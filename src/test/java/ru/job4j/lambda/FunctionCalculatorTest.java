package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(33D, 65D, 129D);
        assertThat(result).isEqualTo(expected);
    }
}