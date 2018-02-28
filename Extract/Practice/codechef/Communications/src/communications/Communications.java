package communications;

import java.util.Scanner;

class Communications {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        while (T-- > 0) {
            int Count = 0;

            int R = scanner.nextInt();

            for (int i = 0; i < 3; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if ((x + y) <= R) {
                    Count++;
                }

            }

            if (Count == 3) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }

    }

}
