package pasianssi.logiikka;

import java.io.IOException;

/**
 * Luokka sisältää Pelialustan jonne kortit jaetaan Luokassa on myös pinot
 * joihin kortit jaetaan ja jonne ne tulisi siirtää.
 *
 * @author Harri
 */
public class PeliAlusta {

    private Pino[] alaPinot;
    private Pino[] ylaPinot;
    private Pino kaantoPakka;
    private Pino kaannettavaPakka;
    private Pakka pakka;

    /**
     * Alustaa pelialustan ja luo pinot, kaantopakat, sekä pakan josta kortit
     * jaetaan.
     *
     * @throws java.io.IOException Heittää IOEXceptionin jos kuvaa ei saatavilla
     */
    public PeliAlusta() throws IOException {
        alaPinot = new Pino[7];

        int x = 20;
        int y = 150;

        for (int i = 0; i < alaPinot.length; i++) {
            alaPinot[i] = new Pino(x, y);
            x += 65;
        }
        ylaPinot = new Pino[4];

        x = 20;
        y = 50;

        for (int i = 0; i < ylaPinot.length; i++) {
            ylaPinot[i] = new Pino(x, y);
            x += 65;
        }
        kaantoPakka = new Pino(345, 50);
        kaannettavaPakka = new Pino(410, 50);
        pakka = new Pakka();
        pakka.luoPakka();

    }

    /**
     * Metodi sekoitusta varten.
     */
    public void sekoitaPakka() {
        pakka.sekoitaPakka();
    }

    /**
     * Jakaa kortit pelin alkuun.
     */
    public void jaaKortit() {
        int a = 7;
        int b = 0;

        for (int i = 0; i < 7; i++) {
            int y = alaPinot[0].getPinonY();
            while (b < a) {
                alaPinot[i].lisaaPinoon(pakka.otaKortti(b));
                alaPinot[i].getKorttiPinosta(b).setKortinX(alaPinot[i].getPinonX());
                alaPinot[i].getKorttiPinosta(b).setKortinY(y);

                y += 35;
                b++;
            }
            a--;
            b = 0;
        }

        while (!pakka.onkoTyhja()) {
            kaannettavaPakka.lisaaPinoon(pakka.otaKortti(pakka.pakanKoko() - 1));
            annaPaalimmaiselleKortillePinonXY(kaannettavaPakka);
        }

        for (int i = 0; i < 7; i++) {
            alaPinot[i].getKorttiPinosta(alaPinot[i].pinonYlinIndeksi()).kaannaKortti();
        }

    }

    /**
     * Gettereitä.
     */
    /**
     * Gettereitä.
     *
     * @return alaPinot palauttaa alaPinot pinot
     */
    public Pino[] getAlaPinot() {
        return alaPinot;
    }

    public Pino[] getYlaPinot() {
        return ylaPinot;
    }

    public Pakka getPakka() {
        return pakka;
    }

    public Pino getKaantoPakka() {
        return kaantoPakka;
    }


    public Pino getKaannettavaPakka() {
        return kaannettavaPakka;
    }

    /**
     * Antaa kortille pinon X Y arvot.
     * @param pino Pino jonka X Y arvot annetaan
     */
    public void annaPaalimmaiselleKortillePinonXY(Pino pino) {
        pino.getKorttiPinosta(pino.pinonYlinIndeksi()).setKortinX(pino.getPinonX());
        pino.getKorttiPinosta(pino.pinonYlinIndeksi()).setKortinY(pino.getPinonY());

    }

    /**
     * Ottaa kortin kääntöpakasta ja siirtää sen käännettyyn pakkaan Mikäli
     * kortit loppuu kääntöpakasta niin kortit siirretään takaisin sinne.
     */
    public void otaKorttiPakasta() {
        if (!kaannettavaPakka.onkoTyhja()) {
            int i = kaannettavaPakka.pinonYlinIndeksi();
            kaantoPakka.lisaaPinoon(kaannettavaPakka.otaKorttiPinosta(i));
            kaantoPakka.getKorttiPinosta(kaantoPakka.pinonYlinIndeksi()).kaannaKortti();
            annaPaalimmaiselleKortillePinonXY(kaantoPakka);
        } else {
            while (!kaantoPakka.onkoTyhja()) {
                kaannettavaPakka.lisaaPinoon(kaantoPakka.otaKorttiPinosta(kaantoPakka.pinonKoko() - 1));
                annaPaalimmaiselleKortillePinonXY(kaannettavaPakka);
            }
        }

    }

    /**
     * Siirtää kortin pinosta toiseen.
     *
     * @param mista mistä kortti otetaan
     * @param minne minne kortti laitetaan
     */
    public void siirraKorttiYlaPinoon(Pino mista, Pino minne) {

        Kortti valittuKortti = mista.getKorttiPinosta(mista.pinonYlinIndeksi());
        if (minne.pinonKoko() == 0 && valittuKortti.getKortinArvo() == 1) {
            mista.poistaTiettyKortti(valittuKortti);
            minne.lisaaPinoon(valittuKortti);
            annaPaalimmaiselleKortillePinonXY(minne);
        } else if (!minne.onkoTyhja() && minne.getKorttiPinosta(minne.pinonYlinIndeksi()).getKortinArvo() == valittuKortti.getKortinArvo() - 1
                && minne.getKorttiPinosta(minne.pinonYlinIndeksi()).getMaanArvo() == valittuKortti.getMaanArvo()) {
            mista.poistaTiettyKortti(valittuKortti);
            minne.lisaaPinoon(valittuKortti);
            annaPaalimmaiselleKortillePinonXY(minne);
        }
    }

    /**
     * Metodi siirtää kortin tai kortteja pinosta pinoon jos siirto on sallittu.
     *
     * @param valittu mista kortti otetaan
     * @param minne minne kortti siirretaan
     * @param montako montako korttia siiretaan
     */
    public void siirraKortteja(Pino valittu, Pino minne, int montako) {

        Kortti valittuKortti = valittu.getKorttiPinosta(valittu.pinonKoko() - montako);
        if (minne.onkoTyhja() && valittuKortti.getKortinArvo() == 13) {
            for (int i = valittu.pinonKoko() - montako; i < valittu.pinonKoko(); i++) {
                Kortti siirrettava = valittu.getKorttiPinosta(i);
                siirrettava.setKortinX(minne.getPinonX());
                siirrettava.setKortinY(minne.getPinonY());
                minne.lisaaPinoon(siirrettava);
            }
            valittu.poistaKorttiSarja(valittuKortti);
        } else if (!minne.onkoTyhja() && minne.getKorttiPinosta(minne.pinonYlinIndeksi()).getKortinArvo() == valittuKortti.getKortinArvo() + 1
                && minne.getKorttiPinosta(minne.pinonYlinIndeksi()).onkoPunainen() != valittuKortti.onkoPunainen()) {
            for (int i = valittu.pinonKoko() - montako; i < valittu.pinonKoko(); i++) {
                Kortti siirrettava = valittu.getKorttiPinosta(i);
                siirrettava.setKortinX(minne.getPinonX());
                siirrettava.setKortinY(minne.getKorttiPinosta(minne.pinonYlinIndeksi()).getKortinY() + 35);
                minne.lisaaPinoon(siirrettava);
            }
            valittu.poistaKorttiSarja(valittuKortti);
        }
    }

    /**
     * Metodi kääntää valitun kortin oikeinpäin mikäli päälimmäinne kortti
     * pinosta on väärinpäin.
     *
     * @param mista mistä kortti käännetään
     */
    public void kannaKorttiOikeinPain(Pino mista) {
        if (!mista.getKorttiPinosta(mista.pinonYlinIndeksi()).onkoKuvaYlos()) {
            mista.getKorttiPinosta(mista.pinonYlinIndeksi()).kaannaKortti();
        }
    }


}
