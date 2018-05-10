package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

public class PictureParameterSet {
    public int[] bottom_right;
    public int chroma_qp_index_offset;
    public boolean constrained_intra_pred_flag;
    public boolean deblocking_filter_control_present_flag;
    public boolean entropy_coding_mode_flag;
    public PPSExt extended;
    public int[] num_ref_idx_active_minus1 = new int[2];
    public int num_slice_groups_minus1;
    public int pic_init_qp_minus26;
    public int pic_init_qs_minus26;
    public boolean pic_order_present_flag;
    public int pic_parameter_set_id;
    public boolean redundant_pic_cnt_present_flag;
    public int[] run_length_minus1;
    public int seq_parameter_set_id;
    public boolean slice_group_change_direction_flag;
    public int slice_group_change_rate_minus1;
    public int[] slice_group_id;
    public int slice_group_map_type;
    public int[] top_left;
    public int weighted_bipred_idc;
    public boolean weighted_pred_flag;

    public static class PPSExt {
        public boolean[] pic_scaling_list_present_flag;
        public ScalingMatrix scalindMatrix;
        public int second_chroma_qp_index_offset;
        public boolean transform_8x8_mode_flag;
    }

    public static PictureParameterSet read(ByteBuffer byteBuffer) {
        BitReader bitReader = new BitReader(byteBuffer);
        byteBuffer = new PictureParameterSet();
        byteBuffer.pic_parameter_set_id = CAVLCReader.readUE(bitReader, "PPS: pic_parameter_set_id");
        byteBuffer.seq_parameter_set_id = CAVLCReader.readUE(bitReader, "PPS: seq_parameter_set_id");
        byteBuffer.entropy_coding_mode_flag = CAVLCReader.readBool(bitReader, "PPS: entropy_coding_mode_flag");
        byteBuffer.pic_order_present_flag = CAVLCReader.readBool(bitReader, "PPS: pic_order_present_flag");
        byteBuffer.num_slice_groups_minus1 = CAVLCReader.readUE(bitReader, "PPS: num_slice_groups_minus1");
        int i = 0;
        if (byteBuffer.num_slice_groups_minus1 > 0) {
            byteBuffer.slice_group_map_type = CAVLCReader.readUE(bitReader, "PPS: slice_group_map_type");
            byteBuffer.top_left = new int[(byteBuffer.num_slice_groups_minus1 + 1)];
            byteBuffer.bottom_right = new int[(byteBuffer.num_slice_groups_minus1 + 1)];
            byteBuffer.run_length_minus1 = new int[(byteBuffer.num_slice_groups_minus1 + 1)];
            int i2;
            if (byteBuffer.slice_group_map_type == 0) {
                for (i2 = 0; i2 <= byteBuffer.num_slice_groups_minus1; i2++) {
                    byteBuffer.run_length_minus1[i2] = CAVLCReader.readUE(bitReader, "PPS: run_length_minus1");
                }
            } else if (byteBuffer.slice_group_map_type == 2) {
                for (i2 = 0; i2 < byteBuffer.num_slice_groups_minus1; i2++) {
                    byteBuffer.top_left[i2] = CAVLCReader.readUE(bitReader, "PPS: top_left");
                    byteBuffer.bottom_right[i2] = CAVLCReader.readUE(bitReader, "PPS: bottom_right");
                }
            } else {
                int i3 = 3;
                if (!(byteBuffer.slice_group_map_type == 3 || byteBuffer.slice_group_map_type == 4)) {
                    if (byteBuffer.slice_group_map_type != 5) {
                        if (byteBuffer.slice_group_map_type == 6) {
                            if (byteBuffer.num_slice_groups_minus1 + 1 <= 4) {
                                i3 = byteBuffer.num_slice_groups_minus1 + 1 > 2 ? 2 : 1;
                            }
                            i2 = CAVLCReader.readUE(bitReader, "PPS: pic_size_in_map_units_minus1");
                            byteBuffer.slice_group_id = new int[(i2 + 1)];
                            for (int i4 = 0; i4 <= i2; i4++) {
                                int[] iArr = byteBuffer.slice_group_id;
                                StringBuilder stringBuilder = new StringBuilder("PPS: slice_group_id [");
                                stringBuilder.append(i4);
                                stringBuilder.append("]f");
                                iArr[i4] = CAVLCReader.readU(bitReader, i3, stringBuilder.toString());
                            }
                        }
                    }
                }
                byteBuffer.slice_group_change_direction_flag = CAVLCReader.readBool(bitReader, "PPS: slice_group_change_direction_flag");
                byteBuffer.slice_group_change_rate_minus1 = CAVLCReader.readUE(bitReader, "PPS: slice_group_change_rate_minus1");
            }
        }
        byteBuffer.num_ref_idx_active_minus1 = new int[]{CAVLCReader.readUE(bitReader, "PPS: num_ref_idx_l0_active_minus1"), CAVLCReader.readUE(bitReader, "PPS: num_ref_idx_l1_active_minus1")};
        byteBuffer.weighted_pred_flag = CAVLCReader.readBool(bitReader, "PPS: weighted_pred_flag");
        byteBuffer.weighted_bipred_idc = CAVLCReader.readNBit(bitReader, 2, "PPS: weighted_bipred_idc");
        byteBuffer.pic_init_qp_minus26 = CAVLCReader.readSE(bitReader, "PPS: pic_init_qp_minus26");
        byteBuffer.pic_init_qs_minus26 = CAVLCReader.readSE(bitReader, "PPS: pic_init_qs_minus26");
        byteBuffer.chroma_qp_index_offset = CAVLCReader.readSE(bitReader, "PPS: chroma_qp_index_offset");
        byteBuffer.deblocking_filter_control_present_flag = CAVLCReader.readBool(bitReader, "PPS: deblocking_filter_control_present_flag");
        byteBuffer.constrained_intra_pred_flag = CAVLCReader.readBool(bitReader, "PPS: constrained_intra_pred_flag");
        byteBuffer.redundant_pic_cnt_present_flag = CAVLCReader.readBool(bitReader, "PPS: redundant_pic_cnt_present_flag");
        if (CAVLCReader.moreRBSPData(bitReader)) {
            byteBuffer.extended = new PPSExt();
            byteBuffer.extended.transform_8x8_mode_flag = CAVLCReader.readBool(bitReader, "PPS: transform_8x8_mode_flag");
            if (CAVLCReader.readBool(bitReader, "PPS: pic_scaling_matrix_present_flag")) {
                while (i < (byteBuffer.extended.transform_8x8_mode_flag * 2) + 6) {
                    if (CAVLCReader.readBool(bitReader, "PPS: pic_scaling_list_present_flag")) {
                        byteBuffer.extended.scalindMatrix.ScalingList4x4 = new ScalingList[8];
                        byteBuffer.extended.scalindMatrix.ScalingList8x8 = new ScalingList[8];
                        if (i < 6) {
                            byteBuffer.extended.scalindMatrix.ScalingList4x4[i] = ScalingList.read(bitReader, 16);
                        } else {
                            byteBuffer.extended.scalindMatrix.ScalingList8x8[i - 6] = ScalingList.read(bitReader, 64);
                        }
                    }
                    i++;
                }
            }
            byteBuffer.extended.second_chroma_qp_index_offset = CAVLCReader.readSE(bitReader, "PPS: second_chroma_qp_index_offset");
        }
        return byteBuffer;
    }

    public void write(ByteBuffer byteBuffer) {
        int i;
        BitWriter bitWriter = new BitWriter(byteBuffer);
        CAVLCWriter.writeUE(bitWriter, this.pic_parameter_set_id, "PPS: pic_parameter_set_id");
        CAVLCWriter.writeUE(bitWriter, this.seq_parameter_set_id, "PPS: seq_parameter_set_id");
        CAVLCWriter.writeBool(bitWriter, this.entropy_coding_mode_flag, "PPS: entropy_coding_mode_flag");
        CAVLCWriter.writeBool(bitWriter, this.pic_order_present_flag, "PPS: pic_order_present_flag");
        CAVLCWriter.writeUE(bitWriter, this.num_slice_groups_minus1, "PPS: num_slice_groups_minus1");
        if (this.num_slice_groups_minus1 > null) {
            CAVLCWriter.writeUE(bitWriter, this.slice_group_map_type, "PPS: slice_group_map_type");
            byteBuffer = new int[1];
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            if (this.slice_group_map_type == 0) {
                for (byteBuffer = null; byteBuffer <= this.num_slice_groups_minus1; byteBuffer++) {
                    CAVLCWriter.writeUE(bitWriter, iArr2[byteBuffer], "PPS: ");
                }
            } else if (this.slice_group_map_type == 2) {
                for (i = 0; i < this.num_slice_groups_minus1; i++) {
                    CAVLCWriter.writeUE(bitWriter, byteBuffer[i], "PPS: ");
                    CAVLCWriter.writeUE(bitWriter, iArr[i], "PPS: ");
                }
            } else {
                int i2 = 3;
                if (!(this.slice_group_map_type == 3 || this.slice_group_map_type == 4)) {
                    if (this.slice_group_map_type != 5) {
                        if (this.slice_group_map_type == 6) {
                            if (this.num_slice_groups_minus1 + 1 <= 4) {
                                i2 = this.num_slice_groups_minus1 + 1 > 2 ? 2 : 1;
                            }
                            CAVLCWriter.writeUE(bitWriter, this.slice_group_id.length, "PPS: ");
                            for (byteBuffer = null; byteBuffer <= this.slice_group_id.length; byteBuffer++) {
                                CAVLCWriter.writeU(bitWriter, this.slice_group_id[byteBuffer], i2);
                            }
                        }
                    }
                }
                CAVLCWriter.writeBool(bitWriter, this.slice_group_change_direction_flag, "PPS: slice_group_change_direction_flag");
                CAVLCWriter.writeUE(bitWriter, this.slice_group_change_rate_minus1, "PPS: slice_group_change_rate_minus1");
            }
        }
        CAVLCWriter.writeUE(bitWriter, this.num_ref_idx_active_minus1[0], "PPS: num_ref_idx_l0_active_minus1");
        CAVLCWriter.writeUE(bitWriter, this.num_ref_idx_active_minus1[1], "PPS: num_ref_idx_l1_active_minus1");
        CAVLCWriter.writeBool(bitWriter, this.weighted_pred_flag, "PPS: weighted_pred_flag");
        CAVLCWriter.writeNBit(bitWriter, (long) this.weighted_bipred_idc, 2, "PPS: weighted_bipred_idc");
        CAVLCWriter.writeSE(bitWriter, this.pic_init_qp_minus26, "PPS: pic_init_qp_minus26");
        CAVLCWriter.writeSE(bitWriter, this.pic_init_qs_minus26, "PPS: pic_init_qs_minus26");
        CAVLCWriter.writeSE(bitWriter, this.chroma_qp_index_offset, "PPS: chroma_qp_index_offset");
        CAVLCWriter.writeBool(bitWriter, this.deblocking_filter_control_present_flag, "PPS: deblocking_filter_control_present_flag");
        CAVLCWriter.writeBool(bitWriter, this.constrained_intra_pred_flag, "PPS: constrained_intra_pred_flag");
        CAVLCWriter.writeBool(bitWriter, this.redundant_pic_cnt_present_flag, "PPS: redundant_pic_cnt_present_flag");
        if (this.extended != null) {
            CAVLCWriter.writeBool(bitWriter, this.extended.transform_8x8_mode_flag, "PPS: transform_8x8_mode_flag");
            CAVLCWriter.writeBool(bitWriter, this.extended.scalindMatrix != null ? 1 : null, "PPS: scalindMatrix");
            if (this.extended.scalindMatrix != null) {
                for (byteBuffer = null; byteBuffer < (this.extended.transform_8x8_mode_flag * 2) + 6; byteBuffer++) {
                    if (byteBuffer < 6) {
                        CAVLCWriter.writeBool(bitWriter, this.extended.scalindMatrix.ScalingList4x4[byteBuffer] != null, "PPS: ");
                        if (this.extended.scalindMatrix.ScalingList4x4[byteBuffer] != null) {
                            this.extended.scalindMatrix.ScalingList4x4[byteBuffer].write(bitWriter);
                        }
                    } else {
                        i = byteBuffer - 6;
                        CAVLCWriter.writeBool(bitWriter, this.extended.scalindMatrix.ScalingList8x8[i] != null, "PPS: ");
                        if (this.extended.scalindMatrix.ScalingList8x8[i] != null) {
                            this.extended.scalindMatrix.ScalingList8x8[i].write(bitWriter);
                        }
                    }
                }
            }
            CAVLCWriter.writeSE(bitWriter, this.extended.second_chroma_qp_index_offset, "PPS: ");
        }
        CAVLCWriter.writeTrailingBits(bitWriter);
    }

    public int hashCode() {
        int i = 1237;
        int hashCode = 31 * (((((((((((((((((((((((((((((((((((((((((((Arrays.hashCode(this.bottom_right) + 31) * 31) + this.chroma_qp_index_offset) * 31) + (this.constrained_intra_pred_flag ? 1231 : 1237)) * 31) + (this.deblocking_filter_control_present_flag ? 1231 : 1237)) * 31) + (this.entropy_coding_mode_flag ? 1231 : 1237)) * 31) + (this.extended == null ? 0 : this.extended.hashCode())) * 31) + this.num_ref_idx_active_minus1[0]) * 31) + this.num_ref_idx_active_minus1[1]) * 31) + this.num_slice_groups_minus1) * 31) + this.pic_init_qp_minus26) * 31) + this.pic_init_qs_minus26) * 31) + (this.pic_order_present_flag ? 1231 : 1237)) * 31) + this.pic_parameter_set_id) * 31) + (this.redundant_pic_cnt_present_flag ? 1231 : 1237)) * 31) + Arrays.hashCode(this.run_length_minus1)) * 31) + this.seq_parameter_set_id) * 31) + (this.slice_group_change_direction_flag ? 1231 : 1237)) * 31) + this.slice_group_change_rate_minus1) * 31) + Arrays.hashCode(this.slice_group_id)) * 31) + this.slice_group_map_type) * 31) + Arrays.hashCode(this.top_left)) * 31) + this.weighted_bipred_idc);
        if (this.weighted_pred_flag) {
            i = 1231;
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PictureParameterSet pictureParameterSet = (PictureParameterSet) obj;
        if (!Arrays.equals(this.bottom_right, pictureParameterSet.bottom_right) || this.chroma_qp_index_offset != pictureParameterSet.chroma_qp_index_offset || this.constrained_intra_pred_flag != pictureParameterSet.constrained_intra_pred_flag || this.deblocking_filter_control_present_flag != pictureParameterSet.deblocking_filter_control_present_flag || this.entropy_coding_mode_flag != pictureParameterSet.entropy_coding_mode_flag) {
            return false;
        }
        if (this.extended == null) {
            if (pictureParameterSet.extended != null) {
                return false;
            }
        } else if (!this.extended.equals(pictureParameterSet.extended)) {
            return false;
        }
        return this.num_ref_idx_active_minus1[0] == pictureParameterSet.num_ref_idx_active_minus1[0] && this.num_ref_idx_active_minus1[1] == pictureParameterSet.num_ref_idx_active_minus1[1] && this.num_slice_groups_minus1 == pictureParameterSet.num_slice_groups_minus1 && this.pic_init_qp_minus26 == pictureParameterSet.pic_init_qp_minus26 && this.pic_init_qs_minus26 == pictureParameterSet.pic_init_qs_minus26 && this.pic_order_present_flag == pictureParameterSet.pic_order_present_flag && this.pic_parameter_set_id == pictureParameterSet.pic_parameter_set_id && this.redundant_pic_cnt_present_flag == pictureParameterSet.redundant_pic_cnt_present_flag && Arrays.equals(this.run_length_minus1, pictureParameterSet.run_length_minus1) && this.seq_parameter_set_id == pictureParameterSet.seq_parameter_set_id && this.slice_group_change_direction_flag == pictureParameterSet.slice_group_change_direction_flag && this.slice_group_change_rate_minus1 == pictureParameterSet.slice_group_change_rate_minus1 && Arrays.equals(this.slice_group_id, pictureParameterSet.slice_group_id) && this.slice_group_map_type == pictureParameterSet.slice_group_map_type && Arrays.equals(this.top_left, pictureParameterSet.top_left) && this.weighted_bipred_idc == pictureParameterSet.weighted_bipred_idc && this.weighted_pred_flag == pictureParameterSet.weighted_pred_flag;
    }

    public PictureParameterSet copy() {
        ByteBuffer allocate = ByteBuffer.allocate(MPEGConst.CODE_END);
        write(allocate);
        allocate.flip();
        return read(allocate);
    }
}
