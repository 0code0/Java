/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumtrian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author 0code0
 */
public class SUMTRIAN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j <= i; j++) {

                    matrix[i][j] = scanner.nextInt();
                }
            }

            for (int i = n - 1; i >= 0; i--) {

                for (int j = 0; j < i; j++) {

                    if (matrix[i][j] > matrix[i][j + 1]) {
                        matrix[i - 1][j] = matrix[i][j] + matrix[i - 1][j];
                    } else {

                        matrix[i - 1][j] = matrix[i][j + 1] + matrix[i - 1][j];
                    }
                }
            }

            System.out.println(matrix[0][0]);
        }

    }

}
