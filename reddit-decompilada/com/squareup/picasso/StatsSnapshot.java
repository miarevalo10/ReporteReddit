package com.squareup.picasso;

public class StatsSnapshot {
    public final int f23902a;
    public final int f23903b;
    public final long f23904c;
    public final long f23905d;
    public final long f23906e;
    public final long f23907f;
    public final long f23908g;
    public final long f23909h;
    public final long f23910i;
    public final long f23911j;
    public final int f23912k;
    public final int f23913l;
    public final int f23914m;
    public final long f23915n;

    public StatsSnapshot(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f23902a = i;
        this.f23903b = i2;
        this.f23904c = j;
        this.f23905d = j2;
        this.f23906e = j3;
        this.f23907f = j4;
        this.f23908g = j5;
        this.f23909h = j6;
        this.f23910i = j7;
        this.f23911j = j8;
        this.f23912k = i3;
        this.f23913l = i4;
        this.f23914m = i5;
        this.f23915n = j9;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatsSnapshot{maxSize=");
        stringBuilder.append(this.f23902a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.f23903b);
        stringBuilder.append(", cacheHits=");
        stringBuilder.append(this.f23904c);
        stringBuilder.append(", cacheMisses=");
        stringBuilder.append(this.f23905d);
        stringBuilder.append(", downloadCount=");
        stringBuilder.append(this.f23912k);
        stringBuilder.append(", totalDownloadSize=");
        stringBuilder.append(this.f23906e);
        stringBuilder.append(", averageDownloadSize=");
        stringBuilder.append(this.f23909h);
        stringBuilder.append(", totalOriginalBitmapSize=");
        stringBuilder.append(this.f23907f);
        stringBuilder.append(", totalTransformedBitmapSize=");
        stringBuilder.append(this.f23908g);
        stringBuilder.append(", averageOriginalBitmapSize=");
        stringBuilder.append(this.f23910i);
        stringBuilder.append(", averageTransformedBitmapSize=");
        stringBuilder.append(this.f23911j);
        stringBuilder.append(", originalBitmapCount=");
        stringBuilder.append(this.f23913l);
        stringBuilder.append(", transformedBitmapCount=");
        stringBuilder.append(this.f23914m);
        stringBuilder.append(", timeStamp=");
        stringBuilder.append(this.f23915n);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
