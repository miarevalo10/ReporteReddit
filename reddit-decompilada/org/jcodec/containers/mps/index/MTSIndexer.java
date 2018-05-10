package org.jcodec.containers.mps.index;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.Assert;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.NIOUtils.FileReader;
import org.jcodec.common.NIOUtils.FileReaderListener;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mps.MPSDemuxer.PESPacket;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.MTSUtils;
import org.jcodec.containers.mps.index.MTSIndex.MTSProgram;

public class MTSIndexer {
    public static final int BUFFER_SIZE = 96256;
    private MTSAnalyser[] indexers;

    class C26501 extends FileReader {
        final /* synthetic */ MTSIndexer f33305a;

        C26501(MTSIndexer mTSIndexer) {
            this.f33305a = mTSIndexer;
        }

        protected void done() {
            for (MTSAnalyser finishAnalyse : this.f33305a.indexers) {
                finishAnalyse.finishAnalyse();
            }
        }

        protected void data(ByteBuffer byteBuffer, long j) {
            while (byteBuffer.hasRemaining()) {
                ByteBuffer read = NIOUtils.read(byteBuffer, 188);
                j += 188;
                Assert.assertEquals(71, read.get() & 255);
                int i = (((read.get() & 255) << 8) | (read.get() & 255)) & 8191;
                for (int i2 = 0; i2 < this.f33305a.indexers.length; i2++) {
                    if (i == this.f33305a.indexers[i2].f36210b) {
                        if (((read.get() & 255) & 32) != 0) {
                            NIOUtils.skip(read, read.get() & 255);
                        }
                        this.f33305a.indexers[i2].analyseBuffer(read, j - ((long) read.remaining()));
                    }
                }
            }
        }
    }

    static class C26512 implements FileReaderListener {
        C26512() {
        }

        public final void progress(int i) {
            System.out.println(i);
        }
    }

    private class MTSAnalyser extends BaseIndexer {
        final /* synthetic */ MTSIndexer f36209a;
        private int f36210b;
        private long f36211c;

        public MTSAnalyser(MTSIndexer mTSIndexer, int i) {
            this.f36209a = mTSIndexer;
            this.f36210b = i;
        }

        public final MTSProgram m36590a() {
            return new MTSProgram(super.serialize(), this.f36210b);
        }

        protected void pes(ByteBuffer byteBuffer, long j, int i, int i2) {
            if (MPSUtils.mediaStream(i2)) {
                r1 = new Object[2];
                int i3 = 0;
                r1[0] = Long.valueOf(j);
                r1[1] = Integer.valueOf(i);
                Logger.debug(String.format("PES: %08x, %d", r1));
                PESPacket readPESHeader = MPSUtils.readPESHeader(byteBuffer, j);
                if (this.f36211c != j) {
                    i3 = (int) ((j / 188) - this.f36211c);
                }
                this.f36211c = (((long) i) + j) / 188;
                savePESMeta(i2, MPSIndex.makePESToken((long) i3, (long) ((int) (this.f36211c - (j / 188))), (long) byteBuffer.remaining()));
                getAnalyser(i2).pkt(byteBuffer, readPESHeader);
            }
        }
    }

    public void index(File file, FileReaderListener fileReaderListener) throws IOException {
        index(fileReaderListener, MTSUtils.getMediaPids(file)).readFile(file, 96256, fileReaderListener);
    }

    public void index(SeekableByteChannel seekableByteChannel, FileReaderListener fileReaderListener) throws IOException {
        index(fileReaderListener, MTSUtils.getMediaPids(seekableByteChannel)).readFile(seekableByteChannel, 96256, fileReaderListener);
    }

    public FileReader index(FileReaderListener fileReaderListener, int[] iArr) throws IOException {
        this.indexers = new MTSAnalyser[iArr.length];
        for (fileReaderListener = null; fileReaderListener < iArr.length; fileReaderListener++) {
            this.indexers[fileReaderListener] = new MTSAnalyser(this, iArr[fileReaderListener]);
        }
        return new C26501(this);
    }

    public MTSIndex serialize() {
        MTSProgram[] mTSProgramArr = new MTSProgram[this.indexers.length];
        for (int i = 0; i < this.indexers.length; i++) {
            mTSProgramArr[i] = this.indexers[i].m36590a();
        }
        return new MTSIndex(mTSProgramArr);
    }

    public static void main(String[] strArr) throws IOException {
        File file = new File(strArr[0]);
        MTSIndexer mTSIndexer = new MTSIndexer();
        mTSIndexer.index(file, new C26512());
        NIOUtils.writeTo(mTSIndexer.serialize().serialize(), new File(strArr[1]));
    }
}
