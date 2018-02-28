package chefrout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFROUT {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String val = br.readLine();

            if (val.contains("SE")) {
                System.out.println("no");
            } else if (val.contains("EC")) {
                System.out.println("no");
            } else if (val.contains("SC")) {
                System.out.println("no");
            } else {

                System.out.println("yes");
            }

        }

    }

}
