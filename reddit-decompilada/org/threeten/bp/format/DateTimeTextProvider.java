package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.temporal.TemporalField;

abstract class DateTimeTextProvider {
    public abstract String mo7849a(TemporalField temporalField, long j, TextStyle textStyle, Locale locale);

    DateTimeTextProvider() {
    }

    static DateTimeTextProvider m43159a() {
        return new SimpleDateTimeTextProvider();
    }
}
