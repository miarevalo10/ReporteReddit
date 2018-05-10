package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public final class Annotations$Companion$EMPTY$1 implements Annotations {
    public final boolean mo6680a() {
        return true;
    }

    public final String toString() {
        return "EMPTY";
    }

    Annotations$Companion$EMPTY$1() {
    }

    public final /* synthetic */ AnnotationDescriptor mo6679a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return null;
    }

    public final boolean mo6682b(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return DefaultImpls.m27116a(this, fqName);
    }

    public final List<AnnotationWithTarget> mo6681b() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final List<AnnotationWithTarget> mo6683c() {
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public final Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt__CollectionsKt.m26790a().iterator();
    }
}
