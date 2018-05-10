package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory f30326a = new C24481();
    private final DateFormat f30327b = new SimpleDateFormat("hh:mm:ss a");

    static class C24481 implements TypeAdapterFactory {
        C24481() {
        }

        public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f22996a == Time.class ? new TimeTypeAdapter() : null;
        }
    }

    public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
        return m31238b(jsonReader);
    }

    private synchronized Time m31238b(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo5258f() == JsonToken.NULL) {
            jsonReader.mo5263k();
            return null;
        }
        try {
            return new Time(this.f30327b.parse(jsonReader.mo5261i()).getTime());
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        }
    }

    private synchronized void m31237a(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.mo5277b(time == null ? null : this.f30327b.format(time));
    }
}
