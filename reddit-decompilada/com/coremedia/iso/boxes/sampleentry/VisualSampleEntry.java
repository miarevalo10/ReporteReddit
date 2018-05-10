package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class VisualSampleEntry extends AbstractSampleEntry implements Container {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE1 = "mp4v";
    public static final String TYPE2 = "s263";
    public static final String TYPE3 = "avc1";
    public static final String TYPE4 = "avc3";
    public static final String TYPE5 = "drmi";
    public static final String TYPE6 = "hvc1";
    public static final String TYPE7 = "hev1";
    public static final String TYPE_ENCRYPTED = "encv";
    private String compressorname;
    private int depth;
    private int frameCount;
    private int height;
    private double horizresolution;
    private long[] predefined;
    private double vertresolution;
    private int width;

    public VisualSampleEntry() {
        super(TYPE3);
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }

    public VisualSampleEntry(String str) {
        super(str);
        this.horizresolution = 72.0d;
        this.vertresolution = 72.0d;
        this.frameCount = 1;
        this.compressorname = "";
        this.depth = 24;
        this.predefined = new long[3];
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final double getHorizresolution() {
        return this.horizresolution;
    }

    public final void setHorizresolution(double d) {
        this.horizresolution = d;
    }

    public final double getVertresolution() {
        return this.vertresolution;
    }

    public final void setVertresolution(double d) {
        this.vertresolution = d;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final void setFrameCount(int i) {
        this.frameCount = i;
    }

    public final String getCompressorname() {
        return this.compressorname;
    }

    public final void setCompressorname(String str) {
        this.compressorname = str;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final void setDepth(int i) {
        this.depth = i;
    }

    public final void parse(final DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        final long position = dataSource.position() + j;
        byteBuffer = ByteBuffer.allocate(78);
        dataSource.read(byteBuffer);
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.m3283c(byteBuffer);
        IsoTypeReader.m3283c(byteBuffer);
        IsoTypeReader.m3283c(byteBuffer);
        this.predefined[0] = IsoTypeReader.m3280a(byteBuffer);
        this.predefined[1] = IsoTypeReader.m3280a(byteBuffer);
        this.predefined[2] = IsoTypeReader.m3280a(byteBuffer);
        this.width = IsoTypeReader.m3283c(byteBuffer);
        this.height = IsoTypeReader.m3283c(byteBuffer);
        this.horizresolution = IsoTypeReader.m3287g(byteBuffer);
        this.vertresolution = IsoTypeReader.m3287g(byteBuffer);
        IsoTypeReader.m3280a(byteBuffer);
        this.frameCount = IsoTypeReader.m3283c(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        if (d > 31) {
            d = 31;
        }
        byte[] bArr = new byte[d];
        byteBuffer.get(bArr);
        this.compressorname = Utf8.m3307a(bArr);
        if (d < 31) {
            byteBuffer.get(new byte[(31 - d)]);
        }
        this.depth = IsoTypeReader.m3283c(byteBuffer);
        IsoTypeReader.m3283c(byteBuffer);
        initContainer(new DataSource() {
            public int read(ByteBuffer byteBuffer) throws IOException {
                if (position == dataSource.position()) {
                    return -1;
                }
                if (((long) byteBuffer.remaining()) <= position - dataSource.position()) {
                    return dataSource.read(byteBuffer);
                }
                ByteBuffer allocate = ByteBuffer.allocate(CastUtils.m7705a(position - dataSource.position()));
                dataSource.read(allocate);
                byteBuffer.put((ByteBuffer) allocate.rewind());
                return allocate.capacity();
            }

            public long size() throws IOException {
                return position;
            }

            public long position() throws IOException {
                return dataSource.position();
            }

            public void position(long j) throws IOException {
                dataSource.position(j);
            }

            public long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
                return dataSource.transferTo(j, j2, writableByteChannel);
            }

            public ByteBuffer map(long j, long j2) throws IOException {
                return dataSource.map(j, j2);
            }

            public void close() throws IOException {
                dataSource.close();
            }
        }, j - 78, boxParser);
    }

    public final void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(78);
        allocate.position(6);
        IsoTypeWriter.m3299b(allocate, this.dataReferenceIndex);
        IsoTypeWriter.m3299b(allocate, 0);
        IsoTypeWriter.m3299b(allocate, 0);
        IsoTypeWriter.m3300b(allocate, this.predefined[0]);
        IsoTypeWriter.m3300b(allocate, this.predefined[1]);
        IsoTypeWriter.m3300b(allocate, this.predefined[2]);
        IsoTypeWriter.m3299b(allocate, getWidth());
        IsoTypeWriter.m3299b(allocate, getHeight());
        IsoTypeWriter.m3294a(allocate, getHorizresolution());
        IsoTypeWriter.m3294a(allocate, getVertresolution());
        IsoTypeWriter.m3300b(allocate, 0);
        IsoTypeWriter.m3299b(allocate, getFrameCount());
        IsoTypeWriter.m3303c(allocate, Utf8.m3309b(getCompressorname()));
        allocate.put(Utf8.m3308a(getCompressorname()));
        int b = Utf8.m3309b(getCompressorname());
        while (b < 31) {
            b++;
            allocate.put((byte) 0);
        }
        IsoTypeWriter.m3299b(allocate, getDepth());
        IsoTypeWriter.m3299b(allocate, 65535);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public final long getSize() {
        int i;
        long containerSize = getContainerSize() + 78;
        if (!this.largeBox) {
            if (8 + containerSize < 4294967296L) {
                i = 8;
                return containerSize + ((long) i);
            }
        }
        i = 16;
        return containerSize + ((long) i);
    }
}
