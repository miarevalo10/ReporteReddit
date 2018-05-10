package org.jcodec.containers.mp4.muxer;

import com.coremedia.iso.boxes.EditBox;
import com.coremedia.iso.boxes.UserDataBox;
import com.googlecode.mp4parser.boxes.apple.GenericMediaHeaderAtom;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import com.googlecode.mp4parser.boxes.apple.TrackApertureModeDimensionAtom;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.common.model.Unit;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.ClearApertureBox;
import org.jcodec.containers.mp4.boxes.DataInfoBox;
import org.jcodec.containers.mp4.boxes.DataRefBox;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.EditListBox;
import org.jcodec.containers.mp4.boxes.EncodedPixelBox;
import org.jcodec.containers.mp4.boxes.GenericMediaInfoBox;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.LeafBox;
import org.jcodec.containers.mp4.boxes.MediaInfoBox;
import org.jcodec.containers.mp4.boxes.MovieHeaderBox;
import org.jcodec.containers.mp4.boxes.NameBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.PixelAspectExt;
import org.jcodec.containers.mp4.boxes.ProductionApertureBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleToChunkBox.SampleToChunkEntry;
import org.jcodec.containers.mp4.boxes.SoundMediaHeaderBox;
import org.jcodec.containers.mp4.boxes.TimecodeMediaInfoBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoMediaHeaderBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;

public abstract class AbstractMP4MuxerTrack {
    protected long chunkDuration;
    protected int chunkNo = 0;
    protected List<ByteBuffer> curChunk = new ArrayList();
    protected List<Edit> edits;
    protected boolean finished;
    private String name;
    protected List<SampleEntry> sampleEntries = new ArrayList();
    protected List<SampleToChunkEntry> samplesInChunks = new ArrayList();
    protected int samplesInLastChunk = -1;
    protected Rational tgtChunkDuration;
    protected Unit tgtChunkDurationUnit;
    protected int timescale;
    protected int trackId;
    protected TrackType type;

    protected abstract Box finish(MovieHeaderBox movieHeaderBox) throws IOException;

    public abstract long getTrackTotalDuration();

    public AbstractMP4MuxerTrack(int i, TrackType trackType, int i2) {
        this.trackId = i;
        this.type = trackType;
        this.timescale = i2;
    }

    public void setTgtChunkDuration(Rational rational, Unit unit) {
        this.tgtChunkDuration = rational;
        this.tgtChunkDurationUnit = unit;
    }

    public int getTimescale() {
        return this.timescale;
    }

    public boolean isVideo() {
        return this.type == TrackType.VIDEO;
    }

    public boolean isTimecode() {
        return this.type == TrackType.TIMECODE;
    }

    public boolean isAudio() {
        return this.type == TrackType.SOUND;
    }

    public Size getDisplayDimensions() {
        int height;
        int i = 0;
        if (this.sampleEntries.get(0) instanceof VideoSampleEntry) {
            VideoSampleEntry videoSampleEntry = (VideoSampleEntry) this.sampleEntries.get(0);
            PixelAspectExt pixelAspectExt = (PixelAspectExt) Box.findFirst(videoSampleEntry, PixelAspectExt.class, PixelAspectExt.fourcc());
            Rational rational = pixelAspectExt != null ? pixelAspectExt.getRational() : new Rational(1, 1);
            i = (rational.getNum() * videoSampleEntry.getWidth()) / rational.getDen();
            height = videoSampleEntry.getHeight();
        } else {
            height = 0;
        }
        return new Size(i, height);
    }

    public void tapt(TrakBox trakBox) {
        Size displayDimensions = getDisplayDimensions();
        if (this.type == TrackType.VIDEO) {
            Box nodeBox = new NodeBox(new Header(TrackApertureModeDimensionAtom.TYPE));
            nodeBox.add(new ClearApertureBox(displayDimensions.getWidth(), displayDimensions.getHeight()));
            nodeBox.add(new ProductionApertureBox(displayDimensions.getWidth(), displayDimensions.getHeight()));
            nodeBox.add(new EncodedPixelBox(displayDimensions.getWidth(), displayDimensions.getHeight()));
            trakBox.add(nodeBox);
        }
    }

    public void addSampleEntry(SampleEntry sampleEntry) {
        if (this.finished) {
            throw new IllegalStateException("The muxer track has finished muxing");
        }
        this.sampleEntries.add(sampleEntry);
    }

    public List<SampleEntry> getEntries() {
        return this.sampleEntries;
    }

    public void setEdits(List<Edit> list) {
        this.edits = list;
    }

    protected void putEdits(TrakBox trakBox) {
        if (this.edits != null) {
            Box nodeBox = new NodeBox(new Header(EditBox.TYPE));
            nodeBox.add(new EditListBox(this.edits));
            trakBox.add(nodeBox);
        }
    }

    public void setName(String str) {
        this.name = str;
    }

    protected void putName(TrakBox trakBox) {
        if (this.name != null) {
            Box nodeBox = new NodeBox(new Header(UserDataBox.TYPE));
            nodeBox.add(new NameBox(this.name));
            trakBox.add(nodeBox);
        }
    }

    protected void mediaHeader(MediaInfoBox mediaInfoBox, TrackType trackType) {
        switch (trackType) {
            case VIDEO:
                trackType = new VideoMediaHeaderBox(0, 0, 0, 0);
                trackType.setFlags(1);
                mediaInfoBox.add(trackType);
                return;
            case SOUND:
                trackType = new SoundMediaHeaderBox();
                trackType.setFlags(1);
                mediaInfoBox.add(trackType);
                return;
            case TIMECODE:
                trackType = new NodeBox(new Header(GenericMediaHeaderAtom.TYPE));
                trackType.add(new GenericMediaInfoBox());
                Box nodeBox = new NodeBox(new Header(TimeCodeBox.TYPE));
                trackType.add(nodeBox);
                nodeBox.add(new TimecodeMediaInfoBox((short) 0, (short) 0, (short) 12, new short[]{(short) 0, (short) 0, (short) 0}, new short[]{(short) 255, (short) 255, (short) 255}, "Lucida Grande"));
                mediaInfoBox.add(trackType);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Handler ");
                stringBuilder.append(trackType.getHandler());
                stringBuilder.append(" not supported");
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    protected void addDref(NodeBox nodeBox) {
        Box dataInfoBox = new DataInfoBox();
        nodeBox.add(dataInfoBox);
        nodeBox = new DataRefBox();
        dataInfoBox.add(nodeBox);
        nodeBox.add(new LeafBox(new Header("alis", 0), ByteBuffer.wrap(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1})));
    }
}
