package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType f41645a = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset f41646b = Charset.forName("UTF-8");
    private final Gson f41647c;
    private final TypeAdapter<T> f41648d;

    GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f41647c = gson;
        this.f41648d = typeAdapter;
    }

    public final /* synthetic */ Object mo7875a(Object obj) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter a = this.f41647c.a(new OutputStreamWriter(buffer.b(), f41646b));
        this.f41648d.a(a, obj);
        a.close();
        return RequestBody.create(f41645a, buffer.o());
    }
}
