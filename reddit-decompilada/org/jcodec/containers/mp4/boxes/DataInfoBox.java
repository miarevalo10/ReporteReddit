package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.DataInformationBox;
import com.coremedia.iso.boxes.DataReferenceBox;

public class DataInfoBox extends NodeBox {
    public static String fourcc() {
        return DataInformationBox.TYPE;
    }

    public DataInfoBox() {
        super(new Header(fourcc()));
    }

    public DataInfoBox(Header header) {
        super(header);
    }

    public DataRefBox getDref() {
        return (DataRefBox) Box.findFirst(this, DataRefBox.class, DataReferenceBox.TYPE);
    }
}
