import java.util.Scanner;

public class Askisi3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ask two numbers
        System.out.print("Give first number: ");
        int a = scanner.nextInt();

        System.out.print("Give second number: ");
        int b = scanner.nextInt();

        // check numbers
        if (a < 0 || b < 0) {
            System.out.println("Wrong data. Numbers must be possitive.");
            scanner.close();
            return;
        }

        // GCD simple method
        int gcd1 = megistosDieretis(a, b);
        System.out.println("greatest common divisor (GCD) of these two numbers: " + gcd1);

        // GCD Euclidian
        int gcd2 = euklidis(a, b);
        System.out.println("greatest common divisor using Euclid's algorithm: " + gcd2);

        scanner.close();
    }

    // Simple greatest common divisor
    public static int megistosDieretis(int a, int b) {
        int min = Math.min(a, b);
        int gcd = 1;

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }

    // greatest common divisor using Euclid's
    public static int euklidis(int a, int b) {
        if (a == b) return a;
        if (a > b) return euklidis(a - b, b);
        else return euklidis(a, b - a);
    }
}