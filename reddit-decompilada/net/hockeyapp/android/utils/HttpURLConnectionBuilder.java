package net.hockeyapp.android.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpURLConnectionBuilder {
    public String f26604a;
    private final String f26605b;
    private String f26606c;
    private SimpleMultipartEntity f26607d;
    private int f26608e = 120000;
    private final Map<String, String> f26609f;

    public HttpURLConnectionBuilder(String str) {
        this.f26605b = str;
        this.f26609f = new HashMap();
        this.f26609f.put("User-Agent", "HockeySDK/Android 5.1.0");
    }

    public final HttpURLConnectionBuilder m28214a(Map<String, String> map) {
        if (map.size() > 25) {
            StringBuilder stringBuilder = new StringBuilder("Fields size too large: ");
            stringBuilder.append(map.size());
            stringBuilder.append(" - max allowed: 25");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            if (str2 != null && ((long) str2.length()) > 4194304) {
                StringBuilder stringBuilder2 = new StringBuilder("Form field ");
                stringBuilder2.append(str);
                stringBuilder2.append(" size too large: ");
                stringBuilder2.append(str2.length());
                stringBuilder2.append(" - max allowed: 4194304");
                throw new IllegalArgumentException(stringBuilder2.toString());
            }
        }
        try {
            map = m28211a((Map) map, "UTF-8");
            m28213a("Content-Type", HttpRequest.CONTENT_TYPE_FORM);
            this.f26606c = map;
            return this;
        } catch (Map<String, String> map2) {
            throw new RuntimeException(map2);
        }
    }

    public final HttpURLConnectionBuilder m28215a(Map<String, String> map, Context context, List<Uri> list) {
        try {
            this.f26607d = new SimpleMultipartEntity(File.createTempFile("multipart", null, context.getCacheDir()));
            this.f26607d.m28227a();
            for (String str : map.keySet()) {
                SimpleMultipartEntity simpleMultipartEntity = this.f26607d;
                String str2 = (String) map.get(str);
                simpleMultipartEntity.m28227a();
                OutputStream outputStream = simpleMultipartEntity.f26615b;
                StringBuilder stringBuilder = new StringBuilder("Content-Disposition: form-data; name=\"");
                stringBuilder.append(str);
                stringBuilder.append("\"\r\n");
                outputStream.write(stringBuilder.toString().getBytes());
                simpleMultipartEntity.f26615b.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
                simpleMultipartEntity.f26615b.write("Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes());
                simpleMultipartEntity.f26615b.write(str2.getBytes());
                OutputStream outputStream2 = simpleMultipartEntity.f26615b;
                StringBuilder stringBuilder2 = new StringBuilder("\r\n--");
                stringBuilder2.append(simpleMultipartEntity.f26616c);
                stringBuilder2.append("\r\n");
                outputStream2.write(stringBuilder2.toString().getBytes());
            }
            int i = 0;
            while (i < list.size()) {
                Uri uri = (Uri) list.get(i);
                boolean z = i == list.size() - 1;
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                String lastPathSegment = uri.getLastPathSegment();
                SimpleMultipartEntity simpleMultipartEntity2 = this.f26607d;
                StringBuilder stringBuilder3 = new StringBuilder("attachment");
                stringBuilder3.append(i);
                simpleMultipartEntity2.m28229a(stringBuilder3.toString(), lastPathSegment, openInputStream, "application/octet-stream", z);
                i++;
            }
            this.f26607d.m28230b();
            context = new StringBuilder("multipart/form-data; boundary=");
            context.append(this.f26607d.f26616c);
            m28213a("Content-Type", context.toString());
            return this;
        } catch (Map<String, String> map2) {
            throw new RuntimeException(map2);
        }
    }

    public final HttpURLConnectionBuilder m28213a(String str, String str2) {
        this.f26609f.put(str, str2);
        return this;
    }

    public final HttpURLConnection m28212a() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f26605b).openConnection();
        httpURLConnection.setConnectTimeout(this.f26608e);
        httpURLConnection.setReadTimeout(this.f26608e);
        if (!TextUtils.isEmpty(this.f26604a)) {
            httpURLConnection.setRequestMethod(this.f26604a);
            if (!TextUtils.isEmpty(this.f26606c) || this.f26604a.equalsIgnoreCase(HttpRequest.METHOD_POST) || this.f26604a.equalsIgnoreCase(HttpRequest.METHOD_PUT)) {
                httpURLConnection.setDoOutput(true);
            }
        }
        for (String str : this.f26609f.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.f26609f.get(str));
        }
        if (!TextUtils.isEmpty(this.f26606c)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            bufferedWriter.write(this.f26606c);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        if (this.f26607d != null) {
            SimpleMultipartEntity simpleMultipartEntity = this.f26607d;
            simpleMultipartEntity.m28230b();
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(simpleMultipartEntity.f26614a.length()));
            this.f26607d.m28228a(httpURLConnection.getOutputStream());
        }
        return httpURLConnection;
    }

    private static String m28211a(Map<String, String> map, String str) throws UnsupportedEncodingException {
        Iterable arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            String str22 = URLEncoder.encode(str22, str);
            str3 = URLEncoder.encode(str3, str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str22);
            stringBuilder.append(Operation.EQUALS);
            stringBuilder.append(str3);
            arrayList.add(stringBuilder.toString());
        }
        return TextUtils.join("&", arrayList);
    }
}
