package org.jcodec.api;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jcodec.codecs.h264.H264Encoder;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.muxer.FramesMP4MuxerTrack;
import org.jcodec.containers.mp4.muxer.MP4Muxer;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

public class SequenceEncoder {
    private ByteBuffer _out = ByteBuffer.allocate(12441600);
    private SeekableByteChannel ch;
    private H264Encoder encoder = new H264Encoder();
    private int frameNo;
    private MP4Muxer muxer = new MP4Muxer(this.ch, Brand.MP4);
    private FramesMP4MuxerTrack outTrack = this.muxer.addTrack(TrackType.VIDEO, 25);
    private ArrayList<ByteBuffer> ppsList = new ArrayList();
    private ArrayList<ByteBuffer> spsList = new ArrayList();
    private Picture toEncode;
    private Transform transform = ColorUtil.getTransform(ColorSpace.RGB, this.encoder.getSupportedColorSpaces()[0]);

    public SequenceEncoder(File file) throws IOException {
        this.ch = NIOUtils.writableFileChannel(file);
    }

    public void encodeNativeFrame(Picture picture) throws IOException {
        if (this.toEncode == null) {
            r0.toEncode = Picture.create(picture.getWidth(), picture.getHeight(), r0.encoder.getSupportedColorSpaces()[0]);
        }
        r0.transform.transform(picture, r0.toEncode);
        r0._out.clear();
        ByteBuffer encodeFrame = r0.encoder.encodeFrame(r0.toEncode, r0._out);
        r0.spsList.clear();
        r0.ppsList.clear();
        H264Utils.wipePS(encodeFrame, r0.spsList, r0.ppsList);
        H264Utils.encodeMOVPacket(encodeFrame);
        r0.outTrack.addFrame(new MP4Packet(encodeFrame, (long) r0.frameNo, 25, 1, (long) r0.frameNo, true, null, (long) r0.frameNo, 0));
        r0.frameNo++;
    }

    public void finish() throws IOException {
        this.outTrack.addSampleEntry(H264Utils.createMOVSampleEntry(this.spsList, this.ppsList, 4));
        this.muxer.writeHeader();
        NIOUtils.closeQuietly(this.ch);
    }
}
