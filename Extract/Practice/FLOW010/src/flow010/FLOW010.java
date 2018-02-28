package flow010;

import java.util.Scanner;

public class FLOW010 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int max = 0;
            for (int i = 2; i <= k; i++) {

                if (n % i > max) {
                    max = n % i;
                }
            }
            System.out.println(max);

        }

    }

}
