package calculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static String input() {
        System.out.print("input >> ");
        return scanner.nextLine();
    }

    public static String removeConsecutiveWhitespaces(final String input) {
        String temp = input;
        while (temp.contains("  ")) {
            temp = temp.replaceAll(" {2}", " ");
        }
        return temp;
    }

    public static List<String> splitDataWithDelimiter(final String data, final String delimiter) {
        return Arrays.asList(data.split(delimiter));
    }
}
