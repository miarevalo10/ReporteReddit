package com.nytimes.android.external.fs3;

import com.nytimes.android.external.fs3.filesystem.FileSystem;
import com.nytimes.android.external.store3.base.Persister;
import io.reactivex.Maybe;
import okio.BufferedSource;

public final class FileSystemPersister<T> implements Persister<BufferedSource, T> {
    private final FSReader<T> f18661a;
    private final FSWriter<T> f18662b;

    private FileSystemPersister(FileSystem fileSystem, PathResolver<T> pathResolver) {
        this.f18661a = new FSReader(fileSystem, pathResolver);
        this.f18662b = new FSWriter(fileSystem, pathResolver);
    }

    public static <T> Persister<BufferedSource, T> m19614a(FileSystem fileSystem, PathResolver<T> pathResolver) {
        if (fileSystem != null) {
            return new FileSystemPersister(fileSystem, pathResolver);
        }
        throw new IllegalArgumentException("root file cannot be null.");
    }

    public final Maybe<BufferedSource> mo2708a(T t) {
        return this.f18661a.mo2708a(t);
    }
}
