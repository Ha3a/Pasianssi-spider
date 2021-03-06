/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.logiikka;

import java.io.IOException;
import pasianssi.logiikka.Pino;
import pasianssi.logiikka.Kortti;
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
public class PinoTest {

    public PinoTest() {
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
    public void lisaytyykoKorttiPinoon() throws IOException {
        Kortti k = new Kortti(1);
        Pino p = new Pino();
        p.lisaaPinoon(k);
        assertEquals(k, p.getKorttiPinosta(0));
    }

    @Test
    public void poistuukoTiettyKorttiPinosta() throws IOException {
        Kortti k = new Kortti(1);
        Pino p = new Pino();
        p.lisaaPinoon(k);
        p.poistaTiettyKortti(k);
        assertEquals(0, p.pinonKoko());
    }

    @Test
    public void poistuukoKorttiSarjaPinosta() throws IOException {
        Pino p = new Pino();
        Kortti k = new Kortti(1);
        p.lisaaPinoon(k);
        p.lisaaPinoon(new Kortti(2));
        p.lisaaPinoon(new Kortti(3));
        p.poistaKorttiSarja(k);
        assertEquals(0, p.pinonKoko());
    }

}
