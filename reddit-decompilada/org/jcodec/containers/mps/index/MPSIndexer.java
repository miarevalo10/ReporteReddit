package org.jcodec.containers.mps.index;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.NIOUtils.FileReader;
import org.jcodec.common.NIOUtils.FileReaderListener;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mps.MPSDemuxer.PESPacket;
import org.jcodec.containers.mps.MPSUtils;

public class MPSIndexer extends BaseIndexer {
    private long predFileStart;

    class C26481 extends FileReader {
        final /* synthetic */ MPSIndexer f33304a;

        C26481(MPSIndexer mPSIndexer) {
            this.f33304a = mPSIndexer;
        }

        protected void data(ByteBuffer byteBuffer, long j) {
            this.f33304a.analyseBuffer(byteBuffer, j);
        }

        protected void done() {
            this.f33304a.finishAnalyse();
        }
    }

    static class C26492 implements FileReaderListener {
        C26492() {
        }

        public final void progress(int i) {
            System.out.println(i);
        }
    }

    public void index(File file, FileReaderListener fileReaderListener) throws IOException {
        newReader().readFile(file, 65536, fileReaderListener);
    }

    public void index(SeekableByteChannel seekableByteChannel, FileReaderListener fileReaderListener) throws IOException {
        newReader().readFile(seekableByteChannel, 65536, fileReaderListener);
    }

    private FileReader newReader() {
        return new C26481(this);
    }

    protected void pes(ByteBuffer byteBuffer, long j, int i, int i2) {
        if (MPSUtils.mediaStream(i2)) {
            PESPacket readPESHeader = MPSUtils.readPESHeader(byteBuffer, j);
            int i3 = 0;
            if (this.predFileStart != j) {
                i3 = 0 + ((int) (j - this.predFileStart));
            }
            long j2 = (long) i;
            this.predFileStart = j + j2;
            savePESMeta(i2, MPSIndex.makePESToken((long) i3, j2, (long) byteBuffer.remaining()));
            getAnalyser(i2).pkt(byteBuffer, readPESHeader);
        }
    }

    public static void main(String[] strArr) throws IOException {
        MPSIndexer mPSIndexer = new MPSIndexer();
        mPSIndexer.index(new File(strArr[0]), new C26492());
        ByteBuffer allocate = ByteBuffer.allocate(65536);
        mPSIndexer.serialize().serializeTo(allocate);
        NIOUtils.writeTo(allocate, new File(strArr[1]));
    }
}
