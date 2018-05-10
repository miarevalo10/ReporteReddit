package com.reddit.frontpage.util;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\u0002J,\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0007\u001a\u00020\u00032\u000e\b\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0001\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/util/BundlerSetString;", "Lcom/evernote/android/state/Bundler;", "", "", "()V", "get", "kotlin.jvm.PlatformType", "key", "bundle", "Landroid/os/Bundle;", "put", "", "value", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BundlerSetString.kt */
public final class BundlerSetString implements Bundler<Set<? extends String>> {
    public final /* synthetic */ Object get(String str, Bundle bundle) {
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(bundle, "bundle");
        str = bundle.getStringArray(str);
        return str != null ? ArraysKt___ArraysKt.m36111k((Object[]) str) : null;
    }

    public final /* synthetic */ void put(String str, Object obj, Bundle bundle) {
        Set set = (Set) obj;
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(set, "value");
        Intrinsics.m26847b(bundle, "bundle");
        obj = set.toArray(new String[0]);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        bundle.putStringArray(str, (String[]) obj);
    }
}
