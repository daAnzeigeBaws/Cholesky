package cholesky;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by phillip.goellner on 21.02.2017.
 */

public class Matrix {

    private int zeilen;
    private int spalten;

    private double[][] feld;

    public Matrix(String dateiname) {
        try {
            LinkedList<Double> values = new LinkedList<>();
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

            for (int i = 0; i < zeilen; i++) {
                for (int j = 0; j < spalten; j++) {
                    feld[i][j] = values.pop();
                }
            }
        } catch (IOException e) {
            throw new CholeskyException("Fehler beim Einlesen!");
        }
    }

    public Matrix(int zeilen, int spalten) {
        this.zeilen = zeilen;
        this.spalten = spalten;
        feld = new double[zeilen][spalten];
    }

    public void setElement(int zeile, int spalte, double wert) {
        feld[zeile-1][spalte-1] = wert;
    }

    public double getElement(int zeile, int spalte) {
        return feld[zeile-1][spalte-1];
    }

    public double[] zeile(int _zeile) {
        double[] result = new double[spalten];
        for (int aktuelleSpalte = 0; aktuelleSpalte < spalten; aktuelleSpalte++) {
            result[aktuelleSpalte] = getElement(_zeile, aktuelleSpalte+1);
        }
        return result;
    }

    public double[] spalte(int _spalte) {
        double[] result = new double[zeilen];
        for (int aktuelleZeile = 0; aktuelleZeile < spalten; aktuelleZeile++) {
            result[aktuelleZeile] = getElement(aktuelleZeile+1, _spalte);
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
        for (int i = 1; i <= zeilen; i++) {
            for (int j = 1; j < spalten ; j++) {
                sb.append(getElement(i,j)).append(' ');
            }
            sb.append(getElement(i, spalten )).append('\n');
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
        Matrix result = new Matrix(this.spalten, this.zeilen);
        for (int aktuelleZeile = 1; aktuelleZeile <= zeilen; aktuelleZeile++) {
            for (int aktuelleSpalte = 1; aktuelleSpalte <= spalten; aktuelleSpalte++) {
                result.setElement(aktuelleSpalte, aktuelleZeile, getElement(aktuelleZeile, aktuelleSpalte));
            }
        }
        return result;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Matrix)) {
            return false;
        }
        Matrix compareWith = (Matrix) o;
        if (compareWith.hoehe() != this.hoehe() || this.breite() > 1 || compareWith.breite() > 1) {
            return false;
        }

        double result = 0;

        for (int line = 0; line < this.hoehe(); line++) {
            result += Math.pow(this.getElement(line, 0) - compareWith.getElement(line, 0), 2);
        }

        result = Math.sqrt(result);
        if (result <= 0.0001) {
            return true;
        }
        return false;


    }
}