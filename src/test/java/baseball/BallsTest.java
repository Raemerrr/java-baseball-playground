package baseball;

import baseball.domain.*;
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

    @Test
    void _1_스트라이크_1볼() {
        Balls computer = new Balls(generatedNumbers);
        Balls user = new Balls(Arrays.asList(3, 9, 4));
        PlayResult play = BaseBallManager.play(computer, user);
        assertThat(play.getStrike()).isEqualTo(1);
        assertThat(play.getBall()).isEqualTo(1);
    }

    @Test
    void _2_스트라이크() {
        Balls computer = new Balls(generatedNumbers);
        Balls user = new Balls(Arrays.asList(3, 4, 6));
        PlayResult play = BaseBallManager.play(computer, user);
        assertThat(play.getStrike()).isEqualTo(2);
        assertThat(play.getBall()).isEqualTo(0);
    }

    @Test
    void _3_스트라이크() {
        Balls computer = new Balls(generatedNumbers);
        Balls user = new Balls(Arrays.asList(3, 4, 5));
        PlayResult play = BaseBallManager.play(computer, user);
        assertThat(play.getStrike()).isEqualTo(3);
        assertThat(play.getBall()).isEqualTo(0);
    }

    @Test
    void _2_볼() {
        Balls computer = new Balls(generatedNumbers);
        Balls user = new Balls(Arrays.asList(4, 3, 9));
        PlayResult play = BaseBallManager.play(computer, user);
        assertThat(play.getStrike()).isEqualTo(0);
        assertThat(play.getBall()).isEqualTo(2);
    }

    @Test
    void _3_볼() {
        Balls computer = new Balls(generatedNumbers);
        Balls user = new Balls(Arrays.asList(5, 3, 4));
        PlayResult play = BaseBallManager.play(computer, user);
        assertThat(play.getStrike()).isEqualTo(0);
        assertThat(play.getBall()).isEqualTo(3);
    }
}
