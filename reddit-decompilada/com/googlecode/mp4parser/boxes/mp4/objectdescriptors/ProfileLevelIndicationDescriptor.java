package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.nio.ByteBuffer;

@Descriptor(a = {20})
public class ProfileLevelIndicationDescriptor extends BaseDescriptor {
    public int f15211a;

    public final int mo2523a() {
        return 1;
    }

    public ProfileLevelIndicationDescriptor() {
        this.Y = 20;
    }

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        this.f15211a = IsoTypeReader.m3284d(byteBuffer);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProfileLevelIndicationDescriptor");
        stringBuilder.append("{profileLevelIndicationIndex=");
        stringBuilder.append(Integer.toHexString(this.f15211a));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                return this.f15211a == ((ProfileLevelIndicationDescriptor) obj).f15211a;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f15211a;
    }
}
