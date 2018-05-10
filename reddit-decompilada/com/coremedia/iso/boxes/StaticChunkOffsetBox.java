package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import org.mp4parser.aspectj.lang.JoinPoint;
import org.mp4parser.aspectj.lang.JoinPoint.StaticPart;
import org.mp4parser.aspectj.runtime.reflect.Factory;

public class StaticChunkOffsetBox extends ChunkOffsetBox {
    public static final String TYPE = "stco";
    private static final StaticPart ajc$tjp_0 = null;
    private static final StaticPart ajc$tjp_1 = null;
    private long[] chunkOffsets = new long[0];

    static {
        ajc$preClinit();
    }

    private static void ajc$preClinit() {
        Factory factory = new Factory("StaticChunkOffsetBox.java", StaticChunkOffsetBox.class);
        ajc$tjp_0 = factory.a("method-execution", factory.a("1", "getChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "", "", "", "[J"), 39);
        ajc$tjp_1 = factory.a("method-execution", factory.a("1", "setChunkOffsets", "com.coremedia.iso.boxes.StaticChunkOffsetBox", "[J", "chunkOffsets", "", "void"), 48);
    }

    public StaticChunkOffsetBox() {
        super(TYPE);
    }

    public long[] getChunkOffsets() {
        JoinPoint a = Factory.a(ajc$tjp_0, this, this);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        return this.chunkOffsets;
    }

    protected long getContentSize() {
        return (long) (8 + (this.chunkOffsets.length * 4));
    }

    public void setChunkOffsets(long[] jArr) {
        JoinPoint a = Factory.a(ajc$tjp_1, this, this, jArr);
        RequiresParseDetailAspect.m7623a();
        RequiresParseDetailAspect.m7624a(a);
        this.chunkOffsets = jArr;
    }

    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        int a = CastUtils.m7705a(IsoTypeReader.m3280a(byteBuffer));
        this.chunkOffsets = new long[a];
        for (int i = 0; i < a; i++) {
            this.chunkOffsets[i] = IsoTypeReader.m3280a(byteBuffer);
        }
    }

    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        IsoTypeWriter.m3300b(byteBuffer, (long) this.chunkOffsets.length);
        for (long b : this.chunkOffsets) {
            IsoTypeWriter.m3300b(byteBuffer, b);
        }
    }
}
