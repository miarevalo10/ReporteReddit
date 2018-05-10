package com.twitter.sdk.android.core.models;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map.Entry;

public class BindingValuesAdapter implements JsonDeserializer<BindingValues>, JsonSerializer<BindingValues> {
    public final /* bridge */ /* synthetic */ JsonElement m31756a(Object obj) {
        return null;
    }

    public final /* synthetic */ Object m31757a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if ((jsonElement instanceof JsonObject) == null) {
            return new BindingValues();
        }
        JsonElement<Entry> entrySet = jsonElement.h().a.entrySet();
        type = new HashMap(32);
        for (Entry entry : entrySet) {
            String str = (String) entry.getKey();
            JsonObject h = ((JsonElement) entry.getValue()).h();
            JsonElement c = h.c("type");
            Object obj = null;
            if (c != null) {
                if (c instanceof JsonPrimitive) {
                    String c2 = c.c();
                    Object obj2 = -1;
                    int hashCode = c2.hashCode();
                    if (hashCode != -1838656495) {
                        if (hashCode != 2614219) {
                            if (hashCode != 69775675) {
                                if (hashCode == 782694408) {
                                    if (c2.equals("BOOLEAN")) {
                                        obj2 = 3;
                                    }
                                }
                            } else if (c2.equals("IMAGE")) {
                                obj2 = 1;
                            }
                        } else if (c2.equals("USER")) {
                            obj2 = 2;
                        }
                    } else if (c2.equals("STRING")) {
                        obj2 = null;
                    }
                    switch (obj2) {
                        case null:
                            obj = jsonDeserializationContext.a(h.c("string_value"), String.class);
                            break;
                        case 1:
                            obj = jsonDeserializationContext.a(h.c("image_value"), ImageValue.class);
                            break;
                        case 2:
                            obj = jsonDeserializationContext.a(h.c("user_value"), UserValue.class);
                            break;
                        case 3:
                            obj = jsonDeserializationContext.a(h.c("boolean_value"), Boolean.class);
                            break;
                        default:
                            break;
                    }
                }
            }
            type.put(str, obj);
        }
        return new BindingValues(type);
    }
}
