package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    public static final int BALL_SIZE = 3;
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
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != BALL_SIZE) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
