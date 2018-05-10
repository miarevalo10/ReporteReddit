package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;

public class VideoSampleEntry extends SampleEntry {
    private static final MyFactory FACTORY = new MyFactory();
    private short clrTbl;
    private String compressorName;
    private short depth;
    private short frameCount;
    private float hRes;
    private short height;
    private short revision;
    private int spacialQual;
    private int temporalQual;
    private float vRes;
    private String vendor;
    private short version;
    private short width;

    public static class MyFactory extends BoxFactory {
        private Map<String, Class<? extends Box>> mappings = new HashMap();

        public MyFactory() {
            this.mappings.put(PixelAspectExt.fourcc(), PixelAspectExt.class);
            this.mappings.put(ColorExtension.fourcc(), ColorExtension.class);
            this.mappings.put(GamaExtension.fourcc(), GamaExtension.class);
            this.mappings.put(CleanApertureExtension.fourcc(), CleanApertureExtension.class);
            this.mappings.put(FielExtension.fourcc(), FielExtension.class);
        }

        public Class<? extends Box> toClass(String str) {
            return (Class) this.mappings.get(str);
        }
    }

    public VideoSampleEntry(Header header, short s, short s2, String str, int i, int i2, short s3, short s4, long j, long j2, short s5, String str2, short s6, short s7, short s8) {
        super(header, s7);
        this.factory = FACTORY;
        this.version = s;
        this.revision = s2;
        this.vendor = str;
        this.temporalQual = i;
        this.spacialQual = i2;
        this.width = s3;
        this.height = s4;
        this.hRes = (float) j;
        this.vRes = (float) j2;
        this.frameCount = s5;
        this.compressorName = str2;
        this.depth = s6;
        this.clrTbl = s8;
    }

    public VideoSampleEntry(Header header) {
        super(header);
        this.factory = FACTORY;
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        this.version = byteBuffer.getShort();
        this.revision = byteBuffer.getShort();
        this.vendor = NIOUtils.readString(byteBuffer, 4);
        this.temporalQual = byteBuffer.getInt();
        this.spacialQual = byteBuffer.getInt();
        this.width = byteBuffer.getShort();
        this.height = byteBuffer.getShort();
        this.hRes = ((float) byteBuffer.getInt()) / 65536.0f;
        this.vRes = ((float) byteBuffer.getInt()) / 65536.0f;
        byteBuffer.getInt();
        this.frameCount = byteBuffer.getShort();
        this.compressorName = NIOUtils.readPascalString(byteBuffer, 31);
        this.depth = byteBuffer.getShort();
        this.clrTbl = byteBuffer.getShort();
        parseExtensions(byteBuffer);
    }

    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putShort(this.version);
        byteBuffer.putShort(this.revision);
        byteBuffer.put(JCodecUtil.asciiString(this.vendor), 0, 4);
        byteBuffer.putInt(this.temporalQual);
        byteBuffer.putInt(this.spacialQual);
        byteBuffer.putShort(this.width);
        byteBuffer.putShort(this.height);
        byteBuffer.putInt((int) (this.hRes * 65536.0f));
        byteBuffer.putInt((int) (this.vRes * 65536.0f));
        byteBuffer.putInt(0);
        byteBuffer.putShort(this.frameCount);
        NIOUtils.writePascalString(byteBuffer, this.compressorName, 31);
        byteBuffer.putShort(this.depth);
        byteBuffer.putShort(this.clrTbl);
        writeExtensions(byteBuffer);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public float gethRes() {
        return this.hRes;
    }

    public float getvRes() {
        return this.vRes;
    }

    public long getFrameCount() {
        return (long) this.frameCount;
    }

    public String getCompressorName() {
        return this.compressorName;
    }

    public long getDepth() {
        return (long) this.depth;
    }

    public String getVendor() {
        return this.vendor;
    }

    public short getVersion() {
        return this.version;
    }

    public short getRevision() {
        return this.revision;
    }

    public int getTemporalQual() {
        return this.temporalQual;
    }

    public int getSpacialQual() {
        return this.spacialQual;
    }

    public short getClrTbl() {
        return this.clrTbl;
    }
}
