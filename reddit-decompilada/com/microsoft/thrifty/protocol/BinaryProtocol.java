package com.microsoft.thrifty.protocol;

import com.microsoft.thrifty.transport.Transport;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;

public class BinaryProtocol extends Protocol {
    private static final StructMetadata f15605b = new StructMetadata("");
    private final long f15606c;
    private final long f15607d;
    private final byte[] f15608e;

    public BinaryProtocol(Transport transport) {
        this(transport, (byte) 0);
    }

    private BinaryProtocol(Transport transport, byte b) {
        super(transport);
        this.f15608e = new byte[8];
        this.f15606c = -1;
        this.f15607d = -1;
    }

    public final void mo2638a(int i, byte b) throws IOException {
        m15499a(b);
        i = (short) i;
        this.f15608e[0] = (byte) ((i >> 8) & 255);
        this.f15608e[1] = (byte) (i & 255);
        this.a.mo2654a(this.f15608e, 2);
    }

    public final void mo2634a() throws IOException {
        m15499a((byte) 0);
    }

    public final void mo2635a(byte b, int i) throws IOException {
        m15499a(b);
        mo2637a(i);
    }

    public final void mo2641a(boolean z) throws IOException {
        m15499a((byte) z);
    }

    private void m15499a(byte b) throws IOException {
        this.f15608e[0] = b;
        this.a.mo2654a(this.f15608e, 1);
    }

    public final void mo2637a(int i) throws IOException {
        this.f15608e[0] = (byte) ((i >> 24) & 255);
        this.f15608e[1] = (byte) ((i >> 16) & 255);
        this.f15608e[2] = (byte) ((i >> 8) & 255);
        this.f15608e[3] = (byte) (i & 255);
        this.a.mo2654a(this.f15608e, 4);
    }

    public final void mo2639a(long j) throws IOException {
        this.f15608e[0] = (byte) ((int) ((j >> 56) & 255));
        this.f15608e[1] = (byte) ((int) ((j >> 48) & 255));
        this.f15608e[2] = (byte) ((int) ((j >> 40) & 255));
        this.f15608e[3] = (byte) ((int) ((j >> 32) & 255));
        this.f15608e[4] = (byte) ((int) ((j >> 24) & 255));
        this.f15608e[5] = (byte) ((int) ((j >> 16) & 255));
        this.f15608e[6] = (byte) ((int) ((j >> 8) & 255));
        this.f15608e[7] = (byte) ((int) (j & 255));
        this.a.mo2654a(this.f15608e, 8);
    }

    public final void mo2636a(double d) throws IOException {
        mo2639a(Double.doubleToLongBits(d));
    }

    public final void mo2640a(String str) throws IOException {
        try {
            str = str.getBytes("UTF-8");
            mo2637a(str.length);
            this.a.mo2654a(str, str.length);
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }

    public final FieldMetadata mo2642b() throws IOException {
        short s;
        byte g = mo2647g();
        if (g == (byte) 0) {
            s = (short) 0;
        } else {
            s = mo2648h();
        }
        return new FieldMetadata("", g, s);
    }

    public final MapMetadata mo2643c() throws IOException {
        byte g = mo2647g();
        byte g2 = mo2647g();
        int i = mo2649i();
        if (this.f15607d == -1 || ((long) i) <= this.f15607d) {
            return new MapMetadata(g, g2, i);
        }
        throw new ProtocolException("Container size limit exceeded");
    }

    public final ListMetadata mo2644d() throws IOException {
        byte g = mo2647g();
        int i = mo2649i();
        if (this.f15607d == -1 || ((long) i) <= this.f15607d) {
            return new ListMetadata(g, i);
        }
        throw new ProtocolException("Container size limit exceeded");
    }

    public final SetMetadata mo2645e() throws IOException {
        byte g = mo2647g();
        int i = mo2649i();
        if (this.f15607d == -1 || ((long) i) <= this.f15607d) {
            return new SetMetadata(g, i);
        }
        throw new ProtocolException("Container size limit exceeded");
    }

    public final boolean mo2646f() throws IOException {
        return mo2647g() == (byte) 1;
    }

    public final byte mo2647g() throws IOException {
        m15500a(this.f15608e, 1);
        return this.f15608e[0];
    }

    public final short mo2648h() throws IOException {
        m15500a(this.f15608e, 2);
        return (short) (((this.f15608e[0] & 255) << 8) | (this.f15608e[1] & 255));
    }

    public final int mo2649i() throws IOException {
        m15500a(this.f15608e, 4);
        return ((((this.f15608e[0] & 255) << 24) | ((this.f15608e[1] & 255) << 16)) | ((this.f15608e[2] & 255) << 8)) | (this.f15608e[3] & 255);
    }

    public final long mo2650j() throws IOException {
        m15500a(this.f15608e, 8);
        return (((((long) this.f15608e[6]) & 255) << 8) | (((((((((long) this.f15608e[0]) & 255) << 56) | ((((long) this.f15608e[1]) & 255) << 48)) | ((((long) this.f15608e[2]) & 255) << 40)) | ((((long) this.f15608e[3]) & 255) << 32)) | ((((long) this.f15608e[4]) & 255) << 24)) | ((((long) this.f15608e[5]) & 255) << 16))) | (((long) this.f15608e[7]) & 255);
    }

    public final double mo2651k() throws IOException {
        return Double.longBitsToDouble(mo2650j());
    }

    public final String mo2652l() throws IOException {
        int i = mo2649i();
        if (this.f15606c == -1 || ((long) i) <= this.f15606c) {
            byte[] bArr = new byte[i];
            m15500a(bArr, i);
            return new String(bArr, "UTF-8");
        }
        throw new ProtocolException("String size limit exceeded");
    }

    private void m15500a(byte[] bArr, int i) throws IOException {
        int i2 = 0;
        int i3 = i;
        while (i3 > 0) {
            int a = this.a.mo2653a(bArr, i2, i3);
            if (a == -1) {
                StringBuilder stringBuilder = new StringBuilder("Expected ");
                stringBuilder.append(i);
                stringBuilder.append(" bytes; got ");
                stringBuilder.append(i2);
                throw new EOFException(stringBuilder.toString());
            }
            i3 -= a;
            i2 += a;
        }
    }
}
