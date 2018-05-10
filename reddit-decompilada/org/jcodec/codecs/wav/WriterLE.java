package org.jcodec.codecs.wav;

import java.io.IOException;
import java.io.OutputStream;

public abstract class WriterLE {
    public static void writeShort(OutputStream outputStream, short s) throws IOException {
        outputStream.write(s & 255);
        outputStream.write((s >> 8) & 255);
    }

    public static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    public static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((int) (j & 255));
        outputStream.write((int) ((j >> 8) & 255));
        outputStream.write((int) ((j >> 16) & 255));
        outputStream.write((int) ((j >> 24) & 255));
        outputStream.write((int) ((j >> 32) & 255));
        outputStream.write((int) ((j >> 40) & 255));
        outputStream.write((int) ((j >> 48) & 255));
        outputStream.write((int) ((j >> 56) & 255));
    }
}
