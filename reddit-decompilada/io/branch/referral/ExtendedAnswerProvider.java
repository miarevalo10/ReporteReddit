package io.branch.referral;

import android.text.TextUtils;
import com.crashlytics.android.answers.shim.KitEvent;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.branch.referral.Defines.Jsonkey;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ExtendedAnswerProvider {
    ExtendedAnswerProvider() {
    }

    public final void m26144a(java.lang.String r2, org.json.JSONObject r3, java.lang.String r4) {
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
        r0 = new com.crashlytics.android.answers.shim.KitEvent;	 Catch:{ Throwable -> 0x001b }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x001b }
        if (r3 == 0) goto L_0x001a;	 Catch:{ Throwable -> 0x001b }
    L_0x0007:
        r2 = "";	 Catch:{ Throwable -> 0x001b }
        r1.m26143a(r0, r3, r2);	 Catch:{ Throwable -> 0x001b }
        r2 = io.branch.referral.Defines.Jsonkey.BranchIdentity;	 Catch:{ Throwable -> 0x001b }
        r2 = r2.bc;	 Catch:{ Throwable -> 0x001b }
        r0.putAttribute(r2, r4);	 Catch:{ Throwable -> 0x001b }
        r2 = com.crashlytics.android.answers.shim.AnswersOptionalLogger.get();	 Catch:{ Throwable -> 0x001b }
        r2.logKitEvent(r0);	 Catch:{ Throwable -> 0x001b }
    L_0x001a:
        return;
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ExtendedAnswerProvider.a(java.lang.String, org.json.JSONObject, java.lang.String):void");
    }

    private void m26143a(KitEvent kitEvent, JSONObject jSONObject, String str) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            Object obj = jSONObject.get(str2);
            if (!str2.startsWith(Operation.PLUS)) {
                StringBuilder stringBuilder;
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str2);
                    stringBuilder.append(".");
                    m26143a(kitEvent, jSONObject2, stringBuilder.toString());
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(".");
                    m26142a(kitEvent, jSONArray, stringBuilder.toString());
                } else {
                    m26141a(kitEvent, str, str2, jSONObject.getString(str2));
                }
            }
        }
    }

    private static void m26142a(KitEvent kitEvent, JSONArray jSONArray, String str) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder("~");
            stringBuilder.append(Integer.toString(i));
            m26141a(kitEvent, str, stringBuilder.toString(), jSONArray.getString(i));
        }
    }

    private static void m26141a(KitEvent kitEvent, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            if (str2.startsWith("~")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str.replaceFirst("~", ""));
                stringBuilder.append(str2.replaceFirst("~", ""));
                kitEvent.putAttribute(stringBuilder.toString(), str3);
                return;
            }
            str = new StringBuilder("$");
            str.append(Jsonkey.IdentityID.bc);
            if (str2.equals(str.toString()) != null) {
                kitEvent.putAttribute(Jsonkey.ReferringBranchIdentity.bc, str3);
            }
        }
    }
}
