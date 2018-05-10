package android.support.v4.util;

import java.io.PrintWriter;

public final class TimeUtils {
    private static final Object f1424a = new Object();
    private static char[] f1425b = new char[24];

    private static int m1067a(char[] cArr, int i, char c, int i2, boolean z) {
        if (!z && i <= 0) {
            return i2;
        }
        int i3;
        if (i > true) {
            z = i / 100;
            cArr[i2] = (char) (z + 48);
            i3 = i2 + 1;
            i -= z * 100;
        } else {
            i3 = i2;
        }
        if (i > true || i2 != i3) {
            i2 = i / 10;
            cArr[i3] = (char) (i2 + 48);
            i3++;
            i -= i2 * 10;
        }
        cArr[i3] = (char) (i + 48);
        i3++;
        cArr[i3] = c;
        return i3 + 1;
    }

    private static void m1070b(long j, PrintWriter printWriter) {
        synchronized (f1424a) {
            if (f1425b.length < 0) {
                f1425b = new char[0];
            }
            char[] cArr = f1425b;
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            int i2 = 1;
            if (i == 0) {
                cArr[0] = 48;
            } else {
                char c;
                int i3;
                int i4;
                int i5;
                if (i > 0) {
                    c = '+';
                } else {
                    c = '-';
                    j = -j;
                }
                int i6 = (int) (j % 1000);
                j = (int) Math.floor((double) (j / 1000));
                if (j > 86400) {
                    i3 = j / 86400;
                    j -= 86400 * i3;
                } else {
                    i3 = 0;
                }
                if (j > 3600) {
                    i4 = j / 3600;
                    j -= i4 * 3600;
                } else {
                    i4 = 0;
                }
                if (j > 60) {
                    i5 = j / 60;
                    j -= i5 * 60;
                } else {
                    i5 = 0;
                }
                cArr[0] = c;
                i = m1067a(cArr, i3, 'd', 1, false);
                i4 = m1067a(cArr, i4, 'h', i, i != 1);
                i4 = m1067a(cArr, i5, 'm', i4, i4 != 1);
                j = m1067a(cArr, i6, 'm', m1067a(cArr, j, 's', i4, i4 != 1), true);
                cArr[j] = 's';
                i2 = 1 + j;
            }
            printWriter.print(new String(f1425b, 0, i2));
        }
    }

    public static void m1069a(long j, PrintWriter printWriter) {
        m1070b(j, printWriter);
    }

    public static void m1068a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            m1070b(j - j2, printWriter);
        }
    }
}
