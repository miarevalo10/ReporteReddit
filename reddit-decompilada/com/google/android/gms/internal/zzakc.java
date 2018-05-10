package com.google.android.gms.internal;

import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzzv
public final class zzakc implements zzaju {
    private final String f14126a;

    public zzakc() {
        this(null);
    }

    public zzakc(String str) {
        this.f14126a = str;
    }

    public final void mo1719a(String str) {
        StringBuilder stringBuilder;
        String str2;
        HttpURLConnection httpURLConnection;
        try {
            str2 = "Pinging URL: ";
            String valueOf = String.valueOf(str);
            zzakb.m5366b(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            zzkb.m6345a();
            zzajr.m5327a(httpURLConnection, this.f14126a);
            zzajv com_google_android_gms_internal_zzajv = new zzajv();
            com_google_android_gms_internal_zzajv.m5359a(httpURLConnection, null);
            int responseCode = httpURLConnection.getResponseCode();
            com_google_android_gms_internal_zzajv.m5358a(httpURLConnection, responseCode);
            if (responseCode < HttpStatus.HTTP_OK || responseCode >= 300) {
                StringBuilder stringBuilder2 = new StringBuilder(65 + String.valueOf(str).length());
                stringBuilder2.append("Received non-success response code ");
                stringBuilder2.append(responseCode);
                stringBuilder2.append(" from pinging URL: ");
                stringBuilder2.append(str);
                zzakb.m5371e(stringBuilder2.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            String message = e.getMessage();
            stringBuilder = new StringBuilder((32 + String.valueOf(str).length()) + String.valueOf(message).length());
            stringBuilder.append("Error while parsing ping URL: ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(message);
            zzakb.m5371e(stringBuilder.toString());
        } catch (IOException e2) {
            str2 = e2.getMessage();
            stringBuilder = new StringBuilder((27 + String.valueOf(str).length()) + String.valueOf(str2).length());
            stringBuilder.append("Error while pinging URL: ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(str2);
            zzakb.m5371e(stringBuilder.toString());
        } catch (RuntimeException e3) {
            str2 = e3.getMessage();
            stringBuilder = new StringBuilder((27 + String.valueOf(str).length()) + String.valueOf(str2).length());
            stringBuilder.append("Error while pinging URL: ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(str2);
            zzakb.m5371e(stringBuilder.toString());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
