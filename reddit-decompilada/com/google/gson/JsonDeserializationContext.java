package com.google.gson;

import java.lang.reflect.Type;

public interface JsonDeserializationContext {
    <T> T mo2504a(JsonElement jsonElement, Type type) throws JsonParseException;
}
