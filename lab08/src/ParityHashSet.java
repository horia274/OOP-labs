import java.util.HashSet;

public class ParityHashSet extends HashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 1) {
            return false;
        }
        return super.add(integer);
    }
}
