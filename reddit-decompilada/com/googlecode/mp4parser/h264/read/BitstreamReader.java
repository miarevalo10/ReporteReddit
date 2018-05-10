package com.googlecode.mp4parser.h264.read;

import com.googlecode.mp4parser.h264.CharCache;
import java.io.IOException;
import java.io.InputStream;

public class BitstreamReader {
    protected static int f9057d;
    public int f9058a;
    public int f9059b;
    public int f9060c;
    protected CharCache f9061e = new CharCache(50);
    private InputStream f9062f;

    public BitstreamReader(InputStream inputStream) throws IOException {
        this.f9062f = inputStream;
        this.f9058a = inputStream.read();
        this.f9059b = inputStream.read();
    }

    public final int m7701a() throws IOException {
        if (this.f9060c == 8) {
            m7703b();
            if (this.f9058a == -1) {
                return -1;
            }
        }
        int i = (this.f9058a >> (7 - this.f9060c)) & 1;
        this.f9060c++;
        this.f9061e.append(i == 0 ? '0' : '1');
        f9057d++;
        return i;
    }

    public final long m7702a(int i) throws IOException {
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | ((long) m7701a());
        }
        return j;
    }

    public final void m7703b() throws IOException {
        this.f9058a = this.f9059b;
        this.f9059b = this.f9062f.read();
        this.f9060c = 0;
    }

    public final long m7704c() throws IOException {
        return m7702a(8 - this.f9060c);
    }
}
