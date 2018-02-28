package factor;

import java.util.Scanner;

public class Factor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int temp = scanner.nextInt();
        int c = 1;
        int n, temp1 = 0, finalCount = 0;
        for (int a = 2; a <= temp; a++) {

            n = a;
            for (int i = 2; i <= n; i++) {

                while (n % i == 0) {
                    n = n / i;
                    c++;
                }
                count = (count * c);
                c = 1;
            }

            if (temp1 == count) {
                finalCount++;
        System.out.println(temp + "---" + finalCount);
            }
            temp1 = count;

            count = 1;
        }

    }
}
