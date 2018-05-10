package com.googlecode.mp4parser.h264.model;

public class VUIParameters {
    public boolean f9032a;
    public int f9033b;
    public int f9034c;
    public boolean f9035d;
    public boolean f9036e;
    public boolean f9037f;
    public int f9038g;
    public boolean f9039h;
    public boolean f9040i;
    public int f9041j;
    public int f9042k;
    public int f9043l;
    public boolean f9044m;
    public int f9045n;
    public int f9046o;
    public boolean f9047p;
    public int f9048q;
    public int f9049r;
    public boolean f9050s;
    public boolean f9051t;
    public boolean f9052u;
    public HRDParameters f9053v;
    public HRDParameters f9054w;
    public BitstreamRestriction f9055x;
    public AspectRatio f9056y;

    public static class BitstreamRestriction {
        public boolean f9025a;
        public int f9026b;
        public int f9027c;
        public int f9028d;
        public int f9029e;
        public int f9030f;
        public int f9031g;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("BitstreamRestriction{");
            stringBuilder.append("motion_vectors_over_pic_boundaries_flag=");
            stringBuilder.append(this.f9025a);
            stringBuilder.append(", max_bytes_per_pic_denom=");
            stringBuilder.append(this.f9026b);
            stringBuilder.append(", max_bits_per_mb_denom=");
            stringBuilder.append(this.f9027c);
            stringBuilder.append(", log2_max_mv_length_horizontal=");
            stringBuilder.append(this.f9028d);
            stringBuilder.append(", log2_max_mv_length_vertical=");
            stringBuilder.append(this.f9029e);
            stringBuilder.append(", num_reorder_frames=");
            stringBuilder.append(this.f9030f);
            stringBuilder.append(", max_dec_frame_buffering=");
            stringBuilder.append(this.f9031g);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("VUIParameters{\naspect_ratio_info_present_flag=");
        stringBuilder.append(this.f9032a);
        stringBuilder.append("\n, sar_width=");
        stringBuilder.append(this.f9033b);
        stringBuilder.append("\n, sar_height=");
        stringBuilder.append(this.f9034c);
        stringBuilder.append("\n, overscan_info_present_flag=");
        stringBuilder.append(this.f9035d);
        stringBuilder.append("\n, overscan_appropriate_flag=");
        stringBuilder.append(this.f9036e);
        stringBuilder.append("\n, video_signal_type_present_flag=");
        stringBuilder.append(this.f9037f);
        stringBuilder.append("\n, video_format=");
        stringBuilder.append(this.f9038g);
        stringBuilder.append("\n, video_full_range_flag=");
        stringBuilder.append(this.f9039h);
        stringBuilder.append("\n, colour_description_present_flag=");
        stringBuilder.append(this.f9040i);
        stringBuilder.append("\n, colour_primaries=");
        stringBuilder.append(this.f9041j);
        stringBuilder.append("\n, transfer_characteristics=");
        stringBuilder.append(this.f9042k);
        stringBuilder.append("\n, matrix_coefficients=");
        stringBuilder.append(this.f9043l);
        stringBuilder.append("\n, chroma_loc_info_present_flag=");
        stringBuilder.append(this.f9044m);
        stringBuilder.append("\n, chroma_sample_loc_type_top_field=");
        stringBuilder.append(this.f9045n);
        stringBuilder.append("\n, chroma_sample_loc_type_bottom_field=");
        stringBuilder.append(this.f9046o);
        stringBuilder.append("\n, timing_info_present_flag=");
        stringBuilder.append(this.f9047p);
        stringBuilder.append("\n, num_units_in_tick=");
        stringBuilder.append(this.f9048q);
        stringBuilder.append("\n, time_scale=");
        stringBuilder.append(this.f9049r);
        stringBuilder.append("\n, fixed_frame_rate_flag=");
        stringBuilder.append(this.f9050s);
        stringBuilder.append("\n, low_delay_hrd_flag=");
        stringBuilder.append(this.f9051t);
        stringBuilder.append("\n, pic_struct_present_flag=");
        stringBuilder.append(this.f9052u);
        stringBuilder.append("\n, nalHRDParams=");
        stringBuilder.append(this.f9053v);
        stringBuilder.append("\n, vclHRDParams=");
        stringBuilder.append(this.f9054w);
        stringBuilder.append("\n, bitstreamRestriction=");
        stringBuilder.append(this.f9055x);
        stringBuilder.append("\n, aspect_ratio=");
        stringBuilder.append(this.f9056y);
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}
