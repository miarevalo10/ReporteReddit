package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
final class OperatorChecks$checks$2 extends Lambda implements Function1<FunctionDescriptor, String> {
    public static final OperatorChecks$checks$2 f38955a = new OperatorChecks$checks$2();

    /* compiled from: modifierChecks.kt */
    static final class C30091 extends Lambda implements Function1<DeclarationDescriptor, Boolean> {
        public static final C30091 f38954a = new C30091();

        C30091() {
            super(1);
        }

        public final /* synthetic */ Object mo6492a(Object obj) {
            return Boolean.valueOf(C30091.m38718a((DeclarationDescriptor) obj));
        }

        public static boolean m38718a(DeclarationDescriptor declarationDescriptor) {
            Intrinsics.m26847b(declarationDescriptor, "$receiver");
            return (!(declarationDescriptor instanceof ClassDescriptor) || KotlinBuiltIns.m26985c((ClassDescriptor) declarationDescriptor) == null) ? null : true;
        }
    }

    OperatorChecks$checks$2() {
        super(1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object mo6492a(java.lang.Object r5) {
        /*
        r4 = this;
        r5 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r5;
        r0 = "$receiver";
        kotlin.jvm.internal.Intrinsics.m26847b(r5, r0);
        r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.C30091.f38954a;
        r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.f33093a;
        r0 = r5.aD_();
        r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.C30091.m38718a(r0);
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x003e;
    L_0x0017:
        r5 = r5.mo7609m();
        r5 = (java.lang.Iterable) r5;
        r5 = r5.iterator();
    L_0x0021:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x003b;
    L_0x0027:
        r0 = r5.next();
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0;
        r3 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.C30091.f38954a;
        r0 = r0.aD_();
        r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.C30091.m38718a(r0);
        if (r0 == 0) goto L_0x0021;
    L_0x0039:
        r5 = r2;
        goto L_0x003c;
    L_0x003b:
        r5 = r1;
    L_0x003c:
        if (r5 == 0) goto L_0x003f;
    L_0x003e:
        r1 = r2;
    L_0x003f:
        if (r1 != 0) goto L_0x0046;
    L_0x0041:
        r5 = "must override ''equals()'' in Any";
        r5 = (java.lang.String) r5;
        return r5;
    L_0x0046:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks$checks$2.a(java.lang.Object):java.lang.Object");
    }
}
