package cylinder;

import java.util.Scanner;

public class Cylinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] elements = new int[n];
        boolean flag = true;
        for (int i = 0; i < n; i++) {

            elements[i] = scanner.nextInt();
        }
        int volume = scanner.nextInt();

        for (int i = 0; i < elements.length; i++) {

            for (int j = 0; j < elements.length; j++) {
                
                
                if ((22 * elements[i] * elements[i] * elements[j]) == volume*7) {

                    System.out.println(elements[i] + " " + elements[j]);
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            System.err.println("No such combination exists");
        }
    }

}
