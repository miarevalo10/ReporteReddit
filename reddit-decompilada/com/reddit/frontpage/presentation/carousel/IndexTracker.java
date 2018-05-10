package com.reddit.frontpage.presentation.carousel;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u000fR$\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/carousel/IndexTracker;", "", "distance", "", "initialIndex", "(II)V", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "step", "incrementIndex", "notifyOfLastUsedIndex", "", "lastIndex", "resetIndex", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: IndexTracker.kt */
public final class IndexTracker {
    public final int f20327a;
    public int f20328b;
    public final int f20329c;

    public IndexTracker(int i, int i2) {
        this.f20329c = i2;
        this.f20327a = i + 1;
        this.f20328b = this.f20329c;
    }

    private /* synthetic */ IndexTracker() {
        this(0, 0);
    }
}
