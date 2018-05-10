package org.jcodec.api.specific;

import org.jcodec.api.FrameGrab.MediaInfo;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;

public class GenericAdaptor implements ContainerAdaptor {
    private VideoDecoder decoder;

    public boolean canSeek(Packet packet) {
        return true;
    }

    public GenericAdaptor(VideoDecoder videoDecoder) {
        this.decoder = videoDecoder;
    }

    public Picture decodeFrame(Packet packet, int[][] iArr) {
        return this.decoder.decodeFrame(packet.getData(), iArr);
    }

    public int[][] allocatePicture() {
        return Picture.create(1920, 1088, ColorSpace.YUV444).getData();
    }

    public MediaInfo getMediaInfo() {
        return new MediaInfo(new Size(0, 0));
    }
}
