package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.HttpUrl.Builder;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address {
    public final HttpUrl f23037a;
    public final Dns f23038b;
    public final SocketFactory f23039c;
    public final Authenticator f23040d;
    public final List<Protocol> f23041e;
    public final List<ConnectionSpec> f23042f;
    public final ProxySelector f23043g;
    public final Proxy f23044h;
    public final SSLSocketFactory f23045i;
    public final HostnameVerifier f23046j;
    public final CertificatePinner f23047k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        Builder builder = new Builder();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            builder.f23205a = "http";
        } else if (str2.equalsIgnoreCase("https")) {
            builder.f23205a = "https";
        } else {
            i = new StringBuilder("unexpected scheme: ");
            i.append(str2);
            throw new IllegalArgumentException(i.toString());
        }
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        str2 = Builder.m25272a(str, 0, str.length());
        if (str2 == null) {
            dns = new StringBuilder("unexpected host: ");
            dns.append(str);
            throw new IllegalArgumentException(dns.toString());
        }
        builder.f23208d = str2;
        if (i > 0) {
            if (i <= 65535) {
                builder.f23209e = i;
                this.f23037a = builder.m25279b();
                if (dns == null) {
                    throw new NullPointerException("dns == null");
                }
                this.f23038b = dns;
                if (socketFactory == null) {
                    throw new NullPointerException("socketFactory == null");
                }
                this.f23039c = socketFactory;
                if (authenticator == null) {
                    throw new NullPointerException("proxyAuthenticator == null");
                }
                this.f23040d = authenticator;
                if (list == null) {
                    throw new NullPointerException("protocols == null");
                }
                this.f23041e = Util.m25362a((List) list);
                if (list2 == null) {
                    throw new NullPointerException("connectionSpecs == null");
                }
                this.f23042f = Util.m25362a((List) list2);
                if (proxySelector == null) {
                    throw new NullPointerException("proxySelector == null");
                }
                this.f23043g = proxySelector;
                this.f23044h = proxy;
                this.f23045i = sSLSocketFactory;
                this.f23046j = hostnameVerifier;
                this.f23047k = certificatePinner;
                return;
            }
        }
        dns = new StringBuilder("unexpected port: ");
        dns.append(i);
        throw new IllegalArgumentException(dns.toString());
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.f23037a.equals(address.f23037a) && m25193a(address) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = 31 * (((((((((((((((((527 + this.f23037a.hashCode()) * 31) + this.f23038b.hashCode()) * 31) + this.f23040d.hashCode()) * 31) + this.f23041e.hashCode()) * 31) + this.f23042f.hashCode()) * 31) + this.f23043g.hashCode()) * 31) + (this.f23044h != null ? this.f23044h.hashCode() : 0)) * 31) + (this.f23045i != null ? this.f23045i.hashCode() : 0)) * 31) + (this.f23046j != null ? this.f23046j.hashCode() : 0));
        if (this.f23047k != null) {
            i = this.f23047k.hashCode();
        }
        return hashCode + i;
    }

    final boolean m25193a(Address address) {
        return (this.f23038b.equals(address.f23038b) && this.f23040d.equals(address.f23040d) && this.f23041e.equals(address.f23041e) && this.f23042f.equals(address.f23042f) && this.f23043g.equals(address.f23043g) && Util.m25371a(this.f23044h, address.f23044h) && Util.m25371a(this.f23045i, address.f23045i) && Util.m25371a(this.f23046j, address.f23046j) && Util.m25371a(this.f23047k, address.f23047k) && this.f23037a.f23216c == address.f23037a.f23216c) ? true : null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Address{");
        stringBuilder.append(this.f23037a.f23215b);
        stringBuilder.append(":");
        stringBuilder.append(this.f23037a.f23216c);
        if (this.f23044h != null) {
            stringBuilder.append(", proxy=");
            stringBuilder.append(this.f23044h);
        } else {
            stringBuilder.append(", proxySelector=");
            stringBuilder.append(this.f23043g);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
