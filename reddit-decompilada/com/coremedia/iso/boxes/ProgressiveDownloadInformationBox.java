package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class ProgressiveDownloadInformationBox extends AbstractFullBox {
    public static final String TYPE = "pdin";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    List<Entry> entries = Collections.emptyList();

    public static class Entry {
        long initialDelay;
        long rate;

        public Entry(long j, long j2) {
            this.rate = j;
            this.initialDelay = j2;
        }

        public long getRate() {
            return this.rate;
        }

        public void setRate(long j) {
            this.rate = j;
        }

        public long getInitialDelay() {
            return this.initialDelay;
        }

        public void setInitialDelay(long j) {
            this.initialDelay = j;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{rate=");
            stringBuilder.append(this.rate);
            stringBuilder.append(", initialDelay=");
            stringBuilder.append(this.initialDelay);
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
                    return this.initialDelay == entry.initialDelay && this.rate == entry.rate;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((int) (this.rate ^ (this.rate >>> 32)))) + ((int) (this.initialDelay ^ (this.initialDelay >>> 32)));
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("ProgressiveDownloadInformationBox.java", ProgressiveDownloadInformationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.util.List"), 38);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "java.util.List", "entries", "", "void"), 42);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.ProgressiveDownloadInformationBox", "", "", "", "java.lang.String"), 112);
    }

    public ProgressiveDownloadInformationBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) (4 + (this.entries.size() * 8));
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        for (Entry entry : this.entries) {
            IsoTypeWriter.m3300b(byteBuffer, entry.getRate());
            IsoTypeWriter.m3300b(byteBuffer, entry.getInitialDelay());
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

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.entries = new LinkedList();
        while (byteBuffer.remaining() >= 8) {
            this.entries.add(new Entry(IsoTypeReader.m3280a(byteBuffer), IsoTypeReader.m3280a(byteBuffer)));
        }
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("ProgressiveDownloadInfoBox{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
