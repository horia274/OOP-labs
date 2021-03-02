import java.util.TreeSet;

public class ParityTreeSet extends TreeSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 1) {
            return false;
        }
        return super.add(integer);
    }
}
