package org.jcodec.containers.mxf.streaming;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Rational;
import org.jcodec.common.model.Size;
import org.jcodec.containers.mp4.MP4Util;
import org.jcodec.containers.mp4.boxes.EndianBox.Endian;
import org.jcodec.containers.mp4.boxes.channel.Label;
import org.jcodec.containers.mxf.MXFConst.MXFCodecMapping;
import org.jcodec.containers.mxf.MXFDemuxer;
import org.jcodec.containers.mxf.MXFDemuxer.MXFDemuxerTrack;
import org.jcodec.containers.mxf.MXFDemuxer.MXFPacket;
import org.jcodec.containers.mxf.model.GenericDescriptor;
import org.jcodec.containers.mxf.model.GenericPictureEssenceDescriptor;
import org.jcodec.containers.mxf.model.GenericSoundEssenceDescriptor;
import org.jcodec.containers.mxf.model.KLV;
import org.jcodec.containers.mxf.model.TimelineTrack;
import org.jcodec.containers.mxf.model.UL;
import org.jcodec.movtool.streaming.AudioCodecMeta;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VideoCodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;
import org.jcodec.movtool.streaming.tracks.ByteChannelPool;

public class MXFVirtualTrack implements VirtualTrack {
    private UL essenceUL;
    private ByteChannelPool fp;
    private MXFDemuxerTrack track;

    public class MXFVirtualPacket implements VirtualPacket {
        private MXFPacket pkt;

        public MXFVirtualPacket(MXFPacket mXFPacket) {
            this.pkt = mXFPacket;
        }

        public ByteBuffer getData() throws IOException {
            ReadableByteChannel channel;
            Throwable th;
            ByteBuffer byteBuffer = null;
            try {
                channel = MXFVirtualTrack.this.fp.getChannel();
                try {
                    channel.position(this.pkt.getOffset());
                    KLV readKL = KLV.readKL(channel);
                    while (readKL != null && !MXFVirtualTrack.this.essenceUL.equals(readKL.key)) {
                        channel.position(channel.position() + readKL.len);
                        readKL = KLV.readKL(channel);
                    }
                    if (readKL != null && MXFVirtualTrack.this.essenceUL.equals(readKL.key)) {
                        byteBuffer = NIOUtils.fetchFrom(channel, (int) readKL.len);
                    }
                    NIOUtils.closeQuietly(channel);
                    return byteBuffer;
                } catch (Throwable th2) {
                    th = th2;
                    NIOUtils.closeQuietly(channel);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                channel = null;
                th = th4;
                NIOUtils.closeQuietly(channel);
                throw th;
            }
        }

        public int getDataLen() throws IOException {
            return this.pkt.getLen();
        }

        public double getPts() {
            return this.pkt.getPtsD();
        }

        public double getDuration() {
            return this.pkt.getDurationD();
        }

        public boolean isKeyframe() {
            return this.pkt.isKeyFrame();
        }

        public int getFrameNo() {
            return (int) this.pkt.getFrameNo();
        }
    }

    public static class PatchedMXFDemuxer extends MXFDemuxer {
        public PatchedMXFDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
            super(seekableByteChannel);
        }

        protected MXFDemuxerTrack createTrack(UL ul, TimelineTrack timelineTrack, GenericDescriptor genericDescriptor) throws IOException {
            return new MXFDemuxerTrack(this, ul, timelineTrack, genericDescriptor) {
                final /* synthetic */ PatchedMXFDemuxer f38980a;

                public MXFPacket readPacket(long j, int i, long j2, int i2, int i3, int i4, boolean z) throws IOException {
                    return new MXFPacket(null, j2, (long) i2, (long) i3, (long) i4, z, null, j, i);
                }
            };
        }
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public int getPreferredTimescale() {
        return -1;
    }

    public MXFVirtualTrack(MXFDemuxerTrack mXFDemuxerTrack, ByteChannelPool byteChannelPool) throws IOException {
        this.fp = byteChannelPool;
        this.track = mXFDemuxerTrack;
        this.essenceUL = mXFDemuxerTrack.getEssenceUL();
    }

    public static MXFDemuxer createDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        return new PatchedMXFDemuxer(seekableByteChannel);
    }

    public VirtualPacket nextPacket() throws IOException {
        MXFPacket mXFPacket = (MXFPacket) this.track.nextFrame();
        if (mXFPacket == null) {
            return null;
        }
        return new MXFVirtualPacket(mXFPacket);
    }

    public CodecMeta getCodecMeta() {
        return toSampleEntry(this.track.getDescriptor());
    }

    private CodecMeta toSampleEntry(GenericDescriptor genericDescriptor) {
        if (this.track.isVideo()) {
            GenericPictureEssenceDescriptor genericPictureEssenceDescriptor = (GenericPictureEssenceDescriptor) genericDescriptor;
            Rational aspectRatio = genericPictureEssenceDescriptor.getAspectRatio();
            return new VideoCodecMeta(MP4Util.getFourcc(this.track.getCodec().getCodec()), null, new Size(genericPictureEssenceDescriptor.getDisplayWidth(), genericPictureEssenceDescriptor.getDisplayHeight()), new Rational(((aspectRatio.getNum() * 1000) * genericPictureEssenceDescriptor.getDisplayHeight()) / (aspectRatio.getDen() * genericPictureEssenceDescriptor.getDisplayWidth()), 1000));
        } else if (this.track.isAudio()) {
            GenericSoundEssenceDescriptor genericSoundEssenceDescriptor = (GenericSoundEssenceDescriptor) genericDescriptor;
            int quantizationBits = genericSoundEssenceDescriptor.getQuantizationBits() >> 3;
            MXFCodecMapping codec = this.track.getCodec();
            Label[] labelArr = new Label[genericSoundEssenceDescriptor.getChannelCount()];
            Arrays.fill(labelArr, Label.Mono);
            return new AudioCodecMeta(quantizationBits == 3 ? "in24" : "sowt", quantizationBits, genericSoundEssenceDescriptor.getChannelCount(), (int) genericSoundEssenceDescriptor.getAudioSamplingRate().scalar(), codec == MXFCodecMapping.PCM_S16BE ? Endian.BIG_ENDIAN : Endian.LITTLE_ENDIAN, true, labelArr, null);
        } else {
            throw new RuntimeException("Can't get sample entry");
        }
    }

    public void close() {
        this.fp.close();
    }

    public int getTrackId() {
        return this.track.getTrackId();
    }
}
