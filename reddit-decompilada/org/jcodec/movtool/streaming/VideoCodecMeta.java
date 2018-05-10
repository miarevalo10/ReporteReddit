package org.jcodec.movtool.streaming;

import java.nio.ByteBuffer;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;

public class VideoCodecMeta extends CodecMeta {
    private boolean interlaced;
    private Rational pasp;
    private Size size;
    private boolean topFieldFirst;

    public VideoCodecMeta(String str, ByteBuffer byteBuffer, Size size, Rational rational) {
        super(str, byteBuffer);
        this.size = size;
        this.pasp = rational;
    }

    public VideoCodecMeta(String str, ByteBuffer byteBuffer, Size size, Rational rational, boolean z, boolean z2) {
        super(str, byteBuffer);
        this.size = size;
        this.pasp = rational;
        this.interlaced = z;
        this.topFieldFirst = z2;
    }

    public Size getSize() {
        return this.size;
    }

    public Rational getPasp() {
        return this.pasp;
    }

    public boolean isInterlaced() {
        return this.interlaced;
    }

    public boolean isTopFieldFirst() {
        return this.topFieldFirst;
    }
}
