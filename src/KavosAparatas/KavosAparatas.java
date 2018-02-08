package KavosAparatas;

import KavosServisas.KavosServisas;
import Produktai.produktai;

public class KavosAparatas extends KavosServisas {
    /* Sukurti kavos aparatą:
     * Kuris turėtų atributus:
     * Cukraus kiekis
     * Kavos pupelių kiekis
     * Vandens kiekis
     * Panaudojimų skaičius
     * Panaudojimų skaičiaus riba – konstanta, kuri saugo, kas kiek panaudojimų reikia atlikti plovimą
     * Kuris mokėtų:
     *   Papildyti vandens/pupelių/cukraus
     *   Gaminti bent trijų rūšių kavą (nustatoma pagal String parametrą ir kuri naudotų skirtingus produktų kiekius),
     *       jeigu trūksta nors vieno produkto 0 atspausdintų atitinkamą pranešimą;
     *       Taip pat atspausditų pranešimą jeigu laikas plovimui
     *   Atlikti plovimą (apnulina panaudojimų skaičių)
     *   Pasakyti ar pasiruošęs (netrūksta produktų ir išsivalęs)
     *   Pasakytų kokia dabar produktų būsena – atspausdintų informaciją
     *   Pasakytų kokia yra aparato būsena (kiek liko produktų ir iki plovimo)
     *   Turėtų keletą konstruktorių
     *   Turėtų set ir get metodus laukams
     */

    private static final int KADA_PLAUTI = 3;
    public static final String KAVA_JUODA = "Juoda";
    public static final String KAVA_LATTE = "Latte";
    public static final String KAVA_ESPRESSO = "Espresso";
    private produktai Produktai;

    private int panaudojimuSkaicius = 0;
    private boolean arPlauti = false;

    public void papildykCukru() {
        setCukrausKiekis(200);
    }

    public void papildykKava() {
        setKavosKiekis(1000);
    }

    public void papildykVandeni() {
        setVandensKiekis(10000);
    }

    public void uzpildykAparata() {
        papildykCukru();
        papildykKava();
        papildykVandeni();
    }

    public float getVandensKiekis() {
        return this.Produktai.getVandensKiekis();
    }

    public void setVandensKiekis(float vandensKiekis) {
        this.Produktai.setVandensKiekis(vandensKiekis);
    }

    public float getKavosKiekis() {
        return this.Produktai.getKavosKiekis();
    }

    public void setKavosKiekis(float kavosKiekis) {
        this.Produktai.setKavosKiekis(kavosKiekis);
    }

    public float getCukrausKiekis() {
        return this.Produktai.getCukrausKiekis();
    }

    public void setCukrausKiekis(float cukrausKiekis) {
        this.Produktai.setCukrausKiekis(cukrausKiekis);
    }

    public void parodykProduktuBusena() {
        System.out.println("\t==================================");
        System.out.println("\tKavos kiekis: " + getKavosKiekis());
        System.out.println("\tCukraus kiekis: " + getCukrausKiekis());
        System.out.println("\tVandens kiekis: " + getVandensKiekis());
        System.out.println("\t==================================");
    }

    public void parodykAparatoBusena() {
        System.out.println("\t###################################");
        System.out.println("\tPanaudojimu kiekis: " + getPanaudojimuSkaicius());
        System.out.println("\tIki plovimo liko: " + getUzKiekPlauti());
        System.out.println("\t###################################");
        parodykProduktuBusena();
    }

    public int getPanaudojimuSkaicius() {
        return panaudojimuSkaicius;
    }

    public int getUzKiekPlauti() {
        //          7               20                      7
        return KADA_PLAUTI - (getPanaudojimuSkaicius() % KADA_PLAUTI);
    }

    public void plauti() {
        arPlauti = false;
    }

    public void gaminkKava(String kavosRusis) {
        switch (kavosRusis) {
            case KAVA_JUODA:
                this.gaminkJuoda();
                break;
            case KAVA_LATTE:
                this.gaminkLatte();
                break;
            case KAVA_ESPRESSO:
                this.gaminkEspresso();
                break;
        }

    }

    private boolean arGaliuGaminti() {
        boolean result = true;

        if (arPlauti) {
            result = false;
            System.out.println("\t REIKIA PLAUTI!");
        }

        if (getVandensKiekis() <= 0) {
            result = false;
            System.out.println("\t REIKIA VANDENS!");
            setVandensKiekis(0);
        }

        if (getCukrausKiekis() <= 0) {
            result = false;
            System.out.println("\t REIKIA CUKRAUS!");
            setCukrausKiekis(0);
        }
        if (getKavosKiekis() <= 0) {
            result = false;
            System.out.println("\t REIKIA KAVOS!");
            setKavosKiekis(0);
        }

        return result;
    }

    private void gaminkJuoda() {
        if (arGaliuGaminti()) {

            arPlauti = getUzKiekPlauti() == 1;
            setVandensKiekis(getVandensKiekis() - 150);
            setCukrausKiekis(getCukrausKiekis() - 10);
            setKavosKiekis(getKavosKiekis() - 30);
            panaudojimuSkaicius++;
            System.out.println("\n" +
                    "\n" +
                    "                        (\n" +
                    "                          )     (\n" +
                    "                   ___...(-------)-....___\n" +
                    "               .-\"\"       )    (          \"\"-.\n" +
                    "         .-'``'|-._             )         _.-|\n" +
                    "        /  .--.|   `\"\"---...........---\"\"`   |\n" +
                    "       /  /    |                             |\n" +
                    "       |  |    |                             |\n" +
                    "        \\  \\   |                             |\n" +
                    "         `\\ `\\ |                             |\n" +
                    "           `\\ `|                             |\n" +
                    "           _/ /\\                             /\n" +
                    "          (__/  \\                           /\n" +
                    "       _..---\"\"` \\                         /`\"\"---.._\n" +
                    "    .-'           \\                       /          '-.\n" +
                    "   :               `-.__             __.-'              :\n" +
                    "   :                  ) \"\"---...---\"\" (                 :\n" +
                    "    '._               `\"--...___...--\"`              _.'\n" +
                    "  jgs \\\"\"--..__                              __..--\"\"/\n" +
                    "       '._     \"\"\"----.....______.....----\"\"\"     _.'\n" +
                    "          `\"\"--..,,_____            _____,,..--\"\"`\n" +
                    "                        `\"\"\"----\"\"\"`");
        }
    }

    private void gaminkLatte() {
        if (arGaliuGaminti()) {

            arPlauti = getUzKiekPlauti() == 1;
            setVandensKiekis(getVandensKiekis() - 200);
            setCukrausKiekis(getCukrausKiekis() - 10);
            setKavosKiekis(getKavosKiekis() - 10);
            panaudojimuSkaicius++;
            System.out.println("         {\n" +
                    "      {   }\n" +
                    "       }_{ __{\n" +
                    "    .-{   }   }-.\n" +
                    "   (   }     {   )\n" +
                    "   |`-.._____..-'|\n" +
                    "   |             ;--.\n" +
                    "   |            (__  \\\n" +
                    "   |             | )  )\n" +
                    "   |             |/  /\n" +
                    "   |             /  /    -Felix Lee-\n" +
                    "   |            (  /\n" +
                    "   \\             y'\n" +
                    "    `-.._____..-'");
        }
    }

    private void gaminkEspresso() {
        if (arGaliuGaminti()) {
            arPlauti = getUzKiekPlauti() == 1;
            setVandensKiekis(getVandensKiekis() - 50);
            setCukrausKiekis(getCukrausKiekis() - 0);
            setKavosKiekis(getKavosKiekis() - 25);
            panaudojimuSkaicius++;
            System.out.println("  .-~~-.\n" +
                    ",|`-__-'|\n" +
                    "||      |\n" +
                    "`|      |  Double Espresso\n" +
                    "  `-__-'");
        }
    }


    public void setProduktai(produktai produktai) {
        Produktai = produktai;
    }
}