package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class QuantMatrixExtension implements MPEGHeader {
    public int[] chroma_intra_quantiser_matrix;
    public int[] chroma_non_intra_quantiser_matrix;
    public int[] intra_quantiser_matrix;
    public int[] non_intra_quantiser_matrix;

    public static QuantMatrixExtension read(BitReader bitReader) {
        QuantMatrixExtension quantMatrixExtension = new QuantMatrixExtension();
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.intra_quantiser_matrix = readQMat(bitReader);
        }
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.non_intra_quantiser_matrix = readQMat(bitReader);
        }
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.chroma_intra_quantiser_matrix = readQMat(bitReader);
        }
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.chroma_non_intra_quantiser_matrix = readQMat(bitReader);
        }
        return quantMatrixExtension;
    }

    private static int[] readQMat(BitReader bitReader) {
        int[] iArr = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr[i] = bitReader.readNBit(8);
        }
        return iArr;
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(3, 4);
        int i = 0;
        bitWriter.write1Bit(this.intra_quantiser_matrix != null ? 1 : null);
        if (this.intra_quantiser_matrix != null) {
            writeQMat(this.intra_quantiser_matrix, bitWriter);
        }
        bitWriter.write1Bit(this.non_intra_quantiser_matrix != null ? 1 : null);
        if (this.non_intra_quantiser_matrix != null) {
            writeQMat(this.non_intra_quantiser_matrix, bitWriter);
        }
        bitWriter.write1Bit(this.chroma_intra_quantiser_matrix != null ? 1 : null);
        if (this.chroma_intra_quantiser_matrix != null) {
            writeQMat(this.chroma_intra_quantiser_matrix, bitWriter);
        }
        if (this.chroma_non_intra_quantiser_matrix != null) {
            i = 1;
        }
        bitWriter.write1Bit(i);
        if (this.chroma_non_intra_quantiser_matrix != null) {
            writeQMat(this.chroma_non_intra_quantiser_matrix, bitWriter);
        }
        bitWriter.flush();
    }

    private void writeQMat(int[] iArr, BitWriter bitWriter) {
        for (int i = 0; i < 64; i++) {
            bitWriter.writeNBit(iArr[i], 8);
        }
    }
}
