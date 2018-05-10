package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "R", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPropertyImpl.kt */
final class KPropertyImpl$javaField_$1 extends Lambda implements Function0<Field> {
    final /* synthetic */ KPropertyImpl f38293a;

    KPropertyImpl$javaField_$1(KPropertyImpl kPropertyImpl) {
        this.f38293a = kPropertyImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return m38284a();
    }

    private java.lang.reflect.Field m38284a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.f25343a;
        r0 = r5.f38293a;
        r0 = r0.m36189m();
        r0 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.m26929a(r0);
        r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty;
        r2 = 0;
        if (r1 == 0) goto L_0x0063;
    L_0x0011:
        r0 = (kotlin.reflect.jvm.internal.JvmPropertySignature.KotlinProperty) r0;
        r1 = r0.f32562a;
        r3 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil.f26297a;
        r3 = r0.f32563b;
        r4 = r0.f32565d;
        r0 = r0.f32566e;
        r0 = kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil.m27911a(r3, r4, r0);
        if (r0 == 0) goto L_0x0062;
    L_0x0023:
        r0 = (kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBufUtil.PropertySignature) r0;
        r3 = r1.aD_();
        r3 = kotlin.reflect.jvm.internal.impl.load.java.JvmAbi.m27153a(r3);
        if (r3 == 0) goto L_0x003c;
    L_0x002f:
        r1 = r5.f38293a;
        r1 = r1.f36037b;
        r1 = r1.mo6657a();
        r1 = r1.getEnclosingClass();
        goto L_0x0057;
    L_0x003c:
        r1 = r1.aD_();
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r1;
        r3 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
        if (r3 == 0) goto L_0x004d;
    L_0x0046:
        r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r1;
        r1 = kotlin.reflect.jvm.internal.UtilKt.m26932a(r1);
        goto L_0x0055;
    L_0x004d:
        r1 = r5.f38293a;
        r1 = r1.f36037b;
        r1 = r1.mo6657a();
    L_0x0055:
        r1 = (java.lang.Class) r1;
    L_0x0057:
        if (r1 == 0) goto L_0x0060;
    L_0x0059:
        r0 = r0.f26295a;	 Catch:{ NoSuchFieldException -> 0x0060 }
        r0 = r1.getDeclaredField(r0);	 Catch:{ NoSuchFieldException -> 0x0060 }
        r2 = r0;
    L_0x0060:
        r2 = (java.lang.reflect.Field) r2;
    L_0x0062:
        return r2;
    L_0x0063:
        r1 = r0 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField;
        if (r1 == 0) goto L_0x006c;
    L_0x0067:
        r0 = (kotlin.reflect.jvm.internal.JvmPropertySignature.JavaField) r0;
        r0 = r0.f32559a;
        return r0;
    L_0x006c:
        r0 = r0 instanceof kotlin.reflect.jvm.internal.JvmPropertySignature.JavaMethodProperty;
        if (r0 == 0) goto L_0x0071;
    L_0x0070:
        return r2;
    L_0x0071:
        r0 = new kotlin.NoWhenBranchMatchedException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl$javaField_$1.a():java.lang.reflect.Field");
    }
}
