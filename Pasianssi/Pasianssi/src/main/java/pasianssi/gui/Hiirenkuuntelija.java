/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.gui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import pasianssi.logiikka.Kortti;
import pasianssi.logiikka.PeliAlusta;
import pasianssi.logiikka.Pino;

/**
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
    private Pino[] pinoja;
    private Piirtoalusta pial;

    private Pino kohde = null;

    private Kortti vkortti;

    public Hiirenkuuntelija(Kayttoliittyma ka, Piirtoalusta pa, PeliAlusta pal) {
        this.ka = ka;
        pial = pa;
        this.pa = pal;

    }

    /**
     * Tarkista onko klikattu pinon päältä, jos on niin mikä kortti pinosta
     *
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("kek");

        pinoja = pa.getAlaPinot();

        klikattux = e.getX();
        klikattuy = e.getY();
        System.out.println("" + klikattux + "x " + klikattuy + "y");

        mihinPinoonOsutaan();

        if (pinat != null) {
            System.out.println("" + pinat.pinonKoko());
        }

        for (int i = 0; i < 7; i++) {
            for (int a = pinoja[i].pinonYlinIndeksi(); a >= 0; a--) {
                Kortti k = pinoja[i].getKorttiPinosta(a);
                if (osuukoKorttiin(k) && k.onkoKuvaYlos()) {
                    System.out.println("" + k);
                    break;
                }

            }
        }

        if (vkortti != null) {

        }

        if (410 < klikattux && klikattux < 460 && 80 < klikattuy && klikattuy < 130) {
            pa.otaKorttiPakasta();
            pial.repaint();
        } else if (360 < klikattux && klikattux < 410 && 80 < klikattuy && klikattuy < 130) {
            vkortti = pa.valitseKaantoPakanPaalimmainenKortti();
            System.out.println("" + vkortti);
        }

//        source = Pino[x];
//        
//        for (Component c : source.getComponents()){
//            
//        }
    }

    public boolean osuukoKorttiin(Kortti k) {

        if ((k.getKortinX() + 9) < klikattux && klikattux <= (k.getKortinX() + 55)
                && (k.getKortinY() + 25) < klikattuy && klikattuy <= (k.getKortinY() + 80)) {
            return true;
        }

        return false;
    }

    public void mihinPinoonOsutaan() {
        for (int i = 0; i < 7; i++) {
            if ((pinoja[i].getPinonX()) < klikattux && klikattux <= (pinoja[i].getPinonX() + 55)
                    && (pinoja[i].getPinonY()) < klikattuy) {
                pinat = pinoja[i];
                break;
            } else {
                pinat = null;
            }

        }
    }



}

//return (k.getKortinX()) < klikattux && klikattux > k.getKortinX()
//                && (k.getKortinY()) < klikattuy && klikattuy > k.getKortinY();
