package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec {
    public static final ConnectionSpec f23161a;
    public static final ConnectionSpec f23162b = new Builder(f23161a).m25216a(TlsVersion.TLS_1_0).m25215a().m25219b();
    public static final ConnectionSpec f23163c = new Builder(false).m25219b();
    private static final CipherSuite[] f23164h = new CipherSuite[]{CipherSuite.aX, CipherSuite.bb, CipherSuite.aY, CipherSuite.bc, CipherSuite.bi, CipherSuite.bh, CipherSuite.ay, CipherSuite.aI, CipherSuite.az, CipherSuite.aJ, CipherSuite.ag, CipherSuite.ah, CipherSuite.f23100E, CipherSuite.f23104I, CipherSuite.f23130i};
    final boolean f23165d;
    public final boolean f23166e;
    final String[] f23167f;
    final String[] f23168g;

    public static final class Builder {
        boolean f23157a;
        String[] f23158b;
        String[] f23159c;
        boolean f23160d;

        Builder(boolean z) {
            this.f23157a = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.f23157a = connectionSpec.f23165d;
            this.f23158b = connectionSpec.f23167f;
            this.f23159c = connectionSpec.f23168g;
            this.f23160d = connectionSpec.f23166e;
        }

        public final Builder m25217a(String... strArr) {
            if (!this.f23157a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.f23158b = (String[]) strArr.clone();
                return this;
            }
        }

        public final Builder m25216a(TlsVersion... tlsVersionArr) {
            if (this.f23157a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].f23330f;
                }
                return m25218b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public final Builder m25218b(String... strArr) {
            if (!this.f23157a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.f23159c = (String[]) strArr.clone();
                return this;
            }
        }

        public final Builder m25215a() {
            if (this.f23157a) {
                this.f23160d = true;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public final ConnectionSpec m25219b() {
            return new ConnectionSpec(this);
        }
    }

    static {
        Builder builder = new Builder(true);
        CipherSuite[] cipherSuiteArr = f23164h;
        if (builder.f23157a) {
            String[] strArr = new String[cipherSuiteArr.length];
            for (int i = 0; i < cipherSuiteArr.length; i++) {
                strArr[i] = cipherSuiteArr[i].bj;
            }
            f23161a = builder.m25217a(strArr).m25216a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).m25215a().m25219b();
            return;
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    ConnectionSpec(Builder builder) {
        this.f23165d = builder.f23157a;
        this.f23167f = builder.f23158b;
        this.f23168g = builder.f23159c;
        this.f23166e = builder.f23160d;
    }

    public final boolean m25220a(SSLSocket sSLSocket) {
        if (!this.f23165d) {
            return false;
        }
        if (this.f23168g != null && !Util.m25376b(Util.f23341h, this.f23168g, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f23167f == null || Util.m25376b(CipherSuite.f23122a, this.f23167f, sSLSocket.getEnabledCipherSuites()) != null) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        if (this.f23165d != connectionSpec.f23165d) {
            return false;
        }
        return !this.f23165d || (Arrays.equals(this.f23167f, connectionSpec.f23167f) && Arrays.equals(this.f23168g, connectionSpec.f23168g) && this.f23166e == connectionSpec.f23166e);
    }

    public final int hashCode() {
        return this.f23165d ? (31 * (((527 + Arrays.hashCode(this.f23167f)) * 31) + Arrays.hashCode(this.f23168g))) + (this.f23166e ^ 1) : 17;
    }

    public final String toString() {
        if (!this.f23165d) {
            return "ConnectionSpec()";
        }
        String obj;
        String obj2;
        Object obj3 = null;
        if (this.f23167f != null) {
            obj = (this.f23167f != null ? CipherSuite.m25211a(this.f23167f) : null).toString();
        } else {
            obj = "[all enabled]";
        }
        if (this.f23168g != null) {
            if (this.f23168g != null) {
                obj3 = TlsVersion.m25342a(this.f23168g);
            }
            obj2 = obj3.toString();
        } else {
            obj2 = "[all enabled]";
        }
        StringBuilder stringBuilder = new StringBuilder("ConnectionSpec(cipherSuites=");
        stringBuilder.append(obj);
        stringBuilder.append(", tlsVersions=");
        stringBuilder.append(obj2);
        stringBuilder.append(", supportsTlsExtensions=");
        stringBuilder.append(this.f23166e);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
