package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: NotFoundClasses.kt */
public final class NotFoundClasses {
    final MemoizedFunctionToNotNull<ClassRequest, TypeAliasDescriptor> f26261a = this.f26264d.mo5925a((Function1) new NotFoundClasses$typeAliases$1(this));
    private final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> f26262b = this.f26264d.mo5925a((Function1) new NotFoundClasses$packageFragments$1(this));
    private final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> f26263c = this.f26264d.mo5925a((Function1) new NotFoundClasses$classes$1(this));
    private final StorageManager f26264d;
    private final ModuleDescriptor f26265e;

    /* compiled from: NotFoundClasses.kt */
    private static final class ClassRequest {
        final ClassId f26259a;
        final List<Integer> f26260b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof ClassRequest) {
                    ClassRequest classRequest = (ClassRequest) obj;
                    if (Intrinsics.m26845a(this.f26259a, classRequest.f26259a) && Intrinsics.m26845a(this.f26260b, classRequest.f26260b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            ClassId classId = this.f26259a;
            int i = 0;
            int hashCode = (classId != null ? classId.hashCode() : 0) * 31;
            List list = this.f26260b;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ClassRequest(classId=");
            stringBuilder.append(this.f26259a);
            stringBuilder.append(", typeParametersCount=");
            stringBuilder.append(this.f26260b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public ClassRequest(ClassId classId, List<Integer> list) {
            Intrinsics.m26847b(classId, "classId");
            Intrinsics.m26847b(list, "typeParametersCount");
            this.f26259a = classId;
            this.f26260b = list;
        }
    }

    /* compiled from: NotFoundClasses.kt */
    private static final class MockTypeAliasDescriptor extends AbstractTypeAliasDescriptor {
        static final /* synthetic */ KProperty[] f40865b = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(MockTypeAliasDescriptor.class), "constructorTypeParameters", "getConstructorTypeParameters()Ljava/util/List;"))};
        private final NotNullLazyValue f40866c;
        private final boolean f40867d;

        public MockTypeAliasDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, boolean z, int i) {
            Intrinsics.m26847b(storageManager, "storageManager");
            Intrinsics.m26847b(declarationDescriptor, "containingDeclaration");
            Intrinsics.m26847b(name, "name");
            Companion companion = Annotations.f32643a;
            Annotations a = Companion.m27115a();
            Object obj = SourceElement.f25498a;
            Intrinsics.m26843a(obj, "SourceElement.NO_SOURCE");
            Object obj2 = Visibilities.f25508e;
            Intrinsics.m26843a(obj2, "Visibilities.PUBLIC");
            super(declarationDescriptor, a, name, obj, obj2);
            this.f40867d = z;
            m42587a(NotFoundClassesKt.m27861a(this, i));
            this.f40866c = storageManager.mo5926a((Function0) new C2988x6e310cf6(this));
        }

        public final /* bridge */ /* synthetic */ DeclarationDescriptor mo7079b(TypeSubstitutor typeSubstitutor) {
            Intrinsics.m26847b(typeSubstitutor, "substitutor");
            return this;
        }

        public final SimpleType mo7809b() {
            Object n = DescriptorUtilsKt.m27745d(this).m27016n();
            Intrinsics.m26843a(n, "builtIns.nullableAnyType");
            return n;
        }

        public final SimpleType mo7714h() {
            Object n = DescriptorUtilsKt.m27745d(this).m27016n();
            Intrinsics.m26843a(n, "builtIns.nullableAnyType");
            return n;
        }

        public final boolean mo7742l() {
            return this.f40867d;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("MockTypeAliasDescriptor[");
            stringBuilder.append(DescriptorUtilsKt.m27738a((DeclarationDescriptor) this));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        protected final List<TypeParameterDescriptor> mo7811k() {
            return (List) StorageKt.m27920a(this.f40866c, f40865b[0]);
        }

        public final ClassDescriptor mo7810d() {
            Object n = DescriptorUtilsKt.m27745d(this).m27016n();
            Intrinsics.m26843a(n, "builtIns.nullableAnyType");
            ClassifierDescriptor c = n.mo6743g().mo5724c();
            if (!(c instanceof ClassDescriptor)) {
                c = null;
            }
            return (ClassDescriptor) c;
        }
    }

    /* compiled from: NotFoundClasses.kt */
    public static final class MockClassDescriptor extends ClassDescriptorBase {
        private final List<TypeParameterDescriptor> f40970a;
        private final ClassTypeConstructorImpl f40971b = new ClassTypeConstructorImpl(this, 1, this.f40970a, SetsKt__SetsKt.m26800a((Object) DescriptorUtilsKt.m27744c((DeclarationDescriptor) this).mo7089b().m27015m()));
        private final boolean f40972c;

        public final ClassConstructorDescriptor aH_() {
            return null;
        }

        public final ClassDescriptor mo7769e() {
            return null;
        }

        public final boolean mo7772k() {
            return false;
        }

        public final boolean mo7773m() {
            return false;
        }

        public final boolean mo7743n() {
            return false;
        }

        public final boolean mo7744o() {
            return false;
        }

        public final boolean mo7745p() {
            return false;
        }

        public MockClassDescriptor(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Name name, boolean z, int i) {
            Intrinsics.m26847b(storageManager, "storageManager");
            Intrinsics.m26847b(declarationDescriptor, "container");
            Intrinsics.m26847b(name, "name");
            super(storageManager, declarationDescriptor, name, SourceElement.f25498a);
            this.f40972c = z;
            this.f40970a = NotFoundClassesKt.m27861a(this, i);
        }

        public final ClassKind mo7771g() {
            return ClassKind.CLASS;
        }

        public final Modality aG_() {
            return Modality.f25488a;
        }

        public final Visibility mo7257j() {
            return Visibilities.f25508e;
        }

        public final List<TypeParameterDescriptor> mo7719s() {
            return this.f40970a;
        }

        public final boolean mo7742l() {
            return this.f40972c;
        }

        public final Annotations mo5718q() {
            Companion companion = Annotations.f32643a;
            return Companion.m27115a();
        }

        public final Collection<ClassConstructorDescriptor> mo7770f() {
            return SetsKt__SetsKt.m26799a();
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("class ");
            stringBuilder.append(mo6689i());
            stringBuilder.append(" (not found)");
            return stringBuilder.toString();
        }

        public final /* bridge */ /* synthetic */ TypeConstructor mo7610c() {
            return this.f40971b;
        }

        public final /* bridge */ /* synthetic */ MemberScope mo7768d() {
            return Empty.f38819a;
        }

        public final /* bridge */ /* synthetic */ MemberScope mo7767b() {
            return Empty.f38819a;
        }
    }

    public NotFoundClasses(StorageManager storageManager, ModuleDescriptor moduleDescriptor) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(moduleDescriptor, "module");
        this.f26264d = storageManager;
        this.f26265e = moduleDescriptor;
    }

    final ClassDescriptor m27859a(ClassId classId, List<Integer> list) {
        return (ClassDescriptor) this.f26263c.mo6492a(new ClassRequest(classId, list));
    }

    public final TypeConstructor m27860b(ClassId classId, List<Integer> list) {
        Intrinsics.m26847b(classId, "classId");
        Intrinsics.m26847b(list, "typeParametersCount");
        Object c = m27859a(classId, list).mo7610c();
        Intrinsics.m26843a(c, "getOrCreateClass(classId…ersCount).typeConstructor");
        return c;
    }

    public static final /* synthetic */ Object m27856a(NotFoundClasses notFoundClasses, ClassRequest classRequest, Function4 function4) {
        ClassId classId = classRequest.f26259a;
        classRequest = classRequest.f26260b;
        if (classId.f25852a) {
            classRequest = new StringBuilder("Unresolved local class: ");
            classRequest.append(classId);
            throw ((Throwable) new UnsupportedOperationException(classRequest.toString()));
        }
        Object d;
        if (classId.m27402e()) {
            d = classId.m27401d();
            Intrinsics.m26843a(d, "classId.outerClassId");
            notFoundClasses = notFoundClasses.m27859a(d, CollectionsKt___CollectionsKt.m41444j((Iterable) classRequest));
        } else {
            notFoundClasses = notFoundClasses.f26262b;
            d = classId.m27398a();
            Intrinsics.m26843a(d, "classId.packageFqName");
            notFoundClasses = (ClassOrPackageFragmentDescriptor) notFoundClasses.mo6492a(d);
        }
        boolean e = classId.m27402e();
        Object c = classId.m27400c();
        Intrinsics.m26843a(c, "classId.shortClassName");
        Integer num = (Integer) CollectionsKt___CollectionsKt.m41434e((List) classRequest);
        return function4.mo6942a(notFoundClasses, c, Boolean.valueOf(e), Integer.valueOf(num != null ? num.intValue() : null));
    }
}
