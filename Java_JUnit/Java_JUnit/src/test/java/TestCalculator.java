
import org.example.Сalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {
    private static Сalculator calculator;

    @BeforeAll
    public static void init(){
        calculator = new Сalculator ();
    }

    @Test
    public void checkAddNumbers(){
        assertEquals(4,  calculator.add(2, 2));

    }

    @ParameterizedTest
    @CsvSource({
            "-4, -2, 2",
            "24, 144, 6",
            "1, 1, 0"
    })
    public void checkSubtractNumbers(int exp, int value, int value2){
        assertTrue(exp == calculator.subtract(value, value2));
    }

    @ParameterizedTest
    @CsvSource({
            "9, 12, 6",
            "24, 144, 6",
            "0, 1, 0"
    })
    public void checkDivisionNumbers(int exp, int value, int value2){
        assertEquals(exp, calculator.division(value, value2));
    }

    @Test
    public void checkMultiplyNumbers(){
        assertEquals(4,  calculator.multiply(2, 2), "2 * 2 should equal 4");
    }

}
