package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// DONE
// https://www.hackerrank.com/challenges/java-arraylist/problem?h_r=next-challenge&h_v=zen

public class ProblemArrayList {

    private static final ArrayList<ArrayList<Integer>> table = new ArrayList<>();
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static Integer[] readInts(String delimiter) throws IOException {
        String[] str = reader.readLine().split(delimiter);
        Integer[] numbers = new Integer[str.length];
        int i = 0;
        while (i < str.length) {
            numbers[i] = Integer.parseInt(str[i]);
            i++;
        }
        return numbers;
    }


    private static void search(ArrayList<ArrayList<Integer>> tables, int line, int index) {
        if (line < tables.size() && index < tables.get(line).size()) {
            System.out.println(tables.get(line).get(index));
        } else {
            System.out.println("ERROR!");
        }
    }

    private static void solver() throws IOException {
        int lines = readInt();
        while (lines > 0) {
            Integer[] line = readInts(" ");
            ArrayList<Integer> memory = new ArrayList<>();
            Collections.addAll(memory, line);
            table.add(memory);
            lines--;
        }
        int queries = readInt();
        while (queries > 0) {
            Integer[] line = readInts(" ");
            search(table, line[0] - 1, line[1]);
            queries--;
        }
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
