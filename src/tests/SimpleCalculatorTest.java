package tests;

import com.shpp.p2p.cs.aiakovenko.assignment11.SimpleCalculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {
    @Test
    public void test_SimpleCalculator_UnaryMinusAtEnd(){
        String[] args = {"1+2--3"};
        String expectedResult = "6.0";
        // Захоплюємо виведення в консоль
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // Викликаємо метод main
        SimpleCalculator.main(args);
        // Отримуємо виведення з консолі
        String actualOutput = outputStream.toString().trim();
        // Перевіряємо, чи друкується очікуваний рядок
        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_MinusUnaryMinus(){
        String[] args = {"-1--2"};
        String expectedResult = "1.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_MinusUnaryMinus_AndMoreMinusLater(){
        String[] args = {"-1--2-3"};
        String expectedResult = "-2.0";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
    @Test
    public void test_SimpleCalculator_Double_Divide_Minus_UnaryMinusDouble_Multiply(){
        String[] args = {"5.9/3--1.1*3"};
        String expectedResult = "5.2666666666666675";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SimpleCalculator.main(args);
        String actualOutput = outputStream.toString().trim();

        assertEquals(expectedResult, actualOutput);
    }
}


