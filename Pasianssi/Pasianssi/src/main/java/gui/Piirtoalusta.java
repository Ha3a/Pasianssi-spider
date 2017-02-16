package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logiikka.Kortti;
import logiikka.PeliAlusta;
import logiikka.Pino;

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
        try {
            piirraAlaPinot(g);
        } catch (IOException ex) {
            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
        }
        piirraYlaPinot(g);
        try {
            piirraKortti(g);
        } catch (IOException ex) {
            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            piirraKortteja(g);
//        } catch (IOException ex) {
//            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
//    private void piirraAlaPinot(Graphics graphics) {
//        int x = 20;
//        for (int i = 0; i < 7; i++) {
//            graphics.setColor(Color.black);
//            graphics.fill3DRect(x, 150, 50, 50, true);
//            x = x + 65;
//        }
//    }

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

    public void piirraKortti(Graphics g) throws IOException {

        InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/1.png");
        BufferedImage bf = ImageIO.read(is);
        g.drawImage(bf, 345, 50, 50, 50, this);
    }

//    public void piirraKortteja(Graphics g) throws IOException {
//
//        Pino pinot[] = ohjain.getAlaPinot();
//        int x = 20;
//
//        for (int a = 0; a < 7; a++) {
//            if (pinot[a].getKorttiPinosta(pinot[a].pinonYlinIndeksi()).onkoKuvaYlos()) {
//                InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/" + pinot[a].getKorttiPinosta(pinot[a].pinonKoko() - 1).getPakkaArvo() + ".png");
//                BufferedImage bf = ImageIO.read(is);
//                g.drawImage(bf, x, 150, 50, 50, this);
//                x = x + 65;
//            }
//        }
//
//    }

    public void piirraPino(Graphics g, Pino a, int x, int y) throws IOException {
        for (int i = 0; i < a.pinonKoko(); i++) {
            if (a.getKorttiPinosta(i).onkoKuvaYlos()) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/" + a.getKorttiPinosta(i).getPakkaArvo() + ".png");
                BufferedImage bf = ImageIO.read(is);
                g.drawImage(bf, x, y, 50, 50, this);
            } else {
                InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/korttitausta.png");
                BufferedImage bf = ImageIO.read(is);
                g.drawImage(bf, x, y, 50, 50, this);
            }

            y = y + 35;

        }
    }

    public void piirraAlaPinot(Graphics g) throws IOException {

        Pino pinot[] = ohjain.getAlaPinot();
        int x = 20;
        int y = 150;

        for (int a = 0; a < 7; a++) {
            piirraPino(g, pinot[a], x, y);
            x = x + 65;
        }
    }

}
