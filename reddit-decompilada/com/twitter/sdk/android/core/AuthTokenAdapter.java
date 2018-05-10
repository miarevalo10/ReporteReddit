package com.twitter.sdk.android.core;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;
import com.google.gson.internal.Primitives;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AuthTokenAdapter implements JsonDeserializer<AuthToken>, JsonSerializer<AuthToken> {
    static final Map<String, Class<? extends AuthToken>> f30676a;
    private final Gson f30677b = new Gson();

    public final /* synthetic */ JsonElement m31699a(Object obj) {
        String str;
        AuthToken authToken = (AuthToken) obj;
        JsonElement jsonObject = new JsonObject();
        String str2 = "auth_type";
        Class cls = authToken.getClass();
        for (Entry entry : f30676a.entrySet()) {
            if (((Class) entry.getValue()).equals(cls)) {
                str = (String) entry.getKey();
                break;
            }
        }
        str = "";
        jsonObject.a(str2, str);
        jsonObject.a("auth_token", this.f30677b.a(authToken));
        return jsonObject;
    }

    static {
        Map hashMap = new HashMap();
        f30676a = hashMap;
        hashMap.put("oauth1a", TwitterAuthToken.class);
        f30676a.put("oauth2", OAuth2Token.class);
        f30676a.put("guest", GuestAuthToken.class);
    }

    public final /* synthetic */ Object m31700a(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        jsonElement = jsonElement.h();
        type = jsonElement.d("auth_type").c();
        jsonElement = jsonElement.c("auth_token");
        Class cls = (Class) f30676a.get(type);
        return (AuthToken) Primitives.a(cls).cast(this.f30677b.a(jsonElement, cls));
    }
}
