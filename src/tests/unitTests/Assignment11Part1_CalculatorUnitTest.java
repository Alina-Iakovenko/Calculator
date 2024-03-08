package tests.unitTests;

import com.shpp.p2p.cs.aiakovenko.assignment11.Assignment11Part1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Assignment11Part1_CalculatorUnitTest {

    @Test
    public void test_Calculator_falseBrackets()
    {
        String formula = "(1+2)3";
        String expectedErrorMessage = "Exception occured: string doesn`t match formula rules because there are brackets without operator before or after";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_BracketsMultiplyDivideBrackets()
    {
        String formula = "(2+3)*4/(2-1)";
        Double expectedResult = 20.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));

    }
    @Test
    public void test_Calculator_PlusMinus_Success()
    {
        String formula = "1+2-3";
        Double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_Multiply_Divide()
    {
        String formula = "1*2/0.5";
        double expectedResult = 4.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    
    @Test
    public void test_Calculator_UnaryMinusAtStart()
    {
        String formula = "-1+2*3";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
       }
    @Test
    public void test_Calculator_UnaryMinusAndMoreMinusLater()
    {
        String formula = "-1+-2-3";
        double expectedResult = -6.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_Multiply_UnaryMinusAndMoreMinusLater()
    {
        String formula = "2*-3-5";
        double expectedResult = -11.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    
    @Test
    public void test_Calculator_UnaryMinus_MinusLater()
    {
        String formula = "-2-3";
        double expectedResult = -5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_UnaryMinus_Minus_Minus()
    {
        String formula = "-2-3-5-10";
        double expectedResult = -20.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_UnaryMinus_Multiply_Division()
    {
        String formula = "-1*-2/-2*-2";
        double expectedResult = 2.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_SimpleNumber_Multiply_UnaryMinusInTheMiddle()
    {
        String formula = "-1*-2+3";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_Sum_Multiply_Division()
    {
        String formula = "1*3+2/1";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_OddPower()
    {
        String formula = "2^3";
        double expectedResult = 8.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }

    @Test
    public void test_Calculator_PowerInPower()
    {
        String formula = "4^2^3";
        double expectedResult = 65536;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_withUnaryMinus_OddPower()
    {
        String formula = "-2^3";
        double expectedResult = -8.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }

    @Test
    public void test_Calculator_DoublePositivePower()
    {
        String formula = "2^0.5";
        double expectedResult = 1.4142135623730951;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));

    }
    @Test
    public void test_Calculator_DoubleNegativePower()
    {
        String formula = "2^-0.5";
        double expectedResult = 0.7071067811865476;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_SimpleNegativeNumber_DoubleNegativePower_Exception()  {
        String formula = "-2^-0.5";
        String expectedErrorMessage = "Exception occured in class PowerNode: Result is undefined (NaN or Infinity)";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_Double_DoublePositivePower()
    {
        String formula = "0.5^0.8";
        double expectedResult = 0.5743491774985174;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_zeroInZeroPower()
    {
        String formula = "0^0";
        double expectedResult = 1.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_zeroInPositivePower()
    {
        String formula = "0^6";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }

    @Test
    public void test_Calculator_zeroInNegativePower()
    {
        String formula = "0^-6";
        String expectedErrorMessage = "Exception occured in class PowerNode: Result is undefined (NaN or Infinity)";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_powerBetweenAdd()
    {
        String formula = "3+2^2+3";
        double expectedResult = 10.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }

    @Test
    public void test_Calculator_DivideInZero()
    {
        String formula = "9/0";
        String expectedErrorMessage = "Exception occured in class DivideNode: Result is undefined (NaN or Infinity)";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(formula, null));
    }

    @Test
    public void test_Calculator_NegativeDouble_MultiplyToZero()
    {
        String formula = "0*-9.9*0";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
    @Test
    public void test_Calculator_NegativeZero()
    {
        String formula = "-0";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(formula, null));
    }
}


