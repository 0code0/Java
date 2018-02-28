package fsqrt;

import java.util.Scanner;

public class FSQRT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {

            System.out.println((int) Math.sqrt(scanner.nextInt()));

        }

    }

}
