package kuttaka;

import java.util.*;

/**
 *  * Credits :
 *  * Badri Sheshadri | Twitter Handle : https://twitter.com/bseshadri
 */

/**
 * y = (ax + c) / b , where a is coefficientX, b is coefficientY, c is constant
 * we use Aryabhata's Kuttaka algorithm to find the integer solutions
 *
 * @author sriramsarathy
 */
public class AryabhataKuttakaLogic {
    private Long coefficientX;
    private Long coefficientY;
    private Long constant;

    public AryabhataKuttakaLogic(Long coefficientX, Long coefficientY, Long constant) {
        this.coefficientX = coefficientX;
        this.coefficientY = coefficientY;
        this.constant = constant;
    }

    public Long applyKuttaka() {
        return valli(repeatedDivision());
    }

    private ReducerTuple divisionStep(Long dividend, Long divisor) {
        Long reminder = dividend % divisor;
        Long quotient = dividend / divisor;
        return new ReducerTuple(divisor, quotient, reminder);
    }

    private Stack<ReducerTuple> repeatedDivision() {
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
     * (m * reminder + constant ) / last_divisor = p
     *
     * @param reducerTupleStack
     * @return creeper
     */
    private Long valli(Stack<ReducerTuple> reducerTupleStack) {
        ReducerTuple reducerTuple = reducerTupleStack.pop();
        Long m = reducerTuple.getReminder();

        /**
         *  Special case when last divisor is and there are odd number of quotients
         *  Stop before the last step and re-calculate m & p .
         */
        if ((reducerTupleStack.size() % 2 != 0) && reducerTuple.getDivisor() == 1) {
            reducerTuple = reducerTupleStack.pop();
            m = reducerTuple.getDivisor() - (constant % reducerTuple.getDivisor()) ;

        }
        //initialize before the valli steps
        Long p = (m + constant )/ reducerTuple.getDivisor();
        Long creeper = reducerTuple.getQuotient() * m + p;
        int evenQuotients = reducerTupleStack.size() - (reducerTupleStack.size() % 2);

        /** Creeper logic **/
        while (--evenQuotients >= 0) {
            creeper = reducerTuple.getQuotient() * m + p;
            p = m;
            m = creeper;
            reducerTuple = reducerTupleStack.pop();
        }

        // To get the first integer (X) which solves the equation.
        return creeper > coefficientY ? creeper % coefficientY : creeper;
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
