package solution.java.lookahead;

import solution.java.RegexUtils;

import java.util.regex.Pattern;

// https://stackoverflow.com/questions/2973436/regex-lookahead-lookbehind-and-atomic-groups

public class TestAtomicGroup {

    /**
     * Quando usamos Atomic groups a ENGINE para de realizar baktraking procurando
     * por MATCHING dentro do grupo assim que achar o primeiro MATCHING
     * */

    public static void main(String[] args) {
        // MATCHING
        RegexUtils.log(Pattern.compile("(?>goo|g00g)g?le"), "google");
        // MATCHIBNG
        RegexUtils.log(Pattern.compile("(?>goo|g00g)g?le"), "g00gle");

        // FALHA porque a REGEX encontra correspondencia na substring "in"
        RegexUtils.log(Pattern.compile("(?>in|insert)"), "insert");
    }
}
