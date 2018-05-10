package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.util.Assertions;

public abstract class Timeline {
    public static final Timeline f4081a = new C11261();

    public static final class Period {
        public Object f4060a;
        public Object f4061b;
        public int f4062c;
        public long f4063d;
        long f4064e;
        long[] f4065f;
        int[] f4066g;
        int[] f4067h;
        long f4068i;
        private int[] f4069j;
        private long[][] f4070k;

        public final int m3622a() {
            return this.f4065f == null ? 0 : this.f4065f.length;
        }

        public final boolean m3625a(int i) {
            return this.f4066g[i] != -1 && this.f4067h[i] == this.f4066g[i];
        }

        public final int m3623a(long j) {
            if (this.f4065f == null) {
                return -1;
            }
            int length = this.f4065f.length - 1;
            while (length >= 0 && (this.f4065f[length] == Long.MIN_VALUE || this.f4065f[length] > j)) {
                length--;
            }
            if (length < 0 || m3625a(length) != null) {
                return -1;
            }
            return length;
        }

        public final int m3627b(long j) {
            if (this.f4065f == null) {
                return -1;
            }
            int i = 0;
            while (i < this.f4065f.length && this.f4065f[i] != Long.MIN_VALUE && (j >= this.f4065f[i] || m3625a(i))) {
                i++;
            }
            if (i < this.f4065f.length) {
                return i;
            }
            return -1;
        }

        public final boolean m3626a(int i, int i2) {
            return i2 < this.f4069j[i];
        }

        public final long m3628b(int i, int i2) {
            if (i2 >= this.f4070k[i].length) {
                return 1;
            }
            return this.f4070k[i][i2];
        }

        public final Period m3624a(Object obj, Object obj2, long j, long j2) {
            this.f4060a = obj;
            this.f4061b = obj2;
            this.f4062c = null;
            this.f4063d = j;
            this.f4064e = j2;
            this.f4065f = null;
            this.f4066g = null;
            this.f4069j = null;
            this.f4067h = null;
            this.f4070k = null;
            this.f4068i = 1;
            return this;
        }
    }

    public static final class Window {
        public Object f4071a;
        public long f4072b;
        public long f4073c;
        public boolean f4074d;
        public boolean f4075e;
        public int f4076f;
        public int f4077g;
        public long f4078h;
        public long f4079i;
        public long f4080j;

        public final Window m3629a(long j, long j2, boolean z, boolean z2, long j3, long j4, int i, long j5) {
            this.f4071a = null;
            this.f4072b = j;
            this.f4073c = j2;
            this.f4074d = z;
            this.f4075e = z2;
            this.f4078h = j3;
            this.f4079i = j4;
            this.f4076f = 0;
            this.f4077g = i;
            this.f4080j = j5;
            return this;
        }
    }

    static class C11261 extends Timeline {
        public final int mo1299a(Object obj) {
            return -1;
        }

        public final int mo1302b() {
            return 0;
        }

        public final int mo1303c() {
            return 0;
        }

        C11261() {
        }

        public final Window mo1301a(int i, Window window, long j) {
            throw new IndexOutOfBoundsException();
        }

        public final Period mo1300a(int i, Period period, boolean z) {
            throw new IndexOutOfBoundsException();
        }
    }

    public abstract int mo1299a(Object obj);

    public abstract Period mo1300a(int i, Period period, boolean z);

    public abstract Window mo1301a(int i, Window window, long j);

    public abstract int mo1302b();

    public abstract int mo1303c();

    public final boolean m3636a() {
        return mo1302b() == 0;
    }

    public final Pair<Integer, Long> m3632a(Window window, Period period, int i, long j) {
        return m3633a(window, period, i, j, 0);
    }

    public final Pair<Integer, Long> m3633a(Window window, Period period, int i, long j, long j2) {
        Assertions.m4181a(i, mo1302b());
        mo1301a(i, window, j2);
        if (j == -9223372036854775807L) {
            j = window.f4078h;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        i = window.f4076f;
        long j3 = window.f4080j + j;
        long j4 = mo1300a(i, period, false).f4063d;
        while (j4 != -9223372036854775807L && j3 >= j4 && i < window.f4077g) {
            j3 -= j4;
            i++;
            j4 = mo1300a(i, period, false).f4063d;
        }
        return Pair.create(Integer.valueOf(i), Long.valueOf(j3));
    }

    public final int m3630a(int i, Period period, Window window, int i2) {
        int i3 = 0;
        int i4 = mo1300a(i, period, false).f4062c;
        if (mo1301a(i4, window, 0).f4077g != i) {
            return i + 1;
        }
        switch (i2) {
            case 0:
                if (i4 != mo1302b() - 1) {
                    i3 = i4 + 1;
                    break;
                }
                i3 = -1;
                break;
            case 1:
                i3 = i4;
                break;
            case 2:
                if (i4 != mo1302b() - 1) {
                    i3 = i4 + 1;
                    break;
                }
                break;
            default:
                throw new IllegalStateException();
        }
        if (i3 == -1) {
            return -1;
        }
        return mo1301a(i3, window, 0).f4076f;
    }
}
