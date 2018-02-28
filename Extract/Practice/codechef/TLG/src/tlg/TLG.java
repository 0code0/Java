/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tlg;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TLG {
    
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int Max = 0;
        int Min = 0;
        int val = t - 1;
        int[] lead = new int[t];
        int hold = 0;
        while (t-- > 0) {
            
            int S = scanner.nextInt();
            int T = scanner.nextInt();
            
            if ((S > 0) && (S <= 1000) && (T > 0) && (T <= 1000)) {
                int temp = S - T;
                lead[val - t] = hold + temp;
                hold = lead[val - t];
                
            }
        }
        
        for (int i = 0; i < lead.length; i++) {
            
            if (lead[i] > Max) {
                
                Max = lead[i];
            } else if (lead[i] < Min) {
                
                Min = lead[i];
            }
            
        }
        
        if (Max > Math.abs(Min)) {
            
            System.out.println("1"+" "+Max);
        } else {
            
            System.out.println("2"+ " "+Math.abs(Min));
        }        
        
    }
    
}
