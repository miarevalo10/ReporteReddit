package com.googlecode.mp4parser.util;

import java.util.Date;

public class DateHelper {
    public static Date m7707a(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    public static long m7706a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
