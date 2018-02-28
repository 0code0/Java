package flow008;

import java.util.Scanner;

public class FLOW008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {

            int n = scanner.nextInt();

            if (n < 10) {
                System.out.println("What an obedient servant you are!");
            } else {
                System.out.println("-1");
            }

        }

    }

}
