package org.jcodec.movtool.streaming.tracks;

import com.coremedia.iso.boxes.MediaBox;
import com.coremedia.iso.boxes.MediaInformationBox;
import com.coremedia.iso.boxes.SampleSizeBox;
import com.coremedia.iso.boxes.SampleTableBox;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.boxes.apple.PixelAspectRationAtom;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.mp4parser.iso14496.part15.AvcConfigurationBox;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.MP4Packet;
import org.jcodec.containers.mp4.boxes.AudioSampleEntry;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Edit;
import org.jcodec.containers.mp4.boxes.FielExtension;
import org.jcodec.containers.mp4.boxes.LeafBox;
import org.jcodec.containers.mp4.boxes.MovieBox;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.PixelAspectExt;
import org.jcodec.containers.mp4.boxes.SampleEntry;
import org.jcodec.containers.mp4.boxes.SampleSizesBox;
import org.jcodec.containers.mp4.boxes.TrakBox;
import org.jcodec.containers.mp4.boxes.VideoSampleEntry;
import org.jcodec.containers.mp4.boxes.channel.ChannelUtils;
import org.jcodec.containers.mp4.demuxer.AbstractMP4DemuxerTrack;
import org.jcodec.containers.mp4.demuxer.FramesMP4DemuxerTrack;
import org.jcodec.containers.mp4.demuxer.PCMMP4DemuxerTrack;
import org.jcodec.movtool.streaming.AudioCodecMeta;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class RealTrack implements VirtualTrack {
    private AbstractMP4DemuxerTrack demuxer;
    private MovieBox movie;
    private ByteChannelPool pool;
    private TrakBox trak;

    public class RealPacket implements VirtualPacket {
        private MP4Packet packet;

        public RealPacket(MP4Packet mP4Packet) {
            this.packet = mP4Packet;
        }

        public ByteBuffer getData() throws IOException {
            Throwable th;
            ByteBuffer allocate = ByteBuffer.allocate(this.packet.getSize());
            SeekableByteChannel channel;
            try {
                channel = RealTrack.this.pool.getChannel();
                try {
                    if (this.packet.getFileOff() >= channel.size()) {
                        if (channel != null) {
                            channel.close();
                        }
                        return null;
                    }
                    channel.position(this.packet.getFileOff());
                    channel.read(allocate);
                    allocate.flip();
                    if (channel != null) {
                        channel.close();
                    }
                    return allocate;
                } catch (Throwable th2) {
                    th = th2;
                    if (channel != null) {
                        channel.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                channel = null;
                if (channel != null) {
                    channel.close();
                }
                throw th;
            }
        }

        public int getDataLen() {
            return this.packet.getSize();
        }

        public double getPts() {
            return ((double) this.packet.getMediaPts()) / ((double) this.packet.getTimescale());
        }

        public double getDuration() {
            return ((double) this.packet.getDuration()) / ((double) this.packet.getTimescale());
        }

        public boolean isKeyframe() {
            if (!this.packet.isKeyFrame()) {
                if (!this.packet.isPsync()) {
                    return false;
                }
            }
            return true;
        }

        public int getFrameNo() {
            return (int) this.packet.getFrameNo();
        }
    }

    public RealTrack(MovieBox movieBox, TrakBox trakBox, ByteChannelPool byteChannelPool) {
        this.movie = movieBox;
        if (((SampleSizesBox) Box.findFirst(trakBox, SampleSizesBox.class, MediaBox.TYPE, MediaInformationBox.TYPE, SampleTableBox.TYPE, SampleSizeBox.TYPE)).getDefaultSize() == 0) {
            this.demuxer = new FramesMP4DemuxerTrack(this, movieBox, trakBox) {
                final /* synthetic */ RealTrack f39995a;

                protected ByteBuffer readPacketData(SeekableByteChannel seekableByteChannel, ByteBuffer byteBuffer, long j, int i) throws IOException {
                    return byteBuffer;
                }
            };
        } else {
            this.demuxer = new PCMMP4DemuxerTrack(this, movieBox, trakBox) {
                final /* synthetic */ RealTrack f39996a;

                protected ByteBuffer readPacketData(SeekableByteChannel seekableByteChannel, ByteBuffer byteBuffer, long j, int i) throws IOException {
                    return byteBuffer;
                }
            };
        }
        this.trak = trakBox;
        this.pool = byteChannelPool;
    }

    public VirtualPacket nextPacket() throws IOException {
        MP4Packet nextFrame = this.demuxer.nextFrame(null);
        if (nextFrame == null) {
            return null;
        }
        return new RealPacket(nextFrame);
    }

    public CodecMeta getCodecMeta() {
        NodeBox nodeBox = this.trak.getSampleEntries()[0];
        String str = null;
        if (nodeBox instanceof VideoSampleEntry) {
            boolean isInterlaced;
            boolean topFieldFirst;
            VideoSampleEntry videoSampleEntry = (VideoSampleEntry) nodeBox;
            PixelAspectExt pixelAspectExt = (PixelAspectExt) Box.findFirst(nodeBox, PixelAspectExt.class, PixelAspectRationAtom.TYPE);
            FielExtension fielExtension = (FielExtension) Box.findFirst(nodeBox, FielExtension.class, "fiel");
            if (fielExtension != null) {
                isInterlaced = fielExtension.isInterlaced();
                topFieldFirst = fielExtension.topFieldFirst();
            } else {
                isInterlaced = false;
                topFieldFirst = isInterlaced;
            }
            String fourcc = nodeBox.getFourcc();
            ByteBuffer extractVideoCodecPrivate = extractVideoCodecPrivate(nodeBox);
            Size size = new Size(videoSampleEntry.getWidth(), videoSampleEntry.getHeight());
            if (pixelAspectExt != null) {
                str = pixelAspectExt.getRational();
            }
            return new VideoCodecMeta(fourcc, extractVideoCodecPrivate, size, str, isInterlaced, topFieldFirst);
        } else if (nodeBox instanceof AudioSampleEntry) {
            AudioSampleEntry audioSampleEntry = (AudioSampleEntry) nodeBox;
            if (com.coremedia.iso.boxes.sampleentry.AudioSampleEntry.TYPE3.equals(audioSampleEntry.getFourcc())) {
                LeafBox leafBox = (LeafBox) Box.findFirst(nodeBox, LeafBox.class, ESDescriptorBox.TYPE);
                if (leafBox == null) {
                    leafBox = (LeafBox) Box.findFirst(nodeBox, LeafBox.class, null, ESDescriptorBox.TYPE);
                }
                str = leafBox.getData();
            }
            return new AudioCodecMeta(nodeBox.getFourcc(), audioSampleEntry.calcSampleSize(), audioSampleEntry.getChannelCount(), (int) audioSampleEntry.getSampleRate(), audioSampleEntry.getEndian(), audioSampleEntry.isPCM(), ChannelUtils.getLabels(audioSampleEntry), str);
        } else {
            StringBuilder stringBuilder = new StringBuilder("Sample entry '");
            stringBuilder.append(nodeBox.getFourcc());
            stringBuilder.append("' is not supported.");
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    private ByteBuffer extractVideoCodecPrivate(SampleEntry sampleEntry) {
        return VisualSampleEntry.TYPE3.equals(sampleEntry.getFourcc()) ? ((LeafBox) Box.findFirst(sampleEntry, LeafBox.class, AvcConfigurationBox.TYPE)).getData() : null;
    }

    public void close() {
        this.pool.close();
    }

    public VirtualEdit[] getEdits() {
        List edits = this.demuxer.getEdits();
        if (edits == null) {
            return null;
        }
        VirtualEdit[] virtualEditArr = new VirtualEdit[edits.size()];
        for (int i = 0; i < edits.size(); i++) {
            Edit edit = (Edit) edits.get(i);
            virtualEditArr[i] = new VirtualEdit(((double) edit.getMediaTime()) / ((double) this.trak.getTimescale()), ((double) edit.getDuration()) / ((double) this.movie.getTimescale()));
        }
        return virtualEditArr;
    }

    public int getPreferredTimescale() {
        return (int) this.demuxer.getTimescale();
    }
}
