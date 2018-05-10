package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson f41649a;
    private final TypeAdapter<T> f41650b;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f41649a = gson;
        this.f41650b = typeAdapter;
    }

    private T m43795a(ResponseBody responseBody) throws IOException {
        try {
            T a = this.f41650b.a(this.f41649a.a(responseBody.charStream()));
            return a;
        } finally {
            responseBody.close();
        }
    }
}
