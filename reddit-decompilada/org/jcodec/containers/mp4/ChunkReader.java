package org.jcodec.containers.mp4;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import java.util.Arrays;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.SampleDescriptionBox;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class ChunkReader {
    private long[] chunkOffsets;
    private long chunkTv = 0;
    private int curChunk;
    private int s2cIndex;
    private int sampleNo;
    private SampleToChunkEntry[] sampleToChunk;
    private SampleDescriptionBox stsd;
    private SampleSizesBox stsz;
    private TimeToSampleEntry[] tts;
    private int ttsInd = 0;
    private int ttsSubInd = 0;

    public ChunkReader(TrakBox trakBox) {
        this.tts = ((TimeToSampleBox) Box.findFirst(trakBox, TimeToSampleBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.TimeToSampleBox.TYPE)).getEntries();
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) Box.findFirst(trakBox, ChunkOffsetsBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, StaticChunkOffsetBox.TYPE);
        ChunkOffsets64Box chunkOffsets64Box = (ChunkOffsets64Box) Box.findFirst(trakBox, ChunkOffsets64Box.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, ChunkOffset64BitBox.TYPE);
        this.stsz = (SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE);
        SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) Box.findFirst(trakBox, SampleToChunkBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.SampleToChunkBox.TYPE);
        if (chunkOffsetsBox != null) {
            this.chunkOffsets = chunkOffsetsBox.getChunkOffsets();
        } else {
            this.chunkOffsets = chunkOffsets64Box.getChunkOffsets();
        }
        this.sampleToChunk = sampleToChunkBox.getSampleToChunk();
        this.stsd = (SampleDescriptionBox) Box.findFirst(trakBox, SampleDescriptionBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, com.coremedia.iso.boxes.SampleDescriptionBox.TYPE);
    }

    public boolean hasNext() {
        return this.curChunk < this.chunkOffsets.length;
    }

    public Chunk next() {
        if (this.curChunk >= this.chunkOffsets.length) {
            return null;
        }
        int i;
        int[] iArr;
        int frameSize;
        int[] iArr2;
        if (this.s2cIndex + 1 < this.sampleToChunk.length && ((long) (this.curChunk + 1)) == this.sampleToChunk[this.s2cIndex + 1].getFirst()) {
            this.s2cIndex++;
        }
        int count = this.sampleToChunk[this.s2cIndex].getCount();
        if (this.ttsSubInd + count <= this.tts[this.ttsInd].getSampleCount()) {
            int sampleDuration = this.tts[this.ttsInd].getSampleDuration();
            this.ttsSubInd += count;
            i = sampleDuration;
            iArr = null;
        } else {
            int[] iArr3 = new int[count];
            for (int i2 = 0; i2 < count; i2++) {
                if (this.ttsSubInd >= this.tts[this.ttsInd].getSampleCount() && this.ttsInd < this.tts.length - 1) {
                    this.ttsSubInd = 0;
                    this.ttsInd++;
                }
                iArr3[i2] = this.tts[this.ttsInd].getSampleDuration();
                this.ttsSubInd++;
            }
            iArr = iArr3;
            i = 0;
        }
        if (this.stsz.getDefaultSize() > 0) {
            frameSize = getFrameSize();
            iArr2 = null;
        } else {
            iArr2 = Arrays.copyOfRange(this.stsz.getSizes(), this.sampleNo, this.sampleNo + count);
            frameSize = 0;
        }
        Chunk chunk = new Chunk(this.chunkOffsets[this.curChunk], this.chunkTv, count, frameSize, iArr2, i, iArr, this.sampleToChunk[this.s2cIndex].getEntry());
        this.chunkTv += (long) chunk.getDuration();
        this.sampleNo += count;
        this.curChunk++;
        return chunk;
    }

    private int getFrameSize() {
        Box box = (Box) this.stsd.getBoxes().get(this.sampleToChunk[this.s2cIndex].getEntry() - 1);
        return box instanceof AudioSampleEntry ? ((AudioSampleEntry) box).calcFrameSize() : this.stsz.getDefaultSize();
    }

    public int size() {
        return this.chunkOffsets.length;
    }
}
