package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException;
import com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.HttpDataSource.RequestProperties;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Predicate;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import okhttp3.internal.http.StatusLine;

public class DefaultHttpDataSource implements HttpDataSource {
    private static final Pattern f17052b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> f17053c = new AtomicReference();
    private final boolean f17054d;
    private final int f17055e;
    private final int f17056f;
    private final String f17057g;
    private final Predicate<String> f17058h = null;
    private final RequestProperties f17059i;
    private final RequestProperties f17060j;
    private final TransferListener<? super DefaultHttpDataSource> f17061k;
    private DataSpec f17062l;
    private HttpURLConnection f17063m;
    private InputStream f17064n;
    private boolean f17065o;
    private long f17066p;
    private long f17067q;
    private long f17068r;
    private long f17069s;

    public DefaultHttpDataSource(String str, TransferListener<? super DefaultHttpDataSource> transferListener, int i, int i2, boolean z, RequestProperties requestProperties) {
        this.f17057g = Assertions.m4183a(str);
        this.f17061k = transferListener;
        this.f17060j = new RequestProperties();
        this.f17055e = i;
        this.f17056f = i2;
        this.f17054d = z;
        this.f17059i = requestProperties;
    }

    public final Uri mo1437b() {
        return this.f17063m == null ? null : Uri.parse(this.f17063m.getURL().toString());
    }

    public final long mo1435a(DataSpec dataSpec) throws HttpDataSourceException {
        StringBuilder stringBuilder;
        IOException iOException;
        DataSpec dataSpec2 = dataSpec;
        this.f17062l = dataSpec2;
        long j = 0;
        this.f17069s = 0;
        this.f17068r = 0;
        try {
            int i;
            HttpURLConnection a;
            URL url = new URL(dataSpec2.f5167a.toString());
            byte[] bArr = dataSpec2.f5168b;
            long j2 = dataSpec2.f5170d;
            long j3 = dataSpec2.f5171e;
            boolean a2 = dataSpec.m4150a();
            if (r10.f17054d) {
                i = 0;
                URL url2 = url;
                byte[] bArr2 = bArr;
                while (true) {
                    int i2 = i + 1;
                    int i3;
                    if (i <= 20) {
                        URL url3 = url2;
                        i3 = i2;
                        long j4 = j3;
                        a = m17374a(url2, bArr2, j2, j3, a2, false);
                        int responseCode = a.getResponseCode();
                        if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                            if (bArr2 == null) {
                                if (responseCode != StatusLine.HTTP_TEMP_REDIRECT) {
                                    if (responseCode != StatusLine.HTTP_PERM_REDIRECT) {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                        bArr2 = null;
                        String headerField = a.getHeaderField(HttpRequest.HEADER_LOCATION);
                        a.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        url2 = new URL(url3, headerField);
                        String protocol = url2.getProtocol();
                        if ("https".equals(protocol) || "http".equals(protocol)) {
                            i = i3;
                            j3 = j4;
                        } else {
                            stringBuilder = new StringBuilder("Unsupported protocol redirect: ");
                            stringBuilder.append(protocol);
                            throw new ProtocolException(stringBuilder.toString());
                        }
                    }
                    i3 = i2;
                    StringBuilder stringBuilder2 = new StringBuilder("Too many redirects: ");
                    stringBuilder2.append(i3);
                    throw new NoRouteToHostException(stringBuilder2.toString());
                }
            }
            a = m17374a(url, bArr, j2, j3, a2, true);
            r10.f17063m = a;
            try {
                i = r10.f17063m.getResponseCode();
                if (i >= HttpStatus.HTTP_OK) {
                    if (i <= 299) {
                        String contentType = r10.f17063m.getContentType();
                        if (r10.f17058h == null || r10.f17058h.mo1476a(contentType)) {
                            if (i == HttpStatus.HTTP_OK && dataSpec2.f5170d != 0) {
                                j = dataSpec2.f5170d;
                            }
                            r10.f17066p = j;
                            if (dataSpec.m4150a()) {
                                r10.f17067q = dataSpec2.f5171e;
                            } else {
                                long j5 = -1;
                                if (dataSpec2.f5171e != -1) {
                                    r10.f17067q = dataSpec2.f5171e;
                                } else {
                                    long a3 = m17373a(r10.f17063m);
                                    if (a3 != -1) {
                                        j5 = a3 - r10.f17066p;
                                    }
                                    r10.f17067q = j5;
                                }
                            }
                            try {
                                r10.f17064n = r10.f17063m.getInputStream();
                                r10.f17065o = true;
                                if (r10.f17061k != null) {
                                    r10.f17061k.mo1473b();
                                }
                                return r10.f17067q;
                            } catch (IOException e) {
                                IOException iOException2 = e;
                                m17375c();
                                throw new HttpDataSourceException(iOException2, dataSpec2, 1);
                            }
                        }
                        m17375c();
                        throw new InvalidContentTypeException(contentType, dataSpec2);
                    }
                }
                Map headerFields = r10.f17063m.getHeaderFields();
                m17375c();
                InvalidResponseCodeException invalidResponseCodeException = new InvalidResponseCodeException(i, headerFields, dataSpec2);
                if (i == 416) {
                    invalidResponseCodeException.initCause(new DataSourceException());
                }
                throw invalidResponseCodeException;
            } catch (IOException e2) {
                iOException = e2;
                m17375c();
                stringBuilder = new StringBuilder("Unable to connect to ");
                stringBuilder.append(dataSpec2.f5167a.toString());
                throw new HttpDataSourceException(stringBuilder.toString(), iOException, dataSpec2);
            }
        } catch (IOException e22) {
            iOException = e22;
            stringBuilder = new StringBuilder("Unable to connect to ");
            stringBuilder.append(dataSpec2.f5167a.toString());
            throw new HttpDataSourceException(stringBuilder.toString(), iOException, dataSpec2);
        }
    }

    public final void mo1436a() throws com.google.android.exoplayer2.upstream.HttpDataSource.HttpDataSourceException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r9 = this;
        r0 = 0;
        r1 = 0;
        r2 = r9.f17064n;	 Catch:{ all -> 0x0091 }
        if (r2 == 0) goto L_0x007b;	 Catch:{ all -> 0x0091 }
    L_0x0006:
        r2 = r9.f17063m;	 Catch:{ all -> 0x0091 }
        r3 = r9.f17067q;	 Catch:{ all -> 0x0091 }
        r5 = -1;	 Catch:{ all -> 0x0091 }
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ all -> 0x0091 }
        if (r3 != 0) goto L_0x0013;	 Catch:{ all -> 0x0091 }
    L_0x0010:
        r3 = r9.f17067q;	 Catch:{ all -> 0x0091 }
        goto L_0x0018;	 Catch:{ all -> 0x0091 }
    L_0x0013:
        r3 = r9.f17067q;	 Catch:{ all -> 0x0091 }
        r7 = r9.f17069s;	 Catch:{ all -> 0x0091 }
        r3 = r3 - r7;	 Catch:{ all -> 0x0091 }
    L_0x0018:
        r7 = com.google.android.exoplayer2.util.Util.f5283a;	 Catch:{ all -> 0x0091 }
        r8 = 19;	 Catch:{ all -> 0x0091 }
        if (r7 == r8) goto L_0x0024;	 Catch:{ all -> 0x0091 }
    L_0x001e:
        r7 = com.google.android.exoplayer2.util.Util.f5283a;	 Catch:{ all -> 0x0091 }
        r8 = 20;
        if (r7 != r8) goto L_0x006b;
    L_0x0024:
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x006b }
        r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x006b }
        if (r5 != 0) goto L_0x0034;	 Catch:{ Exception -> 0x006b }
    L_0x002c:
        r3 = r2.read();	 Catch:{ Exception -> 0x006b }
        r4 = -1;	 Catch:{ Exception -> 0x006b }
        if (r3 != r4) goto L_0x003a;	 Catch:{ Exception -> 0x006b }
    L_0x0033:
        goto L_0x006b;	 Catch:{ Exception -> 0x006b }
    L_0x0034:
        r5 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ Exception -> 0x006b }
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ Exception -> 0x006b }
        if (r3 <= 0) goto L_0x006b;	 Catch:{ Exception -> 0x006b }
    L_0x003a:
        r3 = r2.getClass();	 Catch:{ Exception -> 0x006b }
        r3 = r3.getName();	 Catch:{ Exception -> 0x006b }
        r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream";	 Catch:{ Exception -> 0x006b }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x006b }
        if (r4 != 0) goto L_0x0052;	 Catch:{ Exception -> 0x006b }
    L_0x004a:
        r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream";	 Catch:{ Exception -> 0x006b }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x006b }
        if (r3 == 0) goto L_0x006b;	 Catch:{ Exception -> 0x006b }
    L_0x0052:
        r3 = r2.getClass();	 Catch:{ Exception -> 0x006b }
        r3 = r3.getSuperclass();	 Catch:{ Exception -> 0x006b }
        r4 = "unexpectedEndOfInput";	 Catch:{ Exception -> 0x006b }
        r5 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x006b }
        r3 = r3.getDeclaredMethod(r4, r5);	 Catch:{ Exception -> 0x006b }
        r4 = 1;	 Catch:{ Exception -> 0x006b }
        r3.setAccessible(r4);	 Catch:{ Exception -> 0x006b }
        r4 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x006b }
        r3.invoke(r2, r4);	 Catch:{ Exception -> 0x006b }
    L_0x006b:
        r2 = r9.f17064n;	 Catch:{ IOException -> 0x0071 }
        r2.close();	 Catch:{ IOException -> 0x0071 }
        goto L_0x007b;
    L_0x0071:
        r2 = move-exception;
        r3 = new com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;	 Catch:{ all -> 0x0091 }
        r4 = r9.f17062l;	 Catch:{ all -> 0x0091 }
        r5 = 3;	 Catch:{ all -> 0x0091 }
        r3.<init>(r2, r4, r5);	 Catch:{ all -> 0x0091 }
        throw r3;	 Catch:{ all -> 0x0091 }
    L_0x007b:
        r9.f17064n = r0;
        r9.m17375c();
        r0 = r9.f17065o;
        if (r0 == 0) goto L_0x0090;
    L_0x0084:
        r9.f17065o = r1;
        r0 = r9.f17061k;
        if (r0 == 0) goto L_0x0090;
    L_0x008a:
        r0 = r9.f17061k;
        r0.mo1474c();
        return;
    L_0x0090:
        return;
    L_0x0091:
        r2 = move-exception;
        r9.f17064n = r0;
        r9.m17375c();
        r0 = r9.f17065o;
        if (r0 == 0) goto L_0x00a6;
    L_0x009b:
        r9.f17065o = r1;
        r0 = r9.f17061k;
        if (r0 == 0) goto L_0x00a6;
    L_0x00a1:
        r0 = r9.f17061k;
        r0.mo1474c();
    L_0x00a6:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultHttpDataSource.a():void");
    }

    private HttpURLConnection m17374a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f17055e);
        httpURLConnection.setReadTimeout(this.f17056f);
        if (this.f17059i != null) {
            for (Entry entry : this.f17059i.m4151a().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : this.f17060j.m4151a().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder stringBuilder = new StringBuilder("bytes=");
            stringBuilder.append(j);
            stringBuilder.append(Operation.MINUS);
            String stringBuilder2 = stringBuilder.toString();
            if (j2 != -1) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append((j + j2) - 1);
                stringBuilder2 = stringBuilder3.toString();
            }
            httpURLConnection.setRequestProperty("Range", stringBuilder2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f17057g);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null ? 1 : null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod(HttpRequest.METHOD_POST);
            if (bArr.length != null) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                j = httpURLConnection.getOutputStream();
                j.write(bArr);
                j.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private static long m17373a(java.net.HttpURLConnection r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = "Content-Length";
        r0 = r8.getHeaderField(r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0029;
    L_0x000c:
        r1 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0011 }
        goto L_0x002b;
    L_0x0011:
        r1 = "DefaultHttpDataSource";
        r2 = new java.lang.StringBuilder;
        r3 = "Unexpected Content-Length [";
        r2.<init>(r3);
        r2.append(r0);
        r3 = "]";
        r2.append(r3);
        r2 = r2.toString();
        android.util.Log.e(r1, r2);
    L_0x0029:
        r1 = -1;
    L_0x002b:
        r3 = "Content-Range";
        r8 = r8.getHeaderField(r3);
        r3 = android.text.TextUtils.isEmpty(r8);
        if (r3 != 0) goto L_0x00a3;
    L_0x0037:
        r3 = f17052b;
        r3 = r3.matcher(r8);
        r4 = r3.find();
        if (r4 == 0) goto L_0x00a3;
    L_0x0043:
        r4 = 2;
        r4 = r3.group(r4);	 Catch:{ NumberFormatException -> 0x008b }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x008b }
        r6 = 1;	 Catch:{ NumberFormatException -> 0x008b }
        r3 = r3.group(r6);	 Catch:{ NumberFormatException -> 0x008b }
        r6 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x008b }
        r4 = r4 - r6;	 Catch:{ NumberFormatException -> 0x008b }
        r6 = 1;	 Catch:{ NumberFormatException -> 0x008b }
        r3 = r4 + r6;	 Catch:{ NumberFormatException -> 0x008b }
        r5 = 0;	 Catch:{ NumberFormatException -> 0x008b }
        r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x008b }
        if (r5 >= 0) goto L_0x0062;	 Catch:{ NumberFormatException -> 0x008b }
    L_0x0060:
        r1 = r3;	 Catch:{ NumberFormatException -> 0x008b }
        goto L_0x00a3;	 Catch:{ NumberFormatException -> 0x008b }
    L_0x0062:
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x008b }
        if (r5 == 0) goto L_0x00a3;	 Catch:{ NumberFormatException -> 0x008b }
    L_0x0066:
        r5 = "DefaultHttpDataSource";	 Catch:{ NumberFormatException -> 0x008b }
        r6 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x008b }
        r7 = "Inconsistent headers [";	 Catch:{ NumberFormatException -> 0x008b }
        r6.<init>(r7);	 Catch:{ NumberFormatException -> 0x008b }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x008b }
        r0 = "] [";	 Catch:{ NumberFormatException -> 0x008b }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x008b }
        r6.append(r8);	 Catch:{ NumberFormatException -> 0x008b }
        r0 = "]";	 Catch:{ NumberFormatException -> 0x008b }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x008b }
        r0 = r6.toString();	 Catch:{ NumberFormatException -> 0x008b }
        android.util.Log.w(r5, r0);	 Catch:{ NumberFormatException -> 0x008b }
        r3 = java.lang.Math.max(r1, r3);	 Catch:{ NumberFormatException -> 0x008b }
        goto L_0x0060;
    L_0x008b:
        r0 = "DefaultHttpDataSource";
        r3 = new java.lang.StringBuilder;
        r4 = "Unexpected Content-Range [";
        r3.<init>(r4);
        r3.append(r8);
        r8 = "]";
        r3.append(r8);
        r8 = r3.toString();
        android.util.Log.e(r0, r8);
    L_0x00a3:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.DefaultHttpDataSource.a(java.net.HttpURLConnection):long");
    }

    private void m17375c() {
        if (this.f17063m != null) {
            try {
                this.f17063m.disconnect();
            } catch (Throwable e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f17063m = null;
        }
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws HttpDataSourceException {
        try {
            if (this.f17068r != this.f17066p) {
                Object obj = (byte[]) f17053c.getAndSet(null);
                if (obj == null) {
                    obj = new byte[4096];
                }
                while (this.f17068r != this.f17066p) {
                    int read = this.f17064n.read(obj, 0, (int) Math.min(this.f17066p - this.f17068r, (long) obj.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read == -1) {
                        throw new EOFException();
                    } else {
                        this.f17068r += (long) read;
                        if (this.f17061k != null) {
                            this.f17061k.mo1472a(read);
                        }
                    }
                }
                f17053c.set(obj);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.f17067q != -1) {
                long j = this.f17067q - this.f17069s;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            bArr = this.f17064n.read(bArr, i, i2);
            if (bArr != -1) {
                this.f17069s += (long) bArr;
                if (this.f17061k != 0) {
                    this.f17061k.mo1472a(bArr);
                }
                return bArr;
            } else if (this.f17067q == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new HttpDataSourceException(e, this.f17062l, 2);
        }
    }
}
