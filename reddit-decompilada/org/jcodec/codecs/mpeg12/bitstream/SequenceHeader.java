package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class SequenceHeader implements MPEGHeader {
    public static final int Sequence_Display_Extension = 2;
    public static final int Sequence_Extension = 1;
    public static final int Sequence_Scalable_Extension = 5;
    private static boolean hasExtensions;
    public int aspect_ratio_information;
    public int bit_rate;
    public int constrained_parameters_flag;
    public int frame_rate_code;
    public int horizontal_size;
    public int[] intra_quantiser_matrix;
    public int[] non_intra_quantiser_matrix;
    public SequenceDisplayExtension sequenceDisplayExtension;
    public SequenceExtension sequenceExtension;
    public SequenceScalableExtension sequenceScalableExtension;
    public int vbv_buffer_size_value;
    public int vertical_size;

    public SequenceHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        this.horizontal_size = i;
        this.vertical_size = i2;
        this.aspect_ratio_information = i3;
        this.frame_rate_code = i4;
        this.bit_rate = i5;
        this.vbv_buffer_size_value = i6;
        this.constrained_parameters_flag = i7;
        this.intra_quantiser_matrix = iArr;
        this.non_intra_quantiser_matrix = iArr2;
    }

    private SequenceHeader() {
    }

    public static SequenceHeader read(ByteBuffer byteBuffer) {
        BitReader bitReader = new BitReader(byteBuffer);
        byteBuffer = new SequenceHeader();
        byteBuffer.horizontal_size = bitReader.readNBit(12);
        byteBuffer.vertical_size = bitReader.readNBit(12);
        byteBuffer.aspect_ratio_information = bitReader.readNBit(4);
        byteBuffer.frame_rate_code = bitReader.readNBit(4);
        byteBuffer.bit_rate = bitReader.readNBit(18);
        bitReader.read1Bit();
        byteBuffer.vbv_buffer_size_value = bitReader.readNBit(10);
        byteBuffer.constrained_parameters_flag = bitReader.read1Bit();
        int i = 0;
        if (bitReader.read1Bit() != 0) {
            byteBuffer.intra_quantiser_matrix = new int[64];
            for (int i2 = 0; i2 < 64; i2++) {
                byteBuffer.intra_quantiser_matrix[i2] = bitReader.readNBit(8);
            }
        }
        if (bitReader.read1Bit() != 0) {
            byteBuffer.non_intra_quantiser_matrix = new int[64];
            while (i < 64) {
                byteBuffer.non_intra_quantiser_matrix[i] = bitReader.readNBit(8);
                i++;
            }
        }
        return byteBuffer;
    }

    public static void readExtension(ByteBuffer byteBuffer, SequenceHeader sequenceHeader) {
        hasExtensions = true;
        BitReader bitReader = new BitReader(byteBuffer);
        byteBuffer = bitReader.readNBit(4);
        if (byteBuffer != 5) {
            switch (byteBuffer) {
                case 1:
                    sequenceHeader.sequenceExtension = SequenceExtension.read(bitReader);
                    return;
                case 2:
                    sequenceHeader.sequenceDisplayExtension = SequenceDisplayExtension.read(bitReader);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Unsupported extension: ");
                    stringBuilder.append(byteBuffer);
                    throw new RuntimeException(stringBuilder.toString());
            }
        }
        sequenceHeader.sequenceScalableExtension = SequenceScalableExtension.read(bitReader);
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(this.horizontal_size, 12);
        bitWriter.writeNBit(this.vertical_size, 12);
        bitWriter.writeNBit(this.aspect_ratio_information, 4);
        bitWriter.writeNBit(this.frame_rate_code, 4);
        bitWriter.writeNBit(this.bit_rate, 18);
        int i = 1;
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.vbv_buffer_size_value, 10);
        bitWriter.write1Bit(this.constrained_parameters_flag);
        int i2 = 0;
        bitWriter.write1Bit(this.intra_quantiser_matrix != null ? 1 : 0);
        if (this.intra_quantiser_matrix != null) {
            for (int i3 = 0; i3 < 64; i3++) {
                bitWriter.writeNBit(this.intra_quantiser_matrix[i3], 8);
            }
        }
        if (this.non_intra_quantiser_matrix == null) {
            i = 0;
        }
        bitWriter.write1Bit(i);
        if (this.non_intra_quantiser_matrix != null) {
            while (i2 < 64) {
                bitWriter.writeNBit(this.non_intra_quantiser_matrix[i2], 8);
                i2++;
            }
        }
        bitWriter.flush();
        writeExtensions(byteBuffer);
    }

    private void writeExtensions(ByteBuffer byteBuffer) {
        if (this.sequenceExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.sequenceExtension.write(byteBuffer);
        }
        if (this.sequenceScalableExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.sequenceScalableExtension.write(byteBuffer);
        }
        if (this.sequenceDisplayExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.sequenceDisplayExtension.write(byteBuffer);
        }
    }

    public boolean hasExtensions() {
        return hasExtensions;
    }

    public void copyExtensions(SequenceHeader sequenceHeader) {
        this.sequenceExtension = sequenceHeader.sequenceExtension;
        this.sequenceScalableExtension = sequenceHeader.sequenceScalableExtension;
        this.sequenceDisplayExtension = sequenceHeader.sequenceDisplayExtension;
    }
}
