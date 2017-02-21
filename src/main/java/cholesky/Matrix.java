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
        for(int aktuelleZeile=0;aktuelleZeile<zeilen;aktuelleZeile++){
            for(int aktuelleSpalte=0;aktuelleSpalte<=aktuelleZeile;aktuelleSpalte++){
                if(aktuelleZeile==aktuelleSpalte){
                    setElement(aktuelleZeile,aktuelleSpalte, 1);
                }else{
                    setElement(aktuelleZeile,aktuelleSpalte,0);
                    setElement(aktuelleSpalte,aktuelleZeile,0);
                }
            }
        }
    }

    public void setElement(int zeile, int spalte, double wert) {
        feld[zeile][spalte] = wert;
    }

    public double getElement(int zeile, int spalte) {
        return feld[zeile][spalte];
    }

    public double[] zeile(int _zeile) {
        double[] result = new double[spalten];
        for(int aktuelleSpalte=0;aktuelleSpalte<spalten;aktuelleSpalte++){
            result[aktuelleSpalte]=getElement(_zeile,aktuelleSpalte);
        }
        return result;
    }

    public double[] spalte(int _spalte) {
        double[] result = new double[zeilen];
        for(int aktuelleZeile=0;aktuelleZeile<spalten;aktuelleZeile++){
            result[aktuelleZeile]=getElement(aktuelleZeile,_spalte);
        }
        return result;
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

    public Matrix transponierte() {
        Matrix result=new Matrix(this.zeilen,this.spalten);
        for(int aktuelleZeile=0;aktuelleZeile<zeilen;aktuelleZeile++){
            for(int aktuelleSpalte=0;aktuelleSpalte<spalten;aktuelleSpalte++){
                result.setElement(aktuelleZeile,aktuelleSpalte,feld[aktuelleZeile][aktuelleSpalte]);
                result.setElement(aktuelleSpalte,aktuelleZeile,feld[aktuelleSpalte][aktuelleZeile]);
            }
        }
        return result;
    }
}
