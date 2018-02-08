package Produktai;

public class produktai {
    private float cukrausKiekis = 0;    // gramais
    private float kavosKiekis = 0;      // gramais
    private float vandensKiekis = 0;    // mililitrais

    public produktai(float cukrus, float kava, float vanduo) {
        this.cukrausKiekis = cukrus;
        this.kavosKiekis = kava;
        this.vandensKiekis = vanduo;

    }


    public float getCukrausKiekis() {
        return cukrausKiekis;
    }

    public void setCukrausKiekis(float cukrausKiekis) {
        this.cukrausKiekis = cukrausKiekis;
    }

    public float getKavosKiekis() {
        return kavosKiekis;
    }

    public void setKavosKiekis(float kavosKiekis) {
        this.kavosKiekis = kavosKiekis;
    }

    public float getVandensKiekis() {
        return vandensKiekis;
    }

    public void setVandensKiekis(float vandensKiekis) {
        this.vandensKiekis = vandensKiekis;
    }


    public produktai clone(produktai orginalas) {
        produktai clonas = new produktai(orginalas.getCukrausKiekis(), orginalas.getKavosKiekis(), orginalas.getVandensKiekis());
        return clonas;

    }


}
