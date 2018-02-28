/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smpair;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author singhj1
 */
public class SMPAIR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {

            int n = scanner.nextInt();
            int[] val = new int[n];
            for (int i = 0; i < n; i++) {

                val[i] = scanner.nextInt();

            }

            Arrays.sort(val);

            System.out.println(val[0] + val[1]);
        }

    }

}
