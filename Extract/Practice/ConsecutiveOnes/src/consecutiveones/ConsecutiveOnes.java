/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consecutiveones;

import java.util.Scanner;

public class ConsecutiveOnes {

    public long get(long n, int k) {
        String comp = "";
        for (int i = 0; i < k; i++) {

            comp += "1";
        }
        long val = Long.parseLong(comp,2);
        
        while(val < n){
        
            comp+="0";
            val = Long.parseLong(comp,2);
        }
        return val;
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        ConsecutiveOnes ones = new ConsecutiveOnes();
        System.out.println(ones.get(scanner.nextLong(), scanner.nextInt()));
    }

}
