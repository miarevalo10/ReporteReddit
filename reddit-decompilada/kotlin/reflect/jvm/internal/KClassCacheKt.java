package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\b\b\u0000\u0010\b*\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\"/\u0010\u0000\u001a#\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00040\u00040\u0001¢\u0006\u0002\b\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "Lorg/jetbrains/annotations/NotNull;", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k = 2, mv = {1, 1, 5})
/* compiled from: kClassCache.kt */
public final class KClassCacheKt {
    private static HashPMap<String, Object> f25327a = HashPMap.m28133a();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlin.reflect.jvm.internal.KClassImpl<T> m26908a(java.lang.Class<T> r8) {
        /*
        r0 = "jClass";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r0 = r8.getName();
        r1 = f25327a;
        r2 = r0.hashCode();
        r1 = r1.m28134a(r2);
    L_0x0013:
        r2 = 0;
        if (r1 == 0) goto L_0x002c;
    L_0x0016:
        r3 = r1.f26441c;
        if (r3 <= 0) goto L_0x002c;
    L_0x001a:
        r3 = r1.f26439a;
        r3 = (kotlin.reflect.jvm.internal.pcollections.MapEntry) r3;
        r4 = r3.f26453a;
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0029;
    L_0x0026:
        r1 = r3.f26454b;
        goto L_0x002d;
    L_0x0029:
        r1 = r1.f26440b;
        goto L_0x0013;
    L_0x002c:
        r1 = r2;
    L_0x002d:
        r3 = r1 instanceof java.lang.ref.WeakReference;
        if (r3 == 0) goto L_0x0044;
    L_0x0031:
        r1 = (java.lang.ref.WeakReference) r1;
        r1 = r1.get();
        r1 = (kotlin.reflect.jvm.internal.KClassImpl) r1;
        if (r1 == 0) goto L_0x003d;
    L_0x003b:
        r2 = r1.f38246b;
    L_0x003d:
        r2 = kotlin.jvm.internal.Intrinsics.m26845a(r2, r8);
        if (r2 == 0) goto L_0x0090;
    L_0x0043:
        return r1;
    L_0x0044:
        if (r1 == 0) goto L_0x0090;
    L_0x0046:
        if (r1 != 0) goto L_0x0050;
    L_0x0048:
        r8 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type kotlin.Array<java.lang.ref.WeakReference<kotlin.reflect.jvm.internal.KClassImpl<T>>>";
        r8.<init>(r0);
        throw r8;
    L_0x0050:
        r3 = r1;
        r3 = (java.lang.ref.WeakReference[]) r3;
        r4 = 0;
        r5 = r4;
    L_0x0055:
        r6 = r3.length;
        if (r5 >= r6) goto L_0x0070;
    L_0x0058:
        r6 = r3[r5];
        r6 = r6.get();
        r6 = (kotlin.reflect.jvm.internal.KClassImpl) r6;
        if (r6 == 0) goto L_0x0065;
    L_0x0062:
        r7 = r6.f38246b;
        goto L_0x0066;
    L_0x0065:
        r7 = r2;
    L_0x0066:
        r7 = kotlin.jvm.internal.Intrinsics.m26845a(r7, r8);
        if (r7 == 0) goto L_0x006d;
    L_0x006c:
        return r6;
    L_0x006d:
        r5 = r5 + 1;
        goto L_0x0055;
    L_0x0070:
        r2 = r1;
        r2 = (java.lang.Object[]) r2;
        r2 = r2.length;
        r3 = r2 + 1;
        r3 = new java.lang.ref.WeakReference[r3];
        java.lang.System.arraycopy(r1, r4, r3, r4, r2);
        r1 = new kotlin.reflect.jvm.internal.KClassImpl;
        r1.<init>(r8);
        r8 = new java.lang.ref.WeakReference;
        r8.<init>(r1);
        r3[r2] = r8;
        r8 = f25327a;
        r8 = r8.m28135a(r0, r3);
        f25327a = r8;
        return r1;
    L_0x0090:
        r1 = new kotlin.reflect.jvm.internal.KClassImpl;
        r1.<init>(r8);
        r8 = f25327a;
        r2 = new java.lang.ref.WeakReference;
        r2.<init>(r1);
        r8 = r8.m28135a(r0, r2);
        f25327a = r8;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KClassCacheKt.a(java.lang.Class):kotlin.reflect.jvm.internal.KClassImpl<T>");
    }
}
