package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.internal.Conversions;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public abstract class AppleVariableSignedIntegerBox extends AppleDataBox {
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private static final StaticPart ajc$tjp_2 = null;
    private static final StaticPart ajc$tjp_3 = null;
    int intLength = 1;
    long value;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("AppleVariableSignedIntegerBox.java", AppleVariableSignedIntegerBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "int"), 19);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setIntLength", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "int", "intLength", "", "void"), 23);
        ajc$tjp_2 = factory.a("method-execution", factory.a("1", "getValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "", "", "", "long"), 27);
        ajc$tjp_3 = factory.a("method-execution", factory.a("1", "setValue", "com.googlecode.mp4parser.boxes.apple.AppleVariableSignedIntegerBox", "long", "value", "", "void"), 36);
    }

    protected AppleVariableSignedIntegerBox(String str) {
        super(str, 15);
    }

    public int getIntLength() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.intLength;
    }

    public void setIntLength(int i) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, Conversions.a(i));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.intLength = i;
    }

    public long getValue() {
        JoinPoint a = Factory.a(ajc$tjp_2, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (!isParsed()) {
            parseDetails();
        }
        return this.value;
    }

    public void setValue(long j) {
        JoinPoint a = Factory.a(ajc$tjp_3, this, this, Conversions.a(j));
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        if (j <= 127 && j > -128) {
            this.intLength = 1;
        } else if (j <= 32767 && j > -32768 && this.intLength < 2) {
            this.intLength = 2;
        } else if (j > 8388607 || j <= -8388608 || this.intLength >= 3) {
            this.intLength = 4;
        } else {
            this.intLength = 3;
        }
        this.value = j;
    }

    protected byte[] writeData() {
        int dataLength = getDataLength();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[dataLength]);
        IsoTypeWriterVariable.m3306a(this.value, wrap, dataLength);
        return wrap.array();
    }

    protected void parseData(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        this.value = IsoTypeReaderVariable.m3293a(byteBuffer, remaining);
        this.intLength = remaining;
    }

    protected int getDataLength() {
        return this.intLength;
    }
}
