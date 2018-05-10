package org.jcodec.containers.mp4.boxes;

import java.util.List;

public class MovieFragmentBox extends NodeBox {
    private MovieBox moov;

    public static String fourcc() {
        return com.coremedia.iso.boxes.fragment.MovieFragmentBox.TYPE;
    }

    protected void getModelFields(List<String> list) {
    }

    public MovieFragmentBox() {
        super(new Header(fourcc()));
    }

    public MovieBox getMovie() {
        return this.moov;
    }

    public void setMovie(MovieBox movieBox) {
        this.moov = movieBox;
    }

    public TrackFragmentBox[] getTracks() {
        return (TrackFragmentBox[]) Box.findAll(this, TrackFragmentBox.class, TrackFragmentBox.fourcc());
    }

    public int getSequenceNumber() {
        MovieFragmentHeaderBox movieFragmentHeaderBox = (MovieFragmentHeaderBox) Box.findFirst(this, MovieFragmentHeaderBox.class, MovieFragmentHeaderBox.fourcc());
        if (movieFragmentHeaderBox != null) {
            return movieFragmentHeaderBox.getSequenceNumber();
        }
        throw new RuntimeException("Corrupt movie fragment, no header atom found");
    }
}
