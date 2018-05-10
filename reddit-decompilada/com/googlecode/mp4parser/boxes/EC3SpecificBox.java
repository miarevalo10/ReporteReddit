package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitReaderBuffer;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.BitWriterBuffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class EC3SpecificBox extends AbstractBox {
    public static final String TYPE = "dec3";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    int dataRate;
    List<Entry> entries = new LinkedList();
    int numIndSub;

    public static class Entry {
        public int f8931a;
        public int f8932b;
        public int f8933c;
        public int f8934d;
        public int f8935e;
        public int f8936f;
        public int f8937g;
        public int f8938h;
        public int f8939i;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Entry{fscod=");
            stringBuilder.append(this.f8931a);
            stringBuilder.append(", bsid=");
            stringBuilder.append(this.f8932b);
            stringBuilder.append(", bsmod=");
            stringBuilder.append(this.f8933c);
            stringBuilder.append(", acmod=");
            stringBuilder.append(this.f8934d);
            stringBuilder.append(", lfeon=");
            stringBuilder.append(this.f8935e);
            stringBuilder.append(", reserved=");
            stringBuilder.append(this.f8936f);
            stringBuilder.append(", num_dep_sub=");
            stringBuilder.append(this.f8937g);
            stringBuilder.append(", chan_loc=");
            stringBuilder.append(this.f8938h);
            stringBuilder.append(", reserved2=");
            stringBuilder.append(this.f8939i);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("EC3SpecificBox.java", EC3SpecificBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getContentSize", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "long"), 25);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getContent", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 65);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "java.util.List"), 86);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setEntries", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "java.util.List", "entries", "", "void"), 90);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "addEntry", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "com.googlecode.mp4parser.boxes.EC3SpecificBox$Entry", "entry", "", "void"), 94);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 98);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "setDataRate", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "dataRate", "", "void"), 102);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "", "", "", "int"), 106);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "setNumIndSub", "com.googlecode.mp4parser.boxes.EC3SpecificBox", "int", "numIndSub", "", "void"), 110);
    }

    public EC3SpecificBox() {
        super(TYPE);
    }

    public long getContentSize() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        long j = 2;
        for (Entry entry : this.entries) {
            j = entry.f8937g > 0 ? j + 4 : j + 3;
        }
        return j;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        BitReaderBuffer bitReaderBuffer = new BitReaderBuffer(byteBuffer);
        this.dataRate = bitReaderBuffer.m7683a(13);
        this.numIndSub = bitReaderBuffer.m7683a(3) + 1;
        for (int i = 0; i < this.numIndSub; i++) {
            Entry entry = new Entry();
            entry.f8931a = bitReaderBuffer.m7683a(2);
            entry.f8932b = bitReaderBuffer.m7683a(5);
            entry.f8933c = bitReaderBuffer.m7683a(5);
            entry.f8934d = bitReaderBuffer.m7683a(3);
            entry.f8935e = bitReaderBuffer.m7683a(1);
            entry.f8936f = bitReaderBuffer.m7683a(3);
            entry.f8937g = bitReaderBuffer.m7683a(4);
            if (entry.f8937g > 0) {
                entry.f8938h = bitReaderBuffer.m7683a(9);
            } else {
                entry.f8939i = bitReaderBuffer.m7683a(1);
            }
            this.entries.add(entry);
        }
    }

    public void getContent(ByteBuffer byteBuffer) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, byteBuffer);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        BitWriterBuffer bitWriterBuffer = new BitWriterBuffer(byteBuffer);
        bitWriterBuffer.m7686a(this.dataRate, 13);
        bitWriterBuffer.m7686a(this.entries.size() - 1, 3);
        for (Entry entry : this.entries) {
            bitWriterBuffer.m7686a(entry.f8931a, 2);
            bitWriterBuffer.m7686a(entry.f8932b, 5);
            bitWriterBuffer.m7686a(entry.f8933c, 5);
            bitWriterBuffer.m7686a(entry.f8934d, 3);
            bitWriterBuffer.m7686a(entry.f8935e, 1);
            bitWriterBuffer.m7686a(entry.f8936f, 3);
            bitWriterBuffer.m7686a(entry.f8937g, 4);
            if (entry.f8937g > 0) {
                bitWriterBuffer.m7686a(entry.f8938h, 9);
            } else {
                bitWriterBuffer.m7686a(entry.f8939i, 1);
            }
        }
    }

    public List<Entry> getEntries() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.entries = list;
    }

    public void addEntry(Entry entry) {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this, entry);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.entries.add(entry);
    }

    public int getDataRate() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.dataRate;
    }

    public void setDataRate(int i) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.dataRate = i;
    }

    public int getNumIndSub() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.numIndSub;
    }

    public void setNumIndSub(int i) {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.numIndSub = i;
    }
}
