package kotlin.reflect.jvm.internal.impl.serialization.jvm;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite f26286a = null;

    static {
        ClassMapperLite classMapperLite = new ClassMapperLite();
    }

    private ClassMapperLite() {
        f26286a = this;
    }

    public static final String m27904a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        Object a = StringsKt__StringsJVMKt.m41941a(classId.m27404g(), '.', '$');
        Object a2 = StringsKt__StringsKt.m42447a((String) a, (CharSequence) "kotlin/");
        if ((Intrinsics.m26845a(a2, a) ^ 1) != 0) {
            JvmPrimitiveType[] values = JvmPrimitiveType.values();
            int i = 0;
            while (i < values.length) {
                JvmPrimitiveType jvmPrimitiveType = values[i];
                PrimitiveType a3 = jvmPrimitiveType.m27755a();
                if (Intrinsics.m26845a(a2, a3.m27028a().m27429a())) {
                    Object c = jvmPrimitiveType.m27757c();
                    Intrinsics.m26843a(c, "jvmPrimitive.desc");
                    return c;
                } else if (Intrinsics.m26845a(a2, a3.m27029b().m27429a())) {
                    classId = new StringBuilder("[");
                    classId.append(jvmPrimitiveType.m27757c());
                    return classId.toString();
                } else {
                    i++;
                }
            }
            if (Intrinsics.m26845a(a2, KotlinBuiltIns.f25420j.f25384e.m27421e().m27429a())) {
                return "V";
            }
        }
        classId = JavaToKotlinClassMap.f25878a.m27443a(classId.m27403f().m27409b());
        if (classId != null) {
            StringBuilder stringBuilder = new StringBuilder("L");
            stringBuilder.append(StringsKt__StringsJVMKt.m41941a((String) classId.m27404g(), '.', '$'));
            stringBuilder.append(";");
            return stringBuilder.toString();
        }
        classId = new StringBuilder("L");
        classId.append(a);
        classId.append(";");
        return classId.toString();
    }
}
