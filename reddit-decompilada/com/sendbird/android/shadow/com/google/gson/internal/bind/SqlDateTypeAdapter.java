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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory f30324a = new C24471();
    private final DateFormat f30325b = new SimpleDateFormat("MMM d, yyyy");

    static class C24471 implements TypeAdapterFactory {
        C24471() {
        }

        public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f22996a == Date.class ? new SqlDateTypeAdapter() : null;
        }
    }

    public final /* synthetic */ Object mo5241a(JsonReader jsonReader) throws IOException {
        return m31233b(jsonReader);
    }

    private synchronized Date m31233b(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo5258f() == JsonToken.NULL) {
            jsonReader.mo5263k();
            return null;
        }
        try {
            return new Date(this.f30325b.parse(jsonReader.mo5261i()).getTime());
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        }
    }

    private synchronized void m31232a(JsonWriter jsonWriter, Date date) throws IOException {
        jsonWriter.mo5277b(date == null ? null : this.f30325b.format(date));
    }
}
