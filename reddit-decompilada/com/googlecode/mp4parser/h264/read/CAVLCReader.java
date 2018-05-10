package com.googlecode.mp4parser.h264.read;

import java.io.IOException;
import java.io.InputStream;

public class CAVLCReader extends BitstreamReader {
    public CAVLCReader(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    public final long m15198a(int i, String str) throws IOException {
        long a = m7702a(i);
        m15195a(str, String.valueOf(a));
        return a;
    }

    private int m15196e() throws IOException {
        int i = 0;
        while (m7701a() == 0) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((long) ((1 << i) - 1)) + m7702a(i));
    }

    public final int m15197a(String str) throws IOException {
        int e = m15196e();
        m15195a(str, String.valueOf(e));
        return e;
    }

    public final int m15199b(String str) throws IOException {
        int e = m15196e();
        int i = e & 1;
        e = ((e >> 1) + i) * ((i << 1) - 1);
        m15195a(str, String.valueOf(e));
        return e;
    }

    public final boolean m15200c(String str) throws IOException {
        boolean z = m7701a() != 0;
        m15195a(str, z ? "1" : "0");
        return z;
    }

    public final void m15201d() throws IOException {
        m7701a();
        m7704c();
    }

    private void m15195a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        String valueOf = String.valueOf(BitstreamReader.f9057d - this.e.length());
        int length = 8 - valueOf.length();
        StringBuilder stringBuilder2 = new StringBuilder("@");
        stringBuilder2.append(valueOf);
        stringBuilder.append(stringBuilder2.toString());
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(str);
        int length2 = (100 - stringBuilder.length()) - this.e.length();
        while (i < length2) {
            stringBuilder.append(' ');
            i++;
        }
        stringBuilder.append(this.e);
        str = new StringBuilder(" (");
        str.append(str2);
        str.append(")");
        stringBuilder.append(str.toString());
        this.e.clear();
    }
}
