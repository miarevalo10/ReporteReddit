package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TrackFragmentRandomAccessBox extends AbstractFullBox {
    public static final String TYPE = "tfra";
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
    private List<Entry> entries = Collections.emptyList();
    private int lengthSizeOfSampleNum = 2;
    private int lengthSizeOfTrafNum = 2;
    private int lengthSizeOfTrunNum = 2;
    private int reserved;
    private long trackId;

    public static class Entry {
        private long moofOffset;
        private long sampleNumber;
        private long time;
        private long trafNumber;
        private long trunNumber;

        public Entry(long j, long j2, long j3, long j4, long j5) {
            this.moofOffset = j2;
            this.sampleNumber = j5;
            this.time = j;
            this.trafNumber = j3;
            this.trunNumber = j4;
        }

        public long getTime() {
            return this.time;
        }

        public long getMoofOffset() {
            return this.moofOffset;
        }

        public long getTrafNumber() {
            return this.trafNumber;
        }

        public long getTrunNumber() {
            return this.trunNumber;
        }

        public long getSampleNumber() {
            return this.sampleNumber;
        }

        public void setTime(long j) {
            this.time = j;
        }

        public void setMoofOffset(long j) {
            this.moofOffset = j;
        }

        public void setTrafNumber(long j) {
            this.trafNumber = j;
        }

        public void setTrunNumber(long j) {
            this.trunNumber = j;
        }

        public void setSampleNumber(long j) {
            this.sampleNumber = j;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{time=");
            stringBuilder.append(this.time);
            stringBuilder.append(", moofOffset=");
            stringBuilder.append(this.moofOffset);
            stringBuilder.append(", trafNumber=");
            stringBuilder.append(this.trafNumber);
            stringBuilder.append(", trunNumber=");
            stringBuilder.append(this.trunNumber);
            stringBuilder.append(", sampleNumber=");
            stringBuilder.append(this.sampleNumber);
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
                    return this.moofOffset == entry.moofOffset && this.sampleNumber == entry.sampleNumber && this.time == entry.time && this.trafNumber == entry.trafNumber && this.trunNumber == entry.trunNumber;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((((((int) (this.time ^ (this.time >>> 32))) * 31) + ((int) (this.moofOffset ^ (this.moofOffset >>> 32)))) * 31) + ((int) (this.trafNumber ^ (this.trafNumber >>> 32)))) * 31) + ((int) (this.trunNumber ^ (this.trunNumber >>> 32))))) + ((int) (this.sampleNumber ^ (this.sampleNumber >>> 32)));
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TrackFragmentRandomAccessBox.java", TrackFragmentRandomAccessBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "long", "trackId", "", "void"), 145);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrafNum", "", "void"), 149);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.util.List"), 185);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "java.util.List", "entries", "", "void"), 189);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "java.lang.String"), 290);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "setLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfTrunNum", "", "void"), 153);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "int", "lengthSizeOfSampleNum", "", "void"), 157);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), 161);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getReserved", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 165);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getLengthSizeOfTrafNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 169);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getLengthSizeOfTrunNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 173);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getLengthSizeOfSampleNum", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "int"), 177);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "getNumberOfEntries", "com.coremedia.iso.boxes.fragment.TrackFragmentRandomAccessBox", "", "", "", "long"), MPEGConst.EXTENSION_START_CODE);
    }

    public TrackFragmentRandomAccessBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        long size;
        if (getVersion() == 1) {
            size = 16 + ((long) (16 * this.entries.size()));
        } else {
            size = 16 + ((long) (8 * this.entries.size()));
        }
        return ((size + ((long) (this.lengthSizeOfTrafNum * this.entries.size()))) + ((long) (this.lengthSizeOfTrunNum * this.entries.size()))) + ((long) (this.lengthSizeOfSampleNum * this.entries.size()));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.m3280a(byteBuffer);
        long a = IsoTypeReader.m3280a(byteBuffer);
        this.reserved = (int) (a >> 6);
        this.lengthSizeOfTrafNum = (((int) (63 & a)) >> 4) + 1;
        this.lengthSizeOfTrunNum = (((int) (12 & a)) >> 2) + 1;
        this.lengthSizeOfSampleNum = ((int) (a & 3)) + 1;
        a = IsoTypeReader.m3280a(byteBuffer);
        this.entries = new ArrayList();
        for (int i = 0; ((long) i) < a; i++) {
            Entry entry = new Entry();
            if (getVersion() == 1) {
                entry.time = IsoTypeReader.m3286f(byteBuffer);
                entry.moofOffset = IsoTypeReader.m3286f(byteBuffer);
            } else {
                entry.time = IsoTypeReader.m3280a(byteBuffer);
                entry.moofOffset = IsoTypeReader.m3280a(byteBuffer);
            }
            entry.trafNumber = IsoTypeReaderVariable.m3293a(byteBuffer, this.lengthSizeOfTrafNum);
            entry.trunNumber = IsoTypeReaderVariable.m3293a(byteBuffer, this.lengthSizeOfTrunNum);
            entry.sampleNumber = IsoTypeReaderVariable.m3293a(byteBuffer, this.lengthSizeOfSampleNum);
            this.entries.add(entry);
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, this.trackId);
        IsoTypeWriter.m3300b(byteBuffer, ((((long) (this.reserved << 6)) | ((long) (((this.lengthSizeOfTrafNum - 1) & 3) << 4))) | ((long) (((this.lengthSizeOfTrunNum - 1) & 3) << 2))) | ((long) ((this.lengthSizeOfSampleNum - 1) & 3)));
        IsoTypeWriter.m3300b(byteBuffer, (long) this.entries.size());
        for (Entry entry : this.entries) {
            if (getVersion() == 1) {
                IsoTypeWriter.m3296a(byteBuffer, entry.time);
                IsoTypeWriter.m3296a(byteBuffer, entry.moofOffset);
            } else {
                IsoTypeWriter.m3300b(byteBuffer, entry.time);
                IsoTypeWriter.m3300b(byteBuffer, entry.moofOffset);
            }
            IsoTypeWriterVariable.m3306a(entry.trafNumber, byteBuffer, this.lengthSizeOfTrafNum);
            IsoTypeWriterVariable.m3306a(entry.trunNumber, byteBuffer, this.lengthSizeOfTrunNum);
            IsoTypeWriterVariable.m3306a(entry.sampleNumber, byteBuffer, this.lengthSizeOfSampleNum);
        }
    }

    public void setTrackId(long j) {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.trackId = j;
    }

    public void setLengthSizeOfTrafNum(int i) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.lengthSizeOfTrafNum = i;
    }

    public void setLengthSizeOfTrunNum(int i) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.lengthSizeOfTrunNum = i;
    }

    public void setLengthSizeOfSampleNum(int i) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.lengthSizeOfSampleNum = i;
    }

    public long getTrackId() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.trackId;
    }

    public int getReserved() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.reserved;
    }

    public int getLengthSizeOfTrafNum() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.lengthSizeOfTrafNum;
    }

    public int getLengthSizeOfTrunNum() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.lengthSizeOfTrunNum;
    }

    public int getLengthSizeOfSampleNum() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.lengthSizeOfSampleNum;
    }

    public long getNumberOfEntries() {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (long) this.entries.size();
    }

    public List<Entry> getEntries() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return Collections.unmodifiableList(this.entries);
    }

    public void setEntries(List<Entry> list) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.entries = list;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("TrackFragmentRandomAccessBox{trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
