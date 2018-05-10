package com.googlecode.mp4parser.h264.model;

import com.googlecode.mp4parser.h264.model.VUIParameters.BitstreamRestriction;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import java.io.IOException;
import java.io.InputStream;

public class SeqParameterSet extends BitstreamElement {
    public boolean f15256A;
    public int f15257B;
    public int f15258C;
    public int f15259D;
    public boolean f15260E;
    public boolean f15261F;
    public boolean f15262G;
    public int f15263H;
    public int f15264I;
    public int f15265J;
    public int f15266K;
    public int[] f15267L;
    public VUIParameters f15268M;
    public ScalingMatrix f15269N;
    public int f15270O;
    public int f15271a;
    public boolean f15272b;
    public boolean f15273c;
    public boolean f15274d;
    public int f15275e;
    public boolean f15276f;
    public boolean f15277g;
    public boolean f15278h;
    public ChromaFormat f15279i;
    public int f15280j;
    public int f15281k;
    public int f15282l;
    public int f15283m;
    public int f15284n;
    public int f15285o;
    public boolean f15286p;
    public int f15287q;
    public long f15288r;
    public boolean f15289s;
    public boolean f15290t;
    public boolean f15291u;
    public boolean f15292v;
    public boolean f15293w;
    public boolean f15294x;
    public int f15295y;
    public int f15296z;

    public static SeqParameterSet m15194a(InputStream inputStream) throws IOException {
        VUIParameters vUIParameters;
        boolean c;
        boolean c2;
        CAVLCReader cAVLCReader = new CAVLCReader(inputStream);
        inputStream = new SeqParameterSet();
        inputStream.f15287q = (int) cAVLCReader.m15198a(8, "SPS: profile_idc");
        inputStream.f15289s = cAVLCReader.m15200c("SPS: constraint_set_0_flag");
        inputStream.f15290t = cAVLCReader.m15200c("SPS: constraint_set_1_flag");
        inputStream.f15291u = cAVLCReader.m15200c("SPS: constraint_set_2_flag");
        inputStream.f15292v = cAVLCReader.m15200c("SPS: constraint_set_3_flag");
        inputStream.f15293w = cAVLCReader.m15200c("SPS: constraint_set_4_flag");
        inputStream.f15294x = cAVLCReader.m15200c("SPS: constraint_set_5_flag");
        inputStream.f15288r = cAVLCReader.m15198a(2, "SPS: reserved_zero_2bits");
        inputStream.f15295y = (int) cAVLCReader.m15198a(8, "SPS: level_idc");
        inputStream.f15296z = cAVLCReader.m15197a("SPS: seq_parameter_set_id");
        int i = 0;
        if (!(inputStream.f15287q == 100 || inputStream.f15287q == 110 || inputStream.f15287q == 122)) {
            if (inputStream.f15287q != 144) {
                inputStream.f15279i = ChromaFormat.f9001b;
                inputStream.f15280j = cAVLCReader.m15197a("SPS: log2_max_frame_num_minus4");
                inputStream.f15271a = cAVLCReader.m15197a("SPS: pic_order_cnt_type");
                if (inputStream.f15271a == 0) {
                    inputStream.f15281k = cAVLCReader.m15197a("SPS: log2_max_pic_order_cnt_lsb_minus4");
                } else if (inputStream.f15271a == 1) {
                    inputStream.f15273c = cAVLCReader.m15200c("SPS: delta_pic_order_always_zero_flag");
                    inputStream.f15257B = cAVLCReader.m15199b("SPS: offset_for_non_ref_pic");
                    inputStream.f15258C = cAVLCReader.m15199b("SPS: offset_for_top_to_bottom_field");
                    inputStream.f15270O = cAVLCReader.m15197a("SPS: num_ref_frames_in_pic_order_cnt_cycle");
                    inputStream.f15267L = new int[inputStream.f15270O];
                    while (i < inputStream.f15270O) {
                        int[] iArr = inputStream.f15267L;
                        StringBuilder stringBuilder = new StringBuilder("SPS: offsetForRefFrame [");
                        stringBuilder.append(i);
                        stringBuilder.append("]");
                        iArr[i] = cAVLCReader.m15199b(stringBuilder.toString());
                        i++;
                    }
                }
                inputStream.f15259D = cAVLCReader.m15197a("SPS: num_ref_frames");
                inputStream.f15260E = cAVLCReader.m15200c("SPS: gaps_in_frame_num_value_allowed_flag");
                inputStream.f15283m = cAVLCReader.m15197a("SPS: pic_width_in_mbs_minus1");
                inputStream.f15282l = cAVLCReader.m15197a("SPS: pic_height_in_map_units_minus1");
                inputStream.f15261F = cAVLCReader.m15200c("SPS: frame_mbs_only_flag");
                if (!inputStream.f15261F) {
                    inputStream.f15277g = cAVLCReader.m15200c("SPS: mb_adaptive_frame_field_flag");
                }
                inputStream.f15278h = cAVLCReader.m15200c("SPS: direct_8x8_inference_flag");
                inputStream.f15262G = cAVLCReader.m15200c("SPS: frame_cropping_flag");
                if (inputStream.f15262G) {
                    inputStream.f15263H = cAVLCReader.m15197a("SPS: frame_crop_left_offset");
                    inputStream.f15264I = cAVLCReader.m15197a("SPS: frame_crop_right_offset");
                    inputStream.f15265J = cAVLCReader.m15197a("SPS: frame_crop_top_offset");
                    inputStream.f15266K = cAVLCReader.m15197a("SPS: frame_crop_bottom_offset");
                }
                if (cAVLCReader.m15200c("SPS: vui_parameters_present_flag")) {
                    vUIParameters = new VUIParameters();
                    vUIParameters.f9032a = cAVLCReader.m15200c("VUI: aspect_ratio_info_present_flag");
                    if (vUIParameters.f9032a) {
                        vUIParameters.f9056y = AspectRatio.m7698a((int) cAVLCReader.m15198a(8, "VUI: aspect_ratio"));
                        if (vUIParameters.f9056y == AspectRatio.f8998a) {
                            vUIParameters.f9033b = (int) cAVLCReader.m15198a(16, "VUI: sar_width");
                            vUIParameters.f9034c = (int) cAVLCReader.m15198a(16, "VUI: sar_height");
                        }
                    }
                    vUIParameters.f9035d = cAVLCReader.m15200c("VUI: overscan_info_present_flag");
                    if (vUIParameters.f9035d) {
                        vUIParameters.f9036e = cAVLCReader.m15200c("VUI: overscan_appropriate_flag");
                    }
                    vUIParameters.f9037f = cAVLCReader.m15200c("VUI: video_signal_type_present_flag");
                    if (vUIParameters.f9037f) {
                        vUIParameters.f9038g = (int) cAVLCReader.m15198a(3, "VUI: video_format");
                        vUIParameters.f9039h = cAVLCReader.m15200c("VUI: video_full_range_flag");
                        vUIParameters.f9040i = cAVLCReader.m15200c("VUI: colour_description_present_flag");
                        if (vUIParameters.f9040i) {
                            vUIParameters.f9041j = (int) cAVLCReader.m15198a(8, "VUI: colour_primaries");
                            vUIParameters.f9042k = (int) cAVLCReader.m15198a(8, "VUI: transfer_characteristics");
                            vUIParameters.f9043l = (int) cAVLCReader.m15198a(8, "VUI: matrix_coefficients");
                        }
                    }
                    vUIParameters.f9044m = cAVLCReader.m15200c("VUI: chroma_loc_info_present_flag");
                    if (vUIParameters.f9044m) {
                        vUIParameters.f9045n = cAVLCReader.m15197a("VUI chroma_sample_loc_type_top_field");
                        vUIParameters.f9046o = cAVLCReader.m15197a("VUI chroma_sample_loc_type_bottom_field");
                    }
                    vUIParameters.f9047p = cAVLCReader.m15200c("VUI: timing_info_present_flag");
                    if (vUIParameters.f9047p) {
                        vUIParameters.f9048q = (int) cAVLCReader.m15198a(32, "VUI: num_units_in_tick");
                        vUIParameters.f9049r = (int) cAVLCReader.m15198a(32, "VUI: time_scale");
                        vUIParameters.f9050s = cAVLCReader.m15200c("VUI: fixed_frame_rate_flag");
                    }
                    c = cAVLCReader.m15200c("VUI: nal_hrd_parameters_present_flag");
                    if (c) {
                        vUIParameters.f9053v = m15193a(cAVLCReader);
                    }
                    c2 = cAVLCReader.m15200c("VUI: vcl_hrd_parameters_present_flag");
                    if (c2) {
                        vUIParameters.f9054w = m15193a(cAVLCReader);
                    }
                    if (c || c2) {
                        vUIParameters.f9051t = cAVLCReader.m15200c("VUI: low_delay_hrd_flag");
                    }
                    vUIParameters.f9052u = cAVLCReader.m15200c("VUI: pic_struct_present_flag");
                    if (cAVLCReader.m15200c("VUI: bitstream_restriction_flag")) {
                        vUIParameters.f9055x = new BitstreamRestriction();
                        vUIParameters.f9055x.f9025a = cAVLCReader.m15200c("VUI: motion_vectors_over_pic_boundaries_flag");
                        vUIParameters.f9055x.f9026b = cAVLCReader.m15197a("VUI max_bytes_per_pic_denom");
                        vUIParameters.f9055x.f9027c = cAVLCReader.m15197a("VUI max_bits_per_mb_denom");
                        vUIParameters.f9055x.f9028d = cAVLCReader.m15197a("VUI log2_max_mv_length_horizontal");
                        vUIParameters.f9055x.f9029e = cAVLCReader.m15197a("VUI log2_max_mv_length_vertical");
                        vUIParameters.f9055x.f9030f = cAVLCReader.m15197a("VUI num_reorder_frames");
                        vUIParameters.f9055x.f9031g = cAVLCReader.m15197a("VUI max_dec_frame_buffering");
                    }
                    inputStream.f15268M = vUIParameters;
                }
                cAVLCReader.m15201d();
                return inputStream;
            }
        }
        inputStream.f15279i = ChromaFormat.m7699a(cAVLCReader.m15197a("SPS: chroma_format_idc"));
        if (inputStream.f15279i == ChromaFormat.f9003d) {
            inputStream.f15256A = cAVLCReader.m15200c("SPS: residual_color_transform_flag");
        }
        inputStream.f15284n = cAVLCReader.m15197a("SPS: bit_depth_luma_minus8");
        inputStream.f15285o = cAVLCReader.m15197a("SPS: bit_depth_chroma_minus8");
        inputStream.f15286p = cAVLCReader.m15200c("SPS: qpprime_y_zero_transform_bypass_flag");
        if (cAVLCReader.m15200c("SPS: seq_scaling_matrix_present_lag")) {
            inputStream.f15269N = new ScalingMatrix();
            for (int i2 = 0; i2 < 8; i2++) {
                if (cAVLCReader.m15200c("SPS: seqScalingListPresentFlag")) {
                    inputStream.f15269N.f9023a = new ScalingList[8];
                    inputStream.f15269N.f9024b = new ScalingList[8];
                    if (i2 < 6) {
                        inputStream.f15269N.f9023a[i2] = ScalingList.m7700a(cAVLCReader, 16);
                    } else {
                        inputStream.f15269N.f9024b[i2 - 6] = ScalingList.m7700a(cAVLCReader, 64);
                    }
                }
            }
        }
        inputStream.f15280j = cAVLCReader.m15197a("SPS: log2_max_frame_num_minus4");
        inputStream.f15271a = cAVLCReader.m15197a("SPS: pic_order_cnt_type");
        if (inputStream.f15271a == 0) {
            inputStream.f15281k = cAVLCReader.m15197a("SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (inputStream.f15271a == 1) {
            inputStream.f15273c = cAVLCReader.m15200c("SPS: delta_pic_order_always_zero_flag");
            inputStream.f15257B = cAVLCReader.m15199b("SPS: offset_for_non_ref_pic");
            inputStream.f15258C = cAVLCReader.m15199b("SPS: offset_for_top_to_bottom_field");
            inputStream.f15270O = cAVLCReader.m15197a("SPS: num_ref_frames_in_pic_order_cnt_cycle");
            inputStream.f15267L = new int[inputStream.f15270O];
            while (i < inputStream.f15270O) {
                int[] iArr2 = inputStream.f15267L;
                StringBuilder stringBuilder2 = new StringBuilder("SPS: offsetForRefFrame [");
                stringBuilder2.append(i);
                stringBuilder2.append("]");
                iArr2[i] = cAVLCReader.m15199b(stringBuilder2.toString());
                i++;
            }
        }
        inputStream.f15259D = cAVLCReader.m15197a("SPS: num_ref_frames");
        inputStream.f15260E = cAVLCReader.m15200c("SPS: gaps_in_frame_num_value_allowed_flag");
        inputStream.f15283m = cAVLCReader.m15197a("SPS: pic_width_in_mbs_minus1");
        inputStream.f15282l = cAVLCReader.m15197a("SPS: pic_height_in_map_units_minus1");
        inputStream.f15261F = cAVLCReader.m15200c("SPS: frame_mbs_only_flag");
        if (inputStream.f15261F) {
            inputStream.f15277g = cAVLCReader.m15200c("SPS: mb_adaptive_frame_field_flag");
        }
        inputStream.f15278h = cAVLCReader.m15200c("SPS: direct_8x8_inference_flag");
        inputStream.f15262G = cAVLCReader.m15200c("SPS: frame_cropping_flag");
        if (inputStream.f15262G) {
            inputStream.f15263H = cAVLCReader.m15197a("SPS: frame_crop_left_offset");
            inputStream.f15264I = cAVLCReader.m15197a("SPS: frame_crop_right_offset");
            inputStream.f15265J = cAVLCReader.m15197a("SPS: frame_crop_top_offset");
            inputStream.f15266K = cAVLCReader.m15197a("SPS: frame_crop_bottom_offset");
        }
        if (cAVLCReader.m15200c("SPS: vui_parameters_present_flag")) {
            vUIParameters = new VUIParameters();
            vUIParameters.f9032a = cAVLCReader.m15200c("VUI: aspect_ratio_info_present_flag");
            if (vUIParameters.f9032a) {
                vUIParameters.f9056y = AspectRatio.m7698a((int) cAVLCReader.m15198a(8, "VUI: aspect_ratio"));
                if (vUIParameters.f9056y == AspectRatio.f8998a) {
                    vUIParameters.f9033b = (int) cAVLCReader.m15198a(16, "VUI: sar_width");
                    vUIParameters.f9034c = (int) cAVLCReader.m15198a(16, "VUI: sar_height");
                }
            }
            vUIParameters.f9035d = cAVLCReader.m15200c("VUI: overscan_info_present_flag");
            if (vUIParameters.f9035d) {
                vUIParameters.f9036e = cAVLCReader.m15200c("VUI: overscan_appropriate_flag");
            }
            vUIParameters.f9037f = cAVLCReader.m15200c("VUI: video_signal_type_present_flag");
            if (vUIParameters.f9037f) {
                vUIParameters.f9038g = (int) cAVLCReader.m15198a(3, "VUI: video_format");
                vUIParameters.f9039h = cAVLCReader.m15200c("VUI: video_full_range_flag");
                vUIParameters.f9040i = cAVLCReader.m15200c("VUI: colour_description_present_flag");
                if (vUIParameters.f9040i) {
                    vUIParameters.f9041j = (int) cAVLCReader.m15198a(8, "VUI: colour_primaries");
                    vUIParameters.f9042k = (int) cAVLCReader.m15198a(8, "VUI: transfer_characteristics");
                    vUIParameters.f9043l = (int) cAVLCReader.m15198a(8, "VUI: matrix_coefficients");
                }
            }
            vUIParameters.f9044m = cAVLCReader.m15200c("VUI: chroma_loc_info_present_flag");
            if (vUIParameters.f9044m) {
                vUIParameters.f9045n = cAVLCReader.m15197a("VUI chroma_sample_loc_type_top_field");
                vUIParameters.f9046o = cAVLCReader.m15197a("VUI chroma_sample_loc_type_bottom_field");
            }
            vUIParameters.f9047p = cAVLCReader.m15200c("VUI: timing_info_present_flag");
            if (vUIParameters.f9047p) {
                vUIParameters.f9048q = (int) cAVLCReader.m15198a(32, "VUI: num_units_in_tick");
                vUIParameters.f9049r = (int) cAVLCReader.m15198a(32, "VUI: time_scale");
                vUIParameters.f9050s = cAVLCReader.m15200c("VUI: fixed_frame_rate_flag");
            }
            c = cAVLCReader.m15200c("VUI: nal_hrd_parameters_present_flag");
            if (c) {
                vUIParameters.f9053v = m15193a(cAVLCReader);
            }
            c2 = cAVLCReader.m15200c("VUI: vcl_hrd_parameters_present_flag");
            if (c2) {
                vUIParameters.f9054w = m15193a(cAVLCReader);
            }
            vUIParameters.f9051t = cAVLCReader.m15200c("VUI: low_delay_hrd_flag");
            vUIParameters.f9052u = cAVLCReader.m15200c("VUI: pic_struct_present_flag");
            if (cAVLCReader.m15200c("VUI: bitstream_restriction_flag")) {
                vUIParameters.f9055x = new BitstreamRestriction();
                vUIParameters.f9055x.f9025a = cAVLCReader.m15200c("VUI: motion_vectors_over_pic_boundaries_flag");
                vUIParameters.f9055x.f9026b = cAVLCReader.m15197a("VUI max_bytes_per_pic_denom");
                vUIParameters.f9055x.f9027c = cAVLCReader.m15197a("VUI max_bits_per_mb_denom");
                vUIParameters.f9055x.f9028d = cAVLCReader.m15197a("VUI log2_max_mv_length_horizontal");
                vUIParameters.f9055x.f9029e = cAVLCReader.m15197a("VUI log2_max_mv_length_vertical");
                vUIParameters.f9055x.f9030f = cAVLCReader.m15197a("VUI num_reorder_frames");
                vUIParameters.f9055x.f9031g = cAVLCReader.m15197a("VUI max_dec_frame_buffering");
            }
            inputStream.f15268M = vUIParameters;
        }
        cAVLCReader.m15201d();
        return inputStream;
    }

    private static HRDParameters m15193a(CAVLCReader cAVLCReader) throws IOException {
        HRDParameters hRDParameters = new HRDParameters();
        hRDParameters.f9007a = cAVLCReader.m15197a("SPS: cpb_cnt_minus1");
        hRDParameters.f9008b = (int) cAVLCReader.m15198a(4, "HRD: bit_rate_scale");
        hRDParameters.f9009c = (int) cAVLCReader.m15198a(4, "HRD: cpb_size_scale");
        hRDParameters.f9010d = new int[(hRDParameters.f9007a + 1)];
        hRDParameters.f9011e = new int[(hRDParameters.f9007a + 1)];
        hRDParameters.f9012f = new boolean[(hRDParameters.f9007a + 1)];
        for (int i = 0; i <= hRDParameters.f9007a; i++) {
            hRDParameters.f9010d[i] = cAVLCReader.m15197a("HRD: bit_rate_value_minus1");
            hRDParameters.f9011e[i] = cAVLCReader.m15197a("HRD: cpb_size_value_minus1");
            hRDParameters.f9012f[i] = cAVLCReader.m15200c("HRD: cbr_flag");
        }
        hRDParameters.f9013g = (int) cAVLCReader.m15198a(5, "HRD: initial_cpb_removal_delay_length_minus1");
        hRDParameters.f9014h = (int) cAVLCReader.m15198a(5, "HRD: cpb_removal_delay_length_minus1");
        hRDParameters.f9015i = (int) cAVLCReader.m15198a(5, "HRD: dpb_output_delay_length_minus1");
        hRDParameters.f9016j = (int) cAVLCReader.m15198a(5, "HRD: time_offset_length");
        return hRDParameters;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SeqParameterSet{ \n        pic_order_cnt_type=");
        stringBuilder.append(this.f15271a);
        stringBuilder.append(", \n        field_pic_flag=");
        stringBuilder.append(this.f15272b);
        stringBuilder.append(", \n        delta_pic_order_always_zero_flag=");
        stringBuilder.append(this.f15273c);
        stringBuilder.append(", \n        weighted_pred_flag=");
        stringBuilder.append(this.f15274d);
        stringBuilder.append(", \n        weighted_bipred_idc=");
        stringBuilder.append(this.f15275e);
        stringBuilder.append(", \n        entropy_coding_mode_flag=");
        stringBuilder.append(this.f15276f);
        stringBuilder.append(", \n        mb_adaptive_frame_field_flag=");
        stringBuilder.append(this.f15277g);
        stringBuilder.append(", \n        direct_8x8_inference_flag=");
        stringBuilder.append(this.f15278h);
        stringBuilder.append(", \n        chroma_format_idc=");
        stringBuilder.append(this.f15279i);
        stringBuilder.append(", \n        log2_max_frame_num_minus4=");
        stringBuilder.append(this.f15280j);
        stringBuilder.append(", \n        log2_max_pic_order_cnt_lsb_minus4=");
        stringBuilder.append(this.f15281k);
        stringBuilder.append(", \n        pic_height_in_map_units_minus1=");
        stringBuilder.append(this.f15282l);
        stringBuilder.append(", \n        pic_width_in_mbs_minus1=");
        stringBuilder.append(this.f15283m);
        stringBuilder.append(", \n        bit_depth_luma_minus8=");
        stringBuilder.append(this.f15284n);
        stringBuilder.append(", \n        bit_depth_chroma_minus8=");
        stringBuilder.append(this.f15285o);
        stringBuilder.append(", \n        qpprime_y_zero_transform_bypass_flag=");
        stringBuilder.append(this.f15286p);
        stringBuilder.append(", \n        profile_idc=");
        stringBuilder.append(this.f15287q);
        stringBuilder.append(", \n        constraint_set_0_flag=");
        stringBuilder.append(this.f15289s);
        stringBuilder.append(", \n        constraint_set_1_flag=");
        stringBuilder.append(this.f15290t);
        stringBuilder.append(", \n        constraint_set_2_flag=");
        stringBuilder.append(this.f15291u);
        stringBuilder.append(", \n        constraint_set_3_flag=");
        stringBuilder.append(this.f15292v);
        stringBuilder.append(", \n        constraint_set_4_flag=");
        stringBuilder.append(this.f15293w);
        stringBuilder.append(", \n        constraint_set_5_flag=");
        stringBuilder.append(this.f15294x);
        stringBuilder.append(", \n        level_idc=");
        stringBuilder.append(this.f15295y);
        stringBuilder.append(", \n        seq_parameter_set_id=");
        stringBuilder.append(this.f15296z);
        stringBuilder.append(", \n        residual_color_transform_flag=");
        stringBuilder.append(this.f15256A);
        stringBuilder.append(", \n        offset_for_non_ref_pic=");
        stringBuilder.append(this.f15257B);
        stringBuilder.append(", \n        offset_for_top_to_bottom_field=");
        stringBuilder.append(this.f15258C);
        stringBuilder.append(", \n        num_ref_frames=");
        stringBuilder.append(this.f15259D);
        stringBuilder.append(", \n        gaps_in_frame_num_value_allowed_flag=");
        stringBuilder.append(this.f15260E);
        stringBuilder.append(", \n        frame_mbs_only_flag=");
        stringBuilder.append(this.f15261F);
        stringBuilder.append(", \n        frame_cropping_flag=");
        stringBuilder.append(this.f15262G);
        stringBuilder.append(", \n        frame_crop_left_offset=");
        stringBuilder.append(this.f15263H);
        stringBuilder.append(", \n        frame_crop_right_offset=");
        stringBuilder.append(this.f15264I);
        stringBuilder.append(", \n        frame_crop_top_offset=");
        stringBuilder.append(this.f15265J);
        stringBuilder.append(", \n        frame_crop_bottom_offset=");
        stringBuilder.append(this.f15266K);
        stringBuilder.append(", \n        offsetForRefFrame=");
        stringBuilder.append(this.f15267L);
        stringBuilder.append(", \n        vuiParams=");
        stringBuilder.append(this.f15268M);
        stringBuilder.append(", \n        scalingMatrix=");
        stringBuilder.append(this.f15269N);
        stringBuilder.append(", \n        num_ref_frames_in_pic_order_cnt_cycle=");
        stringBuilder.append(this.f15270O);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
