package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.MediaInformationBox;

public class MediaBox extends NodeBox {
    public static String fourcc() {
        return com.coremedia.iso.boxes.MediaBox.TYPE;
    }

    public MediaBox(Header header) {
        super(header);
    }

    public MediaBox() {
        super(new Header(fourcc()));
    }

    public MediaInfoBox getMinf() {
        return (MediaInfoBox) Box.findFirst(this, MediaInfoBox.class, MediaInformationBox.TYPE);
    }
}
