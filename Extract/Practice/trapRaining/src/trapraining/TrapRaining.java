/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trapraining;

import java.util.Scanner;

/**
 *
 * @author 0code0
 */
public class TrapRaining {

    /**
     * @param args the command line arguments
     */
    // Method for maximum amount of water
    static int findWater(int[] arr, int n) {

        int left[] = new int[n];

        int right[] = new int[n];

        int water = 0;

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        return water;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of bars");
        int len = scanner.nextInt();
        System.out.println("Enter the width of each bar");
        int[] WaterData = new int[len];

        for (int i = 0; i < len; i++) {

            WaterData[i] = scanner.nextInt();
        }

        System.out.println("We can tap " + findWater(WaterData, len) + " unit of water in the middle gap");
    }

}
