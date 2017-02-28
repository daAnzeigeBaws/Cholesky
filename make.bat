@echo off
del cholesky.jar
javac src/cholesky/Cholesky.java src/cholesky/CholeskyException.java src/cholesky/Matrix.java
if errorlevel 1 (
    echo "Javac is not among your Environment Variables!"
    echo "Please insert JAVA_HOME to your Path"
)
cd src
jar -fMc cholesky.jar cholesky/Cholesky.class cholesky/CholeskyException.class cholesky/Matrix.class
del /S *.class
move /Y cholesky.jar ../cholesky.jar