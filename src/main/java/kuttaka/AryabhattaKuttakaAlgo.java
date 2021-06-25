package kuttaka;

import java.util.*;

/**
 * y = (ax + c) / b , where a is coefficientX, b is coefficientY, c is constant
 * we use Aryabhatta's Kuttaka algorithm to find
 *
 * @author sriramsarathy
 */
public class AryabhattaKuttakaAlgo {
    private Long coefficientX;
    private Long coefficientY;
    private Long constant;

    public AryabhattaKuttakaAlgo(Long coefficientX, Long coefficientY, Long constant) {
        this.coefficientX = coefficientX;
        this.coefficientY = coefficientY;
        this.constant = constant;
    }

    private ReducerTuple divisionStep(Long dividend, Long divisor) {
        Long reminder = dividend % divisor;
        Long quotient = dividend / divisor;
        return new ReducerTuple(reminder, divisor, quotient);
    }

    public Stack<ReducerTuple> repeatedDivision() {
        Long dividend = coefficientX, divisor = coefficientY;
        Stack<ReducerTuple> reducerTuplesStack = new Stack<>();
        while (divisor != 0) {
            ReducerTuple reducerTuple = divisionStep(dividend, divisor);
            dividend = reducerTuple.getDivisor();
            divisor = reducerTuple.getReminder();
            reducerTuplesStack.push(reducerTuple);
        }
        return reducerTuplesStack;
    }

    /**
     * (constant ) / last divisor = p
     *
     * @param reducerTupleStack
     * @return creeper
     */
    public Long valli(Stack<ReducerTuple> reducerTupleStack) {
        ReducerTuple reducerTuple = reducerTupleStack.pop();
        Long m = reducerTuple.getReminder();
        Long p = constant / reducerTuple.getDivisor();
        Long creeper = reducerTuple.getQuotient() * m + p;
        int quotientCount = 1;
        while (!reducerTupleStack.isEmpty()) {
            creeper = reducerTuple.getQuotient() * m + p;
            p = m;
            m = creeper;
            reducerTuple = reducerTupleStack.pop();
            quotientCount++;
        }

        System.out.println("Quotient Count :" + quotientCount);
        return creeper > coefficientX ? creeper % coefficientX : creeper;
    }

    public Long getCoefficientX() {
        return coefficientX;
    }

    public Long getCoefficientY() {
        return coefficientY;
    }

    public Long getConstant() {
        return constant;
    }
}
