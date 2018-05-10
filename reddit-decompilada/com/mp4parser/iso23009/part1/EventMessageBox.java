package com.mp4parser.iso23009.part1;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class EventMessageBox extends AbstractFullBox {
    public static final String TYPE = "emsg";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_11 = null;
    private static final StaticPart ajc$tjp_12 = null;
    private static final StaticPart ajc$tjp_13 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    long eventDuration;
    long id;
    byte[] messageData;
    long presentationTimeDelta;
    String schemeIdUri;
    long timescale;
    String value;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("EventMessageBox.java", EventMessageBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 59);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setSchemeIdUri", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", "schemeIdUri", "", "void"), 63);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getId", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 99);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setId", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "id", "", "void"), 103);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "getMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "[B"), 107);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "setMessageData", "com.mp4parser.iso23009.part1.EventMessageBox", "[B", "messageData", "", "void"), 111);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getValue", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "java.lang.String"), 67);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setValue", "com.mp4parser.iso23009.part1.EventMessageBox", "java.lang.String", "value", "", "void"), 71);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 75);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setTimescale", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "timescale", "", "void"), 79);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 83);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setPresentationTimeDelta", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "presentationTimeDelta", "", "void"), 87);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", "", "", "", "long"), 91);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setEventDuration", "com.mp4parser.iso23009.part1.EventMessageBox", "long", "eventDuration", "", "void"), 95);
    }

    public EventMessageBox() {
        super(TYPE);
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.schemeIdUri = IsoTypeReader.m3285e(byteBuffer);
        this.value = IsoTypeReader.m3285e(byteBuffer);
        this.timescale = IsoTypeReader.m3280a(byteBuffer);
        this.presentationTimeDelta = IsoTypeReader.m3280a(byteBuffer);
        this.eventDuration = IsoTypeReader.m3280a(byteBuffer);
        this.id = IsoTypeReader.m3280a(byteBuffer);
        this.messageData = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.messageData);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3305c(byteBuffer, this.schemeIdUri);
        IsoTypeWriter.m3305c(byteBuffer, this.value);
        IsoTypeWriter.m3300b(byteBuffer, this.timescale);
        IsoTypeWriter.m3300b(byteBuffer, this.presentationTimeDelta);
        IsoTypeWriter.m3300b(byteBuffer, this.eventDuration);
        IsoTypeWriter.m3300b(byteBuffer, this.id);
        byteBuffer.put(this.messageData);
    }

    protected long getContentSize() {
        return (long) (((22 + Utf8.m3309b(this.schemeIdUri)) + Utf8.m3309b(this.value)) + this.messageData.length);
    }

    public String getSchemeIdUri() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.schemeIdUri;
    }

    public void setSchemeIdUri(String str) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.schemeIdUri = str;
    }

    public String getValue() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.value;
    }

    public void setValue(String str) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.value = str;
    }

    public long getTimescale() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.timescale;
    }

    public void setTimescale(long j) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.timescale = j;
    }

    public long getPresentationTimeDelta() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.presentationTimeDelta;
    }

    public void setPresentationTimeDelta(long j) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.presentationTimeDelta = j;
    }

    public long getEventDuration() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.eventDuration;
    }

    public void setEventDuration(long j) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.eventDuration = j;
    }

    public long getId() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.id;
    }

    public void setId(long j) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.id = j;
    }

    public byte[] getMessageData() {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.messageData;
    }

    public void setMessageData(byte[] bArr) {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this, bArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.messageData = bArr;
    }
}
