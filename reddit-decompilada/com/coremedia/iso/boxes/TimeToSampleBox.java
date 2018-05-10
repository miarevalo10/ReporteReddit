package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TimeToSampleBox extends AbstractFullBox {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "stts";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    static Map<List<Entry>, SoftReference<long[]>> cache = new WeakHashMap();
    List<Entry> entries = Collections.emptyList();

    public static class Entry {
        long count;
        long delta;

        public Entry(long j, long j2) {
            this.count = j;
            this.delta = j2;
        }

        public long getCount() {
            return this.count;
        }

        public long getDelta() {
            return this.delta;
        }

        public void setCount(long j) {
            this.count = j;
        }

        public void setDelta(long j) {
            this.delta = j;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{count=");
            stringBuilder.append(this.count);
            stringBuilder.append(", delta=");
            stringBuilder.append(this.delta);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TimeToSampleBox.java", TimeToSampleBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.util.List"), 79);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.coremedia.iso.boxes.TimeToSampleBox", "java.util.List", "entries", "", "void"), 83);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.TimeToSampleBox", "", "", "", "java.lang.String"), 87);
    }

    public TimeToSampleBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) (8 + (this.entries.size() * 8));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.entries = new ArrayList(a);
        for (int i = 0; i < a; i++) {
            this.entries.add(new Entry(IsoTypeReader.m3280a(byteBuffer), IsoTypeReader.m3280a(byteBuffer)));
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, (long) this.entries.size());
        for (Entry entry : this.entries) {
            IsoTypeWriter.m3300b(byteBuffer, entry.getCount());
            IsoTypeWriter.m3300b(byteBuffer, entry.getDelta());
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

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("TimeToSampleBox[entryCount=");
        stringBuilder.append(this.entries.size());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static {
        ajc$preClinit();
    }

    public static synchronized long[] blowupTimeToSamples(List<Entry> list) {
        synchronized (TimeToSampleBox.class) {
            SoftReference softReference = (SoftReference) cache.get(list);
            if (softReference != null) {
                long[] jArr = (long[]) softReference.get();
                if (jArr != null) {
                    return jArr;
                }
            }
            long j = 0;
            for (Entry count : list) {
                j += count.getCount();
            }
            Object obj = new long[((int) j)];
            int i = 0;
            for (Entry entry : list) {
                int i2 = i;
                i = 0;
                while (((long) i) < entry.getCount()) {
                    int i3 = i2 + 1;
                    obj[i2] = entry.getDelta();
                    i++;
                    i2 = i3;
                }
                i = i2;
            }
            cache.put(list, new SoftReference(obj));
            return obj;
        }
    }
}
