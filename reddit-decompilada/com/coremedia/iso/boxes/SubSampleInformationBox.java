package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SubSampleInformationBox extends AbstractFullBox {
    public static final String TYPE = "subs";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private List<SubSampleEntry> entries = new ArrayList();

    public static class SubSampleEntry {
        private long sampleDelta;
        private List<SubsampleEntry> subsampleEntries = new ArrayList();

        public static class SubsampleEntry {
            private int discardable;
            private long reserved;
            private int subsamplePriority;
            private long subsampleSize;

            public long getSubsampleSize() {
                return this.subsampleSize;
            }

            public void setSubsampleSize(long j) {
                this.subsampleSize = j;
            }

            public int getSubsamplePriority() {
                return this.subsamplePriority;
            }

            public void setSubsamplePriority(int i) {
                this.subsamplePriority = i;
            }

            public int getDiscardable() {
                return this.discardable;
            }

            public void setDiscardable(int i) {
                this.discardable = i;
            }

            public long getReserved() {
                return this.reserved;
            }

            public void setReserved(long j) {
                this.reserved = j;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("SubsampleEntry{subsampleSize=");
                stringBuilder.append(this.subsampleSize);
                stringBuilder.append(", subsamplePriority=");
                stringBuilder.append(this.subsamplePriority);
                stringBuilder.append(", discardable=");
                stringBuilder.append(this.discardable);
                stringBuilder.append(", reserved=");
                stringBuilder.append(this.reserved);
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
        }

        public long getSampleDelta() {
            return this.sampleDelta;
        }

        public void setSampleDelta(long j) {
            this.sampleDelta = j;
        }

        public int getSubsampleCount() {
            return this.subsampleEntries.size();
        }

        public List<SubsampleEntry> getSubsampleEntries() {
            return this.subsampleEntries;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("SampleEntry{sampleDelta=");
            stringBuilder.append(this.sampleDelta);
            stringBuilder.append(", subsampleCount=");
            stringBuilder.append(this.subsampleEntries.size());
            stringBuilder.append(", subsampleEntries=");
            stringBuilder.append(this.subsampleEntries);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SubSampleInformationBox.java", SubSampleInformationBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.util.List"), 50);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "java.util.List", "entries", "", "void"), 54);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.lang.String"), 124);
    }

    public SubSampleInformationBox() {
        super(TYPE);
    }

    public List<SubSampleEntry> getEntries() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.entries;
    }

    public void setEntries(List<SubSampleEntry> list) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.entries = list;
    }

    protected long getContentSize() {
        long j = 8;
        for (SubSampleEntry subsampleEntries : this.entries) {
            j = (j + 4) + 2;
            for (int i = 0; i < subsampleEntries.getSubsampleEntries().size(); i++) {
                j = ((getVersion() == 1 ? j + 4 : j + 2) + 2) + 4;
            }
        }
        return j;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        long a = IsoTypeReader.m3280a(byteBuffer);
        for (int i = 0; ((long) i) < a; i++) {
            SubSampleEntry subSampleEntry = new SubSampleEntry();
            subSampleEntry.setSampleDelta(IsoTypeReader.m3280a(byteBuffer));
            int c = IsoTypeReader.m3283c(byteBuffer);
            for (int i2 = 0; i2 < c; i2++) {
                SubsampleEntry subsampleEntry = new SubsampleEntry();
                subsampleEntry.setSubsampleSize(getVersion() == 1 ? IsoTypeReader.m3280a(byteBuffer) : (long) IsoTypeReader.m3283c(byteBuffer));
                subsampleEntry.setSubsamplePriority(IsoTypeReader.m3284d(byteBuffer));
                subsampleEntry.setDiscardable(IsoTypeReader.m3284d(byteBuffer));
                subsampleEntry.setReserved(IsoTypeReader.m3280a(byteBuffer));
                subSampleEntry.getSubsampleEntries().add(subsampleEntry);
            }
            this.entries.add(subSampleEntry);
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, (long) this.entries.size());
        for (SubSampleEntry subSampleEntry : this.entries) {
            IsoTypeWriter.m3300b(byteBuffer, subSampleEntry.getSampleDelta());
            IsoTypeWriter.m3299b(byteBuffer, subSampleEntry.getSubsampleCount());
            for (SubsampleEntry subsampleEntry : subSampleEntry.getSubsampleEntries()) {
                if (getVersion() == 1) {
                    IsoTypeWriter.m3300b(byteBuffer, subsampleEntry.getSubsampleSize());
                } else {
                    IsoTypeWriter.m3299b(byteBuffer, CastUtils.m7705a(subsampleEntry.getSubsampleSize()));
                }
                IsoTypeWriter.m3303c(byteBuffer, subsampleEntry.getSubsamplePriority());
                IsoTypeWriter.m3303c(byteBuffer, subsampleEntry.getDiscardable());
                IsoTypeWriter.m3300b(byteBuffer, subsampleEntry.getReserved());
            }
        }
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("SubSampleInformationBox{entryCount=");
        stringBuilder.append(this.entries.size());
        stringBuilder.append(", entries=");
        stringBuilder.append(this.entries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
