package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: RawType.kt */
public final class RawTypeImpl extends FlexibleType implements RawType {
    public RawTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(simpleType, "lowerBound");
        Intrinsics.m26847b(simpleType2, "upperBound");
        super(simpleType, simpleType2);
        boolean a = KotlinTypeChecker.f26349a.mo5935a(simpleType, simpleType2);
        if (_Assertions.f25274a && !a) {
            StringBuilder stringBuilder = new StringBuilder("Lower bound ");
            stringBuilder.append(simpleType);
            stringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
            stringBuilder.append(simpleType2);
            throw ((Throwable) new AssertionError(stringBuilder.toString()));
        }
    }

    public final /* synthetic */ UnwrappedType mo7271a(Annotations annotations) {
        Intrinsics.m26847b(annotations, "newAnnotations");
        return new RawTypeImpl(this.f38926a.mo7296b(annotations), this.f38927b.mo7296b(annotations));
    }

    public final MemberScope mo6740b() {
        ClassifierDescriptor c = mo6743g().mo5724c();
        if (!(c instanceof ClassDescriptor)) {
            c = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor) c;
        if (classDescriptor == null) {
            StringBuilder stringBuilder = new StringBuilder("Incorrect classifier: ");
            stringBuilder.append(mo6743g().mo5724c());
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        Object a = classDescriptor.mo7738a((TypeSubstitution) RawSubstitution.f32752a);
        Intrinsics.m26843a(a, "classDescriptor.getMemberScope(RawSubstitution)");
        return a;
    }

    public final String mo7270a(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.m26847b(descriptorRenderer, "renderer");
        Intrinsics.m26847b(descriptorRendererOptions, "options");
        RawTypeImpl$render$1 rawTypeImpl$render$1 = RawTypeImpl$render$1.f38450a;
        RawTypeImpl$render$2 rawTypeImpl$render$2 = new RawTypeImpl$render$2(descriptorRenderer);
        RawTypeImpl$render$3 rawTypeImpl$render$3 = RawTypeImpl$render$3.f38452a;
        String a = descriptorRenderer.mo5894a((KotlinType) this.f38926a);
        Object a2 = descriptorRenderer.mo5894a((KotlinType) this.f38927b);
        if (descriptorRendererOptions.mo5905b() != null) {
            descriptorRenderer = new StringBuilder("raw (");
            descriptorRenderer.append(a);
            descriptorRenderer.append("..");
            descriptorRenderer.append(a2);
            descriptorRenderer.append(")");
            return descriptorRenderer.toString();
        } else if (this.f38927b.mo6739a().isEmpty() != null) {
            return descriptorRenderer.mo5889a(a, a2, TypeUtilsKt.m28060a((KotlinType) this));
        } else {
            rawTypeImpl$render$2 = rawTypeImpl$render$2;
            descriptorRendererOptions = rawTypeImpl$render$2.m38417a((KotlinType) this.f38926a);
            List a3 = rawTypeImpl$render$2.m38417a((KotlinType) this.f38927b);
            Iterable<String> iterable = (Iterable) descriptorRendererOptions;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (String str : iterable) {
                StringBuilder stringBuilder = new StringBuilder("(raw) ");
                stringBuilder.append(str);
                arrayList.add(stringBuilder.toString());
            }
            String a4 = CollectionsKt___CollectionsKt.m41412a((Iterable) (List) arrayList, (CharSequence) ", ", null, null, 0, null, null, 62);
            for (Pair pair : CollectionsKt___CollectionsKt.m41417a((Iterable) iterable, (Iterable) a3)) {
                RawTypeImpl$render$1 rawTypeImpl$render$12 = RawTypeImpl$render$1.f38450a;
                if (!RawTypeImpl$render$1.m38414a((String) pair.f25267a, (String) pair.f25268b)) {
                    descriptorRendererOptions = null;
                    break;
                }
            }
            descriptorRendererOptions = true;
            if (descriptorRendererOptions != null) {
                a2 = RawTypeImpl$render$3.m38418a((String) a2, a4);
            }
            Object a5 = RawTypeImpl$render$3.m38418a(a, a4);
            if (Intrinsics.m26845a(a5, a2)) {
                return a5;
            }
            return descriptorRenderer.mo5889a(a5, a2, TypeUtilsKt.m28060a((KotlinType) this));
        }
    }

    public final SimpleType aP_() {
        return this.f38926a;
    }

    public final /* synthetic */ UnwrappedType mo7272a(boolean z) {
        return new RawTypeImpl(this.f38926a.mo7297b(z), this.f38927b.mo7297b(z));
    }
}
