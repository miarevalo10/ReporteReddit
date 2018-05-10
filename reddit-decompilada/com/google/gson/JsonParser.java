package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.io.StringReader;

public final class JsonParser {
    public static JsonElement m7505a(String str) throws JsonSyntaxException {
        return m7504a(new StringReader(str));
    }

    private static JsonElement m7504a(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            reader = m7503a(jsonReader);
            if ((reader instanceof JsonNull) || jsonReader.mo2475f() == JsonToken.END_DOCUMENT) {
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

    public static JsonElement m7503a(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        StringBuilder stringBuilder;
        boolean z = jsonReader.f8838a;
        jsonReader.f8838a = true;
        try {
            JsonElement a = Streams.m7553a(jsonReader);
            jsonReader.f8838a = z;
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
            jsonReader.f8838a = z;
        }
    }
}
