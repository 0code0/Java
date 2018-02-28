package devisors;

import java.util.Scanner;

public class Devisors {

    static long printDivisors(long n) {

        long temp = 0;
        long finalCount = 0;
        long tempCount = 1;
        long tempCount2 = 1;
        long temp1 = 0;
        for (long a = 2; a <= n; a++) {
            temp1 = a;
            for (long i = 2; i <= a; i++) {

                while (temp1 % i == 0) {
                    temp1 = temp1 / i;
                    tempCount2++;
                }
                tempCount = (tempCount * tempCount2);
                tempCount2 = 1;

            }

            if (temp == tempCount) {
                finalCount++;
            }
            temp = tempCount;
            tempCount = 1;

        }

        return finalCount;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            long k = scanner.nextLong();
            System.out.println(printDivisors(k));
        }
        scanner.close();
    }

}
