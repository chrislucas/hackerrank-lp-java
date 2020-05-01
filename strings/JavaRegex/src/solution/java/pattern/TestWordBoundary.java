package solution.java.pattern;

import solution.java.RegexUtils;

import java.util.regex.Pattern;

public class TestWordBoundary {

    private static void testDifferenceNegativeCharSetAndNegativeLookbehinb() {
        // negative lookbehind
        Pattern pattern1 = Pattern.compile("\\b\\w+(?<!s)\\b");    // palavra terminada com
        // negation with character set
        Pattern pattern2 = Pattern.compile("\\b\\w+[^s]\\b");
        String name = "John's";

        RegexUtils.log(pattern1, name);
        RegexUtils.log(pattern2, name);
    }

    private static void simpleTest1() {
        RegexUtils.log(Pattern.compile("\\schris\\b"), " chris");
    }

    public static void main(String[] args) {
        testDifferenceNegativeCharSetAndNegativeLookbehinb();
    }
}
