package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.SimpleCalculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorVariableTest {
    @Test
    public void test_SimpleCalculator_SimpleVariables(){
        String[] args = {"2*x+3*y", "x=2", "y=3"};
        String expectedResult = "13.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_SimpleVariables_WithUnaryMinus() {
        String[] args = {"2*-x+3*y", "x=2", "y=3"};
        String expectedResult = "5.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_NegativeVariables_WithUnaryMinus() {
        String[] args = {"2*-x+3*y", "x=-2", "y=3"};
        String expectedResult = "13.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_VariableFirst() {
        String[] args = {"x*2+3*y", "x=-2", "y=3"};
        String expectedResult = "5.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_Variable_Multiply_UnaryVariable() {
        String[] args = {"y*-x+3*3", "x=2", "y=3"};
        String expectedResult = "3.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_Variable_Multiply_UnaryVariable_VariableTwiceOccurred_WithoutNumber() {
        String[] args = {"y*-x+y", "x=2", "y=3"};
        String expectedResult = "-3.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }

}


