package com.google.android.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class ReusableBufferedOutputStream extends BufferedOutputStream {
    private boolean f5266a;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public final void close() throws IOException {
        Throwable th;
        this.f5266a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.out.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        if (th != null) {
            Util.m4309a(th);
        }
    }

    public final void m4281a(OutputStream outputStream) {
        Assertions.m4186b(this.f5266a);
        this.out = outputStream;
        this.count = 0;
        this.f5266a = false;
    }
}
