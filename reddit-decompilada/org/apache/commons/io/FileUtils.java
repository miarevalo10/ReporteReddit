package org.apache.commons.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

public class FileUtils {
    public static final BigInteger f26716a;
    public static final BigInteger f26717b;
    public static final BigInteger f26718c = f26716a.multiply(f26717b);
    public static final BigInteger f26719d = f26716a.multiply(f26718c);
    public static final BigInteger f26720e = f26716a.multiply(f26719d);
    public static final BigInteger f26721f = f26716a.multiply(f26720e);
    public static final BigInteger f26722g = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(1152921504606846976L));
    public static final BigInteger f26723h = f26716a.multiply(f26722g);
    public static final File[] f26724i = new File[0];

    static {
        BigInteger valueOf = BigInteger.valueOf(1024);
        f26716a = valueOf;
        f26717b = valueOf.multiply(valueOf);
    }

    public static void m28333a(InputStream inputStream, File file) throws IOException {
        OutputStream fileOutputStream;
        try {
            StringBuilder stringBuilder;
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!(parentFile == null || parentFile.mkdirs() || parentFile.isDirectory())) {
                    stringBuilder = new StringBuilder("Directory '");
                    stringBuilder.append(parentFile);
                    stringBuilder.append("' could not be created");
                    throw new IOException(stringBuilder.toString());
                }
            } else if (file.isDirectory()) {
                stringBuilder = new StringBuilder("File '");
                stringBuilder.append(file);
                stringBuilder.append("' exists but is a directory");
                throw new IOException(stringBuilder.toString());
            } else if (!file.canWrite()) {
                stringBuilder = new StringBuilder("File '");
                stringBuilder.append(file);
                stringBuilder.append("' cannot be written to");
                throw new IOException(stringBuilder.toString());
            }
            fileOutputStream = new FileOutputStream(file, false);
            IOUtils.m28334a(inputStream, fileOutputStream);
            fileOutputStream.close();
            IOUtils.m28337a(fileOutputStream);
            IOUtils.m28336a(inputStream);
        } catch (Throwable th) {
            IOUtils.m28336a(inputStream);
        }
    }
}
