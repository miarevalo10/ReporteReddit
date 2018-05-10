package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    int f3274a;
    private final InputStream f3275b;
    private final Charset f3276c;
    private byte[] f3277d;
    private int f3278e;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private StrictLineReader(InputStream inputStream, Charset charset, byte b) {
        if (inputStream != null) {
            if (charset != null) {
                if (charset.equals(Util.f3279a) == (byte) 0) {
                    throw new IllegalArgumentException("Unsupported encoding");
                }
                this.f3275b = inputStream;
                this.f3276c = charset;
                this.f3277d = new byte[8192];
                return;
            }
        }
        throw new NullPointerException();
    }

    public void close() throws IOException {
        synchronized (this.f3275b) {
            if (this.f3277d != null) {
                this.f3277d = null;
                this.f3275b.close();
            }
        }
    }

    public final String m2813a() throws IOException {
        synchronized (this.f3275b) {
            if (this.f3277d == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f3278e >= this.f3274a) {
                m2812b();
            }
            for (int i2 = this.f3278e; i2 != this.f3274a; i2++) {
                if (this.f3277d[i2] == (byte) 10) {
                    int i3;
                    String str;
                    if (i2 != this.f3278e) {
                        i3 = i2 - 1;
                        if (this.f3277d[i3] == (byte) 13) {
                            str = new String(this.f3277d, this.f3278e, i3 - this.f3278e, this.f3276c.name());
                            this.f3278e = i2 + 1;
                            return str;
                        }
                    }
                    i3 = i2;
                    str = new String(this.f3277d, this.f3278e, i3 - this.f3278e, this.f3276c.name());
                    this.f3278e = i2 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream c02691 = new ByteArrayOutputStream(this, (this.f3274a - this.f3278e) + 80) {
                final /* synthetic */ StrictLineReader f3273a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.f3273a.f3276c.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c02691.write(this.f3277d, this.f3278e, this.f3274a - this.f3278e);
                this.f3274a = -1;
                m2812b();
                i = this.f3278e;
                while (i != this.f3274a) {
                    if (this.f3277d[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f3278e) {
                c02691.write(this.f3277d, this.f3278e, i - this.f3278e);
            }
            this.f3278e = i + 1;
            String byteArrayOutputStream = c02691.toString();
            return byteArrayOutputStream;
        }
    }

    private void m2812b() throws IOException {
        int read = this.f3275b.read(this.f3277d, 0, this.f3277d.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f3278e = 0;
        this.f3274a = read;
    }
}
