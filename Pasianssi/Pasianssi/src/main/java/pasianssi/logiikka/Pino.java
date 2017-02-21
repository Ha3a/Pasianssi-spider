package pasianssi.logiikka;

import java.util.ArrayList;

/**
 * Luokka rakentaa pinot joissa kortit on pelialustalla.
 *
 * @author Harri
 */
public class Pino {

    private ArrayList<Kortti> pino;
    private int pinonX;
    private int pinonY;
    
    
    /**
     * Luodaan ArrayList.
     */
    public Pino(int x, int y) {
        this.pino = new ArrayList<>();
        pinonX = x;
        pinonY = y;
    }

    
    
    public int getPinonX(){
        return pinonX;
    }
    
    public int getPinonY(){
        return pinonY;
    }
    
    
    /**
     * lisätään kortti pinoon.
     *
     * @param k lisättävä kortti
     */
    public void lisaaPinoon(Kortti k) {
        pino.add(k);
        
    }

    /**
     * Poistaa tietyn kortin pinosta.
     *
     * @param k poistettava kortti
     */
    public void poistaTiettyKortti(Kortti k) {
        pino.remove(k);
    }

    /**
     * Antaa kortin pinosta indeksin mukaan.
     *
     * @param i kortin indeksi
     * @return indeksin kortti
     */
    public Kortti getKorttiPinosta(int i) {
        Kortti kortti = pino.get(i);
        return kortti;
    }

    /**
     * Ottaa kortin tietyn indeksin kohdalta pinosta ja poistaa sen.
     *
     * @param i kortin indeksi
     * @return indeksin kortti
     */
    public Kortti otaKorttiPinosta(int i) {
        Kortti kortti = pino.get(i);
        poistaTiettyKortti(kortti);
        return kortti;
    }

    /**
     * Poistaa tietyn kortin pinosta ja sen alapuolella olevat kortit.
     *
     * @param k Kortti jonka alta poistetaan kortit
     */
    public void poistaKorttiSarja(Kortti k) {
        int indeksi = pino.indexOf(k);
        while (indeksi != pino.size()) {

            pino.remove(pino.size() - 1);

        }
    }

    /**
     * Palauttaa pinon koon.
     *
     * @return pinon koko inttinä
     */
    public int pinonKoko() {
        return pino.size();
    }

    /**
     * palauttaa pinon ylimmän kortin indeksin.
     *
     * @return ylimmän kortin indeksi inttinä
     */
    public int pinonYlinIndeksi() {
        return (pino.size() - 1);
    }

    /**
     * Tulostaa pinon kortit.
     *
     * @return tuloste korteista
     */
    public String toString() {

        for (int i = 0; i < pino.size(); i++) {
            System.out.println(pino.get(i) + " ");
        }

        return "";
    }

    /**
     * Tarkistaa onko pino tyhjä.
     *
     * @return true jos tyhjä
     */
    public boolean onkoTyhja() {
        return pino.isEmpty();
    }
}
