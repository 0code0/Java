package flow018;

import java.util.Scanner;

public class FLOW018 {

    public long REC(long n) {

        if (n == 1) {
            return n;
        }

        return n * REC((n - 1));
    }

    public static void main(String[] args) {
        FLOW018 flow018 = new FLOW018();
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            if (n == 0) {

                System.out.println("1");
            } else {

                System.out.println(flow018.REC(n));
            }

        }

    }

}
