package org.jcodec.containers.mp4.demuxer;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.coremedia.iso.boxes.UserDataBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.model.RationalLarge;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.EditListBox;
import org.jcodec.containers.mp4.boxes.NameBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

public abstract class AbstractMP4DemuxerTrack implements SeekableDemuxerTrack {
    protected TrakBox box;
    protected long[] chunkOffsets;
    protected long curFrame;
    protected long duration;
    private int no;
    protected long pts;
    protected SampleEntry[] sampleEntries;
    protected SampleToChunkEntry[] sampleToChunks;
    protected int stcoInd;
    protected int stscInd;
    protected int sttsInd;
    protected int sttsSubInd;
    protected TimeToSampleEntry[] timeToSamples;
    protected int timescale;
    private TrackType type;

    public abstract long getFrameCount();

    public abstract MP4Packet nextFrame(ByteBuffer byteBuffer) throws IOException;

    protected abstract void seekPointer(long j);

    public AbstractMP4DemuxerTrack(TrakBox trakBox) {
        this.no = trakBox.getTrackHeader().getNo();
        this.type = MP4Demuxer.getTrackType(trakBox);
        this.sampleEntries = (SampleEntry[]) Box.findAll(trakBox, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null);
        NodeBox stbl = trakBox.getMdia().getMinf().getStbl();
        TimeToSampleBox timeToSampleBox = (TimeToSampleBox) Box.findFirst(stbl, TimeToSampleBox.class, com.coremedia.iso.boxes.TimeToSampleBox.TYPE);
        SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) Box.findFirst(stbl, SampleToChunkBox.class, com.coremedia.iso.boxes.SampleToChunkBox.TYPE);
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) Box.findFirst(stbl, ChunkOffsetsBox.class, StaticChunkOffsetBox.TYPE);
        ChunkOffsets64Box chunkOffsets64Box = (ChunkOffsets64Box) Box.findFirst(stbl, ChunkOffsets64Box.class, ChunkOffset64BitBox.TYPE);
        this.timeToSamples = timeToSampleBox.getEntries();
        this.sampleToChunks = sampleToChunkBox.getSampleToChunk();
        this.chunkOffsets = chunkOffsetsBox != null ? chunkOffsetsBox.getChunkOffsets() : chunkOffsets64Box.getChunkOffsets();
        for (TimeToSampleEntry timeToSampleEntry : this.timeToSamples) {
            this.duration += (long) (timeToSampleEntry.getSampleCount() * timeToSampleEntry.getSampleDuration());
        }
        this.box = trakBox;
        this.timescale = trakBox.getTimescale();
    }

    public int pts2Sample(long j, int i) {
        j = (j * ((long) this.timescale)) / ((long) i);
        i = 0;
        int i2 = 0;
        while (i < this.timeToSamples.length - 1) {
            long sampleCount = (long) (this.timeToSamples[i].getSampleCount() * this.timeToSamples[i].getSampleDuration());
            if (j < sampleCount) {
                break;
            }
            j -= sampleCount;
            i2 += this.timeToSamples[i].getSampleCount();
            i++;
        }
        return i2 + ((int) (j / ((long) this.timeToSamples[i].getSampleDuration())));
    }

    public TrackType getType() {
        return this.type;
    }

    public int getNo() {
        return this.no;
    }

    public SampleEntry[] getSampleEntries() {
        return this.sampleEntries;
    }

    public TrakBox getBox() {
        return this.box;
    }

    public long getTimescale() {
        return (long) this.timescale;
    }

    public boolean canSeek(long j) {
        return (j < 0 || j >= this.duration) ? 0 : 1;
    }

    public synchronized boolean seek(long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("Seeking to negative pts");
        }
        int i = 0;
        if (j >= this.duration) {
            return false;
        }
        this.sttsInd = 0;
        while (j > ((long) (this.timeToSamples[this.sttsInd].getSampleCount() * this.timeToSamples[this.sttsInd].getSampleDuration())) + j2 && this.sttsInd < this.timeToSamples.length - 1) {
            j2 += (long) (this.timeToSamples[this.sttsInd].getSampleCount() * this.timeToSamples[this.sttsInd].getSampleDuration());
            i += this.timeToSamples[this.sttsInd].getSampleCount();
            this.sttsInd++;
        }
        this.sttsSubInd = (int) ((j - j2) / ((long) this.timeToSamples[this.sttsInd].getSampleDuration()));
        i += this.sttsSubInd;
        this.pts = j2 + ((long) (this.timeToSamples[this.sttsInd].getSampleDuration() * this.sttsSubInd));
        seekPointer((long) i);
        return true;
    }

    protected void shiftPts(long j) {
        this.pts -= (long) (this.sttsSubInd * this.timeToSamples[this.sttsInd].getSampleDuration());
        this.sttsSubInd = (int) (((long) this.sttsSubInd) + j);
        while (this.sttsInd < this.timeToSamples.length - 1 && this.sttsSubInd >= this.timeToSamples[this.sttsInd].getSampleCount()) {
            this.pts += this.timeToSamples[this.sttsInd].getSegmentDuration();
            this.sttsSubInd -= this.timeToSamples[this.sttsInd].getSampleCount();
            this.sttsInd++;
        }
        this.pts += (long) (this.sttsSubInd * this.timeToSamples[this.sttsInd].getSampleDuration());
    }

    protected void nextChunk() {
        if (this.stcoInd < this.chunkOffsets.length) {
            this.stcoInd++;
            if (this.stscInd + 1 < this.sampleToChunks.length && ((long) (this.stcoInd + 1)) == this.sampleToChunks[this.stscInd + 1].getFirst()) {
                this.stscInd++;
            }
        }
    }

    public synchronized boolean gotoFrame(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("negative frame number");
        } else if (j >= getFrameCount()) {
            return 0;
        } else {
            if (j == this.curFrame) {
                return true;
            }
            seekPointer(j);
            seekPts(j);
            return true;
        }
    }

    public void seek(double d) {
        seek((long) (d * ((double) this.timescale)));
    }

    private void seekPts(long j) {
        this.sttsSubInd = 0;
        this.sttsInd = 0;
        this.pts = 0;
        shiftPts(j);
    }

    public RationalLarge getDuration() {
        return new RationalLarge(this.box.getMediaDuration(), (long) this.box.getTimescale());
    }

    public long getCurFrame() {
        return this.curFrame;
    }

    public List<Edit> getEdits() {
        EditListBox editListBox = (EditListBox) Box.findFirst(this.box, EditListBox.class, EditBox.TYPE, com.coremedia.iso.boxes.EditListBox.TYPE);
        return editListBox != null ? editListBox.getEdits() : null;
    }

    public String getName() {
        NameBox nameBox = (NameBox) Box.findFirst(this.box, NameBox.class, UserDataBox.TYPE, "name");
        return nameBox != null ? nameBox.getName() : null;
    }

    public String getFourcc() {
        return getSampleEntries()[0].getFourcc();
    }

    protected ByteBuffer readPacketData(SeekableByteChannel seekableByteChannel, ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer = byteBuffer.duplicate();
        synchronized (seekableByteChannel) {
            seekableByteChannel.position(j);
            NIOUtils.read(seekableByteChannel, byteBuffer, i);
        }
        byteBuffer.flip();
        return byteBuffer;
    }
}
