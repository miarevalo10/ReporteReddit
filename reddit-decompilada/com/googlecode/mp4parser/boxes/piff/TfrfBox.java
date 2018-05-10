package com.googlecode.mp4parser.boxes.piff;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.containers.mxf.model.BER;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TfrfBox extends AbstractFullBox {
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    public List<Entry> entries = new ArrayList();

    public class Entry {
        long f8987a;
        long f8988b;
        final /* synthetic */ TfrfBox f8989c;

        public Entry(TfrfBox tfrfBox) {
            this.f8989c = tfrfBox;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Entry");
            stringBuilder.append("{fragmentAbsoluteTime=");
            stringBuilder.append(this.f8987a);
            stringBuilder.append(", fragmentAbsoluteDuration=");
            stringBuilder.append(this.f8988b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TfrfBox.java", TfrfBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getFragmentCount", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "long"), 91);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getEntries", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.util.List"), 95);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.googlecode.mp4parser.boxes.piff.TfrfBox", "", "", "", "java.lang.String"), 100);
    }

    public TfrfBox() {
        super("uuid");
    }

    public byte[] getUserType() {
        return new byte[]{(byte) -44, BER.ASN_LONG_LEN, (byte) 126, (byte) -14, (byte) -54, (byte) 57, (byte) 70, (byte) -107, (byte) -114, (byte) 84, (byte) 38, (byte) -53, (byte) -98, (byte) 70, (byte) -89, (byte) -97};
    }

    protected long getContentSize() {
        return (long) (5 + (this.entries.size() * (getVersion() == 1 ? 16 : 8)));
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3303c(byteBuffer, this.entries.size());
        for (Entry entry : this.entries) {
            if (getVersion() == 1) {
                IsoTypeWriter.m3296a(byteBuffer, entry.f8987a);
                IsoTypeWriter.m3296a(byteBuffer, entry.f8988b);
            } else {
                IsoTypeWriter.m3300b(byteBuffer, entry.f8987a);
                IsoTypeWriter.m3300b(byteBuffer, entry.f8988b);
            }
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        for (int i = 0; i < d; i++) {
            Entry entry = new Entry(this);
            if (getVersion() == 1) {
                entry.f8987a = IsoTypeReader.m3286f(byteBuffer);
                entry.f8988b = IsoTypeReader.m3286f(byteBuffer);
            } else {
                entry.f8987a = IsoTypeReader.m3280a(byteBuffer);
                entry.f8988b = IsoTypeReader.m3280a(byteBuffer);
            }
            this.entries.add(entry);
        }
    }

    public long getFragmentCount() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (long) this.entries.size();
    }

    public List<Entry> getEntries() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.entries;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TfrfBox");
        stringBuilder.append("{entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
