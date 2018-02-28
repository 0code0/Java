/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author singhj1
 */
public class Max {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());
        int temp, Max = 0;
        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());

            String[] val = reader.readLine().split(" ");

            for (String val1 : val) {
                for (String val2 : val) {
                    temp = Integer.parseInt(val1) % Integer.parseInt(val2);
                    if (temp > Max) {
                        Max = temp;
                    }
                }
            }

            System.out.println(Max);

        }

    }

}
