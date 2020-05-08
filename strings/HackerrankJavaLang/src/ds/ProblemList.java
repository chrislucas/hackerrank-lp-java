package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DONE
 * https://www.hackerrank.com/challenges/java-list/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 * */

public class ProblemList {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> readInts(String delimiter) throws IOException {
        String[] str = reader.readLine().split(delimiter);
        List<Integer> numbers = new ArrayList<>();
        int i = 0;
        while (i < str.length) {
            numbers.add( Integer.parseInt(str[i]));
            i++;
        }
        return numbers;
    }

    private static void solver() throws IOException {
        readInt();
        List<Integer> numbers = readInts(" ");
        int queries = readInt();
        while (queries>0) {
            String op = reader.readLine();
            if ("Insert".equals(op)) {
                String[] values = reader.readLine().split(" ");
                int index = Integer.parseInt(values[0]);
                int value = Integer.parseInt(values[1]);
                numbers.add(index, value);
            }
            else {
                numbers.remove(Integer.parseInt(reader.readLine()));
            }
            queries--;
        }
        for (int i=0; i< numbers.size(); i++) {
            System.out.printf(i == 0 ? "%d" : " %d", numbers.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
