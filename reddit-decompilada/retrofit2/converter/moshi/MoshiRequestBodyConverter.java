package retrofit2.converter.moshi;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

final class MoshiRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType f41655a = MediaType.parse("application/json; charset=UTF-8");
    private final JsonAdapter<T> f41656b;

    MoshiRequestBodyConverter(JsonAdapter<T> jsonAdapter) {
        this.f41656b = jsonAdapter;
    }

    public final /* synthetic */ Object mo7875a(Object obj) throws IOException {
        Object buffer = new Buffer();
        this.f41656b.toJson(JsonWriter.a(buffer), obj);
        return RequestBody.create(f41655a, buffer.o());
    }
}
