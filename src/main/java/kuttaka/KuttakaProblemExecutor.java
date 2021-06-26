package kuttaka;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KuttakaProblemExecutor {

    public void execute() {
        for (AryabhataKuttakaLogic kuttakaProblem : getProblems()) {
            Map<Long, Long> result = getXandY(kuttakaProblem);
            System.out.println(" ---------");
            System.out.println("Y = ( "+ kuttakaProblem.getCoefficientX() + "X + "+ kuttakaProblem.getConstant() + ") / "+ kuttakaProblem.getCoefficientY() );
            System.out.println("X = " + result.entrySet().stream().findFirst().get().getKey() + ", Y = " + result.entrySet().stream().findFirst().get().getValue());
        }
    }

    private Map<Long, Long> getXandY(AryabhataKuttakaLogic kuttakaProblem) {
        Long X = kuttakaProblem.applyKuttaka();
        Long Y = ( kuttakaProblem.getCoefficientX() * X + kuttakaProblem.getConstant() ) / kuttakaProblem.getCoefficientY() ;
        return Map.of(X, Y);
    }

    private List<AryabhataKuttakaLogic> getProblems() {
        List<AryabhataKuttakaLogic> kuttakaProblemList = new ArrayList<>();
        kuttakaProblemList.add(new AryabhataKuttakaLogic(9L, 11L, 6L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(6L, 13L, 1L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(15L, 23L, 9L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(43L, 9L, 13L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(7L, 8L, 3L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(7L, 9L, 4L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(7L, 9L, 2L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(9L, 7L, 1L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(9L, 7L, 2L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(9L, 7L, 3L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(91L, 144L, 22L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(234L, 173L, 28L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(447L, 11L, 9L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(701L, 199L, 1L));
        kuttakaProblemList.add(new AryabhataKuttakaLogic(3175L, 1922L, 50L));

        return kuttakaProblemList;
    }
}
/**
 * Solutions:
 *  ---------
 * Y = ( 9X + 6) / 11
 * X = 3, Y = 3
 *  ---------
 * Y = ( 6X + 1) / 13
 * X = 2, Y = 1
 *  ---------
 * Y = ( 15X + 9) / 23
 * X = 4, Y = 3
 *  ---------
 * Y = ( 43X + 13) / 9
 * X = 2, Y = 11
 *  ---------
 * Y = ( 7X + 3) / 8
 * X = 3, Y = 3
 *  ---------
 * Y = ( 7X + 4) / 9
 * X = 2, Y = 2
 *  ---------
 * Y = ( 7X + 2) / 9
 * X = 1, Y = 1
 *  ---------
 * Y = ( 9X + 1) / 7
 * X = 3, Y = 4
 *  ---------
 * Y = ( 9X + 2) / 7
 * X = 6, Y = 8
 *  ---------
 * Y = ( 9X + 3) / 7
 * X = 2, Y = 3
 *  ---------
 * Y = ( 91X + 22) / 144
 * X = 14, Y = 9
 *  ---------
 * Y = ( 234X + 28) / 173
 * X = 130, Y = 176
 *  ---------
 * Y = ( 447X + 9) / 11
 * X = 5, Y = 204
 *  ---------
 * Y = ( 701X + 1) / 199
 * X = 44, Y = 155
 *  ---------
 * Y = ( 3175X + 50) / 1922
 * X = 454, Y = 750
 *
 */