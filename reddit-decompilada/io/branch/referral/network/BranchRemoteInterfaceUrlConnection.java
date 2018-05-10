package io.branch.referral.network;

import android.content.Context;
import io.branch.referral.PrefHelper;
import io.branch.referral.network.BranchRemoteInterface.BranchRemoteException;
import io.branch.referral.network.BranchRemoteInterface.BranchResponse;
import org.json.JSONObject;

public class BranchRemoteInterfaceUrlConnection extends BranchRemoteInterface {
    PrefHelper f30973a;

    BranchRemoteInterfaceUrlConnection(Context context) {
        this.f30973a = PrefHelper.m26151a(context);
    }

    public final BranchResponse mo5558a(String str) throws BranchRemoteException {
        return m31931a(str, 0);
    }

    public final BranchResponse mo5559a(String str, JSONObject jSONObject) throws BranchRemoteException {
        return m31932a(str, jSONObject, 0);
    }

    private io.branch.referral.network.BranchRemoteInterface.BranchResponse m31931a(java.lang.String r9, int r10) throws io.branch.referral.network.BranchRemoteInterface.BranchRemoteException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:io.branch.referral.network.BranchRemoteInterfaceUrlConnection.a(java.lang.String, int):io.branch.referral.network.BranchRemoteInterface$BranchResponse. bs: [B:54:0x00c7, B:59:0x00f2]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r8 = this;
        r0 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
        r1 = 3;
        r2 = 0;
        r3 = io.branch.referral.PrefHelper.m26158b();	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        if (r3 > 0) goto L_0x000c;	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
    L_0x000a:
        r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
    L_0x000c:
        r4 = "?";	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r4 = r9.contains(r4);	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        if (r4 == 0) goto L_0x0017;	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
    L_0x0014:
        r4 = "&";	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        goto L_0x0019;	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
    L_0x0017:
        r4 = "?";	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
    L_0x0019:
        r5 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r5.<init>();	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r5.append(r9);	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r5.append(r4);	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r4 = "retryNumber=";	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r5.append(r4);	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r5.append(r10);	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r4 = r5.toString();	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r5 = new java.net.URL;	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r5.<init>(r4);	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r4 = r5.openConnection();	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r4 = (javax.net.ssl.HttpsURLConnection) r4;	 Catch:{ SocketException -> 0x0113, SocketTimeoutException -> 0x00ea, IOException -> 0x00c6 }
        r4.setConnectTimeout(r3);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r4.setReadTimeout(r3);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r3 = r4.getResponseCode();	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        if (r3 < r5) goto L_0x006a;	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
    L_0x0049:
        r5 = "bnc_retry_count";	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r5 = io.branch.referral.PrefHelper.m26160b(r5, r1);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        if (r10 >= r5) goto L_0x006a;
    L_0x0051:
        r2 = io.branch.referral.PrefHelper.m26164c();	 Catch:{ InterruptedException -> 0x005a }
        r2 = (long) r2;	 Catch:{ InterruptedException -> 0x005a }
        java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x005a }
        goto L_0x005e;
    L_0x005a:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
    L_0x005e:
        r10 = r10 + 1;	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r2 = r8.m31931a(r9, r10);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        if (r4 == 0) goto L_0x0069;
    L_0x0066:
        r4.disconnect();
    L_0x0069:
        return r2;
    L_0x006a:
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 == r5) goto L_0x0087;
    L_0x006e:
        r5 = r4.getErrorStream();	 Catch:{ FileNotFoundException -> 0x009a }
        if (r5 == 0) goto L_0x0087;	 Catch:{ FileNotFoundException -> 0x009a }
    L_0x0074:
        r5 = new io.branch.referral.network.BranchRemoteInterface$BranchResponse;	 Catch:{ FileNotFoundException -> 0x009a }
        r6 = r4.getErrorStream();	 Catch:{ FileNotFoundException -> 0x009a }
        r6 = m31933a(r6);	 Catch:{ FileNotFoundException -> 0x009a }
        r5.<init>(r6, r3);	 Catch:{ FileNotFoundException -> 0x009a }
        if (r4 == 0) goto L_0x0086;
    L_0x0083:
        r4.disconnect();
    L_0x0086:
        return r5;
    L_0x0087:
        r5 = new io.branch.referral.network.BranchRemoteInterface$BranchResponse;	 Catch:{ FileNotFoundException -> 0x009a }
        r6 = r4.getInputStream();	 Catch:{ FileNotFoundException -> 0x009a }
        r6 = m31933a(r6);	 Catch:{ FileNotFoundException -> 0x009a }
        r5.<init>(r6, r3);	 Catch:{ FileNotFoundException -> 0x009a }
        if (r4 == 0) goto L_0x0099;
    L_0x0096:
        r4.disconnect();
    L_0x0099:
        return r5;
    L_0x009a:
        r5 = "BranchSDK";	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r6 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r7 = "A resource conflict occurred with this request ";	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r6.<init>(r7);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r6.append(r9);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r6 = r6.toString();	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        io.branch.referral.PrefHelper.m26161b(r5, r6);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r5 = new io.branch.referral.network.BranchRemoteInterface$BranchResponse;	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        r5.<init>(r2, r3);	 Catch:{ SocketException -> 0x00c1, SocketTimeoutException -> 0x00bf, IOException -> 0x00bc, all -> 0x00b8 }
        if (r4 == 0) goto L_0x00b7;
    L_0x00b4:
        r4.disconnect();
    L_0x00b7:
        return r5;
    L_0x00b8:
        r9 = move-exception;
        r2 = r4;
        goto L_0x0137;
    L_0x00bc:
        r9 = move-exception;
        r2 = r4;
        goto L_0x00c7;
    L_0x00bf:
        r2 = r4;
        goto L_0x00ea;
    L_0x00c1:
        r9 = move-exception;
        r2 = r4;
        goto L_0x0114;
    L_0x00c4:
        r9 = move-exception;
        goto L_0x0137;
    L_0x00c6:
        r9 = move-exception;
    L_0x00c7:
        r10 = r8.getClass();	 Catch:{ all -> 0x00c4 }
        r10 = r10.getSimpleName();	 Catch:{ all -> 0x00c4 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r3 = "Branch connect exception: ";	 Catch:{ all -> 0x00c4 }
        r1.<init>(r3);	 Catch:{ all -> 0x00c4 }
        r9 = r9.getMessage();	 Catch:{ all -> 0x00c4 }
        r1.append(r9);	 Catch:{ all -> 0x00c4 }
        r9 = r1.toString();	 Catch:{ all -> 0x00c4 }
        io.branch.referral.PrefHelper.m26161b(r10, r9);	 Catch:{ all -> 0x00c4 }
        r9 = new io.branch.referral.network.BranchRemoteInterface$BranchRemoteException;	 Catch:{ all -> 0x00c4 }
        r9.<init>(r0);	 Catch:{ all -> 0x00c4 }
        throw r9;	 Catch:{ all -> 0x00c4 }
    L_0x00ea:
        r0 = "bnc_retry_count";	 Catch:{ all -> 0x00c4 }
        r0 = io.branch.referral.PrefHelper.m26160b(r0, r1);	 Catch:{ all -> 0x00c4 }
        if (r10 >= r0) goto L_0x010b;
    L_0x00f2:
        r0 = io.branch.referral.PrefHelper.m26164c();	 Catch:{ InterruptedException -> 0x00fb }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x00fb }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x00fb }
        goto L_0x00ff;
    L_0x00fb:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00c4 }
    L_0x00ff:
        r10 = r10 + 1;	 Catch:{ all -> 0x00c4 }
        r9 = r8.m31931a(r9, r10);	 Catch:{ all -> 0x00c4 }
        if (r2 == 0) goto L_0x010a;
    L_0x0107:
        r2.disconnect();
    L_0x010a:
        return r9;
    L_0x010b:
        r9 = new io.branch.referral.network.BranchRemoteInterface$BranchRemoteException;	 Catch:{ all -> 0x00c4 }
        r10 = -111; // 0xffffffffffffff91 float:NaN double:NaN;	 Catch:{ all -> 0x00c4 }
        r9.<init>(r10);	 Catch:{ all -> 0x00c4 }
        throw r9;	 Catch:{ all -> 0x00c4 }
    L_0x0113:
        r9 = move-exception;	 Catch:{ all -> 0x00c4 }
    L_0x0114:
        r10 = r8.getClass();	 Catch:{ all -> 0x00c4 }
        r10 = r10.getSimpleName();	 Catch:{ all -> 0x00c4 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c4 }
        r3 = "Http connect exception: ";	 Catch:{ all -> 0x00c4 }
        r1.<init>(r3);	 Catch:{ all -> 0x00c4 }
        r9 = r9.getMessage();	 Catch:{ all -> 0x00c4 }
        r1.append(r9);	 Catch:{ all -> 0x00c4 }
        r9 = r1.toString();	 Catch:{ all -> 0x00c4 }
        io.branch.referral.PrefHelper.m26161b(r10, r9);	 Catch:{ all -> 0x00c4 }
        r9 = new io.branch.referral.network.BranchRemoteInterface$BranchRemoteException;	 Catch:{ all -> 0x00c4 }
        r9.<init>(r0);	 Catch:{ all -> 0x00c4 }
        throw r9;	 Catch:{ all -> 0x00c4 }
    L_0x0137:
        if (r2 == 0) goto L_0x013c;
    L_0x0139:
        r2.disconnect();
    L_0x013c:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterfaceUrlConnection.a(java.lang.String, int):io.branch.referral.network.BranchRemoteInterface$BranchResponse");
    }

    private io.branch.referral.network.BranchRemoteInterface.BranchResponse m31932a(java.lang.String r10, org.json.JSONObject r11, int r12) throws io.branch.referral.network.BranchRemoteInterface.BranchRemoteException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:io.branch.referral.network.BranchRemoteInterfaceUrlConnection.a(java.lang.String, org.json.JSONObject, int):io.branch.referral.network.BranchRemoteInterface$BranchResponse. bs: [B:64:0x010d, B:69:0x013a]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r9 = this;
        r0 = io.branch.referral.PrefHelper.m26158b();
        if (r0 > 0) goto L_0x0008;
    L_0x0006:
        r0 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
    L_0x0008:
        r1 = "retryNumber";	 Catch:{ JSONException -> 0x000d }
        r11.put(r1, r12);	 Catch:{ JSONException -> 0x000d }
    L_0x000d:
        r1 = 3;
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r3 = 0;
        r4 = 1;
        r5 = new java.net.URL;	 Catch:{ SocketTimeoutException -> 0x0132, IOException -> 0x010c, Exception -> 0x00cf }
        r5.<init>(r10);	 Catch:{ SocketTimeoutException -> 0x0132, IOException -> 0x010c, Exception -> 0x00cf }
        r5 = r5.openConnection();	 Catch:{ SocketTimeoutException -> 0x0132, IOException -> 0x010c, Exception -> 0x00cf }
        r5 = (javax.net.ssl.HttpsURLConnection) r5;	 Catch:{ SocketTimeoutException -> 0x0132, IOException -> 0x010c, Exception -> 0x00cf }
        r5.setConnectTimeout(r0);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r5.setReadTimeout(r0);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r5.setDoInput(r4);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r5.setDoOutput(r4);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0 = "Content-Type";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r6 = "application/json";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r5.setRequestProperty(r0, r6);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0 = "Accept";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r6 = "application/json";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r5.setRequestProperty(r0, r6);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0 = "POST";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r5.setRequestMethod(r0);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0 = new java.io.OutputStreamWriter;	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r6 = r5.getOutputStream();	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0.<init>(r6);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r6 = r11.toString();	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0.write(r6);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0.flush();	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0 = r5.getResponseCode();	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        if (r0 < r2) goto L_0x0076;	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
    L_0x0055:
        r6 = "bnc_retry_count";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r6 = io.branch.referral.PrefHelper.m26160b(r6, r1);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        if (r12 >= r6) goto L_0x0076;
    L_0x005d:
        r0 = io.branch.referral.PrefHelper.m26164c();	 Catch:{ InterruptedException -> 0x0066 }
        r6 = (long) r0;	 Catch:{ InterruptedException -> 0x0066 }
        java.lang.Thread.sleep(r6);	 Catch:{ InterruptedException -> 0x0066 }
        goto L_0x006a;
    L_0x0066:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
    L_0x006a:
        r12 = r12 + 1;	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r0 = r9.m31932a(r10, r11, r12);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        if (r5 == 0) goto L_0x0075;
    L_0x0072:
        r5.disconnect();
    L_0x0075:
        return r0;
    L_0x0076:
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r6) goto L_0x0093;
    L_0x007a:
        r6 = r5.getErrorStream();	 Catch:{ FileNotFoundException -> 0x00a6 }
        if (r6 == 0) goto L_0x0093;	 Catch:{ FileNotFoundException -> 0x00a6 }
    L_0x0080:
        r6 = new io.branch.referral.network.BranchRemoteInterface$BranchResponse;	 Catch:{ FileNotFoundException -> 0x00a6 }
        r7 = r5.getErrorStream();	 Catch:{ FileNotFoundException -> 0x00a6 }
        r7 = m31933a(r7);	 Catch:{ FileNotFoundException -> 0x00a6 }
        r6.<init>(r7, r0);	 Catch:{ FileNotFoundException -> 0x00a6 }
        if (r5 == 0) goto L_0x0092;
    L_0x008f:
        r5.disconnect();
    L_0x0092:
        return r6;
    L_0x0093:
        r6 = new io.branch.referral.network.BranchRemoteInterface$BranchResponse;	 Catch:{ FileNotFoundException -> 0x00a6 }
        r7 = r5.getInputStream();	 Catch:{ FileNotFoundException -> 0x00a6 }
        r7 = m31933a(r7);	 Catch:{ FileNotFoundException -> 0x00a6 }
        r6.<init>(r7, r0);	 Catch:{ FileNotFoundException -> 0x00a6 }
        if (r5 == 0) goto L_0x00a5;
    L_0x00a2:
        r5.disconnect();
    L_0x00a5:
        return r6;
    L_0x00a6:
        r6 = "BranchSDK";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r7 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r8 = "A resource conflict occurred with this request ";	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r7.<init>(r8);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r7.append(r10);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r7 = r7.toString();	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        io.branch.referral.PrefHelper.m26161b(r6, r7);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r6 = new io.branch.referral.network.BranchRemoteInterface$BranchResponse;	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        r6.<init>(r3, r0);	 Catch:{ SocketTimeoutException -> 0x00c9, IOException -> 0x00c6, Exception -> 0x00c4 }
        if (r5 == 0) goto L_0x00c3;
    L_0x00c0:
        r5.disconnect();
    L_0x00c3:
        return r6;
    L_0x00c4:
        r10 = move-exception;
        goto L_0x00d1;
    L_0x00c6:
        r10 = move-exception;
        r3 = r5;
        goto L_0x010d;
    L_0x00c9:
        r3 = r5;
        goto L_0x0132;
    L_0x00cb:
        r10 = move-exception;
        r5 = r3;
        goto L_0x015a;
    L_0x00cf:
        r10 = move-exception;
        r5 = r3;
    L_0x00d1:
        r11 = r9.getClass();	 Catch:{ all -> 0x010a }
        r11 = r11.getSimpleName();	 Catch:{ all -> 0x010a }
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010a }
        r0 = "Exception: ";	 Catch:{ all -> 0x010a }
        r12.<init>(r0);	 Catch:{ all -> 0x010a }
        r0 = r10.getMessage();	 Catch:{ all -> 0x010a }
        r12.append(r0);	 Catch:{ all -> 0x010a }
        r12 = r12.toString();	 Catch:{ all -> 0x010a }
        io.branch.referral.PrefHelper.m26161b(r11, r12);	 Catch:{ all -> 0x010a }
        r11 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x010a }
        r12 = 11;	 Catch:{ all -> 0x010a }
        if (r11 < r12) goto L_0x00ff;	 Catch:{ all -> 0x010a }
    L_0x00f4:
        r10 = r10 instanceof android.os.NetworkOnMainThreadException;	 Catch:{ all -> 0x010a }
        if (r10 == 0) goto L_0x00ff;	 Catch:{ all -> 0x010a }
    L_0x00f8:
        r10 = "BranchSDK";	 Catch:{ all -> 0x010a }
        r11 = "Branch Error: Don't call our synchronous methods on the main thread!!!";	 Catch:{ all -> 0x010a }
        android.util.Log.i(r10, r11);	 Catch:{ all -> 0x010a }
    L_0x00ff:
        r10 = new io.branch.referral.network.BranchRemoteInterface$BranchResponse;	 Catch:{ all -> 0x010a }
        r10.<init>(r3, r2);	 Catch:{ all -> 0x010a }
        if (r5 == 0) goto L_0x0109;
    L_0x0106:
        r5.disconnect();
    L_0x0109:
        return r10;
    L_0x010a:
        r10 = move-exception;
        goto L_0x015a;
    L_0x010c:
        r10 = move-exception;
    L_0x010d:
        r11 = r9.getClass();	 Catch:{ all -> 0x00cb }
        r11 = r11.getSimpleName();	 Catch:{ all -> 0x00cb }
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00cb }
        r0 = "Http connect exception: ";	 Catch:{ all -> 0x00cb }
        r12.<init>(r0);	 Catch:{ all -> 0x00cb }
        r10 = r10.getMessage();	 Catch:{ all -> 0x00cb }
        r12.append(r10);	 Catch:{ all -> 0x00cb }
        r10 = r12.toString();	 Catch:{ all -> 0x00cb }
        io.branch.referral.PrefHelper.m26161b(r11, r10);	 Catch:{ all -> 0x00cb }
        r10 = new io.branch.referral.network.BranchRemoteInterface$BranchRemoteException;	 Catch:{ all -> 0x00cb }
        r11 = -113; // 0xffffffffffffff8f float:NaN double:NaN;	 Catch:{ all -> 0x00cb }
        r10.<init>(r11);	 Catch:{ all -> 0x00cb }
        throw r10;	 Catch:{ all -> 0x00cb }
    L_0x0132:
        r0 = "bnc_retry_count";	 Catch:{ all -> 0x00cb }
        r0 = io.branch.referral.PrefHelper.m26160b(r0, r1);	 Catch:{ all -> 0x00cb }
        if (r12 >= r0) goto L_0x0152;
    L_0x013a:
        r0 = io.branch.referral.PrefHelper.m26164c();	 Catch:{ InterruptedException -> 0x0143 }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0143 }
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0143 }
        goto L_0x0147;
    L_0x0143:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00cb }
    L_0x0147:
        r12 = r12 + r4;	 Catch:{ all -> 0x00cb }
        r10 = r9.m31932a(r10, r11, r12);	 Catch:{ all -> 0x00cb }
        if (r3 == 0) goto L_0x0151;
    L_0x014e:
        r3.disconnect();
    L_0x0151:
        return r10;
    L_0x0152:
        r10 = new io.branch.referral.network.BranchRemoteInterface$BranchRemoteException;	 Catch:{ all -> 0x00cb }
        r11 = -111; // 0xffffffffffffff91 float:NaN double:NaN;	 Catch:{ all -> 0x00cb }
        r10.<init>(r11);	 Catch:{ all -> 0x00cb }
        throw r10;	 Catch:{ all -> 0x00cb }
    L_0x015a:
        if (r5 == 0) goto L_0x015f;
    L_0x015c:
        r5.disconnect();
    L_0x015f:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterfaceUrlConnection.a(java.lang.String, org.json.JSONObject, int):io.branch.referral.network.BranchRemoteInterface$BranchResponse");
    }

    private static java.lang.String m31933a(java.io.InputStream r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 == 0) goto L_0x0011;
    L_0x0002:
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r2);
        r0.<init>(r1);
        r2 = r0.readLine();	 Catch:{ IOException -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r2 = 0;
    L_0x0012:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterfaceUrlConnection.a(java.io.InputStream):java.lang.String");
    }
}
