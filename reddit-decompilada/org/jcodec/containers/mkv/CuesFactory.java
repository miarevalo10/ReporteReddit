package org.jcodec.containers.mkv;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class CuesFactory {
    List<CuePointMock> f26810a = new ArrayList();
    private long currentDataOffset = 0;
    private final long offsetBase;
    private long videoTrackNr;

    public static class CuePointMock {
        public int cueClusterPositionSize;
        public long elementOffset;
        private byte[] id;
        private long size;
        private long timecode;

        public static CuePointMock make(EbmlMaster ebmlMaster) {
            return make(ebmlMaster.id, ((EbmlUint) MKVType.findFirst((EbmlBase) ebmlMaster, MKVType.Cluster, MKVType.Timecode)).get(), ebmlMaster.size());
        }

        public static CuePointMock make(byte[] bArr, long j, long j2) {
            CuePointMock cuePointMock = new CuePointMock();
            cuePointMock.id = bArr;
            cuePointMock.timecode = j;
            cuePointMock.size = j2;
            return cuePointMock;
        }
    }

    public CuesFactory(long j, long j2) {
        this.offsetBase = j;
        this.videoTrackNr = j2;
        this.currentDataOffset += this.offsetBase;
    }

    public void addFixedSize(CuePointMock cuePointMock) {
        cuePointMock.elementOffset = this.currentDataOffset;
        cuePointMock.cueClusterPositionSize = 8;
        this.currentDataOffset += cuePointMock.size;
        this.f26810a.add(cuePointMock);
    }

    public void add(CuePointMock cuePointMock) {
        cuePointMock.elementOffset = this.currentDataOffset;
        cuePointMock.cueClusterPositionSize = EbmlUint.calculatePayloadSize(cuePointMock.elementOffset);
        this.currentDataOffset += cuePointMock.size;
        this.f26810a.add(cuePointMock);
    }

    public EbmlMaster createCues() {
        int computeCuesSize = computeCuesSize();
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Cues);
        for (CuePointMock cuePointMock : this.f26810a) {
            EbmlMaster ebmlMaster2 = (EbmlMaster) MKVType.createByType(MKVType.CuePoint);
            EbmlUint ebmlUint = (EbmlUint) MKVType.createByType(MKVType.CueTime);
            ebmlUint.set(cuePointMock.timecode);
            ebmlMaster2.add(ebmlUint);
            EbmlMaster ebmlMaster3 = (EbmlMaster) MKVType.createByType(MKVType.CueTrackPositions);
            EbmlUint ebmlUint2 = (EbmlUint) MKVType.createByType(MKVType.CueTrack);
            ebmlUint2.set(this.videoTrackNr);
            ebmlMaster3.add(ebmlUint2);
            ebmlUint2 = (EbmlUint) MKVType.createByType(MKVType.CueClusterPosition);
            ebmlUint2.set(cuePointMock.elementOffset + ((long) computeCuesSize));
            if (ebmlUint2.data.limit() != cuePointMock.cueClusterPositionSize) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder("estimated size of CueClusterPosition differs from the one actually used. ElementId: ");
                stringBuilder.append(EbmlUtil.toHexString(cuePointMock.id));
                stringBuilder.append(" ");
                stringBuilder.append(ebmlUint2.getData().limit());
                stringBuilder.append(" vs ");
                stringBuilder.append(cuePointMock.cueClusterPositionSize);
                printStream.println(stringBuilder.toString());
            }
            ebmlMaster3.add(ebmlUint2);
            ebmlMaster2.add(ebmlMaster3);
            ebmlMaster.add(ebmlMaster2);
        }
        return ebmlMaster;
    }

    public int computeCuesSize() {
        int estimateSize = estimateSize();
        int i;
        do {
            i = 0;
            for (CuePointMock cuePointMock : this.f26810a) {
                int calculatePayloadSize = EbmlUint.calculatePayloadSize(cuePointMock.elementOffset + ((long) estimateSize));
                if (calculatePayloadSize > cuePointMock.cueClusterPositionSize) {
                    PrintStream printStream = System.err;
                    StringBuilder stringBuilder = new StringBuilder("Size ");
                    stringBuilder.append(estimateSize);
                    stringBuilder.append(" seems too small for element ");
                    stringBuilder.append(EbmlUtil.toHexString(cuePointMock.id));
                    stringBuilder.append(" increasing size by one.");
                    printStream.println(stringBuilder.toString());
                    cuePointMock.cueClusterPositionSize++;
                    estimateSize++;
                    i = 1;
                    continue;
                    break;
                } else if (calculatePayloadSize < cuePointMock.cueClusterPositionSize) {
                    throw new RuntimeException("Downsizing the index is not well thought through");
                }
            }
        } while (i != 0);
        return estimateSize;
    }

    public int estimateFixedSize(int i) {
        int i2 = 34 * i;
        return i2 + (MKVType.Cues.id.length + EbmlUtil.ebmlLength((long) i2));
    }

    public int estimateSize() {
        int i = 0;
        for (CuePointMock cuePointMock : this.f26810a) {
            i += estimateCuePointSize(EbmlUint.calculatePayloadSize(cuePointMock.timecode), EbmlUint.calculatePayloadSize(this.videoTrackNr), EbmlUint.calculatePayloadSize(cuePointMock.elementOffset));
        }
        return i + (MKVType.Cues.id.length + EbmlUtil.ebmlLength((long) i));
    }

    public static int estimateCuePointSize(int i, int i2, int i3) {
        int length = (MKVType.CueTime.id.length + EbmlUtil.ebmlLength((long) i)) + i;
        i = ((((MKVType.CueTrack.id.length + EbmlUtil.ebmlLength((long) i2)) + i2) + MKVType.CueClusterPosition.id.length) + EbmlUtil.ebmlLength((long) i3)) + i3;
        i += MKVType.CueTrackPositions.id.length + EbmlUtil.ebmlLength((long) i);
        return ((MKVType.CuePoint.id.length + EbmlUtil.ebmlLength((long) (length + i))) + length) + i;
    }
}
