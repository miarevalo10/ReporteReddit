package org.threeten.bp.temporal;

import org.threeten.bp.DateTimeException;

public class UnsupportedTemporalTypeException extends DateTimeException {
    public UnsupportedTemporalTypeException(String str) {
        super(str);
    }
}
