package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class AppleRecordingYearBox extends AppleDataBox {
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ssZ");

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AppleRecordingYearBox.java", AppleRecordingYearBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getDate", "com.googlecode.mp4parser.boxes.apple.AppleRecordingYearBox", "", "", "", "java.util.Date"), 27);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setDate", "com.googlecode.mp4parser.boxes.apple.AppleRecordingYearBox", "java.util.Date", "date", "", "void"), 31);
    }

    public AppleRecordingYearBox() {
        super("©day", 1);
        this.df.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public Date getDate() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.date;
    }

    public void setDate(Date date) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.date = date;
    }

    protected byte[] writeData() {
        return Utf8.m3308a(rfc822toIso8601Date(this.df.format(this.date)));
    }

    protected void parseData(ByteBuffer byteBuffer) {
        try {
            this.date = this.df.parse(iso8601toRfc822Date(IsoTypeReader.m3281a(byteBuffer, byteBuffer.remaining())));
        } catch (ByteBuffer byteBuffer2) {
            throw new RuntimeException(byteBuffer2);
        }
    }

    protected static String iso8601toRfc822Date(String str) {
        return str.replaceAll("Z$", "+0000").replaceAll("([0-9][0-9]):([0-9][0-9])$", "$1$2");
    }

    protected static String rfc822toIso8601Date(String str) {
        return str.replaceAll("\\+0000$", "Z");
    }

    protected int getDataLength() {
        return Utf8.m3308a(rfc822toIso8601Date(this.df.format(this.date))).length;
    }
}
