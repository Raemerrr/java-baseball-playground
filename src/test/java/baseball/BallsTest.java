package baseball;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    List<Integer> generatedNumbers;

    @BeforeEach
    void setUp() {
        generatedNumbers = Arrays.asList(3, 4, 5);
    }

    @Test
    void 중복된_수_입력() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> duplicatedNumber = Arrays.asList(3, 3, 5);
            new Balls(duplicatedNumber);
        });
    }

    @Test
    void 스트라이크() {
        Balls computer = new Balls(generatedNumbers);
        BallStatus status = computer.play(new Ball(0, 3));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼() {
        Balls computer = new Balls(generatedNumbers);
        BallStatus status = computer.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 낫싱() {
        Balls computer = new Balls(generatedNumbers);
        BallStatus status = computer.play(new Ball(0, 2));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
