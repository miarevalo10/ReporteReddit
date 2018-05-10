package org.jcodec.api;

import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.api.specific.AVCMP4Adaptor;
import org.jcodec.api.specific.ContainerAdaptor;
import org.jcodec.codecs.h264.H264Decoder;
import org.jcodec.codecs.mpeg12.MPEGDecoder;
import org.jcodec.codecs.prores.ProresDecoder;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.JCodecUtil;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.SeekableDemuxerTrack;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.model.Packet;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack;
import org.jcodec.containers.mp4.demuxer.MP4Demuxer;

public class FrameGrab {
    private ThreadLocal<int[][]> buffers = new ThreadLocal();
    private ContainerAdaptor decoder;
    private DemuxerTrack videoTrack;

    public static class MediaInfo {
        private Size dim;

        public MediaInfo(Size size) {
            this.dim = size;
        }

        public Size getDim() {
            return this.dim;
        }

        public void setDim(Size size) {
            this.dim = size;
        }
    }

    public FrameGrab(SeekableByteChannel seekableByteChannel) throws IOException, JCodecException {
        ByteBuffer allocate = ByteBuffer.allocate(65536);
        seekableByteChannel.read(allocate);
        allocate.flip();
        switch (JCodecUtil.detectFormat(allocate)) {
            case MOV:
                this.videoTrack = new MP4Demuxer(seekableByteChannel).getVideoTrack();
                decodeLeadingFrames();
                return;
            case MPEG_PS:
                throw new UnsupportedFormatException("MPEG PS is temporarily unsupported.");
            case MPEG_TS:
                throw new UnsupportedFormatException("MPEG TS is temporarily unsupported.");
            default:
                throw new UnsupportedFormatException("Container format is not supported by JCodec");
        }
    }

    public FrameGrab(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor) {
        this.videoTrack = seekableDemuxerTrack;
        this.decoder = containerAdaptor;
    }

    private SeekableDemuxerTrack sdt() throws JCodecException {
        if (this.videoTrack instanceof SeekableDemuxerTrack) {
            return (SeekableDemuxerTrack) this.videoTrack;
        }
        throw new JCodecException("Not a seekable track");
    }

    public FrameGrab seekToSecondPrecise(double d) throws IOException, JCodecException {
        sdt().seek(d);
        decodeLeadingFrames();
        return this;
    }

    public FrameGrab seekToFramePrecise(int i) throws IOException, JCodecException {
        sdt().gotoFrame((long) i);
        decodeLeadingFrames();
        return this;
    }

    public FrameGrab seekToSecondSloppy(double d) throws IOException, JCodecException {
        sdt().seek(d);
        goToPrevKeyframe();
        return this;
    }

    public FrameGrab seekToFrameSloppy(int i) throws IOException, JCodecException {
        sdt().gotoFrame((long) i);
        goToPrevKeyframe();
        return this;
    }

    private void goToPrevKeyframe() throws IOException, JCodecException {
        sdt().gotoFrame((long) detectKeyFrame((int) sdt().getCurFrame()));
    }

    private void decodeLeadingFrames() throws IOException, JCodecException {
        SeekableDemuxerTrack sdt = sdt();
        int curFrame = (int) sdt.getCurFrame();
        sdt.gotoFrame((long) detectKeyFrame(curFrame));
        Packet nextFrame = sdt.nextFrame();
        this.decoder = detectDecoder(sdt, nextFrame);
        while (true) {
            long j = (long) curFrame;
            if (nextFrame.getFrameNo() < j) {
                this.decoder.decodeFrame(nextFrame, getBuffer());
                nextFrame = sdt.nextFrame();
            } else {
                sdt.gotoFrame(j);
                return;
            }
        }
    }

    private int[][] getBuffer() {
        int[][] iArr = (int[][]) this.buffers.get();
        if (iArr != null) {
            return iArr;
        }
        Object allocatePicture = this.decoder.allocatePicture();
        this.buffers.set(allocatePicture);
        return allocatePicture;
    }

    private int detectKeyFrame(int i) throws IOException {
        int[] seekFrames = this.videoTrack.getMeta().getSeekFrames();
        if (seekFrames == null) {
            return i;
        }
        int i2 = seekFrames[0];
        int i3 = 1;
        while (i3 < seekFrames.length && seekFrames[i3] <= i) {
            i2 = seekFrames[i3];
            i3++;
        }
        return i2;
    }

    private ContainerAdaptor detectDecoder(SeekableDemuxerTrack seekableDemuxerTrack, Packet packet) throws JCodecException {
        if (seekableDemuxerTrack instanceof AbstractMP4DemuxerTrack) {
            AbstractMP4DemuxerTrack abstractMP4DemuxerTrack = (AbstractMP4DemuxerTrack) seekableDemuxerTrack;
            if ((byFourcc(abstractMP4DemuxerTrack.getSampleEntries()[((MP4Packet) packet).getEntryNo()].getHeader().getFourcc()) instanceof H264Decoder) != null) {
                return new AVCMP4Adaptor(abstractMP4DemuxerTrack.getSampleEntries());
            }
        }
        throw new UnsupportedFormatException("Codec is not supported");
    }

    private VideoDecoder byFourcc(String str) {
        if (str.equals(VisualSampleEntry.TYPE3)) {
            return new H264Decoder();
        }
        if (!str.equals("m1v1")) {
            if (!str.equals("m2v1")) {
                if (!(str.equals("apco") || str.equals("apcs") || str.equals("apcn") || str.equals("apch"))) {
                    if (str.equals("ap4h") == null) {
                        return null;
                    }
                }
                return new ProresDecoder();
            }
        }
        return new MPEGDecoder();
    }

    public Picture getNativeFrame() throws IOException {
        Packet nextFrame = this.videoTrack.nextFrame();
        if (nextFrame == null) {
            return null;
        }
        return this.decoder.decodeFrame(nextFrame, getBuffer());
    }

    public static Picture getNativeFrame(File file, double d) throws IOException, JCodecException {
        ReadableByteChannel readableFileChannel;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file);
            try {
                d = new FrameGrab(readableFileChannel).seekToSecondPrecise(d).getNativeFrame();
                NIOUtils.closeQuietly(readableFileChannel);
                return d;
            } catch (Throwable th) {
                d = th;
                NIOUtils.closeQuietly(readableFileChannel);
                throw d;
            }
        } catch (Throwable th2) {
            d = th2;
            readableFileChannel = null;
            NIOUtils.closeQuietly(readableFileChannel);
            throw d;
        }
    }

    public static Picture getNativeFrame(SeekableByteChannel seekableByteChannel, double d) throws JCodecException, IOException {
        return new FrameGrab(seekableByteChannel).seekToSecondPrecise(d).getNativeFrame();
    }

    public static Picture getNativeFrame(File file, int i) throws IOException, JCodecException {
        ReadableByteChannel readableFileChannel;
        try {
            readableFileChannel = NIOUtils.readableFileChannel(file);
            try {
                i = new FrameGrab(readableFileChannel).seekToFramePrecise(i).getNativeFrame();
                NIOUtils.closeQuietly(readableFileChannel);
                return i;
            } catch (Throwable th) {
                i = th;
                NIOUtils.closeQuietly(readableFileChannel);
                throw i;
            }
        } catch (Throwable th2) {
            i = th2;
            readableFileChannel = null;
            NIOUtils.closeQuietly(readableFileChannel);
            throw i;
        }
    }

    public static Picture getNativeFrame(SeekableByteChannel seekableByteChannel, int i) throws JCodecException, IOException {
        return new FrameGrab(seekableByteChannel).seekToFramePrecise(i).getNativeFrame();
    }

    public static Picture getNativeFrame(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, int i) throws IOException, JCodecException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToFramePrecise(i).getNativeFrame();
    }

    public static Picture getNativeFrame(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, double d) throws IOException, JCodecException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToSecondPrecise(d).getNativeFrame();
    }

    public static Picture getNativeFrameSloppy(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, int i) throws IOException, JCodecException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToFrameSloppy(i).getNativeFrame();
    }

    public static Picture getNativeFrameSloppy(SeekableDemuxerTrack seekableDemuxerTrack, ContainerAdaptor containerAdaptor, double d) throws IOException, JCodecException {
        return new FrameGrab(seekableDemuxerTrack, containerAdaptor).seekToSecondSloppy(d).getNativeFrame();
    }

    public MediaInfo getMediaInfo() {
        return this.decoder.getMediaInfo();
    }
}
