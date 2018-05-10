package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.MovieHeaderBox;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.TrackBox;
import com.googlecode.mp4parser.boxes.apple.CleanApertureAtom;
import com.googlecode.mp4parser.boxes.apple.TrackApertureModeDimensionAtom;
import com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.MP4Util;

public class MovieBox extends NodeBox {
    public static String fourcc() {
        return com.coremedia.iso.boxes.MovieBox.TYPE;
    }

    protected void getModelFields(List<String> list) {
    }

    public MovieBox(Header header) {
        super(header);
    }

    public MovieBox() {
        super(new Header(fourcc()));
    }

    public MovieBox(MovieBox movieBox) {
        super((NodeBox) movieBox);
    }

    public TrakBox[] getTracks() {
        return (TrakBox[]) Box.findAll(this, TrakBox.class, TrackBox.TYPE);
    }

    public TrakBox getVideoTrack() {
        for (TrakBox trakBox : getTracks()) {
            if (trakBox.isVideo()) {
                return trakBox;
            }
        }
        return null;
    }

    public TrakBox getTimecodeTrack() {
        for (TrakBox trakBox : getTracks()) {
            if (trakBox.isTimecode()) {
                return trakBox;
            }
        }
        return null;
    }

    public int getTimescale() {
        return getMovieHeader().getTimescale();
    }

    public long rescale(long j, long j2) {
        return (j * ((long) getTimescale())) / j2;
    }

    public void fixTimescale(int i) {
        int timescale = getTimescale();
        setTimescale(i);
        for (TrakBox trakBox : getTracks()) {
            long j = (long) timescale;
            trakBox.setDuration(rescale(trakBox.getDuration(), j));
            List edits = trakBox.getEdits();
            if (edits != null) {
                ListIterator listIterator = edits.listIterator();
                while (listIterator.hasNext()) {
                    Edit edit = (Edit) listIterator.next();
                    listIterator.set(new Edit(rescale(edit.getDuration(), j), edit.getMediaTime(), edit.getRate()));
                }
            }
        }
        setDuration(rescale(getDuration(), (long) timescale));
    }

    private void setTimescale(int i) {
        ((MovieHeaderBox) Box.findFirst(this, MovieHeaderBox.class, MovieHeaderBox.TYPE)).setTimescale(i);
    }

    public void setDuration(long j) {
        getMovieHeader().setDuration(j);
    }

    private MovieHeaderBox getMovieHeader() {
        return (MovieHeaderBox) Box.findFirst(this, MovieHeaderBox.class, MovieHeaderBox.TYPE);
    }

    public List<TrakBox> getAudioTracks() {
        List arrayList = new ArrayList();
        for (TrakBox trakBox : getTracks()) {
            if (trakBox.isAudio()) {
                arrayList.add(trakBox);
            }
        }
        return arrayList;
    }

    public long getDuration() {
        return getMovieHeader().getDuration();
    }

    public TrakBox importTrack(MovieBox movieBox, TrakBox trakBox) {
        trakBox = (TrakBox) MP4Util.cloneBox(trakBox, 1048576);
        List<Edit> edits = trakBox.getEdits();
        List arrayList = new ArrayList();
        if (edits != null) {
            for (Edit edit : edits) {
                arrayList.add(new Edit(rescale(edit.getDuration(), (long) movieBox.getTimescale()), edit.getMediaTime(), edit.getRate()));
            }
        }
        trakBox.setEdits(arrayList);
        return trakBox;
    }

    public void appendTrack(TrakBox trakBox) {
        trakBox.getTrackHeader().setNo(getMovieHeader().getNextTrackId());
        getMovieHeader().setNextTrackId(getMovieHeader().getNextTrackId() + 1);
        this.boxes.add(trakBox);
    }

    public boolean isPureRefMovie(MovieBox movieBox) {
        boolean z = true;
        for (TrakBox isPureRef : movieBox.getTracks()) {
            z &= isPureRef.isPureRef();
        }
        return z;
    }

    public void updateDuration() {
        long j = 2147483647L;
        for (TrakBox trakBox : getTracks()) {
            if (trakBox.getDuration() < j) {
                j = trakBox.getDuration();
            }
        }
        getMovieHeader().setDuration(j);
    }

    public Size getDisplaySize() {
        NodeBox videoTrack = getVideoTrack();
        if (videoTrack == null) {
            return null;
        }
        ClearApertureBox clearApertureBox = (ClearApertureBox) Box.findFirst(videoTrack, ClearApertureBox.class, TrackApertureModeDimensionAtom.TYPE, CleanApertureAtom.TYPE);
        if (clearApertureBox != null) {
            return applyMatrix(videoTrack, new Size((int) clearApertureBox.getWidth(), (int) clearApertureBox.getHeight()));
        }
        Box box = (Box) ((SampleDescriptionBox) Box.findFirst(videoTrack, SampleDescriptionBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE)).getBoxes().get(0);
        if (box != null) {
            if (box instanceof VideoSampleEntry) {
                VideoSampleEntry videoSampleEntry = (VideoSampleEntry) box;
                Rational par = videoTrack.getPAR();
                return applyMatrix(videoTrack, new Size((videoSampleEntry.getWidth() * par.getNum()) / par.getDen(), videoSampleEntry.getHeight()));
            }
        }
        return null;
    }

    private Size applyMatrix(TrakBox trakBox, Size size) {
        trakBox = trakBox.getTrackHeader().getMatrix();
        return new Size((int) ((((double) size.getWidth()) * ((double) trakBox[0])) / 65536.0d), (int) ((((double) size.getHeight()) * ((double) trakBox[4])) / 65536.0d));
    }

    public Size getStoredSize() {
        NodeBox videoTrack = getVideoTrack();
        if (videoTrack == null) {
            return null;
        }
        EncodedPixelBox encodedPixelBox = (EncodedPixelBox) Box.findFirst(videoTrack, EncodedPixelBox.class, TrackApertureModeDimensionAtom.TYPE, TrackEncodedPixelsDimensionsAtom.TYPE);
        if (encodedPixelBox != null) {
            return new Size((int) encodedPixelBox.getWidth(), (int) encodedPixelBox.getHeight());
        }
        Box box = (Box) ((SampleDescriptionBox) Box.findFirst(videoTrack, SampleDescriptionBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleDescriptionBox.TYPE)).getBoxes().get(0);
        if (box != null) {
            if (box instanceof VideoSampleEntry) {
                VideoSampleEntry videoSampleEntry = (VideoSampleEntry) box;
                return new Size(videoSampleEntry.getWidth(), videoSampleEntry.getHeight());
            }
        }
        return null;
    }
}
