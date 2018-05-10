package org.jcodec.codecs.aac;

import org.jcodec.codecs.aac.blocks.Block;
import org.jcodec.common.io.BitReader;

public class BlockReader {
    public Block nextBlock(BitReader bitReader) {
        if (BlockType.fromCode((long) bitReader.readNBit(3)) == BlockType.TYPE_END) {
            return null;
        }
        bitReader.readNBit(4);
        return null;
    }
}
