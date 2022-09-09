package baseball.domain;

public enum BallStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    BallStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
