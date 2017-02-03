/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.pasianssi;

import java.util.ArrayList;

/**
 *
 * @author Harri
 */
public class Pino {

    private ArrayList<Kortti> pino;

    public Pino() {
        this.pino = new ArrayList<>();
    }

    public void lisaaPinoon(Kortti k) {
        pino.add(k);
    }

    public void poistaTiettyKortti(Kortti k) {
        pino.remove(k);
    }

    public Kortti getKorttiPinosta(int i) {
        Kortti kortti = pino.get(i);
        return kortti;
    }

    public Kortti otaKorttiPinosta(int i) {
        Kortti kortti = pino.get(i);
        poistaTiettyKortti(kortti);
        return kortti;
    }

    public void poistaKorttiSarja(Kortti k) {
        int indeksi = pino.indexOf(k);
        while (indeksi != pino.size()) {

            pino.remove(pino.size() - 1);

        }
    }

    public int pinonKoko() {
        return pino.size();
    }

    public String toString() {

        for (int i = 0; i < pino.size(); i++) {
            System.out.println(pino.get(i) + " ");
        }

        return "";
    }

    public boolean onkoTyhja() {
        return pino.isEmpty();
    }
}
