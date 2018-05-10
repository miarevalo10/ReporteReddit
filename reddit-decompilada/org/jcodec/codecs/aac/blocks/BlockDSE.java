package org.jcodec.codecs.aac.blocks;

import org.jcodec.common.io.BitReader;

public class BlockDSE extends Block {
    public void parse(BitReader bitReader) {
        bitReader.readNBit(4);
        int read1Bit = bitReader.read1Bit();
        int readNBit = bitReader.readNBit(8);
        if (readNBit == 255) {
            readNBit += bitReader.readNBit(8);
        }
        if (read1Bit != 0) {
            bitReader.align();
        }
        int i = 8 * readNBit;
        if (bitReader.skip(i) != i) {
            throw new RuntimeException("Overread");
        }
    }
}
