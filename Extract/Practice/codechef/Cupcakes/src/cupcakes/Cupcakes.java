/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcakes;

import java.util.Scanner;

/**
 *
 * @author 0code0
 */
public class Cupcakes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long N =0;
        while (t-- > 0) {

         N= scanner.nextLong();
         
         if(N==2){
             System.out.println(N);
         }else{
         
             System.out.println((int)Math.floor(N/2)+1);
         }
        }
    }

}
