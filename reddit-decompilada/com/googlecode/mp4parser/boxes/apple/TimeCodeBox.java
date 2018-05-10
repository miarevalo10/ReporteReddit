package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.coremedia.iso.boxes.sampleentry.SampleEntry;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.List;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TimeCodeBox extends AbstractBox implements Container, SampleEntry {
    public static final String TYPE = "tmcd";
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
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    int dataReferenceIndex;
    long flags;
    int frameDuration;
    int numberOfFrames;
    int reserved1;
    int reserved2;
    byte[] rest = new byte[0];
    int timeScale;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TimeCodeBox.java", TimeCodeBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 88);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setDataReferenceIndex", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "dataReferenceIndex", "", "void"), 92);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "setReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved1", "", "void"), 137);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "getReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 141);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "setReserved2", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "reserved2", "", "void"), 145);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "getFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "long"), 149);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "setFlags", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long", "flags", "", "void"), 153);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "getRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "[B"), 157);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "setRest", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "[B", "rest", "", "void"), 161);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.util.List"), 166);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "setBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.util.List", "boxes", "", "void"), 170);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class", "clazz", "", "java.util.List"), 174);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "java.lang.String"), 98);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "getBoxes", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.lang.Class:boolean", "clazz:recursive", "", "java.util.List"), MPEGConst.USER_DATA_START_CODE);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "getByteBuffer", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "long:long", "start:size", "java.io.IOException", "java.nio.ByteBuffer"), 182);
        ajc$tjp_22 = factory.a("method-execution", factory.a("1", "writeContainer", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "java.nio.channels.WritableByteChannel", "bb", "java.io.IOException", "void"), 186);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 109);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "setTimeScale", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "timeScale", "", "void"), 113);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 117);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "setFrameDuration", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "frameDuration", "", "void"), 121);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 125);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "setNumberOfFrames", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "int", "numberOfFrames", "", "void"), 129);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "getReserved1", "com.googlecode.mp4parser.boxes.apple.TimeCodeBox", "", "", "", "int"), 133);
    }

    public TimeCodeBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) (28 + this.rest.length);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(new byte[6]);
        IsoTypeWriter.m3299b(byteBuffer, this.dataReferenceIndex);
        byteBuffer.putInt(this.reserved1);
        IsoTypeWriter.m3300b(byteBuffer, this.flags);
        byteBuffer.putInt(this.timeScale);
        byteBuffer.putInt(this.frameDuration);
        IsoTypeWriter.m3303c(byteBuffer, this.numberOfFrames);
        IsoTypeWriter.m3295a(byteBuffer, this.reserved2);
        byteBuffer.put(this.rest);
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.m3283c(byteBuffer);
        this.reserved1 = byteBuffer.getInt();
        this.flags = IsoTypeReader.m3280a(byteBuffer);
        this.timeScale = byteBuffer.getInt();
        this.frameDuration = byteBuffer.getInt();
        this.numberOfFrames = IsoTypeReader.m3284d(byteBuffer);
        this.reserved2 = IsoTypeReader.m3282b(byteBuffer);
        this.rest = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.rest);
    }

    public int getDataReferenceIndex() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.dataReferenceIndex;
    }

    public void setDataReferenceIndex(int i) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.dataReferenceIndex = i;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("TimeCodeBox{timeScale=");
        stringBuilder.append(this.timeScale);
        stringBuilder.append(", frameDuration=");
        stringBuilder.append(this.frameDuration);
        stringBuilder.append(", numberOfFrames=");
        stringBuilder.append(this.numberOfFrames);
        stringBuilder.append(", reserved1=");
        stringBuilder.append(this.reserved1);
        stringBuilder.append(", reserved2=");
        stringBuilder.append(this.reserved2);
        stringBuilder.append(", flags=");
        stringBuilder.append(this.flags);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public int getTimeScale() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.timeScale;
    }

    public void setTimeScale(int i) {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.timeScale = i;
    }

    public int getFrameDuration() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.frameDuration;
    }

    public void setFrameDuration(int i) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.frameDuration = i;
    }

    public int getNumberOfFrames() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.numberOfFrames;
    }

    public void setNumberOfFrames(int i) {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.numberOfFrames = i;
    }

    public int getReserved1() {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reserved1;
    }

    public void setReserved1(int i) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.reserved1 = i;
    }

    public int getReserved2() {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reserved2;
    }

    public void setReserved2(int i) {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.reserved2 = i;
    }

    public long getFlags() {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.flags;
    }

    public void setFlags(long j) {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.flags = j;
    }

    public byte[] getRest() {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.rest;
    }

    public void setRest(byte[] bArr) {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this, bArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.rest = bArr;
    }

    public List<Box> getBoxes() {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return Collections.emptyList();
    }

    public void setBoxes(List<Box> list) {
        list = Factory.a(ajc$tjp_18, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(list);
        throw new RuntimeException("Time Code Box doesn't accept any children");
    }

    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        cls = Factory.a(ajc$tjp_19, this, this, cls);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(cls);
        return Collections.emptyList();
    }

    public <T extends Box> List<T> getBoxes(Class<T> cls, boolean z) {
        cls = Factory.a(ajc$tjp_20, this, this, cls, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(cls);
        return Collections.emptyList();
    }

    public ByteBuffer getByteBuffer(long j, long j2) throws IOException {
        j = Factory.a(ajc$tjp_21, this, this, Conversions.a(j), Conversions.a(j2));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(j);
        return 0;
    }

    public void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel = Factory.a(ajc$tjp_22, this, this, writableByteChannel);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(writableByteChannel);
    }
}
