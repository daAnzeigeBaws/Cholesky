package cholesky;

/**
 * Created by lukas on 22.02.2017.
 */
public class Main {

    private static Matrix matr3x(int lines){
        Matrix result = new Matrix(lines,1);
        for(int i=0;i<lines;i++){
            result.setElement(i,0,0.01);
        }
        return result;
    }
    public static void main(String[] args) throws Exception{
        Cholesky solver=new Cholesky();
        Matrix a= new Matrix("testdata/GS1_A.txt");
        Matrix b= new Matrix("testdata/GS1_b.txt");
        Matrix x= solver.loese(a,b);
        System.out.println(x);
    }
}
