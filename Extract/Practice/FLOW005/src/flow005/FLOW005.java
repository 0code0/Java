/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flow005;

import java.util.Scanner;

/**
 *
 * @author singhj1
 */
public class FLOW005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int ans = 0, N = scanner.nextInt();

            ans += N / 100;
            N %= 100;

            ans += N / 50;
            N %= 50;

            ans += N / 10;
            N %= 10;

            ans += N / 5;
            N %= 5;

            ans += N / 2;
            N %= 2;

            ans += N / 1;

            System.out.println(ans);

        }

    }

}
