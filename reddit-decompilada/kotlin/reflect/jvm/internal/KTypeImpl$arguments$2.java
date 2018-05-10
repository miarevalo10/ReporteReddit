package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KTypeProjection.Companion;
import kotlin.reflect.jvm.internal.KTypeImpl.WhenMappings;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KTypeImpl.kt */
final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    final /* synthetic */ KTypeImpl f38307a;

    KTypeImpl$arguments$2(KTypeImpl kTypeImpl) {
        this.f38307a = kTypeImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        List a = this.f38307a.f32603a.mo6739a();
        if (a.isEmpty()) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        Lazy a2 = LazyKt.m26776a(LazyThreadSafetyMode.f25264b, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(this));
        KProperty kProperty = KTypeImpl$arguments$2$parameterizedTypeArguments$1.f40286a;
        Iterable<TypeProjection> iterable = a;
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        int i = 0;
        for (TypeProjection typeProjection : iterable) {
            Object a3;
            int i2 = i + 1;
            Companion companion;
            if (typeProjection.mo6734a()) {
                companion = KTypeProjection.f25301a;
                a3 = Companion.m26884a();
            } else {
                Object c = typeProjection.mo6736c();
                Intrinsics.m26843a(c, "typeProjection.type");
                KTypeImpl kTypeImpl = new KTypeImpl(c, new KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(i, this, a2, kProperty));
                switch (WhenMappings.f25336a[typeProjection.mo6735b().ordinal()]) {
                    case 1:
                        companion = KTypeProjection.f25301a;
                        a3 = Companion.m26885a(kTypeImpl);
                        break;
                    case 2:
                        companion = KTypeProjection.f25301a;
                        a3 = Companion.m26886b(kTypeImpl);
                        break;
                    case 3:
                        companion = KTypeProjection.f25301a;
                        a3 = Companion.m26887c(kTypeImpl);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(a3);
            i = i2;
        }
        return (List) arrayList;
    }
}
