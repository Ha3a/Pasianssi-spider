package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import pasianssi.pasianssi.Kortti;
import pasianssi.pasianssi.PeliAlusta;
import pasianssi.pasianssi.Pino;

/**
 * Luokka piirtää kortit pöytään, myös paikat joissa ei ole, mutta tulee kortteja
 * @author Harri
 */
public class Piirtoalusta extends JPanel {

    private PeliAlusta ohjain;
    private KuvaHakija kuvaHakija;

    public Piirtoalusta(PeliAlusta peli) {
        this.ohjain = peli;
        this.kuvaHakija = new KuvaHakija();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraKaantoPino(g);
        piirraKaannettyPino(g);
        piirraAlaPinot(g);
        piirraYlaPinot(g);

    }

    /*
    * Piirtää Kääntöpinon
    */
    private void piirraKaantoPino(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fill3DRect(410, 50, 50, 50, true);
    }

    /*
    * Piirtää Kääntöpinosta käännteyt kortit
    */
    private void piirraKaannettyPino(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fill3DRect(345, 50, 50, 50, true);
    }

    
    /*
    * Piirtää pelialustan alapinot ja niiden kortit
    */
    private void piirraAlaPinot(Graphics graphics) {
        int x = 20;
        for (int i = 0; i < 7; i++) {
            graphics.setColor(Color.black);
            graphics.fill3DRect(x, 150, 50, 50, true);
            x = x + 65;
        }
    }

    
    /*
    * Piirtää pelialustan yläpinot jonne korttien tulisi siirtyä 
    * jotta peli voitetaan
    */
    public void piirraYlaPinot(Graphics graphics) {
        int x = 20;
        for (int i = 0; i < 4; i++) {
            graphics.setColor(Color.black);
            graphics.fill3DRect(x, 50, 50, 50, true);
            x = x + 65;
        }
    }


}
