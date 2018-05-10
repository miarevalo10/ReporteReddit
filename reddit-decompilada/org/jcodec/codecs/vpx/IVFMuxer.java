package org.jcodec.codecs.vpx;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.common.model.Packet;

public class IVFMuxer {
    private SeekableByteChannel ch;
    private int nFrames;

    public IVFMuxer(SeekableByteChannel seekableByteChannel, int i, int i2, int i3) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(32);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) 68);
        allocate.put((byte) 75);
        allocate.put((byte) 73);
        allocate.put((byte) 70);
        allocate.putShort((short) 0);
        allocate.putShort((short) 32);
        allocate.putInt(808996950);
        allocate.putShort((short) i);
        allocate.putShort((short) i2);
        allocate.putInt(i3);
        allocate.putInt(1);
        allocate.putInt(1);
        allocate.clear();
        seekableByteChannel.write(allocate);
        this.ch = seekableByteChannel;
    }

    public void addFrame(Packet packet) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        packet = packet.getData();
        allocate.putInt(packet.remaining());
        allocate.putLong((long) this.nFrames);
        allocate.clear();
        this.ch.write(allocate);
        this.ch.write(packet);
        this.nFrames++;
    }

    public void close() throws IOException {
        this.ch.position(24);
        NIOUtils.writeIntLE(this.ch, this.nFrames);
    }
}
