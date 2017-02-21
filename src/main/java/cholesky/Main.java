package main.java.cholesky;

/**
 * Created by phillip.goellner on 21.02.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Matrix A = new Matrix("src/main/resources/output.txt");
        Matrix b = new Matrix(4,1);
        b.setElement(0,0,4);
        b.setElement(1,0,-18);
        b.setElement(2,0,12);
        b.setElement(3,0,4);
        //System.out.print(A);
        //System.out.print("___\n");
        //System.out.print(b);
        //System.out.print("___\n");
        Cholesky cholesky = new Cholesky();
        Matrix x=cholesky.loese(A,b);
        System.out.print(x);
    }
}
