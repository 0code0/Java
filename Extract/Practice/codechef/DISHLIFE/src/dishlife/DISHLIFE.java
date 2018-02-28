/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dishlife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DISHLIFE {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        int RootLoop = Integer.parseInt(reader.readLine());

        if (RootLoop > 0 && RootLoop < 11) {

            for (int i = 0; i < RootLoop; i++) {

                String[] NandK = reader.readLine().split(" ");
                if (NandK) {
                    outer_loop:
                    for (int j = 1; j <= Integer.parseInt(NandK[0]); j++) {

                        String[] Inputs = reader.readLine().split(" ");

                        for (int k = 1; k < Inputs.length; k++) {

                            if (NandK[1].equals(Inputs[k])) {

                                if ((Integer.parseInt(NandK[0]) - j) == 0) {
                                    flag = false;
                                    System.out.println("all");
                                    break outer_loop;
                                } else {
                                    flag = false;
                                    System.out.println("some");
                                    break outer_loop;
                                }

                            }

                        }

                    }
                }
                if (flag) {

                    System.out.println("sad");
                }
            }
        }
    }

}
