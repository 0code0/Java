/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumber;

import java.util.Scanner;

/**
 *
 * @author 0code0
 */
public class PrimeNumber {

    /**
     * @param args the command line arguments
     */
    static String prime(int a) {
        if(a==1){
            return "Not prime";
        }
        int m = a / 2;
        for (int i = 2; i <= m; i++) {

            if ((a % i) == 0) {
                return "Not prime";
               
            }

        }
        return "Prime";
    }

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {

            System.out.println(prime(scanner.nextInt()));
        }

    }

}
