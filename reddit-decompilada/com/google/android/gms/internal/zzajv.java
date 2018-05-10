package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.util.JsonWriter;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

@zzzv
public final class zzajv {
    private static Object f6481a = new Object();
    private static boolean f6482b = false;
    private static boolean f6483c = false;
    private static zzd f6484d = zzh.m13111d();
    private static final Set<String> f6485e = new HashSet(Arrays.asList(new String[0]));
    private final List<String> f6486f;

    public zzajv() {
        this(null);
    }

    public zzajv(String str) {
        List asList;
        if (m5355c()) {
            String uuid = UUID.randomUUID().toString();
            if (str == null) {
                String[] strArr = new String[1];
                String str2 = "network_request_";
                uuid = String.valueOf(uuid);
                strArr[0] = uuid.length() != 0 ? str2.concat(uuid) : new String(str2);
                asList = Arrays.asList(strArr);
            } else {
                String[] strArr2 = new String[2];
                String str3 = "ad_request_";
                str = String.valueOf(str);
                strArr2[0] = str.length() != 0 ? str3.concat(str) : new String(str3);
                str = "network_request_";
                uuid = String.valueOf(uuid);
                strArr2[1] = uuid.length() != 0 ? str.concat(uuid) : new String(str);
                asList = Arrays.asList(strArr2);
            }
        } else {
            asList = new ArrayList();
        }
        this.f6486f = asList;
    }

    public static void m5343a() {
        synchronized (f6481a) {
            f6482b = false;
            f6483c = false;
            zzakb.m5371e("Ad debug logging enablement is out of date.");
        }
    }

    static final /* synthetic */ void m5344a(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        m5345a(jsonWriter, map);
        jsonWriter.endObject();
    }

    private static void m5345a(JsonWriter jsonWriter, Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (!f6485e.contains(str)) {
                    if (!(entry.getValue() instanceof List)) {
                        if (!(entry.getValue() instanceof String)) {
                            zzakb.m5368c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name("value").value((String) entry.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String str2 : (List) entry.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(str);
                            jsonWriter.name("value").value(str2);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    static final /* synthetic */ void m5346a(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    private final void m5347a(String str, zzaka com_google_android_gms_internal_zzaka) {
        Writer stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(f6484d.mo1632a());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String value : this.f6486f) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            com_google_android_gms_internal_zzaka.mo1729a(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (Throwable e) {
            zzakb.m5367b("unable to log", e);
        }
        m5354c(stringWriter.toString());
    }

    static final /* synthetic */ void m5348a(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        m5345a(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(zzb.m4893a(bArr));
        }
        jsonWriter.endObject();
    }

    public static void m5349a(boolean z) {
        synchronized (f6481a) {
            f6482b = true;
            f6483c = z;
        }
    }

    static final /* synthetic */ void m5350a(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        String str;
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String a = zzb.m4893a(bArr);
        if (length < AbstractSpiCall.DEFAULT_TIMEOUT) {
            str = "body";
        } else {
            a = zzajr.m5321a(a);
            if (a != null) {
                str = "bodydigest";
            }
            jsonWriter.name("bodylength").value((long) length);
            jsonWriter.endObject();
        }
        jsonWriter.name(str).value(a);
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    public static boolean m5351a(Context context) {
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        return ((Boolean) zzkb.m6350f().m6488a(zznh.aT)).booleanValue() && Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
    }

    private final void m5352b(String str, String str2, Map<String, ?> map, byte[] bArr) {
        m5347a("onNetworkRequest", new zzajw(str, str2, map, bArr));
    }

    public static boolean m5353b() {
        boolean z;
        synchronized (f6481a) {
            z = f6482b;
        }
        return z;
    }

    private static synchronized void m5354c(String str) {
        synchronized (zzajv.class) {
            zzakb.m5370d("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String str2 = "GMA Debug CONTENT ";
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzakb.m5370d(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                i = i2;
            }
            zzakb.m5370d("GMA Debug FINISH");
        }
    }

    public static boolean m5355c() {
        boolean z;
        synchronized (f6481a) {
            z = f6482b && f6483c;
        }
        return z;
    }

    public final void m5356a(String str) {
        if (m5355c() && str != null) {
            m5361a(str.getBytes());
        }
    }

    public final void m5357a(String str, String str2, Map<String, ?> map, byte[] bArr) {
        if (m5355c()) {
            m5352b(str, str2, map, bArr);
        }
    }

    public final void m5358a(HttpURLConnection httpURLConnection, int i) {
        String responseMessage;
        if (m5355c()) {
            m5360a(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < HttpStatus.HTTP_OK || i >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String str = "Can not get error message from error HttpURLConnection\n";
                    responseMessage = String.valueOf(e.getMessage());
                    zzakb.m5371e(responseMessage.length() != 0 ? str.concat(responseMessage) : new String(str));
                    responseMessage = null;
                }
                m5362b(responseMessage);
            }
        }
    }

    public final void m5359a(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (m5355c()) {
            m5352b(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    final void m5360a(Map<String, ?> map, int i) {
        m5347a("onNetworkResponse", new zzajx(i, map));
    }

    public final void m5361a(byte[] bArr) {
        m5347a("onNetworkResponseBody", new zzajy(bArr));
    }

    final void m5362b(String str) {
        m5347a("onNetworkRequestError", new zzajz(str));
    }
}
