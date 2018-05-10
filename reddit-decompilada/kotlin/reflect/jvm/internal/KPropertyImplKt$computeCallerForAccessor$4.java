package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundClassCompanionFieldGetter;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundClassCompanionFieldSetter;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundInstanceFieldGetter;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundInstanceFieldSetter;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundJvmStaticInObjectFieldGetter;
import kotlin.reflect.jvm.internal.FunctionCaller.BoundJvmStaticInObjectFieldSetter;
import kotlin.reflect.jvm.internal.FunctionCaller.ClassCompanionFieldGetter;
import kotlin.reflect.jvm.internal.FunctionCaller.ClassCompanionFieldSetter;
import kotlin.reflect.jvm.internal.FunctionCaller.InstanceFieldGetter;
import kotlin.reflect.jvm.internal.FunctionCaller.InstanceFieldSetter;
import kotlin.reflect.jvm.internal.FunctionCaller.JvmStaticInObjectFieldGetter;
import kotlin.reflect.jvm.internal.FunctionCaller.JvmStaticInObjectFieldSetter;
import kotlin.reflect.jvm.internal.FunctionCaller.StaticFieldGetter;
import kotlin.reflect.jvm.internal.FunctionCaller.StaticFieldSetter;
import kotlin.reflect.jvm.internal.KPropertyImpl.Accessor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"computeFieldCaller", "Lkotlin/reflect/jvm/internal/FunctionCaller;", "Ljava/lang/reflect/Field;", "field", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImplKt$computeCallerForAccessor$4 extends Lambda implements Function1<Field, FunctionCaller<? extends Field>> {
    final /* synthetic */ Accessor f38297a;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$1 f38298b;
    final /* synthetic */ boolean f38299c;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$3 f38300d;
    final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$2 f38301e;

    KPropertyImplKt$computeCallerForAccessor$4(Accessor accessor, KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1, boolean z, KPropertyImplKt$computeCallerForAccessor$3 kPropertyImplKt$computeCallerForAccessor$3, KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2) {
        this.f38297a = accessor;
        this.f38298b = kPropertyImplKt$computeCallerForAccessor$1;
        this.f38299c = z;
        this.f38300d = kPropertyImplKt$computeCallerForAccessor$3;
        this.f38301e = kPropertyImplKt$computeCallerForAccessor$2;
        super(1);
    }

    public final FunctionCaller<Field> m38289a(Field field) {
        Intrinsics.m26847b(field, "field");
        if (this.f38298b.m38285a()) {
            DeclarationDescriptor aD_ = this.f38297a.mo7076i().aD_();
            if (aD_ == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            Class a = UtilKt.m26932a((ClassDescriptor) aD_);
            if (a == null) {
                Intrinsics.m26842a();
            }
            if (this.f38299c) {
                if (this.f38297a.mo7255d().mo6675f()) {
                    return new BoundClassCompanionFieldGetter(field, a);
                }
                return new ClassCompanionFieldGetter(field, a);
            } else if (this.f38297a.mo7255d().mo6675f()) {
                return new BoundClassCompanionFieldSetter(field, a);
            } else {
                return new ClassCompanionFieldSetter(field, a);
            }
        } else if (Modifier.isStatic(field.getModifiers())) {
            if (this.f38301e.m38286a()) {
                if (this.f38299c) {
                    if (this.f38297a.mo7255d().mo6675f()) {
                        r0 = new BoundJvmStaticInObjectFieldGetter(field);
                    } else {
                        r0 = new JvmStaticInObjectFieldGetter(field);
                    }
                    return r0;
                }
                if (this.f38297a.mo7255d().mo6675f()) {
                    r0 = new BoundJvmStaticInObjectFieldSetter(field, this.f38300d.m38287a());
                } else {
                    r0 = new JvmStaticInObjectFieldSetter(field, this.f38300d.m38287a());
                }
                return r0;
            } else if (this.f38299c) {
                return new StaticFieldGetter(field);
            } else {
                return new StaticFieldSetter(field, this.f38300d.m38287a());
            }
        } else if (this.f38299c) {
            if (this.f38297a.mo7255d().mo6675f()) {
                r0 = new BoundInstanceFieldGetter(field, this.f38297a.mo7255d().f36040e);
            } else {
                r0 = new InstanceFieldGetter(field);
            }
            return r0;
        } else {
            if (this.f38297a.mo7255d().mo6675f()) {
                r0 = new BoundInstanceFieldSetter(field, this.f38300d.m38287a(), this.f38297a.mo7255d().f36040e);
            } else {
                r0 = new InstanceFieldSetter(field, this.f38300d.m38287a());
            }
            return r0;
        }
    }
}
