package baseball;

import baseball.validator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    void 세자리_숫자만_입력() {
        assertDoesNotThrow(() -> InputValidator.isOnlyNumberAndThreeDigitLimit("123"));
    }

    @Test
    void 네자리_숫자만_입력() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isOnlyNumberAndThreeDigitLimit("1234"));
    }

    @Test
    void 제한된_범위_밖_숫자_입력() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isOnlyNumberAndThreeDigitLimit("012"));
    }

    @Test
    void 문자열_입력() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.isOnlyNumberAndThreeDigitLimit("r"));
    }
}
