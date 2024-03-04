package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.SimpleCalculator;
import org.junit.jupiter.api.Test;

public class InvalidCasesSimpleCalculatorTest {
    @Test
    public void QuotesAndSpaces(){
        String[] args = {"\" 1 + 2 * x \"", "\"x = 2\""};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "5.0";
        System.out.println();
        System.out.println("Expected result: " + expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }

    @Test
    public void NoValueForVariable() {
        String[] args = {"2*x+3*y", "x=2", "z=3"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: no data for variable from formula";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }

    @Test
    public void NoValueForVariable_WrongVariableString() {
        String[] args = {"2*x+3*y", "x==2", "y=3"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: string [x, , 2] can`t be parsed to variable with value";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void InvalidVariableName(){
        String[] args = {"2*x+3*y", "x8=2", "y=3"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: invalid variable name in string: [x8, 2]";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }

    @Test
    public void InvalidVariableValue(){
        String[] args = {"2*x+3*y", "x=2", "z=3..2"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: invalid variable value in string: [z, 3..2]";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void InvalidVariableValue2() {
        String[] args = {"2*x+3*y", "x=2", "z=3.a2"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: invalid variable value in string: [z, 3.a2]";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }

}


