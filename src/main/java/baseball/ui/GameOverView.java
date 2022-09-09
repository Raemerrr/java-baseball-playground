package baseball.ui;

import baseball.domain.BaseBallManager;

public class GameOverView {

    public static boolean isNotFinish(int flag) {
        return flag != BaseBallManager.GAME_OVER_FLAG;
    }
}
