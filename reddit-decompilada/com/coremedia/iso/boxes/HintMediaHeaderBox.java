package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class HintMediaHeaderBox extends AbstractMediaHeaderBox {
    public static final String TYPE = "hmhd";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private long avgBitrate;
    private int avgPduSize;
    private long maxBitrate;
    private int maxPduSize;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("HintMediaHeaderBox.java", HintMediaHeaderBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getMaxPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 42);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getAvgPduSize", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "int"), 46);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getMaxBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 50);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getAvgBitrate", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "long"), 54);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.HintMediaHeaderBox", "", "", "", "java.lang.String"), 84);
    }

    protected long getContentSize() {
        return 20;
    }

    public HintMediaHeaderBox() {
        super(TYPE);
    }

    public int getMaxPduSize() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.maxPduSize;
    }

    public int getAvgPduSize() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avgPduSize;
    }

    public long getMaxBitrate() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.maxBitrate;
    }

    public long getAvgBitrate() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avgBitrate;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.maxPduSize = IsoTypeReader.m3283c(byteBuffer);
        this.avgPduSize = IsoTypeReader.m3283c(byteBuffer);
        this.maxBitrate = IsoTypeReader.m3280a(byteBuffer);
        this.avgBitrate = IsoTypeReader.m3280a(byteBuffer);
        IsoTypeReader.m3280a(byteBuffer);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3299b(byteBuffer, this.maxPduSize);
        IsoTypeWriter.m3299b(byteBuffer, this.avgPduSize);
        IsoTypeWriter.m3300b(byteBuffer, this.maxBitrate);
        IsoTypeWriter.m3300b(byteBuffer, this.avgBitrate);
        IsoTypeWriter.m3300b(byteBuffer, 0);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("HintMediaHeaderBox{maxPduSize=");
        stringBuilder.append(this.maxPduSize);
        stringBuilder.append(", avgPduSize=");
        stringBuilder.append(this.avgPduSize);
        stringBuilder.append(", maxBitrate=");
        stringBuilder.append(this.maxBitrate);
        stringBuilder.append(", avgBitrate=");
        stringBuilder.append(this.avgBitrate);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
