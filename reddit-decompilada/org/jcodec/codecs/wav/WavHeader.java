package org.jcodec.codecs.wav;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.IOUtils;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.model.ChannelLabel;

public class WavHeader {
    public static final int WAV_HEADER_SIZE = 44;
    static ChannelLabel[] mapping = new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.FRONT_CENTER_LEFT, ChannelLabel.FRONT_CENTER_RIGHT, ChannelLabel.REAR_CENTER, ChannelLabel.SIDE_LEFT, ChannelLabel.SIDE_RIGHT, ChannelLabel.CENTER, ChannelLabel.FRONT_LEFT, ChannelLabel.CENTER, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_CENTER, ChannelLabel.REAR_RIGHT, ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
    public String chunkId;
    public int chunkSize;
    public int dataOffset;
    public long dataSize;
    public FmtChunk fmt;
    public String format;

    public static class FmtChunk {
        public short audioFormat;
        public short bitsPerSample;
        public short blockAlign;
        public int byteRate;
        public short numChannels;
        public int sampleRate;

        public int size() {
            return 16;
        }

        public FmtChunk() {
            this.audioFormat = (short) 1;
        }

        public FmtChunk(short s, short s2, int i, int i2, short s3, short s4) {
            this.audioFormat = s;
            this.numChannels = s2;
            this.sampleRate = i;
            this.byteRate = i2;
            this.blockAlign = s3;
            this.bitsPerSample = s4;
        }

        public FmtChunk(FmtChunk fmtChunk) {
            this(fmtChunk.audioFormat, fmtChunk.numChannels, fmtChunk.sampleRate, fmtChunk.byteRate, fmtChunk.blockAlign, fmtChunk.bitsPerSample);
        }

        public static FmtChunk get(ByteBuffer byteBuffer) throws IOException {
            ByteOrder order = byteBuffer.order();
            try {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                FmtChunk fmtChunk = new FmtChunk(byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getShort(), byteBuffer.getShort());
                return fmtChunk;
            } finally {
                byteBuffer.order(order);
            }
        }

        public void put(ByteBuffer byteBuffer) throws IOException {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort(this.audioFormat);
            byteBuffer.putShort(this.numChannels);
            byteBuffer.putInt(this.sampleRate);
            byteBuffer.putInt(this.byteRate);
            byteBuffer.putShort(this.blockAlign);
            byteBuffer.putShort(this.bitsPerSample);
            byteBuffer.order(order);
        }
    }

    public static class FmtChunkExtended extends FmtChunk {
        short bitsPerCodedSample;
        short cbSize;
        int channelLayout;
        int guid;

        public FmtChunkExtended(FmtChunk fmtChunk, short s, short s2, int i, int i2) {
            super(fmtChunk);
            this.cbSize = s;
            this.bitsPerCodedSample = s2;
            this.channelLayout = i;
            this.guid = i2;
        }

        public FmtChunkExtended(FmtChunkExtended fmtChunkExtended) {
            this(fmtChunkExtended, fmtChunkExtended.cbSize, fmtChunkExtended.bitsPerCodedSample, fmtChunkExtended.channelLayout, fmtChunkExtended.guid);
        }

        public static FmtChunk read(ByteBuffer byteBuffer) throws IOException {
            FmtChunk fmtChunk = FmtChunk.get(byteBuffer);
            ByteOrder order = byteBuffer.order();
            try {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                FmtChunk fmtChunkExtended = new FmtChunkExtended(fmtChunk, byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getInt(), byteBuffer.getInt());
                return fmtChunkExtended;
            } finally {
                byteBuffer.order(order);
            }
        }

        public void put(ByteBuffer byteBuffer) throws IOException {
            super.put(byteBuffer);
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort(this.cbSize);
            byteBuffer.putShort(this.bitsPerCodedSample);
            byteBuffer.putInt(this.channelLayout);
            byteBuffer.putInt(this.guid);
            byteBuffer.order(order);
        }

        public int size() {
            return super.size() + 12;
        }

        public ChannelLabel[] getLabels() {
            List arrayList = new ArrayList();
            for (int i = 0; i < WavHeader.mapping.length; i++) {
                if ((this.channelLayout & (1 << i)) != 0) {
                    arrayList.add(WavHeader.mapping[i]);
                }
            }
            return (ChannelLabel[]) arrayList.toArray(new ChannelLabel[0]);
        }
    }

    public static long calcDataSize(int i, int i2, long j) {
        return (j * ((long) i)) * ((long) i2);
    }

    public WavHeader(String str, int i, String str2, FmtChunk fmtChunk, int i2, long j) {
        this.chunkId = str;
        this.chunkSize = i;
        this.format = str2;
        this.fmt = fmtChunk;
        this.dataOffset = i2;
        this.dataSize = j;
    }

    public WavHeader(WavHeader wavHeader) {
        this(wavHeader.chunkId, wavHeader.chunkSize, wavHeader.format, wavHeader.fmt instanceof FmtChunkExtended ? new FmtChunkExtended((FmtChunkExtended) wavHeader.fmt) : new FmtChunk(wavHeader.fmt), wavHeader.dataOffset, wavHeader.dataSize);
    }

    public static WavHeader copyWithRate(WavHeader wavHeader, int i) {
        WavHeader wavHeader2 = new WavHeader(wavHeader);
        wavHeader2.fmt.sampleRate = i;
        return wavHeader2;
    }

    public static WavHeader copyWithChannels(WavHeader wavHeader, int i) {
        WavHeader wavHeader2 = new WavHeader(wavHeader);
        wavHeader2.fmt.numChannels = (short) i;
        return wavHeader2;
    }

    public WavHeader(AudioFormat audioFormat, int i) {
        this("RIFF", 40, "WAVE", new FmtChunk((short) 1, (short) audioFormat.getChannels(), audioFormat.getSampleRate(), (audioFormat.getSampleRate() * audioFormat.getChannels()) * (audioFormat.getSampleSizeInBits() >> 3), (short) (audioFormat.getChannels() * (audioFormat.getSampleSizeInBits() >> 3)), (short) audioFormat.getSampleSizeInBits()), 44, calcDataSize(audioFormat.getChannels(), audioFormat.getSampleSizeInBits() >> 3, (long) i));
    }

    public static WavHeader stereo48k() {
        return stereo48k(0);
    }

    public static WavHeader stereo48k(long j) {
        return new WavHeader("RIFF", 40, "WAVE", new FmtChunk((short) 1, (short) 2, 48000, 192000, (short) 4, (short) 16), 44, calcDataSize(2, 2, j));
    }

    public static WavHeader mono48k(long j) {
        return new WavHeader("RIFF", 40, "WAVE", new FmtChunk((short) 1, (short) 1, 48000, 96000, (short) 2, (short) 16), 44, calcDataSize(1, 2, j));
    }

    public static WavHeader emptyWavHeader() {
        return new WavHeader("RIFF", 40, "WAVE", new FmtChunk(), 44, 0);
    }

    public static WavHeader read(File file) throws IOException {
        Throwable th;
        try {
            file = NIOUtils.readableFileChannel(file);
            try {
                WavHeader read = read((ReadableByteChannel) file);
                IOUtils.closeQuietly(file);
                return read;
            } catch (Throwable th2) {
                th = th2;
                IOUtils.closeQuietly(file);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            file = null;
            IOUtils.closeQuietly(file);
            throw th;
        }
    }

    public static WavHeader read(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        readableByteChannel.read(allocate);
        if (allocate.remaining() > null) {
            throw new IOException("Incomplete wav header found");
        }
        allocate.flip();
        String readString = NIOUtils.readString(allocate, 4);
        int i = allocate.getInt();
        String readString2 = NIOUtils.readString(allocate, 4);
        WavHeader wavHeader = null;
        if ("RIFF".equals(readString)) {
            if ("WAVE".equals(readString2)) {
                int i2;
                String readString3;
                do {
                    readString3 = NIOUtils.readString(allocate, 4);
                    i2 = allocate.getInt();
                    if (!"fmt ".equals(readString3) || i2 < 14 || i2 > 1048576) {
                        if (!"data".equals(readString3)) {
                            NIOUtils.skip(allocate, i2);
                        }
                    } else if (i2 == 16) {
                        wavHeader = FmtChunk.get(allocate);
                    } else if (i2 == 18) {
                        wavHeader = FmtChunk.get(allocate);
                        NIOUtils.skip(allocate, 2);
                    } else if (i2 == 28) {
                        wavHeader = FmtChunk.get(allocate);
                    } else if (i2 != 40) {
                        StringBuilder stringBuilder = new StringBuilder("Don't know how to handle fmt size: ");
                        stringBuilder.append(i2);
                        throw new IllegalStateException(stringBuilder.toString());
                    } else {
                        wavHeader = FmtChunk.get(allocate);
                        NIOUtils.skip(allocate, 12);
                    }
                } while (!"data".equals(readString3));
                return new WavHeader(readString, i, readString2, wavHeader, allocate.position(), (long) i2);
            }
        }
        return null;
    }

    public static WavHeader multiChannelWav(List<File> list) throws IOException {
        return multiChannelWav((File[]) list.toArray(new File[0]));
    }

    public static WavHeader multiChannelWav(File... fileArr) throws IOException {
        WavHeader[] wavHeaderArr = new WavHeader[fileArr.length];
        for (int i = 0; i < fileArr.length; i++) {
            wavHeaderArr[i] = read(fileArr[i]);
        }
        return multiChannelWav(wavHeaderArr);
    }

    public static WavHeader multiChannelWav(WavHeader... wavHeaderArr) {
        WavHeader emptyWavHeader = emptyWavHeader();
        int i = 0;
        int i2 = i;
        while (i < wavHeaderArr.length) {
            i2 = (int) (((long) i2) + wavHeaderArr[i].dataSize);
            i++;
        }
        emptyWavHeader.dataSize = (long) i2;
        FmtChunk fmtChunk = wavHeaderArr[0].fmt;
        short s = fmtChunk.bitsPerSample;
        i = s / 8;
        int i3 = fmtChunk.sampleRate;
        emptyWavHeader.fmt.bitsPerSample = (short) s;
        emptyWavHeader.fmt.blockAlign = (short) (wavHeaderArr.length * i);
        emptyWavHeader.fmt.byteRate = (wavHeaderArr.length * i) * i3;
        emptyWavHeader.fmt.numChannels = (short) wavHeaderArr.length;
        emptyWavHeader.fmt.sampleRate = i3;
        return emptyWavHeader;
    }

    public void write(WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(44);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long j = this.dataSize <= 4294967295L ? this.dataSize + 36 : 40;
        allocate.put(JCodecUtil.asciiString("RIFF"));
        allocate.putInt((int) j);
        allocate.put(JCodecUtil.asciiString("WAVE"));
        allocate.put(JCodecUtil.asciiString("fmt "));
        allocate.putInt(this.fmt.size());
        this.fmt.put(allocate);
        allocate.put(JCodecUtil.asciiString("data"));
        if (this.dataSize <= 4294967295L) {
            allocate.putInt((int) this.dataSize);
        } else {
            allocate.putInt(0);
        }
        allocate.flip();
        writableByteChannel.write(allocate);
    }

    public static WavHeader create(AudioFormat audioFormat, int i) {
        WavHeader emptyWavHeader = emptyWavHeader();
        emptyWavHeader.dataSize = (long) i;
        i = new FmtChunk();
        i = audioFormat.getSampleSizeInBits();
        audioFormat.getSampleRate();
        emptyWavHeader.fmt.bitsPerSample = (short) i;
        emptyWavHeader.fmt.blockAlign = audioFormat.getFrameSize();
        emptyWavHeader.fmt.byteRate = audioFormat.getFrameRate() * audioFormat.getFrameSize();
        emptyWavHeader.fmt.numChannels = (short) audioFormat.getChannels();
        emptyWavHeader.fmt.sampleRate = audioFormat.getSampleRate();
        return emptyWavHeader;
    }

    public ChannelLabel[] getChannelLabels() {
        if (this.fmt instanceof FmtChunkExtended) {
            return ((FmtChunkExtended) this.fmt).getLabels();
        }
        switch (this.fmt.numChannels) {
            case (short) 1:
                return new ChannelLabel[]{ChannelLabel.MONO};
            case (short) 2:
                return new ChannelLabel[]{ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
            case (short) 3:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_CENTER};
            case (short) 4:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
            case (short) 5:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
            case (short) 6:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
            case (short) 7:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.REAR_CENTER};
            case (short) 8:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
            default:
                ChannelLabel[] channelLabelArr = new ChannelLabel[this.fmt.numChannels];
                Arrays.fill(channelLabelArr, ChannelLabel.MONO);
                return channelLabelArr;
        }
    }

    public AudioFormat getFormat() {
        return new AudioFormat(this.fmt.sampleRate, this.fmt.bitsPerSample, this.fmt.numChannels, true, false);
    }
}
