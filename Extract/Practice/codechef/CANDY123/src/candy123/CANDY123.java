package candy123;

import java.util.Scanner;

class CANDY123 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {

            int L = scanner.nextInt();
            int B = scanner.nextInt();
            int i = 1;
            while (true) {

                L -= i;
                B -= i + 1;

                if (L < 0) {

                    System.out.println("Bob");
                    break;
                } else if (B < 0) {
                    System.out.println("Limak");
                    break;

                } else if ((L == 0) && (B == 0)) {
                    System.out.println("Bob");
                    break;
                }
                i += 2;
            }
        }
    }

}
