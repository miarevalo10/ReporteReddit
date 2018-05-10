package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: methodSignatureMapping.kt */
public abstract class JvmType {

    /* compiled from: methodSignatureMapping.kt */
    public static final class Array extends JvmType {
        final JvmType f32821a;

        public Array(JvmType jvmType) {
            Intrinsics.m26847b(jvmType, "elementType");
            super();
            this.f32821a = jvmType;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Object extends JvmType {
        final String f32822a;

        public Object(String str) {
            Intrinsics.m26847b(str, "internalName");
            super();
            this.f32822a = str;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Primitive extends JvmType {
        final JvmPrimitiveType f32823a;

        public Primitive(JvmPrimitiveType jvmPrimitiveType) {
            super();
            this.f32823a = jvmPrimitiveType;
        }
    }

    private JvmType() {
    }

    public String toString() {
        return JvmTypeFactoryImpl.f32824a.m33214a(this);
    }
}
