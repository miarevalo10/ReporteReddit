package com.nytimes.android.external.fs3;

import com.nytimes.android.external.fs3.filesystem.FileSystem;
import com.nytimes.android.external.store3.base.DiskRead;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import java.io.FileNotFoundException;
import okio.BufferedSource;

public class FSReader<T> implements DiskRead<BufferedSource, T> {
    final FileSystem f15669a;
    final PathResolver<T> f15670b;

    public FSReader(FileSystem fileSystem, PathResolver<T> pathResolver) {
        this.f15669a = fileSystem;
        this.f15670b = pathResolver;
    }

    public final Maybe<BufferedSource> mo2708a(T t) {
        return Maybe.create(FSReader$$Lambda$1.m15680a(this, t));
    }

    static /* synthetic */ void m15682a(FSReader fSReader, Object obj, MaybeEmitter maybeEmitter) throws Exception {
        obj = fSReader.f15670b.mo2926a(obj);
        if (fSReader.f15669a.mo2712b(obj)) {
            BufferedSource bufferedSource = null;
            try {
                fSReader = fSReader.f15669a.mo2710a(obj);
                try {
                    maybeEmitter.a(fSReader);
                    maybeEmitter.az_();
                    if (fSReader != null) {
                        try {
                            fSReader.close();
                            return;
                        } catch (FSReader fSReader2) {
                            fSReader2.printStackTrace(System.err);
                            return;
                        }
                    }
                } catch (FileNotFoundException e) {
                    obj = e;
                    bufferedSource = fSReader2;
                    try {
                        maybeEmitter.a(obj);
                        if (bufferedSource != null) {
                            bufferedSource.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        obj = th;
                        if (bufferedSource != null) {
                            try {
                                bufferedSource.close();
                            } catch (FSReader fSReader22) {
                                fSReader22.printStackTrace(System.err);
                            }
                        }
                        throw obj;
                    }
                } catch (Throwable th2) {
                    obj = th2;
                    bufferedSource = fSReader22;
                    if (bufferedSource != null) {
                        bufferedSource.close();
                    }
                    throw obj;
                }
            } catch (FileNotFoundException e2) {
                obj = e2;
                maybeEmitter.a(obj);
                if (bufferedSource != null) {
                    bufferedSource.close();
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("resolvedKey does not resolve to a file");
        stringBuilder.append(obj);
        maybeEmitter.a(new FileNotFoundException(stringBuilder.toString()));
    }
}
