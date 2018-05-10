package org.jcodec.containers.mkv.boxes;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class MkvSegment extends EbmlMaster {
    int headerSize = 0;

    public MkvSegment(byte[] bArr) {
        super(bArr);
    }

    public MkvSegment() {
        super(MKVType.Segment.id);
    }

    public ByteBuffer getHeader() {
        long headerSize = getHeaderSize();
        if (headerSize > 2147483647L) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder("MkvSegment.getHeader: id.length ");
            stringBuilder.append(this.id.length);
            stringBuilder.append("  Element.getEbmlSize(");
            stringBuilder.append(this.dataLen);
            stringBuilder.append("): ");
            stringBuilder.append(EbmlUtil.ebmlLength((long) this.dataLen));
            stringBuilder.append(" size: ");
            stringBuilder.append(this.dataLen);
            printStream.println(stringBuilder.toString());
        }
        ByteBuffer allocate = ByteBuffer.allocate((int) headerSize);
        allocate.put(this.id);
        allocate.put(EbmlUtil.ebmlEncode(getDataLen()));
        if (!(this.children == null || this.children.isEmpty())) {
            Iterator it = this.children.iterator();
            while (it.hasNext()) {
                EbmlBase ebmlBase = (EbmlBase) it.next();
                if (!MKVType.Cluster.equals(ebmlBase.type)) {
                    allocate.put(ebmlBase.getData());
                }
            }
        }
        allocate.flip();
        return allocate;
    }

    public long getHeaderSize() {
        long length = ((long) this.id.length) + ((long) EbmlUtil.ebmlLength(getDataLen()));
        if (!(this.children == null || this.children.isEmpty())) {
            Iterator it = this.children.iterator();
            while (it.hasNext()) {
                EbmlBase ebmlBase = (EbmlBase) it.next();
                if (!MKVType.Cluster.equals(ebmlBase.type)) {
                    length += ebmlBase.size();
                }
            }
        }
        return length;
    }
}
