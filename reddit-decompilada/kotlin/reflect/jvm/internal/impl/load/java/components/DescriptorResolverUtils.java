package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

public final class DescriptorResolverUtils {
    public static <D extends CallableMemberDescriptor> Collection<D> m27176a(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"}));
        } else if (collection2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"}));
        } else if (errorReporter != null) {
            return m27177a(name, collection, collection2, classDescriptor, errorReporter, false);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"errorReporter", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForNonStaticMembers"}));
        }
    }

    public static <D extends CallableMemberDescriptor> Collection<D> m27180b(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, ErrorReporter errorReporter) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"}));
        } else if (collection2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"}));
        } else if (errorReporter != null) {
            return m27177a(name, collection, collection2, classDescriptor, errorReporter, true);
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"errorReporter", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverridesForStaticMembers"}));
        }
    }

    private static <D extends CallableMemberDescriptor> Collection<D> m27177a(Name name, Collection<D> collection, Collection<D> collection2, ClassDescriptor classDescriptor, final ErrorReporter errorReporter, final boolean z) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"}));
        } else if (collection == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromSupertypes", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"}));
        } else if (collection2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"membersFromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"}));
        } else if (errorReporter == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"errorReporter", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "resolveOverrides"}));
        } else {
            final Collection linkedHashSet = new LinkedHashSet();
            OverridingUtil.m27695a(name, collection, collection2, classDescriptor, new NonReportingOverrideStrategy() {

                class C27561 implements Function1<CallableMemberDescriptor, Unit> {
                    final /* synthetic */ C27571 f36080a;

                    C27561(C27571 c27571) {
                        this.f36080a = c27571;
                    }

                    public final /* synthetic */ Object mo6492a(Object obj) {
                        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
                        if (callableMemberDescriptor == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"}));
                        }
                        errorReporter.mo5771a(callableMemberDescriptor);
                        return Unit.f25273a;
                    }
                }

                public final void mo6691a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                    if (callableMemberDescriptor == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromSuper", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "conflict"}));
                    } else if (callableMemberDescriptor2 == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fromCurrent", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "conflict"}));
                    }
                }

                public final void mo6690a(CallableMemberDescriptor callableMemberDescriptor) {
                    if (callableMemberDescriptor == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"fakeOverride", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "addFakeOverride"}));
                    }
                    OverridingUtil.m27693a(callableMemberDescriptor, new C27561(this));
                    linkedHashSet.add(callableMemberDescriptor);
                }

                public final void mo6692a(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
                    if (callableMemberDescriptor == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"member", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "setOverriddenDescriptors"}));
                    } else if (collection == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"overridden", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1", "setOverriddenDescriptors"}));
                    } else if (!z || callableMemberDescriptor.mo7760t() == Kind.FAKE_OVERRIDE) {
                        super.mo6692a(callableMemberDescriptor, collection);
                    }
                }
            });
            return linkedHashSet;
        }
    }

    public static ValueParameterDescriptor m27178a(Name name, ClassDescriptor classDescriptor) {
        if (name == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"name", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "getAnnotationParameterByName"}));
        } else if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"annotationClass", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "getAnnotationParameterByName"}));
        } else {
            classDescriptor = classDescriptor.mo7770f();
            if (classDescriptor.size() != 1) {
                return null;
            }
            for (ValueParameterDescriptor valueParameterDescriptor : ((ClassConstructorDescriptor) classDescriptor.iterator().next()).mo7757k()) {
                if (valueParameterDescriptor.mo6689i().equals(name)) {
                    return valueParameterDescriptor;
                }
            }
            return null;
        }
    }

    public static boolean m27179a(JavaMember javaMember) {
        if (javaMember == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"member", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "isObjectMethodInInterface"}));
        }
        if (javaMember.mo7098d().mo7278f() && (javaMember instanceof JavaMethod)) {
            JavaMethod javaMethod = (JavaMethod) javaMember;
            if (javaMethod == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"method", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "isObjectMethod"}));
            }
            String a = javaMethod.mo7103p().m27429a();
            if (!a.equals("toString")) {
                if (!a.equals("hashCode")) {
                    if (a.equals("equals")) {
                        a = "java.lang.Object";
                        if (javaMethod == null) {
                            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"method", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils", "isMethodWithOneParameterWithFqName"}));
                        }
                        javaMember = javaMethod.mo7290b();
                        if (javaMember.size() == 1) {
                            javaMember = ((JavaValueParameter) javaMember.get(0)).mo7107c();
                            if (javaMember instanceof JavaClassifierType) {
                                javaMember = ((JavaClassifierType) javaMember).mo7093b();
                                if (javaMember instanceof JavaClass) {
                                    javaMember = ((JavaClass) javaMember).mo7274b();
                                    if (!(javaMember == null || javaMember.m27407a().equals(a) == null)) {
                                        javaMember = 1;
                                        if (javaMember == null) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    javaMember = null;
                    return javaMember == null;
                }
            }
            javaMember = javaMethod.mo7290b().isEmpty();
            if (javaMember == null) {
            }
        }
    }
}
