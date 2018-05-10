package com.reddit.config.http;

import okhttp3.RequestBody;
import retrofit2.Converter;

final /* synthetic */ class RetrofitModule$StringConverterFactory$$Lambda$1 implements Converter {
    static final Converter f15714a = new RetrofitModule$StringConverterFactory$$Lambda$1();

    private RetrofitModule$StringConverterFactory$$Lambda$1() {
    }

    public final Object m15802a(Object obj) {
        return RequestBody.create(StringConverterFactory.f15715a, (String) obj);
    }
}
