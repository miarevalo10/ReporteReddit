package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

@Descriptor(a = {5})
public class DecoderSpecificInfo extends BaseDescriptor {
    public byte[] f15193a;

    public DecoderSpecificInfo() {
        this.Y = 5;
    }

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        this.f15193a = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.f15193a);
    }

    public final int mo2523a() {
        return this.f15193a.length;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecoderSpecificInfo");
        stringBuilder.append("{bytes=");
        stringBuilder.append(this.f15193a == null ? "null" : Hex.m3277a(this.f15193a));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return Arrays.equals(this.f15193a, ((DecoderSpecificInfo) obj).f15193a) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f15193a != null ? Arrays.hashCode(this.f15193a) : 0;
    }
}
