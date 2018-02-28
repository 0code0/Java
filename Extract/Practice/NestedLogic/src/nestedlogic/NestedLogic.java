/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestedlogic;

import java.util.Scanner;

/**
 *
 * @author 0code0
 */
public class NestedLogic {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);

        String[] ActuallyDate = scanner.nextLine().split(" ");
        String[] ExpectedDate = scanner.nextLine().split(" ");
    
        int RD = Integer.parseInt(ActuallyDate[0]) - Integer.parseInt(ExpectedDate[0]);
        int RM = Integer.parseInt(ActuallyDate[1]) - Integer.parseInt(ExpectedDate[1]);
        int RY = Integer.parseInt(ActuallyDate[2]) - Integer.parseInt(ExpectedDate[2]);
        
        System.out.println( (RY > 0)? 1000: (RM > 0 && RY ==0)? RM*500 : (RD > 0 && RY==0)? RD *15:0 );
    }

}
