package org.checkerframework.checker.regex;

import java.util.regex.PatternSyntaxException;
import org.checkerframework.dataflow.qual.Pure;

public final class RegexUtil {

    public static class CheckedPatternSyntaxException extends Exception {
        private final PatternSyntaxException f26753a;

        @Pure
        public String getMessage() {
            return this.f26753a.getMessage();
        }
    }
}
