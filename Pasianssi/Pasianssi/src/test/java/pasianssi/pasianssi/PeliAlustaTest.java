/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.pasianssi;

import logiikka.Pino;
import logiikka.Pakka;
import logiikka.PeliAlusta;
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

}
