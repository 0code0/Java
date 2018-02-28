/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implthread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 0code0
 */

class First extends Thread{
@Override    
public void run(){
    System.out.println("First Leg");
    
}

}

class Second extends Thread{
@Override    
public void run(){
    System.out.println("Second Leg");
    try {
        Thread.sleep(10);
    } catch (InterruptedException ex) {
        Logger.getLogger(Second.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}

class Third extends Thread{
@Override    
public void run(){
    try {
        Thread.sleep(10);
        System.out.println("Third Leg");
    } catch (InterruptedException ex) {
        Logger.getLogger(Third.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}


public class ImplThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(int i=0;i<=5;i++){
        First first = new First();
        Second second = new Second();
        Third  third = new Third();
        
        first.setName("first");
        second.setName("Second");
        third.setName("third");
        
        first.start();
        second.start();
        third.start();
        }
    }
    
}
