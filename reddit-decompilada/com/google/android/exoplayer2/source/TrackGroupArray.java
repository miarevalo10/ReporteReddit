package com.google.android.exoplayer2.source;

import java.util.Arrays;

public final class TrackGroupArray {
    public static final TrackGroupArray f4785a = new TrackGroupArray(new TrackGroup[0]);
    public final int f4786b;
    public final TrackGroup[] f4787c;
    private int f4788d;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f4787c = trackGroupArr;
        this.f4786b = trackGroupArr.length;
    }

    public final int m3975a(TrackGroup trackGroup) {
        for (int i = 0; i < this.f4786b; i++) {
            if (this.f4787c[i] == trackGroup) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.f4788d == 0) {
            this.f4788d = Arrays.hashCode(this.f4787c);
        }
        return this.f4788d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
                return this.f4786b == trackGroupArray.f4786b && Arrays.equals(this.f4787c, trackGroupArray.f4787c) != null;
            }
        }
        return false;
    }
}
