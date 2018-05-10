package com.nytimes.android.external.fs3;

import com.nytimes.android.external.fs3.filesystem.FileSystem;
import com.nytimes.android.external.store3.base.DiskWrite;
import io.reactivex.Single;
import okio.BufferedSource;

public class FSWriter<T> implements DiskWrite<BufferedSource, T> {
    final FileSystem f15671a;
    final PathResolver<T> f15672b;

    public FSWriter(FileSystem fileSystem, PathResolver<T> pathResolver) {
        this.f15671a = fileSystem;
        this.f15672b = pathResolver;
    }

    public final Single<Boolean> m15686a(T t, BufferedSource bufferedSource) {
        return Single.fromCallable(FSWriter$$Lambda$1.m8684a(this, t, bufferedSource));
    }
}
