package chefrout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CHEFROUT {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            String val = br.readLine();

            if (val.charAt(0) == 'C') {

                String ans = val.contains("SE") ? "no" : "yes";

                System.out.println(ans);
            } else {

                System.out.println("no");
            }

        }

    }

}
