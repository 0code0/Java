package candies;

import java.util.Scanner;

public class Candies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {

            int A = scanner.nextInt();
            int a = 0;
            int B = scanner.nextInt();

            for (int i = 1; i <= A; i += 2) {

                a += i;

            }
            if ((a - A) == 0) {
                System.out.println("Limak");
            } else {

                System.out.println("Bob");
            }

        }

    }

}
