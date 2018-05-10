package io.branch.referral.network;

import android.content.Context;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class BranchRemoteInterface {

    public static class BranchRemoteException extends Exception {
        private int f24675a = -113;

        public BranchRemoteException(int i) {
            this.f24675a = i;
        }
    }

    public static class BranchResponse {
        private final String f24676a;
        private final int f24677b;

        public BranchResponse(String str, int i) {
            this.f24676a = str;
            this.f24677b = i;
        }
    }

    public final io.branch.referral.ServerResponse m26226a(java.lang.String r5, org.json.JSONObject r6, java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00b7 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        if (r6 == 0) goto L_0x0003;
    L_0x0002:
        goto L_0x0008;
    L_0x0003:
        r6 = new org.json.JSONObject;
        r6.<init>();
    L_0x0008:
        r8 = m26225a(r6, r8);
        if (r8 == 0) goto L_0x011f;
    L_0x000e:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r8.append(r5);
        r5 = m26224a(r6);
        r8.append(r5);
        r5 = r8.toString();
        r0 = java.lang.System.currentTimeMillis();
        r6 = "BranchSDK";
        r8 = new java.lang.StringBuilder;
        r2 = "getting ";
        r8.<init>(r2);
        r8.append(r5);
        r8 = r8.toString();
        io.branch.referral.PrefHelper.m26161b(r6, r8);
        r5 = r4.mo5558a(r5);	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r6 = r5.f24676a;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r5 = r5.f24677b;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r5 = r4.m26222a(r6, r5, r7);	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x0077;
    L_0x004e:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x0077:
        return r5;
    L_0x0078:
        r5 = move-exception;
        goto L_0x00ef;
    L_0x007a:
        r5 = move-exception;
        r5 = r5.f24675a;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r6 = -111; // 0xffffffffffffff91 float:NaN double:NaN;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        if (r5 != r6) goto L_0x00b8;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
    L_0x0083:
        r5 = new io.branch.referral.ServerResponse;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r5.<init>(r7, r6);	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x00b7;
    L_0x008e:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x00b7:
        return r5;
    L_0x00b8:
        r5 = new io.branch.referral.ServerResponse;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r6 = -113; // 0xffffffffffffff8f float:NaN double:NaN;	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r5.<init>(r7, r6);	 Catch:{ BranchRemoteException -> 0x007a, all -> 0x0078 }
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x00ee;
    L_0x00c5:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x00ee:
        return r5;
    L_0x00ef:
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x011e;
    L_0x00f5:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x011e:
        throw r5;
    L_0x011f:
        r5 = new io.branch.referral.ServerResponse;
        r6 = -114; // 0xffffffffffffff8e float:NaN double:NaN;
        r5.<init>(r7, r6);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterface.a(java.lang.String, org.json.JSONObject, java.lang.String, java.lang.String):io.branch.referral.ServerResponse");
    }

    public final io.branch.referral.ServerResponse m26227a(org.json.JSONObject r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00c3 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = java.lang.System.currentTimeMillis();
        if (r5 == 0) goto L_0x0007;
    L_0x0006:
        goto L_0x000c;
    L_0x0007:
        r5 = new org.json.JSONObject;
        r5.<init>();
    L_0x000c:
        r8 = m26225a(r5, r8);
        if (r8 != 0) goto L_0x001a;
    L_0x0012:
        r5 = new io.branch.referral.ServerResponse;
        r6 = -114; // 0xffffffffffffff8e float:NaN double:NaN;
        r5.<init>(r7, r6);
        return r5;
    L_0x001a:
        r8 = "BranchSDK";
        r2 = new java.lang.StringBuilder;
        r3 = "posting to ";
        r2.<init>(r3);
        r2.append(r6);
        r2 = r2.toString();
        io.branch.referral.PrefHelper.m26161b(r8, r2);
        r8 = "BranchSDK";
        r2 = new java.lang.StringBuilder;
        r3 = "Post value = ";
        r2.<init>(r3);
        r3 = r5.toString();
        r2.append(r3);
        r2 = r2.toString();
        io.branch.referral.PrefHelper.m26161b(r8, r2);
        r5 = r4.mo5559a(r6, r5);	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r6 = r5.f24676a;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r5 = r5.f24677b;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r5 = r4.m26222a(r6, r5, r7);	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x0083;
    L_0x005a:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x0083:
        return r5;
    L_0x0084:
        r5 = move-exception;
        goto L_0x00fb;
    L_0x0086:
        r5 = move-exception;
        r5 = r5.f24675a;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r6 = -111; // 0xffffffffffffff91 float:NaN double:NaN;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        if (r5 != r6) goto L_0x00c4;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
    L_0x008f:
        r5 = new io.branch.referral.ServerResponse;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r5.<init>(r7, r6);	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x00c3;
    L_0x009a:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x00c3:
        return r5;
    L_0x00c4:
        r5 = new io.branch.referral.ServerResponse;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r6 = -113; // 0xffffffffffffff8f float:NaN double:NaN;	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r5.<init>(r7, r6);	 Catch:{ BranchRemoteException -> 0x0086, all -> 0x0084 }
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x00fa;
    L_0x00d1:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x00fa:
        return r5;
    L_0x00fb:
        r6 = io.branch.referral.Branch.m31871a();
        if (r6 == 0) goto L_0x012a;
    L_0x0101:
        r2 = java.lang.System.currentTimeMillis();
        r2 = r2 - r0;
        r6 = (int) r2;
        r8 = io.branch.referral.Branch.m31871a();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "-";
        r0.append(r7);
        r7 = io.branch.referral.Defines.Jsonkey.Branch_Round_Trip_Time;
        r7 = r7.bc;
        r0.append(r7);
        r7 = r0.toString();
        r6 = java.lang.String.valueOf(r6);
        r8.m31914a(r7, r6);
    L_0x012a:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterface.a(org.json.JSONObject, java.lang.String, java.lang.String, java.lang.String):io.branch.referral.ServerResponse");
    }

    public abstract BranchResponse mo5558a(String str) throws BranchRemoteException;

    public abstract BranchResponse mo5559a(String str, JSONObject jSONObject) throws BranchRemoteException;

    public static final BranchRemoteInterface m26223a(Context context) {
        return new BranchRemoteInterfaceUrlConnection(context);
    }

    private io.branch.referral.ServerResponse m26222a(java.lang.String r3, int r4, java.lang.String r5) {
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
        r0 = new io.branch.referral.ServerResponse;
        r0.<init>(r5, r4);
        r4 = "BranchSDK";
        r5 = new java.lang.StringBuilder;
        r1 = "returned ";
        r5.<init>(r1);
        r5.append(r3);
        r5 = r5.toString();
        io.branch.referral.PrefHelper.m26161b(r4, r5);
        if (r3 == 0) goto L_0x0048;
    L_0x001a:
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0022 }
        r4.<init>(r3);	 Catch:{ JSONException -> 0x0022 }
        r0.f24665b = r4;	 Catch:{ JSONException -> 0x0022 }
        goto L_0x0048;
    L_0x0022:
        r4 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x002a }
        r4.<init>(r3);	 Catch:{ JSONException -> 0x002a }
        r0.f24665b = r4;	 Catch:{ JSONException -> 0x002a }
        goto L_0x0048;
    L_0x002a:
        r3 = move-exception;
        r4 = r2.getClass();
        r4 = r4.getSimpleName();
        r5 = new java.lang.StringBuilder;
        r1 = "JSON exception: ";
        r5.<init>(r1);
        r3 = r3.getMessage();
        r5.append(r3);
        r3 = r5.toString();
        io.branch.referral.PrefHelper.m26161b(r4, r3);
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterface.a(java.lang.String, int, java.lang.String):io.branch.referral.ServerResponse");
    }

    private static boolean m26225a(org.json.JSONObject r2, java.lang.String r3) {
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
        r0 = "sdk";	 Catch:{ JSONException -> 0x0018 }
        r1 = "android2.12.0";	 Catch:{ JSONException -> 0x0018 }
        r2.put(r0, r1);	 Catch:{ JSONException -> 0x0018 }
        r0 = "bnc_no_value";	 Catch:{ JSONException -> 0x0018 }
        r0 = r3.equals(r0);	 Catch:{ JSONException -> 0x0018 }
        if (r0 != 0) goto L_0x0018;	 Catch:{ JSONException -> 0x0018 }
    L_0x000f:
        r0 = io.branch.referral.Defines.Jsonkey.BranchKey;	 Catch:{ JSONException -> 0x0018 }
        r0 = r0.bc;	 Catch:{ JSONException -> 0x0018 }
        r2.put(r0, r3);	 Catch:{ JSONException -> 0x0018 }
        r2 = 1;
        return r2;
    L_0x0018:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.network.BranchRemoteInterface.a(org.json.JSONObject, java.lang.String):boolean");
    }

    private static String m26224a(JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder();
        if (jSONObject != null) {
            JSONArray names = jSONObject.names();
            if (names != null) {
                int length = names.length();
                Object obj = 1;
                int i = 0;
                while (i < length) {
                    try {
                        String string = names.getString(i);
                        if (obj != null) {
                            stringBuilder.append(Operation.EMPTY_PARAM);
                            obj = null;
                        } else {
                            stringBuilder.append("&");
                        }
                        String string2 = jSONObject.getString(string);
                        stringBuilder.append(string);
                        stringBuilder.append(Operation.EQUALS);
                        stringBuilder.append(string2);
                        i++;
                    } catch (JSONObject jSONObject2) {
                        jSONObject2.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
