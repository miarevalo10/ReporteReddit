package org.jcodec.containers.mp4.boxes;

import com.googlecode.mp4parser.boxes.apple.TrackEncodedPixelsDimensionsAtom;

public class EncodedPixelBox extends ClearApertureBox {
    public static String fourcc() {
        return TrackEncodedPixelsDimensionsAtom.TYPE;
    }

    public EncodedPixelBox(Header header) {
        super(header);
    }

    public EncodedPixelBox() {
        super(new Header(fourcc()));
    }

    public EncodedPixelBox(int i, int i2) {
        super(new Header(fourcc()), i, i2);
    }
}
