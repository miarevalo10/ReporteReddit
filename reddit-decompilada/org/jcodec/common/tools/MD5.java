package org.jcodec.common.tools;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class MD5 {
    public static String md5sum(byte[] bArr) {
        MessageDigest digest = getDigest();
        digest.update(bArr);
        return digestToString(digest.digest());
    }

    private static String digestToString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(i));
        }
        return stringBuilder.toString();
    }

    public static String md5sum(ByteBuffer byteBuffer) {
        MessageDigest digest = getDigest();
        digest.update(byteBuffer);
        return digestToString(digest.digest());
    }

    public static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
