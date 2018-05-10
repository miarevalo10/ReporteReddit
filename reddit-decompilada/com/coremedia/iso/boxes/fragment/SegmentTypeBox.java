package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class SegmentTypeBox extends AbstractBox {
    public static final String TYPE = "styp";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private List<String> compatibleBrands = Collections.emptyList();
    private String majorBrand;
    private long minorVersion;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("SegmentTypeBox.java", SegmentTypeBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.lang.String"), 85);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setMajorBrand", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.lang.String", "majorBrand", "", "void"), 94);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "setMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "long", "minorVersion", "", "void"), 103);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getMinorVersion", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "long"), 113);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "", "", "", "java.util.List"), 122);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setCompatibleBrands", "com.coremedia.iso.boxes.fragment.SegmentTypeBox", "java.util.List", "compatibleBrands", "", "void"), 126);
    }

    public SegmentTypeBox() {
        super(TYPE);
    }

    public SegmentTypeBox(String str, long j, List<String> list) {
        super(TYPE);
        this.majorBrand = str;
        this.minorVersion = j;
        this.compatibleBrands = list;
    }

    protected long getContentSize() {
        return (long) (8 + (this.compatibleBrands.size() * 4));
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.majorBrand = IsoTypeReader.m3291k(byteBuffer);
        this.minorVersion = IsoTypeReader.m3280a(byteBuffer);
        int remaining = byteBuffer.remaining() / 4;
        this.compatibleBrands = new LinkedList();
        for (int i = 0; i < remaining; i++) {
            this.compatibleBrands.add(IsoTypeReader.m3291k(byteBuffer));
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(IsoFile.m17057a(this.majorBrand));
        IsoTypeWriter.m3300b(byteBuffer, this.minorVersion);
        for (String a : this.compatibleBrands) {
            byteBuffer.put(IsoFile.m17057a(a));
        }
    }

    public String getMajorBrand() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.majorBrand;
    }

    public void setMajorBrand(String str) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.majorBrand = str;
    }

    public void setMinorVersion(long j) {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.minorVersion = j;
    }

    public long getMinorVersion() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.minorVersion;
    }

    public List<String> getCompatibleBrands() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.compatibleBrands;
    }

    public void setCompatibleBrands(List<String> list) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, list);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.compatibleBrands = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SegmentTypeBox[");
        stringBuilder.append("majorBrand=");
        stringBuilder.append(getMajorBrand());
        stringBuilder.append(";");
        stringBuilder.append("minorVersion=");
        stringBuilder.append(getMinorVersion());
        for (String str : this.compatibleBrands) {
            stringBuilder.append(";");
            stringBuilder.append("compatibleBrand=");
            stringBuilder.append(str);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
