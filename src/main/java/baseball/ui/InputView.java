package baseball.ui;

import baseball.validator.InputValidator;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> createUserBalls() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = scanner.nextLine();
        InputValidator.isOnlyNumberAndThreeDigitLimit(input);
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public static Integer restartOrFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = scanner.nextLine();
        InputValidator.isOnlyNumberAndOneDigitLimit(input);
        return input.chars()
                .mapToObj(Character::getNumericValue)
                .findFirst()
                .orElse(2);
    }
}
