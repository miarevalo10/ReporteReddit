package org.jcodec.containers.mps.index;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mps.index.MPSIndex.MPSStreamIndex;
import org.jcodec.containers.mps.index.MPSRandomAccessDemuxer.Stream;
import org.jcodec.containers.mps.index.MTSIndex.MTSProgram;

public class MTSRandomAccessDemuxer {
    private SeekableByteChannel ch;
    private MTSProgram[] programs;

    public MTSRandomAccessDemuxer(SeekableByteChannel seekableByteChannel, MTSIndex mTSIndex) {
        this.programs = mTSIndex.getPrograms();
        this.ch = seekableByteChannel;
    }

    public int[] getGuids() {
        int[] iArr = new int[this.programs.length];
        for (int i = 0; i < this.programs.length; i++) {
            iArr[i] = this.programs[i].getTargetGuid();
        }
        return iArr;
    }

    public MPSRandomAccessDemuxer getProgramDemuxer(final int i) throws IOException {
        return new MPSRandomAccessDemuxer(this, this.ch, getProgram(i)) {
            final /* synthetic */ MTSRandomAccessDemuxer f33307b;

            protected Stream newStream(SeekableByteChannel seekableByteChannel, MPSStreamIndex mPSStreamIndex) throws IOException {
                return new Stream(this, mPSStreamIndex, seekableByteChannel) {
                    final /* synthetic */ C26521 f38979a;

                    protected ByteBuffer fetch(int i) throws IOException {
                        ByteBuffer allocate = ByteBuffer.allocate(i * 188);
                        for (int i2 = 0; i2 < i; i2++) {
                            ByteBuffer fetchFrom = NIOUtils.fetchFrom(this.source, 188);
                            Assert.assertEquals(71, fetchFrom.get() & 255);
                            if (((((fetchFrom.get() & 255) << 8) | (fetchFrom.get() & 255)) & 8191) == i) {
                                if (((fetchFrom.get() & 255) & 32) != 0) {
                                    NIOUtils.skip(fetchFrom, fetchFrom.get() & 255);
                                }
                                allocate.put(fetchFrom);
                            }
                        }
                        allocate.flip();
                        return allocate;
                    }

                    protected void skip(long j) throws IOException {
                        this.source.position(this.source.position() + (j * 188));
                    }

                    protected void reset() throws IOException {
                        this.source.position(0);
                    }
                };
            }
        };
    }

    private MPSIndex getProgram(int i) {
        for (MPSIndex mPSIndex : this.programs) {
            if (mPSIndex.getTargetGuid() == i) {
                return mPSIndex;
            }
        }
        return 0;
    }
}
