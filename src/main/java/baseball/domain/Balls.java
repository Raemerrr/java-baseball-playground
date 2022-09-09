package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        checkDuplicateNumbers(numbers);
        this.balls = IntStream.range(0, numbers.size())
                .mapToObj(i -> new Ball(i, numbers.get(i)))
                .collect(Collectors.toList());
    }

    public BallStatus play(Ball otherBall) {
        return this.balls.stream()
                .map(ball -> ball.compare(otherBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult inning(Balls otherBalls) {
        PlayResult result = new PlayResult();
        for (Ball ball : this.balls) {
            BallStatus status = otherBalls.play(ball);
            result.report(status);
        }
        return result;
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != BaseBallManager.BALL_SIZE) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
