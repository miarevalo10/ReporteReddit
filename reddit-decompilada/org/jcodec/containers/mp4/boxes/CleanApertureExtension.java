package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class CleanApertureExtension extends Box {
    private int apertureHeightDenominator;
    private int apertureHeightNumerator;
    private int apertureWidthDenominator;
    private int apertureWidthNumerator;
    private int horizOffsetDenominator;
    private int horizOffsetNumerator;
    private int vertOffsetDenominator;
    private int vertOffsetNumerator;

    public static String fourcc() {
        return "clap";
    }

    public CleanApertureExtension(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(new Header(fourcc()));
        this.apertureWidthNumerator = i;
        this.apertureWidthDenominator = i2;
        this.apertureHeightNumerator = i3;
        this.apertureHeightDenominator = i4;
        this.horizOffsetNumerator = i5;
        this.horizOffsetDenominator = i6;
        this.vertOffsetNumerator = i7;
        this.vertOffsetDenominator = i8;
    }

    public CleanApertureExtension() {
        super(new Header(fourcc()));
    }

    public void parse(ByteBuffer byteBuffer) {
        this.apertureWidthNumerator = byteBuffer.getInt();
        this.apertureWidthDenominator = byteBuffer.getInt();
        this.apertureHeightNumerator = byteBuffer.getInt();
        this.apertureHeightDenominator = byteBuffer.getInt();
        this.horizOffsetNumerator = byteBuffer.getInt();
        this.horizOffsetDenominator = byteBuffer.getInt();
        this.vertOffsetNumerator = byteBuffer.getInt();
        this.vertOffsetDenominator = byteBuffer.getInt();
    }

    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.apertureWidthNumerator);
        byteBuffer.putInt(this.apertureWidthDenominator);
        byteBuffer.putInt(this.apertureHeightNumerator);
        byteBuffer.putInt(this.apertureHeightDenominator);
        byteBuffer.putInt(this.horizOffsetNumerator);
        byteBuffer.putInt(this.horizOffsetDenominator);
        byteBuffer.putInt(this.vertOffsetNumerator);
        byteBuffer.putInt(this.vertOffsetDenominator);
    }
}
