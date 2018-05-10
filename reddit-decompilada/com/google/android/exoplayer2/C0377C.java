package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Util;
import java.util.UUID;

public final class C0377C {
    public static final int f3970a = (Util.f5283a < 23 ? 1020 : 6396);
    public static final UUID f3971b = new UUID(0, 0);
    public static final UUID f3972c = new UUID(1186680826959645954L, -5988876978535335093L);
    public static final UUID f3973d = new UUID(-1301668207276963122L, -6645017420763422227L);
    public static final UUID f3974e = new UUID(-7348484286925749626L, -6083546864340672619L);

    public static long m3540b(long j) {
        return j != -9223372036854775807L ? j == Long.MIN_VALUE ? j : j * 1000 : j;
    }

    public static long m3539a(long j) {
        if (j != -9223372036854775807L) {
            return j == Long.MIN_VALUE ? j : j / 1000;
        } else {
            return j;
        }
    }
}
