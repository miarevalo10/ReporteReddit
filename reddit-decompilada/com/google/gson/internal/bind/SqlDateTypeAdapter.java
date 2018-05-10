package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory f15080a = new C12391();
    private final DateFormat f15081b = new SimpleDateFormat("MMM d, yyyy");

    static class C12391 implements TypeAdapterFactory {
        C12391() {
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f8834a == Date.class ? new SqlDateTypeAdapter() : null;
        }
    }

    public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
        return m15037b(jsonReader);
    }

    private synchronized Date m15037b(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo2475f() == JsonToken.NULL) {
            jsonReader.mo2480k();
            return null;
        }
        try {
            return new Date(this.f15081b.parse(jsonReader.mo2478i()).getTime());
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        }
    }

    private synchronized void m15036a(JsonWriter jsonWriter, Date date) throws IOException {
        jsonWriter.mo2494b(date == null ? null : this.f15081b.format(date));
    }
}
