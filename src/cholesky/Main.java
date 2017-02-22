package cholesky;

/**
 * Created by lukas on 22.02.2017.
 */
public class Main {
    static private Matrix matr3(int size) {
        Matrix result=new Matrix(size,size);
        for(int i=0;i<size;i++){
            result.setElement(i,i,2);
        }

        for(int i=1;i<size;i++) {
            result.setElement(i, i - 1, -1);
            result.setElement(i - 1, i, -1);
        }
        return result;
    }

    static private Matrix matr3b(int size){
        Matrix result=new Matrix(size,1);
        result.setElement(0,0,0.01);
        result.setElement(size-1,0,0.01);
        return result;
    }

    public static void main(String[] args) throws Exception{
        Cholesky solver=new Cholesky();
        Matrix A=new Matrix("testdata/GS6_A.txt");
        Matrix b=new Matrix("testdata/GS6_b.txt");
        Matrix x=solver.loese(A,b);
        System.out.println(x);
    }
}
