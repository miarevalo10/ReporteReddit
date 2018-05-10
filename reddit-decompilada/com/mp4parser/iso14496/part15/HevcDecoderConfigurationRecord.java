package com.mp4parser.iso14496.part15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class HevcDecoderConfigurationRecord {
    boolean f10068A;
    int f10069a;
    int f10070b;
    boolean f10071c;
    int f10072d;
    long f10073e;
    long f10074f;
    int f10075g;
    int f10076h = 15;
    int f10077i;
    int f10078j = 63;
    int f10079k;
    int f10080l = 63;
    int f10081m;
    int f10082n = 31;
    int f10083o;
    int f10084p = 31;
    int f10085q;
    int f10086r;
    int f10087s;
    int f10088t;
    boolean f10089u;
    int f10090v;
    List<Array> f10091w = new ArrayList();
    boolean f10092x;
    boolean f10093y;
    boolean f10094z;

    public static class Array {
        public boolean f10064a;
        public boolean f10065b;
        public int f10066c;
        public List<byte[]> f10067d;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    Array array = (Array) obj;
                    if (this.f10064a != array.f10064a || this.f10066c != array.f10066c || this.f10065b != array.f10065b) {
                        return false;
                    }
                    ListIterator listIterator = this.f10067d.listIterator();
                    obj = array.f10067d.listIterator();
                    while (listIterator.hasNext()) {
                        if (!obj.hasNext()) {
                            break;
                        }
                        byte[] bArr = (byte[]) listIterator.next();
                        byte[] bArr2 = (byte[]) obj.next();
                        if (bArr == null) {
                            if (bArr2 != null) {
                            }
                        } else if (Arrays.equals(bArr, bArr2)) {
                        }
                        return false;
                    }
                    if (!listIterator.hasNext()) {
                        if (obj.hasNext() == null) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((this.f10064a * 31) + this.f10065b) * 31) + this.f10066c)) + (this.f10067d != null ? this.f10067d.hashCode() : 0);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Array{nal_unit_type=");
            stringBuilder.append(this.f10066c);
            stringBuilder.append(", reserved=");
            stringBuilder.append(this.f10065b);
            stringBuilder.append(", array_completeness=");
            stringBuilder.append(this.f10064a);
            stringBuilder.append(", num_nals=");
            stringBuilder.append(this.f10067d.size());
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                HevcDecoderConfigurationRecord hevcDecoderConfigurationRecord = (HevcDecoderConfigurationRecord) obj;
                if (this.f10086r != hevcDecoderConfigurationRecord.f10086r || this.f10085q != hevcDecoderConfigurationRecord.f10085q || this.f10083o != hevcDecoderConfigurationRecord.f10083o || this.f10081m != hevcDecoderConfigurationRecord.f10081m || this.f10069a != hevcDecoderConfigurationRecord.f10069a || this.f10087s != hevcDecoderConfigurationRecord.f10087s || this.f10074f != hevcDecoderConfigurationRecord.f10074f || this.f10075g != hevcDecoderConfigurationRecord.f10075g || this.f10073e != hevcDecoderConfigurationRecord.f10073e || this.f10072d != hevcDecoderConfigurationRecord.f10072d || this.f10070b != hevcDecoderConfigurationRecord.f10070b || this.f10071c != hevcDecoderConfigurationRecord.f10071c || this.f10090v != hevcDecoderConfigurationRecord.f10090v || this.f10077i != hevcDecoderConfigurationRecord.f10077i || this.f10088t != hevcDecoderConfigurationRecord.f10088t || this.f10079k != hevcDecoderConfigurationRecord.f10079k || this.f10076h != hevcDecoderConfigurationRecord.f10076h || this.f10078j != hevcDecoderConfigurationRecord.f10078j || this.f10080l != hevcDecoderConfigurationRecord.f10080l || this.f10082n != hevcDecoderConfigurationRecord.f10082n || this.f10084p != hevcDecoderConfigurationRecord.f10084p || this.f10089u != hevcDecoderConfigurationRecord.f10089u) {
                    return false;
                }
                if (this.f10091w == null) {
                    return hevcDecoderConfigurationRecord.f10091w == null;
                } else {
                    if (this.f10091w.equals(hevcDecoderConfigurationRecord.f10091w) == null) {
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((((((((((((((((((((((((((((((((((((((((((this.f10069a * 31) + this.f10070b) * 31) + this.f10071c) * 31) + this.f10072d) * 31) + ((int) (this.f10073e ^ (this.f10073e >>> 32)))) * 31) + ((int) (this.f10074f ^ (this.f10074f >>> 32)))) * 31) + this.f10075g) * 31) + this.f10076h) * 31) + this.f10077i) * 31) + this.f10078j) * 31) + this.f10079k) * 31) + this.f10080l) * 31) + this.f10081m) * 31) + this.f10082n) * 31) + this.f10083o) * 31) + this.f10084p) * 31) + this.f10085q) * 31) + this.f10086r) * 31) + this.f10087s) * 31) + this.f10088t) * 31) + this.f10089u) * 31) + this.f10090v)) + (this.f10091w != null ? this.f10091w.hashCode() : 0);
    }

    public String toString() {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder("HEVCDecoderConfigurationRecord{configurationVersion=");
        stringBuilder2.append(this.f10069a);
        stringBuilder2.append(", general_profile_space=");
        stringBuilder2.append(this.f10070b);
        stringBuilder2.append(", general_tier_flag=");
        stringBuilder2.append(this.f10071c);
        stringBuilder2.append(", general_profile_idc=");
        stringBuilder2.append(this.f10072d);
        stringBuilder2.append(", general_profile_compatibility_flags=");
        stringBuilder2.append(this.f10073e);
        stringBuilder2.append(", general_constraint_indicator_flags=");
        stringBuilder2.append(this.f10074f);
        stringBuilder2.append(", general_level_idc=");
        stringBuilder2.append(this.f10075g);
        if (this.f10076h != 15) {
            StringBuilder stringBuilder3 = new StringBuilder(", reserved1=");
            stringBuilder3.append(this.f10076h);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        stringBuilder2.append(", min_spatial_segmentation_idc=");
        stringBuilder2.append(this.f10077i);
        if (this.f10078j != 63) {
            stringBuilder3 = new StringBuilder(", reserved2=");
            stringBuilder3.append(this.f10078j);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        stringBuilder2.append(", parallelismType=");
        stringBuilder2.append(this.f10079k);
        if (this.f10080l != 63) {
            stringBuilder3 = new StringBuilder(", reserved3=");
            stringBuilder3.append(this.f10080l);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        stringBuilder2.append(", chromaFormat=");
        stringBuilder2.append(this.f10081m);
        if (this.f10082n != 31) {
            stringBuilder3 = new StringBuilder(", reserved4=");
            stringBuilder3.append(this.f10082n);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        stringBuilder2.append(", bitDepthLumaMinus8=");
        stringBuilder2.append(this.f10083o);
        if (this.f10084p != 31) {
            stringBuilder3 = new StringBuilder(", reserved5=");
            stringBuilder3.append(this.f10084p);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder2.append(stringBuilder);
        stringBuilder2.append(", bitDepthChromaMinus8=");
        stringBuilder2.append(this.f10085q);
        stringBuilder2.append(", avgFrameRate=");
        stringBuilder2.append(this.f10086r);
        stringBuilder2.append(", constantFrameRate=");
        stringBuilder2.append(this.f10087s);
        stringBuilder2.append(", numTemporalLayers=");
        stringBuilder2.append(this.f10088t);
        stringBuilder2.append(", temporalIdNested=");
        stringBuilder2.append(this.f10089u);
        stringBuilder2.append(", lengthSizeMinusOne=");
        stringBuilder2.append(this.f10090v);
        stringBuilder2.append(", arrays=");
        stringBuilder2.append(this.f10091w);
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }
}
