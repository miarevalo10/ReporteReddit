package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.Companion;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory {
    private final KotlinBuiltIns f26089a;

    public ConstantValueFactory(KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtins");
        this.f26089a = kotlinBuiltIns;
    }

    public final LongValue m27728a(long j) {
        return new LongValue(j, this.f26089a);
    }

    public final IntValue m27727a(int i) {
        return new IntValue(i, this.f26089a);
    }

    public static ErrorValue m27718a(String str) {
        Intrinsics.m26847b(str, "message");
        Companion companion = ErrorValue.f32940a;
        return Companion.m27732a(str);
    }

    public final ShortValue m27730a(short s) {
        return new ShortValue(s, this.f26089a);
    }

    public final ByteValue m27722a(byte b) {
        return new ByteValue(b, this.f26089a);
    }

    public final DoubleValue m27725a(double d) {
        return new DoubleValue(d, this.f26089a);
    }

    public final FloatValue m27726a(float f) {
        return new FloatValue(f, this.f26089a);
    }

    public final BooleanValue m27721a(boolean z) {
        return new BooleanValue(z, this.f26089a);
    }

    public final CharValue m27723a(char c) {
        return new CharValue(c, this.f26089a);
    }

    public final StringValue m27731b(String str) {
        Intrinsics.m26847b(str, "value");
        return new StringValue(str, this.f26089a);
    }

    public final NullValue m27729a() {
        return new NullValue(this.f26089a);
    }

    public static EnumValue m27717a(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "enumEntryClass");
        return new EnumValue(classDescriptor);
    }

    public final ArrayValue m27720a(List<? extends ConstantValue<?>> list, KotlinType kotlinType) {
        Intrinsics.m26847b(list, "value");
        Intrinsics.m26847b(kotlinType, "type");
        return new ArrayValue(list, kotlinType, this.f26089a);
    }

    public static AnnotationValue m27716a(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.m26847b(annotationDescriptor, "value");
        return new AnnotationValue(annotationDescriptor);
    }

    public static KClassValue m27719a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        return new KClassValue(kotlinType);
    }

    public final ConstantValue<?> m27724a(Object obj) {
        if (obj instanceof Byte) {
            return m27722a(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return m27730a(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return m27727a(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return m27728a(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return m27723a(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return m27726a(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return m27725a(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return m27721a(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return m27731b((String) obj);
        }
        if (Intrinsics.m26845a(obj, null) != null) {
            return m27729a();
        }
        return null;
    }
}
