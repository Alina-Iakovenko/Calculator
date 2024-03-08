package tests.unitTests;

import com.shpp.p2p.cs.aiakovenko.assignment11.tree.ExpressionParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionParser_BracketsAndFormulas_UnitTest {
    ExpressionParser test = new ExpressionParser();
    @Test
    public void testCheckSign_simpleCase(){
        char sign = '+';
        String formula = "(1+2)-3";
        int expectedResult = -1;
        assertEquals(expectedResult, test.checkSign(sign,formula));
    }
    @Test
    public void testCheckSign_simpleCase2(){
        char sign = '-';
        String formula = "(1+2)-3";
        int expectedResult = 5;
        assertEquals(expectedResult, test.checkSign(sign,formula));
    }
    @Test
    public void testCheckSign_simpleCase3(){
        char sign = '-';
        String formula = "((1+2)-3)";
        int expectedResult = -1;
        assertEquals(expectedResult, test.checkSign(sign,formula));
    }
    @Test
    public void testCheckSign_simpleCase4(){
        char sign = '-';
        String formula = "(1+2)-(3-1)";
        int expectedResult = 5;
        assertEquals(expectedResult, test.checkSign(sign,formula));
    }
    @Test
    public void testCheckSign_simpleCase5(){
        char sign = '(';
        String formula = "(1+2)-(3-1)";
        int expectedResult = -1;
        assertEquals(expectedResult, test.checkSign(sign,formula));
    }
    @Test
    public void testCheckSign_simpleCase6(){
        char sign = ')';
        String formula = "(1+2)-(3-1)";
        int expectedResult = 4;
        assertEquals(expectedResult, test.checkSign(sign,formula));
    }
    @Test
    public void testParseStringToTree_PlusMinus(){
        String formula = "1+3";
        double expectedResult = 4.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_MultiplyMinus(){
        String formula = "2*3-5";
        double expectedResult = 1.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_MultiplyMinusMinus(){
        String formula = "2*3-5-3";
        double expectedResult = -2.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SimpleBracketsMultiply(){
        String formula = "(2+3)*2";
        double expectedResult = 10.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_MultiplySimpleBrackets(){
        String formula = "2*(2+3)";
        double expectedResult = 10.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_MultiplyBracketsPlusUnaryMinusBrackets(){
        String formula = "2*(2+3)+-(-9*5)";
        double expectedResult = 55.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_MultiplyBracketsMinusBracketsMinusDivide(){
        String formula = "2*(2+3)-(-9*5)-8/2";
        double expectedResult = 51.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_BracketsNumberMultiplyBracketsMinus(){
        String formula = "(2*(2+3))-5";
        double expectedResult = 5.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_BracketsNumberMultiplyBracketsDivideBracketsPlusNumberMinus(){
        String formula = "(2*(2+3)/(7-2)+3)-5";
        double expectedResult = 0.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SimpleSinus(){
        String formula = "sin(5)";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SimpleSinus2(){
        String formula = "sin(10-5)";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SimpleSinusInBrackets(){
        String formula = "(sin(10-5))";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SinusInPower(){
        String formula = "(sin(10-5))^2";
        double expectedResult = 0.9195357645382262;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SinusInPower2(){
        String formula = "sin(10-5)^2";
        double expectedResult = 0.9195357645382262;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SinusForNumberInPower2(){
        String formula = "sin((10-5)^2)";
        double expectedResult = -0.13235175009777302890200509388361;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_SinusSinusMinus(){
        String formula = "sin(sin(8+2)-5)";
        double expectedResult = 0.6736704614211501;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_cos(){
        String formula = "cos(10)";
        double expectedResult = -0.83907152907645245225886394782406;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_tan(){
        String formula = "tan(10)";
        double expectedResult = 0.64836082745908667125912493300981;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_atan(){
        String formula = "atan(10)";
        double expectedResult = 1.4711276743037347;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_log10(){
        String formula = "log10(10)";
        double expectedResult = 1.00;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_log2(){
        String formula = "log2(4)";
        double expectedResult = 1.3862943611198906;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
    @Test
    public void testParseStringToTree_sqrt(){
        String formula = "sqrt(9)";
        double expectedResult = 3.0;
        assertEquals(expectedResult,test.parseStringToTree(formula).evaluate());
    }
}

