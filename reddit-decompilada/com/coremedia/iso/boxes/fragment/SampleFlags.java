package com.coremedia.iso.boxes.fragment;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;

public class SampleFlags {
    private byte isLeading;
    private byte reserved;
    private int sampleDegradationPriority;
    private byte sampleDependsOn;
    private byte sampleHasRedundancy;
    private byte sampleIsDependedOn;
    private boolean sampleIsDifferenceSample;
    private byte samplePaddingValue;

    public SampleFlags(ByteBuffer byteBuffer) {
        long a = IsoTypeReader.m3280a(byteBuffer);
        this.reserved = (byte) ((int) ((-268435456 & a) >> 28));
        this.isLeading = (byte) ((int) ((201326592 & a) >> 26));
        this.sampleDependsOn = (byte) ((int) ((50331648 & a) >> 24));
        this.sampleIsDependedOn = (byte) ((int) ((12582912 & a) >> 22));
        this.sampleHasRedundancy = (byte) ((int) ((3145728 & a) >> 20));
        this.samplePaddingValue = (byte) ((int) ((917504 & a) >> 17));
        this.sampleIsDifferenceSample = ((65536 & a) >> 16) > 0 ? true : null;
        this.sampleDegradationPriority = (int) (a & 65535);
    }

    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3300b(byteBuffer, (((((((((long) (this.reserved << 28)) | 0) | ((long) (this.isLeading << 26))) | ((long) (this.sampleDependsOn << 24))) | ((long) (this.sampleIsDependedOn << 22))) | ((long) (this.sampleHasRedundancy << 20))) | ((long) (this.samplePaddingValue << 17))) | ((long) (this.sampleIsDifferenceSample << 16))) | ((long) this.sampleDegradationPriority));
    }

    public int getReserved() {
        return this.reserved;
    }

    public void setReserved(int i) {
        this.reserved = (byte) i;
    }

    public byte getIsLeading() {
        return this.isLeading;
    }

    public void setIsLeading(byte b) {
        this.isLeading = b;
    }

    public int getSampleDependsOn() {
        return this.sampleDependsOn;
    }

    public void setSampleDependsOn(int i) {
        this.sampleDependsOn = (byte) i;
    }

    public int getSampleIsDependedOn() {
        return this.sampleIsDependedOn;
    }

    public void setSampleIsDependedOn(int i) {
        this.sampleIsDependedOn = (byte) i;
    }

    public int getSampleHasRedundancy() {
        return this.sampleHasRedundancy;
    }

    public void setSampleHasRedundancy(int i) {
        this.sampleHasRedundancy = (byte) i;
    }

    public int getSamplePaddingValue() {
        return this.samplePaddingValue;
    }

    public void setSamplePaddingValue(int i) {
        this.samplePaddingValue = (byte) i;
    }

    public boolean isSampleIsDifferenceSample() {
        return this.sampleIsDifferenceSample;
    }

    public void setSampleIsDifferenceSample(boolean z) {
        this.sampleIsDifferenceSample = z;
    }

    public int getSampleDegradationPriority() {
        return this.sampleDegradationPriority;
    }

    public void setSampleDegradationPriority(int i) {
        this.sampleDegradationPriority = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SampleFlags{reserved=");
        stringBuilder.append(this.reserved);
        stringBuilder.append(", isLeading=");
        stringBuilder.append(this.isLeading);
        stringBuilder.append(", depOn=");
        stringBuilder.append(this.sampleDependsOn);
        stringBuilder.append(", isDepOn=");
        stringBuilder.append(this.sampleIsDependedOn);
        stringBuilder.append(", hasRedundancy=");
        stringBuilder.append(this.sampleHasRedundancy);
        stringBuilder.append(", padValue=");
        stringBuilder.append(this.samplePaddingValue);
        stringBuilder.append(", isDiffSample=");
        stringBuilder.append(this.sampleIsDifferenceSample);
        stringBuilder.append(", degradPrio=");
        stringBuilder.append(this.sampleDegradationPriority);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                SampleFlags sampleFlags = (SampleFlags) obj;
                return this.isLeading == sampleFlags.isLeading && this.reserved == sampleFlags.reserved && this.sampleDegradationPriority == sampleFlags.sampleDegradationPriority && this.sampleDependsOn == sampleFlags.sampleDependsOn && this.sampleHasRedundancy == sampleFlags.sampleHasRedundancy && this.sampleIsDependedOn == sampleFlags.sampleIsDependedOn && this.sampleIsDifferenceSample == sampleFlags.sampleIsDifferenceSample && this.samplePaddingValue == sampleFlags.samplePaddingValue;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((((((((((((this.reserved * 31) + this.isLeading) * 31) + this.sampleDependsOn) * 31) + this.sampleIsDependedOn) * 31) + this.sampleHasRedundancy) * 31) + this.samplePaddingValue) * 31) + this.sampleIsDifferenceSample)) + this.sampleDegradationPriority;
    }
}
