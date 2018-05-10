package io.gsonfire.util;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class FieldNameResolver {
    public final FieldNamingStrategy f24966a;
    public final ConcurrentMap<Field, String> f24967b = new ConcurrentHashMap();

    public FieldNameResolver(Gson gson) {
        this.f24966a = gson.a;
    }
}
