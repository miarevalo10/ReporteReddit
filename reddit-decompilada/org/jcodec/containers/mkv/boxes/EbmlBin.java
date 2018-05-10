package org.jcodec.containers.mkv.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class EbmlBin extends EbmlBase {
    public ByteBuffer data;
    protected boolean dataRead = false;

    public EbmlBin(byte[] bArr) {
        this.id = bArr;
    }

    public void read(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(this.dataLen);
        seekableByteChannel.read(allocate);
        allocate.flip();
        read(allocate);
    }

    public void read(ByteBuffer byteBuffer) {
        this.data = byteBuffer.slice();
        this.data.limit(this.dataLen);
        this.dataRead = true;
    }

    public void skip(ByteBuffer byteBuffer) {
        if (!this.dataRead) {
            byteBuffer.position((int) (this.dataOffset + ((long) this.dataLen)));
            this.dataRead = true;
        }
    }

    public long size() {
        if (this.data != null) {
            if (this.data.limit() != 0) {
                return (((long) this.data.limit()) + ((long) EbmlUtil.ebmlLength((long) this.data.limit()))) + ((long) this.id.length);
            }
        }
        return super.size();
    }

    public void set(ByteBuffer byteBuffer) {
        this.data = byteBuffer.slice();
        this.dataLen = this.data.limit();
    }

    public ByteBuffer getData() {
        int ebmlLength = EbmlUtil.ebmlLength((long) this.data.limit());
        byte[] ebmlEncode = EbmlUtil.ebmlEncode((long) this.data.limit(), ebmlLength);
        ByteBuffer allocate = ByteBuffer.allocate((this.id.length + ebmlLength) + this.data.limit());
        allocate.put(this.id);
        allocate.put(ebmlEncode);
        allocate.put(this.data);
        allocate.flip();
        this.data.flip();
        return allocate;
    }
}
