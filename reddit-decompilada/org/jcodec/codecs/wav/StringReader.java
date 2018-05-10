package org.jcodec.codecs.wav;

import java.io.IOException;
import java.io.InputStream;

public abstract class StringReader {
    public static String readString(InputStream inputStream, int i) throws IOException {
        inputStream = sureRead(inputStream, i);
        if (inputStream == null) {
            return null;
        }
        return new String(inputStream);
    }

    public static byte[] sureRead(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        return sureRead(inputStream, bArr, i) == i ? bArr : null;
    }

    public static int sureRead(InputStream inputStream, byte[] bArr, int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        return i2;
    }

    public static void sureSkip(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            j -= inputStream.skip(j);
        }
    }
}
