package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

public class UnknownDescriptor extends BaseDescriptor {
    private static Logger f15213a = Logger.getLogger(UnknownDescriptor.class.getName());
    private ByteBuffer f15214b;

    public final void mo2524a(ByteBuffer byteBuffer) throws IOException {
        this.f15214b = byteBuffer.slice();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UnknownDescriptor");
        stringBuilder.append("{tag=");
        stringBuilder.append(this.Y);
        stringBuilder.append(", sizeOfInstance=");
        stringBuilder.append(this.Z);
        stringBuilder.append(", data=");
        stringBuilder.append(this.f15214b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    final int mo2523a() {
        throw new RuntimeException("sdjlhfl");
    }
}
