package com.bumptech.glide.load.engine.bitmap_recycle;

public interface ArrayPool {
    <T> T mo946a(int i, Class<T> cls);

    <T> T mo947a(Class<T> cls);

    void mo948a();

    void mo949a(int i);

    <T> void mo950a(T t);
}
