package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public abstract class ReflectJavaAnnotationArgument implements JavaAnnotationArgument {
    public static final Factory f32756a = new Factory();
    private final Name f32757b;

    /* compiled from: ReflectJavaAnnotationArguments.kt */
    public static final class Factory {
        private Factory() {
        }

        public static ReflectJavaAnnotationArgument m27247a(Object obj, Name name) {
            Intrinsics.m26847b(obj, "value");
            if (ReflectClassUtilKt.m27241b(obj.getClass())) {
                if (obj != null) {
                    return new ReflectJavaEnumValueAnnotationArgument(name, (Enum) obj);
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
            } else if (obj instanceof Annotation) {
                return new ReflectJavaAnnotationAsAnnotationArgument(name, (Annotation) obj);
            } else {
                if (obj instanceof Object[]) {
                    return new ReflectJavaArrayAnnotationArgument(name, (Object[]) obj);
                }
                if (obj instanceof Class) {
                    return new ReflectJavaClassObjectAnnotationArgument(name, (Class) obj);
                }
                return new ReflectJavaLiteralAnnotationArgument(name, obj);
            }
        }
    }

    public ReflectJavaAnnotationArgument(Name name) {
        this.f32757b = name;
    }

    public final Name mo5800a() {
        return this.f32757b;
    }
}
