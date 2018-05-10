package com.reddit.frontpage.presentation.common;

import com.instabug.library.model.State;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.Util;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.threeten.bp.Instant;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"H\u0007J)\u0010#\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b%J\u0018\u0010&\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0007J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006+"}, d2 = {"Lcom/reddit/frontpage/presentation/common/DateUtil;", "", "()V", "DAY", "", "getDAY", "()J", "HOUR", "getHOUR", "MAX_UNNORMALIZED", "MINUTE", "getMINUTE", "MONTH", "getMONTH", "YEAR", "getYEAR", "formatDateMMMdd", "", "timeInMillis", "locale", "Ljava/util/Locale;", "formatTime", "generateTimePostedLabel", "createdUtc", "includeDelimiter", "", "generateTimeRelativeToNow", "", "getRelativeTimeSpanString", "time", "now", "getTimeSince", "thenMillis", "numValuesToShow", "", "getTimeSinceAfterThreeTenInit", "nowMillis", "getTimeSinceAfterThreeTenInit$app_standardRelease", "isToday", "isYesterday", "normalizeToMillis", "timestampIsLessThan24HoursOld", "timestampUtc", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DateUtil.kt */
public final class DateUtil {
    public static final DateUtil f20370a = new DateUtil();
    private static final long f20371b = 60000;
    private static final long f20372c = 3600000;
    private static final long f20373d = 86400000;
    private static final long f20374e = 2592000000L;
    private static final long f20375f = 31536000000L;
    private static final long f20376g = 9999999999L;

    private DateUtil() {
    }

    public static final long m22703a(long j) {
        return j < f20376g ? j * 1000 : j;
    }

    public static CharSequence m22706b(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        j = TimeUnit.MILLISECONDS.convert(j, TimeUnit.SECONDS);
        currentTimeMillis = m22703a(currentTimeMillis);
        currentTimeMillis -= Math.min(currentTimeMillis, m22703a(j));
        if (currentTimeMillis < f20371b) {
            j = Util.m24027f((int) 2131886814);
            Intrinsics.m26843a((Object) j, "Util.getString(R.string.label_now)");
        } else {
            int i;
            if (currentTimeMillis < f20372c) {
                j = (int) (currentTimeMillis / f20371b);
                i = C1761R.string.fmt_relative_minute;
            } else if (currentTimeMillis < f20373d) {
                j = (int) (currentTimeMillis / f20372c);
                i = C1761R.string.fmt_relative_hour;
            } else if (currentTimeMillis < f20374e) {
                j = (int) (currentTimeMillis / f20373d);
                i = C1761R.string.fmt_relative_day;
            } else if (currentTimeMillis < f20375f) {
                j = (int) (currentTimeMillis / f20374e);
                i = C1761R.string.fmt_relative_month;
            } else {
                j = (int) (currentTimeMillis / f20375f);
                i = C1761R.string.fmt_relative_year;
            }
            j = Util.m23960a(i, Integer.valueOf(j));
            Intrinsics.m26843a((Object) j, "Util.getString(resId, count)");
        }
        return (CharSequence) j;
    }

    public static final String m22705a(long j, boolean z) {
        j = m22706b(j);
        if (!z) {
            return j.toString();
        }
        String f = Util.m24027f((int) C1761R.string.unicode_delimiter);
        z = new StringBuilder();
        z.append(f);
        z.append(j);
        return z.toString();
    }

    public static final String m22704a(long j, int i) {
        AndroidThreeTen.a(FrontpageApplication.f27402a);
        Object a = Period.a(ZonedDateTime.a(Instant.b(j), ZoneId.a()).b.d, ZonedDateTime.a(Instant.b(System.currentTimeMillis()), ZoneId.a()).b.d);
        StringBuilder stringBuilder = new StringBuilder();
        if (i > 0) {
            Intrinsics.m26843a(a, "period");
            if (a.b > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f25295a;
                Object format = String.format("%dy", Arrays.copyOf(new Object[]{Integer.valueOf(a.b)}, 1));
                Intrinsics.m26843a(format, "java.lang.String.format(format, *args)");
                stringBuilder.append(format);
                i--;
            }
        }
        if (i > 0) {
            Intrinsics.m26843a(a, "period");
            if (a.c > 0) {
                if ((((CharSequence) stringBuilder).length() > 0 ? 1 : 0) != 0) {
                    stringBuilder.append(' ');
                }
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f25295a;
                Object format2 = String.format("%dm", Arrays.copyOf(new Object[]{Integer.valueOf(a.c)}, 1));
                Intrinsics.m26843a(format2, "java.lang.String.format(format, *args)");
                stringBuilder.append(format2);
                i--;
            }
        }
        if (i > 0) {
            if ((((CharSequence) stringBuilder).length() > 0 ? 1 : 0) != 0) {
                stringBuilder.append(' ');
            }
            i = StringCompanionObject.f25295a;
            Object[] objArr = new Object[1];
            Intrinsics.m26843a(a, "period");
            objArr[0] = Integer.valueOf(a.d);
            a = String.format("%dd", Arrays.copyOf(objArr, 1));
            Intrinsics.m26843a(a, "java.lang.String.format(format, *args)");
            stringBuilder.append(a);
        }
        a = stringBuilder.toString();
        Intrinsics.m26843a(a, "sb.toString()");
        return a;
    }

    public static boolean m22709e(long j) {
        Object instance = Calendar.getInstance();
        instance.add(6, -1);
        Intrinsics.m26843a(instance, "yesterday");
        return com.reddit.frontpage.util.DateUtil.m23687e(j, instance.getTimeInMillis());
    }

    public static /* synthetic */ boolean m22710f(long j) {
        Object obj = Locale.getDefault();
        Intrinsics.m26843a(obj, "Locale.getDefault()");
        Intrinsics.m26847b(obj, State.KEY_LOCALE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", obj);
        return Intrinsics.m26845a(simpleDateFormat.format(Long.valueOf(j)), simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
    }

    public static /* synthetic */ String m22711g(long j) {
        Object obj = Locale.getDefault();
        Intrinsics.m26843a(obj, "Locale.getDefault()");
        Intrinsics.m26847b(obj, State.KEY_LOCALE);
        Object format = new SimpleDateFormat("MMM dd", obj).format(Long.valueOf(j));
        Intrinsics.m26843a(format, "dateFormat.format(timeInMillis)");
        return format;
    }

    public static /* synthetic */ String m22712h(long j) {
        Object obj = Locale.getDefault();
        Intrinsics.m26843a(obj, "Locale.getDefault()");
        Intrinsics.m26847b(obj, State.KEY_LOCALE);
        Object format = new SimpleDateFormat("hh:mm a", obj).format(Long.valueOf(j));
        if (format.length() > 0 && format.charAt(0) == '0') {
            Intrinsics.m26843a(format, "dateStr");
            if (format == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            format = format.substring(1);
            Intrinsics.m26843a(format, "(this as java.lang.String).substring(startIndex)");
        }
        Intrinsics.m26843a(format, "dateStr");
        return format;
    }

    public static boolean m22713i(long j) {
        return j < System.currentTimeMillis() - f20373d ? 1 : 0;
    }
}
