/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.pasianssi;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Harri
 */
public class Pakka {

    private ArrayList<Kortti> pakka;

    public Pakka() {
        this.pakka = new ArrayList<>(52);
    }

    public final void luoPakka() {
        if (onkoTyhja()) {
            for (int i = 1; i <= 52;) {
                pakka.add(new Kortti(i));
                i++;
            }

        }

    }

    public void sekoitaPakka() {
        Collections.shuffle(pakka);
    }

    public boolean onkoTyhja() {
        return pakka.isEmpty();
    }

    public int pakanKoko() {
        return pakka.size();
    }

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

    public Kortti otaKortti(int index) {
        Kortti sailytys = pakka.get(index);
        pakka.remove(index);
        return sailytys;
    }

}
