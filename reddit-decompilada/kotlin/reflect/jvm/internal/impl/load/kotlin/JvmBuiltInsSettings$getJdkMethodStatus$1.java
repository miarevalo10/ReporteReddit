package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$getJdkMethodStatus$1<N> implements Neighbors<N> {
    final /* synthetic */ JvmBuiltInsSettings f32792a;

    JvmBuiltInsSettings$getJdkMethodStatus$1(JvmBuiltInsSettings jvmBuiltInsSettings) {
        this.f32792a = jvmBuiltInsSettings;
    }

    public final /* synthetic */ Iterable mo5785a(Object obj) {
        Collection arrayList = new ArrayList();
        for (KotlinType g : ((ClassDescriptor) obj).mo7610c().aL_()) {
            ClassifierDescriptor c = g.mo6743g().mo5724c();
            Object obj2 = null;
            c = c != null ? c.aI_() : null;
            if (!(c instanceof ClassDescriptor)) {
                c = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) c;
            if (classDescriptor != null) {
                obj2 = this.f32792a.m33185a(classDescriptor);
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        return (List) arrayList;
    }
}
