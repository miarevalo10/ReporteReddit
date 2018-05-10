package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.platform.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses.MockClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor extends ClassDescriptorBase implements JavaClassDescriptor {
    static final /* synthetic */ KProperty[] f40955g = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LazyJavaClassDescriptor.class), "annotations", "getAnnotations()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    public final LazyJavaResolverContext f40956a;
    public final LazyJavaClassMemberScope f40957b;
    final InnerClassesScopeWrapper f40958c;
    public final JavaClass f40959f;
    private final ClassKind f40960h;
    private final Modality f40961i;
    private final Visibility f40962j;
    private final boolean f40963k;
    private final NotNullLazyValue<LazyJavaClassTypeConstructor> f40964l;
    private final LazyJavaStaticClassScope f40965m;
    private final NotNullLazyValue f40966n;
    private final NotNullLazyValue<List<TypeParameterDescriptor>> f40967o;
    private final LazyJavaResolverContext f40968p;
    private final ClassDescriptor f40969q;

    /* compiled from: LazyJavaClassDescriptor.kt */
    private final class LazyJavaClassTypeConstructor extends AbstractClassTypeConstructor {
        final /* synthetic */ LazyJavaClassDescriptor f38384a;
        private final NotNullLazyValue<List<TypeParameterDescriptor>> f38385b;

        public LazyJavaClassTypeConstructor(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
            this.f38384a = lazyJavaClassDescriptor;
            super(lazyJavaClassDescriptor.f40956a.f25703b.f25685a);
            this.f38385b = lazyJavaClassDescriptor.f40956a.f25703b.f25685a.mo5926a((Function0) new C2938xbaf55d8a(this));
        }

        public final List<TypeParameterDescriptor> mo5723b() {
            return (List) this.f38385b.invoke();
        }

        protected final Collection<KotlinType> mo6684a() {
            Object obj;
            List a;
            Collection c = this.f38384a.f40959f.mo7275c();
            ArrayList arrayList = new ArrayList(c.size());
            ArrayList arrayList2 = new ArrayList(0);
            Object i = m38359i();
            Iterator it = c.iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                JavaClassifierType javaClassifierType = (JavaClassifierType) it.next();
                KotlinType a2 = this.f38384a.f40956a.f25702a.m27225a((JavaType) javaClassifierType, JavaTypeResolverKt.m27226a(TypeUsage.SUPERTYPE, false, false, null, 7));
                if (a2.mo6743g().mo5724c() instanceof MockClassDescriptor) {
                    arrayList2.add(javaClassifierType);
                }
                Object g = a2.mo6743g();
                if (i != null) {
                    obj = i.mo6743g();
                }
                if (!(Intrinsics.m26845a(g, obj) || KotlinBuiltIns.m26991g(a2))) {
                    arrayList.add(a2);
                }
            }
            Collection collection = arrayList;
            ClassDescriptor c2 = this.f38384a.f40969q;
            if (c2 != null) {
                c2 = c2;
                obj = MappingUtilKt.m27447a(c2, this.f38384a).m27987d().m28005b((KotlinType) c2.mo7714h(), Variance.f26337a);
            }
            CollectionsKt.m28092a(collection, obj);
            CollectionsKt.m28092a(collection, i);
            if ((arrayList2.isEmpty() ^ 1) != 0) {
                ErrorReporter errorReporter = this.f38384a.f40956a.f25703b.f25691g;
                ClassDescriptor classDescriptor = this.f38384a;
                Iterable<JavaType> iterable = arrayList2;
                Collection arrayList3 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (JavaType javaType : iterable) {
                    if (javaType == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    }
                    arrayList3.add(((JavaClassifierType) javaType).mo7097f());
                }
                errorReporter.mo5772a(classDescriptor, (List) arrayList3);
            }
            if ((collection.isEmpty() ^ 1) != 0) {
                a = CollectionsKt.m28089a(collection);
            } else {
                a = CollectionsKt__CollectionsKt.m26791a((Object) this.f38384a.f40956a.f25703b.f25700p.mo7089b().m27015m());
            }
            return a;
        }

        protected final SupertypeLoopChecker aK_() {
            return this.f38384a.f40956a.f25703b.f25698n;
        }

        public final boolean mo5725d() {
            return ModalityKt.m27079a(this.f38384a);
        }

        public final String toString() {
            Object a = this.f38384a.mo6689i().m27429a();
            Intrinsics.m26843a(a, "getName().asString()");
            return a;
        }

        private final KotlinType m38359i() {
            Object fqName;
            FqName fqName2;
            FqName a;
            ClassDescriptor a2;
            int size;
            List b;
            int size2;
            Collection arrayList;
            Iterator it;
            List list;
            Annotations q = this.f38384a.mo5718q();
            Object obj = JvmAnnotationNames.f25637h;
            Intrinsics.m26843a(obj, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor a3 = q.mo6679a(obj);
            if (a3 != null) {
                Object i = CollectionsKt___CollectionsKt.m41442i((Iterable) a3.mo5720b().values());
                if (!(i instanceof StringValue)) {
                    i = null;
                }
                StringValue stringValue = (StringValue) i;
                if (stringValue != null) {
                    String str = (String) stringValue.mo5919b();
                    if (str != null) {
                        if (FqNamesUtilKt.m27423a(str)) {
                            fqName = new FqName(str);
                            fqName2 = fqName == null ? (FqName) AddToStdlibKt.m28126a(fqName, C2937xcb5175b1.f38382a) : null;
                            if (fqName2 != null) {
                                FakePureImplementationsProvider fakePureImplementationsProvider = FakePureImplementationsProvider.f25624a;
                                a = FakePureImplementationsProvider.m27142a(DescriptorUtilsKt.m27742b(this.f38384a));
                            } else {
                                a = fqName2;
                            }
                            if (a == null) {
                                return null;
                            }
                            a2 = DescriptorUtilsKt.m27735a(this.f38384a.f40956a.f25703b.f25700p, a, NoLookupLocation.f32689s);
                            if (a2 == null) {
                                return null;
                            }
                            size = a2.mo7610c().mo5723b().size();
                            b = this.f38384a.mo7610c().mo5723b();
                            size2 = b.size();
                            if (size2 != size) {
                                Iterable<TypeParameterDescriptor> iterable = b;
                                arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                                for (TypeParameterDescriptor h : iterable) {
                                    arrayList.add(new TypeProjectionImpl(Variance.f26337a, h.mo7714h()));
                                }
                                list = (List) arrayList;
                            } else if (size2 == 1 || size <= 1 || fqName2 != null) {
                                return null;
                            } else {
                                TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(Variance.f26337a, ((TypeParameterDescriptor) CollectionsKt___CollectionsKt.m41441h(b)).mo7714h());
                                Iterable intRange = new IntRange(1, size);
                                Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(intRange));
                                it = intRange.iterator();
                                while (it.hasNext()) {
                                    ((IntIterator) it).mo6663a();
                                    arrayList2.add(typeProjectionImpl);
                                }
                                list = (List) arrayList2;
                            }
                            Companion companion = Annotations.f32643a;
                            return KotlinTypeFactory.m27950a(Companion.m27115a(), a2, list);
                        }
                    }
                }
            }
            fqName = null;
            if (fqName == null) {
            }
            if (fqName2 != null) {
                a = fqName2;
            } else {
                FakePureImplementationsProvider fakePureImplementationsProvider2 = FakePureImplementationsProvider.f25624a;
                a = FakePureImplementationsProvider.m27142a(DescriptorUtilsKt.m27742b(this.f38384a));
            }
            if (a == null) {
                return null;
            }
            a2 = DescriptorUtilsKt.m27735a(this.f38384a.f40956a.f25703b.f25700p, a, NoLookupLocation.f32689s);
            if (a2 == null) {
                return null;
            }
            size = a2.mo7610c().mo5723b().size();
            b = this.f38384a.mo7610c().mo5723b();
            size2 = b.size();
            if (size2 != size) {
                if (size2 == 1) {
                }
                return null;
            }
            Iterable<TypeParameterDescriptor> iterable2 = b;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable2));
            while (it.hasNext()) {
                arrayList.add(new TypeProjectionImpl(Variance.f26337a, h.mo7714h()));
            }
            list = (List) arrayList;
            Companion companion2 = Annotations.f32643a;
            return KotlinTypeFactory.m27950a(Companion.m27115a(), a2, list);
        }

        public final /* bridge */ /* synthetic */ ClassifierDescriptor mo5724c() {
            return this.f38384a;
        }
    }

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

    public final Annotations mo5718q() {
        return (Annotations) StorageKt.m27920a(this.f40966n, f40955g[0]);
    }

    public final /* synthetic */ Collection mo7770f() {
        return m43035w();
    }

    public final ClassKind mo7771g() {
        return this.f40960h;
    }

    public final Modality aG_() {
        return this.f40961i;
    }

    public final Visibility mo7257j() {
        return (Intrinsics.m26845a(this.f40962j, Visibilities.f25504a) && this.f40959f.mo7277e() == null) ? JavaVisibilities.f25626a : this.f40962j;
    }

    public final boolean mo7742l() {
        return this.f40963k;
    }

    public final TypeConstructor mo7610c() {
        return (TypeConstructor) this.f40964l.invoke();
    }

    public final MemberScope mo7739t() {
        return this.f40958c;
    }

    public final MemberScope mo7767b() {
        return this.f40965m;
    }

    public final List<ClassConstructorDescriptor> m43035w() {
        return (List) this.f40957b.f39719a.invoke();
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        return (List) this.f40967o.invoke();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Lazy Java class ");
        stringBuilder.append(DescriptorUtilsKt.m27738a((DeclarationDescriptor) this));
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ MemberScope mo7768d() {
        return this.f40957b;
    }

    public LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(lazyJavaResolverContext, "outerContext");
        Intrinsics.m26847b(declarationDescriptor, "containingDeclaration");
        Intrinsics.m26847b(javaClass, "jClass");
        super(lazyJavaResolverContext.f25703b.f25685a, declarationDescriptor, javaClass.mo7103p(), lazyJavaResolverContext.f25703b.f25695k.mo5773a(javaClass));
        this.f40968p = lazyJavaResolverContext;
        this.f40959f = javaClass;
        this.f40969q = classDescriptor;
        this.f40956a = ContextKt.m27198a(this.f40968p, this, this.f40959f, 0);
        ClassDescriptor classDescriptor2 = this;
        this.f40956a.f25703b.f25692h.recordClass(this.f40959f, classDescriptor2);
        lazyJavaResolverContext = _Assertions.f25274a;
        if (this.f40959f.mo7279g() != null) {
            lazyJavaResolverContext = ClassKind.ANNOTATION_CLASS;
        } else if (this.f40959f.mo7278f() != null) {
            lazyJavaResolverContext = ClassKind.INTERFACE;
        } else if (this.f40959f.mo7280h() != null) {
            lazyJavaResolverContext = ClassKind.ENUM_CLASS;
        } else {
            lazyJavaResolverContext = ClassKind.CLASS;
        }
        this.f40960h = lazyJavaResolverContext;
        declarationDescriptor = null;
        if (this.f40959f.mo7279g() != null) {
            lazyJavaResolverContext = Modality.f25488a;
        } else {
            lazyJavaResolverContext = Modality.f25492e;
            if (this.f40959f.mo7099l() == null) {
                if (this.f40959f.mo7278f() == null) {
                    lazyJavaResolverContext = null;
                    lazyJavaResolverContext = Modality.Companion.m27078a(lazyJavaResolverContext, this.f40959f.mo7101n() ^ true);
                }
            }
            lazyJavaResolverContext = 1;
            lazyJavaResolverContext = Modality.Companion.m27078a(lazyJavaResolverContext, this.f40959f.mo7101n() ^ true);
        }
        this.f40961i = lazyJavaResolverContext;
        this.f40962j = this.f40959f.mo7102o();
        if (this.f40959f.mo7277e() != null && this.f40959f.mo7100m() == null) {
            declarationDescriptor = 1;
        }
        this.f40963k = declarationDescriptor;
        this.f40964l = this.f40956a.f25703b.f25685a.mo5926a((Function0) new LazyJavaClassDescriptor$typeConstructor$1(this));
        this.f40957b = new LazyJavaClassMemberScope(this.f40956a, classDescriptor2, this.f40959f);
        this.f40958c = new InnerClassesScopeWrapper((MemberScope) this.f40957b);
        this.f40965m = new LazyJavaStaticClassScope(this.f40956a, this.f40959f, this);
        this.f40966n = this.f40956a.f25703b.f25685a.mo5926a((Function0) new LazyJavaClassDescriptor$annotations$2(this));
        this.f40967o = this.f40956a.f25703b.f25685a.mo5926a((Function0) new LazyJavaClassDescriptor$declaredParameters$1(this));
    }
}
