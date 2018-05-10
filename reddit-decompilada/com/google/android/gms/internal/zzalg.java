package com.google.android.gms.internal;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@zzzv
public final class zzalg {
    public static HttpURLConnection m5393a(String str, int i) throws IOException {
        String protocol;
        URL url = new URL(str);
        int i2 = 0;
        while (true) {
            i2++;
            if (i2 <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(i);
                openConnection.setReadTimeout(i);
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    zzajv com_google_android_gms_internal_zzajv = new zzajv();
                    com_google_android_gms_internal_zzajv.m5359a(httpURLConnection, null);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    com_google_android_gms_internal_zzajv.m5358a(httpURLConnection, responseCode);
                    if (responseCode / 100 == 3) {
                        String headerField = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                        if (headerField != null) {
                            URL url2 = new URL(url, headerField);
                            protocol = url2.getProtocol();
                            if (protocol != null) {
                                if (!protocol.equals("http") && !protocol.equals("https")) {
                                    break;
                                }
                                protocol = "Redirecting to ";
                                headerField = String.valueOf(headerField);
                                zzakb.m5366b(headerField.length() != 0 ? protocol.concat(headerField) : new String(protocol));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                throw new IOException("Protocol is null");
                            }
                        }
                        throw new IOException("Missing Location header in redirect");
                    }
                    return httpURLConnection;
                }
                throw new IOException("Invalid protocol.");
            }
            throw new IOException("Too many redirects (20)");
        }
        String str2 = "Unsupported scheme: ";
        String valueOf = String.valueOf(protocol);
        throw new IOException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
