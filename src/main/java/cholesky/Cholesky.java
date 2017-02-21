package main.java.cholesky;

/**
 * Created by phillip.goellner on 21.02.2017.
 */
class Cholesky {
    private Matrix calculateCholeskyMatrix(Matrix A){
        if(A.breite()!=A.hoehe()){
            throw new CholeskyException();
        }

        Matrix result = new Matrix(A.hoehe(),A.breite());

        for(int currentLine=0;currentLine<A.hoehe();currentLine++){
            for(int currentColumn=0;currentColumn<currentLine;currentColumn++){
                double currentElement=A.getElement(currentLine,currentColumn);
                for(int k=0;k<currentColumn-1;k++){
                    currentElement-=A.getElement(currentLine,k)*A.getElement(currentColumn,k);
                }

                if(currentLine>currentColumn){
                    result.setElement(currentLine,currentColumn,currentElement/A.getElement(currentColumn,currentColumn));
                } else if(currentElement>0){
                    result.setElement(currentLine,currentLine,Math.sqrt(currentElement));
                } else{
                    throw new CholeskyException();
                }
            }
        }
        return result;
    }
    public Cholesky() {
    }

    public Matrix loese(Matrix a, Matrix b) {
        return b;
    }
}
