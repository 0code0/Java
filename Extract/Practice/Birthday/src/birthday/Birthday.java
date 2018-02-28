/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author singhj1
 */
public class Birthday {

    int Count = 0;

    public int Rec(String val, int count) {
        Count = count;
        Count++;
        if (val.length() == 2) {
            return -1;
        }

        String sub = val.substring(0, val.length() / 2);
        String sub2 = val.substring((val.length() / 2), val.length());
        char a = sub.charAt(0);
        char b = sub2.charAt(0);
        int subCount = 0;
        int sub2Count = 0;

        for (int i = 0; i < sub.length(); i++) {

            if (sub.charAt(i) == a) {
                subCount++;
            }

            if (subCount == sub.length()) {

                return Count;
            }

        }

        for (int i = 0; i < sub2.length(); i++) {

            if (sub2.charAt(i) == b) {
                sub2Count++;
            }

            if (sub2Count == sub2.length()) {

                return Count;
            }
        }

                Rec(sub, Count);
                Rec(sub2, Count);
                
                return 0;

    }

    public static void main(String[] args) throws IOException {
        Birthday birthday = new Birthday();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            String temp = reader.readLine();
            if ((temp.length() % 2) == 0) {
                String val1 = temp.substring(0, temp.length() / 2);
                String val2 = temp.substring((temp.length() / 2), temp.length());
                int one = birthday.Rec(val1, 1);
                int two = birthday.Rec(val2, 1);

                if (one == two) {

                    System.out.println(two);
                } else if (one < two && one > 0 && two > 0) {

                    System.out.println(one);
                } else if (one > two && one > 0 && two > 0) {
                    System.out.println(one);
                } else if (one < 0) {

                    System.out.println(two);
                } else {
                    System.out.println(one);
                }

            } else {

                System.out.println("-1");
            }

        }

    }

}
