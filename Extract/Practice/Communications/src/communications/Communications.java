package communications;

import java.util.Scanner;

public class Communications {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int count = 0;
            int R = scanner.nextInt();

            int[] X = new int[3];
            int[] Y = new int[3];

            for (int i = 0; i < X.length; i++) {
                X[i] = scanner.nextInt();
                Y[i] = scanner.nextInt();
            }

            if (Math.sqrt(Math.pow((X[0] - X[1]), 2) + Math.pow((Y[0] - Y[1]), 2)) <= R) {

                count++;
            }
            if (Math.sqrt(Math.pow((X[1] - X[2]), 2) + Math.pow((Y[1] - Y[2]), 2)) <= R) {
                count++;

            }
            if (Math.sqrt(Math.pow((X[0] - X[2]), 2) + Math.pow((Y[0] - Y[2]), 2)) <= R) {
                count++;

            }

            if (count >= 2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}
