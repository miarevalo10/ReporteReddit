package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: JavaPropertyInitializerEvaluator.kt */
public interface JavaPropertyInitializerEvaluator {

    /* compiled from: JavaPropertyInitializerEvaluator.kt */
    public static final class DoNothing implements JavaPropertyInitializerEvaluator {
        public static final DoNothing f32701a = null;

        public final boolean mo5765a(JavaField javaField) {
            Intrinsics.m26847b(javaField, "field");
            return false;
        }

        static {
            DoNothing doNothing = new DoNothing();
        }

        private DoNothing() {
            f32701a = this;
        }

        public final /* synthetic */ ConstantValue mo5764a(JavaField javaField, PropertyDescriptor propertyDescriptor) {
            Intrinsics.m26847b(javaField, "field");
            Intrinsics.m26847b(propertyDescriptor, "descriptor");
            return null;
        }
    }

    ConstantValue<?> mo5764a(JavaField javaField, PropertyDescriptor propertyDescriptor);

    boolean mo5765a(JavaField javaField);
}
