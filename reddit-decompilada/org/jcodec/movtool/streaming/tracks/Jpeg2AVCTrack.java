package org.jcodec.movtool.streaming.tracks;

import org.jcodec.codecs.mjpeg.JpegDecoder;
import org.jcodec.codecs.mjpeg.JpegToThumb2x2;
import org.jcodec.codecs.mjpeg.JpegToThumb4x4;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.Size;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualTrack;

public class Jpeg2AVCTrack extends Transcode2AVCTrack {
    public Jpeg2AVCTrack(VirtualTrack virtualTrack, Size size) {
        super(virtualTrack, size);
    }

    protected void checkFourCC(VirtualTrack virtualTrack) {
        virtualTrack = virtualTrack.getCodecMeta().getFourcc();
        if (!"jpeg".equals(virtualTrack)) {
            if ("mjpa".equals(virtualTrack) == null) {
                throw new IllegalArgumentException("Input track is not Jpeg");
            }
        }
    }

    protected int selectScaleFactor(Size size) {
        if (size.getWidth() >= 960) {
            return 2;
        }
        return size.getWidth() > 480 ? 1 : null;
    }

    protected VideoDecoder getDecoder(int i) {
        VideoCodecMeta videoCodecMeta = (VideoCodecMeta) this.src.getCodecMeta();
        switch (i) {
            case 0:
                return new JpegDecoder(videoCodecMeta.isInterlaced(), videoCodecMeta.isTopFieldFirst());
            case 1:
                return new JpegToThumb4x4(videoCodecMeta.isInterlaced(), videoCodecMeta.isTopFieldFirst());
            case 2:
                return new JpegToThumb2x2(videoCodecMeta.isInterlaced(), videoCodecMeta.isTopFieldFirst());
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported scale factor: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
