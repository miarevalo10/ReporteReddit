package com.nytimes.android.external.cache3;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class Stopwatch {
    final Ticker f10219a = Ticker.m8681b();
    boolean f10220b;
    long f10221c;
    long f10222d;

    static /* synthetic */ class C08301 {
        static final /* synthetic */ int[] f10218a = new int[TimeUnit.values().length];

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
            f10218a = r0;
            r0 = f10218a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f10218a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = java.util.concurrent.TimeUnit.MICROSECONDS;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f10218a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f10218a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f10218a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = java.util.concurrent.TimeUnit.MINUTES;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f10218a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = java.util.concurrent.TimeUnit.HOURS;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r0 = f10218a;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = java.util.concurrent.TimeUnit.DAYS;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nytimes.android.external.cache3.Stopwatch.1.<clinit>():void");
        }
    }

    public static Stopwatch m8678a() {
        return new Stopwatch();
    }

    public static Stopwatch m8679b() {
        return new Stopwatch().m8680c();
    }

    Stopwatch() {
    }

    public final Stopwatch m8680c() {
        Preconditions.m8675b(this.f10220b ^ true, "This stopwatch is already running.");
        this.f10220b = true;
        this.f10222d = this.f10219a.mo2662a();
        return this;
    }

    public final String toString() {
        TimeUnit timeUnit;
        String str;
        long a = this.f10220b ? (this.f10219a.mo2662a() - this.f10222d) + this.f10221c : this.f10221c;
        if (TimeUnit.DAYS.convert(a, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.DAYS;
        } else if (TimeUnit.HOURS.convert(a, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.HOURS;
        } else if (TimeUnit.MINUTES.convert(a, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MINUTES;
        } else if (TimeUnit.SECONDS.convert(a, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.SECONDS;
        } else if (TimeUnit.MILLISECONDS.convert(a, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        } else if (TimeUnit.MICROSECONDS.convert(a, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MICROSECONDS;
        } else {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        double convert = ((double) a) / ((double) TimeUnit.NANOSECONDS.convert(1, timeUnit));
        Locale locale = Locale.ROOT;
        String str2 = "%.4g %s";
        Object[] objArr = new Object[2];
        objArr[0] = Double.valueOf(convert);
        switch (C08301.f10218a[timeUnit.ordinal()]) {
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
        objArr[1] = str;
        return String.format(locale, str2, objArr);
    }
}
