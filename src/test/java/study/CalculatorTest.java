package study;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3 + 4:10", "2 * 3 + 5 - 2:9", "2 + 3 * 4 / 2:10", "  1 + 1  :2"}, delimiter = ':')
    @DisplayName("정상입력")
    void 정상입력(final String input, final Integer expected) {
        int result = Calculator.run(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1+1", "+", "+ 1 + 1"})
    @DisplayName("비정상입력")
    void 비정상입력(final String input) {
        Assertions.assertThrows(Exception.class, () -> Calculator.run(input));
    }
}
