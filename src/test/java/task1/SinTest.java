package task1;

import extension.TimeoutExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimeoutExtension.class)
public class SinTest {
    private Sin sinFunction;

    @BeforeEach
    void setUp() {
        sinFunction = new Sin();
    }


    @Test
    public void testFactorialOfZero() {
        assertEquals(1, sinFunction.factorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, sinFunction.factorial(1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120"
    })
    void testFactorialOfSmallNumbers(int input, int expected) {
        assertEquals(expected, sinFunction.factorial(input));
    }


    @Test
    public void testFactorialOfLargerNumber() {
        assertEquals(3628800, sinFunction.factorial(10));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> sinFunction.factorial(-5));
    }

    @Test
    void testFactorialPositive() {
        assertEquals(120, sinFunction.factorial(5)); // 5! = 120
        assertEquals(1, sinFunction.factorial(1));   // 1! = 1
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, sinFunction.factorial(0)); // 0! = 1
    }

    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> sinFunction.factorial(-1));
    }

    @Test
    public void testFactorialOfNegativeNumbe2r() {
        assertDoesNotThrow(() -> sinFunction.factorial(5), "f");
    }

    @Test
    void testSinTaylorZero() {
        assertEquals(0.0, sinFunction.sinTaylor(0, 10), 1e-6);
    }

    @Test
    void testSinTaylorFirstQuarter() {
        double expected = Math.sin(Math.PI / 6);
        assertEquals(expected, sinFunction.sinTaylor(Math.PI / 6, 10), 1e-6);
    }


    @Test
    void testSinTaylorRightAngle() {
        double expected = Math.sin(Math.PI / 2);
        assertEquals(expected, sinFunction.sinTaylor(Math.PI / 2, 10), 1e-4);
    }

    @Test
    void testSinTaylorNegative() {
        double expected = Math.sin(-Math.PI / 4);
        assertEquals(expected, sinFunction.sinTaylor(-Math.PI / 4, 10), 1e-6);
    }

    @Test
    void testSinTaylorLargeIterations() {
        double result = sinFunction.sinTaylor(Math.PI / 3, 50);
        assertTrue(Double.isNaN(result));
    }

    @Test
    void testSinTaylorTooooLargeIterations() throws InterruptedException {
//        Thread.sleep(600);
        double result = sinFunction.sinTaylor(Math.PI / 3, 50);
        assertTrue(Double.isNaN(result));
    }

    @Test
    void testSinTaylorDoesNotMatchSin() {
        double expected = Math.sin(2 * Math.PI);
        assertNotEquals(expected, sinFunction.sinTaylor(2 * Math.PI, 5), 1e-2);
    }
}
