::@echo off
cd src
javac -classpath ../cholesky.jar cholesky/UnitTest.java
java cholesky/UnitTest
::del src/cholesky/UnitTest.class