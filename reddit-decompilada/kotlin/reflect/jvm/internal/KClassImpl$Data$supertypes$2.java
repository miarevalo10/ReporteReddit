package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "T", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$supertypes$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    final /* synthetic */ Data f38242a;

    KClassImpl$Data$supertypes$2(Data data) {
        this.f38242a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<Object> aL_ = this.f38242a.m32891a().mo7610c().aL_();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(aL_));
        for (Object obj : aL_) {
            Intrinsics.m26843a(obj, "kotlinType");
            arrayList.add(new KTypeImpl(obj, new KClassImpl$Data$supertypes$2$$special$$inlined$map$lambda$1(obj, this)));
        }
        return (List) arrayList;
    }
}
