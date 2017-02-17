/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.pasianssi;

import pasianssi.logiikka.Pino;
import pasianssi.logiikka.Pakka;
import pasianssi.logiikka.PeliAlusta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Harri
 */
public class PeliAlustaTest {

    public PeliAlustaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void jaetaankoKortitPakasta() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pakka pakka;
        pakka = pa.getPakka();

        assertEquals(0, pakka.pakanKoko());
    }

    @Test
    public void jaetaankoKortitKaannettavaPakkaan() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino kp;
        kp = pa.getKaannettavaPakka();
        assertEquals(24, kp.pinonKoko());
    }

    @Test
    public void onkoKaantoPakkaTyhjaAlussa() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino kp;
        kp = pa.getKaantoPakka();
        assertEquals(0, kp.pinonKoko());
    }

    @Test
    public void otetaankoKorttiKaannettavastaPakasta() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino kp;
        pa.otaKorttiPakasta();
        kp = pa.getKaannettavaPakka();
        assertEquals(23, kp.pinonKoko());
    }

    @Test
    public void lisaantyykoKorttiKaantoPakkaan() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino kp;
        pa.otaKorttiPakasta();
        kp = pa.getKaantoPakka();
        assertEquals(1, kp.pinonKoko());
    }

    @Test
    public void siirraAssaYlaPinoon() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino apinot[] = pa.getAlaPinot();
        Pino ypinot[] = pa.getYlaPinot();
        pa.siirraKorttiYlaPinoon(apinot[4], ypinot[1]);
        Pino yapinot[] = pa.getYlaPinot();
        assertEquals(1, yapinot[1].pinonKoko());

    }

    @Test
    public void siirraKaksiYlaPinoon() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino apinot[] = pa.getAlaPinot();
        Pino ypinot[] = pa.getYlaPinot();
        pa.siirraKorttiYlaPinoon(apinot[4], ypinot[1]);
        pa.siirraKorttiYlaPinoon(apinot[5], ypinot[1]);
        Pino yapinot[] = pa.getYlaPinot();
        Pino ayPinot[] = pa.getAlaPinot();
        assertEquals(2, yapinot[1].pinonKoko());
        assertEquals(1, ayPinot[5].pinonKoko());

    }

    @Test
    public void PoistuukoKorttiKunsiirraKaksiYlaPinoon() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino apinot[] = pa.getAlaPinot();
        Pino ypinot[] = pa.getYlaPinot();
        pa.siirraKorttiYlaPinoon(apinot[4], ypinot[1]);
        pa.siirraKorttiYlaPinoon(apinot[5], ypinot[1]);
        Pino ayPinot[] = pa.getAlaPinot();
        assertEquals(1, ayPinot[5].pinonKoko());

    }

    @Test
    public void PoistuukoKorttiKunsiirraAssaYlaPinoon() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino apinot[] = pa.getAlaPinot();
        Pino ypinot[] = pa.getYlaPinot();
        pa.siirraKorttiYlaPinoon(apinot[4], ypinot[1]);
        Pino ayPinot[] = pa.getAlaPinot();
        assertEquals(2, ayPinot[4].pinonKoko());

    }

    @Test
    public void SiirtyykoKorttiPinostaToiseenPinoon() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino apinot[] = pa.getAlaPinot();
        pa.siirraKortteja(apinot[3], apinot[0], 1);
        Pino ayPinot[] = pa.getAlaPinot();
        assertEquals(3, ayPinot[3].pinonKoko());

    }

    @Test
    public void SiirtyykoKorttiPinoonToisestaPinosta() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino apinot[] = pa.getAlaPinot();
        pa.siirraKortteja(apinot[3], apinot[0], 1);
        Pino ayPinot[] = pa.getAlaPinot();
        assertEquals(8, ayPinot[0].pinonKoko());

    }

    @Test
    public void SiirtyykoKorttiTyhjaanPinoon() {
        PeliAlusta pa = new PeliAlusta();
        pa.jaaKortit();
        Pino apinot[] = pa.getAlaPinot();
        Pino ypinot[] = pa.getYlaPinot();
        pa.siirraKortteja(apinot[0], ypinot[0], 1);
        Pino ayPinot[] = pa.getYlaPinot();
        assertEquals(1, ayPinot[0].pinonKoko());

    }
}
