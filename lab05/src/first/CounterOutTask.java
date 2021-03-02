package first;

public class CounterOutTask implements Task {
    public static int count = 0;

    public void execute() {
        count++;
        System.out.println("Counter is: " + count);
    }
}
