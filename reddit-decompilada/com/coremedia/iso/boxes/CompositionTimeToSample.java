package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class CompositionTimeToSample extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "ctts";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    List<Entry> entries = Collections.emptyList();

    public static class Entry {
        int count;
        int offset;

        public Entry(int i, int i2) {
            this.count = i;
            this.offset = i2;
        }

        public int getCount() {
            return this.count;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setCount(int i) {
            this.count = i;
        }

        public void setOffset(int i) {
            this.offset = i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{count=");
            stringBuilder.append(this.count);
            stringBuilder.append(", offset=");
            stringBuilder.append(this.offset);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("CompositionTimeToSample.java", CompositionTimeToSample.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "", "", "", "java.util.List"), 57);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.coremedia.iso.boxes.CompositionTimeToSample", "java.util.List", "entries", "", "void"), 61);
    }

    public CompositionTimeToSample() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) (8 + (this.entries.size() * 8));
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

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.entries = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            this.entries.add(new Entry(CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer)), byteBuffer.getInt()));
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, (long) this.entries.size());
        for (Entry entry : this.entries) {
            IsoTypeWriter.m3300b(byteBuffer, (long) entry.getCount());
            byteBuffer.putInt(entry.getOffset());
        }
    }

    public static int[] blowupCompositionTimes(List<Entry> list) {
        long j = 0;
        for (Entry count : list) {
            j += (long) count.getCount();
        }
        int[] iArr = new int[((int) j)];
        list = null;
        for (Entry entry : list) {
            int i = list;
            list = null;
            while (list < entry.getCount()) {
                int i2 = i + 1;
                iArr[i] = entry.getOffset();
                list++;
                i = i2;
            }
            list = i;
        }
        return iArr;
    }
}
