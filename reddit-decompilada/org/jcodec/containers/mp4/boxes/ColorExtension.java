package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.JCodecUtil;

public class ColorExtension extends Box {
    private short matrixIndex;
    private short primariesIndex;
    private short transferFunctionIndex;
    private final String type;

    public static String fourcc() {
        return "colr";
    }

    public ColorExtension(short s, short s2, short s3) {
        this();
        this.primariesIndex = s;
        this.transferFunctionIndex = s2;
        this.matrixIndex = s3;
    }

    public ColorExtension() {
        super(new Header(fourcc()));
        this.type = "nclc";
    }

    public void parse(ByteBuffer byteBuffer) {
        byteBuffer.getInt();
        this.primariesIndex = byteBuffer.getShort();
        this.transferFunctionIndex = byteBuffer.getShort();
        this.matrixIndex = byteBuffer.getShort();
    }

    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put(JCodecUtil.asciiString("nclc"));
        byteBuffer.putShort(this.primariesIndex);
        byteBuffer.putShort(this.transferFunctionIndex);
        byteBuffer.putShort(this.matrixIndex);
    }

    public short getPrimariesIndex() {
        return this.primariesIndex;
    }

    public short getTransferFunctionIndex() {
        return this.transferFunctionIndex;
    }

    public short getMatrixIndex() {
        return this.matrixIndex;
    }
}
