package com.google.ads.mediation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated
public class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Parameter {
        String m3536a();

        boolean m3537b() default true;
    }

    public final void m3538a(java.util.Map<java.lang.String, java.lang.String> r7) throws com.google.ads.mediation.MediationServerParameters.MappingException {
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
        r6 = this;
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = r6.getClass();
        r1 = r1.getFields();
        r2 = 0;
        r3 = r1.length;
    L_0x000f:
        if (r2 >= r3) goto L_0x0027;
    L_0x0011:
        r4 = r1[r2];
        r5 = com.google.ads.mediation.MediationServerParameters.Parameter.class;
        r5 = r4.getAnnotation(r5);
        r5 = (com.google.ads.mediation.MediationServerParameters.Parameter) r5;
        if (r5 == 0) goto L_0x0024;
    L_0x001d:
        r5 = r5.m3536a();
        r0.put(r5, r4);
    L_0x0024:
        r2 = r2 + 1;
        goto L_0x000f;
    L_0x0027:
        r1 = r0.isEmpty();
        if (r1 == 0) goto L_0x0032;
    L_0x002d:
        r1 = "No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.";
        com.google.android.gms.internal.zzakb.m5371e(r1);
    L_0x0032:
        r7 = r7.entrySet();
        r7 = r7.iterator();
    L_0x003a:
        r1 = r7.hasNext();
        if (r1 == 0) goto L_0x00e9;
    L_0x0040:
        r1 = r7.next();
        r1 = (java.util.Map.Entry) r1;
        r2 = r1.getKey();
        r2 = r0.remove(r2);
        r2 = (java.lang.reflect.Field) r2;
        if (r2 == 0) goto L_0x00a6;
    L_0x0052:
        r3 = r1.getValue();	 Catch:{ IllegalAccessException -> 0x007b, IllegalArgumentException -> 0x005a }
        r2.set(r6, r3);	 Catch:{ IllegalAccessException -> 0x007b, IllegalArgumentException -> 0x005a }
        goto L_0x003a;
    L_0x005a:
        r1 = r1.getKey();
        r1 = (java.lang.String) r1;
        r2 = 43;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Server option \"";
        r3.append(r2);
        r3.append(r1);
        r1 = "\" could not be set: Bad Type";
        goto L_0x009b;
    L_0x007b:
        r1 = r1.getKey();
        r1 = (java.lang.String) r1;
        r2 = 49;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Server option \"";
        r3.append(r2);
        r3.append(r1);
        r1 = "\" could not be set: Illegal Access";
    L_0x009b:
        r3.append(r1);
        r1 = r3.toString();
        com.google.android.gms.internal.zzakb.m5371e(r1);
        goto L_0x003a;
    L_0x00a6:
        r2 = r1.getKey();
        r2 = (java.lang.String) r2;
        r1 = r1.getValue();
        r1 = (java.lang.String) r1;
        r3 = 31;
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = java.lang.String.valueOf(r1);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Unexpected server option: ";
        r4.append(r3);
        r4.append(r2);
        r2 = " = \"";
        r4.append(r2);
        r4.append(r1);
        r1 = "\"";
        r4.append(r1);
        r1 = r4.toString();
        com.google.android.gms.internal.zzakb.m5366b(r1);
        goto L_0x003a;
    L_0x00e9:
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r0.values();
        r0 = r0.iterator();
    L_0x00f6:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0151;
    L_0x00fc:
        r1 = r0.next();
        r1 = (java.lang.reflect.Field) r1;
        r2 = com.google.ads.mediation.MediationServerParameters.Parameter.class;
        r2 = r1.getAnnotation(r2);
        r2 = (com.google.ads.mediation.MediationServerParameters.Parameter) r2;
        r2 = r2.m3537b();
        if (r2 == 0) goto L_0x00f6;
    L_0x0110:
        r2 = "Required server option missing: ";
        r3 = com.google.ads.mediation.MediationServerParameters.Parameter.class;
        r3 = r1.getAnnotation(r3);
        r3 = (com.google.ads.mediation.MediationServerParameters.Parameter) r3;
        r3 = r3.m3536a();
        r3 = java.lang.String.valueOf(r3);
        r4 = r3.length();
        if (r4 == 0) goto L_0x012d;
    L_0x0128:
        r2 = r2.concat(r3);
        goto L_0x0133;
    L_0x012d:
        r3 = new java.lang.String;
        r3.<init>(r2);
        r2 = r3;
    L_0x0133:
        com.google.android.gms.internal.zzakb.m5371e(r2);
        r2 = r7.length();
        if (r2 <= 0) goto L_0x0141;
    L_0x013c:
        r2 = ", ";
        r7.append(r2);
    L_0x0141:
        r2 = com.google.ads.mediation.MediationServerParameters.Parameter.class;
        r1 = r1.getAnnotation(r2);
        r1 = (com.google.ads.mediation.MediationServerParameters.Parameter) r1;
        r1 = r1.m3536a();
        r7.append(r1);
        goto L_0x00f6;
    L_0x0151:
        r0 = r7.length();
        if (r0 <= 0) goto L_0x0177;
    L_0x0157:
        r0 = new com.google.ads.mediation.MediationServerParameters$MappingException;
        r1 = "Required server option(s) missing: ";
        r7 = r7.toString();
        r7 = java.lang.String.valueOf(r7);
        r2 = r7.length();
        if (r2 == 0) goto L_0x016e;
    L_0x0169:
        r7 = r1.concat(r7);
        goto L_0x0173;
    L_0x016e:
        r7 = new java.lang.String;
        r7.<init>(r1);
    L_0x0173:
        r0.<init>(r7);
        throw r0;
    L_0x0177:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.mediation.MediationServerParameters.a(java.util.Map):void");
    }
}
