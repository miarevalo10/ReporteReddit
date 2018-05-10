package com.sendbird.android.shadow.okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class Route {
    public final Address f23321a;
    public final Proxy f23322b;
    public final InetSocketAddress f23323c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f23321a = address;
            this.f23322b = proxy;
            this.f23323c = inetSocketAddress;
        }
    }

    public final boolean m25340a() {
        return this.f23321a.f23045i != null && this.f23322b.type() == Type.HTTP;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.f23321a.equals(this.f23321a) && route.f23322b.equals(this.f23322b) && route.f23323c.equals(this.f23323c) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (((527 + this.f23321a.hashCode()) * 31) + this.f23322b.hashCode())) + this.f23323c.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Route{");
        stringBuilder.append(this.f23323c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
