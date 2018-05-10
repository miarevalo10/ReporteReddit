package org.jcodec.containers.mp4.demuxer;

import com.coremedia.iso.boxes.CompositionTimeToSample;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.SyncSampleBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.DemuxerTrackMeta.Type;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.QTTimeUtil;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox.Entry;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SyncSamplesBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class FramesMP4DemuxerTrack extends AbstractMP4DemuxerTrack {
    private Entry[] compOffsets;
    private int cttsInd;
    private int cttsSubInd;
    private SeekableByteChannel input;
    private MovieBox movie;
    private int noInChunk;
    private long offInChunk;
    private int[] partialSync;
    private int psOff;
    private int[] sizes;
    private int ssOff;
    private int[] syncSamples;

    public FramesMP4DemuxerTrack(MovieBox movieBox, TrakBox trakBox, SeekableByteChannel seekableByteChannel) {
        super(trakBox);
        this.input = seekableByteChannel;
        this.movie = movieBox;
        SampleSizesBox sampleSizesBox = (SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, new String[]{MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE});
        SyncSamplesBox syncSamplesBox = (SyncSamplesBox) Box.findFirst(trakBox, SyncSamplesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SyncSampleBox.TYPE);
        SyncSamplesBox syncSamplesBox2 = (SyncSamplesBox) Box.findFirst(trakBox, SyncSamplesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, "stps");
        CompositionOffsetsBox compositionOffsetsBox = (CompositionOffsetsBox) Box.findFirst(trakBox, CompositionOffsetsBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, CompositionTimeToSample.TYPE);
        if (compositionOffsetsBox == null) {
            trakBox = null;
        } else {
            trakBox = compositionOffsetsBox.getEntries();
        }
        this.compOffsets = trakBox;
        if (syncSamplesBox != null) {
            this.syncSamples = syncSamplesBox.getSyncSamples();
        }
        if (syncSamplesBox2 != null) {
            this.partialSync = syncSamplesBox2.getSyncSamples();
        }
        this.sizes = sampleSizesBox.getSizes();
    }

    public synchronized MP4Packet nextFrame() throws IOException {
        if (this.curFrame >= ((long) this.sizes.length)) {
            return null;
        }
        return nextFrame(ByteBuffer.allocate(this.sizes[(int) this.curFrame]));
    }

    public synchronized MP4Packet nextFrame(ByteBuffer byteBuffer) throws IOException {
        FramesMP4DemuxerTrack framesMP4DemuxerTrack = this;
        synchronized (this) {
            try {
                if (framesMP4DemuxerTrack.curFrame >= ((long) framesMP4DemuxerTrack.sizes.length)) {
                    return null;
                }
                int i = framesMP4DemuxerTrack.sizes[(int) framesMP4DemuxerTrack.curFrame];
                if (byteBuffer == null || byteBuffer.remaining() >= i) {
                    long j = framesMP4DemuxerTrack.chunkOffsets[framesMP4DemuxerTrack.stcoInd] + framesMP4DemuxerTrack.offInChunk;
                    ByteBuffer readPacketData = readPacketData(framesMP4DemuxerTrack.input, byteBuffer, j, i);
                    if (readPacketData == null || readPacketData.remaining() >= i) {
                        boolean z;
                        boolean z2;
                        int sampleDuration = framesMP4DemuxerTrack.timeToSamples[framesMP4DemuxerTrack.sttsInd].getSampleDuration();
                        boolean z3 = framesMP4DemuxerTrack.syncSamples == null;
                        if (framesMP4DemuxerTrack.syncSamples == null || framesMP4DemuxerTrack.ssOff >= framesMP4DemuxerTrack.syncSamples.length || framesMP4DemuxerTrack.curFrame + 1 != ((long) framesMP4DemuxerTrack.syncSamples[framesMP4DemuxerTrack.ssOff])) {
                            z = z3;
                        } else {
                            framesMP4DemuxerTrack.ssOff++;
                            z = true;
                        }
                        if (framesMP4DemuxerTrack.partialSync == null || framesMP4DemuxerTrack.psOff >= framesMP4DemuxerTrack.partialSync.length || framesMP4DemuxerTrack.curFrame + 1 != ((long) framesMP4DemuxerTrack.partialSync[framesMP4DemuxerTrack.psOff])) {
                            z2 = false;
                        } else {
                            framesMP4DemuxerTrack.psOff++;
                            z2 = true;
                        }
                        long j2 = framesMP4DemuxerTrack.pts;
                        if (framesMP4DemuxerTrack.compOffsets != null) {
                            j2 = framesMP4DemuxerTrack.pts + ((long) framesMP4DemuxerTrack.compOffsets[framesMP4DemuxerTrack.cttsInd].getOffset());
                            framesMP4DemuxerTrack.cttsSubInd++;
                            if (framesMP4DemuxerTrack.cttsInd < framesMP4DemuxerTrack.compOffsets.length - 1 && framesMP4DemuxerTrack.cttsSubInd == framesMP4DemuxerTrack.compOffsets[framesMP4DemuxerTrack.cttsInd].getCount()) {
                                framesMP4DemuxerTrack.cttsInd++;
                                framesMP4DemuxerTrack.cttsSubInd = 0;
                            }
                        }
                        long j3 = (long) framesMP4DemuxerTrack.timescale;
                        MP4Packet mP4Packet = r9;
                        int i2 = i;
                        MP4Packet mP4Packet2 = new MP4Packet(readPacketData, QTTimeUtil.mediaToEdited(framesMP4DemuxerTrack.box, j2, framesMP4DemuxerTrack.movie.getTimescale()), j3, (long) sampleDuration, framesMP4DemuxerTrack.curFrame, z, null, j2, framesMP4DemuxerTrack.sampleToChunks[framesMP4DemuxerTrack.stscInd].getEntry() - 1, j, i2, z2);
                        framesMP4DemuxerTrack.offInChunk += (long) i2;
                        framesMP4DemuxerTrack.curFrame++;
                        framesMP4DemuxerTrack.noInChunk++;
                        if (framesMP4DemuxerTrack.noInChunk >= framesMP4DemuxerTrack.sampleToChunks[framesMP4DemuxerTrack.stscInd].getCount()) {
                            framesMP4DemuxerTrack.noInChunk = 0;
                            framesMP4DemuxerTrack.offInChunk = 0;
                            nextChunk();
                        }
                        shiftPts(1);
                        return mP4Packet;
                    }
                    return null;
                }
                throw new IllegalArgumentException("Buffer size is not enough to fit a packet");
            } catch (Throwable th) {
                Throwable th2 = th;
            }
        }
    }

    public boolean gotoSyncFrame(long j) {
        if (this.syncSamples == null) {
            return gotoFrame(j);
        }
        if (j < 0) {
            throw new IllegalArgumentException("negative frame number");
        }
        int i = 0;
        if (j >= getFrameCount()) {
            return false;
        }
        if (j == this.curFrame) {
            return true;
        }
        while (i < this.syncSamples.length) {
            if (((long) (this.syncSamples[i] - 1)) > j) {
                return gotoFrame((long) (this.syncSamples[i - 1] - 1));
            }
            i++;
        }
        return gotoFrame((long) (this.syncSamples[this.syncSamples.length - 1] - 1));
    }

    protected void seekPointer(long j) {
        if (this.compOffsets != null) {
            this.cttsSubInd = (int) j;
            this.cttsInd = 0;
            while (this.cttsSubInd >= this.compOffsets[this.cttsInd].getCount()) {
                this.cttsSubInd -= this.compOffsets[this.cttsInd].getCount();
                this.cttsInd++;
            }
        }
        j = (int) j;
        this.curFrame = (long) j;
        this.stcoInd = 0;
        this.stscInd = 0;
        this.noInChunk = j;
        this.offInChunk = 0;
        while (this.noInChunk >= this.sampleToChunks[this.stscInd].getCount()) {
            this.noInChunk -= this.sampleToChunks[this.stscInd].getCount();
            nextChunk();
        }
        for (int i = 0; i < this.noInChunk; i++) {
            this.offInChunk += (long) this.sizes[(j - this.noInChunk) + i];
        }
        if (this.syncSamples != null) {
            this.ssOff = 0;
            while (this.ssOff < this.syncSamples.length && ((long) this.syncSamples[this.ssOff]) < this.curFrame + 1) {
                this.ssOff++;
            }
        }
        if (this.partialSync != null) {
            this.psOff = 0;
            while (this.psOff < this.partialSync.length && ((long) this.partialSync[this.psOff]) < this.curFrame + 1) {
                this.psOff++;
            }
        }
    }

    public long getFrameCount() {
        return (long) this.sizes.length;
    }

    public DemuxerTrackMeta getMeta() {
        int[] copyOf = Arrays.copyOf(this.syncSamples, this.syncSamples.length);
        for (int i = 0; i < copyOf.length; i++) {
            copyOf[i] = copyOf[i] - 1;
        }
        TrackType type = getType();
        Type type2 = type == TrackType.VIDEO ? Type.VIDEO : type == TrackType.SOUND ? Type.AUDIO : Type.OTHER;
        return new DemuxerTrackMeta(type2, copyOf, this.sizes.length, ((double) this.duration) / ((double) this.timescale), this.box.getCodedSize());
    }
}
