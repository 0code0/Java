package cuttingrecipes;

import java.util.Scanner;
import java.util.Arrays;

public class CuttingRecipes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {

            int N = scanner.nextInt();
            int[] val = new int[N];
            int[] temp = new int[N];
            int count = 0;
            String v1 = "", v2 = "";
            for (int i = 0; i < N; i++) {

                val[i] = scanner.nextInt();

            }

            System.arraycopy(val, 0, temp, 0, N);

            Arrays.sort(val);

            for (int i = 0; i < N; i++) {

                if ((val[i] % val[0]) == 0) {

                    count++;
                } else {

                    for (int j = 0; j < val.length; j++) {
                        v1 += val[j] + " ";
                    }
                    System.out.println(v1);
                }

            }

            if (count == val.length) {
                for (int i = 0; i < N; i++) {
                    v2 += temp[i] / val[0] + " ";
                }
                System.out.println(v2);
            }

        }

    }

}
