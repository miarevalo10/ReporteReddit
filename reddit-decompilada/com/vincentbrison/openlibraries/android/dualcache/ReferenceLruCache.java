package com.vincentbrison.openlibraries.android.dualcache;

public class ReferenceLruCache<T> extends RamLruCache<String, T> {
    private SizeOf<T> mHandlerSizeOf;

    protected int sizeOf(String str, T t) {
        return 1;
    }

    public /* bridge */ /* synthetic */ void resize(int i) {
        super.resize(i);
    }

    public /* bridge */ /* synthetic */ void trimToSize(int i) {
        super.trimToSize(i);
    }

    public ReferenceLruCache(int i, SizeOf<T> sizeOf) {
        super(i);
        this.mHandlerSizeOf = sizeOf;
    }
}
