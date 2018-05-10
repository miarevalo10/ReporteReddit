package com.reddit.frontpage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.LocalBroadcastManager;
import com.airbnb.deeplinkdispatch.DeepLinkEntry;
import com.airbnb.deeplinkdispatch.DeepLinkHandler;
import com.airbnb.deeplinkdispatch.DeepLinkResult;
import com.airbnb.deeplinkdispatch.Parser;
import com.reddit.frontpage.util.DeepLinkUtilLoader;
import java.util.Arrays;
import java.util.List;

public final class DeepLinkDelegate {
    private static final String f19868a = "DeepLinkDelegate";
    private final List<? extends Parser> f19869b;

    public DeepLinkDelegate(DeepLinkUtilLoader deepLinkUtilLoader) {
        this.f19869b = Arrays.asList(new DeepLinkUtilLoader[]{deepLinkUtilLoader});
    }

    private DeepLinkEntry m21776a(String str) {
        for (Parser parseUri : this.f19869b) {
            DeepLinkEntry parseUri2 = parseUri.parseUri(str);
            if (parseUri2 != null) {
                return parseUri2;
            }
        }
        return null;
    }

    public final com.airbnb.deeplinkdispatch.DeepLinkResult m21778a(android.app.Activity r18, android.content.Intent r19) {
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
        r17 = this;
        r0 = r18;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r0 = new java.lang.NullPointerException;
        r1 = "activity == null";
        r0.<init>(r1);
        throw r0;
    L_0x000c:
        if (r19 != 0) goto L_0x0016;
    L_0x000e:
        r0 = new java.lang.NullPointerException;
        r1 = "sourceIntent == null";
        r0.<init>(r1);
        throw r0;
    L_0x0016:
        r2 = r19.getData();
        r3 = 0;
        r4 = 0;
        if (r2 != 0) goto L_0x0025;
    L_0x001e:
        r1 = "No Uri in given activity's intent.";
        r0 = m21777a(r0, r4, r3, r1);
        return r0;
    L_0x0025:
        r5 = r2.toString();
        r6 = r17;
        r7 = r6.m21776a(r5);
        if (r7 == 0) goto L_0x0229;
    L_0x0031:
        r8 = com.airbnb.deeplinkdispatch.DeepLinkUri.parse(r5);
        r5 = r7.getParameters(r5);
        r9 = r8.queryParameterNames();
        r9 = r9.iterator();
    L_0x0041:
        r10 = r9.hasNext();
        if (r10 == 0) goto L_0x007e;
    L_0x0047:
        r10 = r9.next();
        r10 = (java.lang.String) r10;
        r11 = r8.queryParameterValues(r10);
        r11 = r11.iterator();
    L_0x0055:
        r12 = r11.hasNext();
        if (r12 == 0) goto L_0x0041;
    L_0x005b:
        r12 = r11.next();
        r12 = (java.lang.String) r12;
        r13 = r5.containsKey(r10);
        if (r13 == 0) goto L_0x007a;
    L_0x0067:
        r13 = f19868a;
        r14 = new java.lang.StringBuilder;
        r15 = "Duplicate parameter name in path and query param: ";
        r14.<init>(r15);
        r14.append(r10);
        r14 = r14.toString();
        android.util.Log.w(r13, r14);
    L_0x007a:
        r5.put(r10, r12);
        goto L_0x0055;
    L_0x007e:
        r8 = "deep_link_uri";
        r9 = r2.toString();
        r5.put(r8, r9);
        r8 = r19.getExtras();
        if (r8 == 0) goto L_0x0097;
    L_0x008d:
        r8 = new android.os.Bundle;
        r9 = r19.getExtras();
        r8.<init>(r9);
        goto L_0x009c;
    L_0x0097:
        r8 = new android.os.Bundle;
        r8.<init>();
    L_0x009c:
        r5 = r5.entrySet();
        r5 = r5.iterator();
    L_0x00a4:
        r9 = r5.hasNext();
        if (r9 == 0) goto L_0x00c0;
    L_0x00aa:
        r9 = r5.next();
        r9 = (java.util.Map.Entry) r9;
        r10 = r9.getKey();
        r10 = (java.lang.String) r10;
        r9 = r9.getValue();
        r9 = (java.lang.String) r9;
        r8.putString(r10, r9);
        goto L_0x00a4;
    L_0x00c0:
        r5 = r7.getActivityClass();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r7.getType();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = com.airbnb.deeplinkdispatch.DeepLinkEntry.Type.CLASS;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r11 = 1;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r9 != r10) goto L_0x00d5;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x00cd:
        r9 = new android.content.Intent;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9.<init>(r0, r5);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x00d2:
        r5 = r3;
        goto L_0x01a4;
    L_0x00d5:
        r9 = r7.getMethod();	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = new java.lang.Class[r11];	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12 = android.content.Context.class;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10[r4] = r12;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r5.getMethod(r9, r10);	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r9.getReturnType();	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12 = android.support.v4.app.TaskStackBuilder.class;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r10.equals(r12);	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r10 == 0) goto L_0x012c;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x00ef:
        r10 = new java.lang.Object[r11];	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10[r4] = r0;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r9.invoke(r5, r10);	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = (android.support.v4.app.TaskStackBuilder) r9;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r9.b;	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r10.size();	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r10 != 0) goto L_0x011d;	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x0101:
        r10 = new java.lang.StringBuilder;	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12 = "Could not deep link to method: ";	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10.<init>(r12);	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12 = r7.getMethod();	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10.append(r12);	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12 = " intents length == 0";	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10.append(r12);	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r10.toString();	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = m21777a(r0, r4, r2, r10);	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        return r10;	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x011d:
        r10 = r9.b;	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r10.size();	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r10 - r11;	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r9.a(r10);	 Catch:{ NoSuchMethodException -> 0x0138, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r5 = r9;
        r9 = r10;
        goto L_0x01a4;
    L_0x012c:
        r10 = new java.lang.Object[r11];	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10[r4] = r0;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r9.invoke(r5, r10);	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = (android.content.Intent) r9;	 Catch:{ NoSuchMethodException -> 0x0137, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        goto L_0x00d2;
    L_0x0137:
        r9 = r3;
    L_0x0138:
        r10 = r7.getMethod();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12 = 2;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r13 = new java.lang.Class[r12];	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r14 = android.content.Context.class;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r13[r4] = r14;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r14 = android.os.Bundle.class;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r13[r11] = r14;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r10 = r5.getMethod(r10, r13);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r13 = r10.getReturnType();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r14 = android.support.v4.app.TaskStackBuilder.class;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r13 = r13.equals(r14);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r13 == 0) goto L_0x0193;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x0157:
        r9 = new java.lang.Object[r12];	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9[r4] = r0;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9[r11] = r8;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r5 = r10.invoke(r5, r9);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r5 = (android.support.v4.app.TaskStackBuilder) r5;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r5.b;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r9.size();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r9 != 0) goto L_0x0187;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x016b:
        r1 = new java.lang.StringBuilder;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r3 = "Could not deep link to method: ";	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1.<init>(r3);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r3 = r7.getMethod();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1.append(r3);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r3 = " intents length == 0";	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1.append(r3);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1 = r1.toString();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1 = m21777a(r0, r4, r2, r1);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        return r1;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x0187:
        r9 = r5.b;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r9.size();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r9 - r11;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r5.a(r9);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        goto L_0x01a4;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x0193:
        r12 = new java.lang.Object[r12];	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12[r4] = r0;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r12[r11] = r8;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r5 = r10.invoke(r5, r12);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r5 = (android.content.Intent) r5;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r16 = r9;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9 = r5;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r5 = r16;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01a4:
        r10 = r9.getAction();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r10 != 0) goto L_0x01b1;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01aa:
        r10 = r19.getAction();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9.setAction(r10);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01b1:
        r10 = r9.getData();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r10 != 0) goto L_0x01be;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01b7:
        r1 = r19.getData();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9.setData(r1);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01be:
        r9.putExtras(r8);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1 = "is_deep_link_flag";	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9.putExtra(r1, r11);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1 = "android.intent.extra.REFERRER";	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9.putExtra(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r1 = r18.getCallingActivity();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        if (r1 == 0) goto L_0x01d6;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01d1:
        r1 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        r9.setFlags(r1);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01d6:
        if (r5 == 0) goto L_0x01dc;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01d8:
        r5.a();	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        goto L_0x01df;	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01dc:
        r0.startActivity(r9);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
    L_0x01df:
        r1 = m21777a(r0, r11, r2, r3);	 Catch:{ NoSuchMethodException -> 0x0212, IllegalAccessException -> 0x01fb, InvocationTargetException -> 0x01e4 }
        return r1;
    L_0x01e4:
        r1 = new java.lang.StringBuilder;
        r3 = "Could not deep link to method: ";
        r1.<init>(r3);
        r3 = r7.getMethod();
        r1.append(r3);
        r1 = r1.toString();
        r0 = m21777a(r0, r4, r2, r1);
        return r0;
    L_0x01fb:
        r1 = new java.lang.StringBuilder;
        r3 = "Could not deep link to method: ";
        r1.<init>(r3);
        r3 = r7.getMethod();
        r1.append(r3);
        r1 = r1.toString();
        r0 = m21777a(r0, r4, r2, r1);
        return r0;
    L_0x0212:
        r1 = new java.lang.StringBuilder;
        r3 = "Deep link to non-existent method: ";
        r1.<init>(r3);
        r3 = r7.getMethod();
        r1.append(r3);
        r1 = r1.toString();
        r0 = m21777a(r0, r4, r2, r1);
        return r0;
    L_0x0229:
        r1 = new java.lang.StringBuilder;
        r3 = "No registered entity to handle deep link: ";
        r1.<init>(r3);
        r3 = r2.toString();
        r1.append(r3);
        r1 = r1.toString();
        r0 = m21777a(r0, r4, r2, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.DeepLinkDelegate.a(android.app.Activity, android.content.Intent):com.airbnb.deeplinkdispatch.DeepLinkResult");
    }

    private static DeepLinkResult m21777a(Context context, boolean z, Uri uri, String str) {
        int i = z ^ 1;
        Intent intent = new Intent();
        intent.setAction(DeepLinkHandler.ACTION);
        intent.putExtra(DeepLinkHandler.EXTRA_URI, uri != null ? uri.toString() : "");
        intent.putExtra(DeepLinkHandler.EXTRA_SUCCESSFUL, i == 0);
        if (i != 0) {
            intent.putExtra(DeepLinkHandler.EXTRA_ERROR_MESSAGE, str);
        }
        LocalBroadcastManager.a(context).a(intent);
        return new DeepLinkResult(z, uri != null ? uri.toString() : null, str);
    }
}
