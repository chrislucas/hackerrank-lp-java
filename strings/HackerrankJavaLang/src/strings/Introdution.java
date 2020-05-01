package strings;

// DONE
// https://www.hackerrank.com/challenges/java-strings-introduction/problem

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Introdution {

    private static String capitalize(String s1) {
        return String.format("%s", s1.substring(0, 1).toUpperCase().concat(s1.substring(1, s1.length())));
    }


    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = reader.readLine();
            String s2 = reader.readLine();
            System.out.printf("%d\n%s\n%s"
                    , s1.length() + s2.length()
                    , s1.compareTo(s2) > 0 ? "Yes" : "No"
                    , capitalize(s1).concat(" ").concat(capitalize(s2))
                    );
        } catch (IOException ignore) { }

    }
}
