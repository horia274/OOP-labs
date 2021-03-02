import java.util.Random;

public class SingletonPasswordMaker {
    static SingletonPasswordMaker instance;
    static int count;
    final int MAGIC_NUMBER = 27;
    final String MAGIC_STRING = "abcdefghijklmnopqrstuvwxyz";
    String name = "Horia";

    static {
        instance = new SingletonPasswordMaker();
    }

    private SingletonPasswordMaker() {}

    public static SingletonPasswordMaker getInstance() {
        count++;
        if (instance == null) {
            instance = new SingletonPasswordMaker();
        }
        return instance;
    }

    public String getPassword() {
        StringBuilder sb = new StringBuilder();
        RandomStringGenerator randomAlphabet = new RandomStringGenerator(10, MAGIC_STRING);
        RandomStringGenerator randomString = new RandomStringGenerator(MAGIC_NUMBER, randomAlphabet.next());
        Random random = new Random();
        int randomInt = random.nextInt(101);

        sb.append(randomString.next());
        sb.append(String.valueOf(name.length()));
        sb.append(String.valueOf(randomInt));
        return sb.toString();
    }
}
