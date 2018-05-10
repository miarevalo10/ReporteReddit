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
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SampleAuxiliaryInformationSizesBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "saiz";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_11 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    private String auxInfoType;
    private String auxInfoTypeParameter;
    private short defaultSampleInfoSize;
    private int sampleCount;
    private short[] sampleInfoSizes = new short[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SampleAuxiliaryInformationSizesBox.java", SampleAuxiliaryInformationSizesBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "index", "", "short"), 57);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 106);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "setSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "sampleCount", "", "void"), 146);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "toString", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 151);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "setAuxInfoType", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoType", "", "void"), 110);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "java.lang.String"), 114);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "setAuxInfoTypeParameter", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "java.lang.String", "auxInfoTypeParameter", "", "void"), 118);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 122);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "setDefaultSampleInfoSize", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "int", "defaultSampleInfoSize", "", "void"), 126);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "[S"), 131);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "setSampleInfoSizes", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "[S", "sampleInfoSizes", "", "void"), 137);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "getSampleCount", "com.mp4parser.iso14496.part12.SampleAuxiliaryInformationSizesBox", "", "", "", "int"), 142);
    }

    public SampleAuxiliaryInformationSizesBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) ((((getFlags() & 1) == 1 ? 12 : 4) + 5) + (this.defaultSampleInfoSize == (short) 0 ? this.sampleInfoSizes.length : 0));
    }

    public short getSize(int i) {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (getDefaultSampleInfoSize() == 0) {
            return this.sampleInfoSizes[i];
        }
        return this.defaultSampleInfoSize;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            byteBuffer.put(IsoFile.m17057a(this.auxInfoType));
            byteBuffer.put(IsoFile.m17057a(this.auxInfoTypeParameter));
        }
        IsoTypeWriter.m3303c(byteBuffer, this.defaultSampleInfoSize);
        if (this.defaultSampleInfoSize == (short) 0) {
            IsoTypeWriter.m3300b(byteBuffer, (long) this.sampleInfoSizes.length);
            for (int c : this.sampleInfoSizes) {
                IsoTypeWriter.m3303c(byteBuffer, c);
            }
            return;
        }
        IsoTypeWriter.m3300b(byteBuffer, (long) this.sampleCount);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.auxInfoType = IsoTypeReader.m3291k(byteBuffer);
            this.auxInfoTypeParameter = IsoTypeReader.m3291k(byteBuffer);
        }
        this.defaultSampleInfoSize = (short) IsoTypeReader.m3284d(byteBuffer);
        this.sampleCount = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        if (this.defaultSampleInfoSize == (short) 0) {
            this.sampleInfoSizes = new short[this.sampleCount];
            for (int i = 0; i < this.sampleCount; i++) {
                this.sampleInfoSizes[i] = (short) IsoTypeReader.m3284d(byteBuffer);
            }
        }
    }

    public String getAuxInfoType() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.auxInfoType;
    }

    public void setAuxInfoType(String str) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.auxInfoType = str;
    }

    public String getAuxInfoTypeParameter() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.auxInfoTypeParameter;
    }

    public void setAuxInfoTypeParameter(String str) {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.auxInfoTypeParameter = str;
    }

    public int getDefaultSampleInfoSize() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.defaultSampleInfoSize;
    }

    public void setDefaultSampleInfoSize(int i) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.defaultSampleInfoSize = (short) i;
    }

    public short[] getSampleInfoSizes() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        Object obj = new short[this.sampleInfoSizes.length];
        System.arraycopy(this.sampleInfoSizes, 0, obj, 0, this.sampleInfoSizes.length);
        return obj;
    }

    public void setSampleInfoSizes(short[] sArr) {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this, sArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.sampleInfoSizes = new short[sArr.length];
        System.arraycopy(sArr, 0, this.sampleInfoSizes, 0, sArr.length);
    }

    public int getSampleCount() {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.sampleCount;
    }

    public void setSampleCount(int i) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.sampleCount = i;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("SampleAuxiliaryInformationSizesBox{defaultSampleInfoSize=");
        stringBuilder.append(this.defaultSampleInfoSize);
        stringBuilder.append(", sampleCount=");
        stringBuilder.append(this.sampleCount);
        stringBuilder.append(", auxInfoType='");
        stringBuilder.append(this.auxInfoType);
        stringBuilder.append('\'');
        stringBuilder.append(", auxInfoTypeParameter='");
        stringBuilder.append(this.auxInfoTypeParameter);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
