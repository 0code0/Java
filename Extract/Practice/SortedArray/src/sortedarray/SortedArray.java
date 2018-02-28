package sortedarray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author 0code0
 */
public class SortedArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please Enter the Length of Keys");
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int keyLen = scanner.nextInt();
        int[] Key = new int[keyLen];
        //int[] freq = new int[freqLen];
        System.out.println("Please Enter the Keys");
        for (int i = 0; i < keyLen; i++) {

            Key[i] = scanner.nextInt();

        }
        System.out.println("Please Enter the Lenght of Freq");
        int freqLen = scanner.nextInt();
        System.out.println("Please Enter the Freq");
        for (int i = 0; i < freqLen; i++) {

            map.put(scanner.nextInt(), Key[i]);
        }

        Set<Entry<Integer, Integer>> set = map.entrySet();
        List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getKey()).compareTo(o1.getKey());
            }
        });
        int count = 1;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : list) {

            sum = sum + (entry.getKey() * count);
            count++;
        }
        System.out.println("The cost of tree is "+sum);

    }

}
