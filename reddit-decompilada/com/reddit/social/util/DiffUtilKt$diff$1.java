package com.reddit.social.util;

import android.support.v7.util.DiffUtil.Callback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/reddit/social/util/DiffUtilKt$diff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiffUtil.kt */
public final class DiffUtilKt$diff$1 extends Callback {
    final /* synthetic */ List f29973a;
    final /* synthetic */ List f29974b;
    final /* synthetic */ Function2 f29975c;

    DiffUtilKt$diff$1(List list, List list2, Function2 function2) {
        this.f29973a = list;
        this.f29974b = list2;
        this.f29975c = function2;
    }

    public final int m30897a() {
        return this.f29973a.size();
    }

    public final int m30899b() {
        return this.f29974b.size();
    }

    public final boolean m30898a(int i, int i2) {
        return ((Boolean) this.f29975c.mo6497a(this.f29973a.get(i), this.f29974b.get(i2))).booleanValue();
    }

    public final boolean m30900b(int i, int i2) {
        return Intrinsics.m26845a(this.f29973a.get(i), this.f29974b.get(i2));
    }
}
