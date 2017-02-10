
package pasianssi.pasianssi;

import java.util.ArrayList;

/**
 * Luokka rakentaa pinot joissa kortit on pelialustalla
 *
 * @author Harri
 */
public class Pino {

    private ArrayList<Kortti> pino;

    public Pino() {
        this.pino = new ArrayList<>();
    }

    /*
    * lisätään kortti pinoon
     */
    public void lisaaPinoon(Kortti k) {
        pino.add(k);
    }

    /*
    * Poistaa tietyn kortin pinosta
     */
    public void poistaTiettyKortti(Kortti k) {
        pino.remove(k);
    }

    /*
    * Antaa kortin pinosta indeksin mukaan
     */
    public Kortti getKorttiPinosta(int i) {
        Kortti kortti = pino.get(i);
        return kortti;
    }

    /*
    * Ottaa kortin tietyn indeksin kohdalta pinosta
     */
    public Kortti otaKorttiPinosta(int i) {
        Kortti kortti = pino.get(i);
        poistaTiettyKortti(kortti);
        return kortti;
    }

    /*
    * Poistaa tietyn kortin pinosta ja sen alapuolella olevat kortit
     */
    public void poistaKorttiSarja(Kortti k) {
        int indeksi = pino.indexOf(k);
        while (indeksi != pino.size()) {

            pino.remove(pino.size() - 1);

        }
    }

    /*
    * Palauttaa pinon koon
     */
    public int pinonKoko() {
        return pino.size();
    }

    public String toString() {

        for (int i = 0; i < pino.size(); i++) {
            System.out.println(pino.get(i) + " ");
        }

        return "";
    }

    /*
    * Tarkistaa onko pino tyhjä
     */
    public boolean onkoTyhja() {
        return pino.isEmpty();
    }
}
