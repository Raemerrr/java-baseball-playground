package baseball.ui;

import baseball.domain.BallStatus;
import baseball.domain.BaseBallManager;
import baseball.domain.PlayResult;

public class ResultView {
    public static void printPlayResult(PlayResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append(createBallString(result));
        sb.append(createStrikeString(result));
        sb.append(createNothingString(result));
        System.out.println(sb);
        isGameOver(result);
    }

    private static String createBallString(PlayResult result) {
        if (result.isNotEmptyBall()) {
            return result.getBall() + BallStatus.BALL.getDescription() + " ";
        }
        return "";
    }

    private static String createStrikeString(PlayResult result) {
        if (result.isNotEmptyStrike()) {
            return result.getStrike() + BallStatus.STRIKE.getDescription() + " ";
        }
        return "";
    }

    private static String createNothingString(PlayResult result) {
        if (result.isNothing()) {
            return BallStatus.NOTHING.getDescription();
        }
        return "";
    }

    private static void isGameOver(PlayResult result) {
        if (result.isGameOver()) {
            System.out.println(BaseBallManager.BALL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
