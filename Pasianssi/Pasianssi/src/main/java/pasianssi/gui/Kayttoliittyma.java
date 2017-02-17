/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import pasianssi.logiikka.PeliAlusta;

/**
 * Luokka rakentaa käyttöliittymän josta peliä pelataan.
 *
 * @author Harri
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private PeliAlusta peliAlusta;
    private Piirtoalusta palusta;

    /**
     * Käyttöliittymän konstruktori jossa luodaan PeliAlusta ilmentymä.
     *
     * @param peliAlusta annetaan peliAlusta
     */
    public Kayttoliittyma(PeliAlusta peliAlusta) {
        this.peliAlusta = peliAlusta;

    }

    /**
     * Lisää komponentit säiliöön josta ne piirretään.
     *
     * @param container container piirtämisen säilöntään
     */
    public void luoKomponentit(Container container) {
        palusta = new Piirtoalusta(peliAlusta);

        container.add(palusta);

    }

    /*
    * Piirtää peli näytölle
     */
    @Override
    public void run() {
        frame = new JFrame("Pasianssi");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

}
