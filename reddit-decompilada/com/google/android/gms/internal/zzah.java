package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class zzah implements zzaq {
    public abstract zzap mo3435a(zzr<?> com_google_android_gms_internal_zzr_, Map<String, String> map) throws IOException, zza;

    @Deprecated
    public final HttpResponse mo1717b(zzr<?> com_google_android_gms_internal_zzr_, Map<String, String> map) throws IOException, zza {
        com_google_android_gms_internal_zzr_ = mo3435a(com_google_android_gms_internal_zzr_, map);
        map = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), com_google_android_gms_internal_zzr_.f6679a, ""));
        List arrayList = new ArrayList();
        for (zzl com_google_android_gms_internal_zzl : Collections.unmodifiableList(com_google_android_gms_internal_zzr_.f6680b)) {
            arrayList.add(new BasicHeader(com_google_android_gms_internal_zzl.f7777a, com_google_android_gms_internal_zzl.f7778b));
        }
        map.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream inputStream = com_google_android_gms_internal_zzr_.f6682d;
        if (inputStream != null) {
            HttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(inputStream);
            basicHttpEntity.setContentLength((long) com_google_android_gms_internal_zzr_.f6681c);
            map.setEntity(basicHttpEntity);
        }
        return map;
    }
}
