package com.google.gson;

import java.lang.reflect.Type;

public interface JsonDeserializer<T> {
    T mo2457a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
