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

    public void luoPakka() {
        if (onkoTyhja()) {
            pakka.add(new Kortti(1));
            for (int i = 1; i <= 52; i++) {
                pakka.add(new Kortti(i));
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
        String kortit;
        for (int i = 1; i <= 52; i++) {
            System.out.print(pakka.get(i) + " ");
            if (i % 13 == 0) {
                System.out.println("");
            }
        }
        return "";
    }

}
