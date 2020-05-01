package solution.java.pattern;

import java.util.regex.Pattern;

public class TestPatternClass {

    private static final String EVEN_NUMBER = "^\\d(\\d{1,2}|(\\.\\d{3}))*[02468]$";

    private static final Pattern PATTERN_EVEN_NUMBER = Pattern.compile(EVEN_NUMBER);

    private static final String FORMATTED_PATTERN_NUMBER = "^(\\d{1,3})(\\d{1,3})*$";

    private static void testPatternEvenNumber() {
        for (int i = 900; i < 10001; i++) {
            String valueOf = String.valueOf(i);
            boolean nonFormattedNumber = PATTERN_EVEN_NUMBER.matcher(valueOf).matches();
            String formattedValueOf = valueOf.replaceAll(FORMATTED_PATTERN_NUMBER, "$1.$2");
            boolean formattedNumber = PATTERN_EVEN_NUMBER.matcher(formattedValueOf).matches();

            System.out.printf("N_FORMATTED: %s - %s; FORMATTED: %s - %s\r\n",
                    valueOf
                    , nonFormattedNumber ? "Match" : "does not match"
                    , formattedValueOf
                    , formattedNumber ? "Match" : "does not match"
            );
        }
        System.out.println();
    }

    private static void testReplace() {
        String input = "christoffer christoffer christoffer";
        String replacement = "lucas";
        System.out.println(input.replace("toffer", replacement));
        System.out.println(input.replace("i", "1"));
        System.out.println(input.replaceFirst("toffer", replacement));
        System.out.println(input.replaceFirst("toffer$", replacement));
        // nao funciona com regex
        System.out.println(input.replace("toffer\\s", replacement));
        System.out.println(input.replaceAll("toffer\\s", replacement + " "));
        System.out.println(input.replaceAll("toffer\\b", replacement));
        System.out.println(input.replaceAll("\\Btoffer", replacement));
        System.out.println(input.replaceAll("[aeiou]", "*"));
        System.out.println(input.replaceAll("([a-z]{5})([a-z]{5})", "$1.$2").replace("toffer", replacement));
    }

    public static void main(String[] args) {
        testPatternEvenNumber();
    }
}
