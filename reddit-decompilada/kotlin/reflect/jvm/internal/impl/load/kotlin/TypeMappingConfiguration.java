package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: typeSignatureMapping.kt */
public interface TypeMappingConfiguration<T> {
    public static final Companion f25812a = new Companion();

    /* compiled from: typeSignatureMapping.kt */
    public static final class Companion {
        private static final Function2<String, String, String> f25811a = null;

        private Companion() {
            f25811a = C2978xfa72d02b.f38781a;
        }

        public static Function2<String, String, String> m27368a() {
            return f25811a;
        }
    }

    /* compiled from: typeSignatureMapping.kt */
    public static final class DefaultImpls {
        public static <T> Function2<String, String, String> m27369a() {
            Companion companion = TypeMappingConfiguration.f25812a;
            return Companion.m27368a();
        }
    }

    T mo5837a(ClassDescriptor classDescriptor);

    Function2<String, String, String> mo5838a();

    KotlinType mo5839a(Collection<KotlinType> collection);

    void mo5840a(KotlinType kotlinType, ClassDescriptor classDescriptor);

    String mo5841b(ClassDescriptor classDescriptor);
}
