package baseball.validator;

public class InputValidator {

    private static final String OnlyNumberAndLimitLength = "[1-9]{3}";

    public static boolean isCorrected(String input) {
        return input.matches(OnlyNumberAndLimitLength);
    }
}
