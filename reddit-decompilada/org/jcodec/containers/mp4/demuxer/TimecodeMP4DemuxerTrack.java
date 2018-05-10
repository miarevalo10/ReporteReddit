package org.jcodec.containers.mp4.demuxer;

import com.coremedia.iso.boxes.ChunkOffset64BitBox;
import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.regex.Pattern;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.TapeTimecode;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.QTTimeUtil;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsets64Box;
import org.jcodec.containers.mp4.boxes.ChunkOffsetsBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox;
import org.jcodec.containers.mp4.boxes.TimeToSampleBox.TimeToSampleEntry;
import org.jcodec.containers.mp4.boxes.TimecodeSampleEntry;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class TimecodeMP4DemuxerTrack {
    private TrakBox box;
    private long[] chunkOffsets;
    private SeekableByteChannel input;
    private MovieBox movie;
    private int[] sampleCache;
    private SampleToChunkEntry[] sampleToChunks;
    private TimeToSampleEntry[] timeToSamples;
    private TimecodeSampleEntry tse;

    public TimecodeMP4DemuxerTrack(MovieBox movieBox, TrakBox trakBox, SeekableByteChannel seekableByteChannel) throws IOException {
        this.box = trakBox;
        this.input = seekableByteChannel;
        this.movie = movieBox;
        movieBox = trakBox.getMdia().getMinf().getStbl();
        TimeToSampleBox timeToSampleBox = (TimeToSampleBox) Box.findFirst(movieBox, TimeToSampleBox.class, new String[]{com.coremedia.iso.boxes.TimeToSampleBox.TYPE});
        SampleToChunkBox sampleToChunkBox = (SampleToChunkBox) Box.findFirst(movieBox, SampleToChunkBox.class, com.coremedia.iso.boxes.SampleToChunkBox.TYPE);
        ChunkOffsetsBox chunkOffsetsBox = (ChunkOffsetsBox) Box.findFirst(movieBox, ChunkOffsetsBox.class, StaticChunkOffsetBox.TYPE);
        ChunkOffsets64Box chunkOffsets64Box = (ChunkOffsets64Box) Box.findFirst(movieBox, ChunkOffsets64Box.class, ChunkOffset64BitBox.TYPE);
        this.timeToSamples = timeToSampleBox.getEntries();
        this.chunkOffsets = chunkOffsetsBox != null ? chunkOffsetsBox.getChunkOffsets() : chunkOffsets64Box.getChunkOffsets();
        this.sampleToChunks = sampleToChunkBox.getSampleToChunk();
        if (this.chunkOffsets.length == 1) {
            cacheSamples(this.sampleToChunks, this.chunkOffsets);
        }
        this.tse = (TimecodeSampleEntry) this.box.getSampleEntries()[null];
    }

    public MP4Packet getTimecode(MP4Packet mP4Packet) throws IOException {
        int i = 0;
        long editedToMedia = QTTimeUtil.editedToMedia(this.box, this.box.rescale(mP4Packet.getPts(), mP4Packet.getTimescale()), this.movie.getTimescale());
        int i2 = 0;
        int i3 = i2;
        while (i < this.sampleCache.length - 1) {
            long sampleDuration = (long) this.timeToSamples[i2].getSampleDuration();
            if (editedToMedia < sampleDuration) {
                break;
            }
            editedToMedia -= sampleDuration;
            i3++;
            if (i2 < this.timeToSamples.length - 1 && i3 >= this.timeToSamples[i2].getSampleCount()) {
                i2++;
            }
            i++;
        }
        return new MP4Packet(mP4Packet, getTimecode(getTimecodeSample(i), ((int) (((((2 * editedToMedia) * ((long) this.tse.getTimescale())) / ((long) this.box.getTimescale())) / ((long) this.tse.getFrameDuration())) + 1)) / 2, this.tse));
    }

    private int getTimecodeSample(int i) throws IOException {
        if (this.sampleCache != null) {
            return this.sampleCache[i];
        }
        synchronized (this.input) {
            int i2 = 0;
            while (i2 < this.sampleToChunks.length && i >= this.sampleToChunks[i2].getCount()) {
                i -= this.sampleToChunks[i2].getCount();
                i2++;
            }
            long min = this.chunkOffsets[i2] + ((long) (Math.min(i, this.sampleToChunks[i2].getCount() - 1) << 2));
            if (this.input.position() != min) {
                this.input.position(min);
            }
            i = NIOUtils.fetchFrom(this.input, 4).getInt();
        }
        return i;
    }

    private TapeTimecode getTimecode(int i, int i2, TimecodeSampleEntry timecodeSampleEntry) {
        i = dropFrameAdjust(i2 + i, timecodeSampleEntry);
        i2 = i / timecodeSampleEntry.getNumFrames();
        return new TapeTimecode((short) (i2 / 3600), (byte) ((i2 / 60) % 60), (byte) (i2 % 60), (byte) (i % timecodeSampleEntry.getNumFrames()), timecodeSampleEntry.isDropFrame());
    }

    private int dropFrameAdjust(int i, TimecodeSampleEntry timecodeSampleEntry) {
        if (timecodeSampleEntry.isDropFrame() == null) {
            return i;
        }
        return (int) (((long) i) + ((18 * ((long) (i / 17982))) + (2 * ((((long) (i % 17982)) - 2) / 1798))));
    }

    private void cacheSamples(SampleToChunkEntry[] sampleToChunkEntryArr, long[] jArr) throws IOException {
        synchronized (this.input) {
            IntArrayList intArrayList = new IntArrayList();
            int i = 0;
            int i2 = i;
            while (i < jArr.length) {
                int count = sampleToChunkEntryArr[i2].getCount();
                if (i2 < sampleToChunkEntryArr.length - 1) {
                    int i3 = i2 + 1;
                    if (((long) (i + 1)) >= sampleToChunkEntryArr[i3].getFirst()) {
                        i2 = i3;
                    }
                }
                this.input.position(jArr[i]);
                ByteBuffer fetchFrom = NIOUtils.fetchFrom(this.input, count * 4);
                for (int i4 = 0; i4 < count; i4++) {
                    intArrayList.add(fetchFrom.getInt());
                }
                i++;
            }
            this.sampleCache = intArrayList.toArray();
        }
    }

    public int getStartTimecode() throws IOException {
        return getTimecodeSample(0);
    }

    public TrakBox getBox() {
        return this.box;
    }

    public int parseTimecode(String str) {
        str = str.split(":");
        byte numFrames = ((TimecodeSampleEntry) Box.findFirst(this.box, TimecodeSampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, TimeCodeBox.TYPE)).getNumFrames();
        return ((Integer.parseInt(str[3]) + (Integer.parseInt(str[2]) * numFrames)) + ((Integer.parseInt(str[1]) * 60) * numFrames)) + ((Integer.parseInt(str[0]) * 3600) * numFrames);
    }

    public int timeCodeToFrameNo(String str) throws Exception {
        if (!isValidTimeCode(str)) {
            return -1;
        }
        str = parseTimecode(str.trim()) - this.sampleCache[0];
        long numFrames = (long) this.tse.getNumFrames();
        return (int) ((QTTimeUtil.mediaToEdited(this.box, ((long) (str * this.tse.getTimescale())) / numFrames, this.movie.getTimescale()) * numFrames) / ((long) this.box.getTimescale()));
    }

    private static boolean isValidTimeCode(String str) {
        return (str == null || str.trim().equals("") != null || Pattern.compile("[0-9][0-9]:[0-5][0-9]:[0-5][0-9]:[0-2][0-9]").matcher(str).matches() == null) ? null : true;
    }
}
