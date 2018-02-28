/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author singhj1
 */
public class ABBA {
    
    private boolean _canObtain(String initial, String target) {
        if (initial.length() == target.length()) {
            return initial.equals(target);
        }
        char lastValue = target.charAt(target.length() - 1);
        String previous;
        if (lastValue == 'A') {
            previous = target.substring(0, target.length() - 1);
        } else { 
            previous = new StringBuffer(target.substring(0, target.length() - 1)).reverse().toString();
        }
        return _canObtain(initial, previous);
    }

    public String canObtain(String initial, String target) {
        if(_canObtain(initial, target)){
            return  "Possible";
        }else{
            return  "Impossible";
        }
        
    }

    public static void main(String[] args) throws IOException {
        ABBA abba = new ABBA();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(abba.canObtain(reader.readLine(), reader.readLine()));
    }
}
