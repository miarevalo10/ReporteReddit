package org.jcodec.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class IOUtils {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    public static void closeQuietly(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0.close();	 Catch:{ IOException -> 0x0007 }
        return;
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.common.IOUtils.closeQuietly(java.io.Closeable):void");
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return i;
            }
            outputStream.write(bArr, 0, read);
            i += read;
        }
    }

    public static int copyDumb(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = 0;
        while (true) {
            int read = inputStream.read();
            if (-1 == read) {
                return i;
            }
            outputStream.write(read);
            i++;
        }
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        return NIOUtils.toArray(NIOUtils.fetchFrom(file));
    }

    public static String toString(InputStream inputStream) throws IOException {
        return new String(toByteArray(inputStream));
    }

    public static void writeStringToFile(File file, String str) throws IOException {
        NIOUtils.writeTo(ByteBuffer.wrap(str.getBytes()), file);
    }

    public static void forceMkdir(File file) throws IOException {
        StringBuilder stringBuilder;
        if (file.exists()) {
            if (!file.isDirectory()) {
                stringBuilder = new StringBuilder("File ");
                stringBuilder.append(file);
                stringBuilder.append(" exists and is not a directory. Unable to create directory.");
                throw new IOException(stringBuilder.toString());
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            stringBuilder = new StringBuilder("Unable to create directory ");
            stringBuilder.append(file);
            throw new IOException(stringBuilder.toString());
        }
    }
}
