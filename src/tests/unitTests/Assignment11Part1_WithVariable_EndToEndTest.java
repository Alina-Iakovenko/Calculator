package tests.unitTests;

import com.shpp.p2p.cs.aiakovenko.assignment11.Assignment11Part1;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment11Part1_WithVariable_EndToEndTest {
    @Test
    public void test_SimpleCalculator_SimpleVariables(){
        String[] args = {"2*x+3*y", "x=2", "y=3"};
        String expectedResult = "13.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Assignment11Part1.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_SimpleVariables_WithUnaryMinus() {
        String[] args = {"2*-x+3*y", "x=2", "y=3"};
        String expectedResult = "5.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Assignment11Part1.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_NegativeVariables_WithUnaryMinus() {
        String[] args = {"2*-x+3*y", "x=-2", "y=3"};
        String expectedResult = "13.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Assignment11Part1.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_VariableFirst() {
        String[] args = {"x*2+3*y", "x=-2", "y=3"};
        String expectedResult = "5.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Assignment11Part1.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_Variable_Multiply_UnaryVariable() {
        String[] args = {"y*-x+3*3", "x=2", "y=3"};
        String expectedResult = "3.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Assignment11Part1.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_Variable_Multiply_UnaryVariable_VariableTwiceOccurred_WithoutNumber() {
        String[] args = {"y*-x+y", "x=2", "y=3"};
        String expectedResult = "-3.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Assignment11Part1.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_sthTerrible() {
        String[] args = {"( 1 + 2 * 3 / 4 ^ 5 + ( -6 * 7 / ( cos ( 8 ) ^ 9 + sin ( tan ( atan ( log2 ( 10 ) ^ 11 ) / 12 ) * 13 ) + 14 - 15 * 16 ) ) ^ 17 - 18 + ( -19 ^ ( -20 ) ) * ( -21 ) + 22 ^ 23 + tan ( 24 ) - sqrt ( 25 ) - 26 + 27 ^ 28 / 29 - 30 ) / 31 ^ a + sqrt ( sqrt ( 625 ) )", "a = 36"};
        String expectedResult = "5.000000000000001";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Assignment11Part1.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }

}


