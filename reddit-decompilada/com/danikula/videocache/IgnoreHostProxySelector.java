package com.danikula.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

class IgnoreHostProxySelector extends ProxySelector {
    private static final List<Proxy> f3751a = Arrays.asList(new Proxy[]{Proxy.NO_PROXY});
    private final ProxySelector f3752b;
    private final String f3753c;
    private final int f3754d;

    private IgnoreHostProxySelector(ProxySelector proxySelector, String str, int i) {
        this.f3752b = (ProxySelector) Preconditions.m3330a((Object) proxySelector);
        this.f3753c = (String) Preconditions.m3330a((Object) str);
        this.f3754d = i;
    }

    static void m3322a(String str, int i) {
        ProxySelector.setDefault(new IgnoreHostProxySelector(ProxySelector.getDefault(), str, i));
    }

    public List<Proxy> select(URI uri) {
        Object obj = (this.f3753c.equals(uri.getHost()) && this.f3754d == uri.getPort()) ? 1 : null;
        return obj != null ? f3751a : this.f3752b.select(uri);
    }

    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f3752b.connectFailed(uri, socketAddress, iOException);
    }
}
