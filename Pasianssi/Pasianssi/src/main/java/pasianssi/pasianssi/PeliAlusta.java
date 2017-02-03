/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.pasianssi;

/**
 *
 * @author Harri
 */
public class PeliAlusta {

    private Pino[] alaPinot;
    private Pino[] ylaPinot;
    private Pino kaantoPakka;
    private Pino kaannettavaPakka;
    private Pakka pakka;

    public PeliAlusta() {
        alaPinot = new Pino[7];
        for (int i = 0; i < alaPinot.length; i++) {
            alaPinot[i] = new Pino();
        }
        ylaPinot = new Pino[4];
        for (int i = 0; i < ylaPinot.length; i++) {
            alaPinot[i] = new Pino();
        }
        kaantoPakka = new Pino();
        kaannettavaPakka = new Pino();
        pakka = new Pakka();
        pakka.luoPakka();

    }

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
    }

    public Pino[] getAlaPinot() {
        return alaPinot;
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

    public void otaKorttiPakasta() {
        if (!kaannettavaPakka.onkoTyhja()) {
            int i = kaannettavaPakka.pinonKoko() - 1;
            kaantoPakka.lisaaPinoon(kaannettavaPakka.otaKorttiPinosta(i));
        } else {
            while (!kaantoPakka.onkoTyhja()) {
                kaannettavaPakka.lisaaPinoon(kaantoPakka.otaKorttiPinosta(kaantoPakka.pinonKoko() - 1));
            }
        }

    }

}
