package org.jcodec.movtool.streaming.tracks;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.RunLength.Integer;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class MPSTrackFactory {
    private FilePool fp;
    private long[] pesTokens;
    private int[] streams;
    private Map<Integer, Stream> tracks = new HashMap();

    public class Stream implements VirtualTrack {
        private int curFrame;
        private long duration;
        private long fileOff;
        private long[] fpts;
        private int[] fsizes;
        private int offInPayload;
        private int pesIdx;
        private ByteBuffer si;
        private int siLen;
        private int streamId;
        private int[] sync;

        protected class MPSPacket implements VirtualPacket {
            private int curFrame;
            private long fileOff;
            private int pesIdx;
            private int pesOff;

            public MPSPacket(int i, long j, int i2, int i3) {
                this.pesOff = i;
                this.fileOff = j;
                this.curFrame = i2;
                this.pesIdx = i3;
            }

            public ByteBuffer getData() throws IOException {
                ReadableByteChannel channel;
                Throwable th;
                ByteBuffer allocate = ByteBuffer.allocate(Stream.this.siLen + Stream.this.fsizes[this.curFrame]);
                allocate.put(Stream.this.si.duplicate());
                try {
                    channel = MPSTrackFactory.this.fp.getChannel();
                    try {
                        long j = r1.fileOff;
                        ByteBuffer readPes = Stream.this.readPes(channel, j, Stream.this.pesLen(MPSTrackFactory.this.pesTokens[r1.pesIdx]), Stream.this.payloadLen(MPSTrackFactory.this.pesTokens[r1.pesIdx]), r1.pesIdx);
                        j += (long) Stream.this.pesLen(MPSTrackFactory.this.pesTokens[r1.pesIdx]);
                        NIOUtils.skip(readPes, r1.pesOff);
                        allocate.put(NIOUtils.read(readPes, Math.min(readPes.remaining(), allocate.remaining())));
                        int i = r1.pesIdx;
                        while (allocate.hasRemaining()) {
                            i++;
                            long j2 = 0;
                            while (MPSTrackFactory.this.streams[i] != Stream.this.streamId && i < MPSTrackFactory.this.pesTokens.length) {
                                j2 += (long) (Stream.this.pesLen(MPSTrackFactory.this.pesTokens[i]) + Stream.this.leadingSize(MPSTrackFactory.this.pesTokens[i]));
                                i++;
                            }
                            long j3 = j;
                            ByteBuffer readPes2 = Stream.this.readPes(channel, (j + j2) + ((long) Stream.this.leadingSize(MPSTrackFactory.this.pesTokens[i])), Stream.this.pesLen(MPSTrackFactory.this.pesTokens[i]), Stream.this.payloadLen(MPSTrackFactory.this.pesTokens[i]), i);
                            j = j3 + ((j2 + ((long) Stream.this.leadingSize(MPSTrackFactory.this.pesTokens[i]))) + ((long) Stream.this.pesLen(MPSTrackFactory.this.pesTokens[i])));
                            allocate.put(NIOUtils.read(readPes2, Math.min(readPes2.remaining(), allocate.remaining())));
                        }
                        allocate.flip();
                        NIOUtils.closeQuietly(channel);
                        return allocate;
                    } catch (Throwable th2) {
                        th = th2;
                        NIOUtils.closeQuietly(channel);
                        throw th;
                    }
                } catch (Throwable th22) {
                    th = th22;
                    channel = null;
                    NIOUtils.closeQuietly(channel);
                    throw th;
                }
            }

            public int getDataLen() throws IOException {
                return Stream.this.siLen + Stream.this.fsizes[this.curFrame];
            }

            public double getPts() {
                return ((double) (Stream.this.fpts[this.curFrame] - Stream.this.fpts[0])) / 90000.0d;
            }

            public double getDuration() {
                return ((double) Stream.this.duration) / 90000.0d;
            }

            public boolean isKeyframe() {
                if (Stream.this.sync.length != 0) {
                    if (Arrays.binarySearch(Stream.this.sync, this.curFrame) < 0) {
                        return false;
                    }
                }
                return true;
            }

            public int getFrameNo() {
                return this.curFrame;
            }
        }

        private int leadingSize(long j) {
            return (int) ((j >>> 48) & 65535);
        }

        private int payloadLen(long j) {
            return (int) (j & 16777215);
        }

        private int pesLen(long j) {
            return (int) ((j >>> 24) & 16777215);
        }

        public VirtualEdit[] getEdits() {
            return null;
        }

        public int getPreferredTimescale() {
            return 90000;
        }

        public Stream(int i) {
            this.streamId = i;
        }

        public void parseIndex(ByteBuffer byteBuffer) throws IOException {
            int i;
            ReadableByteChannel channel;
            this.siLen = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            this.fsizes = new int[i2];
            this.fpts = new long[i2];
            for (i = 0; i < i2; i++) {
                this.fsizes[i] = byteBuffer.getInt();
            }
            i = byteBuffer.getInt();
            this.sync = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                this.sync[i3] = byteBuffer.getInt();
            }
            for (i = 0; i < i2; i++) {
                this.fpts[i] = ((long) byteBuffer.getInt()) & 4294967295L;
            }
            byteBuffer = Arrays.copyOf(this.fpts, 10);
            Arrays.sort(byteBuffer);
            Object obj = new long[10];
            System.arraycopy(this.fpts, this.fpts.length - 10, obj, 0, 10);
            Arrays.sort(obj);
            this.duration = ((obj[9] - byteBuffer[0]) + ((long) (this.fpts.length >> 1))) / ((long) this.fpts.length);
            this.offInPayload = this.siLen;
            this.fileOff = 0;
            while (MPSTrackFactory.this.streams[this.pesIdx] != this.streamId) {
                this.fileOff += (long) (pesLen(MPSTrackFactory.this.pesTokens[this.pesIdx]) + leadingSize(MPSTrackFactory.this.pesTokens[this.pesIdx]));
                this.pesIdx++;
            }
            this.fileOff += (long) leadingSize(MPSTrackFactory.this.pesTokens[this.pesIdx]);
            try {
                channel = MPSTrackFactory.this.fp.getChannel();
                try {
                    this.si = NIOUtils.read(readPes(channel, this.fileOff, pesLen(MPSTrackFactory.this.pesTokens[this.pesIdx]), payloadLen(MPSTrackFactory.this.pesTokens[this.pesIdx]), this.pesIdx), this.siLen);
                    NIOUtils.closeQuietly(channel);
                } catch (Throwable th) {
                    byteBuffer = th;
                    NIOUtils.closeQuietly(channel);
                    throw byteBuffer;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                channel = null;
                byteBuffer = th3;
                NIOUtils.closeQuietly(channel);
                throw byteBuffer;
            }
        }

        protected ByteBuffer readPes(SeekableByteChannel seekableByteChannel, long j, int i, int i2, int i3) throws IOException {
            seekableByteChannel.position(j);
            seekableByteChannel = NIOUtils.fetchFrom((ReadableByteChannel) seekableByteChannel, i);
            MPSUtils.readPESHeader(seekableByteChannel, 0);
            return seekableByteChannel;
        }

        public VirtualPacket nextPacket() throws IOException {
            if (this.curFrame >= this.fsizes.length) {
                return null;
            }
            VirtualPacket mPSPacket = new MPSPacket(this.offInPayload, this.fileOff, this.curFrame, this.pesIdx);
            this.offInPayload += this.fsizes[this.curFrame];
            while (this.pesIdx < MPSTrackFactory.this.streams.length && this.offInPayload >= payloadLen(MPSTrackFactory.this.pesTokens[this.pesIdx])) {
                this.offInPayload -= payloadLen(MPSTrackFactory.this.pesTokens[this.pesIdx]);
                this.fileOff += (long) pesLen(MPSTrackFactory.this.pesTokens[this.pesIdx]);
                this.pesIdx++;
                if (this.pesIdx < MPSTrackFactory.this.streams.length) {
                    long j = 0;
                    while (MPSTrackFactory.this.streams[this.pesIdx] != this.streamId) {
                        j += (long) (pesLen(MPSTrackFactory.this.pesTokens[this.pesIdx]) + leadingSize(MPSTrackFactory.this.pesTokens[this.pesIdx]));
                        this.pesIdx++;
                    }
                    this.fileOff += j + ((long) leadingSize(MPSTrackFactory.this.pesTokens[this.pesIdx]));
                }
            }
            this.curFrame++;
            return mPSPacket;
        }

        public CodecMeta getCodecMeta() {
            return new VideoCodecMeta("m2v1", ByteBuffer.allocate(0), new Size(1920, 1080), new Rational(1, 1));
        }

        public void close() throws IOException {
            MPSTrackFactory.this.fp.close();
        }
    }

    public MPSTrackFactory(ByteBuffer byteBuffer, FilePool filePool) throws IOException {
        this.fp = filePool;
        readIndex(byteBuffer);
    }

    protected void readIndex(ByteBuffer byteBuffer) throws IOException {
        this.pesTokens = new long[byteBuffer.getInt()];
        for (int i = 0; i < this.pesTokens.length; i++) {
            this.pesTokens[i] = byteBuffer.getLong();
        }
        this.streams = Integer.parse(byteBuffer).flattern();
        while (byteBuffer.hasRemaining()) {
            getStream(this.tracks, byteBuffer.get() & 255).parseIndex(byteBuffer);
        }
    }

    private Stream getStream(Map<Integer, Stream> map, int i) {
        Stream stream = (Stream) map.get(Integer.valueOf(i));
        if (stream != null) {
            return stream;
        }
        stream = createStream(i);
        map.put(Integer.valueOf(i), stream);
        return stream;
    }

    protected Stream createStream(int i) {
        return new Stream(i);
    }

    public List<Stream> getVideoStreams() {
        List<Stream> arrayList = new ArrayList();
        for (Entry entry : this.tracks.entrySet()) {
            if (MPSUtils.videoStream(((Integer) entry.getKey()).intValue())) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    public List<Stream> getAudioStreams() {
        List<Stream> arrayList = new ArrayList();
        for (Entry entry : this.tracks.entrySet()) {
            if (MPSUtils.audioStream(((Integer) entry.getKey()).intValue())) {
                arrayList.add(entry.getValue());
            }
        }
        return arrayList;
    }

    public List<Stream> getStreams() {
        return new ArrayList(this.tracks.values());
    }

    public static void main(String[] strArr) throws IOException {
        int i = 0;
        Stream stream = (Stream) new MPSTrackFactory(NIOUtils.fetchFrom(new File(strArr[1])), new FilePool(new File(strArr[0]), 10)).getVideoStreams().get(0);
        strArr = NIOUtils.writableFileChannel(new File(strArr[2]));
        List<VirtualPacket> arrayList = new ArrayList();
        while (i < CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE) {
            arrayList.add(stream.nextPacket());
            i++;
        }
        for (VirtualPacket data : arrayList) {
            strArr.write(data.getData());
        }
        strArr.close();
    }
}
