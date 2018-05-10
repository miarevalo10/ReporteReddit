package io.gsonfire.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.util.RFC3339DateFormat;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class DateRFC3339TypeAdapter extends TypeAdapter<Date> {
    private final boolean f31040a;
    private final TimeZone f31041b;
    private final ThreadLocal<DateFormat> f31042c = new ThreadLocal();

    public final /* synthetic */ Object m32013a(JsonReader jsonReader) throws IOException {
        return m32012b(jsonReader);
    }

    public final /* synthetic */ void m32014a(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.b(m32011b().format((Date) obj));
    }

    public DateRFC3339TypeAdapter(TimeZone timeZone, boolean z) {
        this.f31041b = timeZone;
        this.f31040a = z;
    }

    private DateFormat m32011b() {
        DateFormat dateFormat = (DateFormat) this.f31042c.get();
        if (dateFormat != null) {
            return dateFormat;
        }
        dateFormat = new RFC3339DateFormat(this.f31041b, this.f31040a);
        this.f31042c.set(dateFormat);
        return dateFormat;
    }

    private Date m32012b(JsonReader jsonReader) throws IOException {
        jsonReader = jsonReader.i();
        try {
            return m32011b().parse(jsonReader);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Could not parse date ");
            stringBuilder.append(jsonReader);
            throw new IOException(stringBuilder.toString(), e);
        }
    }
}
