package task1;

public class Sin {
    public int factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }


    public double sinTaylor(double x, int iterationNumber) {
        double result = 0.0;

        for (int i = 0; i < iterationNumber; i++) {
            int exponent = 2 * i + 1;
            double term = Math.pow(-1, i) * Math.pow(x, exponent) / factorial(exponent);
            result += term;

        }
        return result;
    }
}
