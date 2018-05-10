package com.mp4parser.iso14496.part12;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SampleAuxiliaryInformationOffsetsBox extends AbstractFullBox {
    public static final String TYPE = "saio";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private long[] offsets = new long[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SampleAuxiliaryInformationOffsetsBox.java", SampleAuxiliaryInformationOffsetsBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 107);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoType", "", "void"), 111);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "java.lang.String"), 115);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 119);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "", "", "", "[J"), 123);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setOffsets", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationOffsetsBox", "[J", "offsets", "", "void"), 127);
    }

    public SampleAuxiliaryInformationOffsetsBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        int i = 8;
        int length = (getVersion() == 0 ? 4 * this.offsets.length : this.offsets.length * 8) + 8;
        if ((getFlags() & 1) != 1) {
            i = 0;
        }
        return (long) (length + i);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(IsoFile.m17057a(this.auxInfoType));
            byteBuffer.put(IsoFile.m17057a(this.auxInfoTypeParameter));
        }
        IsoTypeWriter.m3300b(byteBuffer, (long) this.offsets.length);
        for (long valueOf : this.offsets) {
            Long valueOf2 = Long.valueOf(valueOf);
            if (getVersion() == 0) {
                IsoTypeWriter.m3300b(byteBuffer, valueOf2.longValue());
            } else {
                IsoTypeWriter.m3296a(byteBuffer, valueOf2.longValue());
            }
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.auxInfoType = IsoTypeReader.m3291k(byteBuffer);
            this.auxInfoTypeParameter = IsoTypeReader.m3291k(byteBuffer);
        }
        int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.offsets = new long[a];
        for (int i = 0; i < a; i++) {
            if (getVersion() == 0) {
                this.offsets[i] = IsoTypeReader.m3280a(byteBuffer);
            } else {
                this.offsets[i] = IsoTypeReader.m3286f(byteBuffer);
            }
        }
    }

    public String getAuxInfoType() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.auxInfoType;
    }

    public void setAuxInfoType(String str) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.auxInfoType = str;
    }

    public String getAuxInfoTypeParameter() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.auxInfoTypeParameter;
    }

    public void setAuxInfoTypeParameter(String str) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.auxInfoTypeParameter = str;
    }

    public long[] getOffsets() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.offsets;
    }

    public void setOffsets(long[] jArr) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, jArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.offsets = jArr;
    }
}
