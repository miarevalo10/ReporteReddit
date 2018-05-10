package com.bumptech.glide.load.data;

import java.io.IOException;

public interface DataRewinder<T> {

    public interface Factory<T> {
        DataRewinder<T> mo896a(T t);

        Class<T> mo897a();
    }

    T mo898a() throws IOException;

    void mo899b();
}
