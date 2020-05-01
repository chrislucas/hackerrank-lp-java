package strings;

// DONE
// https://www.hackerrank.com/challenges/java-string-reverse/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {

    private static String readLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private static boolean isPalindrome(char[] str) {
        int limit = str.length / 2;
        for (int i = 0, j = str.length - 1; i < limit; i++, j--) {
            if (str[i] != str[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.printf("%s\n", isPalindrome(readLine().toCharArray()) ? "Yes" : "No");
    }
}
