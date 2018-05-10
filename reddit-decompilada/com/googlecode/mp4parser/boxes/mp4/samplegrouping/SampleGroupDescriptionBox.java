package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import com.mp4parser.iso14496.part15.StepwiseTemporalLayerEntry;
import com.mp4parser.iso14496.part15.SyncSampleEntry;
import com.mp4parser.iso14496.part15.TemporalLayerSampleGroup;
import com.mp4parser.iso14496.part15.TemporalSubLayerSampleGroup;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SampleGroupDescriptionBox extends AbstractFullBox {
    public static final String TYPE = "sgpd";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private int defaultLength;
    private List<GroupEntry> groupEntries = new LinkedList();
    private String groupingType;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SampleGroupDescriptionBox.java", SampleGroupDescriptionBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 57);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setGroupingType", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.String", "groupingType", "", "void"), 61);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 153);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setDefaultLength", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "int", "defaultLength", "", "void"), 157);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.util.List"), 161);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setGroupEntries", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.util.List", "groupEntries", "", "void"), 165);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "equals", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "java.lang.Object", "o", "", "boolean"), 170);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "hashCode", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "int"), 191);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "toString", "com.googlecode.mp4parser.boxes.mp4.samplegrouping.SampleGroupDescriptionBox", "", "", "", "java.lang.String"), 199);
    }

    public SampleGroupDescriptionBox() {
        super(TYPE);
        setVersion(1);
    }

    public String getGroupingType() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.groupingType;
    }

    public void setGroupingType(String str) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.groupingType = str;
    }

    protected long getContentSize() {
        long j = (getVersion() == 1 ? 12 : 8) + 4;
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                j += 4;
            }
            j += (long) groupEntry.mo2655c();
        }
        return j;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(IsoFile.m17057a(this.groupingType));
        if (getVersion() == 1) {
            IsoTypeWriter.m3300b(byteBuffer, (long) this.defaultLength);
        }
        IsoTypeWriter.m3300b(byteBuffer, (long) this.groupEntries.size());
        for (GroupEntry groupEntry : this.groupEntries) {
            if (getVersion() == 1 && this.defaultLength == 0) {
                IsoTypeWriter.m3300b(byteBuffer, (long) groupEntry.mo2528b().limit());
            }
            byteBuffer.put(groupEntry.mo2528b());
        }
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() != 1) {
            throw new RuntimeException("SampleGroupDescriptionBox are only supported in version 1");
        }
        this.groupingType = IsoTypeReader.m3291k(byteBuffer);
        if (getVersion() == 1) {
            this.defaultLength = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        }
        long a = IsoTypeReader.m3280a(byteBuffer);
        while (true) {
            long j = a - 1;
            if (a > 0) {
                int i = this.defaultLength;
                if (getVersion() == 1) {
                    if (this.defaultLength == 0) {
                        i = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
                    }
                    int position = byteBuffer.position() + i;
                    ByteBuffer slice = byteBuffer.slice();
                    slice.limit(i);
                    this.groupEntries.add(parseGroupEntry(slice, this.groupingType));
                    byteBuffer.position(position);
                    a = j;
                } else {
                    throw new RuntimeException("This should be implemented");
                }
            }
            return;
        }
    }

    private GroupEntry parseGroupEntry(ByteBuffer byteBuffer, String str) {
        if ("roll".equals(str)) {
            str = new RollRecoveryEntry();
        } else if ("rash".equals(str)) {
            str = new RateShareEntry();
        } else if ("seig".equals(str)) {
            str = new CencSampleEncryptionInformationGroupEntry();
        } else if ("rap ".equals(str)) {
            str = new VisualRandomAccessEntry();
        } else if ("tele".equals(str)) {
            str = new TemporalLevelEntry();
        } else if ("sync".equals(str)) {
            str = new SyncSampleEntry();
        } else if ("tscl".equals(str)) {
            str = new TemporalLayerSampleGroup();
        } else if ("tsas".equals(str)) {
            str = new TemporalSubLayerSampleGroup();
        } else if ("stsa".equals(str)) {
            str = new StepwiseTemporalLayerEntry();
        } else {
            str = new UnknownEntry(str);
        }
        str.mo2527a(byteBuffer);
        return str;
    }

    public int getDefaultLength() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.defaultLength;
    }

    public void setDefaultLength(int i) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.defaultLength = i;
    }

    public List<GroupEntry> getGroupEntries() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.groupEntries;
    }

    public void setGroupEntries(List<GroupEntry> list) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.groupEntries = list;
    }

    public boolean equals(Object obj) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, obj);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                SampleGroupDescriptionBox sampleGroupDescriptionBox = (SampleGroupDescriptionBox) obj;
                if (this.defaultLength != sampleGroupDescriptionBox.defaultLength) {
                    return false;
                }
                if (this.groupEntries == null) {
                    return sampleGroupDescriptionBox.groupEntries == null;
                } else {
                    if (this.groupEntries.equals(sampleGroupDescriptionBox.groupEntries) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        int i = 0;
        int i2 = 31 * (this.defaultLength + 0);
        if (this.groupEntries != null) {
            i = this.groupEntries.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("SampleGroupDescriptionBox{groupingType='");
        stringBuilder.append(this.groupEntries.size() > 0 ? ((GroupEntry) this.groupEntries.get(0)).mo2526a() : "????");
        stringBuilder.append('\'');
        stringBuilder.append(", defaultLength=");
        stringBuilder.append(this.defaultLength);
        stringBuilder.append(", groupEntries=");
        stringBuilder.append(this.groupEntries);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
