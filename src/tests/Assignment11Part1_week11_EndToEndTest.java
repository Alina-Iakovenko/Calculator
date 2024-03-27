package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.Assignment11Part1;
//import com.shpp.p2p.cs.hherasymenko.assignment11.Assignment11Part1;
//import com.shpp.p2p.cs.ryaroshenko.assignment11.Assignment11Part1;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

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
    public void testAreValidBrackets_simpleCase() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2+(3-5)";
        double expectedResult = 0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }
    @Test
    public void Assignment11Part1_UnaryMinusBeforeBracketWithMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "-(3-5)";
        double expectedResult = 2;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }
    @Test
    public void Assignment11Part1_MinusBeforeBracketWithMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "4-(3-5)";
        double expectedResult = 6;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }
    @Test
    public void Assignment11Part1_MultiplyUnaryMinusBeforeBracketWithMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1*-(3-5)";
        double expectedResult = 2;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }
    @Test
    public void Assignment11Part1_MultiplyUnaryMinusBeforeBracketWithMinusAndMoreMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1*-(3-5)-5";
        double expectedResult = -3;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }
    @Test
    public void Assignment11Part1_MultiplyUnaryMinusBeforeBracketWithPlusAndMoreMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1*-(3+5)-5";
        double expectedResult = -13;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }
    @Test
    public void Assignment11Part1_MultiplyUnaryMinusBeforeBracketWithPlus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "1*-(3+5)";
        double expectedResult = -8;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testAreValidBrackets_2PairsOfBrackets() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2+(3-5) + (9-6)";
        double expectedResult = 3;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testAreValidBrackets_BracketsInside() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2+(3-(9-5))";
        double expectedResult = 1;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testAreValidBrackets_BracketsInside2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2+((3-5) * 9-6)";
        double expectedResult = -22;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testCheckSign_simpleCase3() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "((1+2)-3)";
        double expectedResult = 0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleBracketsMultiply() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "(2+3)*2";
        double expectedResult = 10.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplySimpleBrackets() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2*(2+3)";
        double expectedResult = 10.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplyBracketsPlusUnaryMinusBrackets() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2*(2+3)+-(-9*5)";
        double expectedResult = 55.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_MultiplyBracketsMinusBracketsMinusDivide() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "2*(2+3)-(-9*5)-8/2";
        double expectedResult = 51.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_BracketsNumberMultiplyBracketsMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "(2*(2+3))-5";
        double expectedResult = 5.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_BracketsNumberMultiplyBracketsDivideBracketsPlusNumberMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "(2*(2+3)/(7-2)+3)-5";
        double expectedResult = 0.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleSinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "sin(5)";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleSinus2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "sin(10-5)";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SimpleSinusInBrackets() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "(sin(10-5))";
        double expectedResult = -0.9589242746631385;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusInPower() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "(sin(10-5))^2";
        double expectedResult = 0.9195357645382262;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusInPower2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "sin(10-5)^2";
        double expectedResult = 0.9195357645382262;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusForNumberInPower2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "sin((10-5)^2)";
        double expectedResult = -0.13235175009777302890200509388361;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_SinusSinusMinus() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "sin(sin(8+2)-5)";
        double expectedResult = 0.6736704614211501;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_cos() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "cos(10)";
        double expectedResult = -0.83907152907645245225886394782406;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_tan() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "tan(10)";
        double expectedResult = 0.64836082745908667125912493300981;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_atan() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "atan(10)";
        double expectedResult = 1.4711276743037347;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_log10() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "log10(10)";
        double expectedResult = 1.00;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_log2() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "log2(4)";
        double expectedResult = 2.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void testParseStringToTree_sqrt() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "sqrt(9)";
        double expectedResult = 3.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));
    }

    @Test
    public void test_Calculator_BracketsMultiplyDivideBrackets() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String formula = "(2+3)*4/(2-1)";
        Double expectedResult = 20.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(new String[]{formula}));

    }

    @Test
    public void test_SimpleCalculator_sthTerrible() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"( 1 + 2 * 3 / 4 ^ 5 + ( -6 * 7 / ( cos ( 8 ) ^ 9 + sin ( tan ( atan ( log2 ( 10 ) ^ 11 ) / 12 ) * 13 ) + 14 - 15 * 16 ) ) ^ 17 - 18 + ( -19 ^ ( -20 ) ) * ( -21 ) + 22 ^ 23 + tan ( 24 ) - sqrt ( 25 ) - 26 + 27 ^ 28 / 29 - 30 ) / 31 ^ a + sqrt ( sqrt ( 625 ) )", "a = 36"};
        double expectedResult = 5.000000000000001;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
    @Test
    public void test_SimpleCalculator_strangeBrackets() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String[] args = {"((-(5+2))+1)"};
        double expectedResult = -6.0;
        assertEquals(expectedResult, Assignment11Part1.testMain(args));
    }
}
