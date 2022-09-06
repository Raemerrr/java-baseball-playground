package calculator.util;

public class StringAsInteger extends Number {

    private String text;

    protected StringAsInteger() {
        /* empty */
    }

    public StringAsInteger(final String text) {
        this.text = text;
    }

    public int intValue() {
        return Integer.parseInt(this.text);
    }

    @Override
    public long longValue() {
        return Long.parseLong(this.text);
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(this.text);
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(this.text);
    }
}
