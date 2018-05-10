package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Logger;
import com.googlecode.mp4parser.util.Matrix;
import com.instabug.library.model.State;
import java.nio.ByteBuffer;
import java.util.Date;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TrackHeaderBox extends AbstractFullBox {
    private static Logger LOG = Logger.m7708a(TrackHeaderBox.class);
    public static final String TYPE = "tkhd";
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
    private static final StaticPart ajc$tjp_22 = null;
    private static final StaticPart ajc$tjp_23 = null;
    private static final StaticPart ajc$tjp_24 = null;
    private static final StaticPart ajc$tjp_25 = null;
    private static final StaticPart ajc$tjp_26 = null;
    private static final StaticPart ajc$tjp_27 = null;
    private static final StaticPart ajc$tjp_28 = null;
    private static final StaticPart ajc$tjp_29 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    private int alternateGroup;
    private Date creationTime = new Date(0);
    private long duration;
    private double height;
    private int layer;
    private Matrix matrix = Matrix.f9068j;
    private Date modificationTime = new Date(0);
    private long trackId;
    private float volume;
    private double width;

    private static void ajc$preClinit() {
        Factory factory = new Factory("TrackHeaderBox.java", TrackHeaderBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 62);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.util.Date"), 66);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "getContent", "com.coremedia.iso.boxes.TrackHeaderBox", "java.nio.ByteBuffer", "byteBuffer", "", "void"), 145);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "java.lang.String"), 173);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "setCreationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "creationTime", "", "void"), 199);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "setModificationTime", "com.coremedia.iso.boxes.TrackHeaderBox", "java.util.Date", "modificationTime", "", "void"), 206);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "setTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "long", "trackId", "", "void"), JpegConst.RST6);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "setDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "long", State.KEY_DURATION, "", "void"), JpegConst.SOS);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "setLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "layer", "", "void"), JpegConst.APP1);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "setAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "int", "alternateGroup", "", "void"), JpegConst.APP5);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "setVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "float", "volume", "", "void"), JpegConst.APP9);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "setMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), JpegConst.APPD);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getTrackId", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 70);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "setWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "width", "", "void"), 241);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "setHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "double", "height", "", "void"), 245);
        ajc$tjp_22 = factory.a("method-execution", factory.a("1", "isEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 250);
        ajc$tjp_23 = factory.a("method-execution", factory.a("1", "isInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), JpegConst.COM);
        ajc$tjp_24 = factory.a("method-execution", factory.a("1", "isInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 258);
        ajc$tjp_25 = factory.a("method-execution", factory.a("1", "isInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "boolean"), 262);
        ajc$tjp_26 = factory.a("method-execution", factory.a("1", "setEnabled", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "enabled", "", "void"), 266);
        ajc$tjp_27 = factory.a("method-execution", factory.a("1", "setInMovie", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inMovie", "", "void"), 274);
        ajc$tjp_28 = factory.a("method-execution", factory.a("1", "setInPreview", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPreview", "", "void"), 282);
        ajc$tjp_29 = factory.a("method-execution", factory.a("1", "setInPoster", "com.coremedia.iso.boxes.TrackHeaderBox", "boolean", "inPoster", "", "void"), 290);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getDuration", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "long"), 74);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getLayer", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 78);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getAlternateGroup", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "int"), 82);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getVolume", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "float"), 86);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getMatrix", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 90);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "getWidth", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 94);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "getHeight", "com.coremedia.iso.boxes.TrackHeaderBox", "", "", "", "double"), 98);
    }

    static {
        ajc$preClinit();
    }

    public TrackHeaderBox() {
        super(TYPE);
    }

    public Date getCreationTime() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.creationTime;
    }

    public Date getModificationTime() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.modificationTime;
    }

    public long getTrackId() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.trackId;
    }

    public long getDuration() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.duration;
    }

    public int getLayer() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.layer;
    }

    public int getAlternateGroup() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.alternateGroup;
    }

    public float getVolume() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.volume;
    }

    public Matrix getMatrix() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.matrix;
    }

    public double getWidth() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.width;
    }

    public double getHeight() {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.height;
    }

    protected long getContentSize() {
        return (getVersion() == 1 ? 36 : 24) + 60;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.creationTime = DateHelper.m7707a(IsoTypeReader.m3286f(byteBuffer));
            this.modificationTime = DateHelper.m7707a(IsoTypeReader.m3286f(byteBuffer));
            this.trackId = IsoTypeReader.m3280a(byteBuffer);
            IsoTypeReader.m3280a(byteBuffer);
            this.duration = byteBuffer.getLong();
        } else {
            this.creationTime = DateHelper.m7707a(IsoTypeReader.m3280a(byteBuffer));
            this.modificationTime = DateHelper.m7707a(IsoTypeReader.m3280a(byteBuffer));
            this.trackId = IsoTypeReader.m3280a(byteBuffer);
            IsoTypeReader.m3280a(byteBuffer);
            this.duration = (long) byteBuffer.getInt();
        }
        if (this.duration < -1) {
            LOG.mo2532b("tkhd duration is not in expected range");
        }
        IsoTypeReader.m3280a(byteBuffer);
        IsoTypeReader.m3280a(byteBuffer);
        this.layer = IsoTypeReader.m3283c(byteBuffer);
        this.alternateGroup = IsoTypeReader.m3283c(byteBuffer);
        this.volume = IsoTypeReader.m3289i(byteBuffer);
        IsoTypeReader.m3283c(byteBuffer);
        this.matrix = Matrix.m7713a(byteBuffer);
        this.width = IsoTypeReader.m3287g(byteBuffer);
        this.height = IsoTypeReader.m3287g(byteBuffer);
    }

    public void getContent(ByteBuffer byteBuffer) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, byteBuffer);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.m3296a(byteBuffer, DateHelper.m7706a(this.creationTime));
            IsoTypeWriter.m3296a(byteBuffer, DateHelper.m7706a(this.modificationTime));
            IsoTypeWriter.m3300b(byteBuffer, this.trackId);
            IsoTypeWriter.m3300b(byteBuffer, 0);
            byteBuffer.putLong(this.duration);
        } else {
            IsoTypeWriter.m3300b(byteBuffer, DateHelper.m7706a(this.creationTime));
            IsoTypeWriter.m3300b(byteBuffer, DateHelper.m7706a(this.modificationTime));
            IsoTypeWriter.m3300b(byteBuffer, this.trackId);
            IsoTypeWriter.m3300b(byteBuffer, 0);
            byteBuffer.putInt((int) this.duration);
        }
        IsoTypeWriter.m3300b(byteBuffer, 0);
        IsoTypeWriter.m3300b(byteBuffer, 0);
        IsoTypeWriter.m3299b(byteBuffer, this.layer);
        IsoTypeWriter.m3299b(byteBuffer, this.alternateGroup);
        IsoTypeWriter.m3302c(byteBuffer, (double) this.volume);
        IsoTypeWriter.m3299b(byteBuffer, 0);
        this.matrix.m7714b(byteBuffer);
        IsoTypeWriter.m3294a(byteBuffer, this.width);
        IsoTypeWriter.m3294a(byteBuffer, this.height);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrackHeaderBox[");
        stringBuilder.append("creationTime=");
        stringBuilder.append(getCreationTime());
        stringBuilder.append(";");
        stringBuilder.append("modificationTime=");
        stringBuilder.append(getModificationTime());
        stringBuilder.append(";");
        stringBuilder.append("trackId=");
        stringBuilder.append(getTrackId());
        stringBuilder.append(";");
        stringBuilder.append("duration=");
        stringBuilder.append(getDuration());
        stringBuilder.append(";");
        stringBuilder.append("layer=");
        stringBuilder.append(getLayer());
        stringBuilder.append(";");
        stringBuilder.append("alternateGroup=");
        stringBuilder.append(getAlternateGroup());
        stringBuilder.append(";");
        stringBuilder.append("volume=");
        stringBuilder.append(getVolume());
        stringBuilder.append(";");
        stringBuilder.append("matrix=");
        stringBuilder.append(this.matrix);
        stringBuilder.append(";");
        stringBuilder.append("width=");
        stringBuilder.append(getWidth());
        stringBuilder.append(";");
        stringBuilder.append("height=");
        stringBuilder.append(getHeight());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void setCreationTime(Date date) {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.creationTime = date;
        if (DateHelper.m7706a(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setModificationTime(Date date) {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.modificationTime = date;
        if (DateHelper.m7706a(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setTrackId(long j) {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.trackId = j;
    }

    public void setDuration(long j) {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.duration = j;
        if (j >= 4294967296L) {
            setFlags(1);
        }
    }

    public void setLayer(int i) {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.layer = i;
    }

    public void setAlternateGroup(int i) {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.alternateGroup = i;
    }

    public void setVolume(float f) {
        JoinPoint a = Factory.a(ajc$tjp_18, this, this, Conversions.a(f));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.volume = f;
    }

    public void setMatrix(Matrix matrix) {
        JoinPoint a = Factory.a(ajc$tjp_19, this, this, matrix);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.matrix = matrix;
    }

    public void setWidth(double d) {
        JoinPoint a = Factory.a(ajc$tjp_20, this, this, Conversions.a(d));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.width = d;
    }

    public void setHeight(double d) {
        JoinPoint a = Factory.a(ajc$tjp_21, this, this, Conversions.a(d));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.height = d;
    }

    public boolean isEnabled() {
        JoinPoint a = Factory.a(ajc$tjp_22, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 1) > 0;
    }

    public boolean isInMovie() {
        JoinPoint a = Factory.a(ajc$tjp_23, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 2) > 0;
    }

    public boolean isInPreview() {
        JoinPoint a = Factory.a(ajc$tjp_24, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 4) > 0;
    }

    public boolean isInPoster() {
        JoinPoint a = Factory.a(ajc$tjp_25, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (getFlags() & 8) > 0;
    }

    public void setEnabled(boolean z) {
        JoinPoint a = Factory.a(ajc$tjp_26, this, this, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (z) {
            setFlags(getFlags() | 1);
        } else {
            setFlags(getFlags() & -2);
        }
    }

    public void setInMovie(boolean z) {
        JoinPoint a = Factory.a(ajc$tjp_27, this, this, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (z) {
            setFlags(getFlags() | 2);
        } else {
            setFlags(getFlags() & -3);
        }
    }

    public void setInPreview(boolean z) {
        JoinPoint a = Factory.a(ajc$tjp_28, this, this, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (z) {
            setFlags(getFlags() | 4);
        } else {
            setFlags(getFlags() & -5);
        }
    }

    public void setInPoster(boolean z) {
        JoinPoint a = Factory.a(ajc$tjp_29, this, this, Conversions.a(z));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (z) {
            setFlags(getFlags() | 8);
        } else {
            setFlags(getFlags() & -9);
        }
    }
}
