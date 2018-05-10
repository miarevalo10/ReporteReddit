package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.AudioFormat;
import org.jcodec.containers.mp4.boxes.EndianBox.Endian;
import org.jcodec.containers.mp4.boxes.channel.Label;
import org.jcodec.movtool.streaming.AudioCodecMeta;
import org.jcodec.movtool.streaming.CodecMeta;
import org.jcodec.movtool.streaming.VirtualPacket;
import org.jcodec.movtool.streaming.VirtualTrack;
import org.jcodec.movtool.streaming.VirtualTrack.VirtualEdit;

public class StereoDownmixTrack implements VirtualTrack {
    private static final int FRAMES_IN_OUT_PACKET = 20480;
    private DownmixHelper downmix;
    private int frameNo;
    private int rate = -1;
    private AudioCodecMeta[] sampleEntries;
    private boolean[][] solo;
    private VirtualTrack[] sources;

    protected class DownmixVirtualPacket implements VirtualPacket {
        private int frameNo;
        private VirtualPacket[] packets;

        public int getDataLen() {
            return 81920;
        }

        public boolean isKeyframe() {
            return true;
        }

        public DownmixVirtualPacket(VirtualPacket[] virtualPacketArr, int i) {
            this.packets = virtualPacketArr;
            this.frameNo = i;
        }

        public ByteBuffer getData() throws IOException {
            ByteBuffer[] byteBufferArr = new ByteBuffer[this.packets.length];
            for (int i = 0; i < byteBufferArr.length; i++) {
                byteBufferArr[i] = this.packets[i] == null ? null : this.packets[i].getData();
            }
            ByteBuffer allocate = ByteBuffer.allocate(81920);
            StereoDownmixTrack.this.downmix.downmix(byteBufferArr, allocate);
            return allocate;
        }

        public double getPts() {
            return ((double) this.frameNo) / ((double) StereoDownmixTrack.this.rate);
        }

        public double getDuration() {
            return 20480.0d / ((double) StereoDownmixTrack.this.rate);
        }

        public int getFrameNo() {
            return this.frameNo;
        }
    }

    public VirtualEdit[] getEdits() {
        return null;
    }

    public StereoDownmixTrack(VirtualTrack... virtualTrackArr) {
        int i = 0;
        this.sources = new VirtualTrack[virtualTrackArr.length];
        this.sampleEntries = new AudioCodecMeta[this.sources.length];
        this.solo = new boolean[virtualTrackArr.length][];
        while (i < virtualTrackArr.length) {
            CodecMeta codecMeta = virtualTrackArr[i].getCodecMeta();
            if (codecMeta instanceof AudioCodecMeta) {
                AudioCodecMeta audioCodecMeta = (AudioCodecMeta) codecMeta;
                if (audioCodecMeta.isPCM()) {
                    AudioFormat format = audioCodecMeta.getFormat();
                    if (this.rate == -1 || this.rate == format.getFrameRate()) {
                        this.rate = format.getFrameRate();
                        this.sampleEntries[i] = audioCodecMeta;
                        this.sources[i] = new PCMFlatternTrack(virtualTrackArr[i], FRAMES_IN_OUT_PACKET);
                        this.solo[i] = new boolean[format.getChannels()];
                        i++;
                    } else {
                        throw new IllegalArgumentException("Can not downmix tracks of different rate.");
                    }
                }
                throw new IllegalArgumentException("Non PCM audio track.");
            }
            throw new IllegalArgumentException("Non audio track");
        }
        this.downmix = new DownmixHelper(this.sampleEntries, FRAMES_IN_OUT_PACKET, null);
    }

    public void soloTrack(int i, boolean z) {
        for (int i2 = 0; i2 < this.solo[i].length; i2++) {
            this.solo[i][i2] = z;
        }
        this.downmix = new DownmixHelper(this.sampleEntries, FRAMES_IN_OUT_PACKET, this.solo);
    }

    public void soloChannel(int i, int i2, boolean z) {
        this.solo[i][i2] = z;
        this.downmix = new DownmixHelper(this.sampleEntries, FRAMES_IN_OUT_PACKET, this.solo);
    }

    public boolean isChannelMute(int i, int i2) {
        return this.solo[i][i2];
    }

    public boolean[][] bulkGetSolo() {
        return this.solo;
    }

    public void soloAll() {
        for (int i = 0; i < this.solo.length; i++) {
            for (int i2 = 0; i2 < this.solo[i].length; i2++) {
                this.solo[i][i2] = true;
            }
        }
    }

    public void muteAll() {
        for (int i = 0; i < this.solo.length; i++) {
            for (int i2 = 0; i2 < this.solo[i].length; i2++) {
                this.solo[i][i2] = false;
            }
        }
    }

    public void bulkSetSolo(boolean[][] zArr) {
        this.solo = zArr;
        this.downmix = new DownmixHelper(this.sampleEntries, FRAMES_IN_OUT_PACKET, zArr);
    }

    public VirtualPacket nextPacket() throws IOException {
        VirtualPacket[] virtualPacketArr = new VirtualPacket[this.sources.length];
        int i = 1;
        for (int i2 = 0; i2 < virtualPacketArr.length; i2++) {
            virtualPacketArr[i2] = this.sources[i2].nextPacket();
            i &= virtualPacketArr[i2] == null ? 1 : 0;
        }
        if (i != 0) {
            return null;
        }
        VirtualPacket downmixVirtualPacket = new DownmixVirtualPacket(virtualPacketArr, this.frameNo);
        this.frameNo += FRAMES_IN_OUT_PACKET;
        return downmixVirtualPacket;
    }

    public CodecMeta getCodecMeta() {
        return new AudioCodecMeta("sowt", 2, 2, this.rate, Endian.LITTLE_ENDIAN, true, new Label[]{Label.Left, Label.Right}, null);
    }

    public void close() throws IOException {
        for (VirtualTrack close : this.sources) {
            close.close();
        }
    }

    public int getPreferredTimescale() {
        return this.rate;
    }
}
