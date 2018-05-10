package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: ReflectKotlinClassFinder.kt */
public final class ReflectKotlinClassFinderKt {
    public static final /* synthetic */ String m27390a(ClassId classId) {
        String a = StringsKt__StringsJVMKt.m41941a(classId.m27399b().m27407a(), '.', '$');
        if (classId.m27398a().f25856b.f25861b.isEmpty()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(classId.m27398a());
        stringBuilder.append(".");
        stringBuilder.append(a);
        return stringBuilder.toString();
    }
}
