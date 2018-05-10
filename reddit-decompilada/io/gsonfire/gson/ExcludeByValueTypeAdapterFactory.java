package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.annotations.ExcludeByValue;
import io.gsonfire.util.FieldNameResolver;
import io.gsonfire.util.reflection.Factory;
import io.gsonfire.util.reflection.FieldInspector;
import java.io.IOException;
import java.lang.reflect.Field;

public final class ExcludeByValueTypeAdapterFactory implements TypeAdapterFactory {
    private final FieldInspector f31051a;
    private final Factory f31052b;
    private FieldNameResolver f31053c = null;

    private class ExcludeByValueTypeAdapter extends TypeAdapter {
        final /* synthetic */ ExcludeByValueTypeAdapterFactory f31048a;
        private final Gson f31049b;
        private final TypeAdapter f31050c;

        public ExcludeByValueTypeAdapter(ExcludeByValueTypeAdapterFactory excludeByValueTypeAdapterFactory, Gson gson, TypeAdapter typeAdapter) {
            this.f31048a = excludeByValueTypeAdapterFactory;
            this.f31049b = gson;
            this.f31050c = typeAdapter;
        }

        public final void m32024a(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                this.f31050c.a(jsonWriter, obj);
                return;
            }
            JsonElement jsonElement = null;
            for (Field field : this.f31048a.f31051a.m26465a(obj.getClass(), ExcludeByValue.class)) {
                try {
                    ExclusionByValueStrategy exclusionByValueStrategy = (ExclusionByValueStrategy) this.f31048a.f31052b.mo5620a(((ExcludeByValue) field.getAnnotation(ExcludeByValue.class)).m26454a());
                    field.get(obj);
                    if (exclusionByValueStrategy.m26457a()) {
                        FieldNameResolver c = this.f31048a.f31053c;
                        String str = (String) c.f24967b.get(field);
                        if (str == null) {
                            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                            if (serializedName == null) {
                                str = c.f24966a.a(field);
                            } else {
                                str = serializedName.a();
                            }
                            if (!c.f24967b.containsKey(field)) {
                                c.f24967b.put(field, str);
                            }
                        }
                        if (str == null) {
                            continue;
                        } else {
                            if (jsonElement == null) {
                                JsonElement a = this.f31050c.a(obj);
                                if (a == null || (a instanceof JsonNull)) {
                                    break;
                                } else if (!(a instanceof JsonObject)) {
                                    break;
                                } else {
                                    jsonElement = this.f31050c.a(obj).h();
                                }
                            }
                            jsonElement.a(str);
                        }
                    }
                } catch (JsonWriter jsonWriter2) {
                    throw new RuntimeException(jsonWriter2);
                }
            }
            if (jsonElement != null) {
                this.f31049b.a(jsonElement, jsonWriter2);
            } else {
                this.f31050c.a(jsonWriter2, obj);
            }
        }

        public final Object m32023a(JsonReader jsonReader) throws IOException {
            return this.f31050c.a(jsonReader);
        }
    }

    public ExcludeByValueTypeAdapterFactory(FieldInspector fieldInspector, Factory factory) {
        this.f31051a = fieldInspector;
        this.f31052b = factory;
    }

    public final <T> TypeAdapter<T> m32028a(Gson gson, TypeToken<T> typeToken) {
        if (this.f31053c == null) {
            this.f31053c = new FieldNameResolver(gson);
        }
        return new ExcludeByValueTypeAdapter(this, gson, gson.a(this, typeToken));
    }
}
