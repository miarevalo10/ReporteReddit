package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;

@Descriptor(a = {6})
public class SLConfigDescriptor extends BaseDescriptor {
    public int f15212a;

    public final int mo2523a() {
        return 1;
    }

    public SLConfigDescriptor() {
        this.Y = 6;
    }

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        this.f15212a = IsoTypeReader.m3284d(byteBuffer);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SLConfigDescriptor");
        stringBuilder.append("{predefined=");
        stringBuilder.append(this.f15212a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.f15212a == ((SLConfigDescriptor) obj).f15212a;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f15212a;
    }
}
