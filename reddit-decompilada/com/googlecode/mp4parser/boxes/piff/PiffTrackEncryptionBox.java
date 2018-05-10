package com.googlecode.mp4parser.boxes.piff;

import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.boxes.AbstractTrackEncryptionBox;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class PiffTrackEncryptionBox extends AbstractTrackEncryptionBox {
    private static final StaticPart ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("PiffTrackEncryptionBox.java", PiffTrackEncryptionBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getFlags", "com.googlecode.mp4parser.boxes.piff.PiffTrackEncryptionBox", "", "", "", "int"), 29);
    }

    public PiffTrackEncryptionBox() {
        super("uuid");
    }

    public byte[] getUserType() {
        return new byte[]{(byte) -119, (byte) 116, (byte) -37, (byte) -50, (byte) 123, (byte) -25, (byte) 76, (byte) 81, (byte) -124, (byte) -7, (byte) 113, (byte) 72, (byte) -7, (byte) -120, (byte) 37, (byte) 84};
    }

    public int getFlags() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return 0;
    }
}
