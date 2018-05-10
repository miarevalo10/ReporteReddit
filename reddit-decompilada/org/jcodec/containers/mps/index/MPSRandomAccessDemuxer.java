package org.jcodec.containers.mps.index;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.index.MPSIndex.MPSStreamIndex;

public class MPSRandomAccessDemuxer {
    private int[] pesStreamIds;
    private long[] pesTokens;
    private Stream[] streams;

    public class Stream extends MPSStreamIndex implements SeekableDemuxerTrack {
        private static final int MPEG_TIMESCALE = 90000;
        private int curFrame;
        private int curPesIdx;
        private long[] foffs;
        private ByteBuffer pesBuf;
        private int seekToFrame = -1;
        protected SeekableByteChannel source;

        public DemuxerTrackMeta getMeta() {
            return null;
        }

        public Stream(MPSStreamIndex mPSStreamIndex, SeekableByteChannel seekableByteChannel) throws IOException {
            super(mPSStreamIndex);
            this.source = seekableByteChannel;
            long j = 0;
            this.foffs = new long[this.fsizes.length];
            for (MPSRandomAccessDemuxer mPSRandomAccessDemuxer = null; mPSRandomAccessDemuxer < this.fsizes.length; mPSRandomAccessDemuxer++) {
                this.foffs[mPSRandomAccessDemuxer] = j;
                j += (long) this.fsizes[mPSRandomAccessDemuxer];
            }
            Arrays.sort(Arrays.copyOf(mPSStreamIndex.getFpts(), 100));
            this.seekToFrame = 0;
            seekToFrame();
        }

        public Packet nextFrame() throws IOException {
            seekToFrame();
            if (this.curFrame >= this.fsizes.length) {
                return null;
            }
            return nextFrame(ByteBuffer.allocate(this.fsizes[this.curFrame]));
        }

        public Packet nextFrame(ByteBuffer byteBuffer) throws IOException {
            seekToFrame();
            if (this.curFrame >= this.fsizes.length) {
                return null;
            }
            boolean z;
            ByteBuffer packet;
            int i = this.fsizes[this.curFrame];
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.limit(duplicate.position() + i);
            while (duplicate.hasRemaining() != null) {
                if (this.pesBuf.hasRemaining() != null) {
                    duplicate.put(NIOUtils.read(this.pesBuf, Math.min(this.pesBuf.remaining(), duplicate.remaining())));
                } else {
                    this.curPesIdx += 1;
                    long j = 0;
                    while (MPSRandomAccessDemuxer.this.pesStreamIds[this.curPesIdx] != this.streamId) {
                        j += (long) (MPSIndex.pesLen(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx]) + MPSIndex.leadingSize(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx]));
                        this.curPesIdx += 1;
                    }
                    skip(j + ((long) MPSIndex.leadingSize(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx])));
                    this.pesBuf = fetch(MPSIndex.pesLen(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx]));
                    MPSUtils.readPESHeader(this.pesBuf, 0);
                }
            }
            duplicate.flip();
            long j2 = (long) this.fpts[this.curFrame];
            long j3 = (long) this.fdur[this.curFrame];
            long j4 = (long) this.curFrame;
            if (this.sync.length != 0) {
                if (Arrays.binarySearch(this.sync, this.curFrame) < 0) {
                    z = false;
                    packet = new Packet(duplicate, j2, 90000, j3, j4, z, null);
                    this.curFrame++;
                    return packet;
                }
            }
            z = true;
            packet = new Packet(duplicate, j2, 90000, j3, j4, z, null);
            this.curFrame++;
            return packet;
        }

        protected ByteBuffer fetch(int i) throws IOException {
            return NIOUtils.fetchFrom(this.source, i);
        }

        protected void skip(long j) throws IOException {
            this.source.position(this.source.position() + j);
        }

        protected void reset() throws IOException {
            this.source.position(0);
        }

        public boolean gotoFrame(long j) {
            this.seekToFrame = (int) j;
            return 1;
        }

        public boolean gotoSyncFrame(long j) {
            for (int i = 0; i < this.sync.length; i++) {
                if (((long) this.sync[i]) > j) {
                    this.seekToFrame = this.sync[i - 1];
                    return true;
                }
            }
            this.seekToFrame = this.sync[this.sync.length - 1];
            return true;
        }

        private void seekToFrame() throws IOException {
            if (this.seekToFrame != -1) {
                this.curFrame = this.seekToFrame;
                long j = this.foffs[this.curFrame];
                reset();
                this.curPesIdx = 0;
                long j2 = 0;
                while (true) {
                    if (MPSRandomAccessDemuxer.this.pesStreamIds[this.curPesIdx] == this.streamId) {
                        long payLoadSize = (long) MPSIndex.payLoadSize(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx]);
                        if (j >= payLoadSize) {
                            j -= payLoadSize;
                        } else {
                            skip(j2 + ((long) MPSIndex.leadingSize(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx])));
                            this.pesBuf = fetch(MPSIndex.pesLen(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx]));
                            MPSUtils.readPESHeader(this.pesBuf, 0);
                            NIOUtils.skip(this.pesBuf, (int) j);
                            this.seekToFrame = -1;
                            return;
                        }
                    }
                    j2 += (long) (MPSIndex.pesLen(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx]) + MPSIndex.leadingSize(MPSRandomAccessDemuxer.this.pesTokens[this.curPesIdx]));
                    this.curPesIdx++;
                }
            }
        }

        public long getCurFrame() {
            return (long) this.curFrame;
        }

        public void seek(double d) {
            throw new UnsupportedOperationException();
        }
    }

    public MPSRandomAccessDemuxer(SeekableByteChannel seekableByteChannel, MPSIndex mPSIndex) throws IOException {
        this.pesTokens = mPSIndex.getPesTokens();
        this.pesStreamIds = mPSIndex.getPesStreamIds().flattern();
        mPSIndex = mPSIndex.getStreams();
        this.streams = new Stream[mPSIndex.length];
        for (int i = 0; i < mPSIndex.length; i++) {
            this.streams[i] = newStream(seekableByteChannel, mPSIndex[i]);
        }
    }

    protected Stream newStream(SeekableByteChannel seekableByteChannel, MPSStreamIndex mPSStreamIndex) throws IOException {
        return new Stream(mPSStreamIndex, seekableByteChannel);
    }

    public Stream[] getStreams() {
        return this.streams;
    }
}
