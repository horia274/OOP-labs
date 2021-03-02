import java.util.LinkedHashSet;

public class ParityLinkedHashSet extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 1) {
            return false;
        }
        return super.add(integer);
    }
}
