package com.reddit.config.http;

import com.instabug.library.model.NetworkLog;
import com.reddit.datalibrary.frontpage.service.api.AwsService;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.inject.Named;
import javax.inject.Singleton;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit.Builder;

public class RetrofitModule {

    static final class StringConverterFactory extends Factory {
        private static final MediaType f15715a = MediaType.parse(NetworkLog.PLAIN_TEXT);

        StringConverterFactory() {
        }

        public static StringConverterFactory m15803a() {
            return new StringConverterFactory();
        }

        public final Converter<ResponseBody, ?> m15805a(Type type, Annotation[] annotationArr) {
            return String.class.equals(type) != null ? RetrofitModule$StringConverterFactory$$Lambda$0.f15713a : null;
        }

        public final Converter<?, RequestBody> m15806b(Type type, Annotation[] annotationArr) {
            return String.class.equals(type) != null ? RetrofitModule$StringConverterFactory$$Lambda$1.f15714a : null;
        }
    }

    @Singleton
    public static AwsService m8729a(@Named("no_body_logging") OkHttpClient okHttpClient) {
        return (AwsService) new Builder().a("https://oauth.reddit.com").a(StringConverterFactory.m15803a()).a(okHttpClient).a().a(AwsService.class);
    }
}
