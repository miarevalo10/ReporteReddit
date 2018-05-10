package org.jcodec.codecs.aac.blocks;

import org.jcodec.codecs.aac.ChannelPosition;
import org.jcodec.common.io.BitReader;

public class BlockPCE extends Block {
    private static final int MAX_ELEM_ID = 16;

    public static class ChannelMapping {
        ChannelPosition position;
        int someInt;
        RawDataBlockType syn_ele;
    }

    public void parse(BitReader bitReader) {
        BitReader bitReader2 = bitReader;
        bitReader2.readNBit(2);
        bitReader2.readNBit(4);
        int readNBit = bitReader2.readNBit(4);
        int readNBit2 = bitReader2.readNBit(4);
        int readNBit3 = bitReader2.readNBit(4);
        int readNBit4 = bitReader2.readNBit(2);
        int readNBit5 = bitReader2.readNBit(3);
        int readNBit6 = bitReader2.readNBit(4);
        if (bitReader.read1Bit() != 0) {
            bitReader2.readNBit(4);
        }
        if (bitReader.read1Bit() != 0) {
            bitReader2.readNBit(4);
        }
        if (bitReader.read1Bit() != 0) {
            bitReader2.readNBit(3);
        }
        ChannelMapping[] channelMappingArr = new ChannelMapping[64];
        BitReader bitReader3 = bitReader2;
        decodeChannelMap(channelMappingArr, 0, ChannelPosition.AAC_CHANNEL_FRONT, bitReader3, readNBit);
        decodeChannelMap(channelMappingArr, readNBit, ChannelPosition.AAC_CHANNEL_SIDE, bitReader3, readNBit2);
        readNBit += readNBit2;
        decodeChannelMap(channelMappingArr, readNBit, ChannelPosition.AAC_CHANNEL_BACK, bitReader3, readNBit3);
        readNBit += readNBit3;
        decodeChannelMap(channelMappingArr, readNBit, ChannelPosition.AAC_CHANNEL_LFE, bitReader3, readNBit4);
        int i = readNBit + readNBit4;
        bitReader2.skip(4 * readNBit5);
        decodeChannelMap(channelMappingArr, i, ChannelPosition.AAC_CHANNEL_CC, bitReader3, readNBit6);
        bitReader.align();
        bitReader2.skip(bitReader2.readNBit(8) * 8);
    }

    private void decodeChannelMap(ChannelMapping[] channelMappingArr, int i, ChannelPosition channelPosition, BitReader bitReader, int i2) {
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                i2 = 0;
                switch (channelPosition) {
                    case AAC_CHANNEL_FRONT:
                    case AAC_CHANNEL_BACK:
                    case AAC_CHANNEL_SIDE:
                        i2 = RawDataBlockType.fromOrdinal(bitReader.read1Bit());
                        break;
                    case AAC_CHANNEL_CC:
                        bitReader.read1Bit();
                        i2 = RawDataBlockType.TYPE_CCE;
                        break;
                    case AAC_CHANNEL_LFE:
                        i2 = RawDataBlockType.TYPE_LFE;
                        break;
                    default:
                        break;
                }
                channelMappingArr[i].syn_ele = i2;
                channelMappingArr[i].someInt = bitReader.readNBit(4);
                channelMappingArr[i].position = channelPosition;
                i++;
                i2 = i3;
            } else {
                return;
            }
        }
    }
}
