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

public class MovieHeaderBox extends AbstractFullBox {
    private static Logger LOG = Logger.m7708a(MovieHeaderBox.class);
    public static final String TYPE = "mvhd";
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
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    private Date creationTime;
    private int currentTime;
    private long duration;
    private Matrix matrix = Matrix.f9068j;
    private Date modificationTime;
    private long nextTrackId;
    private int posterTime;
    private int previewDuration;
    private int previewTime;
    private double rate = 1.0d;
    private int selectionDuration;
    private int selectionTime;
    private long timescale;
    private float volume = 1.0f;

    private static void ajc$preClinit() {
        Factory factory = new Factory("MovieHeaderBox.java", MovieHeaderBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 66);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.util.Date"), 70);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "setModificationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "modificationTime", "", "void"), JpegConst.RST4);
        ajc$tjp_11 = factory.a("method-execution", factory.a("1", "setTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "timescale", "", "void"), 220);
        ajc$tjp_12 = factory.a("method-execution", factory.a("1", "setDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "long", State.KEY_DURATION, "", "void"), JpegConst.APP0);
        ajc$tjp_13 = factory.a("method-execution", factory.a("1", "setRate", "com.coremedia.iso.boxes.MovieHeaderBox", "double", "rate", "", "void"), JpegConst.APP7);
        ajc$tjp_14 = factory.a("method-execution", factory.a("1", "setVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "float", "volume", "", "void"), JpegConst.APPB);
        ajc$tjp_15 = factory.a("method-execution", factory.a("1", "setMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "com.googlecode.mp4parser.util.Matrix", "matrix", "", "void"), JpegConst.APPF);
        ajc$tjp_16 = factory.a("method-execution", factory.a("1", "setNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "long", "nextTrackId", "", "void"), 243);
        ajc$tjp_17 = factory.a("method-execution", factory.a("1", "getPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 247);
        ajc$tjp_18 = factory.a("method-execution", factory.a("1", "setPreviewTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewTime", "", "void"), 251);
        ajc$tjp_19 = factory.a("method-execution", factory.a("1", "getPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 255);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getTimescale", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 74);
        ajc$tjp_20 = factory.a("method-execution", factory.a("1", "setPreviewDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "previewDuration", "", "void"), 259);
        ajc$tjp_21 = factory.a("method-execution", factory.a("1", "getPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 263);
        ajc$tjp_22 = factory.a("method-execution", factory.a("1", "setPosterTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "posterTime", "", "void"), 267);
        ajc$tjp_23 = factory.a("method-execution", factory.a("1", "getSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 271);
        ajc$tjp_24 = factory.a("method-execution", factory.a("1", "setSelectionTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionTime", "", "void"), 275);
        ajc$tjp_25 = factory.a("method-execution", factory.a("1", "getSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 279);
        ajc$tjp_26 = factory.a("method-execution", factory.a("1", "setSelectionDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "selectionDuration", "", "void"), 283);
        ajc$tjp_27 = factory.a("method-execution", factory.a("1", "getCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "int"), 287);
        ajc$tjp_28 = factory.a("method-execution", factory.a("1", "setCurrentTime", "com.coremedia.iso.boxes.MovieHeaderBox", "int", "currentTime", "", "void"), 291);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getDuration", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 78);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getRate", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "double"), 82);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "getVolume", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "float"), 86);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "getMatrix", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "com.googlecode.mp4parser.util.Matrix"), 90);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "getNextTrackId", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "long"), 94);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.MovieHeaderBox", "", "", "", "java.lang.String"), 148);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setCreationTime", "com.coremedia.iso.boxes.MovieHeaderBox", "java.util.Date", "creationTime", "", "void"), 204);
    }

    static {
        ajc$preClinit();
    }

    public MovieHeaderBox() {
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

    public long getTimescale() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.timescale;
    }

    public long getDuration() {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.duration;
    }

    public double getRate() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.rate;
    }

    public float getVolume() {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.volume;
    }

    public Matrix getMatrix() {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.matrix;
    }

    public long getNextTrackId() {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.nextTrackId;
    }

    protected long getContentSize() {
        return (getVersion() == 1 ? 32 : 20) + 80;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.creationTime = DateHelper.m7707a(IsoTypeReader.m3286f(byteBuffer));
            this.modificationTime = DateHelper.m7707a(IsoTypeReader.m3286f(byteBuffer));
            this.timescale = IsoTypeReader.m3280a(byteBuffer);
            this.duration = byteBuffer.getLong();
        } else {
            this.creationTime = DateHelper.m7707a(IsoTypeReader.m3280a(byteBuffer));
            this.modificationTime = DateHelper.m7707a(IsoTypeReader.m3280a(byteBuffer));
            this.timescale = IsoTypeReader.m3280a(byteBuffer);
            this.duration = (long) byteBuffer.getInt();
        }
        if (this.duration < -1) {
            LOG.mo2532b("mvhd duration is not in expected range");
        }
        this.rate = IsoTypeReader.m3287g(byteBuffer);
        this.volume = IsoTypeReader.m3289i(byteBuffer);
        IsoTypeReader.m3283c(byteBuffer);
        IsoTypeReader.m3280a(byteBuffer);
        IsoTypeReader.m3280a(byteBuffer);
        this.matrix = Matrix.m7713a(byteBuffer);
        this.previewTime = byteBuffer.getInt();
        this.previewDuration = byteBuffer.getInt();
        this.posterTime = byteBuffer.getInt();
        this.selectionTime = byteBuffer.getInt();
        this.selectionDuration = byteBuffer.getInt();
        this.currentTime = byteBuffer.getInt();
        this.nextTrackId = IsoTypeReader.m3280a(byteBuffer);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MovieHeaderBox[");
        stringBuilder.append("creationTime=");
        stringBuilder.append(getCreationTime());
        stringBuilder.append(";");
        stringBuilder.append("modificationTime=");
        stringBuilder.append(getModificationTime());
        stringBuilder.append(";");
        stringBuilder.append("timescale=");
        stringBuilder.append(getTimescale());
        stringBuilder.append(";");
        stringBuilder.append("duration=");
        stringBuilder.append(getDuration());
        stringBuilder.append(";");
        stringBuilder.append("rate=");
        stringBuilder.append(getRate());
        stringBuilder.append(";");
        stringBuilder.append("volume=");
        stringBuilder.append(getVolume());
        stringBuilder.append(";");
        stringBuilder.append("matrix=");
        stringBuilder.append(this.matrix);
        stringBuilder.append(";");
        stringBuilder.append("nextTrackId=");
        stringBuilder.append(getNextTrackId());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.m3296a(byteBuffer, DateHelper.m7706a(this.creationTime));
            IsoTypeWriter.m3296a(byteBuffer, DateHelper.m7706a(this.modificationTime));
            IsoTypeWriter.m3300b(byteBuffer, this.timescale);
            byteBuffer.putLong(this.duration);
        } else {
            IsoTypeWriter.m3300b(byteBuffer, DateHelper.m7706a(this.creationTime));
            IsoTypeWriter.m3300b(byteBuffer, DateHelper.m7706a(this.modificationTime));
            IsoTypeWriter.m3300b(byteBuffer, this.timescale);
            byteBuffer.putInt((int) this.duration);
        }
        IsoTypeWriter.m3294a(byteBuffer, this.rate);
        IsoTypeWriter.m3302c(byteBuffer, (double) this.volume);
        IsoTypeWriter.m3299b(byteBuffer, 0);
        IsoTypeWriter.m3300b(byteBuffer, 0);
        IsoTypeWriter.m3300b(byteBuffer, 0);
        this.matrix.m7714b(byteBuffer);
        byteBuffer.putInt(this.previewTime);
        byteBuffer.putInt(this.previewDuration);
        byteBuffer.putInt(this.posterTime);
        byteBuffer.putInt(this.selectionTime);
        byteBuffer.putInt(this.selectionDuration);
        byteBuffer.putInt(this.currentTime);
        IsoTypeWriter.m3300b(byteBuffer, this.nextTrackId);
    }

    public void setCreationTime(Date date) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.creationTime = date;
        if (DateHelper.m7706a(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setModificationTime(Date date) {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.modificationTime = date;
        if (DateHelper.m7706a(date) >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setTimescale(long j) {
        JoinPoint a = Factory.a(ajc$tjp_11, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.timescale = j;
    }

    public void setDuration(long j) {
        JoinPoint a = Factory.a(ajc$tjp_12, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.duration = j;
        if (j >= 4294967296L) {
            setVersion(1);
        }
    }

    public void setRate(double d) {
        JoinPoint a = Factory.a(ajc$tjp_13, this, this, Conversions.a(d));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.rate = d;
    }

    public void setVolume(float f) {
        JoinPoint a = Factory.a(ajc$tjp_14, this, this, Conversions.a(f));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.volume = f;
    }

    public void setMatrix(Matrix matrix) {
        JoinPoint a = Factory.a(ajc$tjp_15, this, this, matrix);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.matrix = matrix;
    }

    public void setNextTrackId(long j) {
        JoinPoint a = Factory.a(ajc$tjp_16, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.nextTrackId = j;
    }

    public int getPreviewTime() {
        JoinPoint a = Factory.a(ajc$tjp_17, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.previewTime;
    }

    public void setPreviewTime(int i) {
        JoinPoint a = Factory.a(ajc$tjp_18, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.previewTime = i;
    }

    public int getPreviewDuration() {
        JoinPoint a = Factory.a(ajc$tjp_19, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.previewDuration;
    }

    public void setPreviewDuration(int i) {
        JoinPoint a = Factory.a(ajc$tjp_20, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.previewDuration = i;
    }

    public int getPosterTime() {
        JoinPoint a = Factory.a(ajc$tjp_21, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.posterTime;
    }

    public void setPosterTime(int i) {
        JoinPoint a = Factory.a(ajc$tjp_22, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.posterTime = i;
    }

    public int getSelectionTime() {
        JoinPoint a = Factory.a(ajc$tjp_23, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.selectionTime;
    }

    public void setSelectionTime(int i) {
        JoinPoint a = Factory.a(ajc$tjp_24, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.selectionTime = i;
    }

    public int getSelectionDuration() {
        JoinPoint a = Factory.a(ajc$tjp_25, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.selectionDuration;
    }

    public void setSelectionDuration(int i) {
        JoinPoint a = Factory.a(ajc$tjp_26, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.selectionDuration = i;
    }

    public int getCurrentTime() {
        JoinPoint a = Factory.a(ajc$tjp_27, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.currentTime;
    }

    public void setCurrentTime(int i) {
        JoinPoint a = Factory.a(ajc$tjp_28, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.currentTime = i;
    }
}
