/**
 * Pakkauksessa pasianssi.pasianssi
 */
package pasianssi.pasianssi;

/**
 * Kortti luokka yksittäiselle kortille.
 *
 * @author Harri
 */
public class Kortti {

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
        "Ace", "2", "3", "4", "5", "6",
        "7", "8", "9", "10", "Jack",
        "Queen", "King"
    };

    /**
     * 1-13 hertta 14-26 pata 27-39 ruutu 40-52 risti.
     */
    private final int pakkaArvo; // 1-52
    private final int kortinArvo; // 1-13
    private final int maanArvo; // 1-4

    /*
     * Käytetty konstruktori.
     */
    public Kortti(final int uudenKortinPakkaArvo) {
        if ((uudenKortinPakkaArvo < 1 || uudenKortinPakkaArvo > 52)) {
            throw new IllegalArgumentException("Virheellinen arvo");
        }
        this.pakkaArvo = uudenKortinPakkaArvo;
        this.maanArvo = pakkaArvoMaanArvoksi(uudenKortinPakkaArvo);
        this.kortinArvo = pakkaArvoKortinArvoksi(uudenKortinPakkaArvo);

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

    /*
     * PakkaArvon muuntaminen kortin arvoksi.
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

    /*
     * Kortin koko nimen tulostus.
     */
    public final String toStringPitka() {
        String kortinNimi = getKortinMaanNimi() + " " + getKortinArvonNimi();
        return kortinNimi;
    }

    /*
     * KortinArvon ja maanArvon muuntaminen pakkaArvoksi.
     */
    public static int pakkaArvoksi(final int kortinArvo, final int maanArvo) {
//        if (1 > kortinArvo) {
//            throw new IllegalArgumentException("Virheellinen kortin arvo");
//        }
//        if (kortinArvo > 13) {
//            throw new IllegalArgumentException("Virheellinen kortin arvo");
//        }
//        if (maanArvo < 1) {
//            throw new IllegalArgumentException("Virheellinen maan arvo");
//        }
//        if (maanArvo > 4) {
//            throw new IllegalArgumentException("Virheellinen maan arvo");
//        }
        int pakkaArvo = (13 * (maanArvo - 1)) + kortinArvo;
        return pakkaArvo;
    }

    /*
     * PakkaArvosta muunto maa arvoksi.
     */
    public static int pakkaArvoMaanArvoksi(final int pakkaArvo) {
        int maanArvo = pakkaArvo / 13;
        if (pakkaArvo % 13 != 0) {
            maanArvo++;
        }
        return maanArvo;
    }

}
