package afu.plume;

import java.util.regex.PatternSyntaxException;

public final class RegexUtil {

    public static class CheckedPatternSyntaxException extends Exception {
        private final PatternSyntaxException f6a;

        public String getMessage() {
            return this.f6a.getMessage();
        }
    }
}
