package org.jcodec.codecs.aac.blocks;

import org.jcodec.common.io.BitReader;

public class BlockCPE extends BlockICS {
    private int[] ms_mask;

    public void parse(BitReader bitReader) {
        if (bitReader.read1Bit() != 0) {
            parseICSInfo(bitReader);
            int readNBit = bitReader.readNBit(2);
            if (readNBit == 3) {
                throw new RuntimeException("ms_present = 3 is reserved.");
            } else if (readNBit != 0) {
                decodeMidSideStereo(bitReader, readNBit, 0, 0);
            }
        }
        new BlockICS().parse(bitReader);
        new BlockICS().parse(bitReader);
    }

    private void decodeMidSideStereo(BitReader bitReader, int i, int i2, int i3) {
        if (i == 1) {
            for (i = 0; i < i2 * i3; i++) {
                this.ms_mask[i] = bitReader.read1Bit();
            }
        }
    }
}
