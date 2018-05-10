package kotlin.reflect.jvm.internal;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u0019*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlin/reflect/jvm/internal/ReflectionObjectRenderer;", "", "()V", "renderer", "Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;", "renderCallable", "", "descriptor", "Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "renderFunction", "Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "renderLambda", "invoke", "renderParameter", "parameter", "Lkotlin/reflect/jvm/internal/KParameterImpl;", "renderProperty", "Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "renderType", "type", "Lorg/jetbrains/kotlin/types/KotlinType;", "renderTypeParameter", "typeParameter", "Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "appendReceiverType", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "receiver", "Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "appendReceivers", "callable", "kotlin-reflection"}, k = 1, mv = {1, 1, 5})
/* compiled from: ReflectionObjectRenderer.kt */
public final class ReflectionObjectRenderer {
    public static final ReflectionObjectRenderer f25341a = null;
    private static final DescriptorRenderer f25342b = null;

    @Metadata(bv = {1, 0, 1}, k = 3, mv = {1, 1, 5})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25339a;
        public static final /* synthetic */ int[] f25340b;

        static {
            int[] iArr = new int[Kind.values().length];
            f25339a = iArr;
            iArr[Kind.f25298b.ordinal()] = 1;
            f25339a[Kind.f25297a.ordinal()] = 2;
            f25339a[Kind.f25299c.ordinal()] = 3;
            iArr = new int[Variance.values().length];
            f25340b = iArr;
            iArr[Variance.f26337a.ordinal()] = 1;
            f25340b[Variance.f26338b.ordinal()] = 2;
            f25340b[Variance.f26339c.ordinal()] = 3;
        }
    }

    static {
        ReflectionObjectRenderer reflectionObjectRenderer = new ReflectionObjectRenderer();
    }

    private ReflectionObjectRenderer() {
        f25341a = this;
        f25342b = DescriptorRenderer.f26012e;
    }

    private static void m26926a(StringBuilder stringBuilder, ReceiverParameterDescriptor receiverParameterDescriptor) {
        if (receiverParameterDescriptor != null) {
            KotlinType x = receiverParameterDescriptor.mo7777x();
            Intrinsics.m26843a((Object) x, "receiver.type");
            stringBuilder.append(m26924a(x));
            stringBuilder.append(".");
        }
    }

    private static void m26925a(StringBuilder stringBuilder, CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor e = callableDescriptor.mo7756e();
        ReceiverParameterDescriptor d = callableDescriptor.mo7755d();
        m26926a(stringBuilder, e);
        Object obj = (e == null || d == null) ? null : 1;
        if (obj != null) {
            stringBuilder.append("(");
        }
        m26926a(stringBuilder, d);
        if (obj != null) {
            stringBuilder.append(")");
        }
    }

    public static String m26922a(PropertyDescriptor propertyDescriptor) {
        Intrinsics.m26847b(propertyDescriptor, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(propertyDescriptor.mo7807y() ? "var " : "val ");
        m26925a(stringBuilder, (CallableDescriptor) propertyDescriptor);
        DescriptorRenderer descriptorRenderer = f25342b;
        Name i = propertyDescriptor.mo6689i();
        Intrinsics.m26843a((Object) i, "descriptor.name");
        stringBuilder.append(descriptorRenderer.mo5893a(i));
        stringBuilder.append(": ");
        KotlinType x = propertyDescriptor.mo7777x();
        Intrinsics.m26843a((Object) x, "descriptor.type");
        stringBuilder.append(m26924a(x));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public static String m26921a(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "descriptor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fun ");
        m26925a(stringBuilder, (CallableDescriptor) functionDescriptor);
        DescriptorRenderer descriptorRenderer = f25342b;
        Name i = functionDescriptor.mo6689i();
        Intrinsics.m26843a((Object) i, "descriptor.name");
        stringBuilder.append(descriptorRenderer.mo5893a(i));
        CollectionsKt___CollectionsKt.m41410a(functionDescriptor.mo7757k(), stringBuilder, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderFunction$1$1.f38311a, 48);
        stringBuilder.append(": ");
        KotlinType aN_ = functionDescriptor.aN_();
        if (aN_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a((Object) aN_, "descriptor.returnType!!");
        stringBuilder.append(m26924a(aN_));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public static String m26927b(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "invoke");
        StringBuilder stringBuilder = new StringBuilder();
        m26925a(stringBuilder, (CallableDescriptor) functionDescriptor);
        CollectionsKt___CollectionsKt.m41410a(functionDescriptor.mo7757k(), stringBuilder, ", ", "(", ")", 0, null, ReflectionObjectRenderer$renderLambda$1$1.f38312a, 48);
        stringBuilder.append(" -> ");
        KotlinType aN_ = functionDescriptor.aN_();
        if (aN_ == null) {
            Intrinsics.m26842a();
        }
        Intrinsics.m26843a((Object) aN_, "invoke.returnType!!");
        stringBuilder.append(m26924a(aN_));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public static String m26920a(KParameterImpl kParameterImpl) {
        Intrinsics.m26847b(kParameterImpl, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
        StringBuilder stringBuilder = new StringBuilder();
        switch (WhenMappings.f25339a[kParameterImpl.f32599c.ordinal()]) {
            case 1:
                stringBuilder.append("extension receiver");
                break;
            case 2:
                stringBuilder.append("instance");
                break;
            case 3:
                StringBuilder stringBuilder2 = new StringBuilder("parameter #");
                stringBuilder2.append(kParameterImpl.f32598b);
                stringBuilder2.append(" ");
                stringBuilder2.append(kParameterImpl.mo5692a());
                stringBuilder.append(stringBuilder2.toString());
                break;
            default:
                break;
        }
        stringBuilder.append(" of ");
        CallableDescriptor a = kParameterImpl.f32597a.mo6676a();
        Intrinsics.m26847b(a, "descriptor");
        if (a instanceof PropertyDescriptor) {
            kParameterImpl = m26922a((PropertyDescriptor) a);
        } else if (a instanceof FunctionDescriptor) {
            kParameterImpl = m26921a((FunctionDescriptor) a);
        } else {
            stringBuilder = new StringBuilder("Illegal callable: ");
            stringBuilder.append(a);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        stringBuilder.append(kParameterImpl);
        Object stringBuilder3 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder3, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder3;
    }

    public static String m26923a(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.m26847b(typeParameterDescriptor, "typeParameter");
        StringBuilder stringBuilder = new StringBuilder();
        switch (WhenMappings.f25340b[typeParameterDescriptor.mo7716k().ordinal()]) {
            case 1:
                break;
            case 2:
                stringBuilder.append("in ");
                break;
            case 3:
                stringBuilder.append("out ");
                break;
            default:
                break;
        }
        stringBuilder.append(typeParameterDescriptor.mo6689i());
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "StringBuilder().apply(builderAction).toString()");
        return stringBuilder2;
    }

    public static String m26924a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "type");
        return f25342b.mo5894a(kotlinType);
    }
}
