package com.reddit.frontpage.presentation.formatter;

import com.reddit.frontpage.presentation.common.DateUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/presentation/formatter/RedditNumberFormatter;", "Lcom/reddit/frontpage/presentation/formatter/NumberFormatter;", "()V", "format", "", "count", "", "formatTime", "timestamp", "numValuesToShow", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditNumberFormatter.kt */
public final class RedditNumberFormatter implements NumberFormatter {
    public final String mo4823a(long j) {
        Object format;
        if (0 <= j) {
            if (999 >= j) {
                return String.valueOf(j);
            }
        }
        if (1000 <= j) {
            if (99999 >= j) {
                format = String.format("%.1fk", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / 1000.0f)}, 1));
                Intrinsics.m26843a(format, "java.lang.String.format(this, *args)");
                return format;
            }
        }
        if (100000 <= j) {
            if (999999 >= j) {
                format = String.format("%dk", Arrays.copyOf(new Object[]{Long.valueOf(j / 1000)}, 1));
                Intrinsics.m26843a(format, "java.lang.String.format(this, *args)");
                return format;
            }
        }
        if (1000000 <= j) {
            if (99999999 >= j) {
                format = String.format("%.1fm", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / 1000000.0f)}, 1));
                Intrinsics.m26843a(format, "java.lang.String.format(this, *args)");
                return format;
            }
        }
        format = String.format("%dm", Arrays.copyOf(new Object[]{Long.valueOf(j / 1000000)}, 1));
        Intrinsics.m26843a(format, "java.lang.String.format(this, *args)");
        return format;
    }

    public final String mo4824b(long j) {
        return DateUtil.m22704a(j * 1000, 1);
    }
}
