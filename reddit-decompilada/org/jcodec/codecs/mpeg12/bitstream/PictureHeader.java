package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class PictureHeader implements MPEGHeader {
    public static final int BiPredictiveCoded = 3;
    public static final int Copyright_Extension = 4;
    public static final int IntraCoded = 1;
    public static final int Picture_Coding_Extension = 8;
    public static final int Picture_Display_Extension = 7;
    public static final int Picture_Spatial_Scalable_Extension = 9;
    public static final int Picture_Temporal_Scalable_Extension = 16;
    public static final int PredictiveCoded = 2;
    public static final int Quant_Matrix_Extension = 3;
    public int backward_f_code;
    public CopyrightExtension copyrightExtension;
    public int forward_f_code;
    public int full_pel_backward_vector;
    public int full_pel_forward_vector;
    private boolean hasExtensions;
    public PictureCodingExtension pictureCodingExtension;
    public PictureDisplayExtension pictureDisplayExtension;
    public PictureSpatialScalableExtension pictureSpatialScalableExtension;
    public PictureTemporalScalableExtension pictureTemporalScalableExtension;
    public int picture_coding_type;
    public QuantMatrixExtension quantMatrixExtension;
    public int temporal_reference;
    public int vbv_delay;

    public PictureHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.temporal_reference = i;
        this.picture_coding_type = i2;
        this.vbv_delay = i3;
        this.full_pel_forward_vector = i4;
        this.forward_f_code = i5;
        this.full_pel_backward_vector = i6;
        this.backward_f_code = i7;
    }

    private PictureHeader() {
    }

    public static PictureHeader read(ByteBuffer byteBuffer) {
        BitReader bitReader = new BitReader(byteBuffer);
        byteBuffer = new PictureHeader();
        byteBuffer.temporal_reference = bitReader.readNBit(10);
        byteBuffer.picture_coding_type = bitReader.readNBit(3);
        byteBuffer.vbv_delay = bitReader.readNBit(16);
        if (byteBuffer.picture_coding_type == 2 || byteBuffer.picture_coding_type == 3) {
            byteBuffer.full_pel_forward_vector = bitReader.read1Bit();
            byteBuffer.forward_f_code = bitReader.readNBit(3);
        }
        if (byteBuffer.picture_coding_type == 3) {
            byteBuffer.full_pel_backward_vector = bitReader.read1Bit();
            byteBuffer.backward_f_code = bitReader.readNBit(3);
        }
        while (bitReader.read1Bit() == 1) {
            bitReader.readNBit(8);
        }
        return byteBuffer;
    }

    public static void readExtension(ByteBuffer byteBuffer, PictureHeader pictureHeader, SequenceHeader sequenceHeader) {
        pictureHeader.hasExtensions = true;
        BitReader bitReader = new BitReader(byteBuffer);
        byteBuffer = bitReader.readNBit(4);
        if (byteBuffer != 16) {
            switch (byteBuffer) {
                case 3:
                    pictureHeader.quantMatrixExtension = QuantMatrixExtension.read(bitReader);
                    return;
                case 4:
                    pictureHeader.copyrightExtension = CopyrightExtension.read(bitReader);
                    return;
                default:
                    switch (byteBuffer) {
                        case 7:
                            pictureHeader.pictureDisplayExtension = PictureDisplayExtension.read(bitReader, sequenceHeader.sequenceExtension, pictureHeader.pictureCodingExtension);
                            return;
                        case 8:
                            pictureHeader.pictureCodingExtension = PictureCodingExtension.read(bitReader);
                            return;
                        case 9:
                            pictureHeader.pictureSpatialScalableExtension = PictureSpatialScalableExtension.read(bitReader);
                            return;
                        default:
                            sequenceHeader = new StringBuilder("Unsupported extension: ");
                            sequenceHeader.append(byteBuffer);
                            throw new RuntimeException(sequenceHeader.toString());
                    }
            }
        }
        pictureHeader.pictureTemporalScalableExtension = PictureTemporalScalableExtension.read(bitReader);
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(this.temporal_reference, 10);
        bitWriter.writeNBit(this.picture_coding_type, 3);
        bitWriter.writeNBit(this.vbv_delay, 16);
        if (this.picture_coding_type == 2 || this.picture_coding_type == 3) {
            bitWriter.write1Bit(this.full_pel_forward_vector);
            bitWriter.write1Bit(this.forward_f_code);
        }
        if (this.picture_coding_type == 3) {
            bitWriter.write1Bit(this.full_pel_backward_vector);
            bitWriter.writeNBit(this.backward_f_code, 3);
        }
        bitWriter.write1Bit(0);
        bitWriter.flush();
        writeExtensions(byteBuffer);
    }

    private void writeExtensions(ByteBuffer byteBuffer) {
        if (this.quantMatrixExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.quantMatrixExtension.write(byteBuffer);
        }
        if (this.copyrightExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.copyrightExtension.write(byteBuffer);
        }
        if (this.pictureCodingExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureCodingExtension.write(byteBuffer);
        }
        if (this.pictureDisplayExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureDisplayExtension.write(byteBuffer);
        }
        if (this.pictureSpatialScalableExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureSpatialScalableExtension.write(byteBuffer);
        }
        if (this.pictureTemporalScalableExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureTemporalScalableExtension.write(byteBuffer);
        }
    }

    public boolean hasExtensions() {
        return this.hasExtensions;
    }
}
