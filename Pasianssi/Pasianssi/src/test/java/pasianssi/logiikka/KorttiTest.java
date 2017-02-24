/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.logiikka;

import java.io.IOException;
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
public class KorttiTest {

    public KorttiTest() {
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
    public void testLuoKortit() throws IOException {
        for (int i = 1; i <= 52; i++) {
            Kortti kortti = new Kortti(i);
        }
    }



    //Antaako getPakkaArvo oikean arvon
    @Test
    public void testGetPakkaArvo() throws IOException {
        Kortti kortti = new Kortti(1);
        int i = kortti.getPakkaArvo();
        assertEquals(1, i);
    }

    //Sama max valuella
    @Test
    public void testGetPakkaArvoMax() throws IOException {
        Kortti kortti = new Kortti(52);
        int i = kortti.getPakkaArvo();
        assertEquals(52, i);
    }

    //Antaako getMaanArvo oikean arvon
    @Test
    public void testGetMaanArvo() throws IOException {
        Kortti kortti = new Kortti(1);
        int i = kortti.getMaanArvo();
        assertEquals(1, i);
    }

    //Sama max valuella
    @Test
    public void testGetMaanArvoMax() throws IOException {
        Kortti kortti = new Kortti(52);
        int i = kortti.getMaanArvo();
        assertEquals(4, i);
    }

    //Antaako getKortinMaanNimi oikean nimen
    @Test
    public void testGetKortinMaanNimi() throws IOException {
        Kortti kortti = new Kortti(1);
        String nimi = kortti.getKortinMaanNimi();
        assertEquals("Hearts", nimi);
    }

    //Sama max valuella
    @Test
    public void testGetKortinMaanNimiMax() throws IOException {
        Kortti kortti = new Kortti(52);
        String nimi = kortti.getKortinMaanNimi();
        assertEquals("Clubs", nimi);
    }

    // Antaako getKortinArvo oikean arvon
    @Test
    public void testGetKortinArvo() throws IOException {
        Kortti kortti = new Kortti(1);
        int i = kortti.getKortinArvo();
        assertEquals(1, i);
    }

    //Sama max valuella
    @Test
    public void testGetKortinArvoMax() throws IOException {
        Kortti kortti = new Kortti(52);
        int i = kortti.getKortinArvo();
        assertEquals(13, i);
    }

    //Antaako getKortinArvonNimi oikean nimen

    /**
     *
     */
    @Test
    public void testGetKortinArvonNimi() throws IOException {
        Kortti kortti = new Kortti(1);
        String nimi = kortti.getKortinArvonNimi();
        assertEquals("Ace", nimi);
    }

    //Tulostaako kortti oikean nimen
    @Test
    public void testGetKortinArvonNimiMax() throws IOException {
        Kortti kortti = new Kortti(52);
        String nimi = kortti.getKortinArvonNimi();
        assertEquals("King", nimi);
    }

    //Muuntuuko pakkaArvo kortinArvoksi oikein
    @Test
    public void testpakkaArvoKortinArvoksi() throws IOException {
        Kortti kortti = new Kortti(52);
        int i = Kortti.pakkaArvoKortinArvoksi(kortti.getPakkaArvo());
        assertEquals(13, i);
    }

    //Toimiiko lyhyt tulostus oikein
    @Test
    public void testToString() throws IOException {
        Kortti kortti = new Kortti(1);
        String nimi = kortti.toString();
        assertEquals("AH", nimi);
    }

    @Test
    public void testToStringNumeroKorti() throws IOException {
        Kortti kortti = new Kortti(10);
        String nimi = kortti.toString();
        assertEquals("10H", nimi);
    }

    @Test
    public void testToStringAatelinen() throws IOException {
        Kortti kortti = new Kortti(13);
        String nimi = kortti.toString();
        assertEquals("KH", nimi);
    }

    //Toimiiko pitkä tulostus oikein
    @Test
    public void testToStringPitka() throws IOException {
        Kortti kortti = new Kortti(1);
        String nimi = kortti.toStringPitka();
        assertEquals("Hearts Ace", nimi);
    }

    //Muuntuuko kortinArvo ja maanArvo pakkaArvoksi oikein
    @Test
    public void testPakkaArvoksi() throws IOException {
        Kortti kortti = new Kortti(52);
        int i = Kortti.pakkaArvoksi(kortti.getKortinArvo(), kortti.getMaanArvo());
        assertEquals(52, i);
    }

    //Muuntuuko pakkaArvo maanArvoksi oikein
    @Test
    public void testPakkaArvoMaanArvoksi() throws IOException {
        Kortti kortti = new Kortti(52);
        int i = Kortti.pakkaArvoMaanArvoksi(kortti.getPakkaArvo());
        assertEquals(4, i);
    }

}
