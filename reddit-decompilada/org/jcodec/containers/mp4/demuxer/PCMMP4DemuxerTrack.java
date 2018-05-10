package org.jcodec.containers.mp4.demuxer;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.DemuxerTrackMeta.Type;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Packet;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class PCMMP4DemuxerTrack extends AbstractMP4DemuxerTrack {
    private int defaultSampleSize;
    private SeekableByteChannel input;
    private MovieBox movie;
    private int posShift;
    protected int totalFrames;

    public PCMMP4DemuxerTrack(MovieBox movieBox, TrakBox trakBox, SeekableByteChannel seekableByteChannel) {
        super(trakBox);
        this.movie = movieBox;
        this.input = seekableByteChannel;
        this.defaultSampleSize = ((SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, new String[]{MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE})).getDefaultSize();
        seekableByteChannel = null;
        for (trakBox = 1; trakBox < this.sampleToChunks.length; trakBox++) {
            int i = trakBox - 1;
            int first = (int) (this.sampleToChunks[trakBox].getFirst() - this.sampleToChunks[i].getFirst());
            this.totalFrames += this.sampleToChunks[i].getCount() * first;
            seekableByteChannel += first;
        }
        this.totalFrames += this.sampleToChunks[this.sampleToChunks.length - 1].getCount() * (this.chunkOffsets.length - seekableByteChannel);
    }

    public Packet nextFrame() throws IOException {
        return nextFrame(ByteBuffer.allocate((this.sampleToChunks[this.stscInd].getCount() * getFrameSize()) - this.posShift));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.jcodec.containers.mp4.MP4Packet nextFrame(java.nio.ByteBuffer r34) throws java.io.IOException {
        /*
        r33 = this;
        r7 = r33;
        monitor-enter(r33);
        r1 = r7.stcoInd;	 Catch:{ all -> 0x00ad }
        r2 = r7.chunkOffsets;	 Catch:{ all -> 0x00ad }
        r2 = r2.length;	 Catch:{ all -> 0x00ad }
        if (r1 < r2) goto L_0x000d;
    L_0x000a:
        r1 = 0;
        monitor-exit(r33);
        return r1;
    L_0x000d:
        r8 = r33.getFrameSize();	 Catch:{ all -> 0x00ad }
        r1 = r7.sampleToChunks;	 Catch:{ all -> 0x00ad }
        r2 = r7.stscInd;	 Catch:{ all -> 0x00ad }
        r1 = r1[r2];	 Catch:{ all -> 0x00ad }
        r9 = r1.getEntry();	 Catch:{ all -> 0x00ad }
        r1 = r7.sampleToChunks;	 Catch:{ all -> 0x00ad }
        r2 = r7.stscInd;	 Catch:{ all -> 0x00ad }
        r1 = r1[r2];	 Catch:{ all -> 0x00ad }
        r1 = r1.getCount();	 Catch:{ all -> 0x00ad }
        r1 = r1 * r8;
        r2 = r7.chunkOffsets;	 Catch:{ all -> 0x00ad }
        r3 = r7.stcoInd;	 Catch:{ all -> 0x00ad }
        r3 = r2[r3];	 Catch:{ all -> 0x00ad }
        r2 = r7.posShift;	 Catch:{ all -> 0x00ad }
        r5 = (long) r2;	 Catch:{ all -> 0x00ad }
        r25 = r3 + r5;
        r2 = r7.posShift;	 Catch:{ all -> 0x00ad }
        r27 = r1 - r2;
        r2 = r7.input;	 Catch:{ all -> 0x00ad }
        r1 = r7;
        r3 = r34;
        r4 = r25;
        r6 = r27;
        r11 = r1.readPacketData(r2, r3, r4, r6);	 Catch:{ all -> 0x00ad }
        r1 = r7.pts;	 Catch:{ all -> 0x00ad }
        r3 = r27 / r8;
        r3 = (long) r3;	 Catch:{ all -> 0x00ad }
        r7.shiftPts(r3);	 Catch:{ all -> 0x00ad }
        r5 = new org.jcodec.containers.mp4.MP4Packet;	 Catch:{ all -> 0x00ad }
        r6 = r7.box;	 Catch:{ all -> 0x00ad }
        r8 = r7.movie;	 Catch:{ all -> 0x00ad }
        r8 = r8.getTimescale();	 Catch:{ all -> 0x00ad }
        r12 = org.jcodec.containers.mp4.QTTimeUtil.mediaToEdited(r6, r1, r8);	 Catch:{ all -> 0x00ad }
        r6 = r7.timescale;	 Catch:{ all -> 0x00ad }
        r14 = (long) r6;	 Catch:{ all -> 0x00ad }
        r29 = r3;
        r3 = r7.pts;	 Catch:{ all -> 0x00ad }
        r3 = r3 - r1;
        r3 = (int) r3;	 Catch:{ all -> 0x00ad }
        r3 = (long) r3;	 Catch:{ all -> 0x00ad }
        r31 = r1;
        r1 = r7.curFrame;	 Catch:{ all -> 0x00ad }
        r20 = 1;
        r21 = 0;
        r24 = r9 + -1;
        r28 = 1;
        r10 = r5;
        r16 = r3;
        r18 = r1;
        r22 = r31;
        r10.<init>(r11, r12, r14, r16, r18, r20, r21, r22, r24, r25, r27, r28);	 Catch:{ all -> 0x00ad }
        r1 = r7.curFrame;	 Catch:{ all -> 0x00ad }
        r1 = r1 + r29;
        r7.curFrame = r1;	 Catch:{ all -> 0x00ad }
        r1 = 0;
        r7.posShift = r1;	 Catch:{ all -> 0x00ad }
        r1 = r7.stcoInd;	 Catch:{ all -> 0x00ad }
        r1 = r1 + 1;
        r7.stcoInd = r1;	 Catch:{ all -> 0x00ad }
        r1 = r7.stscInd;	 Catch:{ all -> 0x00ad }
        r2 = r7.sampleToChunks;	 Catch:{ all -> 0x00ad }
        r2 = r2.length;	 Catch:{ all -> 0x00ad }
        r2 = r2 + -1;
        if (r1 >= r2) goto L_0x00ab;
    L_0x0090:
        r1 = r7.stcoInd;	 Catch:{ all -> 0x00ad }
        r1 = r1 + 1;
        r1 = (long) r1;	 Catch:{ all -> 0x00ad }
        r3 = r7.sampleToChunks;	 Catch:{ all -> 0x00ad }
        r4 = r7.stscInd;	 Catch:{ all -> 0x00ad }
        r4 = r4 + 1;
        r3 = r3[r4];	 Catch:{ all -> 0x00ad }
        r3 = r3.getFirst();	 Catch:{ all -> 0x00ad }
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 != 0) goto L_0x00ab;
    L_0x00a5:
        r1 = r7.stscInd;	 Catch:{ all -> 0x00ad }
        r1 = r1 + 1;
        r7.stscInd = r1;	 Catch:{ all -> 0x00ad }
    L_0x00ab:
        monitor-exit(r33);
        return r5;
    L_0x00ad:
        r0 = move-exception;
        r1 = r0;
        monitor-exit(r33);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.containers.mp4.demuxer.PCMMP4DemuxerTrack.nextFrame(java.nio.ByteBuffer):org.jcodec.containers.mp4.MP4Packet");
    }

    public boolean gotoSyncFrame(long j) {
        return gotoFrame(j);
    }

    public int getFrameSize() {
        SampleEntry sampleEntry = this.sampleEntries[this.sampleToChunks[this.stscInd].getEntry() - 1];
        if (sampleEntry instanceof AudioSampleEntry) {
            return ((AudioSampleEntry) sampleEntry).calcFrameSize();
        }
        return this.defaultSampleSize;
    }

    protected void seekPointer(long j) {
        this.stcoInd = 0;
        this.stscInd = 0;
        this.curFrame = 0;
        while (true) {
            long count = this.curFrame + ((long) this.sampleToChunks[this.stscInd].getCount());
            if (count <= j) {
                this.curFrame = count;
                nextChunk();
            } else {
                this.posShift = (int) ((j - this.curFrame) * ((long) getFrameSize()));
                this.curFrame = j;
                return;
            }
        }
    }

    public long getFrameCount() {
        return (long) this.totalFrames;
    }

    public DemuxerTrackMeta getMeta() {
        return new DemuxerTrackMeta(Type.AUDIO, null, this.totalFrames, ((double) this.duration) / ((double) this.timescale), null);
    }
}
