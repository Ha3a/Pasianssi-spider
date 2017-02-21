/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasianssi.gui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import pasianssi.logiikka.Kortti;
import pasianssi.logiikka.PeliAlusta;
import pasianssi.logiikka.Pino;

/**
 *
 * @author Harri
 */
public class Hiirenkuuntelija extends MouseAdapter {

    private Kayttoliittyma ka;
    private int klikkattux;
    private int klikattuy;
    private PeliAlusta pa;
    private Pino pinot;
    private Pino pinat;
    private Pino[] pinoja;
    private Piirtoalusta pial;
    
    private Pino kohde = null;
    
    private Kortti vkortti;
    
    
    
    public Hiirenkuuntelija(Kayttoliittyma ka, Piirtoalusta pa, PeliAlusta pal) {
        this.ka = ka;
        pial = pa;
        this.pa = pal;



        
        
                

        
        
        
    }

    
    /**
     * Tarkista onko klikattu pinon päältä, jos on niin mikä kortti pinosta
     * 
     * 
     * @param e 
     */
    
    
    
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("kek");
        
               
        
        klikkattux = e.getX();
        klikattuy = e.getY();
        System.out.println("" + klikkattux + "x " + klikattuy + "y");
        
        if(vkortti != null){
            
        }
        
        if(410 < klikkattux && klikkattux < 460 && 80 < klikattuy && klikattuy < 130){
            pa.otaKorttiPakasta();
            pial.repaint();
        }else if(360 < klikkattux && klikkattux < 410 && 80 < klikattuy && klikattuy < 130){
            vkortti = pa.valitseKortti();
        }
        
        

        
        
        
        
        
        
//        source = Pino[x];
//        
//        for (Component c : source.getComponents()){
//            
//        }
    }

}
