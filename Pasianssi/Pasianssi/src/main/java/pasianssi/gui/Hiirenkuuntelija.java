/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import pasianssi.logiikka.Kortti;
import pasianssi.logiikka.PeliAlusta;
import pasianssi.logiikka.Pino;

/**
 * Luokka hiiren toimintaa varten.
 *
 * @author Harri
 */
public class Hiirenkuuntelija extends MouseAdapter {

    private Kayttoliittyma ka;
    private int klikattux;
    private int klikattuy;
    private PeliAlusta pa;
    private Pino pinot;
    private Pino pinat;
    private Pino kpakka;
    private Pino[] ypinot;
    private Pino[] pinoja;
    private Piirtoalusta pial;
    int moneskoKortti;

    private Pino kohde = null;

    private Kortti vkortti;

    /**
     * Konstruktori luokalle.
     *
     * @param ka ka on Käyttöliittymän ilmentymä
     * @param pa pa on Piirtoalustan ilmentymä
     * @param pal pal on PeliAlustan ilmentymä
     */
    public Hiirenkuuntelija(Kayttoliittyma ka, Piirtoalusta pa, PeliAlusta pal) {
        this.ka = ka;
        pial = pa;
        this.pa = pal;

    }

    /**
     * Toiminnalisuus kun hiirtä klikataan.
     *
     *
     * @param e e on hiiren klikkaus.
     */
    @Override
    public void mousePressed(MouseEvent e) {

        pial.repaint();

        pinoja = pa.getAlaPinot();
        kpakka = pa.getKaantoPakka();
        ypinot = pa.getYlaPinot();

        klikattux = e.getX();
        klikattuy = e.getY();

        if (pinat != null) {
            mihinPinoonOsutaanNyt();
            if (pinot != null) {
                if (149 < pinot.getPinonY()) {
                    pa.siirraKortteja(pinat, pinot, moneskoKortti);
                    pial.repaint();
                    pinat = null;
                    pinot = null;
                } else if (pinot.getPinonY() < 149) {
                    pa.siirraKorttiYlaPinoon(pinat, pinot);
                    pial.repaint();
                    pinat = null;
                    pinot = null;
                }
            }
        }

        mihinPinoonOsutaan();

        if (pinat != null && !pinat.getKorttiPinosta(pinat.pinonYlinIndeksi()).onkoKuvaYlos()) {
            pinat.getKorttiPinosta(pinat.pinonYlinIndeksi()).kaannaKortti();
            pial.repaint();
        }

        if (410 < klikattux && klikattux < 460 && 80 < klikattuy && klikattuy < 130) {

            pa.otaKorttiPakasta();
            pial.repaint();

        }

    }

    /**
     * Katsotaan osuuko x y kortin x y alueelle.
     *
     * @param k Kortti k on annettu kortti
     * @return Palauttaa true tai false
     */
    public boolean osuukoKorttiin(Kortti k) {

        if ((k.getKortinX() + 9) < klikattux && klikattux <= (k.getKortinX() + 55)
                && (k.getKortinY() + 25) < klikattuy && klikattuy <= (k.getKortinY() + 80)) {
            return true;
        }

        return false;
    }

    /**
     * Testataan osutaanko mihin pinoon klikatessa.
     */
    public void mihinPinoonOsutaan() {
        for (int i = 0; i < 7; i++) {
            if ((pinoja[i].getPinonX()) < klikattux && klikattux <= (pinoja[i].getPinonX() + 55)
                    && (pinoja[i].getPinonY()) < klikattuy) {
                pinat = pinoja[i];
                for (int b = 0; b < 7; b++) {
                    for (int a = pinoja[b].pinonYlinIndeksi(); a >= 0; a--) {
                        Kortti k = pinoja[b].getKorttiPinosta(a);
                        if (osuukoKorttiin(k) && k.onkoKuvaYlos()) {
                            moneskoKortti = (pinat.pinonKoko() - pinat.getKortinIndeks(k));

                            break;
                        }

                    }
                }
                break;
            } else if ((kpakka.getPinonX()) < klikattux && klikattux <= (kpakka.getPinonX() + 55)
                    && (kpakka.getPinonY()) < klikattuy && klikattuy <= (kpakka.getPinonY() + 80)) {
                pinat = kpakka;
                if (!kpakka.onkoTyhja()) {

                    moneskoKortti = 1;

                }
                break;
            } else {
                pinat = null;
            }

        }
    }

    /**
     * Testataan mihin pinoon osutaan seuraavalla klikkauksella.
     */
    public void mihinPinoonOsutaanNyt() {

        if ((kpakka.getPinonX()) < klikattux && klikattux <= (kpakka.getPinonX() + 55)
                && (kpakka.getPinonY()) < klikattuy && klikattuy <= (kpakka.getPinonY() + 80)) {
            pinat = null;
            return;

        }

        for (int i = 0; i < 7; i++) {
            if ((pinoja[i].getPinonX()) < klikattux && klikattux <= (pinoja[i].getPinonX() + 55)
                    && (pinoja[i].getPinonY()) < klikattuy) {
                pinot = pinoja[i];
                break;
            } else {
                pinot = null;
            }
        }
        for (int i = 0; i < 4; i++) {
            if ((ypinot[i].getPinonX()) < klikattux && klikattux <= (ypinot[i].getPinonX() + 55)
                    && (pinoja[i].getPinonY()) > klikattuy) {
                pinot = ypinot[i];
                pa.siirraKorttiYlaPinoon(pinat, pinot);
                break;

            }
        }
    }

}
