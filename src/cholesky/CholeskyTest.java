package cholesky;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by phillip.goellner on 28.02.2017.
 */
public class CholeskyTest {
    @org.junit.Test(expected = CholeskyException.class)
    public void loese() throws Exception {
        Cholesky cholesky = new Cholesky();


        String basePath = "testdata/GS";
        String testingLog = "Testing GS ";
        String expectedLog = "Expected result is: ";
        String yieldLog = "Test yielded result: ";
        String equal = "equal\n";
        String notEqual = "not equal\n";
        String exception = "exception\n";
        String failed = "failed\n";

        StringBuilder testLog = new StringBuilder();

        Matrix a = new Matrix(basePath + "1_A.txt");
        Matrix b = new Matrix(basePath + "1_b.txt");
        Matrix x = new Matrix(basePath + "1_x.txt");

        Matrix calculated_x;

        testLog.append(testingLog)
                .append(1)
                .append('\n')
                .append(expectedLog)
                .append(equal);

        try {
            calculated_x = cholesky.loese(a, b);
            assertEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(equal);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append(2)
                .append('\n')
                .append(expectedLog)
                .append(equal);

        a = new Matrix(basePath + "2_A.txt");
        b = new Matrix(basePath + "2_b.txt");
        x = new Matrix(basePath + "2_x.txt");

        try {
            calculated_x = cholesky.loese(a, b);
            assertEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(equal);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append("3.3")
                .append('\n')
                .append(expectedLog)
                .append(equal);

        a = new Matrix(basePath + "3_A3.txt");
        b = new Matrix(basePath + "3_b3.txt");
        x = new Matrix(basePath + "3_x3.txt");

        try {
            calculated_x = cholesky.loese(a, b);
            assertEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(equal);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append("3.5")
                .append('\n')
                .append(expectedLog)
                .append(equal);

        a = new Matrix(basePath + "3_A5.txt");
        b = new Matrix(basePath + "3_b5.txt");
        x = new Matrix(basePath + "3_x5.txt");

        try {
            calculated_x = cholesky.loese(a, b);
            assertEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(equal);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append("3.10")
                .append('\n')
                .append(expectedLog)
                .append(equal);

        a = new Matrix(basePath + "3_A10.txt");
        b = new Matrix(basePath + "3_b10.txt");
        x = new Matrix(basePath + "3_x10.txt");

        try {
            calculated_x = cholesky.loese(a, b);
            assertEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(equal);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append("3.100")
                .append('\n')
                .append(expectedLog)
                .append(equal);

        a = new Matrix(basePath + "3_A100.txt");
        b = new Matrix(basePath + "3_b100.txt");
        x = new Matrix(basePath + "3_x100.txt");

        try {
            calculated_x = cholesky.loese(a, b);
            assertEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(equal);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append("3.1000")
                .append('\n')
                .append(expectedLog)
                .append(equal);

        a = new Matrix(basePath + "3_A1000.txt");
        b = new Matrix(basePath + "3_b1000.txt");
        x = new Matrix(basePath + "3_x1000.txt");

        try {
            calculated_x = cholesky.loese(a, b);
            assertEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(equal);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }
        testLog.append('\n');

        testLog.append(testingLog)
                .append(4)
                .append('\n')
                .append(expectedLog)
                .append(exception);

        a = new Matrix(basePath + "4_A.txt");
        b = new Matrix(basePath + "4_b.txt");

        try {
            cholesky.loese(a, b);
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(exception);
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append(5)
                .append('\n')
                .append(expectedLog)
                .append(exception);

        a = new Matrix(basePath + "5_A.txt");
        b = new Matrix(basePath + "5_b.txt");

        try {
            cholesky.loese(a, b);
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(exception);
        }

        testLog.append('\n');

        testLog.append(testingLog)
                .append(6)
                .append('\n')
                .append(expectedLog)
                .append(notEqual);

        a = new Matrix(basePath + "6_A.txt");
        b = new Matrix(basePath + "6_b.txt");
        x = new Matrix(basePath + "6_x.txt");

        try {
            calculated_x = cholesky.loese(a, b);
            assertNotEquals(x, calculated_x);
            testLog.append(yieldLog)
                    .append(notEqual);
        } catch (CholeskyException e) {
            testLog.append(yieldLog)
                    .append(failed);
            Files.write(Paths.get("test.log"), testLog.toString().getBytes());
            fail();
        }

        testLog.append('\n')
                .append("Test finished successfully!");

        Files.write(Paths.get("test.log"), testLog.toString().getBytes());
    }

}