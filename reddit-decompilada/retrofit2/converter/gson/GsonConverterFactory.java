package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;

public final class GsonConverterFactory extends Factory {
    private final Gson f41644a;

    public static GsonConverterFactory m43790a() {
        return m43791a(new Gson());
    }

    public static GsonConverterFactory m43791a(Gson gson) {
        if (gson != null) {
            return new GsonConverterFactory(gson);
        }
        throw new NullPointerException("gson == null");
    }

    private GsonConverterFactory(Gson gson) {
        this.f41644a = gson;
    }

    public final Converter<ResponseBody, ?> mo7876a(Type type, Annotation[] annotationArr) {
        return new GsonResponseBodyConverter(this.f41644a, this.f41644a.a(TypeToken.a(type)));
    }

    public final Converter<?, RequestBody> mo7877b(Type type, Annotation[] annotationArr) {
        return new GsonRequestBodyConverter(this.f41644a, this.f41644a.a(TypeToken.a(type)));
    }
}
