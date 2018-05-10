package com.instabug.library.logging;

import com.instabug.library.model.NetworkLog;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressFBWarnings({"NM_METHOD_NAMING_CONVENTION"})
public class InstabugNetworkLog {
    private NetworkLog networkLog = new NetworkLog();

    public void log(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, int r9) throws java.io.IOException {
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
        r0 = com.instabug.library.analytics.AnalyticsObserver.getInstance();
        r1 = 3;
        r1 = new com.instabug.library.analytics.model.Api.Parameter[r1];
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "connection";
        r2 = r2.setName(r3);
        r3 = java.net.HttpURLConnection.class;
        r2 = r2.setType(r3);
        r3 = 0;
        r1[r3] = r2;
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "requestBody";
        r2 = r2.setName(r3);
        r3 = java.lang.String.class;
        r2 = r2.setType(r3);
        r3 = 1;
        r1[r3] = r2;
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "responseBody";
        r2 = r2.setName(r3);
        r3 = java.lang.String.class;
        r2 = r2.setType(r3);
        r3 = 2;
        r1[r3] = r2;
        r0.catchApiUsage(r1);
        r0 = r4.networkLog;
        r0.setResponseCode(r9);
        r9 = r4.networkLog;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.instabug.library.util.InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds();
        r0.append(r1);
        r0 = r0.toString();
        r9.setDate(r0);
        r9 = r4.networkLog;
        r9.setMethod(r6);
        r6 = r4.networkLog;
        r6.setUrl(r5);
        r5 = r4.networkLog;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r6 = r4.validateBody(r7);	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5.setRequest(r6);	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5 = r4.networkLog;	 Catch:{ IllegalArgumentException -> 0x0097 }
        r6 = r4.validateBody(r8);	 Catch:{ IllegalArgumentException -> 0x0097 }
        r5.setResponse(r6);	 Catch:{ IllegalArgumentException -> 0x0097 }
        r4.insert();
        r5 = new java.lang.StringBuilder;
        r6 = "adding network log: ";
        r5.<init>(r6);
        r6 = r4.networkLog;
        r6 = r6.toString();
        r5.append(r6);
        r5 = r5.toString();
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);
        return;
    L_0x0097:
        r5 = "Content-type is not allowed to be logged";
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);
        r5 = 0;
        r4.networkLog = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.logging.InstabugNetworkLog.log(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    @java.lang.Deprecated
    public void Log(java.net.HttpURLConnection r5, java.lang.String r6, java.lang.String r7) throws java.io.IOException {
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
        r0 = com.instabug.library.analytics.AnalyticsObserver.getInstance();
        r1 = 3;
        r1 = new com.instabug.library.analytics.model.Api.Parameter[r1];
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "connection";
        r2 = r2.setName(r3);
        r3 = java.net.HttpURLConnection.class;
        r2 = r2.setType(r3);
        r3 = 0;
        r1[r3] = r2;
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "requestBody";
        r2 = r2.setName(r3);
        r3 = java.lang.String.class;
        r2 = r2.setType(r3);
        r3 = 1;
        r1[r3] = r2;
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "responseBody";
        r2 = r2.setName(r3);
        r3 = java.lang.String.class;
        r2 = r2.setType(r3);
        r3 = 2;
        r1[r3] = r2;
        r0.catchApiUsage(r1);
        r0 = r4.networkLog;
        r1 = r5.getResponseCode();
        r0.setResponseCode(r1);
        r0 = r4.networkLog;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.instabug.library.util.InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds();
        r1.append(r2);
        r1 = r1.toString();
        r0.setDate(r1);
        r0 = r4.networkLog;
        r1 = r5.getRequestMethod();
        r0.setMethod(r1);
        r0 = r4.networkLog;
        r1 = r5.getURL();
        r1 = r1.toString();
        r0.setUrl(r1);
        r4.addHeaders(r5);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5 = r4.networkLog;	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r6 = r4.validateBody(r6);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5.setRequest(r6);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5 = r4.networkLog;	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r6 = r4.validateBody(r7);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5.setResponse(r6);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        goto L_0x009d;
    L_0x0090:
        r5 = "Content-type is not allowed to be logged";
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);
        r5 = 0;
        r4.networkLog = r5;
        return;
    L_0x0099:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x009d:
        r4.insert();
        r5 = new java.lang.StringBuilder;
        r6 = "adding network log: ";
        r5.<init>(r6);
        r6 = r4.networkLog;
        r6 = r6.toString();
        r5.append(r6);
        r5 = r5.toString();
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.logging.InstabugNetworkLog.Log(java.net.HttpURLConnection, java.lang.String, java.lang.String):void");
    }

    private String validateBody(String str) {
        if (str == null) {
            return null;
        }
        return ((long) str.getBytes(Charset.forName("UTF-8")).length) > 1000000 ? NetworkLog.LIMIT_ERROR : str;
    }

    public void log(java.net.HttpURLConnection r5, java.lang.String r6, java.lang.String r7) throws java.io.IOException {
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
        r0 = com.instabug.library.analytics.AnalyticsObserver.getInstance();
        r1 = 3;
        r1 = new com.instabug.library.analytics.model.Api.Parameter[r1];
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "connection";
        r2 = r2.setName(r3);
        r3 = java.net.HttpURLConnection.class;
        r2 = r2.setType(r3);
        r3 = 0;
        r1[r3] = r2;
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "requestBody";
        r2 = r2.setName(r3);
        r3 = java.lang.String.class;
        r2 = r2.setType(r3);
        r3 = 1;
        r1[r3] = r2;
        r2 = new com.instabug.library.analytics.model.Api$Parameter;
        r2.<init>();
        r3 = "responseBody";
        r2 = r2.setName(r3);
        r3 = java.lang.String.class;
        r2 = r2.setType(r3);
        r3 = 2;
        r1[r3] = r2;
        r0.catchApiUsage(r1);
        r0 = r4.networkLog;
        r1 = r5.getResponseCode();
        r0.setResponseCode(r1);
        r0 = r4.networkLog;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = com.instabug.library.util.InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds();
        r1.append(r2);
        r1 = r1.toString();
        r0.setDate(r1);
        r0 = r4.networkLog;
        r1 = r5.getRequestMethod();
        r0.setMethod(r1);
        r0 = r4.networkLog;
        r1 = r5.getURL();
        r1 = r1.toString();
        r0.setUrl(r1);
        r4.addHeaders(r5);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5 = r4.networkLog;	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r6 = r4.validateBody(r6);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5.setRequest(r6);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5 = r4.networkLog;	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r6 = r4.validateBody(r7);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        r5.setResponse(r6);	 Catch:{ JSONException -> 0x0099, IllegalArgumentException -> 0x0090 }
        goto L_0x009d;
    L_0x0090:
        r5 = "Content-type is not allowed to be logged";
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);
        r5 = 0;
        r4.networkLog = r5;
        return;
    L_0x0099:
        r5 = move-exception;
        r5.printStackTrace();
    L_0x009d:
        r4.insert();
        r5 = new java.lang.StringBuilder;
        r6 = "adding network log: ";
        r5.<init>(r6);
        r6 = r4.networkLog;
        r6 = r6.toString();
        r5.append(r6);
        r5 = r5.toString();
        com.instabug.library.util.InstabugSDKLogger.m8356d(r4, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.logging.InstabugNetworkLog.log(java.net.HttpURLConnection, java.lang.String, java.lang.String):void");
    }

    private void addHeaders(HttpURLConnection httpURLConnection) throws JSONException, IllegalArgumentException {
        JSONObject jSONObject = new JSONObject();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            if (str != null) {
                for (String str2 : (List) httpURLConnection.getHeaderFields().get(str)) {
                    if (!str.equalsIgnoreCase(NetworkLog.CONTENT_TYPE) || str2.contains("application/json") || str2.contains(NetworkLog.XML_1) || str2.contains(NetworkLog.XML_2) || str2.contains(NetworkLog.HTML) || str2.contains(NetworkLog.PLAIN_TEXT)) {
                        jSONObject.put(str, str2);
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                continue;
            }
        }
        this.networkLog.setHeaders(jSONObject.toString());
    }

    private void insert() {
        this.networkLog.insert();
    }
}
