package snakproc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import jdk.nashorn.internal.parser.TokenType;

public class SNAKPROC {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int len = Integer.parseInt(br.readLine());

            String value = br.readLine();

            if (value.contains("HH")) {
                System.out.println("Invalid");
            } else if (value.contains("TT")) {
                System.out.println("Invalid");
            } else if (value.charAt(0) == 'T') {
                System.out.println("Invalid");
            } else if (value.charAt(value.length() - 1) == 'H') {
                System.out.println("Invalid");
            } else {
                System.out.println("valid");
            }

        }

    }

}
