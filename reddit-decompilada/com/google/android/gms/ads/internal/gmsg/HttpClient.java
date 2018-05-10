package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajv;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzzv;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
@KeepName
@zzzv
public class HttpClient implements zzt<com.google.android.gms.ads.internal.js.zza> {
    private final Context mContext;
    private final zzakd zzapr;

    @zzzv
    static class zza {
        final String f5410a;
        final String f5411b;

        public zza(String str, String str2) {
            this.f5410a = str;
            this.f5411b = str2;
        }
    }

    @zzzv
    static class zzb {
        final String f5412a;
        final URL f5413b;
        final ArrayList<zza> f5414c;
        final String f5415d;

        zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.f5412a = str;
            this.f5413b = url;
            this.f5414c = arrayList;
            this.f5415d = str2;
        }
    }

    @zzzv
    class zzc {
        final zzd f5416a;
        final boolean f5417b;
        final String f5418c;

        public zzc(boolean z, zzd com_google_android_gms_ads_internal_gmsg_HttpClient_zzd, String str) {
            this.f5417b = z;
            this.f5416a = com_google_android_gms_ads_internal_gmsg_HttpClient_zzd;
            this.f5418c = str;
        }
    }

    @zzzv
    static class zzd {
        final String f5419a;
        final int f5420b;
        final List<zza> f5421c;
        final String f5422d;

        zzd(String str, int i, List<zza> list, String str2) {
            this.f5419a = str;
            this.f5420b = i;
            this.f5421c = list;
            this.f5422d = str2;
        }
    }

    public HttpClient(Context context, zzakd com_google_android_gms_internal_zzakd) {
        this.mContext = context;
        this.zzapr = com_google_android_gms_internal_zzakd;
    }

    private static zzb zzd(JSONObject jSONObject) {
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString(UpdateFragment.FRAGMENT_URL);
        URL url = null;
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            zzakb.m5367b("Error constructing http request.", e);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzahh.m5148a(new zzu(this, map, (com.google.android.gms.ads.internal.js.zza) obj));
    }

    private static JSONObject zza(zzd com_google_android_gms_ads_internal_gmsg_HttpClient_zzd) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", com_google_android_gms_ads_internal_gmsg_HttpClient_zzd.f5419a);
            if (com_google_android_gms_ads_internal_gmsg_HttpClient_zzd.f5422d != null) {
                jSONObject.put("body", com_google_android_gms_ads_internal_gmsg_HttpClient_zzd.f5422d);
            }
            JSONArray jSONArray = new JSONArray();
            for (zza com_google_android_gms_ads_internal_gmsg_HttpClient_zza : com_google_android_gms_ads_internal_gmsg_HttpClient_zzd.f5421c) {
                jSONArray.put(new JSONObject().put("key", com_google_android_gms_ads_internal_gmsg_HttpClient_zza.f5410a).put("value", com_google_android_gms_ads_internal_gmsg_HttpClient_zza.f5411b));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", com_google_android_gms_ads_internal_gmsg_HttpClient_zzd.f5420b);
        } catch (zzd com_google_android_gms_ads_internal_gmsg_HttpClient_zzd2) {
            zzakb.m5367b("Error constructing JSON for http response.", com_google_android_gms_ads_internal_gmsg_HttpClient_zzd2);
        }
        return jSONObject;
    }

    private final zzc zza(zzb com_google_android_gms_ads_internal_gmsg_HttpClient_zzb) {
        HttpURLConnection httpURLConnection;
        zzc com_google_android_gms_ads_internal_gmsg_HttpClient_zzc;
        try {
            httpURLConnection = (HttpURLConnection) com_google_android_gms_ads_internal_gmsg_HttpClient_zzb.f5413b.openConnection();
            try {
                byte[] bArr;
                zzbs.m4486e().m5228a(this.mContext, this.zzapr.f17551a, httpURLConnection);
                ArrayList arrayList = com_google_android_gms_ads_internal_gmsg_HttpClient_zzb.f5414c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zza com_google_android_gms_ads_internal_gmsg_HttpClient_zza = (zza) obj;
                    httpURLConnection.addRequestProperty(com_google_android_gms_ads_internal_gmsg_HttpClient_zza.f5410a, com_google_android_gms_ads_internal_gmsg_HttpClient_zza.f5411b);
                }
                if (TextUtils.isEmpty(com_google_android_gms_ads_internal_gmsg_HttpClient_zzb.f5415d)) {
                    bArr = null;
                } else {
                    httpURLConnection.setDoOutput(true);
                    bArr = com_google_android_gms_ads_internal_gmsg_HttpClient_zzb.f5415d.getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.close();
                }
                zzajv com_google_android_gms_internal_zzajv = new zzajv();
                com_google_android_gms_internal_zzajv.m5359a(httpURLConnection, bArr);
                List arrayList2 = new ArrayList();
                if (httpURLConnection.getHeaderFields() != null) {
                    for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                        for (String com_google_android_gms_ads_internal_gmsg_HttpClient_zza2 : (List) entry.getValue()) {
                            arrayList2.add(new zza((String) entry.getKey(), com_google_android_gms_ads_internal_gmsg_HttpClient_zza2));
                        }
                    }
                }
                com_google_android_gms_ads_internal_gmsg_HttpClient_zzb = com_google_android_gms_ads_internal_gmsg_HttpClient_zzb.f5412a;
                int responseCode = httpURLConnection.getResponseCode();
                zzbs.m4486e();
                zzd com_google_android_gms_ads_internal_gmsg_HttpClient_zzd = new zzd(com_google_android_gms_ads_internal_gmsg_HttpClient_zzb, responseCode, arrayList2, zzahn.m5161a(new InputStreamReader(httpURLConnection.getInputStream())));
                com_google_android_gms_internal_zzajv.m5358a(httpURLConnection, com_google_android_gms_ads_internal_gmsg_HttpClient_zzd.f5420b);
                com_google_android_gms_internal_zzajv.m5356a(com_google_android_gms_ads_internal_gmsg_HttpClient_zzd.f5422d);
                com_google_android_gms_ads_internal_gmsg_HttpClient_zzb = new zzc(true, com_google_android_gms_ads_internal_gmsg_HttpClient_zzd, null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return com_google_android_gms_ads_internal_gmsg_HttpClient_zzb;
            } catch (Exception e) {
                com_google_android_gms_ads_internal_gmsg_HttpClient_zzb = e;
                try {
                    com_google_android_gms_ads_internal_gmsg_HttpClient_zzc = new zzc(false, null, com_google_android_gms_ads_internal_gmsg_HttpClient_zzb.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return com_google_android_gms_ads_internal_gmsg_HttpClient_zzc;
                } catch (Throwable th) {
                    com_google_android_gms_ads_internal_gmsg_HttpClient_zzb = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw com_google_android_gms_ads_internal_gmsg_HttpClient_zzb;
                }
            }
        } catch (Exception e2) {
            com_google_android_gms_ads_internal_gmsg_HttpClient_zzb = e2;
            httpURLConnection = null;
            com_google_android_gms_ads_internal_gmsg_HttpClient_zzc = new zzc(false, null, com_google_android_gms_ads_internal_gmsg_HttpClient_zzb.toString());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return com_google_android_gms_ads_internal_gmsg_HttpClient_zzc;
        } catch (Throwable th2) {
            com_google_android_gms_ads_internal_gmsg_HttpClient_zzb = th2;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw com_google_android_gms_ads_internal_gmsg_HttpClient_zzb;
        }
    }

    @Keep
    @KeepName
    public JSONObject send(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String str = "";
        Object optString;
        try {
            optString = jSONObject.optString("http_request_id");
            try {
                jSONObject = zza(zzd(jSONObject));
                if (jSONObject.f5417b) {
                    jSONObject2.put("response", zza(jSONObject.f5416a));
                    jSONObject2.put("success", true);
                } else {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", jSONObject.f5418c);
                }
            } catch (Exception e) {
                jSONObject = e;
                zzakb.m5367b("Error executing http request.", jSONObject);
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", jSONObject.toString());
                } catch (JSONObject jSONObject3) {
                    zzakb.m5367b("Error executing http request.", jSONObject3);
                }
                return jSONObject2;
            }
        } catch (Exception e2) {
            jSONObject3 = e2;
            optString = str;
            zzakb.m5367b("Error executing http request.", jSONObject3);
            jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
            jSONObject2.put("success", false);
            jSONObject2.put("reason", jSONObject3.toString());
            return jSONObject2;
        }
        return jSONObject2;
    }
}
