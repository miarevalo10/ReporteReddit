package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;

final class zzchu implements Runnable {
    private final URL f6910a;
    private final byte[] f6911b;
    private final zzchs f6912c;
    private final String f6913d;
    private final Map<String, String> f6914e;
    private /* synthetic */ zzchq f6915f;

    public zzchu(zzchq com_google_android_gms_internal_zzchq, String str, URL url, byte[] bArr, Map<String, String> map, zzchs com_google_android_gms_internal_zzchs) {
        this.f6915f = com_google_android_gms_internal_zzchq;
        zzbq.m4810a(str);
        zzbq.m4808a((Object) url);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzchs);
        this.f6910a = url;
        this.f6911b = bArr;
        this.f6912c = com_google_android_gms_internal_zzchs;
        this.f6913d = str;
        this.f6914e = map;
    }

    public final void run() {
        int i;
        Map map;
        Throwable th;
        int i2;
        Map map2;
        Throwable th2;
        Throwable e;
        this.f6915f.mo1810b();
        OutputStream outputStream = null;
        HttpURLConnection httpURLConnection;
        try {
            URLConnection openConnection = this.f6910a.openConnection();
            if (openConnection instanceof HttpURLConnection) {
                httpURLConnection = (HttpURLConnection) openConnection;
                httpURLConnection.setDefaultUseCaches(false);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.setReadTimeout(61000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoInput(true);
                try {
                    if (this.f6914e != null) {
                        for (Entry entry : this.f6914e.entrySet()) {
                            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                    if (this.f6911b != null) {
                        byte[] a = this.f6915f.mo1824p().m18548a(this.f6911b);
                        this.f6915f.mo1828t().f17822g.m5694a("Uploading data. size", Integer.valueOf(a.length));
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.addRequestProperty(HttpRequest.HEADER_CONTENT_ENCODING, HttpRequest.ENCODING_GZIP);
                        httpURLConnection.setFixedLengthStreamingMode(a.length);
                        httpURLConnection.connect();
                        OutputStream outputStream2 = httpURLConnection.getOutputStream();
                        try {
                            outputStream2.write(a);
                            outputStream2.close();
                        } catch (Throwable e2) {
                            i = 0;
                            map = null;
                            outputStream = outputStream2;
                            th = e2;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e3) {
                                    this.f6915f.mo1828t().f17816a.m5695a("Error closing HTTP compressed POST connection output stream. appId", zzchm.m18154a(this.f6913d), e3);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i, th, null, map));
                        } catch (Throwable e22) {
                            i2 = 0;
                            map2 = null;
                            outputStream = outputStream2;
                            th2 = e22;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e32) {
                                    this.f6915f.mo1828t().f17816a.m5695a("Error closing HTTP compressed POST connection output stream. appId", zzchm.m18154a(this.f6913d), e32);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i2, null, null, map2));
                            throw th2;
                        }
                    }
                    i2 = httpURLConnection.getResponseCode();
                    try {
                        map2 = httpURLConnection.getHeaderFields();
                        try {
                            byte[] a2 = zzchq.m18186b(httpURLConnection);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i2, null, a2, map2));
                            return;
                        } catch (IOException e4) {
                            e = e4;
                            i = i2;
                            map = map2;
                            th = e;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i, th, null, map));
                        } catch (Throwable e5) {
                            th2 = e5;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i2, null, null, map2));
                            throw th2;
                        }
                    } catch (IOException e6) {
                        e5 = e6;
                        map = null;
                        i = i2;
                        th = e5;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i, th, null, map));
                    } catch (Throwable e52) {
                        th2 = e52;
                        map2 = null;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i2, null, null, map2));
                        throw th2;
                    }
                } catch (Throwable th22) {
                    i = 0;
                    map = null;
                    th = th22;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i, th, null, map));
                } catch (Throwable th3) {
                    th22 = th3;
                    i2 = 0;
                    map2 = null;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i2, null, null, map2));
                    throw th22;
                }
            }
            throw new IOException("Failed to obtain HTTP connection");
        } catch (Throwable e7) {
            i = 0;
            map = null;
            th = e7;
            httpURLConnection = map;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i, th, null, map));
        } catch (Throwable e72) {
            i2 = 0;
            map2 = null;
            th22 = e72;
            httpURLConnection = map2;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            this.f6915f.mo1827s().m18271a(new zzcht(this.f6913d, this.f6912c, i2, null, null, map2));
            throw th22;
        }
    }
}
