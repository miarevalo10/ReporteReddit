package com.coremedia.iso;

import java.nio.ByteBuffer;

public final class IsoTypeReaderVariable {
    public static long m3293a(ByteBuffer byteBuffer, int i) {
        if (i == 8) {
            return IsoTypeReader.m3286f(byteBuffer);
        }
        switch (i) {
            case 1:
                return (long) IsoTypeReader.m3284d(byteBuffer);
            case 2:
                return (long) IsoTypeReader.m3283c(byteBuffer);
            case 3:
                return (long) IsoTypeReader.m3282b(byteBuffer);
            case 4:
                return IsoTypeReader.m3280a(byteBuffer);
            default:
                StringBuilder stringBuilder = new StringBuilder("I don't know how to read ");
                stringBuilder.append(i);
                stringBuilder.append(" bytes");
                throw new RuntimeException(stringBuilder.toString());
        }
    }
}
