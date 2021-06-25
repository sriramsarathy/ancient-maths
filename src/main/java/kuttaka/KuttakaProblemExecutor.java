package kuttaka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KuttakaProblemExecutor {

    public void execute() {
        for (AryabhattaKuttakaAlgo kuttakaProblem : getProblems()) {
            Map<Long, Long> result = getXandY(kuttakaProblem);
            System.out.println(" ---------");
            System.out.println("Y = ( "+ kuttakaProblem.getCoefficientX() + "X + "+ kuttakaProblem.getConstant() + ") / "+ kuttakaProblem.getCoefficientY() );
            System.out.println("X = " + result.entrySet().stream().findFirst().get().getKey() + ", Y = " + result.entrySet().stream().findFirst().get().getValue());
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
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(6L, 13L, 1L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(15L, 23L, 9L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(43L, 9L, 13L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(7L, 8L, 3L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(7L, 9L, 4L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(7L, 9L, 2L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(9L, 7L, 1L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(9L, 7L, 1L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(9L, 7L, 3L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(91L, 144L, 22L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(234L, 173L, 28L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(447L, 11L, 9L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(701L, 199L, 1L));
        kuttakaProblemList.add(new AryabhattaKuttakaAlgo(3175L, 1922L, 50L));


        return kuttakaProblemList;
    }
}
