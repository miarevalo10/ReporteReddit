package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TrackFragmentBaseMediaDecodeTimeBox extends AbstractFullBox {
    public static final String TYPE = "tfdt";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private long baseMediaDecodeTime;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TrackFragmentBaseMediaDecodeTimeBox.java", TrackFragmentBaseMediaDecodeTimeBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "long"), 65);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setBaseMediaDecodeTime", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "long", "baseMediaDecodeTime", "", "void"), 69);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.fragment.TrackFragmentBaseMediaDecodeTimeBox", "", "", "", "java.lang.String"), 74);
    }

    public TrackFragmentBaseMediaDecodeTimeBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) (getVersion() == 0 ? 8 : 12);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.m3296a(byteBuffer, this.baseMediaDecodeTime);
        } else {
            IsoTypeWriter.m3300b(byteBuffer, this.baseMediaDecodeTime);
        }
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.baseMediaDecodeTime = IsoTypeReader.m3286f(byteBuffer);
        } else {
            this.baseMediaDecodeTime = IsoTypeReader.m3280a(byteBuffer);
        }
    }

    public long getBaseMediaDecodeTime() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.baseMediaDecodeTime;
    }

    public void setBaseMediaDecodeTime(long j) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.baseMediaDecodeTime = j;
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("TrackFragmentBaseMediaDecodeTimeBox{baseMediaDecodeTime=");
        stringBuilder.append(this.baseMediaDecodeTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
