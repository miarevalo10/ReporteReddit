package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: findClassInModule.kt */
final class C2986x24bfe126 extends Lambda implements Function1<ClassId, ClassId> {
    public static final C2986x24bfe126 f38832a = new C2986x24bfe126();

    C2986x24bfe126() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ClassId classId = (ClassId) obj;
        Intrinsics.m26847b(classId, "it");
        return classId.m27402e() ? classId.m27401d() : null;
    }
}
