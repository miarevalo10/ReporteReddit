package com.sendbird.android.shadow.com.google.gson.internal.bind;

import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.TypeAdapter;
import com.sendbird.android.shadow.com.google.gson.TypeAdapterFactory;
import com.sendbird.android.shadow.com.google.gson.internal.LinkedTreeMap;
import com.sendbird.android.shadow.com.google.gson.reflect.TypeToken;
import com.sendbird.android.shadow.com.google.gson.stream.JsonReader;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    public static final TypeAdapterFactory f30309a = new C24451();
    private final Gson f30310b;

    static class C24451 implements TypeAdapterFactory {
        C24451() {
        }

        public final <T> TypeAdapter<T> mo5250a(Gson gson, TypeToken<T> typeToken) {
            return typeToken.f22996a == Object.class ? new ObjectTypeAdapter(gson) : null;
        }
    }

    ObjectTypeAdapter(Gson gson) {
        this.f30310b = gson;
    }

    public final Object mo5241a(JsonReader jsonReader) throws IOException {
        switch (jsonReader.mo5258f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                jsonReader.mo5252a();
                while (jsonReader.mo5257e()) {
                    arrayList.add(mo5241a(jsonReader));
                }
                jsonReader.mo5253b();
                return arrayList;
            case BEGIN_OBJECT:
                Map linkedTreeMap = new LinkedTreeMap();
                jsonReader.mo5254c();
                while (jsonReader.mo5257e()) {
                    linkedTreeMap.put(jsonReader.mo5260h(), mo5241a(jsonReader));
                }
                jsonReader.mo5256d();
                return linkedTreeMap;
            case STRING:
                return jsonReader.mo5261i();
            case NUMBER:
                return Double.valueOf(jsonReader.mo5264l());
            case BOOLEAN:
                return Boolean.valueOf(jsonReader.mo5262j());
            case NULL:
                jsonReader.mo5263k();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public final void mo5242a(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo5281e();
            return;
        }
        TypeAdapter a = this.f30310b.m25063a(obj.getClass());
        if (a instanceof ObjectTypeAdapter) {
            jsonWriter.mo5278c();
            jsonWriter.mo5280d();
            return;
        }
        a.mo5242a(jsonWriter, obj);
    }
}
