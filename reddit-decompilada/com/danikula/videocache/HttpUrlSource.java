package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import com.facebook.stetho.server.http.HttpStatus;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUrlSource implements Source {
    private static final Logger f12684b = LoggerFactory.a("HttpUrlSource");
    SourceInfo f12685a;
    private final SourceInfoStorage f12686c;
    private HttpURLConnection f12687d;
    private InputStream f12688e;

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.m3362a());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage) {
        this.f12686c = (SourceInfoStorage) Preconditions.m3330a((Object) sourceInfoStorage);
        sourceInfoStorage = sourceInfoStorage.mo1105a(str);
        if (sourceInfoStorage == null) {
            sourceInfoStorage = new SourceInfo(str, -2147483648L, ProxyCacheUtils.m3343a(str));
        }
        this.f12685a = sourceInfoStorage;
    }

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.f12685a = httpUrlSource.f12685a;
        this.f12686c = httpUrlSource.f12686c;
    }

    public final synchronized long mo1100a() throws ProxyCacheException {
        if (this.f12685a.f3772b == -2147483648L) {
            m11763d();
        }
        return this.f12685a.f3772b;
    }

    public final void mo1101a(long j) throws ProxyCacheException {
        try {
            this.f12687d = m11762a(j, -1);
            String contentType = this.f12687d.getContentType();
            this.f12688e = new BufferedInputStream(this.f12687d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f12687d;
            int responseCode = this.f12687d.getResponseCode();
            long a = m11761a(httpURLConnection);
            if (responseCode != HttpStatus.HTTP_OK) {
                a = responseCode == 206 ? a + j : this.f12685a.f3772b;
            }
            this.f12685a = new SourceInfo(this.f12685a.f3771a, a, contentType);
            this.f12686c.mo1106a(this.f12685a.f3771a, this.f12685a);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Error opening connection for ");
            stringBuilder.append(this.f12685a.f3771a);
            stringBuilder.append(" with offset ");
            stringBuilder.append(j);
            throw new ProxyCacheException(stringBuilder.toString(), e);
        }
    }

    private static long m11761a(HttpURLConnection httpURLConnection) {
        httpURLConnection = httpURLConnection.getHeaderField("Content-Length");
        if (httpURLConnection == null) {
            return -1;
        }
        return Long.parseLong(httpURLConnection);
    }

    public final void mo1102b() throws ProxyCacheException {
        if (this.f12687d != null) {
            try {
                this.f12687d.disconnect();
            } catch (Throwable e) {
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (Throwable e2) {
                f12684b.a("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e2);
            }
        }
    }

    public final int mo1099a(byte[] bArr) throws ProxyCacheException {
        StringBuilder stringBuilder;
        if (this.f12688e == null) {
            StringBuilder stringBuilder2 = new StringBuilder("Error reading data from ");
            stringBuilder2.append(this.f12685a.f3771a);
            stringBuilder2.append(": connection is absent!");
            throw new ProxyCacheException(stringBuilder2.toString());
        }
        try {
            return this.f12688e.read(bArr, 0, bArr.length);
        } catch (byte[] bArr2) {
            stringBuilder = new StringBuilder("Reading source ");
            stringBuilder.append(this.f12685a.f3771a);
            stringBuilder.append(" is interrupted");
            throw new InterruptedProxyCacheException(stringBuilder.toString(), bArr2);
        } catch (byte[] bArr22) {
            stringBuilder = new StringBuilder("Error reading data from ");
            stringBuilder.append(this.f12685a.f3771a);
            throw new ProxyCacheException(stringBuilder.toString(), bArr22);
        }
    }

    private void m11763d() throws ProxyCacheException {
        HttpURLConnection a;
        Closeable inputStream;
        Throwable e;
        Logger logger;
        StringBuilder stringBuilder;
        Logger logger2 = f12684b;
        StringBuilder stringBuilder2 = new StringBuilder("Read content info from ");
        stringBuilder2.append(this.f12685a.f3771a);
        logger2.a(stringBuilder2.toString());
        Closeable closeable = null;
        try {
            a = m11762a(0, AbstractSpiCall.DEFAULT_TIMEOUT);
            try {
                long a2 = m11761a(a);
                String contentType = a.getContentType();
                inputStream = a.getInputStream();
                try {
                    this.f12685a = new SourceInfo(this.f12685a.f3771a, a2, contentType);
                    this.f12686c.mo1106a(this.f12685a.f3771a, this.f12685a);
                    Logger logger3 = f12684b;
                    StringBuilder stringBuilder3 = new StringBuilder("Source info fetched: ");
                    stringBuilder3.append(this.f12685a);
                    logger3.a(stringBuilder3.toString());
                    ProxyCacheUtils.m3344a(inputStream);
                    if (a != null) {
                        a.disconnect();
                    }
                } catch (IOException e2) {
                    e = e2;
                    closeable = inputStream;
                    try {
                        logger = f12684b;
                        stringBuilder = new StringBuilder("Error fetching info from ");
                        stringBuilder.append(this.f12685a.f3771a);
                        logger.a(stringBuilder.toString(), e);
                        ProxyCacheUtils.m3344a(closeable);
                        if (a != null) {
                            a.disconnect();
                        }
                    } catch (Throwable th) {
                        e = th;
                        inputStream = closeable;
                        ProxyCacheUtils.m3344a(inputStream);
                        if (a != null) {
                            a.disconnect();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    ProxyCacheUtils.m3344a(inputStream);
                    if (a != null) {
                        a.disconnect();
                    }
                    throw e;
                }
            } catch (IOException e3) {
                e = e3;
                logger = f12684b;
                stringBuilder = new StringBuilder("Error fetching info from ");
                stringBuilder.append(this.f12685a.f3771a);
                logger.a(stringBuilder.toString(), e);
                ProxyCacheUtils.m3344a(closeable);
                if (a != null) {
                    a.disconnect();
                }
            }
        } catch (IOException e4) {
            e = e4;
            a = null;
            logger = f12684b;
            stringBuilder = new StringBuilder("Error fetching info from ");
            stringBuilder.append(this.f12685a.f3771a);
            logger.a(stringBuilder.toString(), e);
            ProxyCacheUtils.m3344a(closeable);
            if (a != null) {
                a.disconnect();
            }
        } catch (Throwable th3) {
            e = th3;
            a = null;
            inputStream = a;
            ProxyCacheUtils.m3344a(inputStream);
            if (a != null) {
                a.disconnect();
            }
            throw e;
        }
    }

    private HttpURLConnection m11762a(long j, int i) throws IOException, ProxyCacheException {
        HttpURLConnection httpURLConnection;
        String str = this.f12685a.f3771a;
        int i2 = 0;
        Object obj;
        do {
            String stringBuilder;
            Logger logger = f12684b;
            StringBuilder stringBuilder2 = new StringBuilder("Open connection ");
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 > 0) {
                StringBuilder stringBuilder3 = new StringBuilder(" with offset ");
                stringBuilder3.append(j);
                stringBuilder = stringBuilder3.toString();
            } else {
                stringBuilder = "";
            }
            stringBuilder2.append(stringBuilder);
            stringBuilder2.append(" to ");
            stringBuilder2.append(str);
            logger.a(stringBuilder2.toString());
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i3 > 0) {
                StringBuilder stringBuilder4 = new StringBuilder("bytes=");
                stringBuilder4.append(j);
                stringBuilder4.append(Operation.MINUS);
                httpURLConnection.setRequestProperty("Range", stringBuilder4.toString());
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (!(responseCode == 301 || responseCode == 302)) {
                if (responseCode != 303) {
                    obj = null;
                    if (obj != null) {
                        str = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                        i2++;
                        httpURLConnection.disconnect();
                    }
                    if (i2 > 5) {
                        StringBuilder stringBuilder5 = new StringBuilder("Too many redirects: ");
                        stringBuilder5.append(i2);
                        throw new ProxyCacheException(stringBuilder5.toString());
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                str = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                StringBuilder stringBuilder52 = new StringBuilder("Too many redirects: ");
                stringBuilder52.append(i2);
                throw new ProxyCacheException(stringBuilder52.toString());
            }
        } while (obj != null);
        return httpURLConnection;
    }

    public final synchronized String m11768c() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.f12685a.f3773c)) {
            m11763d();
        }
        return this.f12685a.f3773c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("HttpUrlSource{sourceInfo='");
        stringBuilder.append(this.f12685a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
