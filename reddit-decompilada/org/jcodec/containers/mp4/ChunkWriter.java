package org.jcodec.containers.mp4;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.boxes.AliasBox;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.DataInfoBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.MediaInfoBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class ChunkWriter {
    byte[] buf = new byte[8092];
    private int curChunk;
    private SampleEntry[] entries;
    private SeekableByteChannel[] inputs;
    private long[] offsets;
    private SeekableByteChannel out;
    private TrakBox trak;

    public ChunkWriter(TrakBox trakBox, SeekableByteChannel[] seekableByteChannelArr, SeekableByteChannel seekableByteChannel) {
        int length;
        this.entries = (SampleEntry[]) Box.findAll(trakBox, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null);
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) Box.findFirst(trakBox, ChunkOffsetsBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, StaticChunkOffsetBox.TYPE);
        ChunkOffsets64Box chunkOffsets64Box = (ChunkOffsets64Box) Box.findFirst(trakBox, ChunkOffsets64Box.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, ChunkOffset64BitBox.TYPE);
        if (chunkOffsetsBox != null) {
            length = chunkOffsetsBox.getChunkOffsets().length;
        } else {
            length = chunkOffsets64Box.getChunkOffsets().length;
        }
        this.inputs = seekableByteChannelArr;
        this.offsets = new long[length];
        this.out = seekableByteChannel;
        this.trak = trakBox;
    }

    public void apply() {
        NodeBox nodeBox = (NodeBox) Box.findFirst(this.trak, NodeBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE);
        nodeBox.removeChildren(StaticChunkOffsetBox.TYPE, ChunkOffset64BitBox.TYPE);
        nodeBox.add(new ChunkOffsets64Box(this.offsets));
        cleanDrefs(this.trak);
    }

    private void cleanDrefs(TrakBox trakBox) {
        MediaInfoBox minf = trakBox.getMdia().getMinf();
        DataInfoBox dinf = trakBox.getMdia().getMinf().getDinf();
        if (dinf == null) {
            dinf = new DataInfoBox();
            minf.add(dinf);
        }
        DataRefBox dref = dinf.getDref();
        if (dref == null) {
            dref = new DataRefBox();
            dinf.add(dref);
        }
        dref.getBoxes().clear();
        dref.add(AliasBox.createSelfRef());
        for (SampleEntry drefInd : (SampleEntry[]) Box.findAll(trakBox, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null)) {
            drefInd.setDrefInd((short) 1);
        }
    }

    private SeekableByteChannel getInput(Chunk chunk) {
        return this.inputs[this.entries[chunk.getEntry() - 1].getDrefInd() - 1];
    }

    public void write(Chunk chunk) throws IOException {
        ReadableByteChannel input = getInput(chunk);
        input.position(chunk.getOffset());
        long position = this.out.position();
        this.out.write(NIOUtils.fetchFrom(input, (int) chunk.getSize()));
        chunk = this.offsets;
        int i = this.curChunk;
        this.curChunk = i + 1;
        chunk[i] = position;
    }
}
