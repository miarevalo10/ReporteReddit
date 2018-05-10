package org.jcodec.containers.mps;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.mpeg12.MPEGES;
import org.jcodec.codecs.mpeg12.SegmentReader;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.DemuxerTrackMeta.Type;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mps.MPEGDemuxer.MPEGDemuxerTrack;

public class MPSDemuxer extends SegmentReader implements MPEGDemuxer {
    private static final int BUFFER_SIZE = 1048576;
    private List<ByteBuffer> bufPool = new ArrayList();
    private SeekableByteChannel channel;
    private Map<Integer, BaseTrack> streams = new HashMap();

    public static class PESPacket {
        public ByteBuffer data;
        public long dts;
        public int length;
        public long pos;
        public long pts;
        public int streamId;

        public PESPacket(ByteBuffer byteBuffer, long j, int i, int i2, long j2, long j3) {
            this.data = byteBuffer;
            this.pts = j;
            this.streamId = i;
            this.length = i2;
            this.pos = j2;
            this.dts = j3;
        }
    }

    public abstract class BaseTrack implements MPEGDemuxerTrack {
        protected List<PESPacket> pending = new ArrayList();
        protected int streamId;

        public BaseTrack(int i, PESPacket pESPacket) throws IOException {
            this.streamId = i;
            this.pending.add(pESPacket);
        }

        public int getSid() {
            return this.streamId;
        }

        public void pending(PESPacket pESPacket) {
            if (this.pending != null) {
                this.pending.add(pESPacket);
            } else {
                MPSDemuxer.this.putBack(pESPacket.data);
            }
        }

        public List<PESPacket> getPending() {
            return this.pending;
        }

        public void ignore() {
            if (this.pending != null) {
                for (PESPacket pESPacket : this.pending) {
                    MPSDemuxer.this.putBack(pESPacket.data);
                }
                this.pending = null;
            }
        }
    }

    public static class MPEGPacket extends Packet {
        private int gop;
        private long offset;
        private ByteBuffer seq;
        private int timecode;

        public MPEGPacket(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, boolean z, TapeTimecode tapeTimecode) {
            super(byteBuffer, j, j2, j3, j4, z, tapeTimecode);
        }

        public long getOffset() {
            return this.offset;
        }

        public ByteBuffer getSeq() {
            return this.seq;
        }

        public int getGOP() {
            return this.gop;
        }

        public int getTimecode() {
            return this.timecode;
        }
    }

    public class MPEGTrack extends BaseTrack implements ReadableByteChannel {
        private MPEGES es = new MPEGES(this);

        public void close() throws IOException {
        }

        public boolean isOpen() {
            return true;
        }

        public MPEGTrack(int i, PESPacket pESPacket) throws IOException {
            super(i, pESPacket);
        }

        public MPEGES getES() {
            return this.es;
        }

        public int read(ByteBuffer byteBuffer) throws IOException {
            PESPacket packet = this.pending.size() > 0 ? (PESPacket) this.pending.remove(0) : getPacket();
            if (packet != null) {
                if (packet.data.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), packet.data.remaining());
                    byteBuffer.put(NIOUtils.read(packet.data, min));
                    if (packet.data.hasRemaining() != null) {
                        this.pending.add(0, packet);
                    } else {
                        MPSDemuxer.this.putBack(packet.data);
                    }
                    return min;
                }
            }
            return -1;
        }

        private PESPacket getPacket() throws IOException {
            if (this.pending.size() > 0) {
                return (PESPacket) this.pending.remove(0);
            }
            PESPacket nextPacket;
            while (true) {
                nextPacket = MPSDemuxer.this.nextPacket(MPSDemuxer.this.getBuffer());
                if (nextPacket == null) {
                    return null;
                }
                if (nextPacket.streamId == this.streamId) {
                    break;
                }
                MPSDemuxer.this.addToStream(nextPacket);
            }
            if (nextPacket.pts != -1) {
                this.es.curPts = nextPacket.pts;
            }
            return nextPacket;
        }

        public Packet nextFrame(ByteBuffer byteBuffer) throws IOException {
            return this.es.getFrame(byteBuffer);
        }

        public DemuxerTrackMeta getMeta() {
            Type type = MPSUtils.videoStream(this.streamId) ? Type.VIDEO : MPSUtils.audioStream(this.streamId) ? Type.AUDIO : Type.OTHER;
            return new DemuxerTrackMeta(type, null, 0, 0.0d, null);
        }
    }

    public class PlainTrack extends BaseTrack {
        private int frameNo;

        public void close() throws IOException {
        }

        public boolean isOpen() {
            return true;
        }

        public PlainTrack(int i, PESPacket pESPacket) throws IOException {
            super(i, pESPacket);
        }

        public Packet nextFrame(ByteBuffer byteBuffer) throws IOException {
            if (this.pending.size() <= null) {
                while (true) {
                    byteBuffer = MPSDemuxer.this.nextPacket(MPSDemuxer.this.getBuffer());
                    if (byteBuffer == null || byteBuffer.streamId == this.streamId) {
                        break;
                    }
                    MPSDemuxer.this.addToStream(byteBuffer);
                }
            } else {
                byteBuffer = (PESPacket) this.pending.remove(0);
            }
            if (byteBuffer == null) {
                return null;
            }
            ByteBuffer byteBuffer2 = byteBuffer.data;
            long j = byteBuffer.pts;
            byteBuffer = this.frameNo;
            this.frameNo = byteBuffer + 1;
            return new Packet(byteBuffer2, j, 90000, 0, (long) byteBuffer, true, null);
        }

        public DemuxerTrackMeta getMeta() {
            Type type = MPSUtils.videoStream(this.streamId) ? Type.VIDEO : MPSUtils.audioStream(this.streamId) ? Type.AUDIO : Type.OTHER;
            return new DemuxerTrackMeta(type, null, 0, 0.0d, null);
        }
    }

    public MPSDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        super(seekableByteChannel);
        this.channel = seekableByteChannel;
        findStreams();
    }

    protected void findStreams() throws IOException {
        int i = 0;
        while (true) {
            if (i == 0 || (i < 5 * this.streams.size() && this.streams.size() < 2)) {
                PESPacket nextPacket = nextPacket(getBuffer());
                if (nextPacket != null) {
                    addToStream(nextPacket);
                    i++;
                } else {
                    return;
                }
            }
            return;
        }
    }

    public ByteBuffer getBuffer() {
        synchronized (this.bufPool) {
            if (this.bufPool.size() > 0) {
                ByteBuffer byteBuffer = (ByteBuffer) this.bufPool.remove(0);
                return byteBuffer;
            }
            return ByteBuffer.allocate(BUFFER_SIZE);
        }
    }

    public void putBack(ByteBuffer byteBuffer) {
        byteBuffer.clear();
        synchronized (this.bufPool) {
            this.bufPool.add(byteBuffer);
        }
    }

    public void seekByte(long j) throws IOException {
        this.channel.position(j);
        reset();
    }

    public void reset() {
        for (BaseTrack baseTrack : this.streams.values()) {
            baseTrack.pending.clear();
        }
    }

    private void addToStream(PESPacket pESPacket) throws IOException {
        BaseTrack baseTrack = (BaseTrack) this.streams.get(Integer.valueOf(pESPacket.streamId));
        if (baseTrack == null) {
            Object mPEGTrack;
            if (isMPEG(pESPacket.data)) {
                mPEGTrack = new MPEGTrack(pESPacket.streamId, pESPacket);
            } else {
                mPEGTrack = new PlainTrack(pESPacket.streamId, pESPacket);
            }
            this.streams.put(Integer.valueOf(pESPacket.streamId), mPEGTrack);
            return;
        }
        baseTrack.pending(pESPacket);
    }

    public PESPacket nextPacket(ByteBuffer byteBuffer) throws IOException {
        byteBuffer = byteBuffer.duplicate();
        while (!MPSUtils.psMarker(this.curMarker)) {
            if (!skipToMarker()) {
                return null;
            }
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        readToNextMarker(byteBuffer);
        PESPacket readPESHeader = MPSUtils.readPESHeader(duplicate, curPos());
        if (readPESHeader.length == 0) {
            while (!MPSUtils.psMarker(this.curMarker) && readToNextMarker(byteBuffer)) {
            }
        } else {
            read(byteBuffer, (readPESHeader.length - byteBuffer.position()) + 6);
        }
        duplicate.limit(byteBuffer.position());
        readPESHeader.data = duplicate;
        return readPESHeader;
    }

    public List<MPEGDemuxerTrack> getTracks() {
        return new ArrayList(this.streams.values());
    }

    public List<MPEGDemuxerTrack> getVideoTracks() {
        List<MPEGDemuxerTrack> arrayList = new ArrayList();
        for (BaseTrack baseTrack : this.streams.values()) {
            if (MPSUtils.videoStream(baseTrack.streamId)) {
                arrayList.add(baseTrack);
            }
        }
        return arrayList;
    }

    public List<MPEGDemuxerTrack> getAudioTracks() {
        List<MPEGDemuxerTrack> arrayList = new ArrayList();
        for (BaseTrack baseTrack : this.streams.values()) {
            if (MPSUtils.audioStream(baseTrack.streamId)) {
                arrayList.add(baseTrack);
            }
        }
        return arrayList;
    }

    private boolean isMPEG(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.duplicate();
        int i = -1;
        boolean z = false;
        boolean z2 = z;
        int i2 = z2;
        while (byteBuffer.hasRemaining()) {
            i = (i << 8) | (byteBuffer.get() & 255);
            if (i >= 256 && i <= 440) {
                if (i >= 432 && i <= 440) {
                    if ((z && i != 437 && i != 434) || z2) {
                        break;
                    }
                    i2 += 5;
                } else if (i != 256) {
                    if (i > 256 && i < 432) {
                        if (!z) {
                            break;
                        }
                        if (!z2) {
                            i2 += 50;
                            z2 = true;
                        }
                        i2++;
                    }
                } else if (z2) {
                    break;
                } else {
                    z = true;
                }
            }
        }
        return i2 > 50;
    }

    public static int probe(ByteBuffer byteBuffer) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = i3;
        int i5 = i4;
        while (byteBuffer.hasRemaining()) {
            i2 = (i2 << 8) | (byteBuffer.get() & 255);
            if (i2 >= 256 && i2 <= 511) {
                if (!MPSUtils.videoMarker(i2)) {
                    if (i2 >= 432 && i2 <= 440 && i != 0) {
                        if ((i3 != 0 && i2 != 437 && i2 != 434) || i4 != 0) {
                            break;
                        }
                        i5 += 5;
                    } else if (i2 == 256 && i != 0) {
                        if (i4 != 0) {
                            break;
                        }
                        i3 = 1;
                    } else if (i2 > 256 && i2 < 432) {
                        if (i3 == 0) {
                            break;
                        }
                        if (i4 == 0) {
                            i5 += 50;
                            i4 = 1;
                        }
                        i5++;
                    }
                } else if (i != 0) {
                    break;
                } else {
                    i = 1;
                }
            }
        }
        return i5;
    }
}
