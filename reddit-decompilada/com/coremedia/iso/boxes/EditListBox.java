package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class EditListBox extends AbstractFullBox {
    public static final String TYPE = "elst";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private List<Entry> entries = new LinkedList();

    public static class Entry {
        EditListBox editListBox;
        private double mediaRate;
        private long mediaTime;
        private long segmentDuration;

        public Entry(EditListBox editListBox, long j, long j2, double d) {
            this.segmentDuration = j;
            this.mediaTime = j2;
            this.mediaRate = d;
            this.editListBox = editListBox;
        }

        public Entry(EditListBox editListBox, ByteBuffer byteBuffer) {
            if (editListBox.getVersion() == 1) {
                this.segmentDuration = IsoTypeReader.m3286f(byteBuffer);
                this.mediaTime = byteBuffer.getLong();
                this.mediaRate = IsoTypeReader.m3287g(byteBuffer);
            } else {
                this.segmentDuration = IsoTypeReader.m3280a(byteBuffer);
                this.mediaTime = (long) byteBuffer.getInt();
                this.mediaRate = IsoTypeReader.m3287g(byteBuffer);
            }
            this.editListBox = editListBox;
        }

        public long getSegmentDuration() {
            return this.segmentDuration;
        }

        public void setSegmentDuration(long j) {
            this.segmentDuration = j;
        }

        public long getMediaTime() {
            return this.mediaTime;
        }

        public void setMediaTime(long j) {
            this.mediaTime = j;
        }

        public double getMediaRate() {
            return this.mediaRate;
        }

        public void setMediaRate(double d) {
            this.mediaRate = d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Entry entry = (Entry) obj;
                    return this.mediaTime == entry.mediaTime && this.segmentDuration == entry.segmentDuration;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((int) (this.segmentDuration ^ (this.segmentDuration >>> 32)))) + ((int) (this.mediaTime ^ (this.mediaTime >>> 32)));
        }

        public void getContent(ByteBuffer byteBuffer) {
            if (this.editListBox.getVersion() == 1) {
                IsoTypeWriter.m3296a(byteBuffer, this.segmentDuration);
                byteBuffer.putLong(this.mediaTime);
            } else {
                IsoTypeWriter.m3300b(byteBuffer, (long) CastUtils.m7705a(this.segmentDuration));
                byteBuffer.putInt(CastUtils.m7705a(this.mediaTime));
            }
            IsoTypeWriter.m3294a(byteBuffer, this.mediaRate);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{segmentDuration=");
            stringBuilder.append(this.segmentDuration);
            stringBuilder.append(", mediaTime=");
            stringBuilder.append(this.mediaTime);
            stringBuilder.append(", mediaRate=");
            stringBuilder.append(this.mediaRate);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("EditListBox.java", EditListBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.util.List"), 68);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.coremedia.iso.boxes.EditListBox", "java.util.List", "entries", "", "void"), 72);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.EditListBox", "", "", "", "java.lang.String"), 108);
    }

    public EditListBox() {
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
        if (getVersion() == 1) {
            return 8 + ((long) (this.entries.size() * 20));
        }
        return 8 + ((long) (this.entries.size() * 12));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.entries = new LinkedList();
        for (int i = 0; i < a; i++) {
            this.entries.add(new Entry(this, byteBuffer));
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, (long) this.entries.size());
        for (Entry content : this.entries) {
            content.getContent(byteBuffer);
        }
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("EditListBox{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
