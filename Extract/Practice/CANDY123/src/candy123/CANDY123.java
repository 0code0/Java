package candy123;

import java.util.Scanner;

public class CANDY123 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int L = scanner.nextInt();
            int B = scanner.nextInt();
            int temp = Math.max(L, B);
            
            for (int i = 1; i <= temp; i += 2) {

                L -= i;
                B -= i + 1;

                if (L < 0) {

                    System.out.println("Bob");
                    break;
                } else if (B < 0) {
                    System.out.println("Limak");
                    break;

                } else if ((B == 0) && (L == 0)) {

                    System.out.println("Bob");
                    break;
                }

            }

        }
    }

}
