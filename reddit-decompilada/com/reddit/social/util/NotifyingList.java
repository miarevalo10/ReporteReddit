package com.reddit.social.util;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView.Adapter;
import com.reddit.frontpage.util.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0002B/\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00032\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J/\u0010\u0014\u001a\u00020\u00152\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00032\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/reddit/social/util/NotifyingList;", "T", "Lkotlin/properties/ReadWriteProperty;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "", "old", "compare", "Lkotlin/Function2;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getCompare", "()Lkotlin/jvm/functions/Function2;", "getOld", "()Ljava/util/List;", "setOld", "(Ljava/util/List;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "value", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: DiffUtil.kt */
public final class NotifyingList<T> implements ReadWriteProperty<Adapter<?>, List<? extends T>> {
    private List<? extends T> f29976a;
    private final Function2<T, T, Boolean> f29977b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "t1", "t2", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Z"}, k = 3, mv = {1, 1, 9})
    /* compiled from: DiffUtil.kt */
    static final class C29111 extends Lambda implements Function2<T, T, Boolean> {
        public static final C29111 f37595a = new C29111();

        C29111() {
            super(2);
        }

        public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
            return Boolean.valueOf(Intrinsics.m26845a(obj, obj2));
        }
    }

    public NotifyingList(List<? extends T> list, Function2<? super T, ? super T, Boolean> function2) {
        Intrinsics.m26847b(list, "old");
        Intrinsics.m26847b(function2, "compare");
        this.f29976a = list;
        this.f29977b = function2;
    }

    public final /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return m30901a((Adapter) obj, kProperty);
    }

    public final /* synthetic */ void setValue(Object obj, KProperty kProperty, Object obj2) {
        m30902a((Adapter) obj, kProperty, (List) obj2);
    }

    public final List<T> m30901a(Adapter<?> adapter, KProperty<?> kProperty) {
        Intrinsics.m26847b(adapter, "thisRef");
        Intrinsics.m26847b(kProperty, "property");
        return this.f29976a;
    }

    public final void m30902a(Adapter<?> adapter, KProperty<?> kProperty, List<? extends T> list) {
        Intrinsics.m26847b(adapter, "thisRef");
        Intrinsics.m26847b(kProperty, "property");
        Intrinsics.m26847b(list, "value");
        Util.m24006c();
        kProperty = DiffUtil.a(DiffUtilKt.m24769a(this.f29976a, list, this.f29977b));
        this.f29976a = list;
        kProperty.a(adapter);
    }
}
