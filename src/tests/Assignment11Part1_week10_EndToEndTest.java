package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.Assignment11Part1;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;
public class Assignment11Part1_week10_EndToEndTest {
    @Test
    public void test_isValidVariableName_VariableNode_() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2*x4+3*y", "x=2", "y=3"}));
    }

    @Test
    public void testConstructor_FoNoFormula() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{" "}));
    }

    @Test
    public void testisValidFormula_InvalidFormula1_wrongStart() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"!jjklkldns"}));
    }

    @Test
    public void testisValidFormula_InvalidFormula2_wrongEnd() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"jjklkldns-"}));
    }

    @Test
    public void testisValidFormula_InvalidFormula3_wrongCharacter() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"j45%jklkldns"}));
    }

    @Test
    public void testisValidFormula_InvalidFormula4_signInline() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"j45/*-jklkldns"}));
    }

    @Test
    public void testisValidFormula_TwoUnaryMinusInline() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2*5---5"}));
    }

    @Test
    public void testParseStringToTree_PlusMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1+3";
        double expectedResult = 4.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplyMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2*3-5";
        double expectedResult = 1.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplyMinusMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2*3-5-3";
        double expectedResult = -2.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_PlusMinus_Success() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1+2-3";
        Double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_Multiply_Divide() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1*2/0.5";
        double expectedResult = 4.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_UnaryMinusAtStart() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-1+2*3";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_UnaryMinusAndMoreMinusLater() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-1+-2-3";
        double expectedResult = -6.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_Multiply_UnaryMinusAndMoreMinusLater() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2*-3-5";
        double expectedResult = -11.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_UnaryMinus_MinusLater() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-2-3";
        double expectedResult = -5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_UnaryMinus_Minus_Minus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-2-3-5-10";
        double expectedResult = -20.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_UnaryMinus_Multiply_Division() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-1*-2/-2*-2";
        double expectedResult = 2.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_SimpleNumber_Multiply_UnaryMinusInTheMiddle() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-1*-2+3";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_Sum_Multiply_Division() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1*3+2/1";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_OddPower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2^3";
        double expectedResult = 8.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_PowerInPower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "4^2^3";
        double expectedResult = 65536;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_withUnaryMinus_OddPower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-2^3";
        double expectedResult = -8.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_DoublePositivePower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2^0.5";
        double expectedResult = 1.4142135623730951;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));

    }

    @Test
    public void test_Calculator_DoubleNegativePower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2^-0.5";
        double expectedResult = 0.7071067811865476;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_Double_DoublePositivePower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "0.5^0.8";
        double expectedResult = 0.5743491774985174;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_zeroInZeroPower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "0^0";
        double expectedResult = 1.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_zeroInPositivePower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "0^6";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_powerBetweenAdd() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "3+2^2+3";
        double expectedResult = 10.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_NegativeDouble_MultiplyToZero() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "0*-9.9*0";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_NegativeZero() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-0";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_DivideInZero() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"9/0"}));
    }

    @Test
    public void test_Calculator_zeroInNegativePower() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"0^-6"}));
    }

    @Test
    public void test_Calculator_SimpleNegativeNumber_DoubleNegativePower_Exception() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"-2^-0.5"}));
    }

    @Test
    public void QuotesAndSpaces() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] formula = {"\" 1 + 2 * x \"", "\"x = 2\""};
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(formula));
    }

    @Test
    public void NoValueForVariable() {
        String[] args = {"2*x+3*y", "x=2", "z=3"};
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(args));
    }

    @Test
    public void NoValueForVariable_WrongVariableString() {
        String[] args = {"2*x+3*y", "x==2", "y=3"};
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(args));
    }

    @Test
    public void InvalidVariableName() {
        String[] args = {"2*x+3*y", "x8=2", "y=3"};
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(args));
    }

    @Test
    public void InvalidVariableValue() {
        String[] args = {"2*x+3*y", "x=2", "z=3..2"};
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(args));
    }

    @Test
    public void InvalidVariableValue2() {
        String[] args = {"2*x+3*y", "x=2", "z=3.a2"};
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_UnaryMinusAtEnd() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"1+2--3"};
        double expectedResult = 6.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_MinusUnaryMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"-1--2"};
        double expectedResult = 1.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_MinusUnaryMinus_AndMoreMinusLater() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"-1--2-3"};
        double expectedResult = -2.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_Double_Divide_Minus_UnaryMinusDouble_Multiply() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"5.9/3--1.1*3"};
        double expectedResult = 5.2666666666666675;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_SimpleVariables() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"2*x+3*y", "x=2", "y=3"};
        double expectedResult = 13.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_SimpleVariables_WithUnaryMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"2*-x+3*y", "x=2", "y=3"};
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_NegativeVariables_WithUnaryMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"2*-x+3*y", "x=-2", "y=3"};
        double expectedResult = 13.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_VariableFirst() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"x*2+3*y", "x=-2", "y=3"};
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_Variable_Multiply_UnaryVariable() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"y*-x+3*3", "x=2", "y=3"};
        double expectedResult = 3.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_Variable_Multiply_UnaryVariable_VariableTwiceOccurred_WithoutNumber() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"y*-x+y", "x=2", "y=3"};
        double expectedResult = -3.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }

}
