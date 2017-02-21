package main.java.cholesky;

/**
 * Created by phillip.goellner on 21.02.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Matrix matrix = new Matrix("src/main/resources/output.txt");
        System.out.print(matrix);
    }
}
