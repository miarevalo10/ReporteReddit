package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import java.io.IOException;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.ByteString;
import retrofit2.Converter;

final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final ByteString f41657a = ByteString.c("EFBBBF");
    private final JsonAdapter<T> f41658b;

    MoshiResponseBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.f41658b = jsonAdapter;
    }

    private T m43802a(ResponseBody responseBody) throws IOException {
        BufferedSource source = responseBody.source();
        try {
            if (source.c(f41657a)) {
                source.i((long) f41657a.h());
            }
            T fromJson = this.f41658b.fromJson(source);
            return fromJson;
        } finally {
            responseBody.close();
        }
    }
}
