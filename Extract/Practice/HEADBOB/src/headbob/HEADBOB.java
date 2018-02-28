package headbob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HEADBOB {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {

            String temp = reader.readLine();

            String val = reader.readLine();
            int Count = 0;
            boolean flag = true;
            for (int i = 0; i < val.length(); i++) {

                if (val.charAt(i) == 'I') {
                    System.out.println("INDIAN");
                    flag = false;
                    break;
                } else if (val.charAt(i) == 'N') {
                    Count++;
                }

            }

            if (flag && (Count == val.length())) {

                System.out.println("NOT SURE");
            } else if (flag && (Count != val.length())) {
                System.out.println("NOT INDIAN");
            }
        }

    }

}
