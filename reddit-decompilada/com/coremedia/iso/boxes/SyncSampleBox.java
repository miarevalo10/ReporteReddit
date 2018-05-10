package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SyncSampleBox extends AbstractFullBox {
    public static final String TYPE = "stss";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private long[] sampleNumber;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SyncSampleBox.java", SyncSampleBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "[J"), 46);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.SyncSampleBox", "", "", "", "java.lang.String"), 77);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "setSampleNumber", "com.coremedia.iso.boxes.SyncSampleBox", "[J", "sampleNumber", "", "void"), 81);
    }

    public SyncSampleBox() {
        super(TYPE);
    }

    public long[] getSampleNumber() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.sampleNumber;
    }

    protected long getContentSize() {
        return (long) ((this.sampleNumber.length * 4) + 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.sampleNumber = new long[a];
        for (int i = 0; i < a; i++) {
            this.sampleNumber[i] = IsoTypeReader.m3280a(byteBuffer);
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, (long) this.sampleNumber.length);
        for (long b : this.sampleNumber) {
            IsoTypeWriter.m3300b(byteBuffer, b);
        }
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("SyncSampleBox[entryCount=");
        stringBuilder.append(this.sampleNumber.length);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void setSampleNumber(long[] jArr) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, jArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.sampleNumber = jArr;
    }
}
