package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: flexibleTypes.kt */
public final class FlexibleTypeImpl extends FlexibleType implements CustomTypeVariable {
    public static boolean f39982c;
    public static final Companion f39983d = new Companion();
    private boolean f39984e;

    /* compiled from: flexibleTypes.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public FlexibleTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(simpleType, "lowerBound");
        Intrinsics.m26847b(simpleType2, "upperBound");
        super(simpleType, simpleType2);
    }

    public final KotlinType a_(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "replacement");
        kotlinType = kotlinType.mo6738h();
        if (kotlinType instanceof FlexibleType) {
            return kotlinType;
        }
        if (kotlinType instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) kotlinType;
            return KotlinTypeFactory.m27953a(simpleType, simpleType.mo7297b(true));
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String mo7270a(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.m26847b(descriptorRenderer, "renderer");
        Intrinsics.m26847b(descriptorRendererOptions, "options");
        if (descriptorRendererOptions.mo5905b() == null) {
            return descriptorRenderer.mo5889a(descriptorRenderer.mo5894a((KotlinType) this.f38926a), descriptorRenderer.mo5894a((KotlinType) this.f38927b), TypeUtilsKt.m28060a((KotlinType) this));
        }
        descriptorRendererOptions = new StringBuilder("(");
        descriptorRendererOptions.append(descriptorRenderer.mo5894a((KotlinType) this.f38926a));
        descriptorRendererOptions.append("..");
        descriptorRendererOptions.append(descriptorRenderer.mo5894a((KotlinType) this.f38927b));
        descriptorRendererOptions.append(")");
        return descriptorRendererOptions.toString();
    }

    public final SimpleType aP_() {
        if (f39982c) {
            if (!this.f39984e) {
                this.f39984e = true;
                int a = FlexibleTypesKt.m27946a(this.f38926a) ^ 1;
                StringBuilder stringBuilder;
                if (_Assertions.f25274a && a == 0) {
                    stringBuilder = new StringBuilder("Lower bound of a flexible type can not be flexible: ");
                    stringBuilder.append(this.f38926a);
                    throw new AssertionError(stringBuilder.toString());
                }
                a = FlexibleTypesKt.m27946a(this.f38927b) ^ 1;
                if (_Assertions.f25274a && a == 0) {
                    stringBuilder = new StringBuilder("Upper bound of a flexible type can not be flexible: ");
                    stringBuilder.append(this.f38927b);
                    throw new AssertionError(stringBuilder.toString());
                }
                int a2 = 1 ^ Intrinsics.m26845a(this.f38926a, this.f38927b);
                if (_Assertions.f25274a && a2 == 0) {
                    stringBuilder = new StringBuilder("Lower and upper bounds are equal: ");
                    stringBuilder.append(this.f38926a);
                    stringBuilder.append(" == ");
                    stringBuilder.append(this.f38927b);
                    throw new AssertionError(stringBuilder.toString());
                }
                boolean a3 = KotlinTypeChecker.f26349a.mo5935a(this.f38926a, this.f38927b);
                if (_Assertions.f25274a && !a3) {
                    stringBuilder = new StringBuilder("Lower bound ");
                    stringBuilder.append(this.f38926a);
                    stringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
                    stringBuilder.append(this.f38927b);
                    throw new AssertionError(stringBuilder.toString());
                }
            }
        }
        return this.f38926a;
    }

    public final boolean aT_() {
        return (this.f38926a.mo6743g().mo5724c() instanceof TypeParameterDescriptor) && Intrinsics.m26845a(this.f38926a.mo6743g(), this.f38927b.mo6743g());
    }

    public final UnwrappedType mo7271a(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return KotlinTypeFactory.m27953a(this.f38926a.mo7296b(annotations), this.f38927b.mo7296b(annotations));
    }

    public final UnwrappedType mo7272a(boolean z) {
        return KotlinTypeFactory.m27953a(this.f38926a.mo7297b(z), this.f38927b.mo7297b(z));
    }
}
