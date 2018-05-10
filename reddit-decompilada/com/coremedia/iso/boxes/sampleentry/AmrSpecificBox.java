package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class AmrSpecificBox extends AbstractBox {
    public static final String TYPE = "damr";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private int decoderVersion;
    private int framesPerSample;
    private int modeChangePeriod;
    private int modeSet;
    private String vendor;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AmrSpecificBox.java", AmrSpecificBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getVendor", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 46);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getDecoderVersion", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 50);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getModeSet", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 54);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getModeChangePeriod", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 58);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getFramesPerSample", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "int"), 62);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getContent", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 84);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.sampleentry.AmrSpecificBox", "", "", "", "java.lang.String"), 92);
    }

    protected long getContentSize() {
        return 9;
    }

    public AmrSpecificBox() {
        super(TYPE);
    }

    public String getVendor() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.vendor;
    }

    public int getDecoderVersion() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.decoderVersion;
    }

    public int getModeSet() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.modeSet;
    }

    public int getModeChangePeriod() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.modeChangePeriod;
    }

    public int getFramesPerSample() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.framesPerSample;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        this.vendor = IsoFile.m17056a(bArr);
        this.decoderVersion = IsoTypeReader.m3284d(byteBuffer);
        this.modeSet = IsoTypeReader.m3283c(byteBuffer);
        this.modeChangePeriod = IsoTypeReader.m3284d(byteBuffer);
        this.framesPerSample = IsoTypeReader.m3284d(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, byteBuffer);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        byteBuffer.put(IsoFile.m17057a(this.vendor));
        IsoTypeWriter.m3303c(byteBuffer, this.decoderVersion);
        IsoTypeWriter.m3299b(byteBuffer, this.modeSet);
        IsoTypeWriter.m3303c(byteBuffer, this.modeChangePeriod);
        IsoTypeWriter.m3303c(byteBuffer, this.framesPerSample);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AmrSpecificBox[vendor=");
        stringBuilder.append(getVendor());
        stringBuilder.append(";decoderVersion=");
        stringBuilder.append(getDecoderVersion());
        stringBuilder.append(";modeSet=");
        stringBuilder.append(getModeSet());
        stringBuilder.append(";modeChangePeriod=");
        stringBuilder.append(getModeChangePeriod());
        stringBuilder.append(";framesPerSample=");
        stringBuilder.append(getFramesPerSample());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
