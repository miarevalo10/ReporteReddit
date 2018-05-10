package com.google.gson;

import com.google.gson.reflect.TypeToken;

public interface TypeAdapterFactory {
    <T> TypeAdapter<T> mo2467a(Gson gson, TypeToken<T> typeToken);
}
