/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.pasianssi;

import java.io.IOException;
import pasianssi.logiikka.Pakka;
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
public class PakkaTest {

    public PakkaTest() {
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
    public void luodaankoPakka() throws IOException {
        Pakka pakka = new Pakka();
        pakka.luoPakka();
        int i = pakka.pakanKoko();
        assertEquals(52, i);
    }

    @Test
    public void eiLuodaUuuttaPakkaa() throws IOException {
        Pakka pakka = new Pakka();
        pakka.luoPakka();
        pakka.luoPakka();
        int i = pakka.pakanKoko();
        assertEquals(52, i);
    }

    @Test
    public void onkoPakkaTyhja() {
        Pakka pakka = new Pakka();
        assertTrue(pakka.onkoTyhja());
    }

    @Test
    public void onkoPakkaEiOleTyhja() throws IOException {
        Pakka pakka = new Pakka();
        pakka.luoPakka();
        assertFalse(pakka.onkoTyhja());
    }

    @Test
    public void kunOttaaKortinPieneneekoPakka() throws IOException {
        Pakka pakka = new Pakka();
        pakka.luoPakka();
        pakka.otaKortti(5);
        assertEquals(51, pakka.pakanKoko());
    }

    @Test
    public void otetaankoOikeaKortti() throws IOException {
        Kortti k = new Kortti(1);
        Pakka pakka = new Pakka();
        pakka.luoPakka();
        Kortti a = pakka.otaKortti(0);
        int i = k.getPakkaArvo();
        int c = a.getPakkaArvo();
        assertEquals(i, c);
    }

    @Test
    public void tulostuukoPakkaOikein() throws IOException {
        Pakka pakka = new Pakka();
        pakka.luoPakka();
        String tulostetaan = pakka.tulostaPakka();

        String haluttuTulostus = "AH 2H 3H 4H 5H 6H 7H 8H 9H 10H JH QH KH \n" +
"AS 2S 3S 4S 5S 6S 7S 8S 9S 10S JS QS KS \n" +
"AD 2D 3D 4D 5D 6D 7D 8D 9D 10D JD QD KD \n" +
"AC 2C 3C 4C 5C 6C 7C 8C 9C 10C JC QC KC \n";
        
        int a = tulostetaan.length();

        assertEquals(haluttuTulostus, tulostetaan);
    }

}
