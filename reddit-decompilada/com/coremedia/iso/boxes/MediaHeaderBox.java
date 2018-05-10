package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.DateHelper;
import com.googlecode.mp4parser.util.Logger;
import com.instabug.library.model.State;
import java.nio.ByteBuffer;
import java.util.Date;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class MediaHeaderBox extends AbstractFullBox {
    private static Logger LOG = Logger.m7708a(MediaHeaderBox.class);
    public static final String TYPE = "mdhd";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_10 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private static final StaticPart ajc$tjp_6 = null;
    private static final StaticPart ajc$tjp_7 = null;
    private static final StaticPart ajc$tjp_8 = null;
    private static final StaticPart ajc$tjp_9 = null;
    private Date creationTime = new Date();
    private long duration;
    private String language = "eng";
    private Date modificationTime = new Date();
    private long timescale;

    private static void ajc$preClinit() {
        Factory factory = new Factory("MediaHeaderBox.java", MediaHeaderBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 48);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.util.Date"), 52);
        ajc$tjp_10 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 125);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 56);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "getDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "long"), 60);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "getLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "", "", "", "java.lang.String"), 64);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setCreationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "creationTime", "", "void"), 81);
        ajc$tjp_6 = factory.a("method-execution", factory.a("1", "setModificationTime", "com.coremedia.iso.boxes.MediaHeaderBox", "java.util.Date", "modificationTime", "", "void"), 85);
        ajc$tjp_7 = factory.a("method-execution", factory.a("1", "setTimescale", "com.coremedia.iso.boxes.MediaHeaderBox", "long", "timescale", "", "void"), 89);
        ajc$tjp_8 = factory.a("method-execution", factory.a("1", "setDuration", "com.coremedia.iso.boxes.MediaHeaderBox", "long", State.KEY_DURATION, "", "void"), 93);
        ajc$tjp_9 = factory.a("method-execution", factory.a("1", "setLanguage", "com.coremedia.iso.boxes.MediaHeaderBox", "java.lang.String", "language", "", "void"), 97);
    }

    static {
        ajc$preClinit();
    }

    public MediaHeaderBox() {
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

    public String getLanguage() {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.language;
    }

    protected long getContentSize() {
        return ((getVersion() == 1 ? 32 : 20) + 2) + 2;
    }

    public void setCreationTime(Date date) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.creationTime = date;
    }

    public void setModificationTime(Date date) {
        JoinPoint a = Factory.a(ajc$tjp_6, this, this, date);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.modificationTime = date;
    }

    public void setTimescale(long j) {
        JoinPoint a = Factory.a(ajc$tjp_7, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.timescale = j;
    }

    public void setDuration(long j) {
        JoinPoint a = Factory.a(ajc$tjp_8, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.duration = j;
    }

    public void setLanguage(String str) {
        JoinPoint a = Factory.a(ajc$tjp_9, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.language = str;
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
            this.duration = IsoTypeReader.m3280a(byteBuffer);
        }
        if (this.duration < -1) {
            LOG.mo2532b("mdhd duration is not in expected range");
        }
        this.language = IsoTypeReader.m3290j(byteBuffer);
        IsoTypeReader.m3283c(byteBuffer);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_10, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaHeaderBox[");
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
        stringBuilder.append("language=");
        stringBuilder.append(getLanguage());
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
        IsoTypeWriter.m3297a(byteBuffer, this.language);
        IsoTypeWriter.m3299b(byteBuffer, 0);
    }
}
