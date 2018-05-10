package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "T", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$typeParameters$2 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {
    final /* synthetic */ Data f38243a;

    KClassImpl$Data$typeParameters$2(Data data) {
        this.f38243a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<TypeParameterDescriptor> s = this.f38243a.m32891a().mo7719s();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(s));
        for (TypeParameterDescriptor kTypeParameterImpl : s) {
            arrayList.add(new KTypeParameterImpl(kTypeParameterImpl));
        }
        return (List) arrayList;
    }
}
