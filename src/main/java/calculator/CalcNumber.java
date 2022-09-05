package calculator;

import util.StringAsInteger;

public class CalcNumber {
    private Number number;

    protected CalcNumber() {
        /* empty */
    }

    public CalcNumber(final String number) {
        this(new StringAsInteger(number));
    }

    public CalcNumber(final Number number) {
        this.number = number;
    }

    public Number getNumber() {
        return this.number;
    }
}
