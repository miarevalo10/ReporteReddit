package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.LazyJavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.NonExtensions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: LazyJavaScope.kt */
public abstract class LazyJavaScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty[] f38423e = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LazyJavaScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LazyJavaScope.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;"))};
    private final NotNullLazyValue<Collection<DeclarationDescriptor>> f38424a = this.f38427d.f25703b.f25685a.mo5927a(new LazyJavaScope$allDescriptors$1(this), CollectionsKt__CollectionsKt.m26790a());
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> f38425b = this.f38427d.f25703b.f25685a.mo5925a((Function1) new LazyJavaScope$functions$1(this));
    final NotNullLazyValue<DeclaredMemberIndex> f38426c = this.f38427d.f25703b.f25685a.mo5926a((Function0) new LazyJavaScope$declaredMemberIndex$1(this));
    final LazyJavaResolverContext f38427d;
    private final NotNullLazyValue f38428g = this.f38427d.f25703b.f25685a.mo5926a((Function0) new LazyJavaScope$functionNamesLazy$2(this));
    private final NotNullLazyValue f38429h = this.f38427d.f25703b.f25685a.mo5926a((Function0) new LazyJavaScope$propertyNamesLazy$2(this));
    private final MemoizedFunctionToNotNull<Name, List<PropertyDescriptor>> f38430i = this.f38427d.f25703b.f25685a.mo5925a((Function1) new LazyJavaScope$properties$1(this));

    /* compiled from: LazyJavaScope.kt */
    protected static final class MethodSignatureData {
        final KotlinType f25708a;
        final KotlinType f25709b;
        final List<ValueParameterDescriptor> f25710c;
        final List<TypeParameterDescriptor> f25711d;
        final boolean f25712e;
        final List<String> f25713f;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MethodSignatureData) {
                MethodSignatureData methodSignatureData = (MethodSignatureData) obj;
                if (Intrinsics.m26845a(this.f25708a, methodSignatureData.f25708a) && Intrinsics.m26845a(this.f25709b, methodSignatureData.f25709b) && Intrinsics.m26845a(this.f25710c, methodSignatureData.f25710c) && Intrinsics.m26845a(this.f25711d, methodSignatureData.f25711d)) {
                    return (this.f25712e == methodSignatureData.f25712e) && Intrinsics.m26845a(this.f25713f, methodSignatureData.f25713f);
                }
            }
        }

        public final int hashCode() {
            KotlinType kotlinType = this.f25708a;
            int i = 0;
            int hashCode = (kotlinType != null ? kotlinType.hashCode() : 0) * 31;
            KotlinType kotlinType2 = this.f25709b;
            hashCode = (hashCode + (kotlinType2 != null ? kotlinType2.hashCode() : 0)) * 31;
            List list = this.f25710c;
            hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            list = this.f25711d;
            hashCode = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
            int i2 = this.f25712e;
            if (i2 != 0) {
                i2 = 1;
            }
            hashCode = (hashCode + i2) * 31;
            list = this.f25713f;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("MethodSignatureData(returnType=");
            stringBuilder.append(this.f25708a);
            stringBuilder.append(", receiverType=");
            stringBuilder.append(this.f25709b);
            stringBuilder.append(", valueParameters=");
            stringBuilder.append(this.f25710c);
            stringBuilder.append(", typeParameters=");
            stringBuilder.append(this.f25711d);
            stringBuilder.append(", hasStableParameterNames=");
            stringBuilder.append(this.f25712e);
            stringBuilder.append(", errors=");
            stringBuilder.append(this.f25713f);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public MethodSignatureData(KotlinType kotlinType, KotlinType kotlinType2, List<? extends ValueParameterDescriptor> list, List<? extends TypeParameterDescriptor> list2, boolean z, List<String> list3) {
            Intrinsics.m26847b(kotlinType, "returnType");
            Intrinsics.m26847b(list, "valueParameters");
            Intrinsics.m26847b(list2, "typeParameters");
            Intrinsics.m26847b(list3, "errors");
            this.f25708a = kotlinType;
            this.f25709b = kotlinType2;
            this.f25710c = list;
            this.f25711d = list2;
            this.f25712e = z;
            this.f25713f = list3;
        }
    }

    /* compiled from: LazyJavaScope.kt */
    protected static final class ResolvedValueParameters {
        final List<ValueParameterDescriptor> f25714a;
        final boolean f25715b;

        public ResolvedValueParameters(List<? extends ValueParameterDescriptor> list, boolean z) {
            Intrinsics.m26847b(list, "descriptors");
            this.f25714a = list;
            this.f25715b = z;
        }
    }

    protected abstract MethodSignatureData mo7260a(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2);

    protected abstract void mo7261a(Collection<SimpleFunctionDescriptor> collection, Name name);

    protected abstract void mo7262a(Name name, Collection<PropertyDescriptor> collection);

    protected boolean mo7263a(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.m26847b(javaMethodDescriptor, "$receiver");
        return true;
    }

    protected abstract Set<Name> mo7265c(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1);

    protected abstract DeclaredMemberIndex mo7266c();

    protected abstract ReceiverParameterDescriptor mo7267d();

    protected abstract DeclarationDescriptor mo7268e();

    public LazyJavaScope(LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        this.f38427d = lazyJavaResolverContext;
    }

    protected final JavaMethodDescriptor m38390a(JavaMethod javaMethod) {
        Intrinsics.m26847b(javaMethod, "method");
        Annotations a = LazyJavaAnnotationsKt.m27201a(this.f38427d, javaMethod);
        Object a2 = JavaMethodDescriptor.m43009a(mo7268e(), a, javaMethod.mo7103p(), this.f38427d.f25703b.f25695k.mo5773a(javaMethod));
        LazyJavaResolverContext lazyJavaResolverContext = this.f38427d;
        Intrinsics.m26843a(a2, "functionDescriptorImpl");
        lazyJavaResolverContext = ContextKt.m27198a(lazyJavaResolverContext, (DeclarationDescriptor) a2, javaMethod, 0);
        Iterable<JavaTypeParameter> q = javaMethod.mo7284q();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
        for (JavaTypeParameter a3 : q) {
            TypeParameterDescriptor a4 = lazyJavaResolverContext.f25704c.mo5779a(a3);
            if (a4 == null) {
                Intrinsics.m26842a();
            }
            arrayList.add(a4);
        }
        List list = (List) arrayList;
        Intrinsics.m26843a(a2, "functionDescriptorImpl");
        ResolvedValueParameters a5 = m38383a(lazyJavaResolverContext, (FunctionDescriptor) a2, javaMethod.mo7290b());
        MethodSignatureData a6 = mo7260a(javaMethod, list, m38384a(javaMethod, a, lazyJavaResolverContext), a5.f25714a);
        KotlinType kotlinType = a6.f25709b;
        ReceiverParameterDescriptor d = mo7267d();
        List list2 = a6.f25711d;
        List list3 = a6.f25710c;
        KotlinType kotlinType2 = a6.f25708a;
        Companion companion = Modality.f25492e;
        a2.mo7833b(kotlinType, d, list2, list3, kotlinType2, Companion.m27078a(javaMethod.mo7099l(), javaMethod.mo7101n() ^ 1), javaMethod.mo7102o());
        a2.m43014a(a6.f25712e, a5.f25715b);
        if ((((Collection) a6.f25713f).isEmpty() ^ 1) != null) {
            lazyJavaResolverContext.f25703b.f25690f.mo5777a((CallableMemberDescriptor) a2, a6.f25713f);
        }
        Intrinsics.m26843a(a2, "functionDescriptorImpl");
        return a2;
    }

    protected static KotlinType m38384a(JavaMethod javaMethod, Annotations annotations, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(javaMethod, "method");
        Intrinsics.m26847b(annotations, "annotations");
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        boolean g = javaMethod.mo7098d().mo7279g();
        javaMethod = lazyJavaResolverContext.f25702a.m27225a(javaMethod.aS_(), (JavaTypeAttributes) new LazyJavaTypeAttributes(TypeUsage.MEMBER_SIGNATURE_COVARIANT, annotations, g ^ 1, g));
        if (g) {
            javaMethod = TypeUtils.m28014c(javaMethod);
            Intrinsics.m26843a((Object) javaMethod, "TypeUtils.makeNotNullable(it)");
        }
        return (KotlinType) javaMethod;
    }

    protected static ResolvedValueParameters m38383a(LazyJavaResolverContext lazyJavaResolverContext, FunctionDescriptor functionDescriptor, List<? extends JavaValueParameter> list) {
        LazyJavaResolverContext lazyJavaResolverContext2 = lazyJavaResolverContext;
        FunctionDescriptor functionDescriptor2 = functionDescriptor;
        List<? extends JavaValueParameter> list2 = list;
        Intrinsics.m26847b(lazyJavaResolverContext2, "c");
        Intrinsics.m26847b(functionDescriptor2, "function");
        Intrinsics.m26847b(list2, "jValueParameters");
        BooleanRef booleanRef = new BooleanRef();
        boolean z = false;
        booleanRef.f25288a = false;
        Iterable<IndexedValue> q = CollectionsKt___CollectionsKt.m41452q(list2);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
        for (IndexedValue indexedValue : q) {
            Pair a;
            Name a2;
            int i = indexedValue.f25277a;
            JavaValueParameter javaValueParameter = (JavaValueParameter) indexedValue.f25278b;
            Annotations a3 = LazyJavaAnnotationsKt.m27201a(lazyJavaResolverContext2, javaValueParameter);
            LazyJavaTypeAttributes lazyJavaTypeAttributes = new LazyJavaTypeAttributes(TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT, a3, z, 12);
            if (javaValueParameter.mo7108d()) {
                JavaType c = javaValueParameter.mo7107c();
                if (!(c instanceof JavaArrayType)) {
                    c = null;
                }
                JavaArrayType javaArrayType = (JavaArrayType) c;
                if (javaArrayType == null) {
                    StringBuilder stringBuilder = new StringBuilder("Vararg parameter should be an array: ");
                    stringBuilder.append(javaValueParameter);
                    throw new AssertionError(stringBuilder.toString());
                }
                KotlinType a4 = lazyJavaResolverContext2.f25702a.m27224a(javaArrayType, (JavaTypeAttributes) lazyJavaTypeAttributes, true);
                a = TuplesKt.m26780a(a4, lazyJavaResolverContext2.f25703b.f25700p.mo7089b().m27000a(a4));
            } else {
                a = TuplesKt.m26780a(lazyJavaResolverContext2.f25702a.m27225a(javaValueParameter.mo7107c(), (JavaTypeAttributes) lazyJavaTypeAttributes), null);
            }
            Object obj = (KotlinType) a.f25267a;
            KotlinType kotlinType = (KotlinType) a.f25268b;
            if (Intrinsics.m26845a(functionDescriptor.mo6689i().m27429a(), (Object) "equals") && list.size() == 1 && Intrinsics.m26845a(lazyJavaResolverContext2.f25703b.f25700p.mo7089b().m27016n(), obj)) {
                a2 = Name.m27424a("other");
            } else {
                a2 = javaValueParameter.mo7106b();
                if (a2 == null) {
                    booleanRef.f25288a = true;
                }
                if (a2 == null) {
                    StringBuilder stringBuilder2 = new StringBuilder("p");
                    stringBuilder2.append(i);
                    a2 = Name.m27424a(stringBuilder2.toString());
                }
            }
            Object obj2 = a2;
            CallableDescriptor callableDescriptor = functionDescriptor2;
            Intrinsics.m26843a(obj2, "name");
            ValueParameterDescriptorImpl valueParameterDescriptorImpl = r8;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl2 = new ValueParameterDescriptorImpl(callableDescriptor, null, i, a3, obj2, obj, false, false, false, kotlinType, lazyJavaResolverContext2.f25703b.f25695k.mo5773a(javaValueParameter));
            arrayList.add(valueParameterDescriptorImpl);
            z = false;
        }
        return new ResolvedValueParameters(CollectionsKt___CollectionsKt.m41449n((List) arrayList), booleanRef.f25288a);
    }

    public Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        if ((aE_().contains(name) ^ 1) != null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        return (Collection) this.f38425b.mo6492a(name);
    }

    protected Set<Name> mo7264b(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        return ((DeclaredMemberIndex) this.f38426c.invoke()).mo5782a();
    }

    protected Set<Name> mo7259a(DescriptorKindFilter descriptorKindFilter) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        return ((DeclaredMemberIndex) this.f38426c.invoke()).mo5783b();
    }

    private static boolean m38385a(JavaField javaField) {
        return (!javaField.mo7101n() || javaField.mo7100m() == null) ? null : true;
    }

    public Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        if ((aF_().contains(name) ^ 1) != null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        return (Collection) this.f38430i.mo6492a(name);
    }

    public Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        return (Collection) this.f38424a.invoke();
    }

    protected final List<DeclarationDescriptor> m38388a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        Intrinsics.m26847b(lookupLocation, "location");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        DescriptorKindFilter.Companion companion = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(DescriptorKindFilter.Companion.m27767h())) {
            for (Name name : mo7265c(descriptorKindFilter, function1)) {
                if (((Boolean) function1.mo6492a(name)).booleanValue()) {
                    CollectionsKt.m28092a((Collection) linkedHashSet, mo6699c(name, lookupLocation));
                }
            }
        }
        companion = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(DescriptorKindFilter.Companion.m27764e()) && !descriptorKindFilter.f26138b.contains(NonExtensions.f32950a)) {
            for (Name name2 : mo7264b(descriptorKindFilter, (Function1) function1)) {
                if (((Boolean) function1.mo6492a(name2)).booleanValue()) {
                    linkedHashSet.addAll(mo6698b(name2, lookupLocation));
                }
            }
        }
        companion = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(DescriptorKindFilter.Companion.m27765f()) && !descriptorKindFilter.f26138b.contains(NonExtensions.f32950a)) {
            for (Name name3 : mo7259a(descriptorKindFilter)) {
                if (((Boolean) function1.mo6492a(name3)).booleanValue()) {
                    linkedHashSet.addAll(mo6694a(name3, lookupLocation));
                }
            }
        }
        return CollectionsKt.m28089a((Collection) linkedHashSet);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Lazy scope for ");
        stringBuilder.append(mo7268e());
        return stringBuilder.toString();
    }

    public final Set<Name> aE_() {
        return (Set) StorageKt.m27920a(this.f38428g, f38423e[0]);
    }

    public final Set<Name> aF_() {
        return (Set) StorageKt.m27920a(this.f38429h, f38423e[1]);
    }

    public static final /* synthetic */ PropertyDescriptor m38382a(LazyJavaScope lazyJavaScope, JavaField javaField) {
        boolean n = javaField.mo7101n() ^ 1;
        Object a = JavaPropertyDescriptor.m43089a(lazyJavaScope.mo7268e(), LazyJavaAnnotationsKt.m27201a(lazyJavaScope.f38427d, javaField), Modality.f25488a, javaField.mo7102o(), n, javaField.mo7103p(), lazyJavaScope.f38427d.f25703b.f25695k.mo5773a(javaField), m38385a(javaField));
        Intrinsics.m26843a(a, "JavaPropertyDescriptor.c…d.isFinalStatic\n        )");
        PropertyDescriptorImpl propertyDescriptorImpl = (PropertyDescriptorImpl) a;
        propertyDescriptorImpl.m42990a(null, null);
        Annotations q = propertyDescriptorImpl.mo5718q();
        Intrinsics.m26843a((Object) q, "propertyDescriptor.annotations");
        if (m38385a(javaField)) {
            lazyJavaScope.f38427d.f25703b.f25693i.mo5765a(javaField);
        }
        propertyDescriptorImpl.m42991a(lazyJavaScope.f38427d.f25702a.m27225a(javaField.aR_(), (JavaTypeAttributes) new LazyJavaTypeAttributes(TypeUsage.MEMBER_SIGNATURE_INVARIANT, q, true, 8)), CollectionsKt__CollectionsKt.m26790a(), lazyJavaScope.mo7267d(), null);
        if (DescriptorUtils.m27646a((VariableDescriptor) propertyDescriptorImpl, propertyDescriptorImpl.mo7777x())) {
            propertyDescriptorImpl.m42825a(lazyJavaScope.f38427d.f25703b.f25685a.mo5931b((Function0) new LazyJavaScope$resolveProperty$1(lazyJavaScope, javaField, propertyDescriptorImpl)));
        }
        PropertyDescriptor propertyDescriptor = propertyDescriptorImpl;
        lazyJavaScope.f38427d.f25703b.f25692h.recordField(javaField, propertyDescriptor);
        return propertyDescriptor;
    }
}
