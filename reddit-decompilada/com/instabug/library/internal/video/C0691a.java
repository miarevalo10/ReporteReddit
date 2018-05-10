package com.instabug.library.internal.video;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.jcodec.codecs.h264.H264Encoder;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.muxer.FramesMP4MuxerTrack;
import org.jcodec.containers.mp4.muxer.MP4Muxer;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;

/* compiled from: InstabugSequenceEncoder */
public class C0691a {
    SeekableByteChannel f9631a;
    Picture f9632b;
    Transform f9633c = ColorUtil.getTransform(ColorSpace.RGB, this.f9634d.getSupportedColorSpaces()[0]);
    H264Encoder f9634d = new H264Encoder();
    ArrayList<ByteBuffer> f9635e = new ArrayList();
    ArrayList<ByteBuffer> f9636f = new ArrayList();
    FramesMP4MuxerTrack f9637g = this.f9640j.addTrack(TrackType.VIDEO, 8);
    ByteBuffer f9638h = ByteBuffer.allocate(12441600);
    int f9639i;
    MP4Muxer f9640j = new MP4Muxer(this.f9631a, Brand.MP4);

    public C0691a(File file) throws IOException {
        this.f9631a = NIOUtils.writableFileChannel(file);
    }
}
