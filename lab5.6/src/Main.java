import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BigInteger first = generateRandomBigInteger(10);

        BigInteger p1 = first.pow(2);

        BigInteger p2 = powerUsingMultiplication(first, 2);

        System.out.println(first);
        System.out.println("pow: " + p1);
        System.out.println("multiplication: " + p2);
    }
    private static BigInteger generateRandomBigInteger(int size) {
        Random random = new Random();
        StringBuilder string = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int r = random.nextInt(10);
            string.append(r);
        }
        return new BigInteger(string.toString());
    }

    private static BigInteger powerUsingMultiplication(BigInteger base, int pow) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < pow; i++) {
            result = result.multiply(base);
        }
        return result;
    }
}