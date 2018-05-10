package com.bumptech.glide;

import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    protected TransitionFactory<? super TranscodeType> f3254a = NoTransition.m11727a();

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m2793a();
    }

    public final CHILD m2793a() {
        try {
            return (TransitionOptions) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
