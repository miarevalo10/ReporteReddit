package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class SeqParameterSetExt {
    public boolean additional_extension_flag;
    public boolean alpha_incr_flag;
    public int alpha_opaque_value;
    public int alpha_transparent_value;
    public int aux_format_idc;
    public int bit_depth_aux_minus8;
    public int seq_parameter_set_id;

    public static SeqParameterSetExt read(ByteBuffer byteBuffer) {
        BitReader bitReader = new BitReader(byteBuffer);
        byteBuffer = new SeqParameterSetExt();
        byteBuffer.seq_parameter_set_id = CAVLCReader.readUE(bitReader, "SPSE: seq_parameter_set_id");
        byteBuffer.aux_format_idc = CAVLCReader.readUE(bitReader, "SPSE: aux_format_idc");
        if (byteBuffer.aux_format_idc != 0) {
            byteBuffer.bit_depth_aux_minus8 = CAVLCReader.readUE(bitReader, "SPSE: bit_depth_aux_minus8");
            byteBuffer.alpha_incr_flag = CAVLCReader.readBool(bitReader, "SPSE: alpha_incr_flag");
            byteBuffer.alpha_opaque_value = CAVLCReader.readU(bitReader, byteBuffer.bit_depth_aux_minus8 + 9, "SPSE: alpha_opaque_value");
            byteBuffer.alpha_transparent_value = CAVLCReader.readU(bitReader, byteBuffer.bit_depth_aux_minus8 + 9, "SPSE: alpha_transparent_value");
        }
        byteBuffer.additional_extension_flag = CAVLCReader.readBool(bitReader, "SPSE: additional_extension_flag");
        return byteBuffer;
    }

    public void write(ByteBuffer byteBuffer) {
        CAVLCWriter.writeTrailingBits(new BitWriter(byteBuffer));
    }
}
