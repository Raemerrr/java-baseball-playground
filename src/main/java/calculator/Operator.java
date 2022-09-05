package calculator;

public class Operator {

    private String operator;

    protected Operator() {
        /* empty */
    }

    public Operator(final String operator) {
        this.operator = operator;
    }

    public int calculate(final Number number1, final Number number2) {
        int result;
        switch (operator) {
            case "+":
                result = number1.intValue() + number2.intValue();
                break;
            case "-":
                result = number1.intValue() - number2.intValue();
                break;
            case "*":
                result = number1.intValue() * number2.intValue();
                break;
            case "/":
                result = number1.intValue() / number2.intValue();
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }
}
