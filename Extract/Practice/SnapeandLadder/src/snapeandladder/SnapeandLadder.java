package snapeandladder;

import java.util.Scanner;

public class SnapeandLadder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int B = scanner.nextInt();
            int LS = scanner.nextInt();

            System.out.println(Math.sqrt((LS * LS) - (B * B)) + " " + Math.sqrt((B * B) + (LS * LS)));

        }

    }

}
