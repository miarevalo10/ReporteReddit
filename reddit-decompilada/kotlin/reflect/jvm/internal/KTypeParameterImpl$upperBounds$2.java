package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KTypeParameterImpl.kt */
final class KTypeParameterImpl$upperBounds$2 extends Lambda implements Function0<List<? extends KTypeImpl>> {
    final /* synthetic */ KTypeParameterImpl f38310a;

    KTypeParameterImpl$upperBounds$2(KTypeParameterImpl kTypeParameterImpl) {
        this.f38310a = kTypeParameterImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<Object> j = this.f38310a.f36043a.mo7715j();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(j));
        for (Object obj : j) {
            Intrinsics.m26843a(obj, "kotlinType");
            arrayList.add(new KTypeImpl(obj, new KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1(this)));
        }
        return (List) arrayList;
    }
}
