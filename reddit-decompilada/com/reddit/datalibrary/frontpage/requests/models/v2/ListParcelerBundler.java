package com.reddit.datalibrary.frontpage.requests.models.v2;

import android.os.Bundle;
import com.evernote.android.state.Bundler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.parceler.Parcels;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/requests/models/v2/ListParcelerBundler;", "T", "", "Lcom/evernote/android/state/Bundler;", "()V", "get", "key", "", "bundle", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)Ljava/util/List;", "put", "", "value", "(Ljava/lang/String;Ljava/util/List;Landroid/os/Bundle;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListParcelerBundler.kt */
public final class ListParcelerBundler<T extends List<?>> implements Bundler<T> {
    public final /* synthetic */ Object get(String str, Bundle bundle) {
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(bundle, "bundle");
        return (List) Parcels.m28673a(bundle.getParcelable(str));
    }

    public final /* synthetic */ void put(String str, Object obj, Bundle bundle) {
        List list = (List) obj;
        Intrinsics.m26847b(str, "key");
        Intrinsics.m26847b(list, "value");
        Intrinsics.m26847b(bundle, "bundle");
        bundle.putParcelable(str, Parcels.m28672a(new ArrayList(list)));
    }
}
