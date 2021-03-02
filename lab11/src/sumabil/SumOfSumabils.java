package sumabil;

import java.util.List;

public class SumOfSumabils {
    public <T extends Sumabil> T sumOfSumabils(List<T> sumabils, T sum) {
        if (sumabils == null || sumabils.size() == 0) {
            return null;
        }
        for (T sumabil : sumabils) {
            sum.addValue(sumabil);
        }
        return sum;
    }
}
