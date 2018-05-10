package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.PredictionWeightTable;
import org.jcodec.codecs.h264.io.model.RefPicMarking;
import org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType;
import org.jcodec.codecs.h264.io.model.RefPicMarking.Instruction;
import org.jcodec.codecs.h264.io.model.RefPicMarkingIDR;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;

public class SliceHeaderReader {
    private static int CeilLog2(int i) {
        i--;
        int i2 = 0;
        while (i != 0) {
            i >>= 1;
            i2++;
        }
        return i2;
    }

    public SliceHeader readPart1(BitReader bitReader) {
        SliceHeader sliceHeader = new SliceHeader();
        sliceHeader.first_mb_in_slice = CAVLCReader.readUE(bitReader, "SH: first_mb_in_slice");
        int readUE = CAVLCReader.readUE(bitReader, "SH: slice_type");
        sliceHeader.slice_type = SliceType.fromValue(readUE % 5);
        sliceHeader.slice_type_restr = readUE / 5 > 0;
        sliceHeader.pic_parameter_set_id = CAVLCReader.readUE(bitReader, "SH: pic_parameter_set_id");
        return sliceHeader;
    }

    public SliceHeader readPart2(SliceHeader sliceHeader, NALUnit nALUnit, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, BitReader bitReader) {
        sliceHeader.pps = pictureParameterSet;
        sliceHeader.sps = seqParameterSet;
        sliceHeader.frame_num = CAVLCReader.readU(bitReader, seqParameterSet.log2_max_frame_num_minus4 + 4, "SH: frame_num");
        if (!seqParameterSet.frame_mbs_only_flag) {
            sliceHeader.field_pic_flag = CAVLCReader.readBool(bitReader, "SH: field_pic_flag");
            if (sliceHeader.field_pic_flag) {
                sliceHeader.bottom_field_flag = CAVLCReader.readBool(bitReader, "SH: bottom_field_flag");
            }
        }
        if (nALUnit.type == NALUnitType.IDR_SLICE) {
            sliceHeader.idr_pic_id = CAVLCReader.readUE(bitReader, "SH: idr_pic_id");
        }
        if (seqParameterSet.pic_order_cnt_type == 0) {
            sliceHeader.pic_order_cnt_lsb = CAVLCReader.readU(bitReader, seqParameterSet.log2_max_pic_order_cnt_lsb_minus4 + 4, "SH: pic_order_cnt_lsb");
            if (pictureParameterSet.pic_order_present_flag && !seqParameterSet.field_pic_flag) {
                sliceHeader.delta_pic_order_cnt_bottom = CAVLCReader.readSE(bitReader, "SH: delta_pic_order_cnt_bottom");
            }
        }
        sliceHeader.delta_pic_order_cnt = new int[2];
        if (seqParameterSet.pic_order_cnt_type == 1 && !seqParameterSet.delta_pic_order_always_zero_flag) {
            sliceHeader.delta_pic_order_cnt[0] = CAVLCReader.readSE(bitReader, "SH: delta_pic_order_cnt[0]");
            if (pictureParameterSet.pic_order_present_flag && !seqParameterSet.field_pic_flag) {
                sliceHeader.delta_pic_order_cnt[1] = CAVLCReader.readSE(bitReader, "SH: delta_pic_order_cnt[1]");
            }
        }
        if (pictureParameterSet.redundant_pic_cnt_present_flag) {
            sliceHeader.redundant_pic_cnt = CAVLCReader.readUE(bitReader, "SH: redundant_pic_cnt");
        }
        if (sliceHeader.slice_type == SliceType.B) {
            sliceHeader.direct_spatial_mv_pred_flag = CAVLCReader.readBool(bitReader, "SH: direct_spatial_mv_pred_flag");
        }
        if (sliceHeader.slice_type == SliceType.P || sliceHeader.slice_type == SliceType.SP || sliceHeader.slice_type == SliceType.B) {
            sliceHeader.num_ref_idx_active_override_flag = CAVLCReader.readBool(bitReader, "SH: num_ref_idx_active_override_flag");
            if (sliceHeader.num_ref_idx_active_override_flag) {
                sliceHeader.num_ref_idx_active_minus1[0] = CAVLCReader.readUE(bitReader, "SH: num_ref_idx_l0_active_minus1");
                if (sliceHeader.slice_type == SliceType.B) {
                    sliceHeader.num_ref_idx_active_minus1[1] = CAVLCReader.readUE(bitReader, "SH: num_ref_idx_l1_active_minus1");
                }
            }
        }
        readRefPicListReordering(sliceHeader, bitReader);
        if ((pictureParameterSet.weighted_pred_flag && (sliceHeader.slice_type == SliceType.P || sliceHeader.slice_type == SliceType.SP)) || (pictureParameterSet.weighted_bipred_idc == 1 && sliceHeader.slice_type == SliceType.B)) {
            readPredWeightTable(seqParameterSet, pictureParameterSet, sliceHeader, bitReader);
        }
        if (nALUnit.nal_ref_idc != 0) {
            readDecoderPicMarking(nALUnit, sliceHeader, bitReader);
        }
        if (!(pictureParameterSet.entropy_coding_mode_flag == null || sliceHeader.slice_type.isInter() == null)) {
            sliceHeader.cabac_init_idc = CAVLCReader.readUE(bitReader, "SH: cabac_init_idc");
        }
        sliceHeader.slice_qp_delta = CAVLCReader.readSE(bitReader, "SH: slice_qp_delta");
        if (sliceHeader.slice_type == SliceType.SP || sliceHeader.slice_type == SliceType.SI) {
            if (sliceHeader.slice_type == SliceType.SP) {
                sliceHeader.sp_for_switch_flag = CAVLCReader.readBool(bitReader, "SH: sp_for_switch_flag");
            }
            sliceHeader.slice_qs_delta = CAVLCReader.readSE(bitReader, "SH: slice_qs_delta");
        }
        if (pictureParameterSet.deblocking_filter_control_present_flag != null) {
            sliceHeader.disable_deblocking_filter_idc = CAVLCReader.readUE(bitReader, "SH: disable_deblocking_filter_idc");
            if (sliceHeader.disable_deblocking_filter_idc != 1) {
                sliceHeader.slice_alpha_c0_offset_div2 = CAVLCReader.readSE(bitReader, "SH: slice_alpha_c0_offset_div2");
                sliceHeader.slice_beta_offset_div2 = CAVLCReader.readSE(bitReader, "SH: slice_beta_offset_div2");
            }
        }
        if (pictureParameterSet.num_slice_groups_minus1 > null && pictureParameterSet.slice_group_map_type >= 3 && pictureParameterSet.slice_group_map_type <= 5) {
            nALUnit = (H264Utils.getPicHeightInMbs(seqParameterSet) * (seqParameterSet.pic_width_in_mbs_minus1 + 1)) / (pictureParameterSet.slice_group_change_rate_minus1 + 1);
            if ((H264Utils.getPicHeightInMbs(seqParameterSet) * (seqParameterSet.pic_width_in_mbs_minus1 + 1)) % (pictureParameterSet.slice_group_change_rate_minus1 + 1) > 0) {
                nALUnit++;
            }
            sliceHeader.slice_group_change_cycle = CAVLCReader.readU(bitReader, CeilLog2(nALUnit + 1), "SH: slice_group_change_cycle");
        }
        return sliceHeader;
    }

    private static void readDecoderPicMarking(NALUnit nALUnit, SliceHeader sliceHeader, BitReader bitReader) {
        if (nALUnit.type == NALUnitType.IDR_SLICE) {
            sliceHeader.refPicMarkingIDR = new RefPicMarkingIDR(CAVLCReader.readBool(bitReader, "SH: no_output_of_prior_pics_flag"), CAVLCReader.readBool(bitReader, "SH: long_term_reference_flag"));
            return;
        }
        if (CAVLCReader.readBool(bitReader, "SH: adaptive_ref_pic_marking_mode_flag") != null) {
            nALUnit = new ArrayList();
            int readUE;
            do {
                readUE = CAVLCReader.readUE(bitReader, "SH: memory_management_control_operation");
                Object obj = null;
                switch (readUE) {
                    case 1:
                        obj = new Instruction(InstrType.REMOVE_SHORT, CAVLCReader.readUE(bitReader, "SH: difference_of_pic_nums_minus1") + 1, 0);
                        break;
                    case 2:
                        obj = new Instruction(InstrType.REMOVE_LONG, CAVLCReader.readUE(bitReader, "SH: long_term_pic_num"), 0);
                        break;
                    case 3:
                        obj = new Instruction(InstrType.CONVERT_INTO_LONG, CAVLCReader.readUE(bitReader, "SH: difference_of_pic_nums_minus1") + 1, CAVLCReader.readUE(bitReader, "SH: long_term_frame_idx"));
                        break;
                    case 4:
                        obj = new Instruction(InstrType.TRUNK_LONG, CAVLCReader.readUE(bitReader, "SH: max_long_term_frame_idx_plus1") - 1, 0);
                        break;
                    case 5:
                        obj = new Instruction(InstrType.CLEAR, 0, 0);
                        break;
                    case 6:
                        obj = new Instruction(InstrType.MARK_LONG, CAVLCReader.readUE(bitReader, "SH: long_term_frame_idx"), 0);
                        break;
                    default:
                        break;
                }
                if (obj != null) {
                    nALUnit.add(obj);
                    continue;
                }
            } while (readUE != 0);
            sliceHeader.refPicMarkingNonIDR = new RefPicMarking((Instruction[]) nALUnit.toArray(new Instruction[0]));
        }
    }

    private static void readPredWeightTable(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, SliceHeader sliceHeader, BitReader bitReader) {
        sliceHeader.pred_weight_table = new PredictionWeightTable();
        int[] iArr = sliceHeader.num_ref_idx_active_override_flag ? sliceHeader.num_ref_idx_active_minus1 : pictureParameterSet.num_ref_idx_active_minus1;
        int[] iArr2 = new int[]{iArr[0] + 1, iArr[1] + 1};
        sliceHeader.pred_weight_table.luma_log2_weight_denom = CAVLCReader.readUE(bitReader, "SH: luma_log2_weight_denom");
        if (seqParameterSet.chroma_format_idc != ColorSpace.MONO) {
            sliceHeader.pred_weight_table.chroma_log2_weight_denom = CAVLCReader.readUE(bitReader, "SH: chroma_log2_weight_denom");
        }
        int i = 1 << sliceHeader.pred_weight_table.luma_log2_weight_denom;
        int i2 = 1 << sliceHeader.pred_weight_table.chroma_log2_weight_denom;
        for (int i3 = 0; i3 < 2; i3++) {
            sliceHeader.pred_weight_table.luma_weight[i3] = new int[iArr2[i3]];
            sliceHeader.pred_weight_table.luma_offset[i3] = new int[iArr2[i3]];
            sliceHeader.pred_weight_table.chroma_weight[i3] = (int[][]) Array.newInstance(int.class, new int[]{2, iArr2[i3]});
            sliceHeader.pred_weight_table.chroma_offset[i3] = (int[][]) Array.newInstance(int.class, new int[]{2, iArr2[i3]});
            for (int i4 = 0; i4 < iArr2[i3]; i4++) {
                sliceHeader.pred_weight_table.luma_weight[i3][i4] = i;
                sliceHeader.pred_weight_table.luma_offset[i3][i4] = 0;
                sliceHeader.pred_weight_table.chroma_weight[i3][0][i4] = i2;
                sliceHeader.pred_weight_table.chroma_offset[i3][0][i4] = 0;
                sliceHeader.pred_weight_table.chroma_weight[i3][1][i4] = i2;
                sliceHeader.pred_weight_table.chroma_offset[i3][1][i4] = 0;
            }
        }
        readWeightOffset(seqParameterSet, pictureParameterSet, sliceHeader, bitReader, iArr2, 0);
        if (sliceHeader.slice_type == SliceType.B) {
            readWeightOffset(seqParameterSet, pictureParameterSet, sliceHeader, bitReader, iArr2, 1);
        }
    }

    private static void readWeightOffset(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, SliceHeader sliceHeader, BitReader bitReader, int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr[i]; i2++) {
            if (CAVLCReader.readBool(bitReader, "SH: luma_weight_l0_flag")) {
                sliceHeader.pred_weight_table.luma_weight[i][i2] = CAVLCReader.readSE(bitReader, "SH: weight");
                sliceHeader.pred_weight_table.luma_offset[i][i2] = CAVLCReader.readSE(bitReader, "SH: offset");
            }
            if (seqParameterSet.chroma_format_idc != ColorSpace.MONO && CAVLCReader.readBool(bitReader, "SH: chroma_weight_l0_flag")) {
                sliceHeader.pred_weight_table.chroma_weight[i][0][i2] = CAVLCReader.readSE(bitReader, "SH: weight");
                sliceHeader.pred_weight_table.chroma_offset[i][0][i2] = CAVLCReader.readSE(bitReader, "SH: offset");
                sliceHeader.pred_weight_table.chroma_weight[i][1][i2] = CAVLCReader.readSE(bitReader, "SH: weight");
                sliceHeader.pred_weight_table.chroma_offset[i][1][i2] = CAVLCReader.readSE(bitReader, "SH: offset");
            }
        }
    }

    private static void readRefPicListReordering(SliceHeader sliceHeader, BitReader bitReader) {
        sliceHeader.refPicReordering = new int[2][][];
        if (sliceHeader.slice_type.isInter() && CAVLCReader.readBool(bitReader, "SH: ref_pic_list_reordering_flag_l0")) {
            sliceHeader.refPicReordering[0] = readReorderingEntries(bitReader);
        }
        if (sliceHeader.slice_type == SliceType.B && CAVLCReader.readBool(bitReader, "SH: ref_pic_list_reordering_flag_l1")) {
            sliceHeader.refPicReordering[1] = readReorderingEntries(bitReader);
        }
    }

    private static int[][] readReorderingEntries(BitReader bitReader) {
        IntArrayList intArrayList = new IntArrayList();
        IntArrayList intArrayList2 = new IntArrayList();
        while (true) {
            int readUE = CAVLCReader.readUE(bitReader, "SH: reordering_of_pic_nums_idc");
            if (readUE != 3) {
                intArrayList.add(readUE);
                intArrayList2.add(CAVLCReader.readUE(bitReader, "SH: abs_diff_pic_num_minus1"));
            } else {
                return new int[][]{intArrayList.toArray(), intArrayList2.toArray()};
            }
        }
    }
}
