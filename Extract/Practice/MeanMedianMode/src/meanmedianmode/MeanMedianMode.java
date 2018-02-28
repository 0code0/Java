/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meanmedianmode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author 0code0
 */
public class MeanMedianMode {

    /**
     * @param args the command line arguments
     */
    static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Map<Integer, Integer> map = new HashMap<>();
        Scanner s = new Scanner(System.in);
        int[] N = new int[s.nextInt()];
        float mean = 0;
        int count = 0;
        for (int i = 0; i < N.length; i++) {
            int t = s.nextInt();
            N[i] = t;
            map.put(t, 0);
        }
        sort(N);

        for (int i = 0; i < N.length; i++) {
            mean += N[i];
        }
        System.out.println(mean);

        if ((N.length % 2) == 0) {
            int d = N.length / 2;
            float t = (N[d] + N[d - 1]) / 2;
            System.out.println(t);

        } else {
            System.out.println(N[N.length / 2]);

        }

        for (int i = 0; i < N.length; i++) {

            if (map.containsKey(N[i])) {
                map.put(N[i], map.get(N[i]) + 1);
            }

        }

    }

}
