package org.jcodec.common.model;

public class Picture8Bit {
    private byte[] cb;
    private byte[] cr;
    private int height;
    private int width;
    private byte[] f26805y;

    public Picture8Bit(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.width = i;
        this.height = i2;
        this.f26805y = bArr;
        this.cb = bArr2;
        this.cr = bArr3;
    }

    public static Picture8Bit create422(int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        i3 >>= 1;
        return new Picture8Bit(i, i2, bArr, new byte[i3], new byte[i3]);
    }

    public static Picture8Bit create420(int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        i3 >>= 2;
        return new Picture8Bit(i, i2, bArr, new byte[i3], new byte[i3]);
    }

    public Picture8Bit(Picture8Bit picture8Bit) {
        this(picture8Bit.width, picture8Bit.height, picture8Bit.f26805y, picture8Bit.cb, picture8Bit.cr);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getY() {
        return this.f26805y;
    }

    public byte[] getCb() {
        return this.cb;
    }

    public byte[] getCr() {
        return this.cr;
    }
}
