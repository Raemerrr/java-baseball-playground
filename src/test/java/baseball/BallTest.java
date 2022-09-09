package baseball;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void 스트라이크() {
        Ball b1 = new Ball(2, 1);
        Ball b2 = new Ball(2, 1);
        BallStatus ballStatus = b1.compare(b2);
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼() {
        Ball b1 = new Ball(0, 1);
        Ball b2 = new Ball(2, 1);
        BallStatus ballStatus = b1.compare(b2);
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 낫싱() {
        Ball b1 = new Ball(0, 1);
        Ball b2 = new Ball(0, 2);
        BallStatus ballStatus = b1.compare(b2);
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
