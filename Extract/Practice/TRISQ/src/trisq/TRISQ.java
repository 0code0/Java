package trisq;

import java.util.Scanner;

public class TRISQ {

    public int Rec(int n) {

        if (n == 1) {
            return n;
        }

        return n + Rec(n - 1);

    }

    public static void main(String[] args) {
        TRISQ trisq = new TRISQ();
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int n = (scanner.nextInt() / 2) - 1;

            if (n > 0) {

                System.out.println(trisq.Rec(n));
            } else {
                System.out.println("0");
            }
        }

    }

}
