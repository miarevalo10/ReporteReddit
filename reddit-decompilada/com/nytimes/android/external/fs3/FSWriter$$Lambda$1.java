package com.nytimes.android.external.fs3;

import java.util.concurrent.Callable;
import okio.BufferedSource;

final /* synthetic */ class FSWriter$$Lambda$1 implements Callable {
    private final FSWriter f10224a;
    private final Object f10225b;
    private final BufferedSource f10226c;

    private FSWriter$$Lambda$1(FSWriter fSWriter, Object obj, BufferedSource bufferedSource) {
        this.f10224a = fSWriter;
        this.f10225b = obj;
        this.f10226c = bufferedSource;
    }

    public static Callable m8684a(FSWriter fSWriter, Object obj, BufferedSource bufferedSource) {
        return new FSWriter$$Lambda$1(fSWriter, obj, bufferedSource);
    }

    public final Object call() {
        return this.f10224a.f15671a.mo2711a(this.f10224a.f15672b.mo2926a(this.f10225b), this.f10226c);
    }
}
