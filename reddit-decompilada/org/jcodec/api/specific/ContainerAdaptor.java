package org.jcodec.api.specific;

import org.jcodec.api.FrameGrab.MediaInfo;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;

public interface ContainerAdaptor {
    int[][] allocatePicture();

    boolean canSeek(Packet packet);

    Picture decodeFrame(Packet packet, int[][] iArr);

    MediaInfo getMediaInfo();
}
