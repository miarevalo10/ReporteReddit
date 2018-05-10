package org.jcodec.containers.mp4.demuxer;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.boxes.apple.TimeCodeBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.HandlerBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.TrakBox;

public class MP4Demuxer {
    private static int free = 1718773093;
    private static int ftyp = 1718909296;
    private static int mdat = 1835295092;
    private static int moov = 1836019574;
    private static int wide = 2003395685;
    private SeekableByteChannel input;
    MovieBox movie;
    private TimecodeMP4DemuxerTrack timecodeTrack;
    private List<AbstractMP4DemuxerTrack> tracks = new LinkedList();

    public AbstractMP4DemuxerTrack create(TrakBox trakBox) {
        if (((SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE)).getDefaultSize() == 0) {
            return new FramesMP4DemuxerTrack(this.movie, trakBox, this.input);
        }
        return new PCMMP4DemuxerTrack(this.movie, trakBox, this.input);
    }

    public MP4Demuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.input = seekableByteChannel;
        findMovieBox(seekableByteChannel);
    }

    public AbstractMP4DemuxerTrack[] getTracks() {
        return (AbstractMP4DemuxerTrack[]) this.tracks.toArray(new AbstractMP4DemuxerTrack[0]);
    }

    private void findMovieBox(SeekableByteChannel seekableByteChannel) throws IOException {
        this.movie = MP4Util.parseMovie(seekableByteChannel);
        if (this.movie == null) {
            throw new IOException("Could not find movie meta information box");
        }
        processHeader(this.movie);
    }

    private void processHeader(NodeBox nodeBox) throws IOException {
        TrakBox trakBox = null;
        for (NodeBox nodeBox2 : (TrakBox[]) Box.findAll(nodeBox, TrakBox.class, TrackBox.TYPE)) {
            if (TimeCodeBox.TYPE.equals(((SampleEntry) Box.findFirst(nodeBox2, SampleEntry.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE, null)).getFourcc())) {
                trakBox = nodeBox2;
            } else {
                this.tracks.add(create(nodeBox2));
            }
        }
        if (trakBox != null && getVideoTrack() != null) {
            this.timecodeTrack = new TimecodeMP4DemuxerTrack(this.movie, trakBox, this.input);
        }
    }

    public static TrackType getTrackType(TrakBox trakBox) {
        return TrackType.fromHandler(((HandlerBox) Box.findFirst(trakBox, HandlerBox.class, MediaBox.TYPE, com.coremedia.iso.boxes.HandlerBox.TYPE)).getComponentSubType());
    }

    public AbstractMP4DemuxerTrack getVideoTrack() {
        for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : this.tracks) {
            if (abstractMP4DemuxerTrack.box.isVideo()) {
                return abstractMP4DemuxerTrack;
            }
        }
        return null;
    }

    public MovieBox getMovie() {
        return this.movie;
    }

    public AbstractMP4DemuxerTrack getTrack(int i) {
        for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : this.tracks) {
            if (abstractMP4DemuxerTrack.getNo() == i) {
                return abstractMP4DemuxerTrack;
            }
        }
        return 0;
    }

    public List<AbstractMP4DemuxerTrack> getAudioTracks() {
        List arrayList = new ArrayList();
        for (AbstractMP4DemuxerTrack abstractMP4DemuxerTrack : this.tracks) {
            if (abstractMP4DemuxerTrack.box.isAudio()) {
                arrayList.add(abstractMP4DemuxerTrack);
            }
        }
        return arrayList;
    }

    public TimecodeMP4DemuxerTrack getTimecodeTrack() {
        return this.timecodeTrack;
    }

    public static int probe(ByteBuffer byteBuffer) {
        byteBuffer = byteBuffer.duplicate();
        int i = 0;
        int i2 = i;
        while (true) {
            int i3 = 8;
            if (byteBuffer.remaining() < 8) {
                break;
            }
            long j = ((long) byteBuffer.getInt()) & 4294967295L;
            int i4 = byteBuffer.getInt();
            if (j != 1) {
                if (j < 8) {
                    break;
                }
            }
            j = byteBuffer.getLong();
            i3 = 16;
            if ((i4 == ftyp && j < 64) || ((i4 == moov && j < 104857600) || i4 == free || i4 == mdat || i4 == wide)) {
                i++;
            }
            i2++;
            if (j >= 2147483647L) {
                break;
            }
            NIOUtils.skip(byteBuffer, (int) (j - ((long) i3)));
        }
        if (i2 == 0) {
            return 0;
        }
        return (i * 100) / i2;
    }
}
