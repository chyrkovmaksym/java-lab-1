import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        byte[] inputValues = getInputValues(4);
        byte a = inputValues[0];
        byte n = inputValues[1];
        byte b = inputValues[2];
        byte m = inputValues[3];

        double result = calculateResults(a, n, b, m);
        System.out.println(result);
    }

    public static byte[] getInputValues(int size) {
        byte[] inputValues = new byte[size];
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a: ");
            inputValues[0] = scanner.nextByte();

            System.out.print("Enter n: ");
            inputValues[1] = scanner.nextByte();

            System.out.print("Enter b: ");
            inputValues[2] = scanner.nextByte();

            System.out.print("Enter m: ");
            inputValues[3] = scanner.nextByte();

            if (!checkLimits(inputValues)) {
                System.out.println("Invalid input. Incorrect limits. Try again!");
                return getInputValues(size);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Value must match a byte type. Try again!");
            return getInputValues(size);
        }
        return inputValues;
    }

    public static boolean checkLimits(byte[] inputValues) {
        return inputValues[0] <= inputValues[1] && inputValues[2] <= inputValues[3];
    }

    public static double calculateResults(byte a, byte n, byte b, byte m) throws Exception {
        double res = 0;

        for (byte i = a; i <= n; i++) {
            for (byte j = b; j <= m; j++) {
                if (i == 2) {
                    throw new Exception("Division by zero occurred");
                }
                res += (double) (i % j) / (i - 2);
            }
        }

        return res;
    }
}