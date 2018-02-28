package luckfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LUCKFOUR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int Count = 0;
            String value = reader.readLine();

            for (int i = 0; i < value.length(); i++) {

                if (value.charAt(i) == '4') {
                    Count++;
                }

            }

            System.out.println(Count);

        }

    }

}
