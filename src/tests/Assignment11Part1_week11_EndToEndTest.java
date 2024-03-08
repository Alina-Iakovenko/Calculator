package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.Assignment11Part1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Assignment11Part1_week11_EndToEndTest {
    @Test
    public void testAreValidBrackets_BracketsInside_false() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+((3-5) * 9-6))"}));
    }

    @Test
    public void testAreValidBrackets_EmptyBrackets_false() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+(3-5) * ()9-6"}));
    }

    @Test
    public void testAreValidBrackets_BracketsInside2_false() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+((3-5) * 9-6))"}));
    }

    @Test
    public void testAreValidBrackets_BracketsInside3() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+(3-(-5)) * 9-6)"}));
    }

    @Test
    public void testAreValidBrackets_BracketsInside4_false() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+(3-5 * 9-6))"}));
    }

    @Test
    public void testAreValidBrackets_NotClosed_false() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+(3-5 * 9-6"}));
    }

    @Test
    public void testAreValidBrackets_NotOpened_false() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+3-5) * 9-6"}));
    }

    @Test
    public void testConstructor_InvalidBrackets_Exception() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+((3-5) * 9-6))"}));
    }

    @Test
    public void testConstructor_InvalidBrackets2_Exception() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"2+((3-5) * (9-(6))"}));
    }

    @Test
    public void test_Calculator_falseBrackets() {
        assertThrows(Exception.class, () -> Assignment11Part1.testMain(new String[]{"(1+2)3"}));
    }

    @Test
    public void testAreValidBrackets_simpleCase() {
        String formula = "2+(3-5)";
        double expectedResult = 0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testAreValidBrackets_2PairsOfBrackets() {
        String formula = "2+(3-5) + (9-6)";
        double expectedResult = 3;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testAreValidBrackets_BracketsInside() {
        String formula = "2+(3-(9-5))";
        double expectedResult = 1;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testAreValidBrackets_BracketsInside2() {
        String formula = "2+((3-5) * 9-6)";
        double expectedResult = -22;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testCheckSign_simpleCase3() {
        String formula = "((1+2)-3)";
        double expectedResult = 0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleBracketsMultiply() {
        String formula = "(2+3)*2";
        double expectedResult = 10.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplySimpleBrackets() {
        String formula = "2*(2+3)";
        double expectedResult = 10.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplyBracketsPlusUnaryMinusBrackets() {
        String formula = "2*(2+3)+-(-9*5)";
        double expectedResult = 55.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplyBracketsMinusBracketsMinusDivide() {
        String formula = "2*(2+3)-(-9*5)-8/2";
        double expectedResult = 51.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_BracketsNumberMultiplyBracketsMinus() {
        String formula = "(2*(2+3))-5";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_BracketsNumberMultiplyBracketsDivideBracketsPlusNumberMinus() {
        String formula = "(2*(2+3)/(7-2)+3)-5";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleSinus() {
        String formula = "sin(5)";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleSinus2() {
        String formula = "sin(10-5)";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleSinusInBrackets() {
        String formula = "(sin(10-5))";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusInPower() {
        String formula = "(sin(10-5))^2";
        double expectedResult = 0.9195357645382262;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusInPower2() {
        String formula = "sin(10-5)^2";
        double expectedResult = 0.9195357645382262;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusForNumberInPower2() {
        String formula = "sin((10-5)^2)";
        double expectedResult = -0.13235175009777302890200509388361;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusSinusMinus() {
        String formula = "sin(sin(8+2)-5)";
        double expectedResult = 0.6736704614211501;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_cos() {
        String formula = "cos(10)";
        double expectedResult = -0.83907152907645245225886394782406;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_tan() {
        String formula = "tan(10)";
        double expectedResult = 0.64836082745908667125912493300981;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_atan() {
        String formula = "atan(10)";
        double expectedResult = 1.4711276743037347;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_log10() {
        String formula = "log10(10)";
        double expectedResult = 1.00;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_log2() {
        String formula = "log2(4)";
        double expectedResult = 1.3862943611198906;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_sqrt() {
        String formula = "sqrt(9)";
        double expectedResult = 3.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_BracketsMultiplyDivideBrackets() {
        String formula = "(2+3)*4/(2-1)";
        Double expectedResult = 20.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));

    }

    @Test
    public void test_SimpleCalculator_sthTerrible() {
        String[] args = {"( 1 + 2 * 3 / 4 ^ 5 + ( -6 * 7 / ( cos ( 8 ) ^ 9 + sin ( tan ( atan ( log2 ( 10 ) ^ 11 ) / 12 ) * 13 ) + 14 - 15 * 16 ) ) ^ 17 - 18 + ( -19 ^ ( -20 ) ) * ( -21 ) + 22 ^ 23 + tan ( 24 ) - sqrt ( 25 ) - 26 + 27 ^ 28 / 29 - 30 ) / 31 ^ a + sqrt ( sqrt ( 625 ) )", "a = 36"};
        double expectedResult = 5.000000000000001;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
}
