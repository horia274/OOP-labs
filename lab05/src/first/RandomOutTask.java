package first;
import java.util.Random;

public class RandomOutTask implements Task {
    public int randomInt;

    public RandomOutTask() {
        Random rand = new Random();
        randomInt = rand.nextInt(1000);
    }

    public void execute() {
        System.out.println("Random number: " + randomInt);
    }
}
