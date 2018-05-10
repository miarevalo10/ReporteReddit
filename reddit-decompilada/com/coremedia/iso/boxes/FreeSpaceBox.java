package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class FreeSpaceBox extends AbstractBox {
    public static final String TYPE = "skip";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    byte[] data;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("FreeSpaceBox.java", FreeSpaceBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "setData", "com.coremedia.iso.boxes.FreeSpaceBox", "[B", "data", "", "void"), 42);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "getData", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", "[B"), 46);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "toString", "com.coremedia.iso.boxes.FreeSpaceBox", "", "", "", "java.lang.String"), 61);
    }

    protected long getContentSize() {
        return (long) this.data.length;
    }

    public FreeSpaceBox() {
        super(TYPE);
    }

    public void setData(byte[] bArr) {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this, bArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.data = bArr;
    }

    public byte[] getData() {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.data;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        this.data = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.data);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        byteBuffer.put(this.data);
    }

    public String toString() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        StringBuilder stringBuilder = new StringBuilder("FreeSpaceBox[size=");
        stringBuilder.append(this.data.length);
        stringBuilder.append(";type=");
        stringBuilder.append(getType());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}