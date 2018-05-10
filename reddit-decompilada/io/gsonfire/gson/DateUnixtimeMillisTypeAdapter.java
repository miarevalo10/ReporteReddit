package io.gsonfire.gson;

import java.util.Date;

public class DateUnixtimeMillisTypeAdapter extends DateUnixtimeTypeAdapter {
    public DateUnixtimeMillisTypeAdapter(boolean z) {
        super(z);
    }

    protected final long mo6605a(Date date) {
        return date.getTime();
    }

    protected final Date mo6606a(long j) {
        return new Date(j);
    }
}
