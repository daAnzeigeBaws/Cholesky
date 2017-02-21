package main.java.cholesky;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by phillip.goellner on 21.02.2017.
 */

class Matrix {

    private int zeilen;
    private int spalten;

    private double[][] feld;
  
    public Matrix(String dateiname) throws IOException {
        LinkedList<Double> values = new LinkedList();
        List<String> ss = Files.readAllLines(Paths.get(dateiname));

        String[] _tokens = ss.get(0).split(" ");
        zeilen = Integer.parseInt(_tokens[0]);
        spalten = Integer.parseInt(_tokens[1]);

        feld = new double[zeilen][spalten];

        Files.readAllLines(Paths.get(dateiname)).subList(1, ss.size()).forEach(line -> {
            String[] tokens = line.split(" ");
            for (String value : tokens) {
                values.add(Double.parseDouble(value));
            }
        });

        for (int i = 0; i < feld[0].length; i++) {
            for (int j = 0; j < feld.length; j++) {
                feld[j][i] = values.pop();
            }
        }
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < feld[0].length; i++) {
            for (int j = 0; j < feld.length - 1; j++) {
                sb.append(feld[j][i]).append(' ');
            }
            sb.append(feld[feld.length - 1][i]).append('\n');
        }
        return sb.toString();
    }

    public void toFile(String dateiname) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(zeilen).append(' ').append(spalten).append('\n');
        sb.append(this.toString());
        sb.deleteCharAt(sb.length() - 1);

        Files.write(Paths.get(dateiname), sb.toString().getBytes());
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
