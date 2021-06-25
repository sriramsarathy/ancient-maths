package kuttaka;

public class ReducerTuple {
    private Long reminder;
    private Long divisor;
    private Long quotient;

    public ReducerTuple(Long reminder, Long divisor, Long quotient) {
        this.reminder = reminder;
        this.divisor = divisor;
        this.quotient = quotient;
    }

    public Long getReminder() {
        return reminder;
    }

    public Long getDivisor() {
        return divisor;
    }

    public Long getQuotient() {
        return quotient;
    }
}
