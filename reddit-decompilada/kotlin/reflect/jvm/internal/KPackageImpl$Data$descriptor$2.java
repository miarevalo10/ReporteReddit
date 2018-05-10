package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;

@Metadata(bv = {1, 0, 1}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/jetbrains/kotlin/descriptors/PackageViewDescriptor;", "invoke"}, k = 3, mv = {1, 1, 5})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$Data$descriptor$2 extends Lambda implements Function0<PackageViewDescriptor> {
    final /* synthetic */ Data f38262a;

    KPackageImpl$Data$descriptor$2(Data data) {
        this.f38262a = data;
        super(0);
    }

    public final /* synthetic */ java.lang.Object invoke() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.f38262a;
        r0 = r0.m26910d();
        r0 = (kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimeModuleData) r0;
        r1 = r0.f25849b;
        r2 = r9.f38262a;
        r2 = r2.f32594d;
        r2 = r2.f38267b;
        r3 = "moduleName";
        kotlin.jvm.internal.Intrinsics.m26847b(r2, r3);
        r3 = 0;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0063 }
        r5 = "META-INF/";	 Catch:{ Exception -> 0x0063 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0063 }
        r4.append(r2);	 Catch:{ Exception -> 0x0063 }
        r5 = ".";	 Catch:{ Exception -> 0x0063 }
        r4.append(r5);	 Catch:{ Exception -> 0x0063 }
        r5 = kotlin.reflect.jvm.internal.impl.load.kotlin.ModuleMapping.f25802b;	 Catch:{ Exception -> 0x0063 }
        r4.append(r5);	 Catch:{ Exception -> 0x0063 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0063 }
        r5 = r1.f32852b;	 Catch:{ Exception -> 0x0063 }
        r5 = r5.getResourceAsStream(r4);	 Catch:{ Exception -> 0x0063 }
        if (r5 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x0063 }
    L_0x0036:
        r5 = (java.io.Closeable) r5;	 Catch:{ Exception -> 0x0063 }
        r6 = 0;
        r7 = r5;	 Catch:{ Exception -> 0x0051 }
        r7 = (java.io.InputStream) r7;	 Catch:{ Exception -> 0x0051 }
        r8 = kotlin.reflect.jvm.internal.impl.load.kotlin.ModuleMapping.f25804d;	 Catch:{ Exception -> 0x0051 }
        r7 = kotlin.io.ByteStreamsKt.m26827a(r7);	 Catch:{ Exception -> 0x0051 }
        r4 = kotlin.reflect.jvm.internal.impl.load.kotlin.ModuleMapping.Companion.m27355a(r7, r4);	 Catch:{ Exception -> 0x0051 }
        if (r5 == 0) goto L_0x004b;
    L_0x0048:
        r5.close();	 Catch:{ Exception -> 0x0063 }
    L_0x004b:
        r4 = (kotlin.reflect.jvm.internal.impl.load.kotlin.ModuleMapping) r4;	 Catch:{ Exception -> 0x0063 }
        r3 = r4;
        goto L_0x0063;
    L_0x004f:
        r4 = move-exception;
        goto L_0x005b;
    L_0x0051:
        r4 = move-exception;
        r6 = 1;
        if (r5 == 0) goto L_0x0058;
    L_0x0055:
        r5.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0058:
        r4 = (java.lang.Throwable) r4;	 Catch:{ all -> 0x004f }
        throw r4;	 Catch:{ all -> 0x004f }
    L_0x005b:
        if (r6 != 0) goto L_0x0062;
    L_0x005d:
        if (r5 == 0) goto L_0x0062;
    L_0x005f:
        r5.close();	 Catch:{ Exception -> 0x0063 }
    L_0x0062:
        throw r4;	 Catch:{ Exception -> 0x0063 }
    L_0x0063:
        r1 = r1.f32851a;
        if (r3 != 0) goto L_0x0069;
    L_0x0067:
        r3 = kotlin.reflect.jvm.internal.impl.load.kotlin.ModuleMapping.f25803c;
    L_0x0069:
        r1.putIfAbsent(r2, r3);
        r0 = r0.f25848a;
        r0 = r0.f26230c;
        r1 = r9.f38262a;
        r1 = r1.f32594d;
        r1 = r1.f38266a;
        r1 = kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt.m27244e(r1);
        r1 = r1.m27398a();
        r2 = "jClass.classId.packageFqName";
        kotlin.jvm.internal.Intrinsics.m26843a(r1, r2);
        r0 = r0.mo7087a(r1);
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPackageImpl$Data$descriptor$2.invoke():java.lang.Object");
    }
}
