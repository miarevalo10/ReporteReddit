package org.jcodec.containers.mkv;

import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class SeekHeadFactory {
    List<SeekMock> f26811a = new ArrayList();
    long currentDataOffset = 0;

    public static class SeekMock {
        public long dataOffset;
        byte[] id;
        int seekPointerSize;
        int size;

        public static SeekMock make(EbmlBase ebmlBase) {
            SeekMock seekMock = new SeekMock();
            seekMock.id = ebmlBase.id;
            seekMock.size = (int) ebmlBase.size();
            return seekMock;
        }
    }

    public void add(EbmlBase ebmlBase) {
        ebmlBase = SeekMock.make(ebmlBase);
        ebmlBase.dataOffset = this.currentDataOffset;
        ebmlBase.seekPointerSize = EbmlUint.calculatePayloadSize(ebmlBase.dataOffset);
        this.currentDataOffset += (long) ebmlBase.size;
        this.f26811a.add(ebmlBase);
    }

    public EbmlMaster indexSeekHead() {
        int computeSeekHeadSize = computeSeekHeadSize();
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.SeekHead);
        for (SeekMock seekMock : this.f26811a) {
            EbmlMaster ebmlMaster2 = (EbmlMaster) MKVType.createByType(MKVType.Seek);
            EbmlBin ebmlBin = (EbmlBin) MKVType.createByType(MKVType.SeekID);
            ebmlBin.set(ByteBuffer.wrap(seekMock.id));
            ebmlMaster2.add(ebmlBin);
            EbmlUint ebmlUint = (EbmlUint) MKVType.createByType(MKVType.SeekPosition);
            ebmlUint.set(seekMock.dataOffset + ((long) computeSeekHeadSize));
            if (ebmlUint.data.limit() != seekMock.seekPointerSize) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder("estimated size of seekPosition differs from the one actually used. ElementId: ");
                stringBuilder.append(EbmlUtil.toHexString(seekMock.id));
                stringBuilder.append(" ");
                stringBuilder.append(ebmlUint.getData().limit());
                stringBuilder.append(" vs ");
                stringBuilder.append(seekMock.seekPointerSize);
                printStream.println(stringBuilder.toString());
            }
            ebmlMaster2.add(ebmlUint);
            ebmlMaster.add(ebmlMaster2);
        }
        ByteBuffer data = ebmlMaster.getData();
        if (data.limit() != computeSeekHeadSize) {
            PrintStream printStream2 = System.err;
            StringBuilder stringBuilder2 = new StringBuilder("estimated size of seekHead differs from the one actually used. ");
            stringBuilder2.append(data.limit());
            stringBuilder2.append(" vs ");
            stringBuilder2.append(computeSeekHeadSize);
            printStream2.println(stringBuilder2.toString());
        }
        return ebmlMaster;
    }

    public int computeSeekHeadSize() {
        int estimateSize = estimateSize();
        int i;
        do {
            i = 0;
            for (SeekMock seekMock : this.f26811a) {
                int calculatePayloadSize = EbmlUint.calculatePayloadSize(seekMock.dataOffset + ((long) estimateSize));
                if (calculatePayloadSize > seekMock.seekPointerSize) {
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder("Size ");
                    stringBuilder.append(estimateSize);
                    stringBuilder.append(" seems too small for element ");
                    stringBuilder.append(EbmlUtil.toHexString(seekMock.id));
                    stringBuilder.append(" increasing size by one.");
                    printStream.println(stringBuilder.toString());
                    seekMock.seekPointerSize++;
                    estimateSize++;
                    i = 1;
                    continue;
                    break;
                } else if (calculatePayloadSize < seekMock.seekPointerSize) {
                    throw new RuntimeException("Downsizing the index is not well thought through.");
                }
            }
        } while (i != 0);
        return estimateSize;
    }

    int estimateSize() {
        int i = 1;
        int length = (MKVType.SeekHead.id.length + 1) + estimeteSeekSize(((SeekMock) this.f26811a.get(0)).id.length, 1);
        while (i < this.f26811a.size()) {
            length += estimeteSeekSize(((SeekMock) this.f26811a.get(i)).id.length, ((SeekMock) this.f26811a.get(i)).seekPointerSize);
            i++;
        }
        return length;
    }

    public static int estimeteSeekSize(int i, int i2) {
        int length = (MKVType.SeekID.id.length + EbmlUtil.ebmlLength((long) i)) + i;
        i = (MKVType.SeekPosition.id.length + EbmlUtil.ebmlLength((long) i2)) + i2;
        return ((MKVType.Seek.id.length + EbmlUtil.ebmlLength((long) (length + i))) + length) + i;
    }
}
