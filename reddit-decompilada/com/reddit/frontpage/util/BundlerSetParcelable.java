package com.reddit.frontpage.util;

import android.os.Bundle;
import android.os.Parcelable;
import com.evernote.android.state.Bundler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00030\u00030\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/util/BundlerSetParcelable;", "Lcom/evernote/android/state/Bundler;", "", "Landroid/os/Parcelable;", "()V", "get", "kotlin.jvm.PlatformType", "key", "", "bundle", "Landroid/os/Bundle;", "put", "", "value", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BundlerSetParcelable.kt */
public final class BundlerSetParcelable implements Bundler<Set<? extends Parcelable>> {
    public final /* synthetic */ Object get(String str, Bundle bundle) {
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(bundle, "bundle");
        str = bundle.getParcelableArray(str);
        if (str != null) {
            str = ArraysKt___ArraysKt.m36111k((Object[]) str);
            if (str != null) {
                return str;
            }
        }
        return SetsKt__SetsKt.m26799a();
    }

    public final /* synthetic */ void put(String str, Object obj, Bundle bundle) {
        Set set = (Set) obj;
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(set, "value");
        Intrinsics.m26847b(bundle, "bundle");
        obj = set.toArray(new Parcelable[0]);
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        bundle.putParcelableArray(str, (Parcelable[]) obj);
    }
}
