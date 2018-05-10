package com.googlecode.mp4parser.boxes.threegpp26244;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SegmentIndexBox extends AbstractFullBox {
    public static final String TYPE = "sidx";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_11 = null;
    private static final StaticPart ajc$tjp_12 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    long earliestPresentationTime;
    List<Entry> entries = new ArrayList();
    long firstOffset;
    long referenceId;
    int reserved;
    long timeScale;

    public static class Entry {
        byte f8990a;
        int f8991b;
        long f8992c;
        byte f8993d;
        byte f8994e;
        int f8995f;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{referenceType=");
            stringBuilder.append(this.f8990a);
            stringBuilder.append(", referencedSize=");
            stringBuilder.append(this.f8991b);
            stringBuilder.append(", subsegmentDuration=");
            stringBuilder.append(this.f8992c);
            stringBuilder.append(", startsWithSap=");
            stringBuilder.append(this.f8993d);
            stringBuilder.append(", sapType=");
            stringBuilder.append(this.f8994e);
            stringBuilder.append(", sapDeltaTime=");
            stringBuilder.append(this.f8995f);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Entry entry = (Entry) obj;
                    return this.f8990a == entry.f8990a && this.f8991b == entry.f8991b && this.f8995f == entry.f8995f && this.f8994e == entry.f8994e && this.f8993d == entry.f8993d && this.f8992c == entry.f8992c;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((((((this.f8990a * 31) + this.f8991b) * 31) + ((int) (this.f8992c ^ (this.f8992c >>> 32)))) * 31) + this.f8993d) * 31) + this.f8994e)) + this.f8995f;
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SegmentIndexBox.java", SegmentIndexBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.util.List"), 128);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "java.util.List", "entries", "", "void"), 132);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "int"), 168);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setReserved", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "int", "reserved", "", "void"), 172);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "toString", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "java.lang.String"), 298);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 136);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setReferenceId", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "referenceId", "", "void"), 140);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 144);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setTimeScale", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "timeScale", "", "void"), 148);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 152);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setEarliestPresentationTime", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "earliestPresentationTime", "", "void"), 156);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "", "", "", "long"), 160);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setFirstOffset", "com.googlecode.mp4parser.boxes.threegpp26244.SegmentIndexBox", "long", "firstOffset", "", "void"), 164);
    }

    public SegmentIndexBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (((12 + ((long) (getVersion() == 0 ? 8 : 16))) + 2) + 2) + ((long) (this.entries.size() * 12));
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, this.referenceId);
        IsoTypeWriter.m3300b(byteBuffer, this.timeScale);
        if (getVersion() == 0) {
            IsoTypeWriter.m3300b(byteBuffer, this.earliestPresentationTime);
            IsoTypeWriter.m3300b(byteBuffer, this.firstOffset);
        } else {
            IsoTypeWriter.m3296a(byteBuffer, this.earliestPresentationTime);
            IsoTypeWriter.m3296a(byteBuffer, this.firstOffset);
        }
        IsoTypeWriter.m3299b(byteBuffer, this.reserved);
        IsoTypeWriter.m3299b(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.m7686a(entry.f8990a, 1);
            bitWriterBuffer.m7686a(entry.f8991b, 31);
            IsoTypeWriter.m3300b(byteBuffer, entry.f8992c);
            bitWriterBuffer = new BitWriterBuffer(byteBuffer);
            bitWriterBuffer.m7686a(entry.f8993d, 1);
            bitWriterBuffer.m7686a(entry.f8994e, 3);
            bitWriterBuffer.m7686a(entry.f8995f, 28);
        }
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.referenceId = IsoTypeReader.m3280a(byteBuffer);
        this.timeScale = IsoTypeReader.m3280a(byteBuffer);
        if (getVersion() == 0) {
            this.earliestPresentationTime = IsoTypeReader.m3280a(byteBuffer);
            this.firstOffset = IsoTypeReader.m3280a(byteBuffer);
        } else {
            this.earliestPresentationTime = IsoTypeReader.m3286f(byteBuffer);
            this.firstOffset = IsoTypeReader.m3286f(byteBuffer);
        }
        this.reserved = IsoTypeReader.m3283c(byteBuffer);
        int c = IsoTypeReader.m3283c(byteBuffer);
        for (int i = 0; i < c; i++) {
            BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            Entry entry = new Entry();
            entry.f8990a = (byte) bitReaderBuffer.m7683a(1);
            entry.f8991b = bitReaderBuffer.m7683a(31);
            entry.f8992c = IsoTypeReader.m3280a(byteBuffer);
            bitReaderBuffer = new BitReaderBuffer(byteBuffer);
            entry.f8993d = (byte) bitReaderBuffer.m7683a(1);
            entry.f8994e = (byte) bitReaderBuffer.m7683a(3);
            entry.f8995f = bitReaderBuffer.m7683a(28);
            this.entries.add(entry);
        }
    }

    public List<Entry> getEntries() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.entries = list;
    }

    public long getReferenceId() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.referenceId;
    }

    public void setReferenceId(long j) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.referenceId = j;
    }

    public long getTimeScale() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.timeScale;
    }

    public void setTimeScale(long j) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.timeScale = j;
    }

    public long getEarliestPresentationTime() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.earliestPresentationTime;
    }

    public void setEarliestPresentationTime(long j) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.earliestPresentationTime = j;
    }

    public long getFirstOffset() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.firstOffset;
    }

    public void setFirstOffset(long j) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.firstOffset = j;
    }

    public int getReserved() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reserved;
    }

    public void setReserved(int i) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.reserved = i;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("SegmentIndexBox{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append(", referenceId=");
        stringBuilder.append(this.referenceId);
        stringBuilder.append(", timeScale=");
        stringBuilder.append(this.timeScale);
        stringBuilder.append(", earliestPresentationTime=");
        stringBuilder.append(this.earliestPresentationTime);
        stringBuilder.append(", firstOffset=");
        stringBuilder.append(this.firstOffset);
        stringBuilder.append(", reserved=");
        stringBuilder.append(this.reserved);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
