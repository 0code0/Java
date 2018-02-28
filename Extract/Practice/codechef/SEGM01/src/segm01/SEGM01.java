/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segm01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 0code0
 */
public class SEGM01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            String val = reader.readLine();
            String count = "";
            int Count = 0;
            int j = 0;
            boolean flag = true;
            for (int i = 0; i < val.length(); i++) {

                if (val.charAt(i) == '1') {
                    count += i + ",";

                } else {
                    Count++;
                }

            }

            String[] temp = count.split(",");

            if (Count == val.length()) {
                System.out.println("NO");
            } else {
                for (int i = Integer.parseInt(temp[0]); i < (temp.length + Integer.parseInt(temp[0])); i++) {

                    if (Integer.parseInt(temp[j]) != i) {
                        flag = false;
                        System.out.println("NO");
                        break;
                    }
                    j++;
                }

                if (flag) {
                    System.out.println("YES");
                }
            }
        }

    }

}
