package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * DONE
 * https://www.hackerrank.com/challenges/java-stack/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * */
public class JavaStackProblem {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void solver() throws IOException {
        String line = null;
        while ( (line = reader.readLine()) != null ) {
            Stack<String> stack = new Stack<>();
            boolean error = false;
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[' || c == '{')
                    stack.push(String.valueOf(c));
                else {
                    if (!stack.isEmpty()) {
                        String top = stack.peek();
                        if (c == ')' && top.equals("(")
                                || c == ']' && top.equals("[")
                                || c == '}' && top.equals("{") )
                            stack.pop();
                        else
                            break;
                    }
                    else {
                        error = true;
                        break;
                    }
                }
            }
            if (error) {
                System.out.println(false);
            }
            else {
                System.out.printf("%s\n", stack.isEmpty());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
