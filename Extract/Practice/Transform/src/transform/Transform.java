package transform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Transform {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {

            String RPN = reader.readLine();
            String temp = "";
            String temp1 = "";
            for (int i = 0; i < RPN.length(); i++) {

                if (String.valueOf(RPN.charAt(i)).matches("[a-z]")) {

                    temp += RPN.charAt(i);

                } else if (RPN.charAt(i) == ')') {
                    temp += stack.pop();
                    temp1 += stack.pop();
                } else {

                    stack.push(RPN.charAt(i));
                }

            }

            System.out.println("---" + temp);
            System.out.println("Stack value" + stack);
        }

    }

}
