package com.actividad2;

public class AlmacenarPaises {
    String paises,capitales;

    public AlmacenarPaises(String paises, String capitales) {
        this.paises = paises;
        this.capitales = capitales;
    }

    public String getPaises() {
        return paises;
    }

    public void setPaises(String paises) {
        this.paises = paises;
    }

    public String getCapitales() {
        return capitales;
    }

    public void setCapitales(String capitales) {
        this.capitales = capitales;
    }

    @Override
    public String toString() {
        return "AlmacenarPaises{" +
                "paises='" + paises + '\'' +
                ", capitales='" + capitales + '\'' +
                '}';
    }
}
