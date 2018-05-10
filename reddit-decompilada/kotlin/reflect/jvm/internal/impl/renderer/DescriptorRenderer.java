package kotlin.reflect.jvm.internal.impl.renderer;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: DescriptorRenderer.kt */
public abstract class DescriptorRenderer {
    public static final DescriptorRenderer f26008a = Companion.m27584a((Function1) DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.f38790a);
    public static final DescriptorRenderer f26009b = Companion.m27584a((Function1) DescriptorRenderer$Companion$COMPACT$1.f38789a);
    public static final DescriptorRenderer f26010c = Companion.m27584a((Function1) DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.f38791a);
    public static final DescriptorRenderer f26011d = Companion.m27584a((Function1) DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.f38795a);
    public static final DescriptorRenderer f26012e = Companion.m27584a((Function1) DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.f38793a);
    public static final DescriptorRenderer f26013f = Companion.m27584a((Function1) DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.f38796a);
    public static final DescriptorRenderer f26014g = Companion.m27584a((Function1) DescriptorRenderer$Companion$DEBUG_TEXT$1.f38792a);
    public static final DescriptorRenderer f26015h = Companion.m27584a((Function1) DescriptorRenderer$Companion$HTML$1.f38794a);
    public static final Companion f26016i = new Companion();

    /* compiled from: DescriptorRenderer.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] f26007a;

            static {
                int[] iArr = new int[ClassKind.values().length];
                f26007a = iArr;
                iArr[ClassKind.CLASS.ordinal()] = 1;
                f26007a[ClassKind.INTERFACE.ordinal()] = 2;
                f26007a[ClassKind.ENUM_CLASS.ordinal()] = 3;
                f26007a[ClassKind.OBJECT.ordinal()] = 4;
                f26007a[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                f26007a[ClassKind.ENUM_ENTRY.ordinal()] = 6;
            }
        }

        private Companion() {
        }

        public static DescriptorRenderer m27584a(Function1<? super DescriptorRendererOptions, Unit> function1) {
            Intrinsics.m26847b(function1, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            function1.mo6492a(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.m33459d();
            return (DescriptorRenderer) new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }

        public static String m27583a(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
            Intrinsics.m26847b(classifierDescriptorWithTypeParameters, "classifier");
            if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptorWithTypeParameters;
                if (classDescriptor.mo7772k()) {
                    return "companion object";
                }
                switch (WhenMappings.f26007a[classDescriptor.mo7771g().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Unexpected classifier: ");
            stringBuilder.append(classifierDescriptorWithTypeParameters);
            throw new AssertionError(stringBuilder.toString());
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    public interface ValueParametersHandler {

        /* compiled from: DescriptorRenderer.kt */
        public static final class DEFAULT implements ValueParametersHandler {
            public static final DEFAULT f32886a = null;

            public final void mo5887a(ValueParameterDescriptor valueParameterDescriptor, StringBuilder stringBuilder) {
                Intrinsics.m26847b(valueParameterDescriptor, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                Intrinsics.m26847b(stringBuilder, "builder");
            }

            static {
                DEFAULT defaultR = new DEFAULT();
            }

            private DEFAULT() {
                f32886a = this;
            }

            public final void mo5885a(StringBuilder stringBuilder) {
                Intrinsics.m26847b(stringBuilder, "builder");
                stringBuilder.append("(");
            }

            public final void mo5888b(StringBuilder stringBuilder) {
                Intrinsics.m26847b(stringBuilder, "builder");
                stringBuilder.append(")");
            }

            public final void mo5886a(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder stringBuilder) {
                Intrinsics.m26847b(valueParameterDescriptor, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                Intrinsics.m26847b(stringBuilder, "builder");
                if (i != i2 - 1) {
                    stringBuilder.append(", ");
                }
            }
        }

        void mo5885a(StringBuilder stringBuilder);

        void mo5886a(ValueParameterDescriptor valueParameterDescriptor, int i, int i2, StringBuilder stringBuilder);

        void mo5887a(ValueParameterDescriptor valueParameterDescriptor, StringBuilder stringBuilder);

        void mo5888b(StringBuilder stringBuilder);
    }

    public abstract String mo5889a(String str, String str2, KotlinBuiltIns kotlinBuiltIns);

    public abstract String mo5890a(DeclarationDescriptor declarationDescriptor);

    public abstract String mo5891a(AnnotationDescriptor annotationDescriptor, AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract String mo5892a(FqNameUnsafe fqNameUnsafe);

    public abstract String mo5893a(Name name);

    public abstract String mo5894a(KotlinType kotlinType);

    public abstract String mo5895a(TypeProjection typeProjection);

    public final DescriptorRenderer m27597a(Function1<? super DescriptorRendererOptions, Unit> function1) {
        Intrinsics.m26847b(function1, "changeOptions");
        if (this == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        }
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = ((DescriptorRendererImpl) this).f32889j;
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = new DescriptorRendererOptionsImpl();
        Field[] declaredFields = descriptorRendererOptionsImpl.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(descriptorRendererOptionsImpl);
                if (!(obj instanceof ObservableProperty)) {
                    obj = null;
                }
                ObservableProperty observableProperty = (ObservableProperty) obj;
                if (observableProperty != null) {
                    int a = 1 ^ StringsKt__StringsJVMKt.m41944a(field.getName(), "is");
                    if (_Assertions.f25274a && a == 0) {
                        throw new AssertionError("Fields named is* are not supported here yet");
                    }
                    KDeclarationContainer a2 = Reflection.m26850a(DescriptorRendererOptionsImpl.class);
                    String name = field.getName();
                    StringBuilder stringBuilder = new StringBuilder("get");
                    stringBuilder.append(StringsKt__StringsJVMKt.m41940a(field.getName()));
                    Object value = observableProperty.getValue(descriptorRendererOptionsImpl, new PropertyReference1Impl(a2, name, stringBuilder.toString()));
                    if (value == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Any");
                    }
                    field.set(descriptorRendererOptionsImpl2, descriptorRendererOptionsImpl2.m33446a(value));
                }
            }
        }
        function1.mo6492a(descriptorRendererOptionsImpl2);
        descriptorRendererOptionsImpl2.m33459d();
        return (DescriptorRenderer) new DescriptorRendererImpl(descriptorRendererOptionsImpl2);
    }
}
