package calculator;

import util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {

    protected Calculator() {
        /* empty */
    }

    public static int run(final String input) {
        String data = StringUtils.removeConsecutiveWhitespaces(input);
        Map<Boolean, List<String>> splitNumberOperator = splitNumberOperator(StringUtils.splitDataWithDelimiter(data, " "));
        CalcNumbers calcNumbers = new CalcNumbers(splitNumberOperator.get(true));
        Operators operators = new Operators(splitNumberOperator.get(false));
        return calculate(calcNumbers, operators);
    }

    private static Map<Boolean, List<String>> splitNumberOperator(final List<String> splitData) {
        return splitData.stream()
                .collect(Collectors.partitioningBy(s -> splitData.indexOf(s) % 2 == 0));
    }

    private static int calculate(CalcNumbers calcNumbers, Operators operators) {
        if (calcNumbers.getSize() <= operators.getSize()) {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }
        while (calcNumbers.isNotFinish()) {
            Operator operator = operators.popFirst();
            int result = operator.calculate(calcNumbers.popFirst().getNumber(), calcNumbers.popFirst().getNumber());
            calcNumbers.addFirst(new CalcNumber(result));
        }
        return calcNumbers.popFirst().getNumber().intValue();
    }
}
