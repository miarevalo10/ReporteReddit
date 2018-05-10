package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.EnumEntry;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Package;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.ClassMapperLite;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C, T> implements AnnotationAndConstantLoader<A, C, T> {
    public static final Companion f32769a = new Companion();
    private static final Set<ClassId> f32770d;
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, Storage<A, C>> f32771b;
    private final KotlinClassFinder f32772c;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    private static final class Companion {
        private Companion() {
        }

        public static Set<ClassId> m27286a() {
            return AbstractBinaryClassAnnotationAndConstantLoader.f32770d;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    private static final class Storage<A, C> {
        final Map<MemberSignature, List<A>> f25780a;
        final Map<MemberSignature, C> f25781b;

        public Storage(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2) {
            Intrinsics.m26847b(map, "memberAnnotations");
            Intrinsics.m26847b(map2, "propertyConstants");
            this.f25780a = map;
            this.f25781b = map2;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25782a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            f25782a = iArr;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            f25782a[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            f25782a[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
        }
    }

    protected abstract A mo6718a(Annotation annotation, NameResolver nameResolver);

    protected abstract List<T> mo6719a(List<? extends A> list);

    protected abstract List<T> mo6720a(List<? extends A> list, List<? extends A> list2, AnnotationUseSiteTarget annotationUseSiteTarget);

    protected abstract AnnotationArgumentVisitor mo6721a(ClassId classId, SourceElement sourceElement, List<A> list);

    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(kotlinClassFinder, "kotlinClassFinder");
        this.f32772c = kotlinClassFinder;
        this.f32771b = storageManager.mo5925a((Function1) new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    public final List<A> mo5809a(Class classR) {
        Intrinsics.m26847b(classR, "container");
        KotlinJvmBinaryClass b = m33144b(classR);
        if (b == null) {
            StringBuilder stringBuilder = new StringBuilder("Class for loading annotations is not found: ");
            stringBuilder.append(classR.mo5923a());
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        classR = new ArrayList(1);
        b.mo5850a((AnnotationVisitor) new C2572xc0ff27f9(this, classR));
        return (List) classR;
    }

    public final List<T> mo5810a(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(messageLite, "proto");
        Intrinsics.m26847b(annotatedCallableKind, "kind");
        if (!Intrinsics.m26845a((Object) annotatedCallableKind, AnnotatedCallableKind.PROPERTY)) {
            MemberSignature a = m33141a(messageLite, protoContainer.f26267a, protoContainer.f26268b, annotatedCallableKind);
            if (a == null) {
                return CollectionsKt__CollectionsKt.m26790a();
            }
            return mo6719a(m33134a(this, protoContainer, a, false, null, 28));
        } else if (messageLite == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.ProtoBuf.Property");
        } else {
            Property property = (Property) messageLite;
            Property property2 = property;
            annotatedCallableKind = m33143a(property2, protoContainer.f26267a, protoContainer.f26268b, false, true, 8);
            MemberSignature a2 = m33143a(property2, protoContainer.f26267a, protoContainer.f26268b, true, false, 16);
            messageLite = Flags.f26169t.m33502a(property.f40420e);
            List list = null;
            List a3 = annotatedCallableKind != null ? m33134a(this, protoContainer, (MemberSignature) annotatedCallableKind, true, (Boolean) messageLite, 8) : null;
            if (a3 == null) {
                a3 = CollectionsKt__CollectionsKt.m26790a();
            }
            if (a2 != null) {
                list = m33135a(protoContainer, a2, true, true, (Boolean) messageLite);
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.m26790a();
            }
            if (a2 != null) {
                protoContainer = a2.f25801a;
                if (protoContainer != null) {
                    protoContainer = StringsKt__StringsKt.m42452a((CharSequence) protoContainer, (CharSequence) "$delegate");
                    return mo6720a(a3, list, protoContainer == null ? AnnotationUseSiteTarget.f25530i : AnnotationUseSiteTarget.f25522a);
                }
            }
            protoContainer = null;
            if (protoContainer == null) {
            }
            return mo6720a(a3, list, protoContainer == null ? AnnotationUseSiteTarget.f25530i : AnnotationUseSiteTarget.f25522a);
        }
    }

    public final List<A> mo5812a(ProtoContainer protoContainer, EnumEntry enumEntry) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(enumEntry, "proto");
        kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion = MemberSignature.f25800b;
        Object a = protoContainer.f26267a.mo5829a(enumEntry.f40354e);
        Intrinsics.m26843a(a, "container.nameResolver.getString(proto.name)");
        if (protoContainer == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        }
        return m33134a(this, protoContainer, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27347b(a, ClassMapperLite.m27904a(((Class) protoContainer).f33041d)), false, null, 28);
    }

    private final List<A> m33135a(ProtoContainer protoContainer, MemberSignature memberSignature, boolean z, boolean z2, Boolean bool) {
        protoContainer = m33139a(protoContainer, m33140a(protoContainer, z, z2, bool));
        if (protoContainer == null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        protoContainer = (List) ((Storage) this.f32771b.mo6492a(protoContainer)).f25780a.get(memberSignature);
        if (protoContainer == null) {
            protoContainer = CollectionsKt__CollectionsKt.m26790a();
        }
        return protoContainer;
    }

    public final List<A> mo5807a(Type type, NameResolver nameResolver) {
        Intrinsics.m26847b(type, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Iterable<Annotation> iterable = (Iterable) type.m39931b(JvmProtoBuf.f26290d);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation annotation : iterable) {
            Intrinsics.m26843a((Object) annotation, "it");
            arrayList.add(mo6718a(annotation, nameResolver));
        }
        return (List) arrayList;
    }

    public final List<A> mo5808a(TypeParameter typeParameter, NameResolver nameResolver) {
        Intrinsics.m26847b(typeParameter, "proto");
        Intrinsics.m26847b(nameResolver, "nameResolver");
        Iterable<Annotation> iterable = (Iterable) typeParameter.m39931b(JvmProtoBuf.f26292f);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
        for (Annotation annotation : iterable) {
            Intrinsics.m26843a((Object) annotation, "it");
            arrayList.add(mo6718a(annotation, nameResolver));
        }
        return (List) arrayList;
    }

    public final C mo5806a(ProtoContainer protoContainer, Property property, KotlinType kotlinType) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(property, "proto");
        Intrinsics.m26847b(kotlinType, "expectedType");
        kotlinType = m33141a((MessageLite) property, protoContainer.f26267a, protoContainer.f26268b, AnnotatedCallableKind.PROPERTY);
        if (kotlinType == null) {
            return null;
        }
        protoContainer = m33139a(protoContainer, m33140a(protoContainer, true, true, Flags.f26169t.m33502a(property.f40420e)));
        if (protoContainer == null) {
            return null;
        }
        return ((Storage) this.f32771b.mo6492a(protoContainer)).f25781b.get(kotlinType);
    }

    private static KotlinJvmBinaryClass m33139a(ProtoContainer protoContainer, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass != null) {
            return kotlinJvmBinaryClass;
        }
        return (protoContainer instanceof Class) != null ? m33144b((Class) protoContainer) : null;
    }

    private final KotlinJvmBinaryClass m33140a(ProtoContainer protoContainer, boolean z, boolean z2, Boolean bool) {
        Class classR;
        if (z) {
            if (bool == null) {
                z = new StringBuilder("isConst should not be null for property (container=");
                z.append(protoContainer);
                z.append(")");
                throw ((Throwable) new IllegalStateException(z.toString().toString()));
            }
            ClassId a;
            if (protoContainer instanceof Class) {
                classR = (Class) protoContainer;
                if (Intrinsics.m26845a(classR.f33042e, Kind.INTERFACE)) {
                    protoContainer = this.f32772c;
                    a = classR.f33041d.m27397a(Name.m27424a("DefaultImpls"));
                    Intrinsics.m26843a((Object) a, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                    return protoContainer.mo5855a(a);
                }
            }
            if (bool == null) {
                Intrinsics.m26842a();
            }
            if (bool.booleanValue() && (protoContainer instanceof Package)) {
                z = protoContainer.f26269c;
                if ((z instanceof JvmPackagePartSource) == null) {
                    z = false;
                }
                JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) z;
                if (jvmPackagePartSource != null) {
                    z = jvmPackagePartSource.f36119c;
                } else {
                    z = false;
                }
                if (z) {
                    protoContainer = this.f32772c;
                    a = ClassId.m27396a(new FqName(StringsKt__StringsJVMKt.m41941a((String) z.m27752a(), '/', '.')));
                    Intrinsics.m26843a((Object) a, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
                    return protoContainer.mo5855a(a);
                }
            }
        }
        if (z2 && (protoContainer instanceof Class)) {
            classR = (Class) protoContainer;
            if (Intrinsics.m26845a(classR.f33042e, Kind.COMPANION_OBJECT)) {
                z = classR.f33045h;
                if (z && (Intrinsics.m26845a(z.f33042e, Kind.CLASS) || Intrinsics.m26845a(z.f33042e, Kind.ENUM_CLASS))) {
                    return m33144b(z);
                }
            }
        }
        if (!(protoContainer instanceof Package) || !(protoContainer.f26269c instanceof JvmPackagePartSource)) {
            return null;
        }
        z = this.f32772c;
        protoContainer = protoContainer.f26269c;
        if (protoContainer == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        }
        JvmPackagePartSource jvmPackagePartSource2 = (JvmPackagePartSource) protoContainer;
        bool = jvmPackagePartSource2.f36118b;
        int lastIndexOf = bool.f26093a.lastIndexOf(Operation.DIVISION);
        if (lastIndexOf == -1) {
            bool = FqName.f25855a;
            if (bool == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName", "getPackageFqName"}));
            }
        }
        bool = new FqName(bool.f26093a.substring(0, lastIndexOf).replace('/', '.'));
        return z.mo5855a(new ClassId(bool, jvmPackagePartSource2.m36309b()));
    }

    private static MemberSignature m33142a(Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, boolean z2) {
        if (!property.m39930a(JvmProtoBuf.f26289c)) {
            return null;
        }
        JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) property.m39931b(JvmProtoBuf.f26289c);
        if (z) {
            z = JvmProtoBufUtil.f26297a;
            property = JvmProtoBufUtil.m27911a(property, nameResolver, typeTable);
            if (property == null) {
                return null;
            }
            nameResolver = property.f26295a;
            property = property.f26296b;
            typeTable = MemberSignature.f25800b;
            return kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27347b(nameResolver, property);
        } else if (!z2 || jvmPropertySignature.m40423i() == null) {
            return null;
        } else {
            property = MemberSignature.f25800b;
            JvmMethodSignature jvmMethodSignature = jvmPropertySignature.f39936d;
            Intrinsics.m26843a((Object) jvmMethodSignature, "signature.syntheticMethod");
            return kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27346a(nameResolver, jvmMethodSignature);
        }
    }

    private static MemberSignature m33141a(MessageLite messageLite, NameResolver nameResolver, TypeTable typeTable, AnnotatedCallableKind annotatedCallableKind) {
        if (messageLite instanceof Constructor) {
            annotatedCallableKind = MemberSignature.f25800b;
            annotatedCallableKind = JvmProtoBufUtil.f26297a;
            messageLite = JvmProtoBufUtil.m27906a((Constructor) messageLite, nameResolver, typeTable);
            if (messageLite == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27343a(messageLite);
        } else if (messageLite instanceof Function) {
            annotatedCallableKind = MemberSignature.f25800b;
            annotatedCallableKind = JvmProtoBufUtil.f26297a;
            messageLite = JvmProtoBufUtil.m27907a((Function) messageLite, nameResolver, typeTable);
            if (messageLite == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27343a(messageLite);
        } else {
            if (messageLite instanceof Property) {
                Property property = (Property) messageLite;
                if (property.m39930a(JvmProtoBuf.f26289c)) {
                    JvmPropertySignature jvmPropertySignature = (JvmPropertySignature) property.m39931b(JvmProtoBuf.f26289c);
                    JvmMethodSignature jvmMethodSignature;
                    switch (WhenMappings.f25782a[annotatedCallableKind.ordinal()]) {
                        case 1:
                            messageLite = MemberSignature.f25800b;
                            jvmMethodSignature = jvmPropertySignature.f39937e;
                            Intrinsics.m26843a((Object) jvmMethodSignature, "signature.getter");
                            return kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27346a(nameResolver, jvmMethodSignature);
                        case 2:
                            messageLite = MemberSignature.f25800b;
                            jvmMethodSignature = jvmPropertySignature.f39938f;
                            Intrinsics.m26843a((Object) jvmMethodSignature, "signature.setter");
                            return kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27346a(nameResolver, jvmMethodSignature);
                        case 3:
                            return m33142a(property, nameResolver, typeTable, true, true);
                        default:
                            return null;
                    }
                }
            }
            return null;
        }
    }

    static {
        Iterable<FqName> b = CollectionsKt__CollectionsKt.m26796b((Object[]) new FqName[]{JvmAnnotationNames.f25630a, JvmAnnotationNames.f25633d, JvmAnnotationNames.f25634e, new FqName("java.lang.annotation.Target"), new FqName("java.lang.annotation.Retention"), new FqName("java.lang.annotation.Documented")});
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
        for (FqName a : b) {
            arrayList.add(ClassId.m27396a(a));
        }
        f32770d = CollectionsKt___CollectionsKt.m41451p((List) arrayList);
    }

    private static KotlinJvmBinaryClass m33144b(Class classR) {
        classR = classR.f26269c;
        if (!(classR instanceof KotlinJvmBinarySourceElement)) {
            classR = null;
        }
        KotlinJvmBinarySourceElement kotlinJvmBinarySourceElement = (KotlinJvmBinarySourceElement) classR;
        return kotlinJvmBinarySourceElement != null ? kotlinJvmBinarySourceElement.f36122b : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<A> mo5811a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer r7, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r8, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r9, int r10, kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter r11) {
        /*
        r6 = this;
        r0 = "container";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r0);
        r0 = "callableProto";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r0 = "kind";
        kotlin.jvm.internal.Intrinsics.m26847b(r9, r0);
        r0 = "proto";
        kotlin.jvm.internal.Intrinsics.m26847b(r11, r0);
        r11 = r7.f26267a;
        r0 = r7.f26268b;
        r9 = m33141a(r8, r11, r0, r9);
        if (r9 == 0) goto L_0x0089;
    L_0x001e:
        r11 = r8 instanceof kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
        r0 = 0;
        r1 = 1;
        if (r11 == 0) goto L_0x002e;
    L_0x0024:
        r8 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function) r8;
        r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt.m27874a(r8);
        if (r8 == 0) goto L_0x005d;
    L_0x002c:
        r0 = r1;
        goto L_0x005d;
    L_0x002e:
        r11 = r8 instanceof kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
        if (r11 == 0) goto L_0x003b;
    L_0x0032:
        r8 = (kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property) r8;
        r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt.m27875a(r8);
        if (r8 == 0) goto L_0x005d;
    L_0x003a:
        goto L_0x002c;
    L_0x003b:
        r11 = r8 instanceof kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Constructor;
        if (r11 == 0) goto L_0x006f;
    L_0x003f:
        if (r7 != 0) goto L_0x0049;
    L_0x0041:
        r7 = new kotlin.TypeCastException;
        r8 = "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class";
        r7.<init>(r8);
        throw r7;
    L_0x0049:
        r8 = r7;
        r8 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer.Class) r8;
        r11 = r8.f33042e;
        r2 = kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class.Kind.ENUM_CLASS;
        r11 = kotlin.jvm.internal.Intrinsics.m26845a(r11, r2);
        if (r11 == 0) goto L_0x0058;
    L_0x0056:
        r0 = 2;
        goto L_0x005d;
    L_0x0058:
        r8 = r8.f33043f;
        if (r8 == 0) goto L_0x005d;
    L_0x005c:
        goto L_0x002c;
    L_0x005d:
        r10 = r10 + r0;
        r8 = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.f25800b;
        r2 = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27345a(r9, r10);
        r3 = 0;
        r4 = 0;
        r5 = 28;
        r0 = r6;
        r1 = r7;
        r7 = m33134a(r0, r1, r2, r3, r4, r5);
        return r7;
    L_0x006f:
        r7 = new java.lang.UnsupportedOperationException;
        r9 = new java.lang.StringBuilder;
        r10 = "Unsupported message: ";
        r9.<init>(r10);
        r8 = r8.getClass();
        r9.append(r8);
        r8 = r9.toString();
        r7.<init>(r8);
        r7 = (java.lang.Throwable) r7;
        throw r7;
    L_0x0089:
        r7 = kotlin.collections.CollectionsKt__CollectionsKt.m26790a();
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.a(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind, int, kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$ValueParameter):java.util.List<A>");
    }

    public final List<A> mo5813b(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.m26847b(protoContainer, "container");
        Intrinsics.m26847b(messageLite, "proto");
        Intrinsics.m26847b(annotatedCallableKind, "kind");
        MemberSignature a = m33141a(messageLite, protoContainer.f26267a, protoContainer.f26268b, annotatedCallableKind);
        if (a == null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        annotatedCallableKind = MemberSignature.f25800b;
        return m33134a(this, protoContainer, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.m27345a(a, (int) null), false, null, 28);
    }

    public static final /* synthetic */ AnnotationArgumentVisitor m33138a(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, ClassId classId, SourceElement sourceElement, List list) {
        if (Companion.m27286a().contains(classId)) {
            return null;
        }
        return abstractBinaryClassAnnotationAndConstantLoader.mo6721a(classId, sourceElement, list);
    }

    public static final /* synthetic */ Storage m33137a(AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        kotlinJvmBinaryClass.mo5851a((MemberVisitor) new C2571x2cf49cf1(abstractBinaryClassAnnotationAndConstantLoader, hashMap, hashMap2));
        return new Storage(hashMap, hashMap2);
    }
}
