package kotlin.reflect.jvm.internal.impl.protobuf;

public class LazyFieldLite {
    protected volatile MessageLite f25931a;
    private ByteString f25932b;
    private ExtensionRegistryLite f25933c;

    public final kotlin.reflect.jvm.internal.impl.protobuf.MessageLite m27536a(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f25931a;
        if (r0 != 0) goto L_0x0027;
    L_0x0004:
        monitor-enter(r2);
        r0 = r2.f25931a;	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x0024 }
    L_0x0009:
        monitor-exit(r2);	 Catch:{ all -> 0x0024 }
        goto L_0x0027;
    L_0x000b:
        r0 = r2.f25932b;	 Catch:{ IOException -> 0x0022 }
        if (r0 == 0) goto L_0x0020;	 Catch:{ IOException -> 0x0022 }
    L_0x000f:
        r3 = r3.mo7112a();	 Catch:{ IOException -> 0x0022 }
        r0 = r2.f25932b;	 Catch:{ IOException -> 0x0022 }
        r1 = r2.f25933c;	 Catch:{ IOException -> 0x0022 }
        r3 = r3.mo5861a(r0, r1);	 Catch:{ IOException -> 0x0022 }
        r3 = (kotlin.reflect.jvm.internal.impl.protobuf.MessageLite) r3;	 Catch:{ IOException -> 0x0022 }
        r2.f25931a = r3;	 Catch:{ IOException -> 0x0022 }
        goto L_0x0022;	 Catch:{ IOException -> 0x0022 }
    L_0x0020:
        r2.f25931a = r3;	 Catch:{ IOException -> 0x0022 }
    L_0x0022:
        monitor-exit(r2);	 Catch:{ all -> 0x0024 }
        goto L_0x0027;	 Catch:{ all -> 0x0024 }
    L_0x0024:
        r3 = move-exception;	 Catch:{ all -> 0x0024 }
        monitor-exit(r2);	 Catch:{ all -> 0x0024 }
        throw r3;
    L_0x0027:
        r3 = r2.f25931a;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.LazyFieldLite.a(kotlin.reflect.jvm.internal.impl.protobuf.MessageLite):kotlin.reflect.jvm.internal.impl.protobuf.MessageLite");
    }
}
