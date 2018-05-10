package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;

/* compiled from: ReflectJavaModifierListOwner.kt */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    public static final class DefaultImpls {
        public static boolean m27252a(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isAbstract(reflectJavaModifierListOwner.mo7105s());
        }

        public static boolean m27253b(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isStatic(reflectJavaModifierListOwner.mo7105s());
        }

        public static boolean m27254c(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isFinal(reflectJavaModifierListOwner.mo7105s());
        }

        public static Visibility m27255d(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            reflectJavaModifierListOwner = reflectJavaModifierListOwner.mo7105s();
            if (Modifier.isPublic(reflectJavaModifierListOwner)) {
                reflectJavaModifierListOwner = Visibilities.f25508e;
                Intrinsics.m26843a((Object) reflectJavaModifierListOwner, "Visibilities.PUBLIC");
            } else if (Modifier.isPrivate(reflectJavaModifierListOwner)) {
                reflectJavaModifierListOwner = Visibilities.f25504a;
                Intrinsics.m26843a((Object) reflectJavaModifierListOwner, "Visibilities.PRIVATE");
            } else if (Modifier.isProtected(reflectJavaModifierListOwner)) {
                if (Modifier.isStatic(reflectJavaModifierListOwner) != null) {
                    reflectJavaModifierListOwner = JavaVisibilities.f25627b;
                } else {
                    reflectJavaModifierListOwner = JavaVisibilities.f25628c;
                }
                Intrinsics.m26843a((Object) reflectJavaModifierListOwner, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
            } else {
                reflectJavaModifierListOwner = JavaVisibilities.f25626a;
                Intrinsics.m26843a((Object) reflectJavaModifierListOwner, "JavaVisibilities.PACKAGE_VISIBILITY");
            }
            return (Visibility) reflectJavaModifierListOwner;
        }
    }

    int mo7105s();
}
