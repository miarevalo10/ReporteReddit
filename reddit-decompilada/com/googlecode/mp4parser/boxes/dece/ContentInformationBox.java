package com.googlecode.mp4parser.boxes.dece;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class ContentInformationBox extends AbstractFullBox {
    public static final String TYPE = "cinf";
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
    Map<String, String> brandEntries = new LinkedHashMap();
    String codecs;
    Map<String, String> idEntries = new LinkedHashMap();
    String languages;
    String mimeSubtypeName;
    String profileLevelIdc;
    String protection;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("ContentInformationBox.java", ContentInformationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 144);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setMimeSubtypeName", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "mimeSubtypeName", "", "void"), 148);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), MPEGConst.GROUP_START_CODE);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setBrandEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "brandEntries", "", "void"), 188);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "getIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.util.Map"), JpegConst.SOF0);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "setIdEntries", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.util.Map", "idEntries", "", "void"), JpegConst.DHT);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 152);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setProfileLevelIdc", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "profileLevelIdc", "", "void"), 156);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 160);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setCodecs", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "codecs", "", "void"), 164);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 168);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setProtection", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "protection", "", "void"), 172);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "", "", "", "java.lang.String"), 176);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setLanguages", "com.googlecode.mp4parser.boxes.dece.ContentInformationBox", "java.lang.String", "languages", "", "void"), 180);
    }

    public ContentInformationBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        long b = (((((4 + ((long) (Utf8.m3309b(this.mimeSubtypeName) + 1))) + ((long) (Utf8.m3309b(this.profileLevelIdc) + 1))) + ((long) (Utf8.m3309b(this.codecs) + 1))) + ((long) (Utf8.m3309b(this.protection) + 1))) + ((long) (Utf8.m3309b(this.languages) + 1))) + 1;
        for (Entry entry : this.brandEntries.entrySet()) {
            b = (b + ((long) (Utf8.m3309b((String) entry.getKey()) + 1))) + ((long) (Utf8.m3309b((String) entry.getValue()) + 1));
        }
        b++;
        for (Entry entry2 : this.idEntries.entrySet()) {
            b = (b + ((long) (Utf8.m3309b((String) entry2.getKey()) + 1))) + ((long) (Utf8.m3309b((String) entry2.getValue()) + 1));
        }
        return b;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3301b(byteBuffer, this.mimeSubtypeName);
        IsoTypeWriter.m3301b(byteBuffer, this.profileLevelIdc);
        IsoTypeWriter.m3301b(byteBuffer, this.codecs);
        IsoTypeWriter.m3301b(byteBuffer, this.protection);
        IsoTypeWriter.m3301b(byteBuffer, this.languages);
        IsoTypeWriter.m3303c(byteBuffer, this.brandEntries.size());
        for (Entry entry : this.brandEntries.entrySet()) {
            IsoTypeWriter.m3301b(byteBuffer, (String) entry.getKey());
            IsoTypeWriter.m3301b(byteBuffer, (String) entry.getValue());
        }
        IsoTypeWriter.m3303c(byteBuffer, this.idEntries.size());
        for (Entry entry2 : this.idEntries.entrySet()) {
            IsoTypeWriter.m3301b(byteBuffer, (String) entry2.getKey());
            IsoTypeWriter.m3301b(byteBuffer, (String) entry2.getValue());
        }
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.mimeSubtypeName = IsoTypeReader.m3285e(byteBuffer);
        this.profileLevelIdc = IsoTypeReader.m3285e(byteBuffer);
        this.codecs = IsoTypeReader.m3285e(byteBuffer);
        this.protection = IsoTypeReader.m3285e(byteBuffer);
        this.languages = IsoTypeReader.m3285e(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        while (true) {
            int i = d - 1;
            if (d <= 0) {
                break;
            }
            this.brandEntries.put(IsoTypeReader.m3285e(byteBuffer), IsoTypeReader.m3285e(byteBuffer));
            d = i;
        }
        d = IsoTypeReader.m3284d(byteBuffer);
        while (true) {
            i = d - 1;
            if (d > 0) {
                this.idEntries.put(IsoTypeReader.m3285e(byteBuffer), IsoTypeReader.m3285e(byteBuffer));
                d = i;
            } else {
                return;
            }
        }
    }

    public String getMimeSubtypeName() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.mimeSubtypeName;
    }

    public void setMimeSubtypeName(String str) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.mimeSubtypeName = str;
    }

    public String getProfileLevelIdc() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.profileLevelIdc;
    }

    public void setProfileLevelIdc(String str) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.profileLevelIdc = str;
    }

    public String getCodecs() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.codecs;
    }

    public void setCodecs(String str) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.codecs = str;
    }

    public String getProtection() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.protection;
    }

    public void setProtection(String str) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.protection = str;
    }

    public String getLanguages() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.languages;
    }

    public void setLanguages(String str) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.languages = str;
    }

    public Map<String, String> getBrandEntries() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.brandEntries;
    }

    public void setBrandEntries(Map<String, String> map) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, map);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.brandEntries = map;
    }

    public Map<String, String> getIdEntries() {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.idEntries;
    }

    public void setIdEntries(Map<String, String> map) {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this, map);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.idEntries = map;
    }
}
