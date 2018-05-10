package com.mp4parser.iso14496.part15;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;

public class TemporalLayerSampleGroup extends GroupEntry {
    int f15612a;
    int f15613b;
    boolean f15614c;
    int f15615d;
    long f15616e;
    long f15617f;
    int f15618g;
    int f15619h;
    int f15620i;
    int f15621j;
    int f15622k;

    public final String mo2526a() {
        return "tscl";
    }

    public final int mo2655c() {
        return 20;
    }

    public final void mo2527a(ByteBuffer byteBuffer) {
        this.f15612a = IsoTypeReader.m3284d(byteBuffer);
        int d = IsoTypeReader.m3284d(byteBuffer);
        this.f15613b = (d & JpegConst.SOF0) >> 6;
        this.f15614c = (d & 32) > 0;
        this.f15615d = d & 31;
        this.f15616e = IsoTypeReader.m3280a(byteBuffer);
        this.f15617f = IsoTypeReader.m3292l(byteBuffer);
        this.f15618g = IsoTypeReader.m3284d(byteBuffer);
        this.f15619h = IsoTypeReader.m3283c(byteBuffer);
        this.f15620i = IsoTypeReader.m3283c(byteBuffer);
        this.f15621j = IsoTypeReader.m3284d(byteBuffer);
        this.f15622k = IsoTypeReader.m3283c(byteBuffer);
    }

    public final ByteBuffer mo2528b() {
        ByteBuffer allocate = ByteBuffer.allocate(20);
        IsoTypeWriter.m3303c(allocate, this.f15612a);
        IsoTypeWriter.m3303c(allocate, ((this.f15613b << 6) + (this.f15614c ? 32 : 0)) + this.f15615d);
        IsoTypeWriter.m3300b(allocate, this.f15616e);
        IsoTypeWriter.m3304c(allocate, this.f15617f);
        IsoTypeWriter.m3303c(allocate, this.f15618g);
        IsoTypeWriter.m3299b(allocate, this.f15619h);
        IsoTypeWriter.m3299b(allocate, this.f15620i);
        IsoTypeWriter.m3303c(allocate, this.f15621j);
        IsoTypeWriter.m3299b(allocate, this.f15622k);
        return (ByteBuffer) allocate.rewind();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                TemporalLayerSampleGroup temporalLayerSampleGroup = (TemporalLayerSampleGroup) obj;
                return this.f15612a == temporalLayerSampleGroup.f15612a && this.f15620i == temporalLayerSampleGroup.f15620i && this.f15622k == temporalLayerSampleGroup.f15622k && this.f15621j == temporalLayerSampleGroup.f15621j && this.f15619h == temporalLayerSampleGroup.f15619h && this.f15617f == temporalLayerSampleGroup.f15617f && this.f15618g == temporalLayerSampleGroup.f15618g && this.f15616e == temporalLayerSampleGroup.f15616e && this.f15615d == temporalLayerSampleGroup.f15615d && this.f15613b == temporalLayerSampleGroup.f15613b && this.f15614c == temporalLayerSampleGroup.f15614c;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((((((((((((((((((this.f15612a * 31) + this.f15613b) * 31) + this.f15614c) * 31) + this.f15615d) * 31) + ((int) (this.f15616e ^ (this.f15616e >>> 32)))) * 31) + ((int) (this.f15617f ^ (this.f15617f >>> 32)))) * 31) + this.f15618g) * 31) + this.f15619h) * 31) + this.f15620i) * 31) + this.f15621j)) + this.f15622k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TemporalLayerSampleGroup{temporalLayerId=");
        stringBuilder.append(this.f15612a);
        stringBuilder.append(", tlprofile_space=");
        stringBuilder.append(this.f15613b);
        stringBuilder.append(", tltier_flag=");
        stringBuilder.append(this.f15614c);
        stringBuilder.append(", tlprofile_idc=");
        stringBuilder.append(this.f15615d);
        stringBuilder.append(", tlprofile_compatibility_flags=");
        stringBuilder.append(this.f15616e);
        stringBuilder.append(", tlconstraint_indicator_flags=");
        stringBuilder.append(this.f15617f);
        stringBuilder.append(", tllevel_idc=");
        stringBuilder.append(this.f15618g);
        stringBuilder.append(", tlMaxBitRate=");
        stringBuilder.append(this.f15619h);
        stringBuilder.append(", tlAvgBitRate=");
        stringBuilder.append(this.f15620i);
        stringBuilder.append(", tlConstantFrameRate=");
        stringBuilder.append(this.f15621j);
        stringBuilder.append(", tlAvgFrameRate=");
        stringBuilder.append(this.f15622k);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
