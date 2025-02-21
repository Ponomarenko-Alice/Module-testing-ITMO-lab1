package task1;

import extension.TimeoutExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TimeoutExtension.class)
public class SinTest {
    private final Sin sinFunction = new Sin();


    @Test
    public void testFactorialOfZero() {
        assertEquals(1, sinFunction.factorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, sinFunction.factorial(1));
    }

    @Test
    public void testFactorialOfSmallNumbers() {
        assertEquals(2, sinFunction.factorial(2));
        assertEquals(6, sinFunction.factorial(3));
        assertEquals(24, sinFunction.factorial(4));
        assertEquals(120, sinFunction.factorial(5));
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
        assertEquals(expected, sinFunction.sinTaylor(Math.PI / 2, 10), 1e-6);
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
