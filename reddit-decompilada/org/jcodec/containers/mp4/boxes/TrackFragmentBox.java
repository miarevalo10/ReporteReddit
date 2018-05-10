package org.jcodec.containers.mp4.boxes;

import java.util.List;

public class TrackFragmentBox extends NodeBox {
    public static String fourcc() {
        return com.coremedia.iso.boxes.fragment.TrackFragmentBox.TYPE;
    }

    protected void getModelFields(List<String> list) {
    }

    public TrackFragmentBox() {
        super(new Header(fourcc()));
    }

    public int getTrackId() {
        TrackFragmentHeaderBox trackFragmentHeaderBox = (TrackFragmentHeaderBox) Box.findFirst(this, TrackFragmentHeaderBox.class, TrackFragmentHeaderBox.fourcc());
        if (trackFragmentHeaderBox != null) {
            return trackFragmentHeaderBox.getTrackId();
        }
        throw new RuntimeException("Corrupt track fragment, no header atom found");
    }
}
