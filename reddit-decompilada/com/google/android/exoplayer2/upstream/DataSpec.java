package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class DataSpec {
    public final Uri f5167a;
    public final byte[] f5168b;
    public final long f5169c;
    public final long f5170d;
    public final long f5171e;
    public final String f5172f;
    public final int f5173g;

    public DataSpec(Uri uri) {
        this(uri, (byte) 0);
    }

    public DataSpec(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public DataSpec(Uri uri, byte b) {
        this(uri, 0, 0, -1, null, 1);
    }

    private DataSpec(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    private DataSpec(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = false;
        Assertions.m4184a(j >= 0);
        Assertions.m4184a(j2 >= 0);
        if (j3 > 0 || j3 == -1) {
            z = true;
        }
        Assertions.m4184a(z);
        this.f5167a = uri;
        this.f5168b = bArr;
        this.f5169c = j;
        this.f5170d = j2;
        this.f5171e = j3;
        this.f5172f = str;
        this.f5173g = i;
    }

    public final boolean m4150a() {
        return (this.f5173g & 1) == 1;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSpec[");
        stringBuilder.append(this.f5167a);
        stringBuilder.append(", ");
        stringBuilder.append(Arrays.toString(this.f5168b));
        stringBuilder.append(", ");
        stringBuilder.append(this.f5169c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5170d);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5171e);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5172f);
        stringBuilder.append(", ");
        stringBuilder.append(this.f5173g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final DataSpec m4149a(long j) {
        long j2 = -1;
        if (this.f5171e != -1) {
            j2 = r0.f5171e - j;
        }
        long j3 = j2;
        if (j == 0 && r0.f5171e == j3) {
            return r0;
        }
        return new DataSpec(r0.f5167a, r0.f5168b, r0.f5169c + j, r0.f5170d + j, j3, r0.f5172f, r0.f5173g);
    }
}
