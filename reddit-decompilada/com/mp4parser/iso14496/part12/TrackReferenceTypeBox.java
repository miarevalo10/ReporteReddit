package com.mp4parser.iso14496.part12;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.Mp4Arrays;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class TrackReferenceTypeBox extends AbstractBox {
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    long[] trackIds = new long[null];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("TrackReferenceTypeBox.java", TrackReferenceTypeBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "", "", "", "[J"), 58);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setTrackIds", "com.mp4parser.iso14496.part12.TrackReferenceTypeBox", "[J", "trackIds", "", "void"), 62);
    }

    public TrackReferenceTypeBox(String str) {
        super(str);
    }

    protected long getContentSize() {
        return (long) (this.trackIds.length * 4);
    }

    protected void getContent(ByteBuffer byteBuffer) {
        for (long b : this.trackIds) {
            IsoTypeWriter.m3300b(byteBuffer, b);
        }
    }

    protected void _parseDetails(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() >= 4) {
            this.trackIds = Mp4Arrays.m7715a(this.trackIds, IsoTypeReader.m3280a(byteBuffer));
        }
    }

    public long[] getTrackIds() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.trackIds;
    }

    public void setTrackIds(long[] jArr) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, jArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.trackIds = jArr;
    }
}
