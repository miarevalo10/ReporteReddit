package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.jcodec.containers.mxf.model.BER;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public final class OmaDrmAccessUnitFormatBox extends AbstractFullBox {
    public static final String TYPE = "odaf";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    private static final StaticPart ajc$tjp_4 = null;
    private static final StaticPart ajc$tjp_5 = null;
    private byte allBits;
    private int initVectorLength;
    private int keyIndicatorLength;
    private boolean selectiveEncryption;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("OmaDrmAccessUnitFormatBox.java", OmaDrmAccessUnitFormatBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "isSelectiveEncryption", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "boolean"), 46);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 50);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "", "", "", "int"), 54);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setInitVectorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "initVectorLength", "", "void"), 58);
        ajc$tjp_4 = factory.a("method-execution", factory.a("1", "setKeyIndicatorLength", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "int", "keyIndicatorLength", "", "void"), 62);
        ajc$tjp_5 = factory.a("method-execution", factory.a("1", "setAllBits", "com.coremedia.iso.boxes.OmaDrmAccessUnitFormatBox", "byte", "allBits", "", "void"), 66);
    }

    protected final long getContentSize() {
        return 7;
    }

    public OmaDrmAccessUnitFormatBox() {
        super(TYPE);
    }

    public final boolean isSelectiveEncryption() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.selectiveEncryption;
    }

    public final int getKeyIndicatorLength() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.keyIndicatorLength;
    }

    public final int getInitVectorLength() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.initVectorLength;
    }

    public final void setInitVectorLength(int i) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.initVectorLength = i;
    }

    public final void setKeyIndicatorLength(int i) {
        JoinPoint a = Factory.a(ajc$tjp_4, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.keyIndicatorLength = i;
    }

    public final void setAllBits(byte b) {
        JoinPoint a = Factory.a(ajc$tjp_5, this, this, Conversions.a(b));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.allBits = b;
        this.selectiveEncryption = (b & BER.ASN_LONG_LEN) == BER.ASN_LONG_LEN ? (byte) 1 : (byte) 0;
    }

    public final void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.allBits = (byte) IsoTypeReader.m3284d(byteBuffer);
        this.selectiveEncryption = (this.allBits & 128) == 128;
        this.keyIndicatorLength = IsoTypeReader.m3284d(byteBuffer);
        this.initVectorLength = IsoTypeReader.m3284d(byteBuffer);
    }

    protected final void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3303c(byteBuffer, this.allBits);
        IsoTypeWriter.m3303c(byteBuffer, this.keyIndicatorLength);
        IsoTypeWriter.m3303c(byteBuffer, this.initVectorLength);
    }
}
