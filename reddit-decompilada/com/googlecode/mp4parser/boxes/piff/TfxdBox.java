package com.googlecode.mp4parser.boxes.piff;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.jcodec.containers.mxf.model.BER;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TfxdBox extends AbstractFullBox {
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    public long fragmentAbsoluteDuration;
    public long fragmentAbsoluteTime;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TfxdBox.java", TfxdBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getFragmentAbsoluteTime", "com.googlecode.mp4parser.boxes.piff.TfxdBox", "", "", "", "long"), 79);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getFragmentAbsoluteDuration", "com.googlecode.mp4parser.boxes.piff.TfxdBox", "", "", "", "long"), 83);
    }

    public TfxdBox() {
        super("uuid");
    }

    public byte[] getUserType() {
        return new byte[]{(byte) 109, (byte) 29, (byte) -101, (byte) 5, (byte) 66, (byte) -43, (byte) 68, (byte) -26, BER.ASN_LONG_LEN, (byte) -30, (byte) 20, (byte) 29, (byte) -81, (byte) -9, (byte) 87, (byte) -78};
    }

    protected long getContentSize() {
        return (long) (getVersion() == 1 ? 20 : 12);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            this.fragmentAbsoluteTime = IsoTypeReader.m3286f(byteBuffer);
            this.fragmentAbsoluteDuration = IsoTypeReader.m3286f(byteBuffer);
            return;
        }
        this.fragmentAbsoluteTime = IsoTypeReader.m3280a(byteBuffer);
        this.fragmentAbsoluteDuration = IsoTypeReader.m3280a(byteBuffer);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        if (getVersion() == 1) {
            IsoTypeWriter.m3296a(byteBuffer, this.fragmentAbsoluteTime);
            IsoTypeWriter.m3296a(byteBuffer, this.fragmentAbsoluteDuration);
            return;
        }
        IsoTypeWriter.m3300b(byteBuffer, this.fragmentAbsoluteTime);
        IsoTypeWriter.m3300b(byteBuffer, this.fragmentAbsoluteDuration);
    }

    public long getFragmentAbsoluteTime() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.fragmentAbsoluteTime;
    }

    public long getFragmentAbsoluteDuration() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.fragmentAbsoluteDuration;
    }
}
