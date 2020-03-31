package solution.java.lookahead;


import solution.java.RegexUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.regular-expressions.info/lookaround.html
 *
 * PONTO MUITO IMPORANTE PARA ENTENDER COMO A ENGINE USA O LOOKAHEAD (POSITIVO E NEGATIVO)
 *
 * Seja uma REGEX R = q(?=ub?it) e uma String S = qubit, o interpretador ira procurar "q" seguido
 * de ub(0 ou 1x)it, mas nao ira adicionar o que segue "q" na resposta da reqex, ou seja a ENGINE
 * nao consome os caracteres que seguem "q".
 *
 * RECAPTULANDO, PROCURA POR UM PATTERN SEM ADICIONAR OS CARACTERES NO RESULTADO FINAL DA ANALISE.
 *
 * q(?=u)  -> procura por um 'q' seguido de um 'u' mas nao adiciona 'u' no resultado do matching se encontra-lo na string
 * de busca (exemplo quit ou qubit, a engine nao vai adicionar o 'u' no resultado final)
 *
 *
 *
 * Lookahead and Lookbehind are collectively called "lookaround" and also they are zero-legnth assertion
 * like "Start and End of Line (^$)" and "Start and end of word \\b" anchors.
 *
 * The difference between both is that lookaround  actually matches with characters, BUT THEN GIVES UP THE MATCH,
 * returning only the result: MATCH OR NOT
 *
 * This assertions do not consume chars in the string, just assert whether a match is possible or not.
 *
 *  LOOKAHEAD -> Means that  we want to  start search from right of initial position of assertion
 *  [ (?!). (?=)]
 * LOOKBEHIND -> Meand hat we want to start search from left of initial position of assertion
 * [(?<!), (?<=)]
 *
 * https://stackoverflow.com/questions/2973436/regex-lookahead-lookbehind-and-atomic-groups
 *
 * */


public class TestZeroLengthAssertions {


    // negative lookahead (?!regex)
    private static void negativeLookAhead() {
        Pattern patternThousandNumber = Pattern.compile("\\d(?!\\.)\\d{3}");
        RegexUtils.log(patternThousandNumber, "1000");

        Pattern patternImageTagHTML = Pattern.compile("<img ((?!src=).)* src=(\\S*) />" );
        RegexUtils.log(patternImageTagHTML, "<img border=1 src=image.jpg />");
        RegexUtils.log(patternImageTagHTML, "<img src=src=src=src=src=src=src />");
    }

    // positive lookahead (?=regex)
    private static void positiveLookAhead() {
        Pattern patternThousandNumber = Pattern.compile("\\d(?=.\\d{3})");
        RegexUtils.log(patternThousandNumber, "1.000");

        Pattern pattern = Pattern.compile("q(?=ub?it)");
        RegexUtils.log(pattern, "quit");
        RegexUtils.log(pattern, "qubit");
    }

    /**
     *  negative lookbehind (?<!)
     *  positive lookbehind (?<=)
     *
     *  Esses 2 tem o comportamento parecido com o LOOKAHEAD porem,  ele faz com a ENGINE
     *  olhe temporariamente para a posicao anterior do caracter que sucede a ASSERCAO ( ?<! ou ?<=)
     *  na STRING que se busca o PATTERN e faca o teste
     *
     *  (?<!a)b - ("ab") -> o caracter 'b' NAO SUCEDE 'a' ? Resposan: Nao regex falha
     *  (?<=a)b - ("ab") -> o caracter 'b' SUCEDE 'a' ? Resposan: 'b' b sucede a ou a precede b
     *
     * */

    private static void negativeLookBehind() {
        RegexUtils.log(Pattern.compile("qu(?<!i)te"), "quote");
        RegexUtils.log(Pattern.compile("c(?<!a)b"), "cob");
        RegexUtils.log(Pattern.compile("(?<!a)b"), "cob");
        RegexUtils.log(Pattern.compile("(?<!a)b"), "ob");
    }

    private static void positiveLookBehind() {
        String regex = "(?<=a)b";
        //RegexUtils.log(Pattern.compile("qu(?<=o)te"), "quote");
        //RegexUtils.log(Pattern.compile("c(?<=a)b"), "ab");
        RegexUtils.log(Pattern.compile(regex), "ab");
        RegexUtils.log(Pattern.compile(regex), "contrabando");
        RegexUtils.log(Pattern.compile(regex), "abominável");
    }

    public static void main(String[] args) {
        positiveLookBehind();
    }
}
