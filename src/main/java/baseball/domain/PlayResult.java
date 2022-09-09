package baseball.domain;

public class PlayResult {
    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isNotEmptyStrike() {
        return this.strike > 0;
    }

    public boolean isNotEmptyBall() {
        return this.ball > 0;
    }

    public boolean isGameOver() {
        return strike == BaseBallManager.BALL_SIZE;
    }

    public boolean isNotGameOver() {
        return strike < BaseBallManager.BALL_SIZE;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            this.addStrike();
        }
        if (status.isBall()) {
            this.addBall();
        }
    }

    private void addStrike() {
        this.strike += 1;
    }

    private void addBall() {
        this.ball += 1;
    }
}
