package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;

public final class CodedOutputStream {
    final byte[] f25907a;
    final int f25908b;
    int f25909c;
    int f25910d = 0;
    final OutputStream f25911e;

    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f25911e = outputStream;
        this.f25907a = bArr;
        this.f25909c = 0;
        this.f25908b = 4096;
    }

    final void m27499a() throws IOException {
        if (this.f25911e == null) {
            throw new OutOfSpaceException();
        }
        this.f25911e.write(this.f25907a, 0, this.f25909c);
        this.f25909c = 0;
    }

    public final void m27501b() throws IOException {
        if (this.f25911e != null) {
            m27499a();
        }
    }

    public final void m27502b(int i) throws IOException {
        while ((i & -128) != 0) {
            m27500a((i & 127) | 128);
            i >>>= 7;
        }
        m27500a(i);
    }

    public static CodedOutputStream m27498a(OutputStream outputStream) {
        return new CodedOutputStream(outputStream, new byte[4096]);
    }

    public final void m27500a(int i) throws IOException {
        i = (byte) i;
        if (this.f25909c == this.f25908b) {
            m27499a();
        }
        byte[] bArr = this.f25907a;
        int i2 = this.f25909c;
        this.f25909c = i2 + 1;
        bArr[i2] = i;
        this.f25910d++;
    }
}
