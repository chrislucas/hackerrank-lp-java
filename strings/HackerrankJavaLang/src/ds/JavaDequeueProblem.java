package ds;

import strings.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedHashSet;

/**
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 */

public class JavaDequeueProblem {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static Integer[] readIntegers(String delimiter) throws IOException {
        String[] line = reader.readLine().split(delimiter);
        Integer[] numbers = new Integer[line.length];
        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }
        return numbers;
    }


    private static void solver() throws IOException {
        Integer[] params = readIntegers(" ");
        int size = params[0];
        int maxSubArraySize = params[1];
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        Integer[] values = readIntegers(" ");
        Collections.addAll(numbers, values);
        LinkedHashSet<Integer> set = null;
        int rs = 0;
        for (int i = 0; i < size - maxSubArraySize + 1; i++) {
            Integer a = numbers.removeFirst();
            set = new LinkedHashSet<>();
            set.add(a);
            int step = 0;
            for (int j = 1; j < maxSubArraySize; j++) {
                a = numbers.removeFirst();
                if (!set.contains(a)) {
                    set.add(a);
                } else {
                    //step = j;
                    numbers.addFirst(a);
                    break;
                }
            }
            if (set.size() > rs)
                rs = set.size();

            if (i < size - maxSubArraySize) {
                Integer[] array = new Integer[set.size()];
                set.toArray(array);
                for (int k = array.length - 1; k > 0; k--) {
                    numbers.addFirst(array[k]);
                }
            }
            //i += step;
        }
        //System.out.println(rs);
        IO.writeOutput(String.format("raw/%s_output", JavaDequeueProblem.class.getName().toLowerCase()), String.valueOf(rs));
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
