import mymap.TestMap;
import sumabil.TestSumabil;

public class Test {

    private Test() { }

    public static void main(String[] args) {
        TestMap testMap = new TestMap();
        if (!testMap.passTest()) {
            System.out.println("Error in MyHashMap test");
        } else {
            System.out.println("Passed MyHashMap test");
        }

        TestSumabil testSumabil = new TestSumabil();
        if (!testSumabil.passTest()) {
            System.out.println("Error in Sumabil test");
        } else {
            System.out.println("Passed Sumabil test");
        }
    }
}
