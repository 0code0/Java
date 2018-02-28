/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bearandsegment;

import java.util.Scanner;

class BearandSegment {

    public static void main(String str[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = 0, numZero = 0;
        char ch = '1';
        while (--n >= 0) {
            String s = sc.next();
            s = s + '0';

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    if (numZero == 1) {
                        numZero++;

                        break;
                    }

                    temp++;
                } else if (temp != 0) {
                    numZero = 1;

                }
            }

            System.out.println(numZero == 1 ? "YES" : "NO");
            temp = 0;
            numZero = 0;
        }
    }
}
