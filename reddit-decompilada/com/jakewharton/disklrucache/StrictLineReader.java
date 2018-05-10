package com.jakewharton.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private final InputStream f10016a;
    private final Charset f10017b;
    private byte[] f10018c;
    private int f10019d;
    private int f10020e;

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private StrictLineReader(InputStream inputStream, Charset charset, byte b) {
        if (inputStream != null) {
            if (charset != null) {
                if (charset.equals(Util.f10021a) == (byte) 0) {
                    throw new IllegalArgumentException("Unsupported encoding");
                }
                this.f10016a = inputStream;
                this.f10017b = charset;
                this.f10018c = new byte[8192];
                return;
            }
        }
        throw new NullPointerException();
    }

    public void close() throws IOException {
        synchronized (this.f10016a) {
            if (this.f10018c != null) {
                this.f10018c = null;
                this.f10016a.close();
            }
        }
    }

    public final String m8467a() throws IOException {
        synchronized (this.f10016a) {
            if (this.f10018c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f10019d >= this.f10020e) {
                m8466b();
            }
            for (int i2 = this.f10019d; i2 != this.f10020e; i2++) {
                if (this.f10018c[i2] == (byte) 10) {
                    int i3;
                    String str;
                    if (i2 != this.f10019d) {
                        i3 = i2 - 1;
                        if (this.f10018c[i3] == (byte) 13) {
                            str = new String(this.f10018c, this.f10019d, i3 - this.f10019d, this.f10017b.name());
                            this.f10019d = i2 + 1;
                            return str;
                        }
                    }
                    i3 = i2;
                    str = new String(this.f10018c, this.f10019d, i3 - this.f10019d, this.f10017b.name());
                    this.f10019d = i2 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream c08241 = new ByteArrayOutputStream(this, (this.f10020e - this.f10019d) + 80) {
                final /* synthetic */ StrictLineReader f10015a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.f10015a.f10017b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c08241.write(this.f10018c, this.f10019d, this.f10020e - this.f10019d);
                this.f10020e = -1;
                m8466b();
                i = this.f10019d;
                while (i != this.f10020e) {
                    if (this.f10018c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f10019d) {
                c08241.write(this.f10018c, this.f10019d, i - this.f10019d);
            }
            this.f10019d = i + 1;
            String byteArrayOutputStream = c08241.toString();
            return byteArrayOutputStream;
        }
    }

    private void m8466b() throws IOException {
        int read = this.f10016a.read(this.f10018c, 0, this.f10018c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f10019d = 0;
        this.f10020e = read;
    }
}
