package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.inputParser.FormulaString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormulaStringBracketsTest {

    @Test
    public void testAreValidBrackets_simpleCase() {
        assertTrue(FormulaString.areValidBrackets("2+(3-5)"));
    }

    @Test
    public void testAreValidBrackets_2PairsOfBrackets() {
        assertTrue(FormulaString.areValidBrackets("2+(3-5) + (9-6)"));
    }

    @Test
    public void testAreValidBrackets_BracketsInside() {
        assertTrue(FormulaString.areValidBrackets("2+(3-(9-5))"));
    }

    @Test
    public void testAreValidBrackets_BracketsInside2() {
        assertTrue(FormulaString.areValidBrackets("2+((3-5) * 9-6)"));
    }

    @Test
    public void testAreValidBrackets_BracketsInside2_false() {
        assertThrows(IllegalArgumentException.class, () -> FormulaString.areValidBrackets("2+((3-5) * 9-6))"));
    }
    @Test
    public void testAreValidBrackets_BracketsInside3() {
        assertThrows(IllegalArgumentException.class, () -> FormulaString.areValidBrackets("2+(3-(-5)) * 9-6)"));
    }
    @Test
    public void testAreValidBrackets_BracketsInside_false() {
        assertThrows(IllegalArgumentException.class, () -> FormulaString.areValidBrackets("2+(3-5 * 9-6))"));
    }
    @Test
    public void testAreValidBrackets_NotClosed_false() {
        assertThrows(IllegalArgumentException.class, () -> FormulaString.areValidBrackets("2+(3-5 * 9-6"));
    }
    @Test
    public void testAreValidBrackets_NotOpened_false() {
        assertThrows(IllegalArgumentException.class, () -> FormulaString.areValidBrackets("2+3-5) * 9-6"));
    }
    @Test
    public void testConstructor_Brackets_true()
    {
        assertDoesNotThrow(() -> new FormulaString(new String[]{"2+((3-5) * 9-6)"}));
    }
    @Test
    public void testConstructor_InvalidBrackets_Exception() {
        assertThrows(IllegalArgumentException.class, () -> new FormulaString(new String[]{"2+((3-5) * 9-6))"}));
    }
    @Test
    public void testConstructor_InvalidBrackets2_Exception() {
        assertThrows(IllegalArgumentException.class, () -> new FormulaString(new String[]{"2+((3-5) * (9-(6))"}));
    }

}
