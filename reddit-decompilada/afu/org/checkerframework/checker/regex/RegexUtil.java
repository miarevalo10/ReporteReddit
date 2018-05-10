package afu.org.checkerframework.checker.regex;

import java.util.regex.PatternSyntaxException;

public class RegexUtil {

    public static class CheckedPatternSyntaxException extends Exception {
        private final PatternSyntaxException f5a;

        public String getMessage() {
            return this.f5a.getMessage();
        }
    }
}
