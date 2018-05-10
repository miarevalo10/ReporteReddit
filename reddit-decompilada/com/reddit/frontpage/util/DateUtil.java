package com.reddit.frontpage.util;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

public class DateUtil {
    @Deprecated
    public static long m23680a(long j) {
        return j < 9999999999L ? j * 1000 : j;
    }

    @Deprecated
    public static String m23682a(long j, TimeUnit timeUnit) {
        return m23681a(TimeUnit.MILLISECONDS.convert(j, timeUnit), System.currentTimeMillis());
    }

    @Deprecated
    public static String m23681a(long j, long j2) {
        j = m23680a(j);
        j2 = m23680a(j2);
        j2 -= Math.min(j2, j);
        if (j2 < 60000) {
            return FrontpageApplication.f27402a.getString(C1761R.string.label_now);
        }
        int i;
        if (j2 < 3600000) {
            j = (int) (j2 / 60000);
            i = C1761R.string.fmt_relative_minute;
        } else if (j2 < 86400000) {
            j = (int) (j2 / 3600000);
            i = C1761R.string.fmt_relative_hour;
        } else if (j2 < 2592000000L) {
            j = (int) (j2 / 86400000);
            i = C1761R.string.fmt_relative_day;
        } else if (j2 < 31536000000L) {
            j = (int) (j2 / 2592000000L);
            i = C1761R.string.fmt_relative_month;
        } else {
            j = (int) (j2 / 31536000000L);
            i = C1761R.string.fmt_relative_year;
        }
        return FrontpageApplication.f27402a.getString(i, new Object[]{Integer.valueOf(j)});
    }

    public static long m23683b(long j, long j2) {
        if (!m23686d(j, j2)) {
            return -1;
        }
        j = m23680a(j);
        j2 = m23680a(j2);
        j2 -= Math.min(j2, j);
        if (j2 < 3600000) {
            return 60000 - (j2 % 60000);
        }
        if (j2 < 86400000) {
            return 3600000 - (j2 % 3600000);
        }
        return 86400000 - (j2 % 86400000);
    }

    public static String m23685c(long j, long j2) {
        if (m23686d(j, j2)) {
            return m23681a(j, j2);
        }
        j = m23680a(j);
        j2 = m23680a(j2) - j;
        j = ZonedDateTime.a(Instant.b(j), ZoneId.a());
        if (j2 < 86400000) {
            j = j.a(DateTimeFormatter.a(Util.m24027f((int) C1761R.string.date_format_time), Locale.getDefault()));
        } else if (j2 < 31536000000L) {
            j = j.a(DateTimeFormatter.a(Util.m24027f((int) C1761R.string.date_format_day_month_time), Locale.getDefault()));
        } else {
            j = j.a(DateTimeFormatter.a(Util.m24027f((int) C1761R.string.date_format_day_month_year_time), Locale.getDefault()));
        }
        return j;
    }

    public static boolean m23686d(long j, long j2) {
        return m23680a(j2) - m23680a(j) < 86400000 ? 1 : 0;
    }

    public static CharSequence m23684b(long j) {
        return m23681a(TimeUnit.MILLISECONDS.convert(j, TimeUnit.SECONDS), System.currentTimeMillis());
    }

    public static boolean m23687e(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance2.setTime(new Date(j2));
        if (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) {
            return true;
        }
        return 0;
    }
}
