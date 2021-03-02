import java.util.Random;

public class PasswordMaker {
    final int MAGIC_NUMBER = 27;
    final String MAGIC_STRING = "abcdefghijklmnopqrstuvwxyz";
    String name;

    public PasswordMaker(String name) {
        this.name = name;
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
