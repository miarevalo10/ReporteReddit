package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TrackFragmentHeaderBox extends AbstractFullBox {
    public static final String TYPE = "tfhd";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_11 = null;
    private static final StaticPart ajc$tjp_12 = null;
    private static final StaticPart ajc$tjp_13 = null;
    private static final StaticPart ajc$tjp_14 = null;
    private static final StaticPart ajc$tjp_15 = null;
    private static final StaticPart ajc$tjp_16 = null;
    private static final StaticPart ajc$tjp_17 = null;
    private static final StaticPart ajc$tjp_18 = null;
    private static final StaticPart ajc$tjp_19 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_20 = null;
    private static final StaticPart ajc$tjp_21 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    private long baseDataOffset = -1;
    private boolean defaultBaseIsMoof;
    private long defaultSampleDuration = -1;
    private SampleFlags defaultSampleFlags;
    private long defaultSampleSize = -1;
    private boolean durationIsEmpty;
    private long sampleDescriptionIndex;
    private long trackId;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TrackFragmentHeaderBox.java", TrackFragmentHeaderBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "hasBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 126);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "hasSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 130);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "setSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "sampleDescriptionIndex", "", "void"), 171);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "getDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 180);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "setDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleDuration", "", "void"), MPEGConst.GROUP_START_CODE);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "getDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 191);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "setDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "defaultSampleSize", "", "void"), JpegConst.SOF3);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "getDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "com.coremedia.iso.boxes.fragment.SampleFlags"), 204);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "setDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "com.coremedia.iso.boxes.fragment.SampleFlags", "defaultSampleFlags", "", "void"), JpegConst.RST0);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "isDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), JpegConst.EOI);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "setDurationIsEmpty", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "durationIsEmpty", "", "void"), JpegConst.DRI);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "isDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), JpegConst.APP6);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "hasDefaultSampleDuration", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 134);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "setDefaultBaseIsMoof", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "boolean", "defaultBaseIsMoof", "", "void"), JpegConst.APPA);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "java.lang.String"), 244);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "hasDefaultSampleSize", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 138);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "hasDefaultSampleFlags", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "boolean"), 142);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 146);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "setTrackId", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "trackId", "", "void"), ModuleDescriptor.MODULE_VERSION);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 154);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "setBaseDataOffset", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "long", "baseDataOffset", "", "void"), 158);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "getSampleDescriptionIndex", "com.coremedia.iso.boxes.fragment.TrackFragmentHeaderBox", "", "", "", "long"), 167);
    }

    public TrackFragmentHeaderBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        int flags = getFlags();
        long j = (flags & 1) == 1 ? 16 : 8;
        if ((flags & 2) == 2) {
            j += 4;
        }
        if ((flags & 8) == 8) {
            j += 4;
        }
        if ((flags & 16) == 16) {
            j += 4;
        }
        return (flags & 32) == 32 ? j + 4 : j;
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, this.trackId);
        if ((getFlags() & 1) == 1) {
            IsoTypeWriter.m3296a(byteBuffer, getBaseDataOffset());
        }
        if ((getFlags() & 2) == 2) {
            IsoTypeWriter.m3300b(byteBuffer, getSampleDescriptionIndex());
        }
        if ((getFlags() & 8) == 8) {
            IsoTypeWriter.m3300b(byteBuffer, getDefaultSampleDuration());
        }
        if ((getFlags() & 16) == 16) {
            IsoTypeWriter.m3300b(byteBuffer, getDefaultSampleSize());
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags.getContent(byteBuffer);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.trackId = IsoTypeReader.m3280a(byteBuffer);
        if ((getFlags() & 1) == 1) {
            this.baseDataOffset = IsoTypeReader.m3286f(byteBuffer);
        }
        if ((getFlags() & 2) == 2) {
            this.sampleDescriptionIndex = IsoTypeReader.m3280a(byteBuffer);
        }
        if ((getFlags() & 8) == 8) {
            this.defaultSampleDuration = IsoTypeReader.m3280a(byteBuffer);
        }
        if ((getFlags() & 16) == 16) {
            this.defaultSampleSize = IsoTypeReader.m3280a(byteBuffer);
        }
        if ((getFlags() & 32) == 32) {
            this.defaultSampleFlags = new SampleFlags(byteBuffer);
        }
        if ((getFlags() & 65536) == 65536) {
            this.durationIsEmpty = true;
        }
        if ((getFlags() & 131072) == 131072) {
            this.defaultBaseIsMoof = true;
        }
    }

    public boolean hasBaseDataOffset() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 1) != 0;
    }

    public boolean hasSampleDescriptionIndex() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 2) != 0;
    }

    public boolean hasDefaultSampleDuration() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 8) != 0;
    }

    public boolean hasDefaultSampleSize() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 16) != 0;
    }

    public boolean hasDefaultSampleFlags() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 32) != 0;
    }

    public long getTrackId() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.trackId;
    }

    public void setTrackId(long j) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.trackId = j;
    }

    public long getBaseDataOffset() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.baseDataOffset;
    }

    public void setBaseDataOffset(long j) {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (j == -1) {
            setFlags(getFlags() & 2147483646);
        } else {
            setFlags(getFlags() | 1);
        }
        this.baseDataOffset = j;
    }

    public long getSampleDescriptionIndex() {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.sampleDescriptionIndex;
    }

    public void setSampleDescriptionIndex(long j) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (j == -1) {
            setFlags(getFlags() & 2147483645);
        } else {
            setFlags(getFlags() | 2);
        }
        this.sampleDescriptionIndex = j;
    }

    public long getDefaultSampleDuration() {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.defaultSampleDuration;
    }

    public void setDefaultSampleDuration(long j) {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        setFlags(getFlags() | 8);
        this.defaultSampleDuration = j;
    }

    public long getDefaultSampleSize() {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.defaultSampleSize;
    }

    public void setDefaultSampleSize(long j) {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (j != -1) {
            setFlags(getFlags() | 16);
        } else {
            setFlags(getFlags() & 16777199);
        }
        this.defaultSampleSize = j;
    }

    public SampleFlags getDefaultSampleFlags() {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.defaultSampleFlags;
    }

    public void setDefaultSampleFlags(SampleFlags sampleFlags) {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this, sampleFlags);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (sampleFlags != null) {
            setFlags(getFlags() | 32);
        } else {
            setFlags(getFlags() & 16777183);
        }
        this.defaultSampleFlags = sampleFlags;
    }

    public boolean isDurationIsEmpty() {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.durationIsEmpty;
    }

    public void setDurationIsEmpty(boolean z) {
        JoinPoint a = Factory.a(ajc$tjp_18, this, this, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (this.defaultBaseIsMoof) {
            setFlags(getFlags() | 65536);
        } else {
            setFlags(getFlags() & 16711679);
        }
        this.durationIsEmpty = z;
    }

    public boolean isDefaultBaseIsMoof() {
        JoinPoint a = Factory.a(ajc$tjp_19, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.defaultBaseIsMoof;
    }

    public void setDefaultBaseIsMoof(boolean z) {
        JoinPoint a = Factory.a(ajc$tjp_20, this, this, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (z) {
            setFlags(getFlags() | 131072);
        } else {
            setFlags(getFlags() & 16646143);
        }
        this.defaultBaseIsMoof = z;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_21, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackFragmentHeaderBox");
        stringBuilder.append("{trackId=");
        stringBuilder.append(this.trackId);
        stringBuilder.append(", baseDataOffset=");
        stringBuilder.append(this.baseDataOffset);
        stringBuilder.append(", sampleDescriptionIndex=");
        stringBuilder.append(this.sampleDescriptionIndex);
        stringBuilder.append(", defaultSampleDuration=");
        stringBuilder.append(this.defaultSampleDuration);
        stringBuilder.append(", defaultSampleSize=");
        stringBuilder.append(this.defaultSampleSize);
        stringBuilder.append(", defaultSampleFlags=");
        stringBuilder.append(this.defaultSampleFlags);
        stringBuilder.append(", durationIsEmpty=");
        stringBuilder.append(this.durationIsEmpty);
        stringBuilder.append(", defaultBaseIsMoof=");
        stringBuilder.append(this.defaultBaseIsMoof);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
