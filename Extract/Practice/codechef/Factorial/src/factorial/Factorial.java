/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.util.Scanner;

/**
 *
 * @author 0code0
 */
public class Factorial {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int Total = scanner.nextInt();
        while (Total != 0) {
            int value = scanner.nextInt();
            int temp2 = 5;
            int temp = value / temp2;

            while (value > temp2*5) {

                temp += value / (temp2 * 5);
                temp2 =temp2 * 5;
            }
            Total--;
            System.out.println(temp);
            
        }
        
    }

}
