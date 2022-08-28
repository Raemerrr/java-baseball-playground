package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 요구사항1_1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test
    void 요구사항1_2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
    }

    @Test
    void 요구사항2() {
        String actual = "(1,2)".replace("(", "").replace(")", "");
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    void 요구사항3() {
        assertThatThrownBy(() -> {
            String str = "abc";
            for (int i = 0; i < str.length() + 1; i++) {
                char c = str.charAt(i);
                System.out.println(c);
            }
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
