/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author singhj1
 */
public class ABCPath {

    String[][] grid2d;
    char alpha = 'A';
    int Count = 1;
    char temp = 'a';
    int Ai, Aj;

    public int length(String[] grid) {

        grid2d = new String[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length(); j++) {

                grid2d[i][j] = String.valueOf(grid[i].charAt(j));
            }

        }
        loop:
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length(); j++) {

                if (grid2d[i][j].equals(String.valueOf(alpha))) {
                    Ai = i;
                    Aj = j;
                    break loop;
                }

            }

        }
        
        while (!(Ai > grid.length || Aj > grid[0].length())) {

            ++alpha;
            if (grid2d[Ai + 1][Aj].equals(String.valueOf(alpha))) {

                Count++;
                Ai = Ai + 1;

            } else if (grid2d[Ai + 1][Aj + 1].equals(String.valueOf(alpha))) {

                Count++;
                Ai = Ai + 1;
                Aj = Aj + 1;

            } else if (grid2d[Ai][Aj + 1].equals(String.valueOf(alpha))) {

                Count++;
                Aj = Aj + 1;

            } else if (grid2d[Ai + 1][Aj - 1].equals(String.valueOf(alpha))) {
                Count++;
                Ai = Ai + 1;
                Aj = Aj - 1;
            }else{
            
                break;
            }

        }

        return Count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ABCPath aBCPath = new ABCPath();

        System.out.println(aBCPath.length(reader.readLine().split(",")));

    }

}
