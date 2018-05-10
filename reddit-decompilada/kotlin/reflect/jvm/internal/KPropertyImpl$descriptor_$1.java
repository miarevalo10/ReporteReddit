package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.name.Name;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImpl$descriptor_$1 extends Lambda implements Function0<PropertyDescriptor> {
    final /* synthetic */ KPropertyImpl f38292a;

    KPropertyImpl$descriptor_$1(KPropertyImpl kPropertyImpl) {
        this.f38292a = kPropertyImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        KDeclarationContainerImpl kDeclarationContainerImpl = this.f38292a.f36037b;
        String str = this.f38292a.f36038c;
        Object obj = this.f38292a.f36039d;
        Intrinsics.m26847b(str, "name");
        Intrinsics.m26847b(obj, "signature");
        Name a = Name.m27424a(str);
        Intrinsics.m26843a((Object) a, "Name.identifier(name)");
        Collection arrayList = new ArrayList();
        Iterator it = kDeclarationContainerImpl.mo7069a(a).iterator();
        while (true) {
            Object obj2 = 1;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) next;
            if (propertyDescriptor instanceof PropertyDescriptor) {
                RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.f25343a;
                if (Intrinsics.m26845a(RuntimeTypeMapper.m26929a(propertyDescriptor).mo5691a(), obj)) {
                    if (obj2 != null) {
                        arrayList.add(next);
                    }
                }
            }
            obj2 = null;
            if (obj2 != null) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder("Property '");
            stringBuilder.append(str);
            stringBuilder.append("' (JVM signature: ");
            stringBuilder.append(obj);
            stringBuilder.append(") not resolved in ");
            stringBuilder.append(kDeclarationContainerImpl);
            throw new KotlinReflectionInternalError(stringBuilder.toString());
        } else if (list.size() == 1) {
            return (PropertyDescriptor) CollectionsKt___CollectionsKt.m41441h(list);
        } else {
            Map linkedHashMap = new LinkedHashMap();
            for (Object next2 : list) {
                Visibility j = ((PropertyDescriptor) next2).mo7257j();
                ArrayList arrayList2 = linkedHashMap.get(j);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(j, arrayList2);
                }
                arrayList2.add(next2);
            }
            List list2 = (List) CollectionsKt___CollectionsKt.m41436f((Iterable) MapsKt__MapsJVMKt.m32818a(linkedHashMap, C2137x62283bb.f25335a).values());
            if (list2.size() == 1) {
                return (PropertyDescriptor) CollectionsKt___CollectionsKt.m41430d(list2);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(list.size());
            stringBuilder2.append(" properties '");
            stringBuilder2.append(str);
            stringBuilder2.append("' (JVM signature: ");
            stringBuilder2.append(obj);
            stringBuilder2.append(") resolved in ");
            stringBuilder2.append(kDeclarationContainerImpl);
            stringBuilder2.append(": ");
            stringBuilder2.append(list);
            throw new KotlinReflectionInternalError(stringBuilder2.toString());
        }
    }
}
