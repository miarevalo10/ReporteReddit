package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* compiled from: resolvers.kt */
public interface TypeParameterResolver {

    /* compiled from: resolvers.kt */
    public static final class EMPTY implements TypeParameterResolver {
        public static final EMPTY f32713a = null;

        public final TypeParameterDescriptor mo5779a(JavaTypeParameter javaTypeParameter) {
            Intrinsics.m26847b(javaTypeParameter, "javaTypeParameter");
            return null;
        }

        static {
            EMPTY empty = new EMPTY();
        }

        private EMPTY() {
            f32713a = this;
        }
    }

    TypeParameterDescriptor mo5779a(JavaTypeParameter javaTypeParameter);
}
