package pasianssi.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import pasianssi.logiikka.PeliAlusta;
import pasianssi.logiikka.Pino;

/**
 * Luokka piirtää kortit pöytään, myös paikat joissa ei ole, mutta tulee
 * kortteja.
 *
 * @author Harri
 */
public class Piirtoalusta extends JPanel {

    private PeliAlusta ohjain;

    /**
     * Konstruktorille annetaan paremetriksi PeliAlusta luokan ilmentymä.
     *
     * @param peli tuodaan luokalle peli PeliAlusta
     */
    public Piirtoalusta(PeliAlusta peli) {
        this.ohjain = peli;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            piirraKaantoPino(g);
        } catch (IOException ex) {
            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
        }
        piirraKaannettyPino(g);
        try {
            piirraAlaPinot(g);
        } catch (IOException ex) {
            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
        }
        piirraYlaPinot(g);

        try {
            piirraKortitYlaPinoihin(g);
        } catch (IOException ex) {
            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            piirraKaantoPakka(g);
        } catch (IOException ex) {
            Logger.getLogger(Piirtoalusta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    * Piirtää Kääntöpinon.
     */
    private void piirraKaantoPino(Graphics g) throws IOException {

        InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/korttitausta.png");
        BufferedImage bf = ImageIO.read(is);
        g.drawImage(bf, 410, 50, 50, 50, this);
    }

    /*
    * Piirtää Kääntöpinosta käännteyt kortit.
     */
    private void piirraKaannettyPino(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fill3DRect(345, 50, 50, 50, true);
    }

    /**
     * Piirtää pelialustan yläpinot jonne korttien tulisi siirtyä jotta peli
     * voitetaan.
     *
     * @param graphics graphics olio
     */
    public void piirraYlaPinot(Graphics graphics) {
        int x = 20;
        for (int i = 0; i < 4; i++) {
            graphics.setColor(Color.black);
            graphics.fill3DRect(x, 50, 50, 50, true);
            x = x + 65;
        }
    }

    /**
     * Piirtää yläpinojen päälimmäisen kortin käyttäen piirraPaalimmainenKortti
     * metodia, heittää IOExceptionin jos kuvaa ei löydy.
     *
     * @param g g graphics olio
     * @throws IOException IOException heitetään jos kuvaa ei löydy
     */
    public void piirraKortitYlaPinoihin(Graphics g) throws IOException {
        Pino pinot[] = ohjain.getYlaPinot();
        int x = 20;
        int y = 50;

        for (int a = 0; a < 4; a++) {
            piirraPaalimmainenKortti(g, pinot[a], x, y);
            x = x + 65;
        }
    }

    /**
     * Piirtää Kääntöpakan päälimmäisen kortin piirraPaalimmainenKortti metodin
     * avulla, heittää IOExceptionin jos kuvaa ei löydy.
     *
     * @param g g graphics olio
     * @throws IOException IOException heitetään jos kuvaa ei löydy
     */
    public void piirraKaantoPakka(Graphics g) throws IOException {

        Pino kaanotpakka = ohjain.getKaantoPakka();

        piirraPaalimmainenKortti(g, kaanotpakka, 345, 50);

    }

    /**
     * Piirtää pinon kaikki kortit.
     *
     * @param g g graphics olio
     * @param a Pino joka piirretaan
     * @param x x koordinaatti pinolle
     * @param y y koordinaatti pinolle
     * @throws IOException IOException heitetään jos kuvaa ei löydy
     */
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

    /**
     * Piirtää jokaisen alapinon käyttäen hyväksi piirraPino metodia.
     *
     * @param g g graphics olio
     * @throws IOException IOException heitetään jos kuvaa ei löydy
     */
    public void piirraAlaPinot(Graphics g) throws IOException {

        Pino pinot[] = ohjain.getAlaPinot();
        int x = 20;
        int y = 150;

        for (int a = 0; a < 7; a++) {
            piirraPino(g, pinot[a], x, y);
            x = x + 65;
        }
    }

    /**
     * Piirtää vain pinon päälimmäisen kortin.
     *
     * @param g g graphics olio
     * @param a Pino joka piirretaan
     * @param x x koordinaatti pinolle
     * @param y y koordinaatti pinolle
     * @throws IOException IOException heitetään jos kuvaa ei löydy
     */
    public void piirraPaalimmainenKortti(Graphics g, Pino a, int x, int y) throws IOException {
        if (!a.onkoTyhja() && a.getKorttiPinosta(a.pinonYlinIndeksi()).onkoKuvaYlos()) {
            InputStream is = getClass().getClassLoader().getResourceAsStream("kortit/" + a.getKorttiPinosta(a.pinonYlinIndeksi()).getPakkaArvo() + ".png");
            BufferedImage bf = ImageIO.read(is);
            g.drawImage(bf, x, y, 50, 50, this);
        }

    }

}
