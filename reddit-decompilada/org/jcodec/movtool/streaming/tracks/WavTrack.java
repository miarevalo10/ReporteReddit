package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.codecs.wav.WavHeader;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.boxes.channel.Label;
import org.jcodec.movtool.streaming.AudioCodecMeta;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class WavTrack implements VirtualTrack {
    public static final int FRAMES_PER_PKT = 1024;
    private int frameNo;
    private WavHeader header;
    private long offset;
    private int pktDataLen;
    private double pktDuration;
    private ByteChannelPool pool;
    private double pts;
    private AudioCodecMeta se;
    private long size;

    public class WavPacket implements VirtualPacket {
        private int dataLen;
        private int frameNo;
        private long offset;
        private double pts;

        public boolean isKeyframe() {
            return true;
        }

        public WavPacket(int i, double d, long j, int i2) {
            this.frameNo = i;
            this.pts = d;
            this.offset = j;
            this.dataLen = i2;
        }

        public ByteBuffer getData() throws IOException {
            SeekableByteChannel channel;
            Throwable th;
            try {
                channel = WavTrack.this.pool.getChannel();
                try {
                    channel.position(this.offset);
                    ByteBuffer allocate = ByteBuffer.allocate(this.dataLen);
                    NIOUtils.read((ReadableByteChannel) channel, allocate);
                    allocate.flip();
                    channel.close();
                    return allocate;
                } catch (Throwable th2) {
                    th = th2;
                    channel.close();
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                channel = null;
                th = th4;
                channel.close();
                throw th;
            }
        }

        public int getDataLen() throws IOException {
            return this.dataLen;
        }

        public double getPts() {
            return this.pts;
        }

        public double getDuration() {
            return WavTrack.this.pktDuration;
        }

        public int getFrameNo() {
            return this.frameNo;
        }
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public WavTrack(ByteChannelPool byteChannelPool, Label... labelArr) throws IOException {
        this.pool = byteChannelPool;
        try {
            byteChannelPool = byteChannelPool.getChannel();
            try {
                this.header = WavHeader.read((ReadableByteChannel) byteChannelPool);
                this.size = this.header.dataSize <= 0 ? byteChannelPool.size() : this.header.dataSize;
                byteChannelPool.close();
                this.se = new AudioCodecMeta("sowt", ByteBuffer.allocate(0), new AudioFormat(this.header.fmt.sampleRate, this.header.fmt.bitsPerSample >> 3, this.header.fmt.numChannels, true, false), true, labelArr);
                this.pktDataLen = (1024 * this.header.fmt.numChannels) * (this.header.fmt.bitsPerSample >> 3);
                this.pktDuration = 0 / ((double) this.header.fmt.sampleRate);
                this.offset = (long) this.header.dataOffset;
                this.pts = null;
                this.frameNo = 0;
            } catch (Throwable th) {
                labelArr = th;
                byteChannelPool.close();
                throw labelArr;
            }
        } catch (Throwable th2) {
            labelArr = th2;
            byteChannelPool = null;
            byteChannelPool.close();
            throw labelArr;
        }
    }

    public VirtualPacket nextPacket() throws IOException {
        if (this.offset >= this.size) {
            return null;
        }
        VirtualPacket wavPacket = new WavPacket(this.frameNo, this.pts, this.offset, (int) Math.min(this.size - this.offset, (long) this.pktDataLen));
        this.offset += (long) this.pktDataLen;
        this.frameNo += 1024;
        this.pts = ((double) this.frameNo) / ((double) this.header.fmt.sampleRate);
        return wavPacket;
    }

    public CodecMeta getCodecMeta() {
        return this.se;
    }

    public int getPreferredTimescale() {
        return this.header.fmt.sampleRate;
    }

    public void close() throws IOException {
        this.pool.close();
    }
}
