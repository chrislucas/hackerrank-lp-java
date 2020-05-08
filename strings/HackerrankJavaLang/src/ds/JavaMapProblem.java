package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * DONE
 * https://www.hackerrank.com/challenges/phone-book/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * */

public class JavaMapProblem {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void solver() throws IOException {
        int cases = readInt();
        HashMap<String, String> map = new HashMap<>();
        while (cases>0) {
            map.put(reader.readLine(), reader.readLine());
            cases--;
        }
        String line = null;
        while ( (line = reader.readLine()) != null) {
            if (map.containsKey(line)) {
                System.out.printf("%s=%s\n", line, map.get(line));
            }
            else {
                System.out.println("Not found");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
