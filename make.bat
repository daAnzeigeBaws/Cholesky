@echo off
del cholesky.jar
javac src/cholesky/*.java
if errorlevel 1 (
    echo "Javac is not among your Environment Variables!"
    echo "Please insert JAVA_HOME to your Path"
)
cd src
jar -fc cholesky.jar cholesky/*.class
del /S *.class
move /Y cholesky.jar ../cholesky.jar