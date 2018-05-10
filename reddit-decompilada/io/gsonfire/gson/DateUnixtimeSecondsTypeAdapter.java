package io.gsonfire.gson;

import java.util.Date;

public final class DateUnixtimeSecondsTypeAdapter extends DateUnixtimeTypeAdapter {
    public DateUnixtimeSecondsTypeAdapter(boolean z) {
        super(z);
    }

    protected final long mo6605a(Date date) {
        return date.getTime() / 1000;
    }

    protected final Date mo6606a(long j) {
        return new Date(j * 1000);
    }
}
