package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KCallableImpl.kt */
final class KCallableImpl$typeParameters_$1 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
    final /* synthetic */ KCallableImpl f38224a;

    KCallableImpl$typeParameters_$1(KCallableImpl kCallableImpl) {
        this.f38224a = kCallableImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<TypeParameterDescriptor> f = this.f38224a.mo6676a().mo7735f();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(f));
        for (TypeParameterDescriptor kTypeParameterImpl : f) {
            arrayList.add(new KTypeParameterImpl(kTypeParameterImpl));
        }
        return (List) arrayList;
    }
}
