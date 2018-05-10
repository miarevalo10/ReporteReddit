package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.containers.mxf.model.BER;

@Descriptor(a = {0})
public abstract class BaseDescriptor {
    static final /* synthetic */ boolean ab = true;
    public int f8971Y;
    int f8972Z;
    int aa;

    abstract int mo2523a();

    public abstract void mo2524a(ByteBuffer byteBuffer) throws IOException;

    public final void m7681a(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        int i2 = 0;
        while (true) {
            if (i > 0 || i2 < this.aa) {
                i2++;
                if (i > 0) {
                    byteBuffer.put((m7677c() + position) - i2, (byte) (i & 127));
                } else {
                    byteBuffer.put((m7677c() + position) - i2, BER.ASN_LONG_LEN);
                }
                i >>>= 7;
            } else {
                byteBuffer.position(position + m7677c());
                return;
            }
        }
    }

    private int m7677c() {
        int a = mo2523a();
        int i = 0;
        while (true) {
            if (a <= 0 && i >= this.aa) {
                return i;
            }
            a >>>= 7;
            i++;
        }
    }

    public final int m7682b() {
        return (mo2523a() + m7677c()) + 1;
    }

    public final void m7679a(int i, ByteBuffer byteBuffer) throws IOException {
        this.f8971Y = i;
        i = IsoTypeReader.m3284d(byteBuffer);
        this.f8972Z = i & 127;
        int i2 = 1;
        while ((i >>> 7) == 1) {
            i = IsoTypeReader.m3284d(byteBuffer);
            i2++;
            this.f8972Z = (this.f8972Z << 7) | (i & 127);
        }
        this.aa = i2;
        i = byteBuffer.slice();
        i.limit(this.f8972Z);
        mo2524a(i);
        if (ab || i.remaining() == 0) {
            byteBuffer.position(byteBuffer.position() + this.f8972Z);
            return;
        }
        byteBuffer = new StringBuilder(String.valueOf(getClass().getSimpleName()));
        byteBuffer.append(" has not been fully parsed");
        throw new AssertionError(byteBuffer.toString());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseDescriptor");
        stringBuilder.append("{tag=");
        stringBuilder.append(this.f8971Y);
        stringBuilder.append(", sizeOfInstance=");
        stringBuilder.append(this.f8972Z);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
