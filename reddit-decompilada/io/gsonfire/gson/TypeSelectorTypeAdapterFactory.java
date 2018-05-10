package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.gsonfire.ClassConfig;
import io.gsonfire.TypeSelector;
import java.io.IOException;
import java.util.Set;

public class TypeSelectorTypeAdapterFactory<T> implements TypeAdapterFactory {
    private final ClassConfig<T> f31070a;
    private final Set<TypeToken> f31071b;

    private class TypeSelectorTypeAdapter<T> extends TypeAdapter<T> {
        final /* synthetic */ TypeSelectorTypeAdapterFactory f31066a;
        private final Class f31067b;
        private final TypeSelector f31068c;
        private final Gson f31069d;

        private TypeSelectorTypeAdapter(TypeSelectorTypeAdapterFactory typeSelectorTypeAdapterFactory, Class cls, TypeSelector typeSelector, Gson gson) {
            this.f31066a = typeSelectorTypeAdapterFactory;
            this.f31067b = cls;
            this.f31068c = typeSelector;
            this.f31069d = gson;
        }

        public final void m32041a(JsonWriter jsonWriter, T t) throws IOException {
            this.f31069d.a(this.f31069d.a(this.f31066a, TypeToken.a(t.getClass())).a(t), jsonWriter);
        }

        public final T m32040a(JsonReader jsonReader) throws IOException {
            JsonParser jsonParser = new JsonParser();
            jsonReader = JsonParser.a(jsonReader);
            Class a = this.f31068c.m26453a();
            if (a == null) {
                a = this.f31067b;
            }
            TypeToken a2 = TypeToken.a(a);
            this.f31066a.f31071b.add(a2);
            try {
                TypeAdapter a3;
                if (a != this.f31067b) {
                    a3 = this.f31069d.a(a2);
                } else {
                    a3 = this.f31069d.a(this.f31066a, a2);
                }
                this.f31066a.f31071b.remove(a2);
                return a3.a(jsonReader);
            } catch (Throwable th) {
                this.f31066a.f31071b.remove(a2);
            }
        }
    }

    public TypeSelectorTypeAdapterFactory(ClassConfig<T> classConfig, Set<TypeToken> set) {
        this.f31070a = classConfig;
        this.f31071b = set;
    }

    public final <T> TypeAdapter<T> m32043a(Gson gson, TypeToken<T> typeToken) {
        if (!this.f31071b.contains(typeToken) && this.f31070a.f24934a.isAssignableFrom(typeToken.a)) {
            return new NullableTypeAdapter(new TypeSelectorTypeAdapter(typeToken.a, this.f31070a.f24935b, gson));
        }
        return null;
    }
}
