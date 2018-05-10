package io.gsonfire;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public interface PostProcessor<T> {
    void mo4762a(JsonElement jsonElement, T t, Gson gson);

    void mo4763a(T t);
}
