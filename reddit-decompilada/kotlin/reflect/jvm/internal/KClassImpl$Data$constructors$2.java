package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.KClassImpl.Data;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KFunction;", "T", "", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$constructors$2 extends Lambda implements Function0<List<? extends KFunction<? extends T>>> {
    final /* synthetic */ Data f38229a;

    KClassImpl$Data$constructors$2(Data data) {
        this.f38229a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<ConstructorDescriptor> b = this.f38229a.f32579h.mo7070b();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        for (ConstructorDescriptor kFunctionImpl : b) {
            arrayList.add(new KFunctionImpl(this.f38229a.f32579h, kFunctionImpl));
        }
        return (List) arrayList;
    }
}
