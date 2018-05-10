package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature;
import kotlin.reflect.jvm.internal.impl.load.java.BuiltinSpecialProperties;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.PropertiesConventionUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope extends LazyJavaScope {
    final NotNullLazyValue<List<ClassConstructorDescriptor>> f39719a;
    final ClassDescriptor f39720b;
    private final NotNullLazyValue<Map<Name, JavaClass>> f39721g;
    private final NotNullLazyValue<Map<Name, JavaField>> f39722h;
    private final MemoizedFunctionToNullable<Name, ClassDescriptorBase> f39723i;
    private final JavaClass f39724j;

    public final /* synthetic */ Set mo7264b(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Collection hashSet = new HashSet();
        for (KotlinType b : this.f39720b.mo7610c().aL_()) {
            CollectionsKt__MutableCollectionsKt.m38194a(hashSet, (Iterable) b.mo6740b().aE_());
        }
        HashSet hashSet2 = (HashSet) hashSet;
        hashSet2.addAll(((DeclaredMemberIndex) this.f38426c.invoke()).mo5782a());
        hashSet2.addAll(mo7265c(descriptorKindFilter, function1));
        return hashSet2;
    }

    public LazyJavaClassMemberScope(LazyJavaResolverContext lazyJavaResolverContext, ClassDescriptor classDescriptor, JavaClass javaClass) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(classDescriptor, "ownerDescriptor");
        Intrinsics.m26847b(javaClass, "jClass");
        super(lazyJavaResolverContext);
        this.f39720b = classDescriptor;
        this.f39724j = javaClass;
        this.f39719a = lazyJavaResolverContext.f25703b.f25685a.mo5926a((Function0) new LazyJavaClassMemberScope$constructors$1(this, lazyJavaResolverContext));
        this.f39721g = lazyJavaResolverContext.f25703b.f25685a.mo5926a((Function0) new LazyJavaClassMemberScope$nestedClassIndex$1(this));
        this.f39722h = lazyJavaResolverContext.f25703b.f25685a.mo5926a((Function0) new LazyJavaClassMemberScope$enumEntryIndex$1(this));
        this.f39723i = lazyJavaResolverContext.f25703b.f25685a.mo5930b((Function1) new LazyJavaClassMemberScope$nestedClasses$1(this, lazyJavaResolverContext));
    }

    protected final boolean mo7263a(JavaMethodDescriptor javaMethodDescriptor) {
        Intrinsics.m26847b(javaMethodDescriptor, "$receiver");
        if (this.f39724j.mo7279g()) {
            return null;
        }
        return m39855a((SimpleFunctionDescriptor) javaMethodDescriptor);
    }

    private final boolean m39855a(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        boolean z;
        boolean z2;
        Object i = simpleFunctionDescriptor.mo6689i();
        Intrinsics.m26843a(i, "function.name");
        for (Name b : PropertiesConventionUtilKt.m27164a(i)) {
            for (PropertyDescriptor propertyDescriptor : m39858b(b)) {
                boolean z3;
                if (!m39864c(propertyDescriptor, (Function1) new C2941xb5a47a0f(this, simpleFunctionDescriptor)) || (!propertyDescriptor.mo7807y() && JvmAbi.m27154b(simpleFunctionDescriptor.mo6689i().m27429a()))) {
                    z3 = false;
                    continue;
                } else {
                    z3 = true;
                    continue;
                }
                if (z3) {
                    z = true;
                    continue;
                    break;
                }
            }
            z = false;
            continue;
            if (z) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2) {
            return false;
        }
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.f25594a;
        Name i2 = simpleFunctionDescriptor.mo6689i();
        Intrinsics.m26843a((Object) i2, "name");
        for (Name name : BuiltinMethodsWithDifferentJvmName.m27129b(i2)) {
            Collection arrayList = new ArrayList();
            for (Object next : m39843a(name)) {
                if (SpecialBuiltinMembers.m27172b((SimpleFunctionDescriptor) next)) {
                    arrayList.add(next);
                }
            }
            List<SimpleFunctionDescriptor> list = (List) arrayList;
            if (!list.isEmpty()) {
                SimpleFunctionDescriptor a = m39847a(simpleFunctionDescriptor, name);
                for (SimpleFunctionDescriptor a2 : list) {
                    if (m39856a(a2, (FunctionDescriptor) a)) {
                        z = true;
                        continue;
                        break;
                    }
                }
            }
            z = false;
            continue;
            if (z) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        return !z2 && m39861b(simpleFunctionDescriptor) == null;
    }

    private final boolean m39861b(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.f25612a;
        if (!BuiltinMethodsWithSpecialGenericSignature.m27135a(simpleFunctionDescriptor.mo6689i())) {
            return false;
        }
        Name i = simpleFunctionDescriptor.mo6689i();
        Intrinsics.m26843a((Object) i, "name");
        Collection arrayList = new ArrayList();
        for (SimpleFunctionDescriptor a : m39843a(i)) {
            FunctionDescriptor a2 = BuiltinMethodsWithSpecialGenericSignature.m27133a((FunctionDescriptor) a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        for (FunctionDescriptor b : (List) arrayList) {
            if (m39862b(simpleFunctionDescriptor, b)) {
                return true;
            }
        }
        return false;
    }

    private static SimpleFunctionDescriptor m39847a(SimpleFunctionDescriptor simpleFunctionDescriptor, Name name) {
        CopyBuilder C = simpleFunctionDescriptor.mo7736C();
        C.mo5748a(name);
        C.mo5740a();
        C.mo5752b();
        simpleFunctionDescriptor = C.mo5757f();
        if (simpleFunctionDescriptor == null) {
            Intrinsics.m26842a();
        }
        return simpleFunctionDescriptor;
    }

    private static boolean m39856a(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.f25594a;
        if (BuiltinMethodsWithDifferentJvmName.m27132c(simpleFunctionDescriptor)) {
            functionDescriptor = functionDescriptor.mo7761v();
        }
        return m39854a((CallableDescriptor) functionDescriptor, (CallableDescriptor) simpleFunctionDescriptor);
    }

    private static boolean m39854a(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if (Intrinsics.m26845a(OverridingUtil.f26084a.m27707a(callableDescriptor2, callableDescriptor, true).m27679b(), Result.OVERRIDABLE)) {
            Companion companion = JavaIncompatibilityRulesOverridabilityCondition.f32694a;
            if (Companion.m27148a(callableDescriptor2, callableDescriptor) == null) {
                return true;
            }
        }
        return null;
    }

    private final SimpleFunctionDescriptor m39845a(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        PropertyGetterDescriptor b = propertyDescriptor.mo7826b();
        String str = null;
        Object obj = b != null ? (PropertyGetterDescriptor) SpecialBuiltinMembers.m27167a(b) : null;
        if (obj != null) {
            BuiltinSpecialProperties builtinSpecialProperties = BuiltinSpecialProperties.f25619a;
            str = BuiltinSpecialProperties.m27140b((CallableMemberDescriptor) obj);
        }
        if (str != null) {
            ClassDescriptor classDescriptor = this.f39720b;
            if (obj == null) {
                Intrinsics.m26842a();
            }
            Intrinsics.m26843a(obj, "overriddenBuiltinProperty!!");
            if (!SpecialBuiltinMembers.m27171a(classDescriptor, (CallableDescriptor) obj)) {
                return m39844a(propertyDescriptor, str, (Function1) function1);
            }
        }
        String c = JvmAbi.m27155c(propertyDescriptor.mo6689i().m27429a());
        Intrinsics.m26843a((Object) c, "JvmAbi.getterName(name.asString())");
        return m39844a(propertyDescriptor, c, (Function1) function1);
    }

    private static SimpleFunctionDescriptor m39844a(PropertyDescriptor propertyDescriptor, String str, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Object a = Name.m27424a(str);
        Intrinsics.m26843a(a, "Name.identifier(getterName)");
        str = ((Iterable) function1.mo6492a(a)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (str.hasNext() == null) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) str.next();
            if (simpleFunctionDescriptor2.mo7757k().size() != 0) {
                continue;
            } else {
                simpleFunctionDescriptor = (SimpleFunctionDescriptor) AddToStdlibKt.m28126a(simpleFunctionDescriptor2, new C2939x40509986(simpleFunctionDescriptor2, propertyDescriptor));
                continue;
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private static SimpleFunctionDescriptor m39860b(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        SimpleFunctionDescriptor simpleFunctionDescriptor;
        Object a = Name.m27424a(JvmAbi.m27156d(propertyDescriptor.mo6689i().m27429a()));
        Intrinsics.m26843a(a, "Name.identifier(JvmAbi.s…terName(name.asString()))");
        function1 = ((Iterable) function1.mo6492a(a)).iterator();
        do {
            simpleFunctionDescriptor = null;
            if (!function1.hasNext()) {
                break;
            }
            SimpleFunctionDescriptor simpleFunctionDescriptor2 = (SimpleFunctionDescriptor) function1.next();
            if (simpleFunctionDescriptor2.mo7757k().size() != 1) {
                continue;
            } else {
                KotlinType aN_ = simpleFunctionDescriptor2.aN_();
                if (aN_ == null) {
                    continue;
                } else if (KotlinBuiltIns.m26994j(aN_)) {
                    simpleFunctionDescriptor = (SimpleFunctionDescriptor) AddToStdlibKt.m28126a(simpleFunctionDescriptor2, new C2940xcbdbac88(simpleFunctionDescriptor2, propertyDescriptor));
                    continue;
                } else {
                    continue;
                }
            }
        } while (simpleFunctionDescriptor == null);
        return simpleFunctionDescriptor;
    }

    private final boolean m39864c(PropertyDescriptor propertyDescriptor, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        if (JavaDescriptorUtilKt.m27208a(propertyDescriptor)) {
            return false;
        }
        SimpleFunctionDescriptor a = m39845a(propertyDescriptor, (Function1) function1);
        function1 = m39860b(propertyDescriptor, (Function1) function1);
        if (a == null) {
            return false;
        }
        if (propertyDescriptor.mo7807y() == null) {
            return true;
        }
        if (function1 == null || Intrinsics.m26845a(function1.aG_(), a.aG_()) == null) {
            return false;
        }
        return true;
    }

    protected final void mo7261a(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.m26847b(collection, "result");
        Intrinsics.m26847b(name, "name");
        Set a = m39843a(name);
        BuiltinMethodsWithDifferentJvmName builtinMethodsWithDifferentJvmName = BuiltinMethodsWithDifferentJvmName.f25594a;
        if (!BuiltinMethodsWithDifferentJvmName.m27128a(name)) {
            BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = BuiltinMethodsWithSpecialGenericSignature.f25612a;
            if (!BuiltinMethodsWithSpecialGenericSignature.m27135a(name)) {
                Collection arrayList = new ArrayList();
                for (Object next : a) {
                    if (m39855a((SimpleFunctionDescriptor) next)) {
                        arrayList.add(next);
                    }
                }
                m39850a((Collection) collection, name, (Collection) (List) arrayList, false);
                return;
            }
        }
        SmartSet.Companion companion = SmartSet.f26429a;
        SmartSet a2 = SmartSet.Companion.m28116a();
        Object next2 = DescriptorResolverUtils.m27176a(name, a, CollectionsKt__CollectionsKt.m26790a(), this.f39720b, ErrorReporter.f26251b);
        Intrinsics.m26843a(next2, "mergedFunctionFromSuperTypes");
        Name name2 = name;
        Collection<SimpleFunctionDescriptor> collection2 = collection;
        Collection collection3 = next2;
        m39853a(name2, collection2, collection3, collection, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$2(this));
        Intrinsics.m26843a(next2, "mergedFunctionFromSuperTypes");
        m39853a(name2, collection2, collection3, a2, new LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(this));
        Collection arrayList2 = new ArrayList();
        for (Object next3 : a) {
            if (m39855a((SimpleFunctionDescriptor) next3)) {
                arrayList2.add(next3);
            }
        }
        m39850a((Collection) collection, name, (Collection) CollectionsKt___CollectionsKt.m41423b((Collection) (List) arrayList2, (Iterable) a2), true);
    }

    private final void m39853a(Name name, Collection<? extends SimpleFunctionDescriptor> collection, Collection<? extends SimpleFunctionDescriptor> collection2, Collection<SimpleFunctionDescriptor> collection3, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        Iterator it;
        for (SimpleFunctionDescriptor a : collection2) {
            SimpleFunctionDescriptor a2 = (SimpleFunctionDescriptor) SpecialBuiltinMembers.m27167a(a2);
            if (a2 != null) {
                String d = SpecialBuiltinMembers.m27174d(a2);
                if (d == null) {
                    Intrinsics.m26842a();
                }
                Object a3 = Name.m27424a(d);
                Intrinsics.m26843a(a3, "Name.identifier(nameInJava)");
                for (SimpleFunctionDescriptor a4 : (Collection) function1.mo6492a(a3)) {
                    SimpleFunctionDescriptor a42 = m39847a(a42, name);
                    if (m39856a(a2, (FunctionDescriptor) a42)) {
                        collection3.add(m39846a(a42, (CallableDescriptor) a2, (Collection) collection));
                        break;
                    }
                }
            }
        }
        for (SimpleFunctionDescriptor a5 : collection2) {
            FunctionDescriptor a6 = BuiltinMethodsWithSpecialGenericSignature.m27133a((FunctionDescriptor) a5);
            if (a6 != null) {
                Object obj;
                SimpleFunctionDescriptor simpleFunctionDescriptor;
                Object i = a6.mo6689i();
                Intrinsics.m26843a(i, "overridden.name");
                it = ((Iterable) function1.mo6492a(i)).iterator();
                do {
                    simpleFunctionDescriptor = null;
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                } while (!m39862b((SimpleFunctionDescriptor) obj, a6));
                a2 = (SimpleFunctionDescriptor) obj;
                if (a2 != null) {
                    a2 = a2;
                    CopyBuilder C = a2.mo7736C();
                    Iterable<ValueParameterDescriptor> k = a6.mo7757k();
                    Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(k));
                    for (ValueParameterDescriptor x : k) {
                        arrayList.add(x.mo7777x());
                    }
                    arrayList = (List) arrayList;
                    obj = a2.mo7757k();
                    Intrinsics.m26843a(obj, "override.valueParameters");
                    C.mo5741a(UtilKt.m27194a(arrayList, (Collection) obj, a6));
                    C.mo5740a();
                    C.mo5752b();
                    simpleFunctionDescriptor = (SimpleFunctionDescriptor) C.mo5757f();
                }
                if (simpleFunctionDescriptor != null) {
                    simpleFunctionDescriptor = simpleFunctionDescriptor;
                    if (m39855a(simpleFunctionDescriptor)) {
                        collection3.add(m39846a(simpleFunctionDescriptor, (CallableDescriptor) a6, (Collection) collection));
                    }
                    collection2 = Unit.f25273a;
                }
            }
        }
    }

    private static SimpleFunctionDescriptor m39846a(SimpleFunctionDescriptor simpleFunctionDescriptor, CallableDescriptor callableDescriptor, Collection<? extends SimpleFunctionDescriptor> collection) {
        collection = collection.iterator();
        int i;
        do {
            int i2 = 0;
            i = 1;
            if (!collection.hasNext()) {
                i2 = 1;
                break;
            }
            Object obj = (SimpleFunctionDescriptor) collection.next();
            if ((Intrinsics.m26845a((Object) simpleFunctionDescriptor, obj) ^ 1) != 0 && obj.mo7762w() == null && m39854a((CallableDescriptor) obj, callableDescriptor)) {
                continue;
            } else {
                i = 0;
                continue;
            }
        } while (i == 0);
        if (i2 != 0) {
            return simpleFunctionDescriptor;
        }
        simpleFunctionDescriptor = simpleFunctionDescriptor.mo7736C().mo5755d().mo5757f();
        if (simpleFunctionDescriptor == null) {
            Intrinsics.m26842a();
        }
        return simpleFunctionDescriptor;
    }

    protected final void mo7262a(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(collection, "result");
        if (this.f39724j.mo7279g()) {
            JavaMethod javaMethod = (JavaMethod) CollectionsKt___CollectionsKt.m41442i((Iterable) ((DeclaredMemberIndex) this.f38426c.invoke()).mo5781a(name));
            if (javaMethod != null) {
                Modality modality = Modality.f25488a;
                Annotations a = LazyJavaAnnotationsKt.m27201a(this.f38427d, javaMethod);
                Object a2 = JavaPropertyDescriptor.m43089a(this.f39720b, a, modality, javaMethod.mo7102o(), false, javaMethod.mo7103p(), this.f38427d.f25703b.f25695k.mo5773a(javaMethod), false);
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor) a2;
                Annotations.Companion companion = Annotations.f32643a;
                PropertyGetterDescriptorImpl b = DescriptorFactory.m27634b(propertyDescriptor, Annotations.Companion.m27115a());
                a2.m42990a(b, null);
                LazyJavaResolverContext lazyJavaResolverContext = this.f38427d;
                Intrinsics.m26843a(a2, "propertyDescriptor");
                KotlinType a3 = LazyJavaScope.m38384a(javaMethod, a, ContextKt.m27198a(lazyJavaResolverContext, (DeclarationDescriptor) a2, javaMethod, 0));
                a2.m42991a(a3, CollectionsKt__CollectionsKt.m26790a(), mo7267d(), null);
                b.m43066a(a3);
                Intrinsics.m26843a(a2, "propertyDescriptor");
                collection.add(a2);
            }
        }
        Set b2 = m39858b(name);
        if (!b2.isEmpty()) {
            SmartSet.Companion companion2 = SmartSet.f26429a;
            SmartSet a4 = SmartSet.Companion.m28116a();
            m39852a(b2, (Collection) collection, (Function1) new LazyJavaClassMemberScope$computeNonDeclaredProperties$1(this));
            m39852a(b2, (Collection) a4, (Function1) new LazyJavaClassMemberScope$computeNonDeclaredProperties$2(this));
            Object a5 = DescriptorResolverUtils.m27176a(name, SetsKt___SetsKt.m32819a(b2, (Iterable) a4), collection, this.f39720b, this.f38427d.f25703b.f25691g);
            Intrinsics.m26843a(a5, "resolveOverridesForNonSt…components.errorReporter)");
            collection.addAll(a5);
        }
    }

    private final void m39852a(Set<? extends PropertyDescriptor> set, Collection<PropertyDescriptor> collection, Function1<? super Name, ? extends Collection<? extends SimpleFunctionDescriptor>> function1) {
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this;
        Function1 function12 = function1;
        for (PropertyDescriptor propertyDescriptor : set) {
            KotlinType kotlinType = null;
            if (m39864c(propertyDescriptor, function12)) {
                SimpleFunctionDescriptor b;
                SimpleFunctionDescriptor a = m39845a(propertyDescriptor, function12);
                if (a == null) {
                    Intrinsics.m26842a();
                }
                if (propertyDescriptor.mo7807y()) {
                    b = m39860b(propertyDescriptor, function12);
                    if (b == null) {
                        Intrinsics.m26842a();
                    }
                } else {
                    b = null;
                }
                boolean a2 = b != null ? Intrinsics.m26845a(b.aG_(), a.aG_()) : true;
                if (!_Assertions.f25274a || a2) {
                    DeclarationDescriptor declarationDescriptor = lazyJavaClassMemberScope.f39720b;
                    Annotations.Companion companion = Annotations.f32643a;
                    JavaPropertyDescriptor a3 = JavaPropertyDescriptor.m43089a(declarationDescriptor, Annotations.Companion.m27115a(), a.aG_(), a.mo7257j(), b != null, propertyDescriptor.mo6689i(), a.mo7258r(), false);
                    KotlinType aN_ = a.aN_();
                    if (aN_ == null) {
                        Intrinsics.m26842a();
                    }
                    a3.m42991a(aN_, CollectionsKt__CollectionsKt.m26790a(), mo7267d(), null);
                    PropertyDescriptor propertyDescriptor2 = a3;
                    PropertyGetterDescriptorImpl a4 = DescriptorFactory.m27630a(propertyDescriptor2, a.mo5718q(), false, a.mo7258r());
                    a4.f40930e = a;
                    a4.m43066a(a3.mo7777x());
                    if (b != null) {
                        b = b;
                        kotlinType = DescriptorFactory.m27632a(propertyDescriptor2, b.mo5718q(), false, b.mo7257j(), b.mo7258r());
                        kotlinType.f40930e = b;
                    }
                    Object obj = a3;
                    obj.m42990a(a4, (PropertySetterDescriptor) kotlinType);
                } else {
                    Object aG_;
                    StringBuilder stringBuilder = new StringBuilder();
                    StringBuilder stringBuilder2 = new StringBuilder("Different accessors modalities when creating overrides for ");
                    stringBuilder2.append(propertyDescriptor);
                    stringBuilder2.append(" in ");
                    stringBuilder2.append(lazyJavaClassMemberScope.f39720b);
                    stringBuilder.append(stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder("for getter is ");
                    stringBuilder2.append(a.aG_());
                    stringBuilder2.append(", but for setter is ");
                    if (b != null) {
                        aG_ = b.aG_();
                    }
                    stringBuilder2.append(aG_);
                    stringBuilder.append(stringBuilder2.toString());
                    throw new AssertionError(stringBuilder.toString());
                }
            }
            obj = null;
            if (obj != null) {
                collection.add(obj);
                return;
            }
            Collection<PropertyDescriptor> collection2 = collection;
        }
    }

    private static boolean m39862b(SimpleFunctionDescriptor simpleFunctionDescriptor, FunctionDescriptor functionDescriptor) {
        return Intrinsics.m26845a(MethodSignatureMappingKt.m27351a((FunctionDescriptor) simpleFunctionDescriptor, false), MethodSignatureMappingKt.m27351a(functionDescriptor.mo7761v(), false)) && m39854a((CallableDescriptor) simpleFunctionDescriptor, (CallableDescriptor) functionDescriptor) == null;
    }

    private final void m39851a(List<ValueParameterDescriptor> list, ConstructorDescriptor constructorDescriptor, int i, JavaMethod javaMethod, KotlinType kotlinType, KotlinType kotlinType2) {
        KotlinType c;
        CallableDescriptor callableDescriptor = constructorDescriptor;
        Annotations.Companion companion = Annotations.f32643a;
        Annotations a = Annotations.Companion.m27115a();
        Name p = javaMethod.mo7103p();
        Object c2 = TypeUtils.m28014c(kotlinType);
        Intrinsics.m26843a(c2, "TypeUtils.makeNotNullable(returnType)");
        boolean e = javaMethod.mo7291e();
        if (kotlinType2 != null) {
            c = TypeUtils.m28014c(kotlinType2);
        } else {
            c = null;
        }
        list.add(new ValueParameterDescriptorImpl(callableDescriptor, null, i, a, p, c2, e, false, false, c, this.f38427d.f25703b.f25695k.mo5773a(javaMethod)));
    }

    public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        m39866d(name, lookupLocation);
        return (ClassifierDescriptor) this.f39723i.mo6492a(name);
    }

    public final Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        m39866d(name, lookupLocation);
        return super.mo6698b(name, lookupLocation);
    }

    public final Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        m39866d(name, lookupLocation);
        return super.mo6694a(name, lookupLocation);
    }

    protected final Set<Name> mo7265c(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        return SetsKt___SetsKt.m32819a((Set) ((Map) this.f39721g.invoke()).keySet(), (Iterable) ((Map) this.f39722h.invoke()).keySet());
    }

    protected final Set<Name> mo7259a(DescriptorKindFilter descriptorKindFilter) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        if (this.f39724j.mo7279g() != null) {
            return aE_();
        }
        descriptorKindFilter = new LinkedHashSet(((DeclaredMemberIndex) this.f38426c.invoke()).mo5783b());
        for (KotlinType b : this.f39720b.mo7610c().aL_()) {
            CollectionsKt__MutableCollectionsKt.m38194a((Collection) descriptorKindFilter, (Iterable) b.mo6740b().aF_());
        }
        return (Set) ((Collection) descriptorKindFilter);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Lazy Java member scope for ");
        stringBuilder.append(this.f39724j.mo7274b());
        return stringBuilder.toString();
    }

    public final /* synthetic */ DeclaredMemberIndex mo7266c() {
        return new ClassDeclaredMemberIndex(this.f39724j, LazyJavaClassMemberScope$computeMemberIndex$1.f38389a);
    }

    private final void m39850a(Collection<SimpleFunctionDescriptor> collection, Name name, Collection<? extends SimpleFunctionDescriptor> collection2, boolean z) {
        Object a = DescriptorResolverUtils.m27176a(name, collection2, collection, this.f39720b, this.f38427d.f25703b.f25691g);
        if (z) {
            Intrinsics.m26843a(a, "additionalOverrides");
            Iterable<Object> iterable = (Iterable) a;
            collection2 = CollectionsKt___CollectionsKt.m41423b((Collection) collection, (Iterable) iterable);
            Collection collection3 = (Collection) new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (Object obj : iterable) {
                Object obj2;
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) SpecialBuiltinMembers.m27173c((CallableMemberDescriptor) obj2);
                if (simpleFunctionDescriptor != null) {
                    obj2 = m39846a((SimpleFunctionDescriptor) obj2, (CallableDescriptor) simpleFunctionDescriptor, (Collection) collection2);
                }
                collection3.add(obj2);
            }
            collection.addAll((List) collection3);
            return;
        }
        Intrinsics.m26843a(a, "additionalOverrides");
        collection.addAll(a);
    }

    private final Set<SimpleFunctionDescriptor> m39843a(Name name) {
        Collection linkedHashSet = new LinkedHashSet();
        for (KotlinType b : this.f39720b.mo7610c().aL_()) {
            CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) b.mo6740b().mo6698b(name, NoLookupLocation.f32685o));
        }
        return (Set) linkedHashSet;
    }

    private final Set<PropertyDescriptor> m39858b(Name name) {
        Collection arrayList = new ArrayList();
        for (KotlinType b : this.f39720b.mo7610c().aL_()) {
            Iterable<PropertyDescriptor> a = b.mo6740b().mo6694a(name, NoLookupLocation.f32685o);
            Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
            for (PropertyDescriptor add : a) {
                arrayList2.add(add);
            }
            CollectionsKt__MutableCollectionsKt.m38194a(arrayList, (Iterable) (List) arrayList2);
        }
        return CollectionsKt___CollectionsKt.m41451p((List) arrayList);
    }

    protected final MethodSignatureData mo7260a(JavaMethod javaMethod, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics.m26847b(javaMethod, "method");
        Intrinsics.m26847b(list, "methodTypeParameters");
        Intrinsics.m26847b(kotlinType, "returnType");
        Intrinsics.m26847b(list2, "valueParameters");
        javaMethod = this.f38427d.f25703b.f25690f.mo5776a(javaMethod, this.f39720b, kotlinType, list2, list);
        Object obj = javaMethod.f25663a;
        if (obj == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getReturnType"}));
        }
        Intrinsics.m26843a(obj, "propagated.returnType");
        KotlinType kotlinType2 = javaMethod.f25664b;
        Object obj2 = javaMethod.f25665c;
        if (obj2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getValueParameters"}));
        }
        Intrinsics.m26843a(obj2, "propagated.valueParameters");
        Object obj3 = javaMethod.f25666d;
        if (obj3 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getTypeParameters"}));
        }
        Intrinsics.m26843a(obj3, "propagated.typeParameters");
        boolean z = javaMethod.f25668f;
        Object obj4 = javaMethod.f25667e;
        if (obj4 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getErrors"}));
        }
        Intrinsics.m26843a(obj4, "propagated.errors");
        return new MethodSignatureData(obj, kotlinType2, obj2, obj3, z, obj4);
    }

    protected final ReceiverParameterDescriptor mo7267d() {
        return DescriptorUtils.m27641a((DeclarationDescriptor) this.f39720b);
    }

    private final void m39866d(Name name, LookupLocation lookupLocation) {
        UtilsKt.m27123a(this.f38427d.f25703b.f25699o, lookupLocation, this.f39720b, name);
    }

    public final /* bridge */ /* synthetic */ DeclarationDescriptor mo7268e() {
        return this.f39720b;
    }

    public static final /* synthetic */ Collection m39842a(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        Iterable<JavaMethod> a = ((DeclaredMemberIndex) lazyJavaClassMemberScope.f38426c.invoke()).mo5781a(name);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (JavaMethod a2 : a) {
            arrayList.add(lazyJavaClassMemberScope.m38390a(a2));
        }
        return (List) arrayList;
    }

    public static final /* synthetic */ Collection m39857b(LazyJavaClassMemberScope lazyJavaClassMemberScope, Name name) {
        Iterable a = lazyJavaClassMemberScope.m39843a(name);
        Collection collection = (Collection) new ArrayList();
        for (Object next : a) {
            Object obj;
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) next;
            if (!SpecialBuiltinMembers.m27172b(simpleFunctionDescriptor)) {
                if (BuiltinMethodsWithSpecialGenericSignature.m27133a((FunctionDescriptor) simpleFunctionDescriptor) == null) {
                    obj = null;
                    if (obj == null) {
                        collection.add(next);
                    }
                }
            }
            obj = 1;
            if (obj == null) {
                collection.add(next);
            }
        }
        return (List) collection;
    }

    public static final /* synthetic */ JavaClassConstructorDescriptor m39848a(LazyJavaClassMemberScope lazyJavaClassMemberScope, JavaConstructor javaConstructor) {
        ClassDescriptor classDescriptor = lazyJavaClassMemberScope.f39720b;
        JavaElement javaElement = javaConstructor;
        Object a = JavaClassConstructorDescriptor.m43080a(classDescriptor, LazyJavaAnnotationsKt.m27201a(lazyJavaClassMemberScope.f38427d, javaConstructor), false, lazyJavaClassMemberScope.f38427d.f25703b.f25695k.mo5773a(javaElement));
        lazyJavaClassMemberScope = lazyJavaClassMemberScope.f38427d;
        Intrinsics.m26843a(a, "constructorDescriptor");
        lazyJavaClassMemberScope = ContextKt.m27198a(lazyJavaClassMemberScope, (DeclarationDescriptor) a, javaConstructor, classDescriptor.mo7719s().size());
        Intrinsics.m26843a(a, "constructorDescriptor");
        ResolvedValueParameters a2 = LazyJavaScope.m38383a((LazyJavaResolverContext) lazyJavaClassMemberScope, (FunctionDescriptor) a, javaConstructor.mo7285b());
        Collection s = classDescriptor.mo7719s();
        Iterable<JavaTypeParameter> q = javaConstructor.mo7284q();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(q));
        for (JavaTypeParameter a3 : q) {
            TypeParameterDescriptor a4 = lazyJavaClassMemberScope.f25704c.mo5779a(a3);
            if (a4 == null) {
                Intrinsics.m26842a();
            }
            arrayList.add(a4);
        }
        a.m42890a(a2.f25714a, (Visibility) javaConstructor.mo7102o(), CollectionsKt___CollectionsKt.m41423b(s, (Iterable) (List) arrayList));
        a.mo7836a(false);
        a.mo7838b(a2.f25715b);
        a.m42608a((KotlinType) classDescriptor.mo7714h());
        lazyJavaClassMemberScope.f25703b.f25692h.recordConstructor(javaElement, (ConstructorDescriptor) a);
        Intrinsics.m26843a(a, "constructorDescriptor");
        return a;
    }

    public static final /* synthetic */ ClassConstructorDescriptor m39859b(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        LazyJavaScope lazyJavaScope = lazyJavaClassMemberScope;
        boolean g = lazyJavaScope.f39724j.mo7279g();
        if (lazyJavaScope.f39724j.mo7278f() && !g) {
            return null;
        }
        List list;
        ClassDescriptor classDescriptor = lazyJavaScope.f39720b;
        Annotations.Companion companion = Annotations.f32643a;
        Object a = JavaClassConstructorDescriptor.m43080a(classDescriptor, Annotations.Companion.m27115a(), true, lazyJavaScope.f38427d.f25703b.f25695k.mo5773a(lazyJavaScope.f39724j));
        if (g) {
            Intrinsics.m26843a(a, "constructorDescriptor");
            ClassConstructorDescriptorImpl classConstructorDescriptorImpl = (ClassConstructorDescriptorImpl) a;
            Collection i = lazyJavaScope.f39724j.mo7281i();
            ArrayList arrayList = new ArrayList(i.size());
            JavaTypeAttributes a2 = JavaTypeResolverKt.m27226a(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, true, null, 4);
            Iterable iterable = i;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (Object next : iterable) {
                if (Intrinsics.m26845a(((JavaMethod) next).mo7103p(), JvmAnnotationNames.f25632c)) {
                    arrayList2.add(next);
                } else {
                    arrayList3.add(next);
                }
            }
            Pair pair = new Pair(arrayList2, arrayList3);
            List list2 = (List) pair.f25267a;
            List list3 = (List) pair.f25268b;
            g = list2.size() <= 1;
            if (!_Assertions.f25274a || g) {
                JavaMethod javaMethod;
                JavaMethod javaMethod2 = (JavaMethod) CollectionsKt___CollectionsKt.m41434e(list2);
                if (javaMethod2 != null) {
                    Pair pair2;
                    JavaType aS_ = javaMethod2.aS_();
                    if (aS_ instanceof JavaArrayType) {
                        JavaArrayType javaArrayType = (JavaArrayType) aS_;
                        pair2 = new Pair(lazyJavaScope.f38427d.f25702a.m27224a(javaArrayType, a2, true), lazyJavaScope.f38427d.f25702a.m27225a(javaArrayType.mo6706a(), a2));
                    } else {
                        pair2 = new Pair(lazyJavaScope.f38427d.f25702a.m27225a(aS_, a2), null);
                    }
                    javaMethod = javaMethod2;
                    lazyJavaScope.m39851a(arrayList, classConstructorDescriptorImpl, 0, javaMethod2, (KotlinType) pair2.f25267a, (KotlinType) pair2.f25268b);
                } else {
                    javaMethod = javaMethod2;
                }
                int i2 = javaMethod != null ? 1 : 0;
                for (IndexedValue indexedValue : CollectionsKt___CollectionsKt.m41452q(list3)) {
                    JavaMethod javaMethod3 = (JavaMethod) indexedValue.f25278b;
                    lazyJavaScope.m39851a(arrayList, classConstructorDescriptorImpl, indexedValue.f25277a + i2, javaMethod3, lazyJavaScope.f38427d.f25702a.m27225a(javaMethod3.aS_(), a2), null);
                }
                list = arrayList;
            } else {
                StringBuilder stringBuilder = new StringBuilder("There can't be more than one method named 'value' in annotation class: ");
                stringBuilder.append(lazyJavaScope.f39724j);
                throw new AssertionError(stringBuilder.toString());
            }
        }
        list = Collections.emptyList();
        a.mo7838b(false);
        Visibility j = classDescriptor.mo7257j();
        if (Intrinsics.m26845a((Object) j, JavaVisibilities.f25627b)) {
            j = JavaVisibilities.f25628c;
            Intrinsics.m26843a((Object) j, "JavaVisibilities.PROTECTED_AND_PACKAGE");
        } else {
            Intrinsics.m26843a((Object) j, "visibility");
        }
        a.m42889a(list, j);
        a.mo7836a(true);
        a.m42608a((KotlinType) classDescriptor.mo7714h());
        lazyJavaScope.f38427d.f25703b.f25692h.recordConstructor(lazyJavaScope.f39724j, (ConstructorDescriptor) a);
        return (ClassConstructorDescriptor) a;
    }
}
