package strings;

// DONE
// https://www.hackerrank.com/challenges/java-substring/problem?h_r=next-challenge&h_v=zen

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Substrings {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String readLine() throws IOException {
        return reader.readLine();
    }

    private static String[] readLine(String delim) throws IOException {
        return reader.readLine().split(delim);
    }

    private static int [] readInts() throws IOException {
        return Arrays.stream(readLine(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        try {
            String in = readLine();
            int [] indexes = readInts();
            System.out.println(in.substring(indexes[0],indexes[1]));
        } catch (IOException ignore) {}
    }
}
