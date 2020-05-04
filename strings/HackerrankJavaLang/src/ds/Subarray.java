package ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DONE
 * https://www.hackerrank.com/challenges/java-negative-subarray/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * */

public class Subarray {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static int[] readInts(String delimiter, int size) throws IOException {
        String [] str = reader.readLine().split(delimiter);
        int [] numbers = new int[size];
        int i = 0;
        while (i < str.length) {
            numbers[i] = Integer.parseInt(str[i]);
            i++;
        }
        return numbers;
    }


    private static void solver() throws IOException {
        int sizeEnter = readInt();
        int [] numbers = readInts(" ", sizeEnter);
        int counter = 0;
        for (int i = 0; i < sizeEnter ; i++) {
            if (numbers[i] < 0)
                counter++;
            int sum = numbers[i];
            for (int k = i+1; k < sizeEnter ; k++) {
                sum += numbers[k];
                if (sum < 0)
                    counter++;
            }
        }
        System.out.println(counter);
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
