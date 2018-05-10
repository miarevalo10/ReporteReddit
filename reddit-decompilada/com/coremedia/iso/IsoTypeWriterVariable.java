package com.coremedia.iso;

import java.nio.ByteBuffer;

public final class IsoTypeWriterVariable {
    public static void m3306a(long j, ByteBuffer byteBuffer, int i) {
        if (i != 8) {
            switch (i) {
                case 1:
                    IsoTypeWriter.m3303c(byteBuffer, (int) (j & 255));
                    return;
                case 2:
                    IsoTypeWriter.m3299b(byteBuffer, (int) (j & 65535));
                    return;
                case 3:
                    IsoTypeWriter.m3295a(byteBuffer, (int) (j & 16777215));
                    return;
                case 4:
                    IsoTypeWriter.m3300b(byteBuffer, j);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("I don't know how to read ");
                    stringBuilder.append(i);
                    stringBuilder.append(" bytes");
                    throw new RuntimeException(stringBuilder.toString());
            }
        }
        IsoTypeWriter.m3296a(byteBuffer, j);
    }
}
