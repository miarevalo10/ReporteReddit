package com.reddit.frontpage.presentation.template;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000bR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/presentation/template/MapTemplateResolver;", "T", "Lcom/reddit/frontpage/presentation/template/TemplateResolver;", "map", "", "", "(Ljava/util/Map;)V", "getMap", "()Ljava/util/Map;", "resolve", "name", "(Ljava/lang/String;)Ljava/lang/Object;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TemplateResolver.kt */
public final class MapTemplateResolver<T> implements TemplateResolver<T> {
    private final Map<String, T> f28803a;

    public MapTemplateResolver(Map<String, ? extends T> map) {
        Intrinsics.m26847b(map, "map");
        this.f28803a = map;
    }

    public final T mo4929a(String str) {
        Intrinsics.m26847b(str, "name");
        return this.f28803a.get(str);
    }
}
