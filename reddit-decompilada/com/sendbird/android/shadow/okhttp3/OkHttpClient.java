package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.EventListener.Factory;
import com.sendbird.android.shadow.okhttp3.internal.Internal;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.cache.InternalCache;
import com.sendbird.android.shadow.okhttp3.internal.connection.RealConnection;
import com.sendbird.android.shadow.okhttp3.internal.connection.RouteDatabase;
import com.sendbird.android.shadow.okhttp3.internal.connection.StreamAllocation;
import com.sendbird.android.shadow.okhttp3.internal.tls.CertificateChainCleaner;
import com.sendbird.android.shadow.okhttp3.internal.tls.OkHostnameVerifier;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.lang.ref.Reference;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class OkHttpClient implements Cloneable {
    static final List<Protocol> f23256a = Util.m25363a(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<ConnectionSpec> f23257b = Util.m25363a(ConnectionSpec.f23161a, ConnectionSpec.f23163c);
    final int f23258A;
    final int f23259B;
    public final int f23260C;
    public final Dispatcher f23261c;
    public final Proxy f23262d;
    public final List<Protocol> f23263e;
    public final List<ConnectionSpec> f23264f;
    final List<Interceptor> f23265g;
    final List<Interceptor> f23266h;
    final Factory f23267i;
    public final ProxySelector f23268j;
    public final CookieJar f23269k;
    final Cache f23270l;
    final InternalCache f23271m;
    public final SocketFactory f23272n;
    public final SSLSocketFactory f23273o;
    final CertificateChainCleaner f23274p;
    public final HostnameVerifier f23275q;
    public final CertificatePinner f23276r;
    public final Authenticator f23277s;
    public final Authenticator f23278t;
    public final ConnectionPool f23279u;
    public final Dns f23280v;
    public final boolean f23281w;
    public final boolean f23282x;
    public final boolean f23283y;
    final int f23284z;

    public static final class Builder {
        int f23229A;
        Dispatcher f23230a;
        Proxy f23231b;
        public List<Protocol> f23232c;
        List<ConnectionSpec> f23233d;
        final List<Interceptor> f23234e;
        final List<Interceptor> f23235f;
        public Factory f23236g;
        ProxySelector f23237h;
        CookieJar f23238i;
        Cache f23239j;
        InternalCache f23240k;
        SocketFactory f23241l;
        SSLSocketFactory f23242m;
        CertificateChainCleaner f23243n;
        HostnameVerifier f23244o;
        CertificatePinner f23245p;
        Authenticator f23246q;
        Authenticator f23247r;
        ConnectionPool f23248s;
        Dns f23249t;
        boolean f23250u;
        boolean f23251v;
        boolean f23252w;
        int f23253x;
        public int f23254y;
        public int f23255z;

        public Builder() {
            this.f23234e = new ArrayList();
            this.f23235f = new ArrayList();
            this.f23230a = new Dispatcher();
            this.f23232c = OkHttpClient.f23256a;
            this.f23233d = OkHttpClient.f23257b;
            this.f23236g = EventListener.m25236a(EventListener.f23191a);
            this.f23237h = ProxySelector.getDefault();
            this.f23238i = CookieJar.f23182a;
            this.f23241l = SocketFactory.getDefault();
            this.f23244o = OkHostnameVerifier.f23565a;
            this.f23245p = CertificatePinner.f23093a;
            this.f23246q = Authenticator.f23048a;
            this.f23247r = Authenticator.f23048a;
            this.f23248s = new ConnectionPool();
            this.f23249t = Dns.f23190a;
            this.f23250u = true;
            this.f23251v = true;
            this.f23252w = true;
            this.f23253x = AbstractSpiCall.DEFAULT_TIMEOUT;
            this.f23254y = AbstractSpiCall.DEFAULT_TIMEOUT;
            this.f23255z = AbstractSpiCall.DEFAULT_TIMEOUT;
            this.f23229A = 0;
        }

        public Builder(OkHttpClient okHttpClient) {
            this.f23234e = new ArrayList();
            this.f23235f = new ArrayList();
            this.f23230a = okHttpClient.f23261c;
            this.f23231b = okHttpClient.f23262d;
            this.f23232c = okHttpClient.f23263e;
            this.f23233d = okHttpClient.f23264f;
            this.f23234e.addAll(okHttpClient.f23265g);
            this.f23235f.addAll(okHttpClient.f23266h);
            this.f23236g = okHttpClient.f23267i;
            this.f23237h = okHttpClient.f23268j;
            this.f23238i = okHttpClient.f23269k;
            this.f23240k = okHttpClient.f23271m;
            this.f23239j = okHttpClient.f23270l;
            this.f23241l = okHttpClient.f23272n;
            this.f23242m = okHttpClient.f23273o;
            this.f23243n = okHttpClient.f23274p;
            this.f23244o = okHttpClient.f23275q;
            this.f23245p = okHttpClient.f23276r;
            this.f23246q = okHttpClient.f23277s;
            this.f23247r = okHttpClient.f23278t;
            this.f23248s = okHttpClient.f23279u;
            this.f23249t = okHttpClient.f23280v;
            this.f23250u = okHttpClient.f23281w;
            this.f23251v = okHttpClient.f23282x;
            this.f23252w = okHttpClient.f23283y;
            this.f23253x = okHttpClient.f23284z;
            this.f23254y = okHttpClient.f23258A;
            this.f23255z = okHttpClient.f23259B;
            this.f23229A = okHttpClient.f23260C;
        }

        public final OkHttpClient m25309a() {
            return new OkHttpClient(this);
        }
    }

    class C24671 extends Internal {
        C24671() {
        }

        public final void addLenient(com.sendbird.android.shadow.okhttp3.Headers.Builder builder, String str) {
            builder.m25260a(str);
        }

        public final void addLenient(com.sendbird.android.shadow.okhttp3.Headers.Builder builder, String str, String str2) {
            builder.m25264b(str, str2);
        }

        public final boolean equalsNonHost(Address address, Address address2) {
            return address.m25193a(address2);
        }

        public final RouteDatabase routeDatabase(ConnectionPool connectionPool) {
            return connectionPool.f23154e;
        }

        public final int code(com.sendbird.android.shadow.okhttp3.Response.Builder builder) {
            return builder.f23298c;
        }

        public final HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException {
            return HttpUrl.m25291e(str);
        }

        public final StreamAllocation streamAllocation(Call call) {
            return ((RealCall) call).f30368b.f30422a;
        }

        public final Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
            return RealCall.m31337a(okHttpClient, request, true);
        }

        public final void setCache(Builder builder, InternalCache internalCache) {
            builder.f23240k = internalCache;
            builder.f23239j = null;
        }

        public final boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
            if (ConnectionPool.f23150g || Thread.holdsLock(connectionPool)) {
                if (!realConnection.f30398h) {
                    if (connectionPool.f23151b != 0) {
                        connectionPool.notifyAll();
                        return null;
                    }
                }
                connectionPool.f23153d.remove(realConnection);
                return true;
            }
            throw new AssertionError();
        }

        public final RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
            if (ConnectionPool.f23150g || Thread.holdsLock(connectionPool)) {
                for (RealConnection realConnection : connectionPool.f23153d) {
                    if (realConnection.m31365a(address, route)) {
                        streamAllocation.m25410a(realConnection, true);
                        return realConnection;
                    }
                }
                return null;
            }
            throw new AssertionError();
        }

        public final Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
            if (ConnectionPool.f23150g || Thread.holdsLock(connectionPool)) {
                for (RealConnection realConnection : connectionPool.f23153d) {
                    if (realConnection.m31365a(address, null) && realConnection.m31368b() && realConnection != streamAllocation.m25413b()) {
                        if (StreamAllocation.f23406k == null && Thread.holdsLock(streamAllocation.f23410d) == null) {
                            throw new AssertionError();
                        }
                        if (streamAllocation.f23416j == null) {
                            if (streamAllocation.f23414h.f30401k.size() == 1) {
                                Reference reference = (Reference) streamAllocation.f23414h.f30401k.get(0);
                                address = streamAllocation.m25409a(true, false, false);
                                streamAllocation.f23414h = realConnection;
                                realConnection.f30401k.add(reference);
                                return address;
                            }
                        }
                        throw new IllegalStateException();
                    }
                }
                return null;
            }
            throw new AssertionError();
        }

        public final void put(ConnectionPool connectionPool, RealConnection realConnection) {
            if (ConnectionPool.f23150g || Thread.holdsLock(connectionPool)) {
                if (!connectionPool.f23155f) {
                    connectionPool.f23155f = true;
                    ConnectionPool.f23149a.execute(connectionPool.f23152c);
                }
                connectionPool.f23153d.add(realConnection);
                return;
            }
            throw new AssertionError();
        }

        public final void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
            String[] a;
            String[] a2;
            if (connectionSpec.f23167f != null) {
                a = Util.m25372a(CipherSuite.f23122a, sSLSocket.getEnabledCipherSuites(), connectionSpec.f23167f);
            } else {
                a = sSLSocket.getEnabledCipherSuites();
            }
            if (connectionSpec.f23168g != null) {
                a2 = Util.m25372a(Util.f23341h, sSLSocket.getEnabledProtocols(), connectionSpec.f23168g);
            } else {
                a2 = sSLSocket.getEnabledProtocols();
            }
            String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
            boolean a3 = Util.m25356a(CipherSuite.f23122a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
            if (z && !a3) {
                a = Util.m25373a(a, supportedCipherSuites[a3]);
            }
            connectionSpec = new com.sendbird.android.shadow.okhttp3.ConnectionSpec.Builder(connectionSpec).m25217a(a).m25218b(a2).m25219b();
            if (connectionSpec.f23168g) {
                sSLSocket.setEnabledProtocols(connectionSpec.f23168g);
            }
            if (connectionSpec.f23167f) {
                sSLSocket.setEnabledCipherSuites(connectionSpec.f23167f);
            }
        }
    }

    static {
        Internal.instance = new C24671();
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        CertificatePinner certificatePinner;
        Object obj;
        StringBuilder stringBuilder;
        this.f23261c = builder.f23230a;
        this.f23262d = builder.f23231b;
        this.f23263e = builder.f23232c;
        this.f23264f = builder.f23233d;
        this.f23265g = Util.m25362a(builder.f23234e);
        this.f23266h = Util.m25362a(builder.f23235f);
        this.f23267i = builder.f23236g;
        this.f23268j = builder.f23237h;
        this.f23269k = builder.f23238i;
        this.f23270l = builder.f23239j;
        this.f23271m = builder.f23240k;
        this.f23272n = builder.f23241l;
        loop0:
        while (true) {
            Object obj2 = null;
            for (ConnectionSpec connectionSpec : this.f23264f) {
                if (obj2 != null || connectionSpec.f23165d) {
                    obj2 = 1;
                }
            }
            break loop0;
        }
        if (builder.f23242m == null) {
            if (obj2 != null) {
                X509TrustManager a = m25311a();
                this.f23273o = m25310a(a);
                this.f23274p = CertificateChainCleaner.m25565a(a);
                this.f23275q = builder.f23244o;
                certificatePinner = builder.f23245p;
                obj = this.f23274p;
                if (Util.m25371a(certificatePinner.f23095c, obj)) {
                    certificatePinner = new CertificatePinner(certificatePinner.f23094b, obj);
                }
                this.f23276r = certificatePinner;
                this.f23277s = builder.f23246q;
                this.f23278t = builder.f23247r;
                this.f23279u = builder.f23248s;
                this.f23280v = builder.f23249t;
                this.f23281w = builder.f23250u;
                this.f23282x = builder.f23251v;
                this.f23283y = builder.f23252w;
                this.f23284z = builder.f23253x;
                this.f23258A = builder.f23254y;
                this.f23259B = builder.f23255z;
                this.f23260C = builder.f23229A;
                if (this.f23265g.contains(null) != null) {
                    stringBuilder = new StringBuilder("Null interceptor: ");
                    stringBuilder.append(this.f23265g);
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (this.f23266h.contains(null) != null) {
                    stringBuilder = new StringBuilder("Null network interceptor: ");
                    stringBuilder.append(this.f23266h);
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
        }
        this.f23273o = builder.f23242m;
        this.f23274p = builder.f23243n;
        this.f23275q = builder.f23244o;
        certificatePinner = builder.f23245p;
        obj = this.f23274p;
        if (Util.m25371a(certificatePinner.f23095c, obj)) {
            certificatePinner = new CertificatePinner(certificatePinner.f23094b, obj);
        }
        this.f23276r = certificatePinner;
        this.f23277s = builder.f23246q;
        this.f23278t = builder.f23247r;
        this.f23279u = builder.f23248s;
        this.f23280v = builder.f23249t;
        this.f23281w = builder.f23250u;
        this.f23282x = builder.f23251v;
        this.f23283y = builder.f23252w;
        this.f23284z = builder.f23253x;
        this.f23258A = builder.f23254y;
        this.f23259B = builder.f23255z;
        this.f23260C = builder.f23229A;
        if (this.f23265g.contains(null) != null) {
            stringBuilder = new StringBuilder("Null interceptor: ");
            stringBuilder.append(this.f23265g);
            throw new IllegalStateException(stringBuilder.toString());
        } else if (this.f23266h.contains(null) != null) {
            stringBuilder = new StringBuilder("Null network interceptor: ");
            stringBuilder.append(this.f23266h);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private static X509TrustManager m25311a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1) {
                if (trustManagers[0] instanceof X509TrustManager) {
                    return (X509TrustManager) trustManagers[0];
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Unexpected default trust managers:");
            stringBuilder.append(Arrays.toString(trustManagers));
            throw new IllegalStateException(stringBuilder.toString());
        } catch (Exception e) {
            throw Util.m25357a("No System TLS", e);
        }
    }

    private static SSLSocketFactory m25310a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{x509TrustManager}, null);
            return instance.getSocketFactory();
        } catch (Exception e) {
            throw Util.m25357a("No System TLS", e);
        }
    }
}
