package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

/* compiled from: JavaDescriptorUtil.kt */
public final class JavaDescriptorUtilKt {
    public static final boolean m27208a(PropertyDescriptor propertyDescriptor) {
        Intrinsics.m26847b(propertyDescriptor, "$receiver");
        return propertyDescriptor.mo7826b() == null ? true : null;
    }
}
