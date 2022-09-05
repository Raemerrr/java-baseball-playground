package calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Operators {

    private Deque<Operator> operators;

    protected Operators() {
        /* empty */
    }

    public Operators(final List<String> operators) {
        this.operators = operators.stream()
                .map(Operator::new)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    public Operator popFirst() {
        if (this.operators.isEmpty()) {
            throw new IllegalArgumentException("operators is empty!!");
        }
        Operator operator = this.operators.getFirst();
        this.operators.removeFirst();
        return operator;
    }

    public int getSize() {
        return this.operators.size();
    }
}
