package com.google.android.gms.internal;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

final class zzag extends zzah {
    private final zzaq f17543a;

    zzag(zzaq com_google_android_gms_internal_zzaq) {
        this.f17543a = com_google_android_gms_internal_zzaq;
    }

    public final zzap mo3435a(zzr<?> com_google_android_gms_internal_zzr_, Map<String, String> map) throws IOException, zza {
        try {
            HttpResponse b = this.f17543a.mo1717b(com_google_android_gms_internal_zzr_, map);
            int statusCode = b.getStatusLine().getStatusCode();
            Header[] allHeaders = b.getAllHeaders();
            List arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (b.getEntity() == null) {
                return new zzap(statusCode, arrayList);
            }
            long contentLength = b.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new zzap(statusCode, arrayList, (int) b.getEntity().getContentLength(), b.getEntity().getContent());
            }
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Response too large: ");
            stringBuilder.append(contentLength);
            throw new IOException(stringBuilder.toString());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
