package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;

/* compiled from: ClassDeserializer.kt */
public final class ClassDeserializer {
    public static final Companion f26217a = new Companion();
    private static final Set<ClassId> f26218d = SetsKt__SetsKt.m26800a((Object) ClassId.m27396a(KotlinBuiltIns.f25420j.f25382c.m27420d()));
    private final Function1<ClassKey, ClassDescriptor> f26219b = this.f26220c.f26229b.mo5930b((Function1) new ClassDeserializer$classes$1(this));
    private final DeserializationComponents f26220c;

    /* compiled from: ClassDeserializer.kt */
    private static final class ClassKey {
        final ClassId f26215a;
        final ClassDataWithSource f26216b;

        public ClassKey(ClassId classId, ClassDataWithSource classDataWithSource) {
            Intrinsics.m26847b(classId, "classId");
            this.f26215a = classId;
            this.f26216b = classDataWithSource;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof ClassKey) || Intrinsics.m26845a(this.f26215a, ((ClassKey) obj).f26215a) == null) ? null : true;
        }

        public final int hashCode() {
            return this.f26215a.hashCode();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    public static final class Companion {
        private Companion() {
        }

        public static Set<ClassId> m27821a() {
            return ClassDeserializer.f26218d;
        }
    }

    public ClassDeserializer(DeserializationComponents deserializationComponents) {
        Intrinsics.m26847b(deserializationComponents, "components");
        this.f26220c = deserializationComponents;
    }

    public final ClassDescriptor m27825a(ClassId classId, ClassDataWithSource classDataWithSource) {
        Intrinsics.m26847b(classId, "classId");
        return (ClassDescriptor) this.f26219b.mo6492a(new ClassKey(classId, classDataWithSource));
    }

    public static final /* synthetic */ ClassDescriptor m27824a(ClassDeserializer classDeserializer, ClassKey classKey) {
        ClassId classId = classKey.f26215a;
        for (ClassDescriptorFactory a : classDeserializer.f26220c.f26238k) {
            ClassDescriptor a2 = a.mo5705a(classId);
            if (a2 != null) {
                return a2;
            }
        }
        if (Companion.m27821a().contains(classId)) {
            return null;
        }
        classKey = classKey.f26216b;
        if (classKey == null) {
            classKey = classDeserializer.f26220c.f26232e.mo5703a(classId);
        }
        if (classKey == null) {
            return null;
        }
        ClassData classData = classKey.f26142a;
        classKey = classKey.f26143b;
        NameResolver nameResolver = classData.f26140a;
        Class classR = classData.f26141b;
        Object c;
        if (classId.m27402e()) {
            ClassId d = classId.m27401d();
            Intrinsics.m26843a((Object) d, "classId.outerClassId");
            classDeserializer = classDeserializer.m27825a(d, null);
            if (!(classDeserializer instanceof DeserializedClassDescriptor)) {
                classDeserializer = null;
            }
            DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor) classDeserializer;
            if (deserializedClassDescriptor == null) {
                return null;
            }
            c = classId.m27400c();
            Intrinsics.m26843a(c, "classId.shortClassName");
            Intrinsics.m26847b(c, "name");
            if (!deserializedClassDescriptor.f40870c.m38650e().contains(c)) {
                return null;
            }
            classDeserializer = deserializedClassDescriptor.f40869b;
        } else {
            PackageFragmentProvider packageFragmentProvider = classDeserializer.f26220c.f26234g;
            Object a3 = classId.m27398a();
            Intrinsics.m26843a(a3, "classId.packageFqName");
            List a4 = packageFragmentProvider.mo5712a(a3);
            Object obj = null;
            a3 = a4.size() == 1 ? 1 : null;
            if (_Assertions.f25274a && a3 == null) {
                classDeserializer = new StringBuilder("There should be exactly one package: ");
                classDeserializer.append(a4);
                classDeserializer.append(", class id is ");
                classDeserializer.append(classId);
                throw ((Throwable) new AssertionError(classDeserializer.toString()));
            }
            PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) CollectionsKt___CollectionsKt.m41441h(a4);
            if (packageFragmentDescriptor instanceof DeserializedPackageFragment) {
                DeserializedPackageFragment deserializedPackageFragment = (DeserializedPackageFragment) packageFragmentDescriptor;
                c = classId.m27400c();
                Intrinsics.m26843a(c, "classId.shortClassName");
                Intrinsics.m26847b(c, "name");
                MemberScope aC_ = deserializedPackageFragment.aC_();
                if ((aC_ instanceof DeserializedMemberScope) && ((DeserializedMemberScope) aC_).m38650e().contains(c)) {
                    obj = 1;
                }
                if (obj == null) {
                    return null;
                }
            }
            DeserializationComponents deserializationComponents = classDeserializer.f26220c;
            Object obj2 = classR.f40328r;
            Intrinsics.m26843a(obj2, "classProto.typeTable");
            TypeTable typeTable = new TypeTable(obj2);
            classDeserializer = SinceKotlinInfoTable.f26281a;
            obj2 = classR.f40330t;
            Intrinsics.m26843a(obj2, "classProto.sinceKotlinInfoTable");
            classDeserializer = deserializationComponents.m27833a(packageFragmentDescriptor, nameResolver, typeTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable.Companion.m27897a(obj2), null);
        }
        return new DeserializedClassDescriptor(classDeserializer, classR, nameResolver, classKey);
    }
}
