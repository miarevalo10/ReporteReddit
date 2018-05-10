package org.checkerframework.checker.formatter;

import java.util.IllegalFormatConversionException;
import java.util.MissingFormatArgumentException;
import java.util.regex.Pattern;
import org.checkerframework.checker.formatter.qual.ConversionCategory;

public class FormatUtil {
    private static Pattern f26752a = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");

    public static class ExcessiveOrMissingFormatArgumentException extends MissingFormatArgumentException {
        private final int f26748a;
        private final int f26749b;

        public String getMessage() {
            return String.format("Expected %d arguments but found %d.", new Object[]{Integer.valueOf(this.f26748a), Integer.valueOf(this.f26749b)});
        }
    }

    public static class IllegalFormatConversionCategoryException extends IllegalFormatConversionException {
        private final ConversionCategory f26750a;
        private final ConversionCategory f26751b;

        public String getMessage() {
            return String.format("Expected category %s but found %s.", new Object[]{this.f26750a, this.f26751b});
        }
    }
}
