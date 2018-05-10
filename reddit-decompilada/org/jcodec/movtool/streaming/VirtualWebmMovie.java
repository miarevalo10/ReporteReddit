package org.jcodec.movtool.streaming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.containers.mkv.MKVStreamingMuxer;

public class VirtualWebmMovie extends VirtualMovie {
    private MKVStreamingMuxer muxer;

    public VirtualWebmMovie(VirtualTrack... virtualTrackArr) throws IOException {
        super(virtualTrackArr);
        this.muxer = null;
        this.muxer = new MKVStreamingMuxer();
        muxTracks();
    }

    protected void muxTracks() throws IOException {
        List arrayList = new ArrayList();
        long j = 0;
        VirtualPacket[] virtualPacketArr = new VirtualPacket[this.tracks.length];
        VirtualPacket[] virtualPacketArr2 = new VirtualPacket[this.tracks.length];
        int i = 1;
        while (true) {
            int i2 = 0;
            int i3 = -1;
            while (i2 < virtualPacketArr.length) {
                if (virtualPacketArr[i2] == null) {
                    virtualPacketArr[i2] = this.tracks[i2].nextPacket();
                    if (virtualPacketArr[i2] == null) {
                        i2++;
                    }
                }
                if (i3 == -1 || virtualPacketArr[i2].getPts() < virtualPacketArr[i3].getPts()) {
                    i3 = i2;
                    i2++;
                } else {
                    i2++;
                }
            }
            if (i3 != -1) {
                MovieSegment packetChunk = packetChunk(this.tracks[i3], virtualPacketArr[i3], i, i3, j);
                arrayList.add(packetChunk);
                j += (long) packetChunk.getDataLen();
                virtualPacketArr2[i3] = virtualPacketArr[i3];
                virtualPacketArr[i3] = this.tracks[i3].nextPacket();
                i++;
            } else {
                this.headerChunk = headerChunk(arrayList, this.tracks, this.size);
                this.size += ((long) this.headerChunk.getDataLen()) + j;
                this.chunks = (MovieSegment[]) arrayList.toArray(new MovieSegment[0]);
                return;
            }
        }
    }

    protected MovieSegment packetChunk(VirtualTrack virtualTrack, VirtualPacket virtualPacket, int i, int i2, long j) {
        return this.muxer.preparePacket(virtualTrack, virtualPacket, i, i2, j);
    }

    protected MovieSegment headerChunk(List<MovieSegment> list, VirtualTrack[] virtualTrackArr, long j) throws IOException {
        return this.muxer.prepareHeader(list, virtualTrackArr);
    }
}
