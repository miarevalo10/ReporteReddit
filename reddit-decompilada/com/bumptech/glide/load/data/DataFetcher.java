package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void mo902a(Exception exception);

        void mo903a(T t);
    }

    void mo884a();

    void mo885a(Priority priority, DataCallback<? super T> dataCallback);

    void mo886b();

    Class<T> mo887c();

    DataSource mo888d();
}
