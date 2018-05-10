package com.googlecode.mp4parser.boxes.threegpp26245;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class FontTableBox extends AbstractBox {
    public static final String TYPE = "ftab";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    List<FontRecord> entries = new LinkedList();

    public static class FontRecord {
        int f8996a;
        String f8997b;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("FontRecord{fontId=");
            stringBuilder.append(this.f8996a);
            stringBuilder.append(", fontname='");
            stringBuilder.append(this.f8997b);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("FontTableBox.java", FontTableBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "", "", "", "java.util.List"), 52);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26245.FontTableBox", "java.util.List", "entries", "", "void"), 56);
    }

    public FontTableBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        int i = 2;
        for (FontRecord fontRecord : this.entries) {
            i += Utf8.m3309b(fontRecord.f8997b) + 3;
        }
        return (long) i;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        int c = IsoTypeReader.m3283c(byteBuffer);
        for (int i = 0; i < c; i++) {
            FontRecord fontRecord = new FontRecord();
            fontRecord.f8996a = IsoTypeReader.m3283c(byteBuffer);
            fontRecord.f8997b = IsoTypeReader.m3281a(byteBuffer, IsoTypeReader.m3284d(byteBuffer));
            this.entries.add(fontRecord);
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3299b(byteBuffer, this.entries.size());
        for (FontRecord fontRecord : this.entries) {
            IsoTypeWriter.m3299b(byteBuffer, fontRecord.f8996a);
            IsoTypeWriter.m3303c(byteBuffer, fontRecord.f8997b.length());
            byteBuffer.put(Utf8.m3308a(fontRecord.f8997b));
        }
    }

    public List<FontRecord> getEntries() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.entries;
    }

    public void setEntries(List<FontRecord> list) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.entries = list;
    }
}
