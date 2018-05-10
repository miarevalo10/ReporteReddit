package com.reddit.config.http;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final /* synthetic */ class RetrofitModule$StringConverterFactory$$Lambda$0 implements Converter {
    static final Converter f15713a = new RetrofitModule$StringConverterFactory$$Lambda$0();

    private RetrofitModule$StringConverterFactory$$Lambda$0() {
    }

    public final Object m15801a(Object obj) {
        return ((ResponseBody) obj).string();
    }
}
