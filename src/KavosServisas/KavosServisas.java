package KavosServisas;

import KavosAparatas.KavosAparatas;
import Produktai.produktai;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KavosServisas {
    private FileReader _in;
    private BufferedReader _bufferis;
    private final String FILE_NAME = "duomenys.txt";

    public KavosAparatas sukurkAparata() {
        KavosAparatas result = new KavosAparatas();
        return result;
    }

    public void IsplaukAparata(KavosAparatas aparatas) {
        aparatas.plauti();
    }

    public ArrayList<KavosAparatas> SukurkNApratu(int n) {
        ArrayList<KavosAparatas> sarasas = new ArrayList<KavosAparatas>();
        for (int i = 0; i < n; i++) {
            sarasas.add(this.sukurkAparata());
        }
        return sarasas;
    }

    public void IsvalykAparatuProduktus(ArrayList<KavosAparatas> sarasas) {
        produktai IsvalykAparatuProduktus = new produktai(0, 0, 0);
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);
            IsvalykAparatuProduktus.setCukrausKiekis(IsvalykAparatuProduktus.getCukrausKiekis() + aparatas.getCukrausKiekis());
            aparatas.setCukrausKiekis(0);
            IsvalykAparatuProduktus.setKavosKiekis(IsvalykAparatuProduktus.getKavosKiekis() + aparatas.getKavosKiekis());
            aparatas.setKavosKiekis(0);
            IsvalykAparatuProduktus.setVandensKiekis(IsvalykAparatuProduktus.getVandensKiekis() + aparatas.getVandensKiekis());
            aparatas.setVandensKiekis(0);

        }
        System.out.println("Isvalem: " + IsvalykAparatuProduktus);

    }

    public void IsplaukVisus(ArrayList<KavosAparatas> sarasas) {
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);
            aparatas.plauti();
        }
    }

    public void PriskirkBendraSaltiny(ArrayList<KavosAparatas> sarasas) {
        produktai bendras = new produktai(0, 0, 0);
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);
            aparatas.setProduktai(bendras);
        }
    }

    public void PriskirkSaltiny(ArrayList<KavosAparatas> sarasas) {
        for (int i = 0; i < sarasas.size(); i++) {
            produktai skirtingas = new produktai(0, 0, 0);
            KavosAparatas aparatas = sarasas.get(i);
            aparatas.setProduktai(skirtingas);
        }
    }

    public ArrayList<KavosAparatas> skaitymasIsFailo() {
        ArrayList<KavosAparatas> sarasas = new ArrayList<KavosAparatas>();
        try {
            Scanner sc = new Scanner(new File("duomenys.txt"));

            while ((sc.hasNextLine())) {
                produktai produktas = new produktai(sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
                KavosAparatas aparatas = this.sukurkAparata();
                aparatas.setProduktai(produktas);
                sarasas.add(aparatas);
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sarasas;
    }

    public void issaugotiAparatus(ArrayList<KavosAparatas> sarasas) {
        try {
            FileWriter writer = new FileWriter("duomenys.txt");
            for (int i = 0; i < sarasas.size(); i++) {
                KavosAparatas aparatas = sarasas.get(i);
                float cukrus;
                float kava;
                float vanduo;
                cukrus = aparatas.getCukrausKiekis();
                kava = aparatas.getKavosKiekis();
                vanduo = aparatas.getVandensKiekis();
                String eilute = cukrus + " " + kava + " " + vanduo + "\n";
                writer.write(eilute);

            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
