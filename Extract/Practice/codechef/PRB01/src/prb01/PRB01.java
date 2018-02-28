package prb01;

import java.util.Scanner;

public class PRB01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            boolean flag = true;
            int n = scanner.nextInt();

            for (int i = 2; i < n - 1; i++) {

                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}
