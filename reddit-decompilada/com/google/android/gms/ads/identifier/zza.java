package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

final class zza extends Thread {
    private /* synthetic */ Map zzanb;

    zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzanb = map;
    }

    public final void run() {
        String message;
        HttpURLConnection httpURLConnection;
        StringBuilder stringBuilder;
        Throwable e;
        String str;
        String str2;
        zzc com_google_android_gms_ads_identifier_zzc = new zzc();
        Map map = this.zzanb;
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String message2 : map.keySet()) {
            buildUpon.appendQueryParameter(message2, (String) map.get(message2));
        }
        String uri = buildUpon.build().toString();
        try {
            httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < HttpStatus.HTTP_OK || responseCode >= 300) {
                stringBuilder = new StringBuilder(65 + String.valueOf(uri).length());
                stringBuilder.append("Received non-success response code ");
                stringBuilder.append(responseCode);
                stringBuilder.append(" from pinging URL: ");
                stringBuilder.append(uri);
                Log.w("HttpUrlPinger", stringBuilder.toString());
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e2) {
            e = e2;
            str = "HttpUrlPinger";
            message2 = e.getMessage();
            stringBuilder = new StringBuilder((32 + String.valueOf(uri).length()) + String.valueOf(message2).length());
            str2 = "Error while parsing ping URL: ";
            stringBuilder.append(str2);
            stringBuilder.append(uri);
            stringBuilder.append(". ");
            stringBuilder.append(message2);
            Log.w(str, stringBuilder.toString(), e);
        } catch (IOException e3) {
            e = e3;
            str = "HttpUrlPinger";
            message2 = e.getMessage();
            stringBuilder = new StringBuilder((27 + String.valueOf(uri).length()) + String.valueOf(message2).length());
            str2 = "Error while pinging URL: ";
            stringBuilder.append(str2);
            stringBuilder.append(uri);
            stringBuilder.append(". ");
            stringBuilder.append(message2);
            Log.w(str, stringBuilder.toString(), e);
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }
}
