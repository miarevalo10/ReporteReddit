package org.jcodec.containers.mkv.boxes;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class EbmlMaster extends EbmlBase {
    public final ArrayList<EbmlBase> children = new ArrayList();
    protected long usedSize;

    public EbmlMaster(byte[] bArr) {
        this.id = bArr;
    }

    public void add(EbmlBase ebmlBase) {
        if (ebmlBase != null) {
            ebmlBase.parent = this;
            this.children.add(ebmlBase);
        }
    }

    public ByteBuffer getData() {
        long dataLen = getDataLen();
        if (dataLen > 2147483647L) {
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder("EbmlMaster.getData: id.length ");
            stringBuilder.append(this.id.length);
            stringBuilder.append("  EbmlUtil.ebmlLength(");
            stringBuilder.append(dataLen);
            stringBuilder.append("): ");
            stringBuilder.append(EbmlUtil.ebmlLength(dataLen));
            stringBuilder.append(" size: ");
            stringBuilder.append(dataLen);
            printStream.println(stringBuilder.toString());
        }
        ByteBuffer allocate = ByteBuffer.allocate((int) (((long) (this.id.length + EbmlUtil.ebmlLength(dataLen))) + dataLen));
        allocate.put(this.id);
        allocate.put(EbmlUtil.ebmlEncode(dataLen));
        for (int i = 0; i < this.children.size(); i++) {
            allocate.put(((EbmlBase) this.children.get(i)).getData());
        }
        allocate.flip();
        return allocate;
    }

    protected long getDataLen() {
        if (this.children != null) {
            if (!this.children.isEmpty()) {
                long j = 0;
                Iterator it = this.children.iterator();
                while (it.hasNext()) {
                    j += ((EbmlBase) it.next()).size();
                }
                return j;
            }
        }
        return (long) this.dataLen;
    }

    public long size() {
        long dataLen = getDataLen();
        return (dataLen + ((long) EbmlUtil.ebmlLength(dataLen))) + ((long) this.id.length);
    }
}
