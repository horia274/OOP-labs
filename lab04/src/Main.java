import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        PasswordMaker passwordMaker = new PasswordMaker("Horia");
        System.out.println(passwordMaker.getPassword() + "\n");

        SingletonPasswordMaker instance1, instance2;
        instance1 = SingletonPasswordMaker.getInstance();
        instance2 = SingletonPasswordMaker.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance1.getPassword() + "\n");

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(i);
        }
        MyImmutableArray myImmutableArray = new MyImmutableArray(arrayList);
        Collection imutableList = myImmutableArray.getArray();
        System.out.println(imutableList);

//        imutableList.add(1);
//        Exception in thread "main" java.lang.UnsupportedOperationException
//        at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1062)
//        at Main.main(Main.java:24)
    }
}

