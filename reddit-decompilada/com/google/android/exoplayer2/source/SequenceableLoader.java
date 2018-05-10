package com.google.android.exoplayer2.source;

public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void mo3348a(T t);
    }

    boolean mo1401c(long j);

    long mo1402d();

    long mo1403e();
}
