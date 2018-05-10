package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.Companion;

/* compiled from: BuiltInsPackageFragment.kt */
final class BuiltInsPackageFragment$computeMemberScope$1 extends Lambda implements Function0<List<? extends Name>> {
    final /* synthetic */ BuiltInsPackageFragment f38314a;

    BuiltInsPackageFragment$computeMemberScope$1(BuiltInsPackageFragment builtInsPackageFragment) {
        this.f38314a = builtInsPackageFragment;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f38314a.f40838a.f32615a.keySet()) {
            ClassId classId = (ClassId) next;
            int i = 1;
            if (!classId.m27402e()) {
                Companion companion = ClassDeserializer.f26217a;
                if ((Companion.m27821a().contains(classId) ^ 1) != 0) {
                    if (i != 0) {
                        arrayList.add(next);
                    }
                }
            }
            i = 0;
            if (i != 0) {
                arrayList.add(next);
            }
        }
        Iterable<ClassId> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (ClassId c : iterable) {
            arrayList2.add(c.m27400c());
        }
        return (List) arrayList2;
    }
}
