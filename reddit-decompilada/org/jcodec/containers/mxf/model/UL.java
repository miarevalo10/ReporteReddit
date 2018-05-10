package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;

public class UL {
    private byte[] bytes;

    private char hex(int i) {
        return (char) (i < 10 ? 48 + i : 65 + (i - 10));
    }

    public UL(byte... bArr) {
        this.bytes = bArr;
    }

    public UL(int... iArr) {
        this.bytes = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.bytes[i] = (byte) iArr[i];
        }
    }

    public int hashCode() {
        return ((((this.bytes[4] & 255) << 24) | ((this.bytes[5] & 255) << 16)) | ((this.bytes[6] & 255) << 8)) | (this.bytes[7] & 255);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UL)) {
            return false;
        }
        obj = ((UL) obj).bytes;
        for (int i = 4; i < Math.min(this.bytes.length, obj.length); i++) {
            if (this.bytes[i] != obj[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(UL ul, int i) {
        if (ul == null) {
            return false;
        }
        ul = ul.bytes;
        int i2 = 4;
        i >>= 4;
        while (i2 < Math.min(this.bytes.length, ul.length)) {
            if ((i & 1) == 1 && this.bytes[i2] != ul[i2]) {
                return false;
            }
            i2++;
            i >>= 1;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("06:0E:2B:34:");
        for (int i = 4; i < this.bytes.length; i++) {
            stringBuilder.append(hex((this.bytes[i] >> 4) & 15));
            stringBuilder.append(hex(this.bytes[i] & 15));
            if (i < this.bytes.length - 1) {
                stringBuilder.append(":");
            }
        }
        return stringBuilder.toString();
    }

    public int get(int i) {
        return this.bytes[i];
    }

    public static UL read(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        return new UL(bArr);
    }
}
