package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.codecs.pcmdvd.PCMDVDDecoder;
import org.jcodec.common.AudioFormat;
import org.jcodec.containers.mp4.boxes.channel.Label;
import org.jcodec.containers.mp4.muxer.MP4Muxer;
import org.jcodec.movtool.streaming.AudioCodecMeta;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class PCMDVDTrack implements VirtualTrack {
    private PCMDVDDecoder decoder = new PCMDVDDecoder();
    private AudioFormat format;
    private int nFrames;
    private VirtualPacket prevPkt;
    private VirtualTrack src;

    private class PCMDVDPkt extends VirtualPacketWrapper {
        final /* synthetic */ PCMDVDTrack f36215a;

        public PCMDVDPkt(PCMDVDTrack pCMDVDTrack, VirtualPacket virtualPacket) {
            this.f36215a = pCMDVDTrack;
            super(virtualPacket);
        }

        public ByteBuffer getData() throws IOException {
            ByteBuffer data = super.getData();
            return this.f36215a.decoder.decodeFrame(data, data).getData();
        }

        public int getDataLen() throws IOException {
            return (this.f36215a.nFrames * this.f36215a.format.getChannels()) << 1;
        }
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public PCMDVDTrack(VirtualTrack virtualTrack) throws IOException {
        this.src = virtualTrack;
        this.prevPkt = virtualTrack.nextPacket();
        if (this.prevPkt != null) {
            virtualTrack = this.decoder.decodeFrame(this.prevPkt.getData(), ByteBuffer.allocate(this.prevPkt.getData().remaining()));
            this.format = virtualTrack.getFormat();
            this.nFrames = virtualTrack.getNFrames();
        }
    }

    public VirtualPacket nextPacket() throws IOException {
        if (this.prevPkt == null) {
            return null;
        }
        VirtualPacket virtualPacket = this.prevPkt;
        this.prevPkt = this.src.nextPacket();
        return new PCMDVDPkt(this, virtualPacket);
    }

    public CodecMeta getCodecMeta() {
        return new AudioCodecMeta(MP4Muxer.lookupFourcc(this.format), ByteBuffer.allocate(0), this.format, true, new Label[]{Label.Left, Label.Right});
    }

    public int getPreferredTimescale() {
        return this.format.getSampleRate();
    }

    public void close() throws IOException {
        this.src.close();
    }
}
