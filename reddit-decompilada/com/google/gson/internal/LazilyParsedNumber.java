package com.google.gson.internal;

public final class LazilyParsedNumber extends Number {
    private final String f8750a;

    public LazilyParsedNumber(String str) {
        this.f8750a = str;
    }

    public final int intValue() {
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
        r2 = this;
        r0 = r2.f8750a;	 Catch:{ NumberFormatException -> 0x0007 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = r2.f8750a;	 Catch:{ NumberFormatException -> 0x000f }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x000f }
        r0 = (int) r0;
        return r0;
    L_0x000f:
        r0 = new java.math.BigDecimal;
        r1 = r2.f8750a;
        r0.<init>(r1);
        r0 = r0.intValue();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LazilyParsedNumber.intValue():int");
    }

    public final long longValue() {
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
        r2 = this;
        r0 = r2.f8750a;	 Catch:{ NumberFormatException -> 0x0007 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = new java.math.BigDecimal;
        r1 = r2.f8750a;
        r0.<init>(r1);
        r0 = r0.longValue();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LazilyParsedNumber.longValue():long");
    }

    public final float floatValue() {
        return Float.parseFloat(this.f8750a);
    }

    public final double doubleValue() {
        return Double.parseDouble(this.f8750a);
    }

    public final String toString() {
        return this.f8750a;
    }

    public final int hashCode() {
        return this.f8750a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        LazilyParsedNumber lazilyParsedNumber = (LazilyParsedNumber) obj;
        if (this.f8750a != lazilyParsedNumber.f8750a) {
            if (this.f8750a.equals(lazilyParsedNumber.f8750a) == null) {
                return false;
            }
        }
        return true;
    }
}
