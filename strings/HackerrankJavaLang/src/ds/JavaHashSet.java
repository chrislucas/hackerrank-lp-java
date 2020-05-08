package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * DONE
 * https://www.hackerrank.com/challenges/java-hashset/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * */

public class JavaHashSet {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static void solver() throws IOException {
        int cases = Integer.parseInt(reader.readLine());
        HashSet<String> names = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (cases>0) {
            names.add(reader.readLine());
            sb.append(String.format(cases == 1 ? "%d" : "%d\n", names.size()));
            cases--;
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
