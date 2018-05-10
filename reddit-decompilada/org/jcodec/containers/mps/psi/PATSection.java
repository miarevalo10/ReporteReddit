package org.jcodec.containers.mps.psi;

import java.nio.ByteBuffer;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.IntIntMap;

public class PATSection extends PSISection {
    private int[] networkPids;
    private IntIntMap programs;

    public PATSection(PSISection pSISection, int[] iArr, IntIntMap intIntMap) {
        super(pSISection);
        this.networkPids = iArr;
        this.programs = intIntMap;
    }

    public int[] getNetworkPids() {
        return this.networkPids;
    }

    public IntIntMap getPrograms() {
        return this.programs;
    }

    public static PATSection parse(ByteBuffer byteBuffer) {
        PSISection parse = PSISection.parse(byteBuffer);
        IntArrayList intArrayList = new IntArrayList();
        IntIntMap intIntMap = new IntIntMap();
        while (byteBuffer.remaining() > 4) {
            int i = byteBuffer.getShort() & 65535;
            int i2 = byteBuffer.getShort() & 8191;
            if (i == 0) {
                intArrayList.add(i2);
            } else {
                intIntMap.put(i, i2);
            }
        }
        return new PATSection(parse, intArrayList.toArray(), intIntMap);
    }
}
