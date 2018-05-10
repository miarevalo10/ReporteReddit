package org.jcodec.codecs.h264.io.write;

import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarking.Instruction;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.ColorSpace;

public class SliceHeaderWriter {
    private static int CeilLog2(int i) {
        i--;
        int i2 = 0;
        while (i != 0) {
            i >>= 1;
            i2++;
        }
        return i2;
    }

    public void write(SliceHeader sliceHeader, boolean z, int i, BitWriter bitWriter) {
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        PictureParameterSet pictureParameterSet = sliceHeader.pps;
        CAVLCWriter.writeUE(bitWriter, sliceHeader.first_mb_in_slice, "SH: first_mb_in_slice");
        CAVLCWriter.writeUE(bitWriter, sliceHeader.slice_type.ordinal() + (sliceHeader.slice_type_restr ? 5 : 0), "SH: slice_type");
        CAVLCWriter.writeUE(bitWriter, sliceHeader.pic_parameter_set_id, "SH: pic_parameter_set_id");
        CAVLCWriter.writeU(bitWriter, sliceHeader.frame_num, seqParameterSet.log2_max_frame_num_minus4 + 4, "SH: frame_num");
        if (!seqParameterSet.frame_mbs_only_flag) {
            CAVLCWriter.writeBool(bitWriter, sliceHeader.field_pic_flag, "SH: field_pic_flag");
            if (sliceHeader.field_pic_flag) {
                CAVLCWriter.writeBool(bitWriter, sliceHeader.bottom_field_flag, "SH: bottom_field_flag");
            }
        }
        if (z) {
            CAVLCWriter.writeUE(bitWriter, sliceHeader.idr_pic_id, "SH: idr_pic_id");
        }
        if (seqParameterSet.pic_order_cnt_type == 0) {
            CAVLCWriter.writeU(bitWriter, sliceHeader.pic_order_cnt_lsb, seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 + 4);
            if (pictureParameterSet.pic_order_present_flag && !seqParameterSet.field_pic_flag) {
                CAVLCWriter.writeSE(bitWriter, sliceHeader.delta_pic_order_cnt_bottom, "SH: delta_pic_order_cnt_bottom");
            }
        }
        if (seqParameterSet.pic_order_cnt_type == 1 && !seqParameterSet.delta_pic_order_always_zero_flag) {
            CAVLCWriter.writeSE(bitWriter, sliceHeader.delta_pic_order_cnt[0], "SH: delta_pic_order_cnt");
            if (pictureParameterSet.pic_order_present_flag && !seqParameterSet.field_pic_flag) {
                CAVLCWriter.writeSE(bitWriter, sliceHeader.delta_pic_order_cnt[1], "SH: delta_pic_order_cnt");
            }
        }
        if (pictureParameterSet.redundant_pic_cnt_present_flag) {
            CAVLCWriter.writeUE(bitWriter, sliceHeader.redundant_pic_cnt, "SH: redundant_pic_cnt");
        }
        if (sliceHeader.slice_type == SliceType.B) {
            CAVLCWriter.writeBool(bitWriter, sliceHeader.direct_spatial_mv_pred_flag, "SH: direct_spatial_mv_pred_flag");
        }
        if (sliceHeader.slice_type == SliceType.P || sliceHeader.slice_type == SliceType.SP || sliceHeader.slice_type == SliceType.B) {
            CAVLCWriter.writeBool(bitWriter, sliceHeader.num_ref_idx_active_override_flag, "SH: num_ref_idx_active_override_flag");
            if (sliceHeader.num_ref_idx_active_override_flag) {
                CAVLCWriter.writeUE(bitWriter, sliceHeader.num_ref_idx_active_minus1[0], "SH: num_ref_idx_l0_active_minus1");
                if (sliceHeader.slice_type == SliceType.B) {
                    CAVLCWriter.writeUE(bitWriter, sliceHeader.num_ref_idx_active_minus1[1], "SH: num_ref_idx_l1_active_minus1");
                }
            }
        }
        writeRefPicListReordering(sliceHeader, bitWriter);
        if ((pictureParameterSet.weighted_pred_flag && (sliceHeader.slice_type == SliceType.P || sliceHeader.slice_type == SliceType.SP)) || (pictureParameterSet.weighted_bipred_idc == 1 && sliceHeader.slice_type == SliceType.B)) {
            writePredWeightTable(sliceHeader, bitWriter);
        }
        if (i != 0) {
            writeDecRefPicMarking(sliceHeader, z, bitWriter);
        }
        if (pictureParameterSet.entropy_coding_mode_flag && sliceHeader.slice_type.isInter()) {
            CAVLCWriter.writeUE(bitWriter, sliceHeader.cabac_init_idc, "SH: cabac_init_idc");
        }
        CAVLCWriter.writeSE(bitWriter, sliceHeader.slice_qp_delta, "SH: slice_qp_delta");
        if (sliceHeader.slice_type == SliceType.SP || sliceHeader.slice_type == SliceType.SI) {
            if (sliceHeader.slice_type == SliceType.SP) {
                CAVLCWriter.writeBool(bitWriter, sliceHeader.sp_for_switch_flag, "SH: sp_for_switch_flag");
            }
            CAVLCWriter.writeSE(bitWriter, sliceHeader.slice_qs_delta, "SH: slice_qs_delta");
        }
        if (pictureParameterSet.deblocking_filter_control_present_flag) {
            CAVLCWriter.writeUE(bitWriter, sliceHeader.disable_deblocking_filter_idc, "SH: disable_deblocking_filter_idc");
            if (!sliceHeader.disable_deblocking_filter_idc) {
                CAVLCWriter.writeSE(bitWriter, sliceHeader.slice_alpha_c0_offset_div2, "SH: slice_alpha_c0_offset_div2");
                CAVLCWriter.writeSE(bitWriter, sliceHeader.slice_beta_offset_div2, "SH: slice_beta_offset_div2");
            }
        }
        if (pictureParameterSet.num_slice_groups_minus1 <= false && pictureParameterSet.slice_group_map_type >= true && pictureParameterSet.slice_group_map_type <= true) {
            z = ((seqParameterSet.pic_height_in_map_units_minus1 + true) * (seqParameterSet.pic_width_in_mbs_minus1 + 1)) / (pictureParameterSet.slice_group_change_rate_minus1 + 1);
            if (((seqParameterSet.pic_height_in_map_units_minus1 + 1) * (seqParameterSet.pic_width_in_mbs_minus1 + 1)) % (pictureParameterSet.slice_group_change_rate_minus1 + 1) > 0) {
                z++;
            }
            CAVLCWriter.writeU(bitWriter, sliceHeader.slice_group_change_cycle, CeilLog2(z + true));
        }
    }

    private void writeDecRefPicMarking(SliceHeader sliceHeader, boolean z, BitWriter bitWriter) {
        if (z) {
            sliceHeader = sliceHeader.refPicMarkingIDR;
            CAVLCWriter.writeBool(bitWriter, sliceHeader.isDiscardDecodedPics(), "SH: no_output_of_prior_pics_flag");
            CAVLCWriter.writeBool(bitWriter, sliceHeader.isUseForlongTerm(), "SH: long_term_reference_flag");
            return;
        }
        CAVLCWriter.writeBool(bitWriter, sliceHeader.refPicMarkingNonIDR, "SH: adaptive_ref_pic_marking_mode_flag");
        if (sliceHeader.refPicMarkingNonIDR) {
            for (Instruction instruction : sliceHeader.refPicMarkingNonIDR.getInstructions()) {
                switch (instruction.getType()) {
                    case REMOVE_SHORT:
                        CAVLCWriter.writeUE(bitWriter, 1, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUE(bitWriter, instruction.getArg1() - 1, "SH: difference_of_pic_nums_minus1");
                        break;
                    case REMOVE_LONG:
                        CAVLCWriter.writeUE(bitWriter, 2, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUE(bitWriter, instruction.getArg1(), "SH: long_term_pic_num");
                        break;
                    case CONVERT_INTO_LONG:
                        CAVLCWriter.writeUE(bitWriter, 3, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUE(bitWriter, instruction.getArg1() - 1, "SH: difference_of_pic_nums_minus1");
                        CAVLCWriter.writeUE(bitWriter, instruction.getArg2(), "SH: long_term_frame_idx");
                        break;
                    case TRUNK_LONG:
                        CAVLCWriter.writeUE(bitWriter, 4, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUE(bitWriter, instruction.getArg1() + 1, "SH: max_long_term_frame_idx_plus1");
                        break;
                    case CLEAR:
                        CAVLCWriter.writeUE(bitWriter, 5, "SH: memory_management_control_operation");
                        break;
                    case MARK_LONG:
                        CAVLCWriter.writeUE(bitWriter, 6, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUE(bitWriter, instruction.getArg1(), "SH: long_term_frame_idx");
                        break;
                    default:
                        break;
                }
            }
            CAVLCWriter.writeUE(bitWriter, 0, "SH: memory_management_control_operation");
        }
    }

    private void writePredWeightTable(SliceHeader sliceHeader, BitWriter bitWriter) {
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        CAVLCWriter.writeUE(bitWriter, sliceHeader.pred_weight_table.luma_log2_weight_denom, "SH: luma_log2_weight_denom");
        if (seqParameterSet.chroma_format_idc != ColorSpace.MONO) {
            CAVLCWriter.writeUE(bitWriter, sliceHeader.pred_weight_table.chroma_log2_weight_denom, "SH: chroma_log2_weight_denom");
        }
        writeOffsetWeight(sliceHeader, bitWriter, 0);
        if (sliceHeader.slice_type == SliceType.B) {
            writeOffsetWeight(sliceHeader, bitWriter, 1);
        }
    }

    private void writeOffsetWeight(SliceHeader sliceHeader, BitWriter bitWriter, int i) {
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        int i2 = 1 << sliceHeader.pred_weight_table.luma_log2_weight_denom;
        int i3 = 1 << sliceHeader.pred_weight_table.chroma_log2_weight_denom;
        int i4 = 0;
        while (i4 < sliceHeader.pred_weight_table.luma_weight[i].length) {
            boolean z;
            int i5;
            int i6;
            StringBuilder stringBuilder;
            if (sliceHeader.pred_weight_table.luma_weight[i][i4] == i2) {
                if (sliceHeader.pred_weight_table.luma_offset[i][i4] == 0) {
                    z = false;
                    CAVLCWriter.writeBool(bitWriter, z, "SH: luma_weight_l0_flag");
                    if (z) {
                        i5 = sliceHeader.pred_weight_table.luma_weight[i][i4];
                        StringBuilder stringBuilder2 = new StringBuilder("SH: luma_weight_l");
                        stringBuilder2.append(i);
                        CAVLCWriter.writeSE(bitWriter, i5, stringBuilder2.toString());
                        i5 = sliceHeader.pred_weight_table.luma_offset[i][i4];
                        stringBuilder2 = new StringBuilder("SH: luma_offset_l");
                        stringBuilder2.append(i);
                        CAVLCWriter.writeSE(bitWriter, i5, stringBuilder2.toString());
                    }
                    if (seqParameterSet.chroma_format_idc == ColorSpace.MONO) {
                        if (sliceHeader.pred_weight_table.chroma_weight[i][0][i4] == i3 && sliceHeader.pred_weight_table.chroma_offset[i][0][i4] == 0 && sliceHeader.pred_weight_table.chroma_weight[i][1][i4] == i3) {
                            if (sliceHeader.pred_weight_table.chroma_offset[i][1][i4] != 0) {
                                z = false;
                                CAVLCWriter.writeBool(bitWriter, z, "SH: chroma_weight_l0_flag");
                                if (!z) {
                                    for (i5 = 0; i5 < 2; i5++) {
                                        i6 = sliceHeader.pred_weight_table.chroma_weight[i][i5][i4];
                                        stringBuilder = new StringBuilder("SH: chroma_weight_l");
                                        stringBuilder.append(i);
                                        CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                                        i6 = sliceHeader.pred_weight_table.chroma_offset[i][i5][i4];
                                        stringBuilder = new StringBuilder("SH: chroma_offset_l");
                                        stringBuilder.append(i);
                                        CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                                    }
                                }
                            }
                        }
                        z = true;
                        CAVLCWriter.writeBool(bitWriter, z, "SH: chroma_weight_l0_flag");
                        if (!z) {
                            for (i5 = 0; i5 < 2; i5++) {
                                i6 = sliceHeader.pred_weight_table.chroma_weight[i][i5][i4];
                                stringBuilder = new StringBuilder("SH: chroma_weight_l");
                                stringBuilder.append(i);
                                CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                                i6 = sliceHeader.pred_weight_table.chroma_offset[i][i5][i4];
                                stringBuilder = new StringBuilder("SH: chroma_offset_l");
                                stringBuilder.append(i);
                                CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                            }
                        }
                    }
                    i4++;
                }
            }
            z = true;
            CAVLCWriter.writeBool(bitWriter, z, "SH: luma_weight_l0_flag");
            if (z) {
                i5 = sliceHeader.pred_weight_table.luma_weight[i][i4];
                StringBuilder stringBuilder22 = new StringBuilder("SH: luma_weight_l");
                stringBuilder22.append(i);
                CAVLCWriter.writeSE(bitWriter, i5, stringBuilder22.toString());
                i5 = sliceHeader.pred_weight_table.luma_offset[i][i4];
                stringBuilder22 = new StringBuilder("SH: luma_offset_l");
                stringBuilder22.append(i);
                CAVLCWriter.writeSE(bitWriter, i5, stringBuilder22.toString());
            }
            if (seqParameterSet.chroma_format_idc == ColorSpace.MONO) {
                if (sliceHeader.pred_weight_table.chroma_offset[i][1][i4] != 0) {
                    z = false;
                    CAVLCWriter.writeBool(bitWriter, z, "SH: chroma_weight_l0_flag");
                    if (!z) {
                        for (i5 = 0; i5 < 2; i5++) {
                            i6 = sliceHeader.pred_weight_table.chroma_weight[i][i5][i4];
                            stringBuilder = new StringBuilder("SH: chroma_weight_l");
                            stringBuilder.append(i);
                            CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                            i6 = sliceHeader.pred_weight_table.chroma_offset[i][i5][i4];
                            stringBuilder = new StringBuilder("SH: chroma_offset_l");
                            stringBuilder.append(i);
                            CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                        }
                    }
                } else {
                    z = true;
                    CAVLCWriter.writeBool(bitWriter, z, "SH: chroma_weight_l0_flag");
                    if (!z) {
                        for (i5 = 0; i5 < 2; i5++) {
                            i6 = sliceHeader.pred_weight_table.chroma_weight[i][i5][i4];
                            stringBuilder = new StringBuilder("SH: chroma_weight_l");
                            stringBuilder.append(i);
                            CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                            i6 = sliceHeader.pred_weight_table.chroma_offset[i][i5][i4];
                            stringBuilder = new StringBuilder("SH: chroma_offset_l");
                            stringBuilder.append(i);
                            CAVLCWriter.writeSE(bitWriter, i6, stringBuilder.toString());
                        }
                    }
                }
            }
            i4++;
        }
    }

    private void writeRefPicListReordering(SliceHeader sliceHeader, BitWriter bitWriter) {
        boolean z = false;
        if (sliceHeader.slice_type.isInter()) {
            CAVLCWriter.writeBool(bitWriter, sliceHeader.refPicReordering[0] != null, "SH: ref_pic_list_reordering_flag_l0");
            writeReorderingList(sliceHeader.refPicReordering[0], bitWriter);
        }
        if (sliceHeader.slice_type == SliceType.B) {
            if (sliceHeader.refPicReordering[1] != null) {
                z = true;
            }
            CAVLCWriter.writeBool(bitWriter, z, "SH: ref_pic_list_reordering_flag_l1");
            writeReorderingList(sliceHeader.refPicReordering[1], bitWriter);
        }
    }

    private void writeReorderingList(int[][] iArr, BitWriter bitWriter) {
        if (iArr != null) {
            for (int i = 0; i < iArr[0].length; i++) {
                CAVLCWriter.writeUE(bitWriter, iArr[0][i], "SH: reordering_of_pic_nums_idc");
                CAVLCWriter.writeUE(bitWriter, iArr[1][i], "SH: abs_diff_pic_num_minus1");
            }
            CAVLCWriter.writeUE(bitWriter, 3, "SH: reordering_of_pic_nums_idc");
        }
    }
}
