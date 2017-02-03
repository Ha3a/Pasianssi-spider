//package pasianssi.pasianssi;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
///**
// *
// * @author Harri
// */
//public class Main {
//
//    public static void main(String[] args) {
//        Pakka testi = new Pakka();
//        Pino eka = new Pino();
//        System.out.println("" + testi.pakanKoko());
//        testi.luoPakka();
//        System.out.println("" + testi.tulostaPakka());
//        System.out.println("");
//        System.out.println("" + testi.pakanKoko());
////        testi.sekoitaPakka();
//        System.out.println("");
//        System.out.println("" + testi.tulostaPakka());
//        System.out.println("");
//
//        for (int i = 0; i <= testi.pakanKoko();) {
//
//            eka.lisaaPinoon(testi.otaKortti(i));
//            i = i + 5;
//
//        }
//
//        eka.toString();
//
//        System.out.println("");
//
//        System.out.println("" + testi.pakanKoko());
//
//        System.out.println("");
//
//        eka.poistaKorttiSarja(eka.getKorttiPinosta(eka.pinonKoko() - 3));
//
//        eka.toString();
//
//        PeliAlusta alusta = new PeliAlusta();
//
//        alusta.jaaKortit();
//
//        Pino alaPino[] = new Pino[7];
//
//        alaPino = alusta.getAlaPinot();
//
//        Pakka pakka = alusta.getPakka();
//
//        System.out.println("" + pakka.pakanKoko());
//
//        System.out.println("" + pakka.tulostaPakka());
//
//        System.out.println("");
//
//        for (int i = 0; i < 7; i++) {
//            System.out.println("" + alaPino[i].toString());
//        }
//
//        Pakka pt = new Pakka();
//        pt = alusta.getPakka();
//
//        System.out.println("" + pt.pakanKoko());
//        alusta.otaKorttiPakasta();
//
//        Pino ylaPino = new Pino();
//        ylaPino = alusta.getKaantoPakka();
//
//        System.out.println("missa olen");
//
//        System.out.println("" + ylaPino.toString());
//
//        System.out.println("");
//
//        Pino kp = new Pino();
//        kp = alusta.getKaannettavaPakka();
//
//        System.out.println("" + kp.toString());
//
//        for (int i = 0; i < 25; i++) {
//            alusta.otaKorttiPakasta();
//        }
//    }
//}
