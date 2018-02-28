package flow013;

import java.util.Scanner;

public class FLOW013 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {

            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            if (((A > 0) && (B > 0) && (C > 0))) {

                if ((A + B + C) == 180) {
                    System.out.println("YES");
                } else {

                    System.out.println("NO");
                }
            } else {

                System.out.println("NO");
            }

        }

    }

}
