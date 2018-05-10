package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class CopyrightExtension implements MPEGHeader {
    public int copyright_flag;
    public int copyright_identifier;
    public int copyright_number_1;
    public int copyright_number_2;
    public int copyright_number_3;
    public int original_or_copy;

    public static CopyrightExtension read(BitReader bitReader) {
        CopyrightExtension copyrightExtension = new CopyrightExtension();
        copyrightExtension.copyright_flag = bitReader.read1Bit();
        copyrightExtension.copyright_identifier = bitReader.readNBit(8);
        copyrightExtension.original_or_copy = bitReader.read1Bit();
        bitReader.skip(7);
        bitReader.read1Bit();
        copyrightExtension.copyright_number_1 = bitReader.readNBit(20);
        bitReader.read1Bit();
        copyrightExtension.copyright_number_2 = bitReader.readNBit(22);
        bitReader.read1Bit();
        copyrightExtension.copyright_number_3 = bitReader.readNBit(22);
        return copyrightExtension;
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(4, 4);
        bitWriter.write1Bit(this.copyright_flag);
        bitWriter.writeNBit(this.copyright_identifier, 8);
        bitWriter.write1Bit(this.original_or_copy);
        bitWriter.writeNBit(null, 7);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.copyright_number_1, 20);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.copyright_number_2, 22);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.copyright_number_3, 22);
        bitWriter.flush();
    }
}
