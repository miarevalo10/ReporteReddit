package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f26090a;

        static {
            int[] iArr = new int[ClassKind.values().length];
            f26090a = iArr;
            iArr[ClassKind.OBJECT.ordinal()] = 1;
            f26090a[ClassKind.ENUM_ENTRY.ordinal()] = 2;
        }
    }

    public static final FqNameUnsafe m27738a(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        Object c = DescriptorUtils.m27653c(declarationDescriptor);
        Intrinsics.m26843a(c, "DescriptorUtils.getFqName(this)");
        return c;
    }

    public static final FqName m27742b(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        Object d = DescriptorUtils.m27654d(declarationDescriptor);
        Intrinsics.m26843a(d, "DescriptorUtils.getFqNameSafe(this)");
        return d;
    }

    public static final ModuleDescriptor m27744c(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        Object f = DescriptorUtils.m27656f(declarationDescriptor);
        Intrinsics.m26843a(f, "DescriptorUtils.getContainingModule(this)");
        return f;
    }

    public static final ClassDescriptor m27735a(ModuleDescriptor moduleDescriptor, FqName fqName, LookupLocation lookupLocation) {
        Intrinsics.m26847b(moduleDescriptor, "$receiver");
        Intrinsics.m26847b(fqName, "topLevelClassFqName");
        Intrinsics.m26847b(lookupLocation, "location");
        int c = fqName.m27410c() ^ 1;
        if (_Assertions.f25274a && c == 0) {
            throw ((Throwable) new AssertionError("Assertion failed"));
        }
        FqName d = fqName.m27411d();
        Intrinsics.m26843a((Object) d, "topLevelClassFqName.parent()");
        moduleDescriptor = moduleDescriptor.mo7087a(d).mo7081c();
        Object e = fqName.m27412e();
        Intrinsics.m26843a(e, "topLevelClassFqName.shortName()");
        moduleDescriptor = moduleDescriptor.mo6699c(e, lookupLocation);
        if ((moduleDescriptor instanceof ClassDescriptor) == null) {
            moduleDescriptor = null;
        }
        return (ClassDescriptor) moduleDescriptor;
    }

    public static final ClassId m27736a(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        ClassId classId;
        Intrinsics.m26847b(classifierDescriptorWithTypeParameters, "$receiver");
        DeclarationDescriptor aD_ = classifierDescriptorWithTypeParameters.aD_();
        if (aD_ instanceof PackageFragmentDescriptor) {
            classId = new ClassId(((PackageFragmentDescriptor) aD_).mo7722d(), classifierDescriptorWithTypeParameters.mo6689i());
        } else {
            if (aD_ instanceof ClassifierDescriptorWithTypeParameters) {
                ClassId a = m27736a((ClassifierDescriptorWithTypeParameters) aD_);
                if (a != null) {
                    classId = a.m27397a(classifierDescriptorWithTypeParameters.mo6689i());
                }
            }
            classId = null;
        }
        return classId;
    }

    public static final KotlinType m27739a(ClassDescriptor classDescriptor) {
        ClassDescriptor classDescriptor2;
        Intrinsics.m26847b(classDescriptor, "$receiver");
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = classDescriptor;
        Intrinsics.m26847b(classifierDescriptorWithTypeParameters, "$receiver");
        Intrinsics.m26847b(classifierDescriptorWithTypeParameters, "$receiver");
        if (classifierDescriptorWithTypeParameters instanceof ClassDescriptor) {
            classDescriptor2 = (ClassDescriptor) classifierDescriptorWithTypeParameters;
        } else if (classifierDescriptorWithTypeParameters instanceof TypeAliasDescriptor) {
            classDescriptor2 = ((TypeAliasDescriptor) classifierDescriptorWithTypeParameters).mo7810d();
        } else {
            StringBuilder stringBuilder = new StringBuilder("Unexpected descriptor kind: ");
            stringBuilder.append(classifierDescriptorWithTypeParameters);
            throw new UnsupportedOperationException(stringBuilder.toString());
        }
        SimpleType simpleType = null;
        if (classDescriptor2 != null) {
            classDescriptor2 = classDescriptor2;
            switch (WhenMappings.f26090a[classDescriptor2.mo7771g().ordinal()]) {
                case 1:
                    break;
                case 2:
                    classDescriptor = classifierDescriptorWithTypeParameters.aD_();
                    Object obj = ((classDescriptor instanceof ClassDescriptor) && Intrinsics.m26845a(classDescriptor.mo7771g(), ClassKind.ENUM_CLASS)) ? 1 : null;
                    if (!_Assertions.f25274a || obj != null) {
                        if (classDescriptor != null) {
                            classDescriptor2 = classDescriptor;
                            break;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    }
                    throw new AssertionError("Assertion failed");
                default:
                    classDescriptor2 = classDescriptor2.mo7769e();
                    break;
            }
            classDescriptor = classDescriptor2;
        } else {
            classDescriptor = null;
        }
        if (classDescriptor != null) {
            simpleType = classDescriptor.mo7714h();
        }
        return simpleType;
    }

    public static final ClassDescriptor m27741b(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "$receiver");
        for (KotlinType kotlinType : classDescriptor.mo7714h().mo6743g().aL_()) {
            if (!KotlinBuiltIns.m26991g(kotlinType)) {
                ClassifierDescriptor c = kotlinType.mo6743g().mo5724c();
                if (DescriptorUtils.m27662l(c)) {
                    if (c != null) {
                        return (ClassDescriptor) c;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
            }
        }
        return null;
    }

    public static final KotlinBuiltIns m27745d(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        return m27744c(declarationDescriptor).mo7089b();
    }

    public static final boolean m27740a(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.m26847b(valueParameterDescriptor, "$receiver");
        Object a = DFS.m28100a((Collection) CollectionsKt__CollectionsKt.m26791a((Object) valueParameterDescriptor), (Neighbors) DescriptorUtilsKt$hasDefaultValue$1.f32949a, (Function1) DescriptorUtilsKt$hasDefaultValue$2.f38810a);
        Intrinsics.m26843a(a, "DFS.ifAny(\n            l…eclaresDefaultValue\n    )");
        return a.booleanValue();
    }

    public static final Sequence<DeclarationDescriptor> m27746e(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        Intrinsics.m26847b(declarationDescriptor, "$receiver");
        return SequencesKt___SequencesKt.m33709b(SequencesKt__SequencesKt.m28142a(declarationDescriptor, DescriptorUtilsKt$parentsWithSelf$1.f38811a));
    }

    public static final CallableMemberDescriptor m27733a(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "$receiver");
        if (!(callableMemberDescriptor instanceof PropertyAccessorDescriptor)) {
            return callableMemberDescriptor;
        }
        Object D = ((PropertyAccessorDescriptor) callableMemberDescriptor).mo7822D();
        Intrinsics.m26843a(D, "correspondingProperty");
        return (CallableMemberDescriptor) D;
    }

    public static final FqName m27737a(CallableDescriptor callableDescriptor) {
        Intrinsics.m26847b(callableDescriptor, "$receiver");
        FqNameUnsafe fqNameUnsafe = (FqNameUnsafe) AddToStdlibKt.m28126a(m27738a((DeclarationDescriptor) callableDescriptor), DescriptorUtilsKt$fqNameOrNull$1.f38809a);
        return fqNameUnsafe != null ? fqNameUnsafe.m27420d() : null;
    }

    public static /* synthetic */ CallableMemberDescriptor m27734a(CallableMemberDescriptor callableMemberDescriptor, Function1 function1) {
        Intrinsics.m26847b(callableMemberDescriptor, "$receiver");
        Intrinsics.m26847b(function1, "predicate");
        ObjectRef objectRef = new ObjectRef();
        objectRef.f25291a = null;
        return (CallableMemberDescriptor) DFS.m28101a((Collection) CollectionsKt__CollectionsKt.m26791a((Object) callableMemberDescriptor), (Neighbors) new DescriptorUtilsKt$firstOverridden$1(), (NodeHandler) new DescriptorUtilsKt$firstOverridden$2(objectRef, function1));
    }

    public static final Collection<ClassDescriptor> m27743c(ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(classDescriptor, "sealedClass");
        if ((Intrinsics.m26845a(classDescriptor.aG_(), Modality.f25489b) ^ 1) != 0) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DescriptorUtilsKt$computeSealedSubclasses$1 descriptorUtilsKt$computeSealedSubclasses$1 = new DescriptorUtilsKt$computeSealedSubclasses$1(classDescriptor, linkedHashSet);
        DeclarationDescriptor aD_ = classDescriptor.aD_();
        if (aD_ instanceof PackageFragmentDescriptor) {
            descriptorUtilsKt$computeSealedSubclasses$1.m38570a(((PackageFragmentDescriptor) aD_).aC_(), false);
        }
        descriptorUtilsKt$computeSealedSubclasses$1 = descriptorUtilsKt$computeSealedSubclasses$1;
        MemberScope t = classDescriptor.mo7739t();
        Intrinsics.m26843a((Object) t, "sealedClass.unsubstitutedInnerClassesScope");
        descriptorUtilsKt$computeSealedSubclasses$1.m38570a(t, true);
        return linkedHashSet;
    }
}
