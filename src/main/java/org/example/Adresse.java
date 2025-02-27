package org.example;

import java.util.Objects;

public class Adresse {

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;
    private String land;

    public Adresse() {
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(strasse, adresse.strasse) && Objects.equals(hausnummer, adresse.hausnummer) && Objects.equals(plz, adresse.plz) && Objects.equals(ort, adresse.ort) && Objects.equals(land, adresse.land);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strasse, hausnummer, plz, ort, land);
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "strasse='" + strasse + '\'' +
                ", hausnummer='" + hausnummer + '\'' +
                ", plz='" + plz + '\'' +
                ", ort='" + ort + '\'' +
                ", land='" + land + '\'' +
                '}';
    }
}
