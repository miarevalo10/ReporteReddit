package org.jcodec.movtool.streaming;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import org.jcodec.containers.mp4.Brand;

public class VirtualMP4Movie extends VirtualMovie {
    private Brand brand;

    public class PacketChunk implements MovieSegment {
        private String fourcc;
        private int no;
        private VirtualPacket packet;
        private long pos;
        private int track;

        public PacketChunk(VirtualPacket virtualPacket, int i, int i2, long j, String str) {
            this.packet = virtualPacket;
            this.track = i;
            this.no = i2;
            this.pos = j;
            this.fourcc = str;
        }

        public ByteBuffer getData() throws IOException {
            return this.packet.getData().duplicate();
        }

        public int getNo() {
            return this.no;
        }

        public long getPos() {
            return this.pos;
        }

        public void offset(int i) {
            this.pos += (long) i;
        }

        public int getDataLen() throws IOException {
            return this.packet.getDataLen();
        }

        public VirtualPacket getPacket() {
            return this.packet;
        }

        public int getTrackNo() {
            return this.track;
        }
    }

    public VirtualMP4Movie(VirtualTrack... virtualTrackArr) throws IOException {
        this(Brand.MP4, virtualTrackArr);
    }

    public VirtualMP4Movie(Brand brand, VirtualTrack... virtualTrackArr) throws IOException {
        super(virtualTrackArr);
        this.brand = brand;
        muxTracks();
    }

    protected MovieSegment headerChunk(List<MovieSegment> list, VirtualTrack[] virtualTrackArr, long j) throws IOException {
        int i = 0;
        PacketChunk[] packetChunkArr = (PacketChunk[]) list.toArray(new PacketChunk[0]);
        int remaining = MovieHelper.produceHeader(packetChunkArr, virtualTrackArr, j, this.brand).remaining();
        int length = packetChunkArr.length;
        while (i < length) {
            packetChunkArr[i].offset(remaining);
            i++;
        }
        list = MovieHelper.produceHeader(packetChunkArr, virtualTrackArr, j, this.brand);
        return new MovieSegment(this) {
            final /* synthetic */ VirtualMP4Movie f33312b;

            public int getNo() {
                return 0;
            }

            public long getPos() {
                return 0;
            }

            public ByteBuffer getData() {
                return list.duplicate();
            }

            public int getDataLen() {
                return list.remaining();
            }
        };
    }

    protected MovieSegment packetChunk(VirtualTrack virtualTrack, VirtualPacket virtualPacket, int i, int i2, long j) {
        return new PacketChunk(virtualPacket, i2, i, j, virtualTrack.getCodecMeta().getFourcc());
    }
}
