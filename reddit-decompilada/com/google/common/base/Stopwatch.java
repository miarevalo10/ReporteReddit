package com.google.common.base;

import java.util.concurrent.TimeUnit;

public final class Stopwatch {
    public final Ticker f8242a = Ticker.m6941b();
    public boolean f8243b;
    public long f8244c;
    public long f8245d;

    static /* synthetic */ class C04391 {
        static final /* synthetic */ int[] f8241a = new int[TimeUnit.values().length];

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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = java.util.concurrent.TimeUnit.values();
            r0 = r0.length;
            r0 = new int[r0];
            f8241a = r0;
            r0 = f8241a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f8241a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = java.util.concurrent.TimeUnit.MICROSECONDS;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f8241a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f8241a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f8241a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = java.util.concurrent.TimeUnit.MINUTES;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f8241a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = java.util.concurrent.TimeUnit.HOURS;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r0 = f8241a;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = java.util.concurrent.TimeUnit.DAYS;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Stopwatch.1.<clinit>():void");
        }
    }

    public static Stopwatch m6927a() {
        return new Stopwatch();
    }

    public static Stopwatch m6928b() {
        return new Stopwatch().m6932d();
    }

    Stopwatch() {
    }

    public final boolean m6931c() {
        return this.f8243b;
    }

    public final Stopwatch m6932d() {
        Preconditions.m6922b(this.f8243b ^ true, (Object) "This stopwatch is already running.");
        this.f8243b = true;
        this.f8245d = this.f8242a.mo2329a();
        return this;
    }

    private long m6929e() {
        return this.f8243b ? (this.f8242a.mo2329a() - this.f8245d) + this.f8244c : this.f8244c;
    }

    public final long m6930a(TimeUnit timeUnit) {
        return timeUnit.convert(m6929e(), TimeUnit.NANOSECONDS);
    }

    public final String toString() {
        TimeUnit timeUnit;
        String str;
        long e = m6929e();
        if (TimeUnit.DAYS.convert(e, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.DAYS;
        } else if (TimeUnit.HOURS.convert(e, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.HOURS;
        } else if (TimeUnit.MINUTES.convert(e, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MINUTES;
        } else if (TimeUnit.SECONDS.convert(e, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.SECONDS;
        } else if (TimeUnit.MILLISECONDS.convert(e, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        } else if (TimeUnit.MICROSECONDS.convert(e, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MICROSECONDS;
        } else {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        double convert = ((double) e) / ((double) TimeUnit.NANOSECONDS.convert(1, timeUnit));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Platform.m6905a(convert));
        stringBuilder.append(" ");
        switch (C04391.f8241a[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
