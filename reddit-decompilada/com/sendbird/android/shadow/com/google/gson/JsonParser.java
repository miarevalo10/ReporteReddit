package com.sendbird.android.shadow.com.google.gson;

import com.sendbird.android.shadow.com.google.gson.internal.Streams;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public static JsonElement m25078a(String str) throws JsonSyntaxException {
        return m25077a(new StringReader(str));
    }

    private static JsonElement m25077a(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            reader = m25076a(jsonReader);
            if ((reader instanceof JsonNull) || jsonReader.mo5258f() == JsonToken.END_DOCUMENT) {
                return reader;
            }
            throw new JsonSyntaxException("Did not consume the entire document.");
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonIOException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        }
    }

    private static JsonElement m25076a(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        StringBuilder stringBuilder;
        boolean z = jsonReader.f23000a;
        jsonReader.f23000a = true;
        try {
            JsonElement a = Streams.m25125a(jsonReader);
            jsonReader.f23000a = z;
            return a;
        } catch (Throwable e) {
            stringBuilder = new StringBuilder("Failed parsing JSON source: ");
            stringBuilder.append(jsonReader);
            stringBuilder.append(" to Json");
            throw new JsonParseException(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            stringBuilder = new StringBuilder("Failed parsing JSON source: ");
            stringBuilder.append(jsonReader);
            stringBuilder.append(" to Json");
            throw new JsonParseException(stringBuilder.toString(), e2);
        } catch (Throwable th) {
            jsonReader.f23000a = z;
        }
    }
}
