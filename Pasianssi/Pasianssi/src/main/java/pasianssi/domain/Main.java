package pasianssi.domain;

import java.io.IOException;
import pasianssi.gui.Kayttoliittyma;
import pasianssi.gui.Piirtoalusta;
import pasianssi.logiikka.Pakka;
import pasianssi.logiikka.PeliAlusta;
import pasianssi.logiikka.Pino;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Luokka josta ohjelma ajetaan.
 * Tällä hetkellä testi käytössä.
 * @author Harri
 */
public class Main {


    /**
     * Mainin ja troubleshoottaamisen alku.
     * @param args args
     * @throws java.io.IOException voi heittää IOExceptionin
     */
    public static void main(String[] args) throws IOException {  //testi.


        PeliAlusta peli = new PeliAlusta();
        peli.sekoitaPakka();
        peli.jaaKortit();
        
        
        Kayttoliittyma pa = new Kayttoliittyma(peli);
        
        pa.run();
        
        
        
    }
}
