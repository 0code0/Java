/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textreplace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author singhj1
 */
public class TextReplace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String pathname = "C:\\Users\\singhj1\\Desktop\\text.txt";
        String pathname1 = "C:\\Users\\singhj1\\Desktop\\text1.txt";
       
        BufferedReader br = new BufferedReader(new FileReader(pathname));
        FileWriter writer = new FileWriter(pathname1);
        BufferedWriter bw = new BufferedWriter(writer);
        
        String file = br.readLine();
        br.close();
        System.out.println(file);
        System.out.println(file.replaceAll("A", "D"));
        String temp = file.replaceAll("A", "D");
        
        try {
            bw.write(temp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            bw.close();
        }
    }
    
}
