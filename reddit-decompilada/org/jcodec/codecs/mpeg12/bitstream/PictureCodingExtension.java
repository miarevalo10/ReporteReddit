package org.jcodec.codecs.mpeg12.bitstream;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class PictureCodingExtension implements MPEGHeader {
    public static final int Bottom_Field = 2;
    public static final int Frame = 3;
    public static final int Top_Field = 1;
    public int alternate_scan;
    public int chroma_420_type;
    public CompositeDisplay compositeDisplay;
    public int concealment_motion_vectors;
    public int[][] f_code = ((int[][]) Array.newInstance(int.class, new int[]{2, 2}));
    public int frame_pred_frame_dct;
    public int intra_dc_precision;
    public int intra_vlc_format;
    public int picture_structure;
    public int progressive_frame;
    public int q_scale_type;
    public int repeat_first_field;
    public int top_field_first;

    public static class CompositeDisplay {
        public int burst_amplitude;
        public int field_sequence;
        public int sub_carrier;
        public int sub_carrier_phase;
        public int v_axis;

        public static CompositeDisplay read(BitReader bitReader) {
            CompositeDisplay compositeDisplay = new CompositeDisplay();
            compositeDisplay.v_axis = bitReader.read1Bit();
            compositeDisplay.field_sequence = bitReader.readNBit(3);
            compositeDisplay.sub_carrier = bitReader.read1Bit();
            compositeDisplay.burst_amplitude = bitReader.readNBit(7);
            compositeDisplay.sub_carrier_phase = bitReader.readNBit(8);
            return compositeDisplay;
        }

        public void write(BitWriter bitWriter) {
            bitWriter.write1Bit(this.v_axis);
            bitWriter.writeNBit(this.field_sequence, 3);
            bitWriter.write1Bit(this.sub_carrier);
            bitWriter.writeNBit(this.burst_amplitude, 7);
            bitWriter.writeNBit(this.sub_carrier_phase, 8);
        }
    }

    public static PictureCodingExtension read(BitReader bitReader) {
        PictureCodingExtension pictureCodingExtension = new PictureCodingExtension();
        pictureCodingExtension.f_code[0][0] = bitReader.readNBit(4);
        pictureCodingExtension.f_code[0][1] = bitReader.readNBit(4);
        pictureCodingExtension.f_code[1][0] = bitReader.readNBit(4);
        pictureCodingExtension.f_code[1][1] = bitReader.readNBit(4);
        pictureCodingExtension.intra_dc_precision = bitReader.readNBit(2);
        pictureCodingExtension.picture_structure = bitReader.readNBit(2);
        pictureCodingExtension.top_field_first = bitReader.read1Bit();
        pictureCodingExtension.frame_pred_frame_dct = bitReader.read1Bit();
        pictureCodingExtension.concealment_motion_vectors = bitReader.read1Bit();
        pictureCodingExtension.q_scale_type = bitReader.read1Bit();
        pictureCodingExtension.intra_vlc_format = bitReader.read1Bit();
        pictureCodingExtension.alternate_scan = bitReader.read1Bit();
        pictureCodingExtension.repeat_first_field = bitReader.read1Bit();
        pictureCodingExtension.chroma_420_type = bitReader.read1Bit();
        pictureCodingExtension.progressive_frame = bitReader.read1Bit();
        if (bitReader.read1Bit() != 0) {
            pictureCodingExtension.compositeDisplay = CompositeDisplay.read(bitReader);
        }
        return pictureCodingExtension;
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(8, 4);
        int i = 0;
        bitWriter.writeNBit(this.f_code[0][0], 4);
        bitWriter.writeNBit(this.f_code[0][1], 4);
        bitWriter.writeNBit(this.f_code[1][0], 4);
        bitWriter.writeNBit(this.f_code[1][1], 4);
        bitWriter.writeNBit(this.intra_dc_precision, 2);
        bitWriter.writeNBit(this.picture_structure, 2);
        bitWriter.write1Bit(this.top_field_first);
        bitWriter.write1Bit(this.frame_pred_frame_dct);
        bitWriter.write1Bit(this.concealment_motion_vectors);
        bitWriter.write1Bit(this.q_scale_type);
        bitWriter.write1Bit(this.intra_vlc_format);
        bitWriter.write1Bit(this.alternate_scan);
        bitWriter.write1Bit(this.repeat_first_field);
        bitWriter.write1Bit(this.chroma_420_type);
        bitWriter.write1Bit(this.progressive_frame);
        if (this.compositeDisplay != null) {
            i = 1;
        }
        bitWriter.write1Bit(i);
        if (this.compositeDisplay != null) {
            this.compositeDisplay.write(bitWriter);
        }
        bitWriter.flush();
    }
}
