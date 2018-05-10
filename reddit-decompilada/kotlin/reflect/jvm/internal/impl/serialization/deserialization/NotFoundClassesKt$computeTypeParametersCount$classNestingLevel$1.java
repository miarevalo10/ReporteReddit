package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: NotFoundClasses.kt */
final class NotFoundClassesKt$computeTypeParametersCount$classNestingLevel$1 extends Lambda implements Function1<ClassId, ClassId> {
    public static final NotFoundClassesKt$computeTypeParametersCount$classNestingLevel$1 f38857a = new NotFoundClassesKt$computeTypeParametersCount$classNestingLevel$1();

    NotFoundClassesKt$computeTypeParametersCount$classNestingLevel$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ClassId classId = (ClassId) obj;
        Intrinsics.m26847b(classId, "it");
        return classId.m27402e() ? classId.m27401d() : null;
    }
}
