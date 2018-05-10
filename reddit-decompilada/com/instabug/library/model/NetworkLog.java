package com.instabug.library.model;

import android.content.ContentValues;
import android.content.Context;
import com.instabug.library.internal.storage.cache.p024a.C0683a;
import com.instabug.library.internal.storage.cache.p024a.C0685c;
import net.hockeyapp.android.UpdateFragment;

public class NetworkLog {
    public static final String CONTENT_TYPE = "content-type";
    public static final String HTML = "text/html";
    public static final String JSON = "application/json";
    public static final String LIMIT_ERROR = "{\"InstabugNetworkLog Error\":\"Response body exceeded limit\"}";
    public static final String PLAIN_TEXT = "text/plain";
    public static final String XML_1 = "application/xml";
    public static final String XML_2 = "text/xml";
    private String date;
    private String headers;
    private String method;
    private String request;
    private String response;
    private int responseCode;
    private long totalDuration;
    private String url;

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getRequest() {
        return this.request;
    }

    public void setRequest(String str) {
        this.request = str;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    public String getHeaders() {
        return this.headers;
    }

    public void setHeaders(String str) {
        this.headers = str;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    public void setTotalDuration(long j) {
        this.totalDuration = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
        r7 = this;
        r0 = 1;
        if (r7 != r8) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r8 instanceof com.instabug.library.model.NetworkLog;
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r2;
    L_0x000a:
        r8 = (com.instabug.library.model.NetworkLog) r8;
        r1 = r7.responseCode;
        r3 = r8.responseCode;
        if (r1 == r3) goto L_0x0013;
    L_0x0012:
        return r2;
    L_0x0013:
        r1 = r7.date;
        if (r1 == 0) goto L_0x0022;
    L_0x0017:
        r1 = r7.date;
        r3 = r8.date;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0027;
    L_0x0021:
        goto L_0x0026;
    L_0x0022:
        r1 = r8.date;
        if (r1 == 0) goto L_0x0027;
    L_0x0026:
        return r2;
    L_0x0027:
        r1 = r7.url;
        if (r1 == 0) goto L_0x0036;
    L_0x002b:
        r1 = r7.url;
        r3 = r8.url;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x003b;
    L_0x0035:
        goto L_0x003a;
    L_0x0036:
        r1 = r8.url;
        if (r1 == 0) goto L_0x003b;
    L_0x003a:
        return r2;
    L_0x003b:
        r1 = r7.request;
        if (r1 == 0) goto L_0x004a;
    L_0x003f:
        r1 = r7.request;
        r3 = r8.request;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x004f;
    L_0x0049:
        goto L_0x004e;
    L_0x004a:
        r1 = r8.request;
        if (r1 == 0) goto L_0x004f;
    L_0x004e:
        return r2;
    L_0x004f:
        r1 = r7.response;
        if (r1 == 0) goto L_0x005e;
    L_0x0053:
        r1 = r7.response;
        r3 = r8.response;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0063;
    L_0x005d:
        goto L_0x0062;
    L_0x005e:
        r1 = r8.response;
        if (r1 == 0) goto L_0x0063;
    L_0x0062:
        return r2;
    L_0x0063:
        r1 = r7.method;
        if (r1 == 0) goto L_0x0072;
    L_0x0067:
        r1 = r7.method;
        r3 = r8.method;
        r1 = r1.equals(r3);
        if (r1 != 0) goto L_0x0077;
    L_0x0071:
        goto L_0x0076;
    L_0x0072:
        r1 = r8.method;
        if (r1 == 0) goto L_0x0077;
    L_0x0076:
        return r2;
    L_0x0077:
        r3 = r7.totalDuration;
        r5 = r8.totalDuration;
        r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r1 == 0) goto L_0x0080;
    L_0x007f:
        return r2;
    L_0x0080:
        r1 = r7.headers;
        if (r1 == 0) goto L_0x008d;
    L_0x0084:
        r0 = r7.headers;
        r8 = r8.headers;
        r8 = r0.equals(r8);
        return r8;
    L_0x008d:
        r8 = r8.headers;
        if (r8 != 0) goto L_0x0092;
    L_0x0091:
        return r0;
    L_0x0092:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.NetworkLog.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((this.date != null ? this.date.hashCode() : 0) * 31) + (this.url != null ? this.url.hashCode() : 0)) * 31) + (this.request != null ? this.request.hashCode() : 0)) * 31) + (this.response != null ? this.response.hashCode() : 0)) * 31) + (this.method != null ? this.method.hashCode() : 0)) * 31) + this.responseCode) * 31;
        if (this.headers != null) {
            i = this.headers.hashCode();
        }
        return (31 * (hashCode + i)) + Long.valueOf(this.totalDuration).hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkLog{date='");
        stringBuilder.append(this.date);
        stringBuilder.append('\'');
        stringBuilder.append(", url='");
        stringBuilder.append(this.url);
        stringBuilder.append('\'');
        stringBuilder.append(", request='");
        stringBuilder.append(this.request);
        stringBuilder.append('\'');
        stringBuilder.append(", method='");
        stringBuilder.append(this.method);
        stringBuilder.append('\'');
        stringBuilder.append(", responseCode=");
        stringBuilder.append(this.responseCode);
        stringBuilder.append(", headers='");
        stringBuilder.append(this.headers);
        stringBuilder.append('\'');
        stringBuilder.append(", response='");
        stringBuilder.append(this.response);
        stringBuilder.append('\'');
        stringBuilder.append(", totalDuration='");
        stringBuilder.append(this.totalDuration);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Deprecated
    public long insert(Context context) {
        return insert();
    }

    public long insert() {
        C0683a.m8190a();
        C0685c b = C0683a.m8192b();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(UpdateFragment.FRAGMENT_URL, getUrl());
            contentValues.put("request", getRequest());
            contentValues.put("method", getMethod());
            contentValues.put("response", getResponse());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getResponseCode());
            contentValues.put("status", stringBuilder.toString());
            contentValues.put("date", getDate());
            contentValues.put("headers", getHeaders());
            contentValues.put("response_time", Long.valueOf(getTotalDuration()));
            long a = b.m8194a("network_logs", contentValues);
            return a;
        } finally {
            b.m8198b();
        }
    }

    public org.json.JSONObject toJsonObject() throws org.json.JSONException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "date";
        r2 = r4.getDate();
        r0.put(r1, r2);
        r1 = "method";
        r2 = r4.getMethod();
        r0.put(r1, r2);
        r1 = "status";
        r2 = r4.getResponseCode();
        r0.put(r1, r2);
        r1 = "url";
        r2 = r4.getUrl();
        r0.put(r1, r2);
        r1 = "response_time";
        r2 = r4.getTotalDuration();
        r0.put(r1, r2);
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0041 }
        r2 = r4.getHeaders();	 Catch:{ Exception -> 0x0041 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0041 }
        r2 = "headers";	 Catch:{ Exception -> 0x0041 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0041 }
        goto L_0x004a;
    L_0x0041:
        r1 = "headers";
        r2 = r4.getHeaders();
        r0.put(r1, r2);
    L_0x004a:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0059 }
        r2 = r4.getRequest();	 Catch:{ Exception -> 0x0059 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0059 }
        r2 = "request";	 Catch:{ Exception -> 0x0059 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0059 }
        goto L_0x0062;
    L_0x0059:
        r1 = "request";
        r2 = r4.getRequest();
        r0.put(r1, r2);
    L_0x0062:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0071 }
        r2 = r4.getResponse();	 Catch:{ Exception -> 0x0071 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0071 }
        r2 = "response";	 Catch:{ Exception -> 0x0071 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0071 }
        goto L_0x007a;
    L_0x0071:
        r1 = "response";
        r2 = r4.getResponse();
        r0.put(r1, r2);
    L_0x007a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.NetworkLog.toJsonObject():org.json.JSONObject");
    }
}
