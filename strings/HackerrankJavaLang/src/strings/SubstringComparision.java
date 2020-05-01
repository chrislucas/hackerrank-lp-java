package strings;

// DONE
// https://www.hackerrank.com/challenges/java-string-compare/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubstringComparision {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String readLine() throws IOException {
        return reader.readLine();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readLine());
    }


    public static void main(String[] args) {
        try {
            String string = readLine();
            int sSubstring = readInt();

            String largest = string.substring(0, sSubstring);
            String smallest = string.substring(0, sSubstring);

            for (int i=1; i<string.length() - sSubstring + 1; i++) {
                String subs = string.substring(i, sSubstring + i);
                largest = (subs.compareTo(largest) > 0) ? subs : largest;
                smallest = (subs.compareTo(smallest) < 0) ? subs : smallest;
            }

            System.out.printf("%s\n%s", smallest, largest);

        } catch (IOException ignore) {}
    }
}
