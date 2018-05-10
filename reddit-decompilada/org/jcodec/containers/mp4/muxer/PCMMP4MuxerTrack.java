package org.jcodec.containers.mp4.muxer;

import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.coremedia.iso.boxes.SampleTableBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Date;
import org.jcodec.common.Assert;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.Unit;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
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
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TrackHeaderBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class PCMMP4MuxerTrack extends AbstractMP4MuxerTrack {
    private LongArrayList chunkOffsets = new LongArrayList();
    private int frameDuration;
    private int frameSize;
    private int framesInCurChunk;
    private SeekableByteChannel out;
    private int totalFrames;

    public PCMMP4MuxerTrack(SeekableByteChannel seekableByteChannel, int i, TrackType trackType, int i2, int i3, int i4, SampleEntry sampleEntry) {
        super(i, trackType, i2);
        this.out = seekableByteChannel;
        this.frameDuration = i3;
        this.frameSize = i4;
        addSampleEntry(sampleEntry);
        setTgtChunkDuration(new Rational(1, 2), Unit.SEC);
    }

    public void addSamples(ByteBuffer byteBuffer) throws IOException {
        this.curChunk.add(byteBuffer);
        byteBuffer = byteBuffer.remaining() / this.frameSize;
        this.totalFrames += byteBuffer;
        this.framesInCurChunk += byteBuffer;
        this.chunkDuration += (long) (byteBuffer * this.frameDuration);
        outChunkIfNeeded();
    }

    private void outChunkIfNeeded() throws IOException {
        boolean z;
        if (this.tgtChunkDurationUnit != Unit.FRAME) {
            if (this.tgtChunkDurationUnit != Unit.SEC) {
                z = false;
                Assert.assertTrue(z);
                if (this.tgtChunkDurationUnit == Unit.FRAME || this.framesInCurChunk * this.tgtChunkDuration.getDen() != this.tgtChunkDuration.getNum()) {
                    if (this.tgtChunkDurationUnit == Unit.SEC && this.chunkDuration > 0 && this.chunkDuration * ((long) this.tgtChunkDuration.getDen()) >= ((long) (this.tgtChunkDuration.getNum() * this.timescale))) {
                        outChunk();
                    }
                }
                outChunk();
                return;
            }
        }
        z = true;
        Assert.assertTrue(z);
        if (this.tgtChunkDurationUnit == Unit.FRAME) {
        }
        outChunk();
    }

    private void outChunk() throws IOException {
        if (this.framesInCurChunk != 0) {
            this.chunkOffsets.add(this.out.position());
            for (ByteBuffer write : this.curChunk) {
                this.out.write(write);
            }
            this.curChunk.clear();
            if (this.samplesInLastChunk == -1 || this.framesInCurChunk != this.samplesInLastChunk) {
                this.samplesInChunks.add(new SampleToChunkEntry((long) (this.chunkNo + 1), this.framesInCurChunk, 1));
            }
            this.samplesInLastChunk = this.framesInCurChunk;
            this.chunkNo++;
            this.framesInCurChunk = 0;
            this.chunkDuration = 0;
        }
    }

    protected Box finish(MovieHeaderBox movieHeaderBox) throws IOException {
        if (this.finished) {
            throw new IllegalStateException("The muxer track has finished muxing");
        }
        outChunk();
        r0.finished = true;
        Box trakBox = new TrakBox();
        Size displayDimensions = getDisplayDimensions();
        Box box = r4;
        Box trackHeaderBox = new TrackHeaderBox(r0.trackId, ((((long) movieHeaderBox.getTimescale()) * ((long) r0.totalFrames)) * ((long) r0.frameDuration)) / ((long) r0.timescale), (float) displayDimensions.getWidth(), (float) displayDimensions.getHeight(), new Date().getTime(), new Date().getTime(), 1.0f, (short) 0, 0, new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, 1073741824});
        box.setFlags(15);
        trakBox.add(box);
        tapt(trakBox);
        box = new MediaBox();
        trakBox.add(box);
        box.add(new MediaHeaderBox(r0.timescale, (long) (r0.totalFrames * r0.frameDuration), 0, new Date().getTime(), new Date().getTime(), 0));
        box.add(new HandlerBox("mhlr", r0.type.getHandler(), "appl", 0, 0));
        Box mediaInfoBox = new MediaInfoBox();
        box.add(mediaInfoBox);
        mediaHeader(mediaInfoBox, r0.type);
        mediaInfoBox.add(new HandlerBox("dhlr", DataEntryUrlBox.TYPE, "appl", 0, 0));
        addDref(mediaInfoBox);
        box = new NodeBox(new Header(SampleTableBox.TYPE));
        mediaInfoBox.add(box);
        putEdits(trakBox);
        putName(trakBox);
        box.add(new SampleDescriptionBox((SampleEntry[]) r0.sampleEntries.toArray(new SampleEntry[0])));
        box.add(new SampleToChunkBox((SampleToChunkEntry[]) r0.samplesInChunks.toArray(new SampleToChunkEntry[0])));
        box.add(new SampleSizesBox(r0.frameSize, r0.totalFrames));
        box.add(new TimeToSampleBox(new TimeToSampleEntry[]{new TimeToSampleEntry(r0.totalFrames, r0.frameDuration)}));
        box.add(new ChunkOffsets64Box(r0.chunkOffsets.toArray()));
        return trakBox;
    }

    public long getTrackTotalDuration() {
        return (long) (this.totalFrames * this.frameDuration);
    }
}
