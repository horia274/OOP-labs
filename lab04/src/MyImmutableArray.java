import java.util.ArrayList;
import java.util.Collections;
import java.util.Collection;

public class MyImmutableArray {
    ArrayList<Integer> immutableArray;

    public MyImmutableArray(ArrayList<Integer> immutableArray) {
        this.immutableArray = new ArrayList<>();
        for(Integer imutable : immutableArray) {
            this.immutableArray.add(imutable);
        }
    }

    public Collection<Integer> getArray() {
        return Collections.unmodifiableList(immutableArray);
    }
}
