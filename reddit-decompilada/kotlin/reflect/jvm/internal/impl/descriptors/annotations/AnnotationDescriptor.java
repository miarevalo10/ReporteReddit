package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.ReadOnly;

public interface AnnotationDescriptor {
    KotlinType mo5719a();

    @ReadOnly
    Map<ValueParameterDescriptor, ConstantValue<?>> mo5720b();

    SourceElement mo5721c();
}
