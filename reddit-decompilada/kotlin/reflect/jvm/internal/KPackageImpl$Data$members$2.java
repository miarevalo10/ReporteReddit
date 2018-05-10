package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$Data$members$2 extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {
    final /* synthetic */ Data f38263a;

    KPackageImpl$Data$members$2(Data data) {
        this.f38263a = data;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Collection arrayList = new ArrayList();
        for (Object next : this.f38263a.f32594d.m36170a(this.f38263a.f32594d.m38255c(), MemberBelonginess.f25332a)) {
            CallableMemberDescriptor a = ((KCallableImpl) next).mo6676a();
            if (a == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor");
            }
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = (DeserializedCallableMemberDescriptor) a;
            DeclarationDescriptor aD_ = deserializedCallableMemberDescriptor.aD_();
            if (aD_ == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor");
            }
            KotlinJvmBinaryClass kotlinJvmBinaryClass;
            ReflectKotlinClass reflectKotlinClass;
            PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) aD_;
            Object obj = null;
            if (!(packageFragmentDescriptor instanceof LazyJavaPackageFragment)) {
                packageFragmentDescriptor = null;
            }
            LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) packageFragmentDescriptor;
            SourceElement r = lazyJavaPackageFragment != null ? lazyJavaPackageFragment.mo7258r() : null;
            if (!(r instanceof KotlinJvmBinaryPackageSourceElement)) {
                r = null;
            }
            KotlinJvmBinaryPackageSourceElement kotlinJvmBinaryPackageSourceElement = (KotlinJvmBinaryPackageSourceElement) r;
            if (kotlinJvmBinaryPackageSourceElement != null) {
                Intrinsics.m26847b(deserializedCallableMemberDescriptor, "descriptor");
                Name a2 = UtilKt.m27196a((DeserializedMemberDescriptor) deserializedCallableMemberDescriptor);
                if (a2 != null) {
                    kotlinJvmBinaryClass = (KotlinJvmBinaryClass) kotlinJvmBinaryPackageSourceElement.f32825b.m42680b().get(a2.m27429a());
                    if (!(kotlinJvmBinaryClass instanceof ReflectKotlinClass)) {
                        kotlinJvmBinaryClass = null;
                    }
                    reflectKotlinClass = (ReflectKotlinClass) kotlinJvmBinaryClass;
                    if (reflectKotlinClass != null) {
                        obj = reflectKotlinClass.f32848a;
                    }
                    if (Intrinsics.m26845a(obj, this.f38263a.f32594d.f38266a)) {
                        arrayList.add(next);
                    }
                }
            }
            kotlinJvmBinaryClass = null;
            if (kotlinJvmBinaryClass instanceof ReflectKotlinClass) {
                kotlinJvmBinaryClass = null;
            }
            reflectKotlinClass = (ReflectKotlinClass) kotlinJvmBinaryClass;
            if (reflectKotlinClass != null) {
                obj = reflectKotlinClass.f32848a;
            }
            if (Intrinsics.m26845a(obj, this.f38263a.f32594d.f38266a)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }
}
