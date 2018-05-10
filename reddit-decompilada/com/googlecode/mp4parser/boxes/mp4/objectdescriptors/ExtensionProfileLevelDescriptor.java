package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.Hex;
import java.io.IOException;
import java.nio.ByteBuffer;

@Descriptor(a = {19})
public class ExtensionProfileLevelDescriptor extends BaseDescriptor {
    byte[] f15210a;

    public ExtensionProfileLevelDescriptor() {
        this.Y = 19;
    }

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        if (m7682b() > 0) {
            this.f15210a = new byte[m7682b()];
            byteBuffer.get(this.f15210a);
        }
    }

    final int mo2523a() {
        throw new RuntimeException("Not Implemented");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtensionDescriptor");
        stringBuilder.append("{bytes=");
        stringBuilder.append(this.f15210a == null ? "null" : Hex.m3277a(this.f15210a));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
