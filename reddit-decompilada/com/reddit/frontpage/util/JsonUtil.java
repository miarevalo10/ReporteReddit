package com.reddit.frontpage.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;

public class JsonUtil {

    private static class GsonHolder {
        private static final Gson f21750a = new Gson();
    }

    public static Gson m23770a() {
        return GsonHolder.f21750a;
    }

    public static String m23773a(Object obj) {
        Gson a = GsonHolder.f21750a;
        synchronized (a) {
            obj = a.b(obj);
        }
        return obj;
    }

    public static <T> T m23771a(String str, Class<T> cls) throws JsonSyntaxException {
        Gson a = GsonHolder.f21750a;
        synchronized (a) {
            str = a.a(str, cls);
        }
        return str;
    }

    public static String m23772a(JsonElement jsonElement, String str) {
        if (jsonElement != null) {
            if (!(jsonElement instanceof JsonNull)) {
                jsonElement = jsonElement.h().c(str);
                if (jsonElement != null) {
                    if ((jsonElement instanceof JsonNull) == null) {
                        return jsonElement.c();
                    }
                }
                return null;
            }
        }
        return null;
    }
}
