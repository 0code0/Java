package ambiguouspermutations;

import java.util.Scanner;

class AmbiguousPermutations {

    public boolean AmbiguousPermutation(int[] val) {
        int[] fin = new int[val.length];
        for (int i = 1; i <= val.length; i++) {

            for (int j = 0; j < val.length; j++) {

                if ((val[j] == i)) {

                    fin[i - 1] = j + 1;
                    break;

                }

            }

        }

        for (int i = 0; i < val.length; i++) {

            if (val[i] != fin[i]) {

                return false;

            }

        }

        return true;
    }

    public static void main(String[] args) {
        AmbiguousPermutations ambiguousPermutations = new AmbiguousPermutations();
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T != 0) {

            int[] n = new int[T];

            for (int i = 0; i < n.length; i++) {

                n[i] = scanner.nextInt();
            }

            System.out.println(ambiguousPermutations.AmbiguousPermutation(n) ? "ambiguous" : "not ambiguous");

            T = scanner.nextInt();
        }

    }

}
