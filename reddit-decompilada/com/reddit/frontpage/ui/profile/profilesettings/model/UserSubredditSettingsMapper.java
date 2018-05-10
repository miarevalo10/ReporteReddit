package com.reddit.frontpage.ui.profile.profilesettings.model;

import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/model/UserSubredditSettingsMapper;", "", "()V", "toParameters", "", "", "responseBody", "Lokhttp3/ResponseBody;", "displayName", "about", "contentVisible", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserSubredditSettingsMapper.kt */
public final class UserSubredditSettingsMapper {
    public static final UserSubredditSettingsMapper f21567a = new UserSubredditSettingsMapper();

    private UserSubredditSettingsMapper() {
    }

    public static Map<String, String> m23604a(ResponseBody responseBody, String str, String str2, boolean z) {
        Intrinsics.m26847b(responseBody, "responseBody");
        Intrinsics.m26847b(str, "displayName");
        Intrinsics.m26847b(str2, "about");
        JsonParser jsonParser = new JsonParser();
        Object a = JsonParser.a(responseBody.string());
        Intrinsics.m26843a(a, "JsonParser().parse(responseBody.string())");
        a = a.h().e("data");
        Intrinsics.m26843a(a, "json.getAsJsonObject(\"data\")");
        a.a("title", str);
        a.a("public_description", str2);
        a.a("allow_top", JsonObject.a(Boolean.valueOf(z)));
        a.a("sr", a.a("subreddit_id"));
        a.a("link_type", a.a("content_options"));
        a.a("type", a.a("subreddit_type"));
        Object entrySet = a.a.entrySet();
        Intrinsics.m26843a(entrySet, "entrySet()");
        Collection collection = (Collection) new ArrayList();
        for (boolean z2 : (Iterable) entrySet) {
            if (((Entry) z2).getValue() instanceof JsonNull) {
                collection.add(z2);
            }
        }
        for (Entry key : (List) collection) {
            a.a((String) key.getKey());
        }
        return (Map) new Gson().a(a.toString(), new UserSubredditSettingsMapper$toParameters$typeOfHashMap$1().b);
    }
}
