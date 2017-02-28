package cholesky;

/**
 * Created by phillip.goellner on 21.02.2017.
 */
public class Cholesky {
    private boolean isSymmetrical(Matrix matrix){
        for(int line=2;line<=matrix.hoehe();line++){
            for(int column=1;column<=line;column++){
                if(matrix.getElement(line,column)!=matrix.getElement(column,line)){
                    return false;
                }
            }
        }
        return true;
    }
    private Matrix calculateCholeskyMatrix(Matrix A){
        if(A.breite()!=A.hoehe()){
            throw new CholeskyException("Matrix is not square");
        }
        if(!isSymmetrical(A)){
            throw new CholeskyException("Matrix is not symmetrical!");
        }
        for(int currentLine=1;currentLine<=A.hoehe();currentLine++){
            for(int currentColumn=1;currentColumn<=currentLine;currentColumn++){
                double currentElement=A.getElement(currentLine,currentColumn);
                for(int k=1;k<=currentColumn-1;k++){
                    currentElement-=A.getElement(currentLine,k)*A.getElement(currentColumn,k);
                }
                if(currentLine>currentColumn){
                    A.setElement(currentLine,currentColumn,currentElement/A.getElement(currentColumn,currentColumn));
                } else if(currentElement>0){
                    A.setElement(currentLine,currentLine,Math.sqrt(currentElement));
                } else{
                    throw new CholeskyException("Matrix is not positive definite");
                }
            }
        }
        for(int line=1;line<=A.hoehe();line++){
            for(int column=line+1;column<=A.breite();column++){
                A.setElement(line,column,0);
            }
        }
        return A;
    }

    private Matrix solveForZ(Matrix cholesky, Matrix b){
        Matrix z=new Matrix(b.hoehe(),1);
        z.setElement(1,1,b.getElement(1,1)/cholesky.getElement(1,1));
        for(int line=2;line<=z.hoehe();line++){
            double value=b.getElement(line,1);
            for(int k=1;k<line;k++){
                value-=z.getElement(k,1)*cholesky.getElement(line,k);
            }
            value/= cholesky.getElement(line,line);
            z.setElement(line,1,value);
        }
        return z;
    }

    private Matrix solveForX(Matrix choleskyT, Matrix z){
        Matrix x=new Matrix(z.hoehe(),1);
        x.setElement(x.hoehe(),1,z.getElement(z.hoehe(),1)/choleskyT.getElement(z.hoehe(),z.hoehe()));
        for(int line=x.hoehe();line>0;line--){
            double value = z.getElement(line,1);
            for(int k=x.hoehe();k>line;k--){
                value-=x.getElement(k,1)*choleskyT.getElement(line,k);
            }
            value/=choleskyT.getElement(line,line);
            x.setElement(line,1,value);
        }
        return x;
    }
  
    public Cholesky() {
    }

    public Matrix loese(Matrix A, Matrix b) {
        Matrix cholesky = calculateCholeskyMatrix(A);
        Matrix result= solveForZ(cholesky,b);

        result=solveForX(cholesky.transponierte(),result);
        return result;
    }
}
