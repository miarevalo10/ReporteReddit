package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleTableBox;

public class MediaInfoBox extends NodeBox {
    public static String fourcc() {
        return MediaInformationBox.TYPE;
    }

    public MediaInfoBox(Header header) {
        super(header);
    }

    public MediaInfoBox() {
        super(new Header(fourcc()));
    }

    public DataInfoBox getDinf() {
        return (DataInfoBox) Box.findFirst(this, DataInfoBox.class, DataInformationBox.TYPE);
    }

    public NodeBox getStbl() {
        return (NodeBox) Box.findFirst(this, NodeBox.class, SampleTableBox.TYPE);
    }
}
