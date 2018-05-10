package com.coremedia.iso.boxes.sampleentry;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class AudioSampleEntry extends AbstractSampleEntry {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE1 = "samr";
    public static final String TYPE10 = "mlpa";
    public static final String TYPE11 = "dtsl";
    public static final String TYPE12 = "dtsh";
    public static final String TYPE13 = "dtse";
    public static final String TYPE2 = "sawb";
    public static final String TYPE3 = "mp4a";
    public static final String TYPE4 = "drms";
    public static final String TYPE5 = "alac";
    public static final String TYPE7 = "owma";
    public static final String TYPE8 = "ac-3";
    public static final String TYPE9 = "ec-3";
    public static final String TYPE_ENCRYPTED = "enca";
    private long bytesPerFrame;
    private long bytesPerPacket;
    private long bytesPerSample;
    private int channelCount;
    private int compressionId;
    private int packetSize;
    private int reserved1;
    private long reserved2;
    private long sampleRate;
    private int sampleSize;
    private long samplesPerPacket;
    private int soundVersion;
    private byte[] soundVersion2Data;

    public AudioSampleEntry(String str) {
        super(str);
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final int getChannelCount() {
        return this.channelCount;
    }

    public final int getSampleSize() {
        return this.sampleSize;
    }

    public final long getSampleRate() {
        return this.sampleRate;
    }

    public final int getSoundVersion() {
        return this.soundVersion;
    }

    public final int getCompressionId() {
        return this.compressionId;
    }

    public final int getPacketSize() {
        return this.packetSize;
    }

    public final long getSamplesPerPacket() {
        return this.samplesPerPacket;
    }

    public final long getBytesPerPacket() {
        return this.bytesPerPacket;
    }

    public final long getBytesPerFrame() {
        return this.bytesPerFrame;
    }

    public final long getBytesPerSample() {
        return this.bytesPerSample;
    }

    public final byte[] getSoundVersion2Data() {
        return this.soundVersion2Data;
    }

    public final int getReserved1() {
        return this.reserved1;
    }

    public final long getReserved2() {
        return this.reserved2;
    }

    public final void setChannelCount(int i) {
        this.channelCount = i;
    }

    public final void setSampleSize(int i) {
        this.sampleSize = i;
    }

    public final void setSampleRate(long j) {
        this.sampleRate = j;
    }

    public final void setSoundVersion(int i) {
        this.soundVersion = i;
    }

    public final void setCompressionId(int i) {
        this.compressionId = i;
    }

    public final void setPacketSize(int i) {
        this.packetSize = i;
    }

    public final void setSamplesPerPacket(long j) {
        this.samplesPerPacket = j;
    }

    public final void setBytesPerPacket(long j) {
        this.bytesPerPacket = j;
    }

    public final void setBytesPerFrame(long j) {
        this.bytesPerFrame = j;
    }

    public final void setBytesPerSample(long j) {
        this.bytesPerSample = j;
    }

    public final void setReserved1(int i) {
        this.reserved1 = i;
    }

    public final void setReserved2(long j) {
        this.reserved2 = j;
    }

    public final void setSoundVersion2Data(byte[] bArr) {
        this.soundVersion2Data = bArr;
    }

    public final void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        byteBuffer = ByteBuffer.allocate(28);
        dataSource.read(byteBuffer);
        byteBuffer.position(6);
        this.dataReferenceIndex = IsoTypeReader.m3283c(byteBuffer);
        this.soundVersion = IsoTypeReader.m3283c(byteBuffer);
        this.reserved1 = IsoTypeReader.m3283c(byteBuffer);
        this.reserved2 = IsoTypeReader.m3280a(byteBuffer);
        this.channelCount = IsoTypeReader.m3283c(byteBuffer);
        this.sampleSize = IsoTypeReader.m3283c(byteBuffer);
        this.compressionId = IsoTypeReader.m3283c(byteBuffer);
        this.packetSize = IsoTypeReader.m3283c(byteBuffer);
        this.sampleRate = IsoTypeReader.m3280a(byteBuffer);
        int i = 16;
        if (this.type.equals(TYPE10) == null) {
            this.sampleRate >>>= 16;
        }
        if (this.soundVersion == 1) {
            byteBuffer = ByteBuffer.allocate(16);
            dataSource.read(byteBuffer);
            byteBuffer.rewind();
            this.samplesPerPacket = IsoTypeReader.m3280a(byteBuffer);
            this.bytesPerPacket = IsoTypeReader.m3280a(byteBuffer);
            this.bytesPerFrame = IsoTypeReader.m3280a(byteBuffer);
            this.bytesPerSample = IsoTypeReader.m3280a(byteBuffer);
        }
        int i2 = 36;
        if (this.soundVersion == 2) {
            byteBuffer = ByteBuffer.allocate(36);
            dataSource.read(byteBuffer);
            byteBuffer.rewind();
            this.samplesPerPacket = IsoTypeReader.m3280a(byteBuffer);
            this.bytesPerPacket = IsoTypeReader.m3280a(byteBuffer);
            this.bytesPerFrame = IsoTypeReader.m3280a(byteBuffer);
            this.bytesPerSample = IsoTypeReader.m3280a(byteBuffer);
            this.soundVersion2Data = new byte[20];
            byteBuffer.get(this.soundVersion2Data);
        }
        if (TYPE7.equals(this.type) != null) {
            System.err.println(TYPE7);
            j -= 28;
            if (this.soundVersion != 1) {
                i = 0;
            }
            j -= (long) i;
            if (this.soundVersion != 2) {
                i2 = 0;
            }
            j -= (long) i2;
            byteBuffer = ByteBuffer.allocate(CastUtils.m7705a(j));
            dataSource.read(byteBuffer);
            addBox(new Box() {
                public long getOffset() {
                    return 0;
                }

                public String getType() {
                    return "----";
                }

                public void setParent(Container container) {
                }

                public Container getParent() {
                    return AudioSampleEntry.this;
                }

                public long getSize() {
                    return j;
                }

                public void getBox(WritableByteChannel writableByteChannel) throws IOException {
                    byteBuffer.rewind();
                    writableByteChannel.write(byteBuffer);
                }

                public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
                    throw new RuntimeException("NotImplemented");
                }
            });
            return;
        }
        j -= 28;
        if (this.soundVersion != 1) {
            i = 0;
        }
        j -= (long) i;
        if (this.soundVersion != 2) {
            i2 = 0;
        }
        initContainer(dataSource, j - ((long) i2), boxParser);
    }

    public final void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        int i = 0;
        int i2 = 28 + (this.soundVersion == 1 ? 16 : 0);
        if (this.soundVersion == 2) {
            i = 36;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2 + i);
        allocate.position(6);
        IsoTypeWriter.m3299b(allocate, this.dataReferenceIndex);
        IsoTypeWriter.m3299b(allocate, this.soundVersion);
        IsoTypeWriter.m3299b(allocate, this.reserved1);
        IsoTypeWriter.m3300b(allocate, this.reserved2);
        IsoTypeWriter.m3299b(allocate, this.channelCount);
        IsoTypeWriter.m3299b(allocate, this.sampleSize);
        IsoTypeWriter.m3299b(allocate, this.compressionId);
        IsoTypeWriter.m3299b(allocate, this.packetSize);
        if (this.type.equals(TYPE10)) {
            IsoTypeWriter.m3300b(allocate, getSampleRate());
        } else {
            IsoTypeWriter.m3300b(allocate, getSampleRate() << 16);
        }
        if (this.soundVersion == 1) {
            IsoTypeWriter.m3300b(allocate, this.samplesPerPacket);
            IsoTypeWriter.m3300b(allocate, this.bytesPerPacket);
            IsoTypeWriter.m3300b(allocate, this.bytesPerFrame);
            IsoTypeWriter.m3300b(allocate, this.bytesPerSample);
        }
        if (this.soundVersion == 2) {
            IsoTypeWriter.m3300b(allocate, this.samplesPerPacket);
            IsoTypeWriter.m3300b(allocate, this.bytesPerPacket);
            IsoTypeWriter.m3300b(allocate, this.bytesPerFrame);
            IsoTypeWriter.m3300b(allocate, this.bytesPerSample);
            allocate.put(this.soundVersion2Data);
        }
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public final long getSize() {
        int i = 0;
        int i2 = 16;
        int i3 = 28 + (this.soundVersion == 1 ? 16 : 0);
        if (this.soundVersion == 2) {
            i = 36;
        }
        long containerSize = ((long) (i3 + i)) + getContainerSize();
        if (!this.largeBox) {
            if (8 + containerSize < 4294967296L) {
                i2 = 8;
            }
        }
        return containerSize + ((long) i2);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AudioSampleEntry{bytesPerSample=");
        stringBuilder.append(this.bytesPerSample);
        stringBuilder.append(", bytesPerFrame=");
        stringBuilder.append(this.bytesPerFrame);
        stringBuilder.append(", bytesPerPacket=");
        stringBuilder.append(this.bytesPerPacket);
        stringBuilder.append(", samplesPerPacket=");
        stringBuilder.append(this.samplesPerPacket);
        stringBuilder.append(", packetSize=");
        stringBuilder.append(this.packetSize);
        stringBuilder.append(", compressionId=");
        stringBuilder.append(this.compressionId);
        stringBuilder.append(", soundVersion=");
        stringBuilder.append(this.soundVersion);
        stringBuilder.append(", sampleRate=");
        stringBuilder.append(this.sampleRate);
        stringBuilder.append(", sampleSize=");
        stringBuilder.append(this.sampleSize);
        stringBuilder.append(", channelCount=");
        stringBuilder.append(this.channelCount);
        stringBuilder.append(", boxes=");
        stringBuilder.append(getBoxes());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
