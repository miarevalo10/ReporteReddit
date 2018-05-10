package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class MemberComparator implements Comparator<DeclarationDescriptor> {
    public static final MemberComparator f26069a = new MemberComparator();
    static final /* synthetic */ boolean f26070b = true;
    private static final DescriptorRenderer f26071c = Companion.m27584a(new C27631());

    static class C27631 implements Function1<DescriptorRendererOptions, Unit> {
        C27631() {
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            DescriptorRendererOptions descriptorRendererOptions = (DescriptorRendererOptions) obj;
            descriptorRendererOptions.mo5910f(false);
            descriptorRendererOptions.mo5909e(true);
            descriptorRendererOptions.mo5898a(AnnotationArgumentsRenderingPolicy.f26002b);
            descriptorRendererOptions.mo5903b(DescriptorRendererModifier.f26032k);
            return Unit.f25273a;
        }
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
        DeclarationDescriptor declarationDescriptor2 = (DeclarationDescriptor) obj2;
        int a = m27670a(declarationDescriptor2) - m27670a(declarationDescriptor);
        if (a != 0) {
            return a;
        }
        if (DescriptorUtils.m27659i(declarationDescriptor) && DescriptorUtils.m27659i(declarationDescriptor2)) {
            return 0;
        }
        a = declarationDescriptor.mo6689i().m27428a(declarationDescriptor2.mo6689i());
        if (a != 0) {
            return a;
        }
        if ((declarationDescriptor instanceof TypeAliasDescriptor) && (declarationDescriptor2 instanceof TypeAliasDescriptor)) {
            a = f26071c.mo5894a(((TypeAliasDescriptor) declarationDescriptor).mo7809b()).compareTo(f26071c.mo5894a(((TypeAliasDescriptor) declarationDescriptor2).mo7809b()));
            if (a != 0) {
                return a;
            }
        }
        int i = 1;
        if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            int i2;
            int i3;
            CallableDescriptor callableDescriptor = (CallableDescriptor) declarationDescriptor;
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) declarationDescriptor2;
            ReceiverParameterDescriptor d = callableDescriptor.mo7755d();
            ReceiverParameterDescriptor d2 = callableDescriptor2.mo7755d();
            if (!f26070b) {
                i2 = d != null ? 1 : 0;
                if (d2 == null) {
                    i = 0;
                }
                if (i2 != i) {
                    throw new AssertionError();
                }
            }
            if (d != null) {
                i = f26071c.mo5894a(d.mo7777x()).compareTo(f26071c.mo5894a(d2.mo7777x()));
                if (i != 0) {
                    return i;
                }
            }
            List k = callableDescriptor.mo7757k();
            List k2 = callableDescriptor2.mo7757k();
            for (i3 = 0; i3 < Math.min(k.size(), k2.size()); i3++) {
                i2 = f26071c.mo5894a(((ValueParameterDescriptor) k.get(i3)).mo7777x()).compareTo(f26071c.mo5894a(((ValueParameterDescriptor) k2.get(i3)).mo7777x()));
                if (i2 != 0) {
                    return i2;
                }
            }
            i = k.size() - k2.size();
            if (i != 0) {
                return i;
            }
            k = callableDescriptor.mo7735f();
            k2 = callableDescriptor2.mo7735f();
            for (i3 = 0; i3 < Math.min(k.size(), k2.size()); i3++) {
                List j = ((TypeParameterDescriptor) k.get(i3)).mo7715j();
                List j2 = ((TypeParameterDescriptor) k2.get(i3)).mo7715j();
                int size = j.size() - j2.size();
                if (size != 0) {
                    return size;
                }
                for (size = 0; size < j.size(); size++) {
                    int compareTo = f26071c.mo5894a((KotlinType) j.get(size)).compareTo(f26071c.mo5894a((KotlinType) j2.get(size)));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                }
            }
            int size2 = k.size() - k2.size();
            if (size2 != 0) {
                return size2;
            }
            if ((callableDescriptor instanceof CallableMemberDescriptor) && (callableDescriptor2 instanceof CallableMemberDescriptor)) {
                a = ((CallableMemberDescriptor) callableDescriptor).mo7760t().ordinal() - ((CallableMemberDescriptor) callableDescriptor2).mo7760t().ordinal();
                if (a != 0) {
                    return a;
                }
            }
        } else if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor2;
            if (classDescriptor.mo7771g().ordinal() != classDescriptor2.mo7771g().ordinal()) {
                return classDescriptor.mo7771g().ordinal() - classDescriptor2.mo7771g().ordinal();
            }
            if (classDescriptor.mo7772k() != classDescriptor2.mo7772k()) {
                if (classDescriptor.mo7772k() != null) {
                    return 1;
                }
                return -1;
            }
        } else {
            throw new AssertionError(String.format("Unsupported pair of descriptors:\n'%s' Class: %s\n%s' Class: %s", new Object[]{declarationDescriptor, declarationDescriptor.getClass(), declarationDescriptor2, declarationDescriptor2.getClass()}));
        }
        a = f26071c.mo5890a(declarationDescriptor).compareTo(f26071c.mo5890a(declarationDescriptor2));
        if (a != 0) {
            return a;
        }
        return DescriptorUtils.m27656f(declarationDescriptor).mo6689i().m27428a(DescriptorUtils.m27656f(declarationDescriptor2).mo6689i());
    }

    static {
        Companion companion = DescriptorRenderer.f26016i;
    }

    private MemberComparator() {
    }

    private static int m27670a(DeclarationDescriptor declarationDescriptor) {
        if (DescriptorUtils.m27659i(declarationDescriptor)) {
            return 8;
        }
        if (declarationDescriptor instanceof ConstructorDescriptor) {
            return 7;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return ((PropertyDescriptor) declarationDescriptor).mo7755d() == null ? 6 : 5;
        } else {
            if (declarationDescriptor instanceof FunctionDescriptor) {
                return ((FunctionDescriptor) declarationDescriptor).mo7755d() == null ? 4 : 3;
            } else {
                if (declarationDescriptor instanceof ClassDescriptor) {
                    return 2;
                }
                return (declarationDescriptor instanceof TypeAliasDescriptor) != null ? 1 : null;
            }
        }
    }
}
