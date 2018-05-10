package com.reddit.frontpage.util;

import com.reddit.frontpage.C1761R;

public class CountUtil {
    public static String m23674a(long j) {
        if (j < 1000) {
            return String.valueOf(j);
        }
        if (j < 100000) {
            return Util.m23960a((int) C1761R.string.fmt_count_under_100k, Float.valueOf(((float) (j / 100)) / 1092616192));
        } else if (j < 1000000) {
            return Util.m23960a((int) C1761R.string.fmt_count_over_100k, Long.valueOf(j / 1000));
        } else if (j < 100000000) {
            return Util.m23960a((int) C1761R.string.fmt_count_over_1m, Float.valueOf(((float) (j / 100000)) / 1092616192));
        } else {
            return Util.m23960a((int) C1761R.string.fmt_count_over_100m, Long.valueOf(j / 1000000));
        }
    }
}
