package tests.unitTests;

import com.shpp.p2p.cs.aiakovenko.assignment11.Assignment11Part1;
import com.shpp.p2p.cs.aiakovenko.assignment11.inputParser.FormulaString;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.ExpressionParser;
import com.shpp.p2p.cs.aiakovenko.assignment11.tree.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Assignment11Part1_CalculatorUnitTest {

    @Test
    public void test_Calculator_falseBrackets()
    {
        String[] args = {"(1+2)3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        String expectedErrorMessage = "Exception occured: string doesn`t match formula rules because there are brackets without operator before or after";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_BracketsMultiplyDivideBrackets()
    {
        String[] args = {"(2+3)*4/(2-1)"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        Double expectedResult = 20.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));

    }
    @Test
    public void test_Calculator_PlusMinus_Success()
    {
        String[] args = {"1+2-3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        Double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_Multiply_Divide()
    {
        String[] args = {"1*2/0.5"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 4.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    
    @Test
    public void test_Calculator_UnaryMinusAtStart()
    {
        String[] args = {"-1+2*3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
       }
    @Test
    public void test_Calculator_UnaryMinusAndMoreMinusLater()
    {
        String[] args = {"-1+-2-3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = -6.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_Multiply_UnaryMinusAndMoreMinusLater()
    {
        String[] args = {"2*-3-5"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = -11.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    
    @Test
    public void test_Calculator_UnaryMinus_MinusLater()
    {
        String[] args = {"-2-3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = -5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_UnaryMinus_Minus_Minus()
    {
        String[] args = {"-2-3-5-10"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = -20.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_UnaryMinus_Multiply_Division()
    {
        String[] args = {"-1*-2/-2*-2"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 2.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_SimpleNumber_Multiply_UnaryMinusInTheMiddle()
    {
        String[] args = {"-1*-2+3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_Sum_Multiply_Division()
    {
        String[] args = {"1*3+2/1"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_OddPower()
    {
        String[] args = {"2^3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 8.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }

    @Test
    public void test_Calculator_PowerInPower()
    {
        String[] args = {"4^2^3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 65536;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_withUnaryMinus_OddPower()
    {
        String[] args = {"-2^3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = -8.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }

    @Test
    public void test_Calculator_DoublePositivePower()
    {
        String[] args = {"2^0.5"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 1.4142135623730951;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));

    }
    @Test
    public void test_Calculator_DoubleNegativePower()
    {
        String[] args = {"2^-0.5"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 0.7071067811865476;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_SimpleNegativeNumber_DoubleNegativePower_Exception()  {
        String[]args = {"-2^-0.5"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        String expectedErrorMessage = "Exception occured in class PowerNode: Result is undefined (NaN or Infinity)";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_Double_DoublePositivePower()
    {
        String[]args = {"0.5^0.8"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 0.5743491774985174;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_zeroInZeroPower()
    {
        String[]args = {"0^0"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 1.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_zeroInPositivePower()
    {
        String[]args = {"0^6"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }

    @Test
    public void test_Calculator_zeroInNegativePower()
    {
        String[] args = {"0^-6"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        String expectedErrorMessage = "Exception occured in class PowerNode: Result is undefined (NaN or Infinity)";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_powerBetweenAdd()
    {
        String[]args = {"3+2^2+3"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 10.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }

    @Test
    public void test_Calculator_DivideInZero()
    {
        String[]args = {"9/0"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        String expectedErrorMessage = "Exception occured in class DivideNode: Result is undefined (NaN or Infinity)";
        assertThrows(Exception.class, () -> Assignment11Part1.calculate(tree, null));
    }

    @Test
    public void test_Calculator_NegativeDouble_MultiplyToZero()
    {
        String[]args = {"0*-9.9*0"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
    @Test
    public void test_Calculator_NegativeZero()
    {
        String[]args = {"-0"};
        FormulaString formula = new FormulaString(args);
        ExpressionParser formulaParser = new ExpressionParser();
        Node tree = formulaParser.parseStringToTree(formula.getFormula());
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.calculate(tree, null));
    }
}


