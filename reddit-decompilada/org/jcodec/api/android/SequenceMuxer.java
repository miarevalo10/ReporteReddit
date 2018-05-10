package org.jcodec.api.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.IOException;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.muxer.FramesMP4MuxerTrack;
import org.jcodec.containers.mp4.muxer.MP4Muxer;

public class SequenceMuxer {
    private SeekableByteChannel ch;
    private int frameNo;
    private MP4Muxer muxer = new MP4Muxer(this.ch, Brand.MP4);
    private FramesMP4MuxerTrack outTrack = this.muxer.addTrack(TrackType.VIDEO, 25);
    private Size size;

    public SequenceMuxer(File file) throws IOException {
        this.ch = NIOUtils.writableFileChannel(file);
    }

    public void encodeImage(File file) throws IOException {
        if (this.size == null) {
            Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            r0.size = new Size(decodeFile.getWidth(), decodeFile.getHeight());
        }
        FramesMP4MuxerTrack framesMP4MuxerTrack = r0.outTrack;
        MP4Packet mP4Packet = r2;
        MP4Packet mP4Packet2 = new MP4Packet(NIOUtils.fetchFrom(file), (long) r0.frameNo, 25, 1, (long) r0.frameNo, true, null, (long) r0.frameNo, 0);
        framesMP4MuxerTrack.addFrame(mP4Packet);
        r0.frameNo++;
    }

    public void finish() throws IOException {
        this.outTrack.addSampleEntry(MP4Muxer.videoSampleEntry("png ", this.size, "JCodec"));
        this.muxer.writeHeader();
        NIOUtils.closeQuietly(this.ch);
    }
}
