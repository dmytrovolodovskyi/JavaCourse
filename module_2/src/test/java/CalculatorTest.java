import calculator.Operations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private final float a = 10f;
    private final float b = 20f;

    private final Operations operations = new Operations();

    @Test
    public void testSum() {
        float result = operations.add(a, b);

        final float expected = a + b;
        assertEquals(expected, result);
    }

    @Test
    public void testSubtract() {
        float result = operations.subtract(a, b);

        final float expected = a - b;
        assertEquals(expected, result);
    }

    @Test
    public void testMultiply() {
        final float result = operations.multiply(a, b);

        final float expected = a * b;
        assertEquals(expected, result);
    }

    @Test
    public void testDivide() {
        final float result = operations.divide(a, b);

        final float expected = a / b;
        assertEquals(expected, result);
    }

}
