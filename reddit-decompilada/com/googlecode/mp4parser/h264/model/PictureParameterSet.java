package com.googlecode.mp4parser.h264.model;

import com.googlecode.mp4parser.h264.read.BitstreamReader;
import com.googlecode.mp4parser.h264.read.CAVLCReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class PictureParameterSet extends BitstreamElement {
    public boolean f15233a;
    public int f15234b;
    public int f15235c;
    public int f15236d;
    public int f15237e;
    public int f15238f;
    public boolean f15239g;
    public int f15240h;
    public int f15241i;
    public boolean f15242j;
    public int f15243k;
    public int f15244l;
    public int f15245m;
    public int f15246n;
    public boolean f15247o;
    public boolean f15248p;
    public boolean f15249q;
    public int[] f15250r;
    public int[] f15251s;
    public int[] f15252t;
    public boolean f15253u;
    public int[] f15254v;
    public PPSExt f15255w;

    public static class PPSExt {
        public boolean f9017a;
        public ScalingMatrix f9018b = new ScalingMatrix();
        public int f9019c;
        public boolean[] f9020d;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("PPSExt{transform_8x8_mode_flag=");
            stringBuilder.append(this.f9017a);
            stringBuilder.append(", scalindMatrix=");
            stringBuilder.append(this.f9018b);
            stringBuilder.append(", second_chroma_qp_index_offset=");
            stringBuilder.append(this.f9019c);
            stringBuilder.append(", pic_scaling_list_present_flag=");
            stringBuilder.append(this.f9020d);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static PictureParameterSet m15192a(InputStream inputStream) throws IOException {
        int i;
        BitstreamReader cAVLCReader = new CAVLCReader(inputStream);
        inputStream = new PictureParameterSet();
        inputStream.f15237e = cAVLCReader.m15197a("PPS: pic_parameter_set_id");
        inputStream.f15238f = cAVLCReader.m15197a("PPS: seq_parameter_set_id");
        inputStream.f15233a = cAVLCReader.m15200c("PPS: entropy_coding_mode_flag");
        inputStream.f15239g = cAVLCReader.m15200c("PPS: pic_order_present_flag");
        inputStream.f15240h = cAVLCReader.m15197a("PPS: num_slice_groups_minus1");
        int i2 = 0;
        int i3 = 1;
        if (inputStream.f15240h > 0) {
            inputStream.f15241i = cAVLCReader.m15197a("PPS: slice_group_map_type");
            inputStream.f15250r = new int[(inputStream.f15240h + 1)];
            inputStream.f15251s = new int[(inputStream.f15240h + 1)];
            inputStream.f15252t = new int[(inputStream.f15240h + 1)];
            if (inputStream.f15241i == 0) {
                for (i = 0; i <= inputStream.f15240h; i++) {
                    inputStream.f15252t[i] = cAVLCReader.m15197a("PPS: run_length_minus1");
                }
            } else if (inputStream.f15241i == 2) {
                for (i = 0; i < inputStream.f15240h; i++) {
                    inputStream.f15250r[i] = cAVLCReader.m15197a("PPS: top_left");
                    inputStream.f15251s[i] = cAVLCReader.m15197a("PPS: bottom_right");
                }
            } else {
                int i4 = 3;
                if (!(inputStream.f15241i == 3 || inputStream.f15241i == 4)) {
                    if (inputStream.f15241i != 5) {
                        if (inputStream.f15241i == 6) {
                            if (inputStream.f15240h + 1 <= 4) {
                                i4 = inputStream.f15240h + 1 > 2 ? 2 : 1;
                            }
                            i = cAVLCReader.m15197a("PPS: pic_size_in_map_units_minus1");
                            inputStream.f15254v = new int[(i + 1)];
                            for (int i5 = 0; i5 <= i; i5++) {
                                int[] iArr = inputStream.f15254v;
                                StringBuilder stringBuilder = new StringBuilder("PPS: slice_group_id [");
                                stringBuilder.append(i5);
                                stringBuilder.append("]f");
                                iArr[i5] = (int) cAVLCReader.m15198a(i4, stringBuilder.toString());
                            }
                        }
                    }
                }
                inputStream.f15253u = cAVLCReader.m15200c("PPS: slice_group_change_direction_flag");
                inputStream.f15236d = cAVLCReader.m15197a("PPS: slice_group_change_rate_minus1");
            }
        }
        inputStream.f15234b = cAVLCReader.m15197a("PPS: num_ref_idx_l0_active_minus1");
        inputStream.f15235c = cAVLCReader.m15197a("PPS: num_ref_idx_l1_active_minus1");
        inputStream.f15242j = cAVLCReader.m15200c("PPS: weighted_pred_flag");
        inputStream.f15243k = (int) cAVLCReader.m15198a(2, "PPS: weighted_bipred_idc");
        inputStream.f15244l = cAVLCReader.m15199b("PPS: pic_init_qp_minus26");
        inputStream.f15245m = cAVLCReader.m15199b("PPS: pic_init_qs_minus26");
        inputStream.f15246n = cAVLCReader.m15199b("PPS: chroma_qp_index_offset");
        inputStream.f15247o = cAVLCReader.m15200c("PPS: deblocking_filter_control_present_flag");
        inputStream.f15248p = cAVLCReader.m15200c("PPS: constrained_intra_pred_flag");
        inputStream.f15249q = cAVLCReader.m15200c("PPS: redundant_pic_cnt_present_flag");
        if (cAVLCReader.f9060c == 8) {
            cAVLCReader.m7703b();
        }
        i = 1 << ((8 - cAVLCReader.f9060c) - 1);
        i = (((i << 1) - 1) & cAVLCReader.f9058a) == i ? 1 : 0;
        if (cAVLCReader.f9058a == -1 || (cAVLCReader.f9059b == -1 && i != 0)) {
            i3 = 0;
        }
        if (i3 != 0) {
            inputStream.f15255w = new PPSExt();
            inputStream.f15255w.f9017a = cAVLCReader.m15200c("PPS: transform_8x8_mode_flag");
            if (cAVLCReader.m15200c("PPS: pic_scaling_matrix_present_flag")) {
                while (i2 < (inputStream.f15255w.f9017a * 2) + 6) {
                    if (cAVLCReader.m15200c("PPS: pic_scaling_list_present_flag")) {
                        inputStream.f15255w.f9018b.f9023a = new ScalingList[8];
                        inputStream.f15255w.f9018b.f9024b = new ScalingList[8];
                        if (i2 < 6) {
                            inputStream.f15255w.f9018b.f9023a[i2] = ScalingList.m7700a(cAVLCReader, 16);
                        } else {
                            inputStream.f15255w.f9018b.f9024b[i2 - 6] = ScalingList.m7700a(cAVLCReader, 64);
                        }
                    }
                    i2++;
                }
            }
            inputStream.f15255w.f9019c = cAVLCReader.m15199b("PPS: second_chroma_qp_index_offset");
        }
        cAVLCReader.m15201d();
        return inputStream;
    }

    public int hashCode() {
        int i = 1237;
        int hashCode = 31 * (((((((((((((((((((((((((((((((((((((((((((Arrays.hashCode(this.f15251s) + 31) * 31) + this.f15246n) * 31) + (this.f15248p ? 1231 : 1237)) * 31) + (this.f15247o ? 1231 : 1237)) * 31) + (this.f15233a ? 1231 : 1237)) * 31) + (this.f15255w == null ? 0 : this.f15255w.hashCode())) * 31) + this.f15234b) * 31) + this.f15235c) * 31) + this.f15240h) * 31) + this.f15244l) * 31) + this.f15245m) * 31) + (this.f15239g ? 1231 : 1237)) * 31) + this.f15237e) * 31) + (this.f15249q ? 1231 : 1237)) * 31) + Arrays.hashCode(this.f15252t)) * 31) + this.f15238f) * 31) + (this.f15253u ? 1231 : 1237)) * 31) + this.f15236d) * 31) + Arrays.hashCode(this.f15254v)) * 31) + this.f15241i) * 31) + Arrays.hashCode(this.f15250r)) * 31) + this.f15243k);
        if (this.f15242j) {
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
        if (!Arrays.equals(this.f15251s, pictureParameterSet.f15251s) || this.f15246n != pictureParameterSet.f15246n || this.f15248p != pictureParameterSet.f15248p || this.f15247o != pictureParameterSet.f15247o || this.f15233a != pictureParameterSet.f15233a) {
            return false;
        }
        if (this.f15255w == null) {
            if (pictureParameterSet.f15255w != null) {
                return false;
            }
        } else if (!this.f15255w.equals(pictureParameterSet.f15255w)) {
            return false;
        }
        return this.f15234b == pictureParameterSet.f15234b && this.f15235c == pictureParameterSet.f15235c && this.f15240h == pictureParameterSet.f15240h && this.f15244l == pictureParameterSet.f15244l && this.f15245m == pictureParameterSet.f15245m && this.f15239g == pictureParameterSet.f15239g && this.f15237e == pictureParameterSet.f15237e && this.f15249q == pictureParameterSet.f15249q && Arrays.equals(this.f15252t, pictureParameterSet.f15252t) && this.f15238f == pictureParameterSet.f15238f && this.f15253u == pictureParameterSet.f15253u && this.f15236d == pictureParameterSet.f15236d && Arrays.equals(this.f15254v, pictureParameterSet.f15254v) && this.f15241i == pictureParameterSet.f15241i && Arrays.equals(this.f15250r, pictureParameterSet.f15250r) && this.f15243k == pictureParameterSet.f15243k && this.f15242j == pictureParameterSet.f15242j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PictureParameterSet{\n       entropy_coding_mode_flag=");
        stringBuilder.append(this.f15233a);
        stringBuilder.append(",\n       num_ref_idx_l0_active_minus1=");
        stringBuilder.append(this.f15234b);
        stringBuilder.append(",\n       num_ref_idx_l1_active_minus1=");
        stringBuilder.append(this.f15235c);
        stringBuilder.append(",\n       slice_group_change_rate_minus1=");
        stringBuilder.append(this.f15236d);
        stringBuilder.append(",\n       pic_parameter_set_id=");
        stringBuilder.append(this.f15237e);
        stringBuilder.append(",\n       seq_parameter_set_id=");
        stringBuilder.append(this.f15238f);
        stringBuilder.append(",\n       pic_order_present_flag=");
        stringBuilder.append(this.f15239g);
        stringBuilder.append(",\n       num_slice_groups_minus1=");
        stringBuilder.append(this.f15240h);
        stringBuilder.append(",\n       slice_group_map_type=");
        stringBuilder.append(this.f15241i);
        stringBuilder.append(",\n       weighted_pred_flag=");
        stringBuilder.append(this.f15242j);
        stringBuilder.append(",\n       weighted_bipred_idc=");
        stringBuilder.append(this.f15243k);
        stringBuilder.append(",\n       pic_init_qp_minus26=");
        stringBuilder.append(this.f15244l);
        stringBuilder.append(",\n       pic_init_qs_minus26=");
        stringBuilder.append(this.f15245m);
        stringBuilder.append(",\n       chroma_qp_index_offset=");
        stringBuilder.append(this.f15246n);
        stringBuilder.append(",\n       deblocking_filter_control_present_flag=");
        stringBuilder.append(this.f15247o);
        stringBuilder.append(",\n       constrained_intra_pred_flag=");
        stringBuilder.append(this.f15248p);
        stringBuilder.append(",\n       redundant_pic_cnt_present_flag=");
        stringBuilder.append(this.f15249q);
        stringBuilder.append(",\n       top_left=");
        stringBuilder.append(this.f15250r);
        stringBuilder.append(",\n       bottom_right=");
        stringBuilder.append(this.f15251s);
        stringBuilder.append(",\n       run_length_minus1=");
        stringBuilder.append(this.f15252t);
        stringBuilder.append(",\n       slice_group_change_direction_flag=");
        stringBuilder.append(this.f15253u);
        stringBuilder.append(",\n       slice_group_id=");
        stringBuilder.append(this.f15254v);
        stringBuilder.append(",\n       extended=");
        stringBuilder.append(this.f15255w);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
