package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SampleToChunkBox extends AbstractFullBox {
    public static final String TYPE = "stsc";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    List<Entry> entries = Collections.emptyList();

    public static class Entry {
        long firstChunk;
        long sampleDescriptionIndex;
        long samplesPerChunk;

        public Entry(long j, long j2, long j3) {
            this.firstChunk = j;
            this.samplesPerChunk = j2;
            this.sampleDescriptionIndex = j3;
        }

        public long getFirstChunk() {
            return this.firstChunk;
        }

        public void setFirstChunk(long j) {
            this.firstChunk = j;
        }

        public long getSamplesPerChunk() {
            return this.samplesPerChunk;
        }

        public void setSamplesPerChunk(long j) {
            this.samplesPerChunk = j;
        }

        public long getSampleDescriptionIndex() {
            return this.sampleDescriptionIndex;
        }

        public void setSampleDescriptionIndex(long j) {
            this.sampleDescriptionIndex = j;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{firstChunk=");
            stringBuilder.append(this.firstChunk);
            stringBuilder.append(", samplesPerChunk=");
            stringBuilder.append(this.samplesPerChunk);
            stringBuilder.append(", sampleDescriptionIndex=");
            stringBuilder.append(this.sampleDescriptionIndex);
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
                    return this.firstChunk == entry.firstChunk && this.sampleDescriptionIndex == entry.sampleDescriptionIndex && this.samplesPerChunk == entry.samplesPerChunk;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((int) (this.firstChunk ^ (this.firstChunk >>> 32))) * 31) + ((int) (this.samplesPerChunk ^ (this.samplesPerChunk >>> 32))))) + ((int) (this.sampleDescriptionIndex ^ (this.sampleDescriptionIndex >>> 32)));
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SampleToChunkBox.java", SampleToChunkBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.util.List"), 47);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.coremedia.iso.boxes.SampleToChunkBox", "java.util.List", "entries", "", "void"), 51);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.SampleToChunkBox", "", "", "", "java.lang.String"), 84);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "blowup", "com.coremedia.iso.boxes.SampleToChunkBox", "int", "chunkCount", "", "[J"), 95);
    }

    public SampleToChunkBox() {
        super(TYPE);
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

    protected long getContentSize() {
        return (long) ((this.entries.size() * 12) + 8);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.entries = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            this.entries.add(new Entry(IsoTypeReader.m3280a(byteBuffer), IsoTypeReader.m3280a(byteBuffer), IsoTypeReader.m3280a(byteBuffer)));
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, (long) this.entries.size());
        for (Entry entry : this.entries) {
            IsoTypeWriter.m3300b(byteBuffer, entry.getFirstChunk());
            IsoTypeWriter.m3300b(byteBuffer, entry.getSamplesPerChunk());
            IsoTypeWriter.m3300b(byteBuffer, entry.getSampleDescriptionIndex());
        }
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("SampleToChunkBox[entryCount=");
        stringBuilder.append(this.entries.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public long[] blowup(int i) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        long[] jArr = new long[i];
        List linkedList = new LinkedList(this.entries);
        Collections.reverse(linkedList);
        Iterator it = linkedList.iterator();
        Entry entry = (Entry) it.next();
        while (i > 1) {
            jArr[i - 1] = entry.getSamplesPerChunk();
            if (((long) i) == entry.getFirstChunk()) {
                entry = (Entry) it.next();
            }
            i--;
        }
        jArr[0] = entry.getSamplesPerChunk();
        return jArr;
    }
}
