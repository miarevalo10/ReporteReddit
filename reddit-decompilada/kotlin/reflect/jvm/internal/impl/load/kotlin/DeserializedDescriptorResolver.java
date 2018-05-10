package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.PackageData;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Package;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;

/* compiled from: DeserializedDescriptorResolver.kt */
public final class DeserializedDescriptorResolver {
    public static final Companion f25784b = new Companion();
    private static final Set<Kind> f25785c = SetsKt__SetsKt.m26800a((Object) Kind.f25828b);
    private static final Set<Kind> f25786d = SetsKt__SetsKt.m26802a((Object[]) new Kind[]{Kind.f25829c, Kind.f25832f});
    private static final JvmMetadataVersion f25787e = new JvmMetadataVersion(1, 1, 2);
    private static boolean f25788f;
    public DeserializationComponents f25789a;

    /* compiled from: DeserializedDescriptorResolver.kt */
    public static final class Companion {
        private Companion() {
        }

        public static Set<Kind> m27287a() {
            return DeserializedDescriptorResolver.f25785c;
        }

        public static boolean m27288b() {
            String property = System.getProperty("kotlin.test.is.pre.release");
            return property != null ? Boolean.parseBoolean(property) : DeserializedDescriptorResolver.f25788f;
        }
    }

    public final DeserializationComponents m27300a() {
        DeserializationComponents deserializationComponents = this.f25789a;
        if (deserializationComponents == null) {
            Intrinsics.m26844a("components");
        }
        return deserializationComponents;
    }

    public static ClassDataWithSource m27291a(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.m26847b(kotlinJvmBinaryClass, "kotlinClass");
        String[] a = m27292a(kotlinJvmBinaryClass, Companion.m27287a());
        if (a == null) {
            return null;
        }
        String[] strArr = kotlinJvmBinaryClass.mo5853c().f25841e;
        if (strArr == null) {
            return null;
        }
        ClassData a2;
        try {
            a2 = JvmProtoBufUtil.m27910a(a, strArr);
        } catch (InvalidProtocolBufferException e) {
            StringBuilder stringBuilder = new StringBuilder("Could not read data from ");
            stringBuilder.append(kotlinJvmBinaryClass.mo5852b());
            throw new IllegalStateException(stringBuilder.toString(), e);
        } catch (Throwable th) {
            if (!kotlinJvmBinaryClass.mo5853c().f25838b.m33204a()) {
                a2 = null;
            }
        }
        a2 = a2;
        if (a2 == null) {
            return null;
        }
        return new ClassDataWithSource(a2, new KotlinJvmBinarySourceElement(kotlinJvmBinaryClass, m27294b(kotlinJvmBinaryClass), m27296c(kotlinJvmBinaryClass)));
    }

    public final MemberScope m27299a(PackageFragmentDescriptor packageFragmentDescriptor, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.m26847b(packageFragmentDescriptor, "descriptor");
        Intrinsics.m26847b(kotlinJvmBinaryClass, "kotlinClass");
        String[] a = m27292a(kotlinJvmBinaryClass, f25786d);
        if (a == null) {
            return null;
        }
        String[] strArr = kotlinJvmBinaryClass.mo5853c().f25841e;
        if (strArr == null) {
            return null;
        }
        PackageData b;
        try {
            b = JvmProtoBufUtil.m27912b(a, strArr);
        } catch (InvalidProtocolBufferException e) {
            StringBuilder stringBuilder = new StringBuilder("Could not read data from ");
            stringBuilder.append(kotlinJvmBinaryClass.mo5852b());
            throw new IllegalStateException(stringBuilder.toString(), e);
        } catch (Throwable th) {
            if (!kotlinJvmBinaryClass.mo5853c().f25838b.m33204a()) {
                b = null;
            }
        }
        b = b;
        if (b == null) {
            return null;
        }
        NameResolver nameResolver = b.f26176a;
        Package packageR = b.f26177b;
        DeserializedContainerSource jvmPackagePartSource = new JvmPackagePartSource(kotlinJvmBinaryClass, m27294b(kotlinJvmBinaryClass), m27296c(kotlinJvmBinaryClass));
        DeserializationComponents deserializationComponents = this.f25789a;
        if (deserializationComponents == null) {
            Intrinsics.m26844a("components");
        }
        return (MemberScope) new DeserializedPackageMemberScope(packageFragmentDescriptor, packageR, nameResolver, jvmPackagePartSource, deserializationComponents, DeserializedDescriptorResolver$createKotlinPackagePartScope$2.f38766a);
    }

    private static IncompatibleVersionErrorData<JvmMetadataVersion> m27294b(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass.mo5853c().f25838b.m33204a()) {
            return null;
        }
        return new IncompatibleVersionErrorData(kotlinJvmBinaryClass.mo5853c().f25838b, JvmMetadataVersion.f32810a, kotlinJvmBinaryClass.mo5852b(), kotlinJvmBinaryClass.mo5849a());
    }

    private static boolean m27296c(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion.Companion companion = JvmMetadataVersion.f32812c;
        if (!(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion.Companion.m27317a() || Companion.m27288b())) {
            if (((kotlinJvmBinaryClass.mo5853c().f25842f & 2) != 0) || Intrinsics.m26845a(kotlinJvmBinaryClass.mo5853c().f25838b, f25787e) != null) {
                return true;
            }
        }
        return false;
    }

    private static String[] m27292a(KotlinJvmBinaryClass kotlinJvmBinaryClass, Set<? extends Kind> set) {
        Intrinsics.m26847b(kotlinJvmBinaryClass, "kotlinClass");
        Intrinsics.m26847b(set, "expectedKinds");
        kotlinJvmBinaryClass = kotlinJvmBinaryClass.mo5853c();
        Object obj = kotlinJvmBinaryClass.f25839c;
        if (obj == null) {
            obj = kotlinJvmBinaryClass.f25840d;
        }
        return obj != null ? (String[]) AddToStdlibKt.m28126a(obj, new DeserializedDescriptorResolver$readData$1(set, kotlinJvmBinaryClass)) : null;
    }
}
