package kuttaka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KuttakaProblemExecutor {

    public void execute() {
        for (AryabhattaKuttakaAlgo kuttakaProblem : getProblems()) {
            Map<Long, Long> result = getXandY(kuttakaProblem);
            System.out.println(" ---- Problem -----");
            System.out.println("X = " + result.entrySet().stream().findFirst().get().getKey());
            System.out.println("Y = ( aX + c ) / b");
            System.out.println("Y = " + result.entrySet().stream().findFirst().get().getValue());
        }

    }

    private Map<Long, Long> getXandY(AryabhattaKuttakaAlgo kuttakaProblem) {
        Long X = kuttakaProblem.valli(kuttakaProblem.repeatedDivision());
        Long Y = ( kuttakaProblem.getCoefficientX() * X + kuttakaProblem.getConstant() ) / kuttakaProblem.getCoefficientY() ;
        return Map.of(X, Y);
    }

    private List<AryabhattaKuttakaAlgo> getProblems() {
        List<AryabhattaKuttakaAlgo> kuttakaProblemList = new ArrayList<>();
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(9L, 11L, 6L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(7L, 9L, 4L));
        return kuttakaProblemList;
    }
}
