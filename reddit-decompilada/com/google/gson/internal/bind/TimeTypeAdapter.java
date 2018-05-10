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
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory f15082a = new C12401();
    private final DateFormat f15083b = new SimpleDateFormat("hh:mm:ss a");

    static class C12401 implements TypeAdapterFactory {
        C12401() {
        }

        public final <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f8834a == Time.class ? new TimeTypeAdapter() : null;
        }
    }

    public final /* synthetic */ Object mo2458a(JsonReader jsonReader) throws IOException {
        return m15042b(jsonReader);
    }

    private synchronized Time m15042b(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo2475f() == JsonToken.NULL) {
            jsonReader.mo2480k();
            return null;
        }
        try {
            return new Time(this.f15083b.parse(jsonReader.mo2478i()).getTime());
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        }
    }

    private synchronized void m15041a(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.mo2494b(time == null ? null : this.f15083b.format(time));
    }
}
