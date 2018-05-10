package com.reddit.social.domain.functions;

import com.google.gson.JsonElement;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/reddit/social/domain/functions/CreateChannelResponseTransformer;", "Lio/reactivex/functions/Function;", "Lcom/google/gson/JsonElement;", "", "()V", "apply", "jsonElement", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CreateChannelResponseTransformer.kt */
public final class CreateChannelResponseTransformer implements Function<JsonElement, String> {
    public final /* synthetic */ Object apply(Object obj) {
        JsonElement jsonElement = (JsonElement) obj;
        Intrinsics.m26847b(jsonElement, "jsonElement");
        obj = jsonElement.h();
        if (obj != null) {
            obj = obj.d("channel_url");
            if (obj != null) {
                obj = obj.c();
                if (obj != null) {
                    return obj;
                }
            }
        }
        return "";
    }
}
