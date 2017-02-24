/**
 * Pakkauksessa pasianssi.pasianssi
 */
package pasianssi.logiikka;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Kortti luokka yksittäiselle kortille.
 *
 * @author Harri
 */
public class Kortti {

    private int kortinX;
    private int kortinY;

    private BufferedImage kortinKuva;

    /**
     * Maa idt. HERTTA on 1, PATA 2, RUUTU 3, RISTI 4.
     */
    public static final int HERTTA = 1;
    public static final int PATA = 2;
    public static final int RUUTU = 3;
    public static final int RISTI = 4;

    /**
     * Maitten nimet.
     */
    private final String[] maittenNimet = new String[]{
        "Hearts", "Spades", "Diamond", "Clubs"
    };

    /**
     * Mikä kortti on minkäkin niminen.
     */
    public static final int ASSA = 1;
    public static final int JATKA = 11;
    public static final int KUNIGATAR = 12;
    public static final int KUNINGAS = 13;

    /**
     * Korttien nimet.
     */
    private final String[] korttienNimet = new String[]{
        "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
        "10", "Jack", "Queen", "King"
    };

    /**
     * 1-13 hertta 14-26 pata 27-39 ruutu 40-52 risti.
     */
    private final int pakkaArvo; // 1-52
    private final int kortinArvo; // 1-13
    private final int maanArvo; // 1-4

    private boolean kuvaPuoliYlos = false;

    /**
     * Käytetty konstruktori.
     *
     * @param uudenKortinPakkaArvo uudenKortinPakkaArvo pakkaID kortille
     * @throws java.io.IOException Heittää IOEXceptionin jos kuvaa ei saatavilla
     */
    public Kortti(final int uudenKortinPakkaArvo) throws IOException {
        if ((uudenKortinPakkaArvo < 1 || uudenKortinPakkaArvo > 52)) {
            throw new IllegalArgumentException("Virheellinen arvo");
        }
        this.pakkaArvo = uudenKortinPakkaArvo;
        this.maanArvo = pakkaArvoMaanArvoksi(uudenKortinPakkaArvo);
        this.kortinArvo = pakkaArvoKortinArvoksi(uudenKortinPakkaArvo);

        InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/" + pakkaArvo + ".png");
        kortinKuva = ImageIO.read(is);

    }

    /*
     *gettereitä.
     */
    public final int getPakkaArvo() {
        return pakkaArvo;
    }

    public final int getMaanArvo() {
        return maanArvo;
    }

    public final String getKortinMaanNimi() {
        return maittenNimet[maanArvo - 1];
    }

    public final int getKortinArvo() {
        return kortinArvo;
    }

    public final String getKortinArvonNimi() {
        return korttienNimet[kortinArvo - 1];
    }

    public int getKortinX() {
        return kortinX;
    }

    public int getKortinY() {
        return kortinY;
    }

    public void setKortinX(int x) {
        kortinX = x;
    }

    public void setKortinY(int y) {
        kortinY = y;
    }

    public BufferedImage getKuva() {
        return kortinKuva;
    }

    /**
     * PakkaArvon muuntaminen kortin arvoksi.
     *
     * @param pakkaArvo kortin id arvo
     * @return palauttaa kortin arvon 1-13
     */
    public static int pakkaArvoKortinArvoksi(final int pakkaArvo) {
        int k = 13;
        int kortinArvo = (pakkaArvo % k);
        if (kortinArvo == 0) {
            kortinArvo = k;
        }

        return kortinArvo;
    }

    /*
     * Kortin tulostus lyhyessä muodossa esimerkiksi ruutu 10 on 10C.
     */
    @Override
    public final String toString() {
        String korttiArvoTekstina;
        if (kortinArvo == 1) {
            korttiArvoTekstina = getKortinArvonNimi().substring(0, 1);
        } else if (kortinArvo <= 10) {
            korttiArvoTekstina = getKortinArvonNimi();
        } else {
            korttiArvoTekstina = getKortinArvonNimi().substring(0, 1);
        }
        String maaLyhyena = getKortinMaanNimi().substring(0, 1);
        String lyhytNimi = korttiArvoTekstina + maaLyhyena;

        return lyhytNimi;

    }

    /**
     * Kortin koko nimen tulostus.
     *
     * @return kortinNimi kortinNimi tekstinä
     */
    public final String toStringPitka() {
        String kortinNimi = getKortinMaanNimi() + " " + getKortinArvonNimi();
        return kortinNimi;
    }

    /**
     * KortinArvon ja maanArvon muuntaminen pakkaArvoksi.
     *
     * @param kortinArvo kortin arvo 1-13
     * @param maanArvo kortin maaID 1-4
     * @return pakkaArvo pakkaArvo pakkaID int
     */
    public static int pakkaArvoksi(final int kortinArvo, final int maanArvo) {
        int pakkaArvo = (13 * (maanArvo - 1)) + kortinArvo;
        return pakkaArvo;
    }

    /**
     * PakkaArvosta muunto maa arvoksi.
     *
     * @param pakkaArvo kortin pakkaID
     * @return palauttaa kortin maaIDn
     */
    public static int pakkaArvoMaanArvoksi(final int pakkaArvo) {
        int maanArvo = pakkaArvo / 13;
        if (pakkaArvo % 13 != 0) {
            maanArvo++;
        }
        return maanArvo;
    }

    /**
     * Tarkistetaan onko kortti musta vai punainen jos puneinen niin palautetaan
     * true.
     *
     * @return false jos ei ole punainen true jos on
     */
    public final boolean onkoPunainen() {
        if (maanArvo == 1 || maanArvo == 3) {
            return true;
        }
        return false;
    }

    /**
     * Muuttaa kortin kuvaPuoliYlos arvoksi true.
     */
    public void kaannaKortti() {
        this.kuvaPuoliYlos = true;
    }

    /**
     * Palauttaa kortin kuvaPuoliYlos arvon.
     *
     * @return true jos kuva ylös false jos kuva alas
     */
    public boolean onkoKuvaYlos() {
        return this.kuvaPuoliYlos;
    }

}
