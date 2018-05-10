package org.jcodec.movtool.streaming.tracks;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.movtool.streaming.VirtualPacket;

public class VirtualPacketWrapper implements VirtualPacket {
    protected VirtualPacket src;

    public VirtualPacketWrapper(VirtualPacket virtualPacket) {
        this.src = virtualPacket;
    }

    public ByteBuffer getData() throws IOException {
        return this.src.getData();
    }

    public int getDataLen() throws IOException {
        return this.src.getDataLen();
    }

    public double getPts() {
        return this.src.getPts();
    }

    public double getDuration() {
        return this.src.getDuration();
    }

    public boolean isKeyframe() {
        return this.src.isKeyframe();
    }

    public int getFrameNo() {
        return this.src.getFrameNo();
    }
}
