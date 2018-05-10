package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KFunctionImpl.kt */
final class KFunctionImpl$descriptor$2 extends Lambda implements Function0<FunctionDescriptor> {
    final /* synthetic */ KFunctionImpl f38250a;
    final /* synthetic */ String f38251b;

    KFunctionImpl$descriptor$2(KFunctionImpl kFunctionImpl, String str) {
        this.f38250a = kFunctionImpl;
        this.f38251b = str;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        KDeclarationContainerImpl kDeclarationContainerImpl = this.f38250a.f38253a;
        String str = this.f38251b;
        Object a = this.f38250a.f38257f;
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(a, "signature");
        Collection n;
        if (Intrinsics.m26845a((Object) str, (Object) "<init>")) {
            n = CollectionsKt___CollectionsKt.m41449n(kDeclarationContainerImpl.mo7070b());
        } else {
            Name a2 = Name.m27424a(str);
            Intrinsics.m26843a((Object) a2, "Name.identifier(name)");
            n = kDeclarationContainerImpl.mo7071b(a2);
        }
        Collection arrayList = new ArrayList();
        for (Object next : r3) {
            FunctionDescriptor functionDescriptor = (FunctionDescriptor) next;
            RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
            if (Intrinsics.m26845a(RuntimeTypeMapper.m26928a(functionDescriptor).mo5690a(), a)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (list.size() == 1) {
            return (FunctionDescriptor) CollectionsKt___CollectionsKt.m41441h(list);
        }
        StringBuilder stringBuilder = new StringBuilder("'");
        stringBuilder.append(str);
        stringBuilder.append("' (JVM signature: ");
        stringBuilder.append(a);
        stringBuilder.append(")");
        str = stringBuilder.toString();
        if (list.isEmpty()) {
            stringBuilder = new StringBuilder("Function ");
            stringBuilder.append(str);
            stringBuilder.append(" not resolved in ");
            stringBuilder.append(kDeclarationContainerImpl);
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(list.size());
            stringBuilder.append(" functions ");
            stringBuilder.append(str);
            stringBuilder.append(" resolved in ");
            stringBuilder.append(kDeclarationContainerImpl);
            stringBuilder.append(": ");
            stringBuilder.append(list);
        }
        throw new KotlinReflectionInternalError(stringBuilder.toString());
    }
}
