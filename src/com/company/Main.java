package com.company;

import KavosAparatas.KavosAparatas;
import KavosServisas.KavosServisas;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int ACTION_0 = 0;
    public static final int ACTION_1 = 1;
    public static final int ACTION_2 = 2;
    public static final int ACTION_3 = 3;
    public static final int ACTION_4 = 4;
    public static final int ACTION_5 = 5;
    public static final int ACTION_6 = 6;
    public static final int ACTION_7 = 7;
    public static final int ACTION_8 = 8;
    public static final int ACTION_9 = 9;
    public static final int ACTION_10 = 10;

    public static final int SERVER_ACTION_11 = 11;
    public static final int SERVER_ACTION_12 = 12;
    public static final int SERVER_ACTION_13 = 13;
    public static final int SERVER_ACTION_14 = 14;
    public static final int SERVER_ACTION_15 = 15;
    public static final int SERVER_ACTION_16 = 16;
    public static final int SERVER_ACTION_17 = 17;
    public static final int SERVER_ACTION_18 = 18;


    public static void main(String[] args) {
        Main obj = new Main();
        obj.run();

    }

    private void rodykMeniu() {
        System.out.println("================Serviso==Veiksmai===================");
        System.out.println(SERVER_ACTION_11 + " - Sukurti n aparatų");
        System.out.println(SERVER_ACTION_12 + " - Pasirinkti su kuriuo aparatu dirbti");
        System.out.println(SERVER_ACTION_13 + " - Išvalyti visus");
        System.out.println(SERVER_ACTION_14 + " - Išvalyti aparatų produktus");
        System.out.println(SERVER_ACTION_15 + " - Patikrinti bendrą produktą");
        System.out.println(SERVER_ACTION_16 + " - Patikrinti skirtingus produktus");
        System.out.println(SERVER_ACTION_17 + " - Failo skaitymas");
        System.out.println(SERVER_ACTION_18 + " - Išsaugoti aparatus");
        System.out.println("================Aparato==Veiksmai====================");
        System.out.println(ACTION_1 + " - Padaryk Juoda kava");
        System.out.println(ACTION_2 + " - Padaryk Latte");
        System.out.println(ACTION_3 + " - Padaryk Espresso");
        System.out.println(ACTION_4 + " - Plauk aparata");
        System.out.println(ACTION_5 + " - Papildyk vandeni");
        System.out.println(ACTION_6 + " - Papildyk cukru");
        System.out.println(ACTION_7 + " - Papildyk kava");
        System.out.println(ACTION_8 + " - Parodyk ar pasiruoses");
        System.out.println(ACTION_9 + " - Parodyk produktu busena");
        System.out.println(ACTION_10 + " - Parodyk aparato busena");
        System.out.println(ACTION_0 + " - Baigti darba");
        System.out.println("==================================================");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        KavosServisas servisas = new KavosServisas();
        int kurisAparatas = -1;
        int AparatuKiekis = -1;
        ArrayList<KavosAparatas> sarasas= null;
        while (arTesti) {
            rodykMeniu();
            int veiksmas = sc.nextInt();
            switch (veiksmas) {
                case SERVER_ACTION_11:
                    System.out.println("Įveskite aparatų kiekį :");
                    AparatuKiekis = sc.nextInt();
                    sarasas = servisas.SukurkNApratu(AparatuKiekis);
                    break;
                case SERVER_ACTION_12:
                    System.out.println("Pasirink su kuriuo paratu dirbti :");
                    kurisAparatas = sc.nextInt();
                    break;
                case SERVER_ACTION_13:
                    servisas.IsplaukVisus(sarasas);
                    break;
                case SERVER_ACTION_14:
                    servisas.IsvalykAparatuProduktus(sarasas);
                    break;
                case SERVER_ACTION_15:
                    servisas.PriskirkBendraSaltiny(sarasas);
                    break;
                case SERVER_ACTION_16:
                    servisas.PriskirkSaltiny(sarasas);
                    break;
                case SERVER_ACTION_17:
                    sarasas = servisas.skaitymasIsFailo();
                    break;
                case SERVER_ACTION_18:
                    servisas.issaugotiAparatus(sarasas);
                    break;
                case ACTION_0:
                    arTesti = false;
                    break;
                case ACTION_1:
                    sarasas.get(kurisAparatas).gaminkKava(KavosAparatas.KAVA_JUODA);
                    break;
                case ACTION_2:
                    sarasas.get(kurisAparatas).gaminkKava(KavosAparatas.KAVA_LATTE);
                    break;
                case ACTION_3:
                    sarasas.get(kurisAparatas).gaminkKava(KavosAparatas.KAVA_ESPRESSO);
                    break;
                case ACTION_4:
                    sarasas.get(kurisAparatas).plauti();
                    break;
                case ACTION_5:
                    sarasas.get(kurisAparatas).papildykVandeni();
                    break;
                case ACTION_6:
                    sarasas.get(kurisAparatas).papildykCukru();
                    break;
                case ACTION_7:
                    sarasas.get(kurisAparatas).papildykKava();
                    break;
                case ACTION_8:

                    break;
                case ACTION_9:
                    sarasas.get(kurisAparatas).parodykProduktuBusena();
                    break;
                case ACTION_10:
                    sarasas.get(kurisAparatas).parodykAparatoBusena();
                    break;

            }
        }

    }
}