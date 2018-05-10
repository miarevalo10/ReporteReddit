package org.jcodec.movtool.streaming.tracks;

import java.util.EnumSet;
import java.util.Iterator;
import org.jcodec.codecs.prores.ProresDecoder;
import org.jcodec.codecs.prores.ProresEncoder.Profile;
import org.jcodec.codecs.prores.ProresToThumb2x2;
import org.jcodec.codecs.prores.ProresToThumb4x4;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.Size;
import org.jcodec.movtool.streaming.VirtualTrack;

public class Prores2AVCTrack extends Transcode2AVCTrack {
    public Prores2AVCTrack(VirtualTrack virtualTrack, Size size) {
        super(virtualTrack, size);
    }

    protected void checkFourCC(VirtualTrack virtualTrack) {
        virtualTrack = virtualTrack.getCodecMeta().getFourcc();
        if (!"ap4h".equals(virtualTrack)) {
            Iterator it = EnumSet.allOf(Profile.class).iterator();
            while (it.hasNext()) {
                if (((Profile) it.next()).fourcc.equals(virtualTrack)) {
                    return;
                }
            }
            throw new IllegalArgumentException("Input track is not ProRes");
        }
    }

    protected int selectScaleFactor(Size size) {
        if (size.getWidth() >= 960) {
            return 2;
        }
        return size.getWidth() > 480 ? 1 : null;
    }

    protected VideoDecoder getDecoder(int i) {
        switch (i) {
            case 0:
                return new ProresDecoder();
            case 1:
                return new ProresToThumb4x4();
            case 2:
                return new ProresToThumb2x2();
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported scale factor: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
