package com.nytimes.android.external.fs3;

import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

final /* synthetic */ class FSReader$$Lambda$1 implements MaybeOnSubscribe {
    private final FSReader f15667a;
    private final Object f15668b;

    private FSReader$$Lambda$1(FSReader fSReader, Object obj) {
        this.f15667a = fSReader;
        this.f15668b = obj;
    }

    public static MaybeOnSubscribe m15680a(FSReader fSReader, Object obj) {
        return new FSReader$$Lambda$1(fSReader, obj);
    }

    public final void m15681a(MaybeEmitter maybeEmitter) {
        FSReader.m15682a(this.f15667a, this.f15668b, maybeEmitter);
    }
}
