package org.jcodec.containers.mp4.muxer;

import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jcodec.common.Assert;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.Unit;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox;
import org.jcodec.containers.mp4.boxes.CompositionOffsetsBox.Entry;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.HandlerBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.MediaBox;
import org.jcodec.containers.mp4.boxes.MediaHeaderBox;
import org.jcodec.containers.mp4.boxes.MediaInfoBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleDescriptionBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.SyncSamplesBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class FramesMP4MuxerTrack extends AbstractMP4MuxerTrack {
    private boolean allIframes = true;
    private LongArrayList chunkOffsets = new LongArrayList();
    private List<Entry> compositionOffsets = new ArrayList();
    private long curDuration = -1;
    private int curFrame;
    private IntArrayList iframes = new IntArrayList();
    private int lastCompositionOffset = 0;
    private int lastCompositionSamples = 0;
    private int lastEntry = -1;
    private SeekableByteChannel out;
    private long ptsEstimate = 0;
    private long sameDurCount = 0;
    private List<TimeToSampleEntry> sampleDurations = new ArrayList();
    private IntArrayList sampleSizes = new IntArrayList();
    private TimecodeMP4MuxerTrack timecodeTrack;
    private long trackTotalDuration;

    public FramesMP4MuxerTrack(SeekableByteChannel seekableByteChannel, int i, TrackType trackType, int i2) {
        super(i, trackType, i2);
        this.out = seekableByteChannel;
        setTgtChunkDuration(new Rational(1, 1), Unit.FRAME);
    }

    public void addFrame(MP4Packet mP4Packet) throws IOException {
        if (this.finished) {
            throw new IllegalStateException("The muxer track has finished muxing");
        }
        int entryNo = mP4Packet.getEntryNo() + 1;
        int pts = (int) (mP4Packet.getPts() - this.ptsEstimate);
        if (pts != this.lastCompositionOffset) {
            if (this.lastCompositionSamples > 0) {
                this.compositionOffsets.add(new Entry(this.lastCompositionSamples, this.lastCompositionOffset));
            }
            this.lastCompositionOffset = pts;
            this.lastCompositionSamples = 0;
        }
        this.lastCompositionSamples++;
        this.ptsEstimate += mP4Packet.getDuration();
        if (!(this.lastEntry == -1 || this.lastEntry == entryNo)) {
            outChunk(this.lastEntry);
            this.samplesInLastChunk = -1;
        }
        this.curChunk.add(mP4Packet.getData());
        if (mP4Packet.isKeyFrame()) {
            this.iframes.add(this.curFrame + 1);
        } else {
            this.allIframes = false;
        }
        this.curFrame++;
        this.chunkDuration += mP4Packet.getDuration();
        if (!(this.curDuration == -1 || mP4Packet.getDuration() == this.curDuration)) {
            this.sampleDurations.add(new TimeToSampleEntry((int) this.sameDurCount, (int) this.curDuration));
            this.sameDurCount = 0;
        }
        this.curDuration = mP4Packet.getDuration();
        this.sameDurCount++;
        this.trackTotalDuration += mP4Packet.getDuration();
        outChunkIfNeeded(entryNo);
        processTimecode(mP4Packet);
        this.lastEntry = entryNo;
    }

    private void processTimecode(MP4Packet mP4Packet) throws IOException {
        if (this.timecodeTrack != null) {
            this.timecodeTrack.addTimecode(mP4Packet);
        }
    }

    private void outChunkIfNeeded(int i) throws IOException {
        boolean z;
        if (this.tgtChunkDurationUnit != Unit.FRAME) {
            if (this.tgtChunkDurationUnit != Unit.SEC) {
                z = false;
                Assert.assertTrue(z);
                if (this.tgtChunkDurationUnit == Unit.FRAME || this.curChunk.size() * this.tgtChunkDuration.getDen() != this.tgtChunkDuration.getNum()) {
                    if (this.tgtChunkDurationUnit == Unit.SEC && this.chunkDuration > 0 && this.chunkDuration * ((long) this.tgtChunkDuration.getDen()) >= ((long) (this.tgtChunkDuration.getNum() * this.timescale))) {
                        outChunk(i);
                    }
                }
                outChunk(i);
                return;
            }
        }
        z = true;
        Assert.assertTrue(z);
        if (this.tgtChunkDurationUnit == Unit.FRAME) {
        }
        outChunk(i);
    }

    void outChunk(int i) throws IOException {
        if (this.curChunk.size() != 0) {
            this.chunkOffsets.add(this.out.position());
            for (ByteBuffer byteBuffer : this.curChunk) {
                this.sampleSizes.add(byteBuffer.remaining());
                this.out.write(byteBuffer);
            }
            if (this.samplesInLastChunk == -1 || this.samplesInLastChunk != this.curChunk.size()) {
                this.samplesInChunks.add(new SampleToChunkEntry((long) (this.chunkNo + 1), this.curChunk.size(), i));
            }
            this.samplesInLastChunk = this.curChunk.size();
            this.chunkNo++;
            this.chunkDuration = 0;
            this.curChunk.clear();
        }
    }

    protected Box finish(MovieHeaderBox movieHeaderBox) throws IOException {
        if (this.finished) {
            throw new IllegalStateException("The muxer track has finished muxing");
        }
        outChunk(r0.lastEntry);
        if (r0.sameDurCount > 0) {
            r0.sampleDurations.add(new TimeToSampleEntry((int) r0.sameDurCount, (int) r0.curDuration));
        }
        r0.finished = true;
        Box trakBox = new TrakBox();
        Size displayDimensions = getDisplayDimensions();
        Box box = r3;
        Box trackHeaderBox = new TrackHeaderBox(r0.trackId, (((long) movieHeaderBox.getTimescale()) * r0.trackTotalDuration) / ((long) r0.timescale), (float) displayDimensions.getWidth(), (float) displayDimensions.getHeight(), new Date().getTime(), new Date().getTime(), 1.0f, (short) 0, 0, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824});
        trackHeaderBox = box;
        trackHeaderBox.setFlags(15);
        trakBox.add(trackHeaderBox);
        tapt(trakBox);
        Box mediaBox = new MediaBox();
        trakBox.add(mediaBox);
        mediaBox.add(new MediaHeaderBox(r0.timescale, r0.trackTotalDuration, 0, new Date().getTime(), new Date().getTime(), 0));
        mediaBox.add(new HandlerBox("mhlr", r0.type.getHandler(), "appl", 0, 0));
        trackHeaderBox = new MediaInfoBox();
        mediaBox.add(trackHeaderBox);
        mediaHeader(trackHeaderBox, r0.type);
        trackHeaderBox.add(new HandlerBox("dhlr", DataEntryUrlBox.TYPE, "appl", 0, 0));
        addDref(trackHeaderBox);
        mediaBox = new NodeBox(new Header(SampleTableBox.TYPE));
        trackHeaderBox.add(mediaBox);
        putCompositionOffsets(mediaBox);
        putEdits(trakBox);
        putName(trakBox);
        mediaBox.add(new SampleDescriptionBox((SampleEntry[]) r0.sampleEntries.toArray(new SampleEntry[0])));
        mediaBox.add(new SampleToChunkBox((SampleToChunkEntry[]) r0.samplesInChunks.toArray(new SampleToChunkEntry[0])));
        mediaBox.add(new SampleSizesBox(r0.sampleSizes.toArray()));
        mediaBox.add(new TimeToSampleBox((TimeToSampleEntry[]) r0.sampleDurations.toArray(new TimeToSampleEntry[0])));
        mediaBox.add(new ChunkOffsets64Box(r0.chunkOffsets.toArray()));
        if (!r0.allIframes && r0.iframes.size() > 0) {
            mediaBox.add(new SyncSamplesBox(r0.iframes.toArray()));
        }
        return trakBox;
    }

    private void putCompositionOffsets(NodeBox nodeBox) {
        if (this.compositionOffsets.size() > 0) {
            this.compositionOffsets.add(new Entry(this.lastCompositionSamples, this.lastCompositionOffset));
            int minOffset = minOffset(this.compositionOffsets);
            if (minOffset > 0) {
                for (Entry entry : this.compositionOffsets) {
                    entry.offset -= minOffset;
                }
            }
            Entry entry2 = (Entry) this.compositionOffsets.get(0);
            if (entry2.getOffset() > 0) {
                if (this.edits == null) {
                    this.edits = new ArrayList();
                    this.edits.add(new Edit(this.trackTotalDuration, (long) entry2.getOffset(), 1.0f));
                } else {
                    for (Edit edit : this.edits) {
                        edit.setMediaTime(edit.getMediaTime() + ((long) entry2.getOffset()));
                    }
                }
            }
            nodeBox.add(new CompositionOffsetsBox((Entry[]) this.compositionOffsets.toArray(new Entry[0])));
        }
    }

    public static int minOffset(List<Entry> list) {
        int i = RedditJobManager.f10810d;
        for (Entry entry : list) {
            if (entry.getOffset() < i) {
                i = entry.getOffset();
            }
        }
        return i;
    }

    public long getTrackTotalDuration() {
        return this.trackTotalDuration;
    }

    public void addSampleEntries(SampleEntry[] sampleEntryArr) {
        for (SampleEntry addSampleEntry : sampleEntryArr) {
            addSampleEntry(addSampleEntry);
        }
    }

    public TimecodeMP4MuxerTrack getTimecodeTrack() {
        return this.timecodeTrack;
    }

    public void setTimecode(TimecodeMP4MuxerTrack timecodeMP4MuxerTrack) {
        this.timecodeTrack = timecodeMP4MuxerTrack;
    }
}
