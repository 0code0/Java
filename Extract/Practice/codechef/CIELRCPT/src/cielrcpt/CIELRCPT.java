package cielrcpt;

import java.util.Scanner;

class CIELRCPT {

    int[] list = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
    int temp, temp2;
    boolean flag = true;
    int Count = 0;

    public int Rec(int val, int count) {
        Count = count;
        if (val == 0) {
            return Count;
        }

        Count++;
        for (int i = 0; i < list.length; i++) {

            if (list[i] <= val) {
                temp = i;       //calculate the greater one

            }

        }

        return Rec(val - list[temp], Count);
    }

    public static void main(String[] args) {
        CIELRCPT cielrcpt = new CIELRCPT();

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int p = scanner.nextInt();

            if (p % 2 == 0) {
                System.out.println(cielrcpt.Rec(p, 0));
            } else {

                System.out.println(cielrcpt.Rec(p - 1, 0) + 1);
            }

        }

    }

}
