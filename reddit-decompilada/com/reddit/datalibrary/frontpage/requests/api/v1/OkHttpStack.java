package com.reddit.datalibrary.frontpage.requests.api.v1;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.HttpStack;
import com.reddit.datalibrary.frontpage.service.api.AwsFileUploadRequest;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class OkHttpStack implements HttpStack {
    final OkHttpClient f16330a;

    static /* synthetic */ class C09491 {
        static final /* synthetic */ int[] f10904a = new int[Protocol.values().length];

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = okhttp3.Protocol.values();
            r0 = r0.length;
            r0 = new int[r0];
            f10904a = r0;
            r0 = f10904a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = okhttp3.Protocol.HTTP_1_0;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f10904a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = okhttp3.Protocol.HTTP_1_1;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f10904a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = okhttp3.Protocol.SPDY_3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f10904a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = okhttp3.Protocol.HTTP_2;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack.1.<clinit>():void");
        }
    }

    public OkHttpStack(OkHttpClient okHttpClient) {
        this.f16330a = okHttpClient;
    }

    public final HttpResponse mo3041a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String value;
        ProtocolVersion protocolVersion;
        Builder builder = new Builder();
        builder.url(request.getUrl());
        Map headers = request.getHeaders();
        for (String value2 : headers.keySet()) {
            builder.addHeader(value2, (String) headers.get(value2));
        }
        for (String str : map.keySet()) {
            String str2;
            builder.addHeader(str2, (String) map.get(str2));
        }
        switch (request.getMethod()) {
            case -1:
                map = request.getPostBody();
                if (map != null) {
                    builder.post(RequestBody.create(MediaType.parse(request.getPostBodyContentType()), map));
                    break;
                }
                break;
            case null:
                builder.get();
                break;
            case 1:
                if ((request instanceof AwsFileUploadRequest) == null) {
                    builder.post(m16389a(request));
                    break;
                }
                AwsFileUploadRequest awsFileUploadRequest = (AwsFileUploadRequest) request;
                builder.post(RequestBody.create(MediaType.parse(awsFileUploadRequest.getBodyContentType()), awsFileUploadRequest.getBodyFile()));
                break;
            case 2:
                builder.put(m16389a(request));
                break;
            case 3:
                builder.delete();
                break;
            case 4:
                builder.head();
                break;
            case 5:
                builder.method(HttpRequest.METHOD_OPTIONS, null);
                break;
            case 6:
                builder.method(HttpRequest.METHOD_TRACE, null);
                break;
            case 7:
                builder.patch(m16389a(request));
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        request = this.f16330a.newCall(builder.build()).execute();
        int i = 0;
        switch (C09491.f10904a[request.protocol().ordinal()]) {
            case 1:
                protocolVersion = new ProtocolVersion("HTTP", 1, 0);
                break;
            case 2:
                protocolVersion = new ProtocolVersion("HTTP", 1, 1);
                break;
            case 3:
                protocolVersion = new ProtocolVersion("SPDY", 3, 1);
                break;
            case 4:
                protocolVersion = new ProtocolVersion("HTTP", 2, 0);
                break;
            default:
                throw new IllegalAccessError("Unknown protocol");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, request.code(), request.message()));
        map = new BasicHttpEntity();
        ResponseBody body = request.body();
        map.setContent(body.byteStream());
        map.setContentLength(body.contentLength());
        map.setContentEncoding(request.header(HttpRequest.HEADER_CONTENT_ENCODING));
        if (body.contentType() != null) {
            map.setContentType(body.contentType().type());
        }
        basicHttpResponse.setEntity(map);
        request = request.headers();
        map = request.size();
        while (i < map) {
            str2 = request.name(i);
            value2 = request.value(i);
            if (str2 != null) {
                basicHttpResponse.addHeader(new BasicHeader(str2, value2));
            }
            i++;
        }
        return basicHttpResponse;
    }

    private static RequestBody m16389a(Request request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body == null) {
            return null;
        }
        return RequestBody.create(MediaType.parse(request.getBodyContentType()), body);
    }
}
