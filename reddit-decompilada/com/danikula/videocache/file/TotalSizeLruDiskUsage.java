package com.danikula.videocache.file;

public class TotalSizeLruDiskUsage extends LruDiskUsage {
    private final long f16755a = 536870912;

    protected final boolean mo3285a(long j) {
        return j <= this.f16755a ? 1 : 0;
    }
}
