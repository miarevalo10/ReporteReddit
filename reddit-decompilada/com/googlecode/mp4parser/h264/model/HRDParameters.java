package com.googlecode.mp4parser.h264.model;

import java.util.Arrays;

public class HRDParameters {
    public int f9007a;
    public int f9008b;
    public int f9009c;
    public int[] f9010d;
    public int[] f9011e;
    public boolean[] f9012f;
    public int f9013g;
    public int f9014h;
    public int f9015i;
    public int f9016j;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HRDParameters{cpb_cnt_minus1=");
        stringBuilder.append(this.f9007a);
        stringBuilder.append(", bit_rate_scale=");
        stringBuilder.append(this.f9008b);
        stringBuilder.append(", cpb_size_scale=");
        stringBuilder.append(this.f9009c);
        stringBuilder.append(", bit_rate_value_minus1=");
        stringBuilder.append(Arrays.toString(this.f9010d));
        stringBuilder.append(", cpb_size_value_minus1=");
        stringBuilder.append(Arrays.toString(this.f9011e));
        stringBuilder.append(", cbr_flag=");
        stringBuilder.append(Arrays.toString(this.f9012f));
        stringBuilder.append(", initial_cpb_removal_delay_length_minus1=");
        stringBuilder.append(this.f9013g);
        stringBuilder.append(", cpb_removal_delay_length_minus1=");
        stringBuilder.append(this.f9014h);
        stringBuilder.append(", dpb_output_delay_length_minus1=");
        stringBuilder.append(this.f9015i);
        stringBuilder.append(", time_offset_length=");
        stringBuilder.append(this.f9016j);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
