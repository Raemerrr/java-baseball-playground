package baseball;

import baseball.validator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {

    @Test
    void 세자리_숫자만_입력() {
        assertThat(InputValidator.isCorrected("123")).isTrue();
    }

    @Test
    void 네자리_숫자만_입력() {
        assertThat(InputValidator.isCorrected("1234")).isFalse();
    }

    @Test
    void 제한된_범위_밖_숫자_입력() {
        assertThat(InputValidator.isCorrected("012")).isFalse();
    }

    @Test
    void 문자열_입력() {
        assertThat(InputValidator.isCorrected("ㄱ")).isFalse();
    }
}
