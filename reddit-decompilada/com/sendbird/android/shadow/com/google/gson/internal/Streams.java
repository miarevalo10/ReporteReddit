package com.sendbird.android.shadow.com.google.gson.internal;

import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.internal.bind.TypeAdapters;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sendbird.android.shadow.com.google.gson.JsonElement m25125a(com.sendbird.android.shadow.com.google.gson.stream.JsonReader r2) throws com.sendbird.android.shadow.com.google.gson.JsonParseException {
        /*
        r2.mo5258f();	 Catch:{ EOFException -> 0x0024, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r0 = 0;
        r1 = com.sendbird.android.shadow.com.google.gson.internal.bind.TypeAdapters.f22966X;	 Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r2 = r1.mo5241a(r2);	 Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r2 = (com.sendbird.android.shadow.com.google.gson.JsonElement) r2;	 Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        return r2;
    L_0x000d:
        r2 = move-exception;
        goto L_0x0026;
    L_0x000f:
        r2 = move-exception;
        r0 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
        r0.<init>(r2);
        throw r0;
    L_0x0016:
        r2 = move-exception;
        r0 = new com.sendbird.android.shadow.com.google.gson.JsonIOException;
        r0.<init>(r2);
        throw r0;
    L_0x001d:
        r2 = move-exception;
        r0 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
        r0.<init>(r2);
        throw r0;
    L_0x0024:
        r2 = move-exception;
        r0 = 1;
    L_0x0026:
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r2 = com.sendbird.android.shadow.com.google.gson.JsonNull.f30234a;
        return r2;
    L_0x002b:
        r0 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException;
        r0.<init>(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.Streams.a(com.sendbird.android.shadow.com.google.gson.stream.JsonReader):com.sendbird.android.shadow.com.google.gson.JsonElement");
    }

    public static void m25127a(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.f22966X.mo5242a(jsonWriter, jsonElement);
    }

    public static Writer m25126a(Appendable appendable) {
        return (Writer) appendable;
    }
}
