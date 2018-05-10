package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public final class AvcConfigurationBox extends AbstractBox {
    public static final String TYPE = "avcC";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_11 = null;
    private static final StaticPart ajc$tjp_12 = null;
    private static final StaticPart ajc$tjp_13 = null;
    private static final StaticPart ajc$tjp_14 = null;
    private static final StaticPart ajc$tjp_15 = null;
    private static final StaticPart ajc$tjp_16 = null;
    private static final StaticPart ajc$tjp_17 = null;
    private static final StaticPart ajc$tjp_18 = null;
    private static final StaticPart ajc$tjp_19 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_20 = null;
    private static final StaticPart ajc$tjp_21 = null;
    private static final StaticPart ajc$tjp_22 = null;
    private static final StaticPart ajc$tjp_23 = null;
    private static final StaticPart ajc$tjp_24 = null;
    private static final StaticPart ajc$tjp_25 = null;
    private static final StaticPart ajc$tjp_26 = null;
    private static final StaticPart ajc$tjp_27 = null;
    private static final StaticPart ajc$tjp_28 = null;
    private static final StaticPart ajc$tjp_29 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    public AvcDecoderConfigurationRecord avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord();

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AvcConfigurationBox.java", AvcConfigurationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 44);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 48);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "setAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcLevelIndication", "", "void"), 84);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "lengthSizeMinusOne", "", "void"), 88);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "setSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSets", "", "void"), 92);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "setPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "pictureParameterSets", "", "void"), 96);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "getChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 100);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "setChromaFormat", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "chromaFormat", "", "void"), 104);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "getBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 108);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "setBitDepthLumaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthLumaMinus8", "", "void"), 112);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "getBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 116);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "setBitDepthChromaMinus8", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "bitDepthChromaMinus8", "", "void"), 120);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 52);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "getSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 124);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "setSequenceParameterSetExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.util.List", "sequenceParameterSetExts", "", "void"), 128);
        ajc$tjp_22 = factory.a("method-execution", factory.a("1", "hasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "boolean"), 132);
        ajc$tjp_23 = factory.a("method-execution", factory.a("1", "setHasExts", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "boolean", "hasExts", "", "void"), 136);
        ajc$tjp_24 = factory.a("method-execution", factory.a("1", "getContentSize", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "long"), 147);
        ajc$tjp_25 = factory.a("method-execution", factory.a("1", "getContent", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 153);
        ajc$tjp_26 = factory.a("method-execution", factory.a("1", "getSPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 158);
        ajc$tjp_27 = factory.a("method-execution", factory.a("1", "getPPS", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "[Ljava.lang.String;"), 162);
        ajc$tjp_28 = factory.a("method-execution", factory.a("1", "getavcDecoderConfigurationRecord", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "com.mp4parser.iso14496.part15.AvcDecoderConfigurationRecord"), 167);
        ajc$tjp_29 = factory.a("method-execution", factory.a("1", "toString", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.lang.String"), 172);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getAvcLevelIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 56);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getLengthSizeMinusOne", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "int"), 60);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getSequenceParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 64);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getPictureParameterSets", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "", "", "", "java.util.List"), 68);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setConfigurationVersion", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "configurationVersion", "", "void"), 72);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "setAvcProfileIndication", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "avcProfileIndication", "", "void"), 76);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setProfileCompatibility", "com.mp4parser.iso14496.part15.AvcConfigurationBox", "int", "profileCompatibility", "", "void"), 80);
    }

    public AvcConfigurationBox() {
        super(TYPE);
    }

    public final int getConfigurationVersion() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10047a;
    }

    public final int getAvcProfileIndication() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10048b;
    }

    public final int getProfileCompatibility() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10049c;
    }

    public final int getAvcLevelIndication() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10050d;
    }

    public final int getLengthSizeMinusOne() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10051e;
    }

    public final List<byte[]> getSequenceParameterSets() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.f10052f);
    }

    public final List<byte[]> getPictureParameterSets() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return Collections.unmodifiableList(this.avcDecoderConfigurationRecord.f10053g);
    }

    public final void setConfigurationVersion(int i) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10047a = i;
    }

    public final void setAvcProfileIndication(int i) {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10048b = i;
    }

    public final void setProfileCompatibility(int i) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10049c = i;
    }

    public final void setAvcLevelIndication(int i) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10050d = i;
    }

    public final void setLengthSizeMinusOne(int i) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10051e = i;
    }

    public final void setSequenceParameterSets(List<byte[]> list) {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10052f = list;
    }

    public final void setPictureParameterSets(List<byte[]> list) {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10053g = list;
    }

    public final int getChromaFormat() {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10055i;
    }

    public final void setChromaFormat(int i) {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10055i = i;
    }

    public final int getBitDepthLumaMinus8() {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10056j;
    }

    public final void setBitDepthLumaMinus8(int i) {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10056j = i;
    }

    public final int getBitDepthChromaMinus8() {
        JoinPoint a = Factory.a(ajc$tjp_18, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10057k;
    }

    public final void setBitDepthChromaMinus8(int i) {
        JoinPoint a = Factory.a(ajc$tjp_19, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10057k = i;
    }

    public final List<byte[]> getSequenceParameterSetExts() {
        JoinPoint a = Factory.a(ajc$tjp_20, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10058l;
    }

    public final void setSequenceParameterSetExts(List<byte[]> list) {
        JoinPoint a = Factory.a(ajc$tjp_21, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10058l = list;
    }

    public final boolean hasExts() {
        JoinPoint a = Factory.a(ajc$tjp_22, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.f10054h;
    }

    public final void setHasExts(boolean z) {
        JoinPoint a = Factory.a(ajc$tjp_23, this, this, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.f10054h = z;
    }

    public final void _parseDetails(ByteBuffer byteBuffer) {
        this.avcDecoderConfigurationRecord = new AvcDecoderConfigurationRecord(byteBuffer);
    }

    public final long getContentSize() {
        JoinPoint a = Factory.a(ajc$tjp_24, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.m8515a();
    }

    public final void getContent(ByteBuffer byteBuffer) {
        JoinPoint a = Factory.a(ajc$tjp_25, this, this, byteBuffer);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.avcDecoderConfigurationRecord.m8516a(byteBuffer);
    }

    public final String[] getSPS() {
        JoinPoint a = Factory.a(ajc$tjp_26, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.m8518c();
    }

    public final String[] getPPS() {
        JoinPoint a = Factory.a(ajc$tjp_27, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord.m8517b();
    }

    public final AvcDecoderConfigurationRecord getavcDecoderConfigurationRecord() {
        JoinPoint a = Factory.a(ajc$tjp_28, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.avcDecoderConfigurationRecord;
    }

    public final String toString() {
        JoinPoint a = Factory.a(ajc$tjp_29, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("AvcConfigurationBox{avcDecoderConfigurationRecord=");
        stringBuilder.append(this.avcDecoderConfigurationRecord);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
