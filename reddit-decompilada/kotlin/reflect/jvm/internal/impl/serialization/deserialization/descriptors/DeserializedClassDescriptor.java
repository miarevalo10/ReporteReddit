package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses.MockClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor {
    public final ClassKind f40868a = Deserialization.m27827a((Kind) Flags.f26154e.mo5920b(this.f40872g.f40315e));
    public final DeserializationContext f40869b;
    public final DeserializedClassMemberScope f40870c;
    public final Class f40871f;
    public final ProtoBuf.Class f40872g;
    private final ClassId f40873h;
    private final Modality f40874i = Deserialization.m27828a((ProtoBuf.Modality) Flags.f26153d.mo5920b(this.f40872g.f40315e));
    private final Visibility f40875j = Deserialization.m27829a((ProtoBuf.Visibility) Flags.f26152c.mo5920b(this.f40872g.f40315e));
    private final MemberScopeImpl f40876k;
    private final DeserializedClassTypeConstructor f40877l;
    private final EnumEntryClassDescriptors f40878m;
    private final DeclarationDescriptor f40879n;
    private final NullableLazyValue<ClassConstructorDescriptor> f40880o;
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> f40881p;
    private final NullableLazyValue<ClassDescriptor> f40882q;
    private final NotNullLazyValue<Collection<ClassDescriptor>> f40883r;
    private final Annotations f40884s;
    private final SourceElement f40885t;

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class EnumEntryClassDescriptors {
        final Map<Name, EnumEntry> f26277a;
        final /* synthetic */ DeserializedClassDescriptor f26278b;
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> f26279c;
        private final NotNullLazyValue<Set<Name>> f26280d;

        public EnumEntryClassDescriptors(DeserializedClassDescriptor deserializedClassDescriptor) {
            this.f26278b = deserializedClassDescriptor;
            Iterable iterable = deserializedClassDescriptor.f40872g.f40326p;
            Map linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.m32855c(MapsKt__MapsKt.m36115a(CollectionsKt__IterablesKt.m32812b(iterable)), 16));
            for (Object next : iterable) {
                linkedHashMap.put(this.f26278b.f40869b.f26246d.mo5830b(((EnumEntry) next).f40354e), next);
            }
            this.f26277a = linkedHashMap;
            this.f26279c = deserializedClassDescriptor.f40869b.f26245c.f26229b.mo5930b((Function1) new C2998xaf8327b7(this));
            this.f26280d = deserializedClassDescriptor.f40869b.f26245c.f26229b.mo5926a((Function0) new C2999xaaca1f71(this));
        }

        public final ClassDescriptor m27895a(Name name) {
            Intrinsics.m26847b(name, "name");
            return (ClassDescriptor) this.f26279c.mo6492a(name);
        }

        public static final /* synthetic */ Set m27894c(EnumEntryClassDescriptors enumEntryClassDescriptors) {
            HashSet hashSet = new HashSet();
            for (KotlinType b : enumEntryClassDescriptors.f26278b.mo7610c().aL_()) {
                for (DeclarationDescriptor declarationDescriptor : DefaultImpls.m27789a(b.mo6740b(), null, null, 3)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.mo6689i());
                    }
                }
            }
            for (Function function : enumEntryClassDescriptors.f26278b.f40872g.f40323m) {
                Collection collection = hashSet;
                Object b2 = enumEntryClassDescriptors.f26278b.f40869b.f26246d.mo5830b(function.f40375g);
                Intrinsics.m26843a(b2, "c.nameResolver.getName(it.name)");
                collection.add(b2);
            }
            Collection collection2 = hashSet;
            Set set = (Set) collection2;
            for (Property property : enumEntryClassDescriptors.f26278b.f40872g.f40324n) {
                Object b3 = enumEntryClassDescriptors.f26278b.f40869b.f26246d.mo5830b(property.f40422g);
                Intrinsics.m26843a(b3, "c.nameResolver.getName(it.name)");
                collection2.add(b3);
            }
            return SetsKt___SetsKt.m32819a(set, (Iterable) collection2);
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        final /* synthetic */ DeserializedClassDescriptor f38875a;
        private final NotNullLazyValue<List<TypeParameterDescriptor>> f38876b;

        public DeserializedClassTypeConstructor(DeserializedClassDescriptor deserializedClassDescriptor) {
            this.f38875a = deserializedClassDescriptor;
            super(deserializedClassDescriptor.f40869b.f26245c.f26229b);
            this.f38876b = deserializedClassDescriptor.f40869b.f26245c.f26229b.mo5926a((Function0) new C2996x32944d2c(this));
        }

        protected final Collection<KotlinType> mo6684a() {
            Iterable<Type> a = ProtoTypeTableUtilKt.m27866a(this.f38875a.f40872g, this.f38875a.f40869b.f26248f);
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
            for (Type a2 : a) {
                arrayList.add(Annotations.f32643a);
            }
            List<KotlinType> b = CollectionsKt___CollectionsKt.m41423b((Collection) (List) arrayList, (Iterable) this.f38875a.f40869b.f26245c.f26240m.mo5825a(this.f38875a));
            Collection arrayList2 = new ArrayList();
            for (KotlinType g : b) {
                ClassifierDescriptor c = g.mo6743g().mo5724c();
                if (!(c instanceof MockClassDescriptor)) {
                    c = null;
                }
                MockClassDescriptor mockClassDescriptor = (MockClassDescriptor) c;
                if (mockClassDescriptor != null) {
                    arrayList2.add(mockClassDescriptor);
                }
            }
            List list = (List) arrayList2;
            if ((list.isEmpty() ^ 1) != 0) {
                ErrorReporter errorReporter = this.f38875a.f40869b.f26245c.f26235h;
                ClassDescriptor classDescriptor = this.f38875a;
                Iterable<MockClassDescriptor> iterable = list;
                Collection arrayList3 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (MockClassDescriptor mockClassDescriptor2 : iterable) {
                    Object a3;
                    ClassId a4 = DescriptorUtilsKt.m27736a((ClassifierDescriptorWithTypeParameters) mockClassDescriptor2);
                    if (a4 != null) {
                        FqName f = a4.m27403f();
                        if (f != null) {
                            a3 = f.m27407a();
                            if (a3 != null) {
                                arrayList3.add(a3);
                            }
                        }
                    }
                    a3 = mockClassDescriptor2.mo6689i().m27429a();
                    arrayList3.add(a3);
                }
                errorReporter.mo5772a(classDescriptor, (List) arrayList3);
            }
            return CollectionsKt.m28089a((Collection) b);
        }

        public final List<TypeParameterDescriptor> mo5723b() {
            return (List) this.f38876b.invoke();
        }

        public final boolean mo5725d() {
            return ModalityKt.m27079a(this.f38875a);
        }

        public final String toString() {
            return this.f38875a.mo6689i().toString();
        }

        protected final SupertypeLoopChecker aK_() {
            return EMPTY.f32638a;
        }

        public final /* bridge */ /* synthetic */ ClassifierDescriptor mo5724c() {
            return this.f38875a;
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassMemberScope extends DeserializedMemberScope {
        final /* synthetic */ DeserializedClassDescriptor f39877a;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> f39878d;

        public DeserializedClassMemberScope(DeserializedClassDescriptor deserializedClassDescriptor) {
            this.f39877a = deserializedClassDescriptor;
            DeserializationContext deserializationContext = deserializedClassDescriptor.f40869b;
            Object obj = deserializedClassDescriptor.f40872g.f40323m;
            Intrinsics.m26843a(obj, "classProto.functionList");
            Collection collection = (Collection) obj;
            obj = deserializedClassDescriptor.f40872g.f40324n;
            Intrinsics.m26843a(obj, "classProto.propertyList");
            Collection collection2 = (Collection) obj;
            obj = deserializedClassDescriptor.f40872g.f40325o;
            Intrinsics.m26843a(obj, "classProto.typeAliasList");
            Collection collection3 = (Collection) obj;
            Iterable<Number> iterable = deserializedClassDescriptor.f40872g.f40321k;
            deserializedClassDescriptor = deserializedClassDescriptor.f40869b.f26246d;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (Number intValue : iterable) {
                arrayList.add(((NameResolver) deserializedClassDescriptor).mo5830b(intValue.intValue()));
            }
            super(deserializationContext, collection, collection2, collection3, (Function0) new DeserializedClassDescriptor$DeserializedClassMemberScope$2$1((List) arrayList));
            this.f39878d = this.f38901b.f26245c.f26229b.mo5926a((Function0) new C2994xb586494b(this));
        }

        public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
            Intrinsics.m26847b(function1, "nameFilter");
            return (Collection) this.f39878d.invoke();
        }

        public final Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
            Intrinsics.m26847b(name, "name");
            Intrinsics.m26847b(lookupLocation, "location");
            m40260d(name, lookupLocation);
            return super.mo6698b(name, lookupLocation);
        }

        public final Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
            Intrinsics.m26847b(name, "name");
            Intrinsics.m26847b(lookupLocation, "location");
            m40260d(name, lookupLocation);
            return super.mo6694a(name, lookupLocation);
        }

        protected final void mo7308a(Name name, Collection<SimpleFunctionDescriptor> collection) {
            Intrinsics.m26847b(name, "name");
            Intrinsics.m26847b(collection, "functions");
            ArrayList arrayList = new ArrayList();
            for (KotlinType b : this.f39877a.mo7610c().aL_()) {
                arrayList.addAll(b.mo6740b().mo6698b(name, NoLookupLocation.f32682l));
            }
            CollectionsKt__MutableCollectionsKt.m38196b((Iterable) collection, (Function1) new C2995x1ddbb2bd(this));
            collection.addAll(this.f38901b.f26245c.f26240m.mo5824a(name, this.f39877a));
            m40259a(name, arrayList, collection);
        }

        protected final void mo7309b(Name name, Collection<PropertyDescriptor> collection) {
            Intrinsics.m26847b(name, "name");
            Intrinsics.m26847b(collection, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (KotlinType b : this.f39877a.mo7610c().aL_()) {
                arrayList.addAll(b.mo6740b().mo6694a(name, NoLookupLocation.f32682l));
            }
            m40259a(name, arrayList, collection);
        }

        private final <D extends CallableMemberDescriptor> void m40259a(Name name, Collection<? extends D> collection, Collection<D> collection2) {
            OverridingUtil.m27695a(name, collection, new ArrayList(collection2), this.f39877a, new C2790xf150c8cf(collection2));
        }

        public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
            Intrinsics.m26847b(name, "name");
            Intrinsics.m26847b(lookupLocation, "location");
            m40260d(name, lookupLocation);
            EnumEntryClassDescriptors b = this.f39877a.f40878m;
            if (b != null) {
                ClassDescriptor a = b.m27895a(name);
                if (a != null) {
                    return a;
                }
            }
            return super.mo6699c(name, lookupLocation);
        }

        protected final ClassId mo7306a(Name name) {
            Intrinsics.m26847b(name, "name");
            return this.f39877a.f40873h.m27397a(name);
        }

        protected final Set<Name> mo7310c() {
            Collection linkedHashSet = new LinkedHashSet();
            for (KotlinType b : this.f39877a.f40877l.m33577h()) {
                CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) b.mo6740b().aE_());
            }
            ((LinkedHashSet) linkedHashSet).addAll(this.f38901b.f26245c.f26240m.mo5827b(this.f39877a));
            return (Set) linkedHashSet;
        }

        protected final Set<Name> mo7311d() {
            Collection linkedHashSet = new LinkedHashSet();
            for (KotlinType b : this.f39877a.f40877l.m33577h()) {
                CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) b.mo6740b().aF_());
            }
            return (Set) linkedHashSet;
        }

        protected final void mo7307a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
            Collection arrayList;
            Intrinsics.m26847b(collection, "result");
            Intrinsics.m26847b(function1, "nameFilter");
            function1 = this.f39877a.f40878m;
            if (function1 != null) {
                arrayList = new ArrayList();
                for (Name name : function1.f26277a.keySet()) {
                    Intrinsics.m26843a((Object) name, "name");
                    ClassDescriptor a = function1.m27895a(name);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                arrayList = (List) arrayList;
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                arrayList = CollectionsKt__CollectionsKt.m26790a();
            }
            collection.addAll(arrayList);
        }

        private final void m40260d(Name name, LookupLocation lookupLocation) {
            UtilsKt.m27123a(this.f38901b.f26245c.f26236i, lookupLocation, (ClassDescriptor) this.f39877a, name);
        }
    }

    public final boolean mo7743n() {
        return false;
    }

    public final boolean mo7744o() {
        return false;
    }

    public final Annotations mo5718q() {
        return this.f40884s;
    }

    public final DeclarationDescriptor aD_() {
        return this.f40879n;
    }

    public final TypeConstructor mo7610c() {
        return this.f40877l;
    }

    public final ClassKind mo7771g() {
        return this.f40868a;
    }

    public final Modality aG_() {
        return this.f40874i;
    }

    public final Visibility mo7257j() {
        return this.f40875j;
    }

    public final MemberScope mo7768d() {
        return this.f40870c;
    }

    public final boolean mo7772k() {
        return Intrinsics.m26845a((Kind) Flags.f26154e.mo5920b(this.f40872g.f40315e), Kind.COMPANION_OBJECT);
    }

    public final ClassConstructorDescriptor aH_() {
        return (ClassConstructorDescriptor) this.f40880o.invoke();
    }

    public final Collection<ClassConstructorDescriptor> mo7770f() {
        return (Collection) this.f40881p.invoke();
    }

    public final ClassDescriptor mo7769e() {
        return (ClassDescriptor) this.f40882q.invoke();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("deserialized class ");
        stringBuilder.append(mo6689i());
        return stringBuilder.toString();
    }

    public final SourceElement mo7258r() {
        return this.f40885t;
    }

    public final List<TypeParameterDescriptor> mo7719s() {
        return this.f40869b.f26243a.m27889a();
    }

    public final /* synthetic */ boolean mo7742l() {
        return Flags.f26155f.m33502a(this.f40872g.f40315e).booleanValue();
    }

    public final /* synthetic */ boolean mo7773m() {
        return Flags.f26156g.m33502a(this.f40872g.f40315e).booleanValue();
    }

    public final /* synthetic */ boolean mo7745p() {
        return Flags.f26157h.m33502a(this.f40872g.f40315e).booleanValue();
    }

    public final /* bridge */ /* synthetic */ MemberScope mo7767b() {
        return this.f40876k;
    }

    public DeserializedClassDescriptor(DeserializationContext deserializationContext, ProtoBuf.Class classR, NameResolver nameResolver, SourceElement sourceElement) {
        Intrinsics.m26847b(deserializationContext, "outerContext");
        Intrinsics.m26847b(classR, "classProto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Intrinsics.m26847b(sourceElement, "sourceElement");
        super(deserializationContext.f26245c.f26229b, nameResolver.mo5831c(classR.f40316f).m27400c());
        this.f40872g = classR;
        this.f40885t = sourceElement;
        this.f40873h = nameResolver.mo5831c(this.f40872g.f40316f);
        DeclarationDescriptor declarationDescriptor = this;
        Object obj = this.f40872g.f40318h;
        Intrinsics.m26843a(obj, "classProto.typeParameterList");
        Object obj2 = this.f40872g.f40328r;
        Intrinsics.m26843a(obj2, "classProto.typeTable");
        this.f40869b = deserializationContext.m27835a(declarationDescriptor, obj, nameResolver, new TypeTable(obj2));
        this.f40876k = (MemberScopeImpl) (Intrinsics.m26845a(this.f40868a, ClassKind.ENUM_CLASS) != null ? new StaticScopeForKotlinEnum(this.f40869b.f26245c.f26229b, this) : Empty.f38819a);
        this.f40877l = new DeserializedClassTypeConstructor(this);
        this.f40870c = new DeserializedClassMemberScope(this);
        nameResolver = null;
        this.f40878m = Intrinsics.m26845a(this.f40868a, ClassKind.ENUM_CLASS) != null ? new EnumEntryClassDescriptors(this) : null;
        this.f40879n = deserializationContext.f26247e;
        this.f40880o = this.f40869b.f26245c.f26229b.mo5931b((Function0) new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.f40881p = this.f40869b.f26245c.f26229b.mo5926a((Function0) new DeserializedClassDescriptor$constructors$1(this));
        this.f40882q = this.f40869b.f26245c.f26229b.mo5931b((Function0) new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.f40883r = this.f40869b.f26245c.f26229b.mo5926a((Function0) new DeserializedClassDescriptor$sealedSubclasses$1(this));
        ProtoBuf.Class classR2 = this.f40872g;
        NameResolver nameResolver2 = this.f40869b.f26246d;
        TypeTable typeTable = this.f40869b.f26248f;
        SourceElement sourceElement2 = this.f40885t;
        classR = this.f40879n;
        if ((classR instanceof DeserializedClassDescriptor) == null) {
            classR = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classR;
        if (deserializedClassDescriptor != null) {
            nameResolver = deserializedClassDescriptor.f40871f;
        }
        this.f40871f = new Class(classR2, nameResolver2, typeTable, sourceElement2, nameResolver);
        if (Flags.f26151b.m33502a(this.f40872g.f40315e).booleanValue() == null) {
            deserializationContext = Annotations.f32643a;
            deserializationContext = Companion.m27115a();
        } else {
            deserializationContext = (Annotations) new DeserializedAnnotations(this.f40869b.f26245c.f26229b, (Function0) new DeserializedClassDescriptor$annotations$1(this));
        }
        this.f40884s = deserializationContext;
    }

    public static final /* synthetic */ ClassConstructorDescriptor m42840d(DeserializedClassDescriptor deserializedClassDescriptor) {
        if (deserializedClassDescriptor.f40868a.m27042a()) {
            ClassConstructorDescriptorImpl a = DescriptorFactory.m27629a((ClassDescriptor) deserializedClassDescriptor, SourceElement.f25498a);
            a.m42608a((KotlinType) deserializedClassDescriptor.mo7714h());
            return a;
        }
        for (Object next : deserializedClassDescriptor.f40872g.f40322l) {
            if ((Flags.f26158i.m33502a(((Constructor) next).f40343e).booleanValue() ^ 1) != 0) {
                break;
            }
        }
        Object next2 = null;
        Constructor constructor = (Constructor) next2;
        if (constructor == null) {
            return null;
        }
        return deserializedClassDescriptor.f40869b.f26244b.m27850a(constructor, true);
    }

    public static final /* synthetic */ Collection m42841e(DeserializedClassDescriptor deserializedClassDescriptor) {
        Collection arrayList = new ArrayList();
        for (Object next : deserializedClassDescriptor.f40872g.f40322l) {
            Object a = Flags.f26158i.m33502a(((Constructor) next).f40343e);
            Intrinsics.m26843a(a, "Flags.IS_SECONDARY.get(it.flags)");
            if (((Boolean) a).booleanValue()) {
                arrayList.add(next);
            }
        }
        Iterable<Constructor> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Constructor constructor : iterable) {
            MemberDeserializer memberDeserializer = deserializedClassDescriptor.f40869b.f26244b;
            Intrinsics.m26843a((Object) constructor, "it");
            arrayList2.add(memberDeserializer.m27850a(constructor, false));
        }
        return CollectionsKt___CollectionsKt.m41423b((Collection) CollectionsKt___CollectionsKt.m41423b((Collection) (List) arrayList2, (Iterable) CollectionsKt.m28094b(deserializedClassDescriptor.aH_())), (Iterable) deserializedClassDescriptor.f40869b.f26245c.f26240m.mo5828c(deserializedClassDescriptor));
    }

    public static final /* synthetic */ ClassDescriptor m42842f(DeserializedClassDescriptor deserializedClassDescriptor) {
        if (!deserializedClassDescriptor.f40872g.m41573i()) {
            return null;
        }
        Object b = deserializedClassDescriptor.f40869b.f26246d.mo5830b(deserializedClassDescriptor.f40872g.f40317g);
        deserializedClassDescriptor = deserializedClassDescriptor.f40870c;
        Intrinsics.m26843a(b, "companionObjectName");
        deserializedClassDescriptor = deserializedClassDescriptor.mo6699c(b, NoLookupLocation.f32688r);
        if (!(deserializedClassDescriptor instanceof ClassDescriptor)) {
            deserializedClassDescriptor = null;
        }
        return deserializedClassDescriptor;
    }

    public static final /* synthetic */ Collection m42843g(DeserializedClassDescriptor deserializedClassDescriptor) {
        if ((Intrinsics.m26845a(deserializedClassDescriptor.f40874i, Modality.f25489b) ^ 1) != 0) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        List<Object> list = deserializedClassDescriptor.f40872g.f40327q;
        if ((list.isEmpty() ^ 1) == 0) {
            return DescriptorUtilsKt.m27743c((ClassDescriptor) deserializedClassDescriptor);
        }
        Collection arrayList = new ArrayList();
        for (Object obj : list) {
            DeserializationComponents deserializationComponents = deserializedClassDescriptor.f40869b.f26245c;
            NameResolver nameResolver = deserializedClassDescriptor.f40869b.f26246d;
            Intrinsics.m26843a(obj, "index");
            Object obj2 = nameResolver.mo5831c(obj2.intValue());
            Intrinsics.m26843a(obj2, "c.nameResolver.getClassId(index)");
            ClassDescriptor a = deserializationComponents.m27832a(obj2);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return (List) arrayList;
    }
}
