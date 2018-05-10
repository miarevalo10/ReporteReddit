package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.ClassConfig;
import io.gsonfire.PostProcessor;
import io.gsonfire.annotations.PostDeserialize;
import io.gsonfire.annotations.PreSerialize;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class FireTypeAdapter<T> extends TypeAdapter<T> {
    private final Class<T> f31055a;
    private final ClassConfig<? super T> f31056b;
    private final Gson f31057c;
    private final TypeAdapter<T> f31058d;
    private final HooksInvoker f31059e = new HooksInvoker();

    public FireTypeAdapter(Class<T> cls, ClassConfig<? super T> classConfig, TypeAdapter<T> typeAdapter, Gson gson) {
        this.f31056b = classConfig;
        this.f31057c = gson;
        this.f31058d = typeAdapter;
        this.f31055a = cls;
    }

    public final void m32032a(JsonWriter jsonWriter, T t) throws IOException {
        if (this.f31056b.f24937d) {
            this.f31059e.m26460a(t, PreSerialize.class, null, null);
        }
        JsonElement a = this.f31058d.a(t);
        for (PostProcessor a2 : this.f31056b.m26447a()) {
            a2.mo4762a(a, t, this.f31057c);
        }
        this.f31057c.a(a, jsonWriter);
    }

    public final T m32031a(JsonReader jsonReader) throws IOException {
        JsonParser jsonParser = new JsonParser();
        jsonReader = JsonParser.a(jsonReader);
        ClassConfig classConfig = this.f31056b;
        if (classConfig.f24936c == null) {
            classConfig.f24936c = new ArrayList();
        }
        Iterator it = classConfig.f24936c.iterator();
        while (it.hasNext()) {
            it.next();
        }
        T a = this.f31058d.a(jsonReader);
        if (this.f31056b.f24937d) {
            this.f31059e.m26460a(a, PostDeserialize.class, jsonReader, this.f31057c);
        }
        m32030b(a);
        return a;
    }

    private void m32030b(T t) {
        for (PostProcessor a : this.f31056b.m26447a()) {
            a.mo4763a(t);
        }
    }
}
