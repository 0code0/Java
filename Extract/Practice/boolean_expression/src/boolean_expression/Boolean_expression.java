package boolean_expression;

import java.util.Scanner;

public class Boolean_expression {

    
    public static int CountParenthesize(String[] symb, String[] oper, int n) {

        int[][] T = new int[n][n];
        int[][] F = new int[n][n];

        for (int i = 0; i < n; i++) {

            T[i][i] = (symb[i].equals("T")) ? 1 : 0;
            F[i][i] = (symb[i].equals("F")) ? 1 : 0;
        }
        for (int gap = 1; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                T[i][j] = F[i][j] = 0;
                for (int g = 0; g < gap; g++) {

                    int k = i + g;

                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k + 1][j] + F[k + 1][j];

                    if (oper[k].equals("&")) {
                        T[i][j] += T[i][k] * T[k + 1][j];
                        F[i][j] += (tik * tkj - T[i][k] * T[k + 1][j]);
                    }
                    if (oper[k].equals("|")) {
                        F[i][j] += F[i][k] * F[k + 1][j];
                        T[i][j] += (tik * tkj - F[i][k] * F[k + 1][j]);
                    }
                    if (oper[k].equals("^")) {
                        T[i][j] += F[i][k] * T[k + 1][j] + T[i][k] * F[k + 1][j];
                        F[i][j] += T[i][k] * T[k + 1][j] + F[i][k] * F[k + 1][j];
                    }
                }
            }
        }

        return T[0][n - 1];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String exp = scanner.next();

            String[] symbols = exp.split("\\^|\\||\\&");
            String[] operators = exp.replaceFirst("^T|F", "").split("T|F");
            
            System.out.println(CountParenthesize(symbols, operators, symbols.length));

        }

    }

}
