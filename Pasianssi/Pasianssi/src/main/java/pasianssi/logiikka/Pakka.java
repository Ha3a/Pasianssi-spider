package pasianssi.logiikka;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka rakentaa pakan josta kortit jaetaan peliin.
 *
 * @author Harri
 */
public class Pakka {

    private ArrayList<Kortti> pakka;

    /**
     * Luodaan pakalle ArrayList.
     */
    public Pakka() {
        this.pakka = new ArrayList<>(52);
    }

    /**
     * Metodi luo 52 korttisen pakan jossa on jokaista korttia yksi.
     */
    public final void luoPakka() {
        if (onkoTyhja()) {
            for (int i = 1; i <= 52;) {
                pakka.add(new Kortti(i));
                i++;
            }

        }

    }

    /**
     * Metodi sekoittaa pakan jotta kortit saadaan jaettua peliin aina erilailla.
     */
    public void sekoitaPakka() {
        Collections.shuffle(pakka);
    }

    /**
     * Tarkistaa onko pakka tyhjä.
     *
     * @return palauttaa true jos pakka on tyhjä
     */
    public boolean onkoTyhja() {
        return pakka.isEmpty();
    }

    /**
     * Palauttaa pakan koon.
     *
     * @return pakka.size() pakan koko inttinä
     */
    public int pakanKoko() {
        return pakka.size();
    }

    /**
     * Tulostaa pakan jokaisen kortin.
     *
     * @return tulostaa syötteen korteista
     */
    public String tulostaPakka() {
        String tulosta = "";
        for (int i = 0; i < pakka.size(); i++) {
            tulosta = tulosta + pakka.get(i) + " ";
            if ((i + 1) % 13 == 0) {
                tulosta = tulosta + "\n";
            }
        }

        return tulosta;
    }

    /**
     * Ottaa pakasta kortin ja poistaa sen pakasta.
     *
     * @param index otettavan kortin indexi
     * @return palauttaa otetun kortin
     */
    public Kortti otaKortti(int index) {
        Kortti sailytys = pakka.get(index);
        pakka.remove(index);
        return sailytys;
    }

}
