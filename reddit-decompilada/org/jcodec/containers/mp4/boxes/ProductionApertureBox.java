package org.jcodec.containers.mp4.boxes;

import com.googlecode.mp4parser.boxes.apple.TrackProductionApertureDimensionsAtom;

public class ProductionApertureBox extends ClearApertureBox {
    public static String fourcc() {
        return TrackProductionApertureDimensionsAtom.TYPE;
    }

    public ProductionApertureBox(Header header) {
        super(header);
    }

    public ProductionApertureBox() {
        super(new Header(fourcc()));
    }

    public ProductionApertureBox(int i, int i2) {
        super(new Header(fourcc()), i, i2);
    }
}
