package com.coremedia.iso.boxes.apple;

import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class AppleDataReferenceBox extends AbstractFullBox {
    public static final String TYPE = "rdrf";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private String dataReference;
    private int dataReferenceSize;
    private String dataReferenceType;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AppleDataReferenceBox.java", AppleDataReferenceBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getDataReferenceSize", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "long"), 63);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getDataReferenceType", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 67);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getDataReference", "com.coremedia.iso.boxes.apple.AppleDataReferenceBox", "", "", "", "java.lang.String"), 71);
    }

    public AppleDataReferenceBox() {
        super(TYPE);
    }

    protected long getContentSize() {
        return (long) (12 + this.dataReferenceSize);
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.dataReferenceType = IsoTypeReader.m3291k(byteBuffer);
        this.dataReferenceSize = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.dataReference = IsoTypeReader.m3281a(byteBuffer, this.dataReferenceSize);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(IsoFile.m17057a(this.dataReferenceType));
        IsoTypeWriter.m3300b(byteBuffer, (long) this.dataReferenceSize);
        byteBuffer.put(Utf8.m3308a(this.dataReference));
    }

    public long getDataReferenceSize() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return (long) this.dataReferenceSize;
    }

    public String getDataReferenceType() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.dataReferenceType;
    }

    public String getDataReference() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.dataReference;
    }
}
