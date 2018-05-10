package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class PictureTemporalScalableExtension implements MPEGHeader {
    public int backward_temporal_reference;
    public int forward_temporal_reference;
    public int reference_select_code;

    public static PictureTemporalScalableExtension read(BitReader bitReader) {
        PictureTemporalScalableExtension pictureTemporalScalableExtension = new PictureTemporalScalableExtension();
        pictureTemporalScalableExtension.reference_select_code = bitReader.readNBit(2);
        pictureTemporalScalableExtension.forward_temporal_reference = bitReader.readNBit(10);
        bitReader.read1Bit();
        pictureTemporalScalableExtension.backward_temporal_reference = bitReader.readNBit(10);
        return pictureTemporalScalableExtension;
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(16, 4);
        bitWriter.writeNBit(this.reference_select_code, 2);
        bitWriter.writeNBit(this.forward_temporal_reference, 10);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.backward_temporal_reference, 10);
        bitWriter.flush();
    }
}
