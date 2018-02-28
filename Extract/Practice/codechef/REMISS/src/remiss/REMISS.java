package remiss;

import java.util.Scanner;

public class REMISS {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int A = scanner.nextInt();
            int B = scanner.nextInt();

            System.out.println(Math.max(A, B) + " " + (A + B));
        }

    }

}
