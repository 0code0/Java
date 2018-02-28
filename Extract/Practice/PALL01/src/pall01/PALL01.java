package pall01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PALL01 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {

            String number = reader.readLine();
            String newNumber = "";

            for (int i = number.length() - 1; i >= 0; i--) {

                newNumber += number.charAt(i);

            }

            if (number.equals(newNumber)) {
                System.out.println("wins");
            } else {
                System.out.println("losses");
            }

        }

    }

}
