package pasianssi.logiikka;

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
     */
    public PeliAlusta() {
        alaPinot = new Pino[7];
        for (int i = 0; i < alaPinot.length; i++) {
            alaPinot[i] = new Pino();
        }
        ylaPinot = new Pino[4];
        for (int i = 0; i < ylaPinot.length; i++) {
            ylaPinot[i] = new Pino();
        }
        kaantoPakka = new Pino();
        kaannettavaPakka = new Pino();
        pakka = new Pakka();
        pakka.luoPakka();

    }

    /**
     * Jakaa kortit pelin alkuun.
     */
    public void jaaKortit() {
        int a = 7;
        int b = 0;
        for (int i = 0; i < 7; i++) {
            while (b < a) {
                alaPinot[i].lisaaPinoon(pakka.otaKortti(b));
                b++;
            }
            a--;
            b = 0;
        }

        while (!pakka.onkoTyhja()) {
            kaannettavaPakka.lisaaPinoon(pakka.otaKortti(pakka.pakanKoko() - 1));
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
     * Ottaa kortin kääntöpakasta ja siirtää sen käännettyyn pakkaan Mikäli
     * kortit loppuu kääntöpakasta niin kortit siirretään takaisin sinne.
     */
    public void otaKorttiPakasta() {
        if (!kaannettavaPakka.onkoTyhja()) {
            int i = kaannettavaPakka.pinonKoko() - 1;
            kaantoPakka.lisaaPinoon(kaannettavaPakka.otaKorttiPinosta(i));
            kaantoPakka.getKorttiPinosta(kaantoPakka.pinonYlinIndeksi()).kaannaKortti();
        } else {
            while (!kaantoPakka.onkoTyhja()) {
                kaannettavaPakka.lisaaPinoon(kaantoPakka.otaKorttiPinosta(kaantoPakka.pinonKoko() - 1));
            }
        }

    }

    /**
     * Siirtää kortin pinosta toiseen.
     *
     * @param valittu mistä kortti otetaan
     * @param mista minne kortti laitetaan
     */
    public void siirraKorttiYlaPinoon(Pino valittu, Pino mista) {

        Kortti valittuKortti = valittu.getKorttiPinosta(valittu.pinonYlinIndeksi());
        if (mista.pinonKoko() == 0 && valittuKortti.getKortinArvo() == 1) {
            valittu.poistaTiettyKortti(valittuKortti);
            mista.lisaaPinoon(valittuKortti);
        } else if (!mista.onkoTyhja() && mista.getKorttiPinosta(mista.pinonYlinIndeksi()).getKortinArvo() == valittuKortti.getKortinArvo() - 1
                && mista.getKorttiPinosta(mista.pinonYlinIndeksi()).getMaanArvo() == valittuKortti.getMaanArvo()) {
            valittu.poistaTiettyKortti(valittuKortti);
            mista.lisaaPinoon(valittuKortti);
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
                minne.lisaaPinoon(siirrettava);
            }
            valittu.poistaKorttiSarja(valittuKortti);
        } else if (!minne.onkoTyhja() && minne.getKorttiPinosta(minne.pinonYlinIndeksi()).getKortinArvo() == valittuKortti.getKortinArvo() + 1
                && minne.getKorttiPinosta(minne.pinonYlinIndeksi()).onkoPunainen() != valittuKortti.onkoPunainen()) {
            for (int i = valittu.pinonKoko() - montako; i < valittu.pinonKoko(); i++) {
                Kortti siirrettava = valittu.getKorttiPinosta(i);
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
