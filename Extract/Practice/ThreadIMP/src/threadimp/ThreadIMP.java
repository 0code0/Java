/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadimp;

/**
 *
 * @author singhj1
 */

class First extends Thread {

    @Override
    public void run() {
        System.out.println("leg 1");

    }

}

class Second extends Thread {

    @Override
    public void run() {
        System.out.println("leg 2");

    }

}

class Third extends Thread {

    @Override
    public void run() {
        System.out.println("leg 3");

    }

}

class Four extends Thread {

    @Override
    public void run() {
        System.out.println("leg 4");

    }

}

public class ThreadIMP {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        First first = new First();
        Second second = new Second();
        Third third = new Third();
        Four four = new Four();
        
        first.start();
        second.start();
        third.start();
        four.start();
    }

}
