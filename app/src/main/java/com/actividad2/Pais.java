package com.actividad2;

public class Pais {
    String contintente;
    String pais;
    String capital;

    @Override
    public String toString() {
        return "Pais{" +
                "contintente='" + contintente + '\'' +
                ", pais='" + pais + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }

    public String getContintente() {
        return contintente;
    }

    public void setContintente(String contintente) {
        this.contintente = contintente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Pais(String contintente, String pais, String capital) {
        this.contintente = contintente;
        this.pais = pais;
        this.capital = capital;
    }
}
