package baseball.domain;

import baseball.ui.GameOverView;
import baseball.ui.InputView;
import baseball.ui.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseBallManager {
    public static final int MIN_BALL_NUM = 1;
    public static final int MAX_BALL_NUM = 9;
    public static final int BALL_SIZE = 3;
    public static final int GAME_START_FLAG = 1;
    public static final int GAME_OVER_FLAG = 2;

    public static void run() {
        do {
            start();
        } while (GameOverView.isNotFinish(InputView.restartOrFinish()));
    }

    public static void start() {
        Balls computerBalls = new Balls(generateNumbers());
        PlayResult result;
        do {
            Balls userBalls = new Balls(InputView.createUserBalls());
            result = play(computerBalls, userBalls);
            ResultView.printPlayResult(result);
        } while (result.isNotGameOver());
    }

    public static PlayResult play(Balls computerBalls, Balls userBalls) {
        return computerBalls.inning(userBalls);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_BALL_NUM, MAX_BALL_NUM)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(BALL_SIZE)
                .collect(Collectors.toList());
    }
}
