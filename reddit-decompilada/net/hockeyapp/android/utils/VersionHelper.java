package net.hockeyapp.android.utils;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import net.hockeyapp.android.C2158R;
import net.hockeyapp.android.UpdateInfoListener;
import org.json.JSONObject;

public class VersionHelper {
    public JSONObject f26622a;
    private ArrayList<JSONObject> f26623b;
    private Context f26624c;
    private UpdateInfoListener f26625d;
    private int f26626e;

    class C21641 implements Comparator<JSONObject> {
        final /* synthetic */ VersionHelper f26621a;

        C21641(VersionHelper versionHelper) {
            this.f26621a = versionHelper;
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return C21641.m28242a((JSONObject) obj, (JSONObject) obj2);
        }

        private static int m28242a(org.json.JSONObject r2, org.json.JSONObject r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = 0;
            r1 = "version";	 Catch:{ JSONException -> 0x0012, JSONException -> 0x0012 }
            r2 = r2.getInt(r1);	 Catch:{ JSONException -> 0x0012, JSONException -> 0x0012 }
            r1 = "version";	 Catch:{ JSONException -> 0x0012, JSONException -> 0x0012 }
            r3 = r3.getInt(r1);	 Catch:{ JSONException -> 0x0012, JSONException -> 0x0012 }
            if (r2 <= r3) goto L_0x0012;
        L_0x0011:
            return r0;
        L_0x0012:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.VersionHelper.1.a(org.json.JSONObject, org.json.JSONObject):int");
        }
    }

    public VersionHelper(Context context, String str, UpdateInfoListener updateInfoListener) {
        this.f26624c = context;
        this.f26625d = updateInfoListener;
        m28246a(str);
        Collections.sort(this.f26623b, new C21641(this));
    }

    private void m28246a(java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r9.f26622a = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r9.f26623b = r0;
        r0 = r9.f26625d;
        r0 = r0.getCurrentVersionCode();
        r9.f26626e = r0;
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r0.<init>(r10);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r10 = r9.f26626e;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r1 = 0;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r2 = r10;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r10 = r1;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0020:
        r3 = r0.length();	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        if (r10 >= r3) goto L_0x0065;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0026:
        r3 = r0.getJSONObject(r10);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r4 = "version";	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r4 = r3.getInt(r4);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r5 = 1;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        if (r4 <= r2) goto L_0x0036;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0034:
        r4 = r5;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        goto L_0x0037;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0036:
        r4 = r1;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0037:
        r6 = "version";	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r6 = r3.getInt(r6);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        if (r6 != r2) goto L_0x004f;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0040:
        r6 = r9.f26624c;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r7 = "timestamp";	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r7 = r3.getLong(r7);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r6 = m28247a(r6, r7);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        if (r6 == 0) goto L_0x004f;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x004e:
        goto L_0x0050;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x004f:
        r5 = r1;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0050:
        if (r4 != 0) goto L_0x0054;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0052:
        if (r5 == 0) goto L_0x005d;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x0054:
        r9.f26622a = r3;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r2 = "version";	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r2 = r3.getInt(r2);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
    L_0x005d:
        r4 = r9.f26623b;	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r4.add(r3);	 Catch:{ JSONException -> 0x0066, JSONException -> 0x0066 }
        r10 = r10 + 1;
        goto L_0x0020;
    L_0x0065:
        return;
    L_0x0066:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.VersionHelper.a(java.lang.String):void");
    }

    public static java.lang.String m28245a(org.json.JSONObject r0, java.lang.String r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getString(r1);	 Catch:{ JSONException -> 0x0005 }
        return r0;
    L_0x0005:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.VersionHelper.a(org.json.JSONObject, java.lang.String, java.lang.String):java.lang.String");
    }

    public static long m28244a(org.json.JSONObject r0, java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getLong(r1);	 Catch:{ JSONException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.VersionHelper.a(org.json.JSONObject, java.lang.String):long");
    }

    public final String m28249a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<body style='padding: 0px 0px 20px 0px'>");
        Iterator it = this.f26623b.iterator();
        int i = 0;
        while (it.hasNext()) {
            JSONObject jSONObject = (JSONObject) it.next();
            if (i > 0) {
                stringBuilder.append("<hr style='border-top: 1px solid #c8c8c8; border-bottom: 0px; margin: 40px 10px 0px 10px;' />");
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            int a = m28243a(this.f26622a);
            int a2 = m28243a(jSONObject);
            String b = m28248b(jSONObject);
            stringBuilder2.append("<div style='padding: 20px 10px 10px;'><strong>");
            if (i == 0) {
                stringBuilder2.append(this.f26624c.getString(C2158R.string.hockeyapp_update_newest_version));
                stringBuilder2.append(':');
            } else {
                b = String.format(this.f26624c.getString(C2158R.string.hockeyapp_update_version), new Object[]{b});
                stringBuilder2.append(String.format("%s (%s): ", new Object[]{b, Integer.valueOf(a2)}));
                if (a2 != a && a2 == this.f26626e) {
                    this.f26626e = -1;
                    stringBuilder2.append(String.format("[%s]", new Object[]{this.f26624c.getString(C2158R.string.hockeyapp_update_already_installed)}));
                }
            }
            stringBuilder2.append("</strong></div>");
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder();
            String a3 = m28245a(jSONObject, "notes", "");
            stringBuilder2.append("<div style='padding: 0px 10px;'>");
            if (a3.trim().length() == 0) {
                stringBuilder2.append(String.format("<em>%s</em>", new Object[]{this.f26624c.getString(C2158R.string.hockeyapp_update_no_info)}));
            } else {
                stringBuilder2.append(a3);
            }
            stringBuilder2.append("</div>");
            stringBuilder.append(stringBuilder2.toString());
            i++;
        }
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    private static int m28243a(org.json.JSONObject r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "version";	 Catch:{ JSONException -> 0x0008 }
        r1 = r1.getInt(r0);	 Catch:{ JSONException -> 0x0008 }
        goto L_0x0009;
    L_0x0008:
        r1 = 0;
    L_0x0009:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.VersionHelper.a(org.json.JSONObject):int");
    }

    private static java.lang.String m28248b(org.json.JSONObject r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "";
        r1 = "shortversion";	 Catch:{ JSONException -> 0x0009 }
        r2 = r2.getString(r1);	 Catch:{ JSONException -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r2 = r0;
    L_0x000a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.hockeyapp.android.utils.VersionHelper.b(org.json.JSONObject):java.lang.String");
    }

    private static boolean m28247a(Context context, long j) {
        if (context == null) {
            return false;
        }
        try {
            if (j > (new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir).lastModified() / 1000) + 1800) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            HockeyLog.m28206a("Failed to get application info", e);
            return false;
        }
    }
}
