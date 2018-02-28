package cuttingrecipes;

import java.util.Scanner;

class CuttingRecipes {

    public int GCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return (GCD(b, a % b));
        }

    }

    public static void main(String[] args) {
        CuttingRecipes cr = new CuttingRecipes();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
        int GCD = 0;

            int N = scanner.nextInt();
            int[] val = new int[N];
            for (int i = 0; i < N; i++) {

                val[i] = scanner.nextInt();

            }

            for (int i = 0; i < val.length; i++) {

                GCD = cr.GCD(GCD, val[i]);
            }

            for (int i = 0; i < val.length; i++) {

                System.out.print(val[i] / GCD + " ");
            }
            System.out.println("");

        }

    }

}
