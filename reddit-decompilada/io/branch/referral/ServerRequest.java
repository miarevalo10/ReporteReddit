package io.branch.referral;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import io.branch.referral.Defines.Jsonkey;
import io.branch.referral.Defines.RequestPath;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public abstract class ServerRequest {
    private static final String POST_KEY = "REQ_POST";
    private static final String POST_PATH_KEY = "REQ_POST_PATH";
    public boolean constructError_ = false;
    private boolean disableAndroidIDFetch_;
    final Set<PROCESS_WAIT_LOCK> locks_;
    private JSONObject params_;
    protected PrefHelper prefHelper_;
    long queueWaitTime_ = 0;
    protected String requestPath_;
    boolean skipOnTimeOut = false;
    private final SystemObserver systemObserver_;
    private int waitLockCnt = 0;

    enum PROCESS_WAIT_LOCK {
        FB_APP_LINK_WAIT_LOCK,
        GAID_FETCH_WAIT_LOCK,
        INTENT_PENDING_WAIT_LOCK,
        STRONG_MATCH_PENDING_WAIT_LOCK,
        INSTALL_REFERRER_FETCH_WAIT_LOCK
    }

    public abstract void clearCallbacks();

    public abstract boolean handleErrors(Context context);

    public abstract void handleFailure(int i, String str);

    public boolean isGAdsParamsRequired() {
        return false;
    }

    public abstract boolean isGetRequest();

    public void onPreExecute() {
    }

    public abstract void onRequestSucceeded(ServerResponse serverResponse, Branch branch);

    public boolean shouldRetryOnFail() {
        return false;
    }

    public ServerRequest(Context context, String str) {
        this.requestPath_ = str;
        this.prefHelper_ = PrefHelper.m26151a(context);
        this.systemObserver_ = new SystemObserver(context);
        this.params_ = new JSONObject();
        this.disableAndroidIDFetch_ = Branch.m31887b();
        this.locks_ = new HashSet();
    }

    protected ServerRequest(String str, JSONObject jSONObject, Context context) {
        this.requestPath_ = str;
        this.params_ = jSONObject;
        this.prefHelper_ = PrefHelper.m26151a(context);
        this.systemObserver_ = new SystemObserver(context);
        this.disableAndroidIDFetch_ = Branch.m31887b();
        this.locks_ = new HashSet();
    }

    public final String getRequestPath() {
        return this.requestPath_;
    }

    public String getRequestUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PrefHelper.m26152a());
        stringBuilder.append(this.requestPath_);
        return stringBuilder.toString();
    }

    protected void setPost(org.json.JSONObject r5) {
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
        r4 = this;
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005f }
        r0.<init>();	 Catch:{ JSONException -> 0x005f }
        r1 = r4.prefHelper_;	 Catch:{ JSONException -> 0x005f }
        r1 = r1.f24649a;	 Catch:{ JSONException -> 0x005f }
        r1 = r1.keys();	 Catch:{ JSONException -> 0x005f }
    L_0x000d:
        r2 = r1.hasNext();	 Catch:{ JSONException -> 0x005f }
        if (r2 == 0) goto L_0x0025;	 Catch:{ JSONException -> 0x005f }
    L_0x0013:
        r2 = r1.next();	 Catch:{ JSONException -> 0x005f }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x005f }
        r3 = r4.prefHelper_;	 Catch:{ JSONException -> 0x005f }
        r3 = r3.f24649a;	 Catch:{ JSONException -> 0x005f }
        r3 = r3.get(r2);	 Catch:{ JSONException -> 0x005f }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x005f }
        goto L_0x000d;	 Catch:{ JSONException -> 0x005f }
    L_0x0025:
        r1 = io.branch.referral.Defines.Jsonkey.Metadata;	 Catch:{ JSONException -> 0x005f }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x005f }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x005f }
        if (r1 == 0) goto L_0x0057;	 Catch:{ JSONException -> 0x005f }
    L_0x002f:
        r1 = io.branch.referral.Defines.Jsonkey.Metadata;	 Catch:{ JSONException -> 0x005f }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x005f }
        r1 = r5.getJSONObject(r1);	 Catch:{ JSONException -> 0x005f }
        r1 = r1.keys();	 Catch:{ JSONException -> 0x005f }
    L_0x003b:
        r2 = r1.hasNext();	 Catch:{ JSONException -> 0x005f }
        if (r2 == 0) goto L_0x0057;	 Catch:{ JSONException -> 0x005f }
    L_0x0041:
        r2 = r1.next();	 Catch:{ JSONException -> 0x005f }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x005f }
        r3 = io.branch.referral.Defines.Jsonkey.Metadata;	 Catch:{ JSONException -> 0x005f }
        r3 = r3.bc;	 Catch:{ JSONException -> 0x005f }
        r3 = r5.getJSONObject(r3);	 Catch:{ JSONException -> 0x005f }
        r3 = r3.get(r2);	 Catch:{ JSONException -> 0x005f }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x005f }
        goto L_0x003b;	 Catch:{ JSONException -> 0x005f }
    L_0x0057:
        r1 = io.branch.referral.Defines.Jsonkey.Metadata;	 Catch:{ JSONException -> 0x005f }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x005f }
        r5.put(r1, r0);	 Catch:{ JSONException -> 0x005f }
        goto L_0x0066;
    L_0x005f:
        r0 = "BranchSDK";
        r1 = "Could not merge metadata, ignoring user metadata.";
        android.util.Log.e(r0, r1);
    L_0x0066:
        r4.params_ = r5;
        r5 = io.branch.referral.PrefHelper.m26179j();
        r0 = r4.systemObserver_;
        r1 = r4.disableAndroidIDFetch_;
        r5 = io.branch.referral.DeviceInfo.m26139a(r5, r0, r1);
        r0 = r4.params_;
        r1 = r5.f24625a;	 Catch:{ JSONException -> 0x012c }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x012c }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x012c }
        if (r1 != 0) goto L_0x0092;	 Catch:{ JSONException -> 0x012c }
    L_0x0080:
        r1 = io.branch.referral.Defines.Jsonkey.HardwareID;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24625a;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
        r1 = io.branch.referral.Defines.Jsonkey.IsHardwareIDReal;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24626b;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
    L_0x0092:
        r1 = r5.f24627c;	 Catch:{ JSONException -> 0x012c }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x012c }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x012c }
        if (r1 != 0) goto L_0x00a5;	 Catch:{ JSONException -> 0x012c }
    L_0x009c:
        r1 = io.branch.referral.Defines.Jsonkey.Brand;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24627c;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
    L_0x00a5:
        r1 = r5.f24628d;	 Catch:{ JSONException -> 0x012c }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x012c }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x012c }
        if (r1 != 0) goto L_0x00b8;	 Catch:{ JSONException -> 0x012c }
    L_0x00af:
        r1 = io.branch.referral.Defines.Jsonkey.Model;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24628d;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
    L_0x00b8:
        r1 = io.branch.referral.Defines.Jsonkey.ScreenDpi;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24629e;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
        r1 = io.branch.referral.Defines.Jsonkey.ScreenHeight;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24630f;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
        r1 = io.branch.referral.Defines.Jsonkey.ScreenWidth;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24631g;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
        r1 = io.branch.referral.Defines.Jsonkey.WiFi;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24632h;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
        r1 = r5.f24634j;	 Catch:{ JSONException -> 0x012c }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x012c }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x012c }
        if (r1 != 0) goto L_0x00ef;	 Catch:{ JSONException -> 0x012c }
    L_0x00e6:
        r1 = io.branch.referral.Defines.Jsonkey.OS;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24634j;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
    L_0x00ef:
        r1 = io.branch.referral.Defines.Jsonkey.OSVersion;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24635k;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
        r1 = r5.f24637m;	 Catch:{ JSONException -> 0x012c }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x012c }
        if (r1 != 0) goto L_0x0109;	 Catch:{ JSONException -> 0x012c }
    L_0x0100:
        r1 = io.branch.referral.Defines.Jsonkey.Country;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24637m;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
    L_0x0109:
        r1 = r5.f24638n;	 Catch:{ JSONException -> 0x012c }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x012c }
        if (r1 != 0) goto L_0x011a;	 Catch:{ JSONException -> 0x012c }
    L_0x0111:
        r1 = io.branch.referral.Defines.Jsonkey.Language;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r2 = r5.f24638n;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x012c }
    L_0x011a:
        r1 = r5.f24633i;	 Catch:{ JSONException -> 0x012c }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x012c }
        if (r1 != 0) goto L_0x012b;	 Catch:{ JSONException -> 0x012c }
    L_0x0122:
        r1 = io.branch.referral.Defines.Jsonkey.LocalIP;	 Catch:{ JSONException -> 0x012c }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x012c }
        r5 = r5.f24633i;	 Catch:{ JSONException -> 0x012c }
        r0.put(r1, r5);	 Catch:{ JSONException -> 0x012c }
    L_0x012b:
        return;
    L_0x012c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequest.setPost(org.json.JSONObject):void");
    }

    public JSONObject getPost() {
        return this.params_;
    }

    public org.json.JSONObject getPostWithInstrumentationValues(java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> r6) {
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
        r5 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = r5.params_;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        if (r1 == 0) goto L_0x002c;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x0009:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r2 = r5.params_;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r2 = r2.toString();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r2 = r1.keys();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x0018:
        r3 = r2.hasNext();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        if (r3 == 0) goto L_0x002c;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x001e:
        r3 = r2.next();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r4 = r1.get(r3);	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r0.put(r3, r4);	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        goto L_0x0018;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x002c:
        r1 = r6.size();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        if (r1 <= 0) goto L_0x0060;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x0032:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r1.<init>();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r2 = r6.keySet();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r2 = r2.iterator();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x003f:
        r3 = r2.hasNext();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        if (r3 == 0) goto L_0x0056;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x0045:
        r3 = r2.next();	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r4 = r6.get(r3);	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r1.put(r3, r4);	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r6.remove(r3);	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        goto L_0x003f;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
    L_0x0056:
        r6 = io.branch.referral.Defines.Jsonkey.Branch_Instrumentation;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r6 = r6.bc;	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        r0.put(r6, r1);	 Catch:{ JSONException -> 0x0060, ConcurrentModificationException -> 0x005e }
        goto L_0x0060;
    L_0x005e:
        r0 = r5.params_;
    L_0x0060:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequest.getPostWithInstrumentationValues(java.util.concurrent.ConcurrentHashMap):org.json.JSONObject");
    }

    public JSONObject getGetParams() {
        return this.params_;
    }

    protected void addGetParam(java.lang.String r2, java.lang.String r3) {
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
        r1 = this;
        r0 = r1.params_;	 Catch:{ JSONException -> 0x0006 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequest.addGetParam(java.lang.String, java.lang.String):void");
    }

    public org.json.JSONObject toJSON() {
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
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "REQ_POST";	 Catch:{ JSONException -> 0x0014 }
        r2 = r3.params_;	 Catch:{ JSONException -> 0x0014 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0014 }
        r1 = "REQ_POST_PATH";	 Catch:{ JSONException -> 0x0014 }
        r2 = r3.requestPath_;	 Catch:{ JSONException -> 0x0014 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequest.toJSON():org.json.JSONObject");
    }

    public static io.branch.referral.ServerRequest fromJSON(org.json.JSONObject r4, android.content.Context r5) {
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
        r0 = "";
        r1 = 0;
        r2 = "REQ_POST";	 Catch:{ JSONException -> 0x0012 }
        r2 = r4.has(r2);	 Catch:{ JSONException -> 0x0012 }
        if (r2 == 0) goto L_0x0012;	 Catch:{ JSONException -> 0x0012 }
    L_0x000b:
        r2 = "REQ_POST";	 Catch:{ JSONException -> 0x0012 }
        r2 = r4.getJSONObject(r2);	 Catch:{ JSONException -> 0x0012 }
        goto L_0x0013;
    L_0x0012:
        r2 = r1;
    L_0x0013:
        r3 = "REQ_POST_PATH";	 Catch:{ JSONException -> 0x0022 }
        r3 = r4.has(r3);	 Catch:{ JSONException -> 0x0022 }
        if (r3 == 0) goto L_0x0022;	 Catch:{ JSONException -> 0x0022 }
    L_0x001b:
        r3 = "REQ_POST_PATH";	 Catch:{ JSONException -> 0x0022 }
        r4 = r4.getString(r3);	 Catch:{ JSONException -> 0x0022 }
        r0 = r4;
    L_0x0022:
        if (r0 == 0) goto L_0x002f;
    L_0x0024:
        r4 = r0.length();
        if (r4 <= 0) goto L_0x002f;
    L_0x002a:
        r4 = getExtendedServerRequest(r0, r2, r5);
        return r4;
    L_0x002f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequest.fromJSON(org.json.JSONObject, android.content.Context):io.branch.referral.ServerRequest");
    }

    private static ServerRequest getExtendedServerRequest(String str, JSONObject jSONObject, Context context) {
        if (str.equalsIgnoreCase(RequestPath.CompletedAction.f24623l)) {
            return new ServerRequestActionCompleted(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.GetURL.f24623l)) {
            return new ServerRequestCreateUrl(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.GetCreditHistory.f24623l)) {
            return new ServerRequestGetRewardHistory(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.GetCredits.f24623l)) {
            return new ServerRequestGetRewards(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.IdentifyUser.f24623l)) {
            return new ServerRequestIdentifyUserRequest(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.Logout.f24623l)) {
            return new ServerRequestLogout(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.RedeemRewards.f24623l)) {
            return new ServerRequestRedeemRewards(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.RegisterClose.f24623l)) {
            return new ServerRequestRegisterClose(str, jSONObject, context);
        }
        if (str.equalsIgnoreCase(RequestPath.RegisterInstall.f24623l)) {
            return new ServerRequestRegisterInstall(str, jSONObject, context);
        }
        return str.equalsIgnoreCase(RequestPath.RegisterOpen.f24623l) ? new ServerRequestRegisterOpen(str, jSONObject, context) : null;
    }

    public void updateGAdsParams(SystemObserver systemObserver) {
        if (!TextUtils.isEmpty(systemObserver.f24671a)) {
            try {
                this.params_.put(Jsonkey.GoogleAdvertisingID.bc, systemObserver.f24671a);
                this.params_.put(Jsonkey.LATVal.bc, systemObserver.f24672b);
            } catch (SystemObserver systemObserver2) {
                systemObserver2.printStackTrace();
            }
        }
    }

    protected boolean doesAppHasInternetPermission(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.INTERNET") == null ? true : null;
    }

    public void onRequestQueued() {
        this.queueWaitTime_ = System.currentTimeMillis();
    }

    public long getQueueWaitTime() {
        if (this.queueWaitTime_ > 0) {
            return System.currentTimeMillis() - this.queueWaitTime_;
        }
        return 0;
    }

    public void addProcessWaitLock(PROCESS_WAIT_LOCK process_wait_lock) {
        if (process_wait_lock != null) {
            this.locks_.add(process_wait_lock);
        }
    }

    public void removeProcessWaitLock(PROCESS_WAIT_LOCK process_wait_lock) {
        this.locks_.remove(process_wait_lock);
    }

    public boolean isWaitingOnProcessToFinish() {
        return this.locks_.size() > 0;
    }

    protected void updateEnvironment(android.content.Context r2, org.json.JSONObject r3) {
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
        r1 = this;
        r2 = isPackageInstalled(r2);	 Catch:{ Exception -> 0x0017 }
        if (r2 == 0) goto L_0x000b;	 Catch:{ Exception -> 0x0017 }
    L_0x0006:
        r2 = io.branch.referral.Defines.Jsonkey.NativeApp;	 Catch:{ Exception -> 0x0017 }
        r2 = r2.bc;	 Catch:{ Exception -> 0x0017 }
        goto L_0x000f;	 Catch:{ Exception -> 0x0017 }
    L_0x000b:
        r2 = io.branch.referral.Defines.Jsonkey.InstantApp;	 Catch:{ Exception -> 0x0017 }
        r2 = r2.bc;	 Catch:{ Exception -> 0x0017 }
    L_0x000f:
        r0 = io.branch.referral.Defines.Jsonkey.Environment;	 Catch:{ Exception -> 0x0017 }
        r0 = r0.bc;	 Catch:{ Exception -> 0x0017 }
        r3.put(r0, r2);	 Catch:{ Exception -> 0x0017 }
        return;
    L_0x0017:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequest.updateEnvironment(android.content.Context, org.json.JSONObject):void");
    }

    private static boolean isPackageInstalled(Context context) {
        PackageManager packageManager = context.getPackageManager();
        context = packageManager.getLaunchIntentForPackage(context.getPackageName());
        if (context == null) {
            return false;
        }
        context = packageManager.queryIntentActivities(context, 65536);
        if (context == null || context.size() <= null) {
            return false;
        }
        return true;
    }
}
