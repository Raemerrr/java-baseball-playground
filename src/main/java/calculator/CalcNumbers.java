package calculator;

import calculator.util.StringAsInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class CalcNumbers {

    private Deque<CalcNumber> calcNumbers;

    protected CalcNumbers() {
        /* empty */
    }

    public CalcNumbers(final List<String> list) {
        this.calcNumbers = list.stream()
                .map(StringAsInteger::new)
                .map(CalcNumber::new)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public CalcNumber popFirst() {
        if (this.calcNumbers.isEmpty()) {
            throw new IllegalArgumentException("calcNumbers is empty!!");
        }
        CalcNumber calcNumber = this.calcNumbers.getFirst();
        this.calcNumbers.removeFirst();
        return calcNumber;
    }

    public void addFirst(final CalcNumber calcNumber) {
        calcNumbers.addFirst(calcNumber);
    }

    public boolean isNotFinish() {
        return 1 < calcNumbers.size();
    }

    public int getSize() {
        return calcNumbers.size();
    }
}
