package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.SimpleCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormulaStringWithPrintedExceptionTest {
    @Test
    public void test_isValidVariableName_VariableNode_() {
        String[] args = {"2*x4+3*y", "x=2", "y=3"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: invalid variable name in formula: x4";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void testConstructor_FoNoFormula(){
        String[] args = {" "};
        System.out.println();
        System.out.println("Input:");
        String expectedResult = "Exception occuredIndex 0 out of bounds for length 0";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void testisValidFormula_InvalidFormula1_wrongStart() {
        String[] args = {"!jjklkldns"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: string doesn`t match formula rules";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void testisValidFormula_InvalidFormula2_wrongEnd() {
        String[] args = {"jjklkldns-"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: string doesn`t match formula rules";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void testisValidFormula_InvalidFormula3_wrongCharacter(){
        String[] args = {"j45%jklkldns"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: string doesn`t match formula rules";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }

    @Test
    public void testisValidFormula_InvalidFormula4_signInline() {
        String[] args = {"j45/*-jklkldns"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occured: string doesn`t match formula rules";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void testisValidFormula_TwoUnaryMinusInline() {
        String[] args = {"2*5---5"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occurred: invalid formula";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }

    @Test
    public void testAreValidBrackets_BracketsInside_false(){
        String[] args = {"2+(3-5 * 9-6))"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occurred: brackets in string doesn`t match formula rules";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
    @Test
    public void testAreValidBrackets_EmptyBrackets_false(){
        String[] args = {"2+(3-5) * ()9-6"};
        System.out.println();
        System.out.println("Input:");
        for (String arg : args) {
            System.out.print(" " + arg);
        }
        String expectedResult = "Exception occurred: string doesn`t match formula rules because there are empty brackets";
        System.out.println();
        System.out.println("Expected result: ");
        System.out.println(expectedResult);

        System.out.print("Received result: ");
        SimpleCalculator.main(args);
        System.out.println();
    }
}
