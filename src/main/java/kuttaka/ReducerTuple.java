package kuttaka;

public class ReducerTuple {
    private Long divisor;
    private Long quotient;
    private Long reminder;

    public ReducerTuple(Long divisor, Long quotient, Long reminder) {
        this.divisor = divisor;
        this.quotient = quotient;
        this.reminder = reminder;
    }

    public Long getDivisor() {
        return divisor;
    }

    public Long getQuotient() {
        return quotient;
    }

    public Long getReminder() {
        return reminder;
    }
}
