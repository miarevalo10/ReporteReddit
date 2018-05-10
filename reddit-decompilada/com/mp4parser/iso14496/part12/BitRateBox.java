package com.mp4parser.iso14496.part12;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public final class BitRateBox extends AbstractBox {
    public static final String TYPE = "btrt";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private long avgBitrate;
    private long bufferSizeDb;
    private long maxBitrate;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("BitRateBox.java", BitRateBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 74);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setBufferSizeDb", "com.mp4parser.iso14496.part12.BitRateBox", "long", "bufferSizeDb", "", "void"), 82);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 90);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setMaxBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "long", "maxBitrate", "", "void"), 98);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "", "", "", "long"), 106);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setAvgBitrate", "com.mp4parser.iso14496.part12.BitRateBox", "long", "avgBitrate", "", "void"), 114);
    }

    protected final long getContentSize() {
        return 12;
    }

    public BitRateBox() {
        super(TYPE);
    }

    public final void _parseDetails(ByteBuffer byteBuffer) {
        this.bufferSizeDb = IsoTypeReader.m3280a(byteBuffer);
        this.maxBitrate = IsoTypeReader.m3280a(byteBuffer);
        this.avgBitrate = IsoTypeReader.m3280a(byteBuffer);
    }

    protected final void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3300b(byteBuffer, this.bufferSizeDb);
        IsoTypeWriter.m3300b(byteBuffer, this.maxBitrate);
        IsoTypeWriter.m3300b(byteBuffer, this.avgBitrate);
    }

    public final long getBufferSizeDb() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.bufferSizeDb;
    }

    public final void setBufferSizeDb(long j) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.bufferSizeDb = j;
    }

    public final long getMaxBitrate() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.maxBitrate;
    }

    public final void setMaxBitrate(long j) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.maxBitrate = j;
    }

    public final long getAvgBitrate() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avgBitrate;
    }

    public final void setAvgBitrate(long j) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avgBitrate = j;
    }
}
