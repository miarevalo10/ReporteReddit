package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;

public class DescriptorUtils {
    public static final Name f26052a = Name.m27424a("values");
    public static final Name f26053b = Name.m27424a("valueOf");
    public static final FqName f26054c = new FqName("kotlin.jvm.JvmName");
    public static final FqName f26055d;
    public static final FqName f26056e;
    static final /* synthetic */ boolean f26057f = true;
    private static final FqName f26058g = new FqName("kotlin.jvm.Volatile");
    private static final FqName f26059h = new FqName("kotlin.jvm.Synchronized");

    static {
        FqName fqName = new FqName("kotlin.coroutines.experimental");
        f26055d = fqName;
        f26056e = fqName.m27408a(Name.m27424a("Continuation"));
    }

    private DescriptorUtils() {
    }

    public static ReceiverParameterDescriptor m27641a(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return declarationDescriptor instanceof ClassDescriptor ? ((ClassDescriptor) declarationDescriptor).mo7740u() : null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"containingDeclaration", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDispatchReceiverParameterIfNeeded"}));
        }
    }

    public static boolean m27651b(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isLocal"}));
        }
        while (declarationDescriptor != null) {
            if (!m27667q(declarationDescriptor)) {
                boolean z = (declarationDescriptor instanceof DeclarationDescriptorWithVisibility) && ((DeclarationDescriptorWithVisibility) declarationDescriptor).mo7257j() == Visibilities.f25509f;
                if (!z) {
                    declarationDescriptor = declarationDescriptor.aD_();
                }
            }
            return true;
        }
        return false;
    }

    public static FqNameUnsafe m27653c(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqName"}));
        }
        FqName n = m27664n(declarationDescriptor);
        declarationDescriptor = n != null ? n.m27409b() : m27665o(declarationDescriptor);
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqName"}));
    }

    public static FqName m27654d(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameSafe"}));
        }
        FqName n = m27664n(declarationDescriptor);
        if (n == null) {
            n = m27665o(declarationDescriptor).m27420d();
        }
        if (n != null) {
            return n;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameSafe"}));
    }

    private static FqName m27664n(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameSafeIfPossible"}));
        }
        if (!(declarationDescriptor instanceof ModuleDescriptor)) {
            if (!ErrorUtils.m27938a(declarationDescriptor)) {
                if (declarationDescriptor instanceof PackageViewDescriptor) {
                    return ((PackageViewDescriptor) declarationDescriptor).mo7080b();
                }
                return declarationDescriptor instanceof PackageFragmentDescriptor ? ((PackageFragmentDescriptor) declarationDescriptor).mo7722d() : null;
            }
        }
        return FqName.f25855a;
    }

    private static FqNameUnsafe m27665o(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getFqNameUnsafe"}));
        }
        DeclarationDescriptor aD_ = declarationDescriptor.aD_();
        if (f26057f || aD_ != null) {
            return m27653c(aD_).m27416a(declarationDescriptor.mo6689i());
        }
        StringBuilder stringBuilder = new StringBuilder("Not package/module descriptor doesn't have containing declaration: ");
        stringBuilder.append(declarationDescriptor);
        throw new AssertionError(stringBuilder.toString());
    }

    public static boolean m27655e(DeclarationDescriptor declarationDescriptor) {
        return (declarationDescriptor == null || (declarationDescriptor.aD_() instanceof PackageFragmentDescriptor) == null) ? null : true;
    }

    public static boolean m27645a(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"first", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "areInSameModule"}));
        } else if (declarationDescriptor2 != null) {
            return m27656f(declarationDescriptor).equals(m27656f(declarationDescriptor2));
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"second", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "areInSameModule"}));
        }
    }

    public static <D extends DeclarationDescriptor> D m27638a(DeclarationDescriptor declarationDescriptor, Class<D> cls) {
        return m27639a(declarationDescriptor, cls, true);
    }

    public static <D extends DeclarationDescriptor> D m27639a(DeclarationDescriptor declarationDescriptor, Class<D> cls, boolean z) {
        if (cls == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"aClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getParentOfType"}));
        } else if (declarationDescriptor == null) {
            return null;
        } else {
            if (z) {
                declarationDescriptor = declarationDescriptor.aD_();
            }
            while (declarationDescriptor != null) {
                if (cls.isInstance(declarationDescriptor)) {
                    return declarationDescriptor;
                }
                declarationDescriptor = declarationDescriptor.aD_();
            }
            return null;
        }
    }

    public static ModuleDescriptor m27656f(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingModule"}));
        }
        ModuleDescriptor p = m27666p(declarationDescriptor);
        if (!f26057f && p == null) {
            StringBuilder stringBuilder = new StringBuilder("Descriptor without a containing module: ");
            stringBuilder.append(declarationDescriptor);
            throw new AssertionError(stringBuilder.toString());
        } else if (p != null) {
            return p;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingModule"}));
        }
    }

    private static ModuleDescriptor m27666p(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingModuleOrNull"}));
        }
        while (declarationDescriptor != null) {
            if (declarationDescriptor instanceof ModuleDescriptor) {
                return (ModuleDescriptor) declarationDescriptor;
            }
            if (declarationDescriptor instanceof PackageViewDescriptor) {
                return ((PackageViewDescriptor) declarationDescriptor).mo7082d();
            }
            declarationDescriptor = declarationDescriptor.aD_();
        }
        return null;
    }

    public static boolean m27643a(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isDirectSubclass"}));
        } else if (classDescriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isDirectSubclass"}));
        } else {
            for (KotlinType b : classDescriptor.mo7610c().aL_()) {
                if (m27652b(b, classDescriptor2.mo7741v())) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean m27650b(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"subClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubclass"}));
        } else if (classDescriptor2 != null) {
            return m27647a(classDescriptor.mo7714h(), classDescriptor2.mo7741v());
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubclass"}));
        }
    }

    private static boolean m27652b(KotlinType kotlinType, DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSameClass"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"other", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSameClass"}));
        } else {
            kotlinType = kotlinType.mo6743g().mo5724c();
            if (kotlinType != null) {
                kotlinType = kotlinType.aJ_();
                return (kotlinType instanceof ClassifierDescriptor) && (declarationDescriptor instanceof ClassifierDescriptor) && ((ClassifierDescriptor) declarationDescriptor).mo7610c().equals(((ClassifierDescriptor) kotlinType).mo7610c()) != null;
            }
        }
    }

    public static boolean m27647a(KotlinType kotlinType, DeclarationDescriptor declarationDescriptor) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubtypeOfClass"}));
        } else if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"superClass", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isSubtypeOfClass"}));
        } else if (m27652b(kotlinType, declarationDescriptor)) {
            return true;
        } else {
            for (KotlinType a : kotlinType.mo6743g().aL_()) {
                if (m27647a(a, declarationDescriptor)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean m27657g(DeclarationDescriptor declarationDescriptor) {
        return (!m27644a(declarationDescriptor, ClassKind.OBJECT) || ((ClassDescriptor) declarationDescriptor).mo7772k() == null) ? null : true;
    }

    public static boolean m27658h(DeclarationDescriptor declarationDescriptor) {
        return (m27644a(declarationDescriptor, ClassKind.CLASS) && ((ClassDescriptor) declarationDescriptor).aG_() == Modality.f25489b) ? true : null;
    }

    public static boolean m27659i(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return m27644a(declarationDescriptor, ClassKind.ENUM_ENTRY);
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isEnumEntry"}));
    }

    public static boolean m27660j(DeclarationDescriptor declarationDescriptor) {
        return m27644a(declarationDescriptor, ClassKind.ANNOTATION_CLASS);
    }

    public static boolean m27661k(DeclarationDescriptor declarationDescriptor) {
        return m27644a(declarationDescriptor, ClassKind.INTERFACE);
    }

    private static boolean m27644a(DeclarationDescriptor declarationDescriptor, ClassKind classKind) {
        if (classKind != null) {
            return (declarationDescriptor instanceof ClassDescriptor) && ((ClassDescriptor) declarationDescriptor).mo7771g() == classKind;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classKind", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isKindOf"}));
        }
    }

    public static ClassDescriptor m27637a(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getSuperClassDescriptor"}));
        }
        for (KotlinType kotlinType : classDescriptor.mo7610c().aL_()) {
            if (kotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForType"}));
            }
            TypeConstructor g = kotlinType.mo6743g();
            if (g == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"typeConstructor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForTypeConstructor"}));
            }
            ClassifierDescriptor c = g.mo5724c();
            if (f26057f || (c instanceof ClassDescriptor)) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) c;
                if (classDescriptor2 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForTypeConstructor"}));
                } else if (classDescriptor2 == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getClassDescriptorForType"}));
                } else if (classDescriptor2.mo7771g() != ClassKind.INTERFACE) {
                    return classDescriptor2;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Classifier descriptor of a type should be of type ClassDescriptor: ");
            stringBuilder.append(g);
            throw new AssertionError(stringBuilder.toString());
        }
        return null;
    }

    public static Visibility m27649b(ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"classDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"}));
        }
        ClassKind g = classDescriptor.mo7771g();
        if (!(g == ClassKind.ENUM_CLASS || g.m27042a())) {
            if (!m27658h(classDescriptor)) {
                if (m27667q(classDescriptor) != null) {
                    classDescriptor = Visibilities.f25514k;
                    if (classDescriptor != null) {
                        return classDescriptor;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"}));
                } else if (f26057f != null || g == ClassKind.CLASS || g == ClassKind.INTERFACE || g == ClassKind.ANNOTATION_CLASS) {
                    classDescriptor = Visibilities.f25508e;
                    if (classDescriptor != null) {
                        return classDescriptor;
                    }
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"}));
                } else {
                    throw new AssertionError();
                }
            }
        }
        classDescriptor = Visibilities.f25504a;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDefaultConstructorVisibility"}));
    }

    public static <D extends CallableMemberDescriptor> D m27636a(D d) {
        if (d == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverride"}));
        }
        while (d.mo7760t() == Kind.FAKE_OVERRIDE) {
            Collection m = d.mo7609m();
            if (m.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder("Fake override should have at least one overridden descriptor: ");
                stringBuilder.append(d);
                throw new IllegalStateException(stringBuilder.toString());
            }
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) m.iterator().next();
        }
        if (d != null) {
            return d;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverride"}));
    }

    public static <D extends DeclarationDescriptorWithVisibility> D m27640a(D d) {
        if (d == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverrideToAnyDeclaration"}));
        } else if (d instanceof CallableMemberDescriptor) {
            d = m27636a((CallableMemberDescriptor) d);
            if (d != null) {
                return d;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverrideToAnyDeclaration"}));
        } else if (d != null) {
            return d;
        } else {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "unwrapFakeOverrideToAnyDeclaration"}));
        }
    }

    public static boolean m27646a(VariableDescriptor variableDescriptor, KotlinType kotlinType) {
        if (variableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"variable", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "shouldRecordInitializerForProperty"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "shouldRecordInitializerForProperty"}));
        } else {
            if (!variableDescriptor.mo7807y()) {
                if (!kotlinType.mo6742d()) {
                    if (TypeUtils.m28016e(kotlinType)) {
                        return true;
                    }
                    variableDescriptor = DescriptorUtilsKt.m27745d(variableDescriptor);
                    if (!(KotlinBuiltIns.m26988d(kotlinType) || KotlinTypeChecker.f26349a.mo5936b(variableDescriptor.m27027y(), kotlinType))) {
                        KotlinTypeChecker kotlinTypeChecker = KotlinTypeChecker.f26349a;
                        ClassDescriptor a = variableDescriptor.m26997a("Number");
                        if (a == null) {
                            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNumber"}));
                        } else if (!kotlinTypeChecker.mo5936b(a.mo7714h(), kotlinType)) {
                            if (KotlinTypeChecker.f26349a.mo5936b(variableDescriptor.m27015m(), kotlinType) == null) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static <D extends CallableDescriptor> Set<D> m27635a(D d) {
        if (d == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"f", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getAllOverriddenDescriptors"}));
        }
        Set linkedHashSet = new LinkedHashSet();
        m27642a(d.aM_(), linkedHashSet);
        return linkedHashSet;
    }

    private static <D extends CallableDescriptor> void m27642a(D d, Set<D> set) {
        if (d == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"current", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "collectAllOverriddenDescriptors"}));
        } else if (set == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "collectAllOverriddenDescriptors"}));
        } else if (!set.contains(d)) {
            for (CallableDescriptor aM_ : d.aM_().mo7609m()) {
                CallableDescriptor aM_2 = aM_2.aM_();
                m27642a(aM_2, (Set) set);
                set.add(aM_2);
            }
        }
    }

    public static SourceFile m27663m(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingSourceFile"}));
        }
        if (declarationDescriptor instanceof PropertySetterDescriptor) {
            declarationDescriptor = ((PropertySetterDescriptor) declarationDescriptor).mo7822D();
        }
        if (declarationDescriptor instanceof DeclarationDescriptorWithSource) {
            declarationDescriptor = ((DeclarationDescriptorWithSource) declarationDescriptor).mo7258r().mo5713a();
            if (declarationDescriptor != null) {
                return declarationDescriptor;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingSourceFile"}));
        }
        declarationDescriptor = SourceFile.f25499a;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getContainingSourceFile"}));
    }

    public static CallableMemberDescriptor m27648b(CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDirectMember"}));
        }
        if (callableMemberDescriptor instanceof PropertyAccessorDescriptor) {
            callableMemberDescriptor = ((PropertyAccessorDescriptor) callableMemberDescriptor).mo7822D();
        }
        if (callableMemberDescriptor != null) {
            return callableMemberDescriptor;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "getDirectMember"}));
    }

    private static boolean m27667q(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return m27644a(declarationDescriptor, ClassKind.CLASS) && declarationDescriptor.mo6689i().equals(SpecialNames.f25870a) != null;
        } else {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils", "isAnonymousObject"}));
        }
    }

    public static boolean m27662l(DeclarationDescriptor declarationDescriptor) {
        if (!m27644a(declarationDescriptor, ClassKind.CLASS)) {
            if (m27644a(declarationDescriptor, ClassKind.ENUM_CLASS) == null) {
                return null;
            }
        }
        return true;
    }
}
