package baseball.validator;

import baseball.domain.BaseBallManager;

public class InputValidator {

    private static final String OnlyNumberAndThreeDigitLimit = "[" + BaseBallManager.MIN_BALL_NUM + "-" + BaseBallManager.MAX_BALL_NUM + "]{" + BaseBallManager.BALL_SIZE + "}";
    private static final String OnlyNumberAndOneDigitLimit = "[" + BaseBallManager.GAME_START_FLAG + "-" + BaseBallManager.GAME_OVER_FLAG + "]";

    public static void isOnlyNumberAndThreeDigitLimit(String input) {
        if (!input.matches(OnlyNumberAndThreeDigitLimit)) {
            throw new IllegalArgumentException(BaseBallManager.MIN_BALL_NUM + " ~ " + BaseBallManager.MAX_BALL_NUM + " 사이의 " + BaseBallManager.BALL_SIZE + "자리 숫자만 입력 가능합니다.");
        }
    }

    public static void isOnlyNumberAndOneDigitLimit(String input) {
        if (!input.matches(OnlyNumberAndOneDigitLimit)) {
            throw new IllegalArgumentException(BaseBallManager.GAME_START_FLAG + " ~ " + BaseBallManager.GAME_OVER_FLAG + " 사이의 1자리 숫자만 입력 가능합니다.");
        }
    }
}
