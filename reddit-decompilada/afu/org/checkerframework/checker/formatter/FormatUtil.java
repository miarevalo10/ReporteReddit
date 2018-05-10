package afu.org.checkerframework.checker.formatter;

import afu.org.checkerframework.checker.formatter.qual.ConversionCategory;
import java.util.IllegalFormatConversionException;
import java.util.MissingFormatArgumentException;
import java.util.regex.Pattern;

public class FormatUtil {
    private static Pattern f4a = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");

    public static class ExcessiveOrMissingFormatArgumentException extends MissingFormatArgumentException {
        private final int f0a;
        private final int f1b;

        public String getMessage() {
            return String.format("Expected %d arguments but found %d.", new Object[]{Integer.valueOf(this.f0a), Integer.valueOf(this.f1b)});
        }
    }

    public static class IllegalFormatConversionCategoryException extends IllegalFormatConversionException {
        private final ConversionCategory f2a;
        private final ConversionCategory f3b;

        public String getMessage() {
            return String.format("Expected category %s but found %s.", new Object[]{this.f2a, this.f3b});
        }
    }
}
