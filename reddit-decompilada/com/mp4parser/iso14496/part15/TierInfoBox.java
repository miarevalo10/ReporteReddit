package com.mp4parser.iso14496.part15;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TierInfoBox extends AbstractBox {
    public static final String TYPE = "tiri";
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
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    int constantFrameRate;
    int discardable;
    int frameRate;
    int levelIndication;
    int profileIndication;
    int profile_compatibility;
    int reserved1 = 0;
    int reserved2 = 0;
    int tierID;
    int visualHeight;
    int visualWidth;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TierInfoBox.java", TierInfoBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getTierID", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 69);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setTierID", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "tierID", "", "void"), 73);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getVisualWidth", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 109);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setVisualWidth", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "visualWidth", "", "void"), 113);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "getVisualHeight", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 117);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "setVisualHeight", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "visualHeight", "", "void"), 121);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "getDiscardable", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 125);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "setDiscardable", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "discardable", "", "void"), 129);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "getConstantFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 133);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "setConstantFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "constantFrameRate", "", "void"), 137);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "getReserved2", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 141);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "setReserved2", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "reserved2", "", "void"), 145);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getProfileIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 77);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "getFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 149);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "setFrameRate", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "frameRate", "", "void"), 153);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setProfileIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "profileIndication", "", "void"), 81);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getProfile_compatibility", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 85);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setProfile_compatibility", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "profile_compatibility", "", "void"), 89);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getLevelIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 93);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setLevelIndication", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "levelIndication", "", "void"), 97);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getReserved1", "com.mp4parser.iso14496.part15.TierInfoBox", "", "", "", "int"), 101);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setReserved1", "com.mp4parser.iso14496.part15.TierInfoBox", "int", "reserved1", "", "void"), 105);
    }

    protected long getContentSize() {
        return 13;
    }

    public TierInfoBox() {
        super(TYPE);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3299b(byteBuffer, this.tierID);
        IsoTypeWriter.m3303c(byteBuffer, this.profileIndication);
        IsoTypeWriter.m3303c(byteBuffer, this.profile_compatibility);
        IsoTypeWriter.m3303c(byteBuffer, this.levelIndication);
        IsoTypeWriter.m3303c(byteBuffer, this.reserved1);
        IsoTypeWriter.m3299b(byteBuffer, this.visualWidth);
        IsoTypeWriter.m3299b(byteBuffer, this.visualHeight);
        IsoTypeWriter.m3303c(byteBuffer, ((this.discardable << 6) + (this.constantFrameRate << 4)) + this.reserved2);
        IsoTypeWriter.m3299b(byteBuffer, this.frameRate);
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        this.tierID = IsoTypeReader.m3283c(byteBuffer);
        this.profileIndication = IsoTypeReader.m3284d(byteBuffer);
        this.profile_compatibility = IsoTypeReader.m3284d(byteBuffer);
        this.levelIndication = IsoTypeReader.m3284d(byteBuffer);
        this.reserved1 = IsoTypeReader.m3284d(byteBuffer);
        this.visualWidth = IsoTypeReader.m3283c(byteBuffer);
        this.visualHeight = IsoTypeReader.m3283c(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        this.discardable = (d & JpegConst.SOF0) >> 6;
        this.constantFrameRate = (d & 48) >> 4;
        this.reserved2 = d & 15;
        this.frameRate = IsoTypeReader.m3283c(byteBuffer);
    }

    public int getTierID() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.tierID;
    }

    public void setTierID(int i) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.tierID = i;
    }

    public int getProfileIndication() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.profileIndication;
    }

    public void setProfileIndication(int i) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.profileIndication = i;
    }

    public int getProfile_compatibility() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.profile_compatibility;
    }

    public void setProfile_compatibility(int i) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.profile_compatibility = i;
    }

    public int getLevelIndication() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.levelIndication;
    }

    public void setLevelIndication(int i) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.levelIndication = i;
    }

    public int getReserved1() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reserved1;
    }

    public void setReserved1(int i) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.reserved1 = i;
    }

    public int getVisualWidth() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.visualWidth;
    }

    public void setVisualWidth(int i) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.visualWidth = i;
    }

    public int getVisualHeight() {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.visualHeight;
    }

    public void setVisualHeight(int i) {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.visualHeight = i;
    }

    public int getDiscardable() {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.discardable;
    }

    public void setDiscardable(int i) {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.discardable = i;
    }

    public int getConstantFrameRate() {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.constantFrameRate;
    }

    public void setConstantFrameRate(int i) {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.constantFrameRate = i;
    }

    public int getReserved2() {
        JoinPoint a = Factory.a(ajc$tjp_18, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reserved2;
    }

    public void setReserved2(int i) {
        JoinPoint a = Factory.a(ajc$tjp_19, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.reserved2 = i;
    }

    public int getFrameRate() {
        JoinPoint a = Factory.a(ajc$tjp_20, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.frameRate;
    }

    public void setFrameRate(int i) {
        JoinPoint a = Factory.a(ajc$tjp_21, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.frameRate = i;
    }
}
