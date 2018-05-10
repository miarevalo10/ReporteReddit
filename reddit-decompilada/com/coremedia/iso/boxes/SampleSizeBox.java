package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SampleSizeBox extends AbstractFullBox {
    public static final String TYPE = "stsz";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    int sampleCount;
    private long sampleSize;
    private long[] sampleSizes = new long[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SampleSizeBox.java", SampleSizeBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 50);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setSampleSize", "com.coremedia.iso.boxes.SampleSizeBox", "long", "sampleSize", "", "void"), 54);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getSampleSizeAtIndex", "com.coremedia.iso.boxes.SampleSizeBox", "int", "index", "", "long"), 59);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getSampleCount", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "long"), 67);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "[J"), 76);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setSampleSizes", "com.coremedia.iso.boxes.SampleSizeBox", "[J", "sampleSizes", "", "void"), 80);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.SampleSizeBox", "", "", "", "java.lang.String"), 119);
    }

    public SampleSizeBox() {
        super(TYPE);
    }

    public long getSampleSize() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.sampleSize;
    }

    public void setSampleSize(long j) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.sampleSize = j;
    }

    public long getSampleSizeAtIndex(int i) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (this.sampleSize > 0) {
            return this.sampleSize;
        }
        return this.sampleSizes[i];
    }

    public long getSampleCount() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (this.sampleSize > 0) {
            return (long) this.sampleCount;
        }
        return (long) this.sampleSizes.length;
    }

    public long[] getSampleSizes() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.sampleSizes;
    }

    public void setSampleSizes(long[] jArr) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, jArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.sampleSizes = jArr;
    }

    protected long getContentSize() {
        return (long) (12 + (this.sampleSize == 0 ? this.sampleSizes.length * 4 : 0));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.sampleSize = IsoTypeReader.m3280a(byteBuffer);
        this.sampleCount = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        if (this.sampleSize == 0) {
            this.sampleSizes = new long[this.sampleCount];
            for (int i = 0; i < this.sampleCount; i++) {
                this.sampleSizes[i] = IsoTypeReader.m3280a(byteBuffer);
            }
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, this.sampleSize);
        if (this.sampleSize == 0) {
            IsoTypeWriter.m3300b(byteBuffer, (long) this.sampleSizes.length);
            for (long b : this.sampleSizes) {
                IsoTypeWriter.m3300b(byteBuffer, b);
            }
            return;
        }
        IsoTypeWriter.m3300b(byteBuffer, (long) this.sampleCount);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("SampleSizeBox[sampleSize=");
        stringBuilder.append(getSampleSize());
        stringBuilder.append(";sampleCount=");
        stringBuilder.append(getSampleCount());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
