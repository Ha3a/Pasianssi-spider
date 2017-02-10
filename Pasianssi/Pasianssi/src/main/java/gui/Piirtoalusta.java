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
 * Luokka piirtää kortit pöytään, myös paikat joissa ei ole, mutta tulee
 * kortteja
 *
 * @author Harri
 */
public class Piirtoalusta extends JPanel {

    private PeliAlusta ohjain;
    private KuvaHakija kuvaHakija;
    Image korttik;

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
        piirraKortti(g);
        piirraKortteja(g);

    }

    /*
    * Piirtää Kääntöpinon
     */
    private void piirraKaantoPino(Graphics g) {
        ImageIcon i = new ImageIcon("src\\main\\resources\\kortit\\korttitausta.png");
        korttik = i.getImage();
        g.drawImage(korttik, 410, 50, 50, 50, this);
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

    public void piirraKortti(Graphics g) {
        ImageIcon i = new ImageIcon("src\\main\\resources\\kortit\\1.png");
        korttik = i.getImage();
        g.drawImage(korttik, 345, 50, 50, 50, this);
    }

    public void piirraKortteja(Graphics g) {

        Pino pinot[] = ohjain.getAlaPinot();
        int x = 20;

        for (int a = 0; a < 7; a++) {
            ImageIcon i = new ImageIcon("src\\main\\resources\\kortit\\" + pinot[a].getKorttiPinosta(pinot[a].pinonKoko() - 1).getPakkaArvo() + ".png");
            korttik = i.getImage();
            g.drawImage(korttik, x, 150, 50, 50, this);
            x = x + 65;
        }

    }

}
