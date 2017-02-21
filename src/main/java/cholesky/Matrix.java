package main.java.cholesky;

/**
 * Created by phillip.goellner on 21.02.2017.
 */

class Matrix {

    private int zeilen;
    private int spalten;

    private double[][] feld;

    public Matrix(String dateiname) {
    }

    public Matrix(int zeilen, int spalten) {
        this.zeilen = zeilen;
        this.spalten = spalten;
    }

    public void setElement(int zeile, int spalte, double wert) {
        feld[zeile][spalte] = wert;
    }

    public double getElement(int zeile, int spalte) {
        return feld[zeile][spalte];
    }

    public double[] zeile(int _zeile) {
        return null;
    }

    public double[] spalte(int _spalte) {
        return null;
    }

    public int hoehe() {
        return zeilen;
    }

    public int breite() {
        return spalten;
    }

    public String toString() {
        return "";
    }

    public void toFile(String dateiname) {
    }

    public Matrix transponiere() {
        return this;
    }
}
