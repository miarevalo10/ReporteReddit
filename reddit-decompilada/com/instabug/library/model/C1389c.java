package com.instabug.library.model;

import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.model.C0740d.C0739a;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserStep */
public class C1389c implements Cacheable, Serializable {
    public long f15532a;
    public String f15533b;
    public C0738a f15534c;

    /* compiled from: UserStep */
    static /* synthetic */ class C07371 {
        public static final /* synthetic */ int[] f9802a = new int[C0739a.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = com.instabug.library.model.C0740d.C0739a.values();
            r0 = r0.length;
            r0 = new int[r0];
            f9802a = r0;
            r0 = f9802a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.instabug.library.model.C0740d.C0739a.TAP;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f9802a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.instabug.library.model.C0740d.C0739a.SHAKE;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f9802a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.instabug.library.model.C0740d.C0739a.APPLICATION_CREATED;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.c.1.<clinit>():void");
        }
    }

    /* compiled from: UserStep */
    public enum C0738a {
        APPLICATION("application"),
        VIEW("view"),
        MOTION("motion"),
        TOUCH("touch"),
        NOT_AVAILABLE("not_available");
        
        private final String f9809f;

        private C0738a(String str) {
            this.f9809f = str;
        }

        public final String toString() {
            return this.f9809f;
        }
    }

    public static ArrayList<C1389c> m15446a(JSONArray jSONArray) throws JSONException {
        ArrayList<C1389c> arrayList = new ArrayList();
        if (jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                C1389c c1389c = new C1389c();
                c1389c.fromJson(jSONArray.getJSONObject(i).toString());
                arrayList.add(c1389c);
            }
        }
        return arrayList;
    }

    public static JSONArray m15447a(ArrayList<C1389c> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                try {
                    jSONArray.put(new JSONObject(((C1389c) arrayList.next()).toJson()));
                } catch (JSONException e) {
                    InstabugSDKLogger.m8360v(C1389c.class, e.toString());
                }
            }
        }
        return jSONArray;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timestamp", this.f15532a);
        jSONObject.put("message", this.f15533b);
        jSONObject.put("type", this.f15534c.toString());
        return jSONObject.toString();
    }

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("timestamp") != null) {
            if (StringUtility.isNumeric(jSONObject.getString("timestamp")) != null) {
                this.f15532a = jSONObject.getLong("timestamp");
            } else {
                try {
                    this.f15532a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(jSONObject.getString("timestamp")).getTime();
                } catch (String str2) {
                    InstabugSDKLogger.m8357e(C1389c.class, str2.getMessage());
                }
            }
        }
        if (jSONObject.has("message") != null) {
            this.f15533b = jSONObject.getString("message");
        }
        if (jSONObject.has("type") != null) {
            str2 = jSONObject.getString("type");
            Object obj = -1;
            int hashCode = str2.hashCode();
            if (hashCode != -1068318794) {
                if (hashCode != 3619493) {
                    if (hashCode != 110550847) {
                        if (hashCode == 1554253136) {
                            if (str2.equals("application") != null) {
                                obj = null;
                            }
                        }
                    } else if (str2.equals("touch") != null) {
                        obj = 3;
                    }
                } else if (str2.equals("view") != null) {
                    obj = 1;
                }
            } else if (str2.equals("motion") != null) {
                obj = 2;
            }
            switch (obj) {
                case null:
                    this.f15534c = C0738a.APPLICATION;
                    return;
                case 1:
                    this.f15534c = C0738a.VIEW;
                    return;
                case 2:
                    this.f15534c = C0738a.MOTION;
                    return;
                case 3:
                    this.f15534c = C0738a.TOUCH;
                    return;
                default:
                    this.f15534c = C0738a.NOT_AVAILABLE;
                    break;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UserStep{timeStamp='");
        stringBuilder.append(this.f15532a);
        stringBuilder.append('\'');
        stringBuilder.append(", message='");
        stringBuilder.append(this.f15533b);
        stringBuilder.append('\'');
        stringBuilder.append(", type=");
        stringBuilder.append(this.f15534c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
