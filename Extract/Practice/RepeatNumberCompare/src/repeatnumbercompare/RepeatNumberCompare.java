/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repeatnumbercompare;

import java.math.BigInteger;
import java.util.Scanner;

public class RepeatNumberCompare {

    public String Repeat(String x1, int x) {
        String temp = x1;
        for (int i = 1; i < x; i++) {

            x1 += temp;
        }
        return x1;
    }

    public String compare(int x1, int k1, int x2, int k2) {

        BigInteger v1 = new BigInteger(Repeat(String.valueOf(x1), k1));
        BigInteger v2 = new BigInteger(Repeat(String.valueOf(x2), k2));

        switch (v1.compareTo(v2)) {
            case 0:
                return "Equal";
            case 1:
                return "Greater";
            default:
                return "Less";
        }
    }

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RepeatNumberCompare compare = new RepeatNumberCompare();
        System.out.println(compare.compare(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));

    }

}
