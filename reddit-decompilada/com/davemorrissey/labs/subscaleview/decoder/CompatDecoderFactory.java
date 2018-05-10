package com.davemorrissey.labs.subscaleview.decoder;

public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private Class<? extends T> f12692a;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this.f12692a = cls;
    }

    public final T mo1107a() throws IllegalAccessException, InstantiationException {
        return this.f12692a.newInstance();
    }
}
