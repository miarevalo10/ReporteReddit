package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public abstract class Utf8AppleDataBox extends AppleDataBox {
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    String value;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("Utf8AppleDataBox.java", Utf8AppleDataBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "", "", "", "java.lang.String"), 21);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "java.lang.String", "value", "", "void"), 30);
    }

    protected Utf8AppleDataBox(String str) {
        super(str, 1);
    }

    public String getValue() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (!isParsed()) {
            parseDetails();
        }
        return this.value;
    }

    public void setValue(String str) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, str);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.value = str;
    }

    public byte[] writeData() {
        return Utf8.m3308a(this.value);
    }

    protected int getDataLength() {
        return this.value.getBytes(Charset.forName("UTF-8")).length;
    }

    protected void parseData(ByteBuffer byteBuffer) {
        this.value = IsoTypeReader.m3281a(byteBuffer, byteBuffer.remaining());
    }
}
