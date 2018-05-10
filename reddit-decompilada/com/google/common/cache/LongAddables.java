package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

final class LongAddables {
    private static final Supplier<LongAddable> f8352a;

    static class C11641 implements Supplier<LongAddable> {
        C11641() {
        }

        public final /* synthetic */ Object mo2328a() {
            return new LongAdder();
        }
    }

    static class C11652 implements Supplier<LongAddable> {
        C11652() {
        }

        public final /* synthetic */ Object mo2328a() {
            return new PureJavaLongAddable();
        }
    }

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        public final void mo2379a() {
            getAndIncrement();
        }

        public final void mo2380a(long j) {
            getAndAdd(j);
        }

        public final long mo2381b() {
            return get();
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = new com.google.common.cache.LongAdder;	 Catch:{ Throwable -> 0x000b }
        r0.<init>();	 Catch:{ Throwable -> 0x000b }
        r0 = new com.google.common.cache.LongAddables$1;	 Catch:{ Throwable -> 0x000b }
        r0.<init>();	 Catch:{ Throwable -> 0x000b }
        goto L_0x0010;
    L_0x000b:
        r0 = new com.google.common.cache.LongAddables$2;
        r0.<init>();
    L_0x0010:
        f8352a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LongAddables.<clinit>():void");
    }

    public static LongAddable m7050a() {
        return (LongAddable) f8352a.mo2328a();
    }
}
