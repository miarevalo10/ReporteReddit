package io.gsonfire.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Date;

abstract class DateUnixtimeTypeAdapter extends TypeAdapter<Date> {
    private final boolean f31043a;

    protected abstract long mo6605a(Date date);

    protected abstract Date mo6606a(long j);

    public final /* synthetic */ void m32018a(JsonWriter jsonWriter, Object obj) throws IOException {
        Date date = (Date) obj;
        if (date.getTime() < 0) {
            if (!this.f31043a) {
                jsonWriter.f();
                return;
            }
        }
        jsonWriter.a(mo6605a(date));
    }

    public DateUnixtimeTypeAdapter(boolean z) {
        this.f31043a = z;
    }

    public final /* synthetic */ Object m32016a(JsonReader jsonReader) throws IOException {
        long m = jsonReader.m();
        if (m < 0) {
            if (this.f31043a == null) {
                return null;
            }
        }
        return mo6606a(m);
    }
}
