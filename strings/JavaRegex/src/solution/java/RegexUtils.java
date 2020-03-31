package solution.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static void log(Pattern pattern, String target) {
        System.out.printf("%s %s with pattern %s\n", target
                , pattern.matcher(target).matches() ? "Match" : "Not Match"
                , pattern.pattern()
        );
        showMatch(pattern.matcher(target));
    }

    private static void showMatch(Matcher matcher) {
        if (matcher.find()) {
            String line = "------------------------------------------------------";
            System.out.println(line);
            for (int i=0; i<matcher.groupCount(); i++) {
                String group = matcher.group(i);
                System.out.printf("Group: %s; Start: %d; End: %d\n",
                        group
                        , i
                        , group.length()
                );
            }
            if (matcher.groupCount() == 0) {
                System.out.printf("Group: %s; Start: %d; End: %d\n",
                        matcher.group()
                        , matcher.start()
                        , matcher.end()
                );
            }
            System.out.println(line);
        }
        else {
            System.out.println("Nothing to show");
        }
    }

}
