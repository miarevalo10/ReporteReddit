package com.google.android.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException {
    public final Timeline f4040a;
    public final int f4041b;
    public final long f4042c;

    public IllegalSeekPositionException(Timeline timeline, int i, long j) {
        this.f4040a = timeline;
        this.f4041b = i;
        this.f4042c = j;
    }
}
