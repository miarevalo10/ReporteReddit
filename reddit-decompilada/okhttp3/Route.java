package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

public final class Route {
    final Address address;
    final InetSocketAddress inetSocketAddress;
    final Proxy proxy;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.address = address;
            this.proxy = proxy;
            this.inetSocketAddress = inetSocketAddress;
        }
    }

    public final Address address() {
        return this.address;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final InetSocketAddress socketAddress() {
        return this.inetSocketAddress;
    }

    public final boolean requiresTunnel() {
        return this.address.sslSocketFactory != null && this.proxy.type() == Type.HTTP;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            if (route.address.equals(this.address) && route.proxy.equals(this.proxy) && route.inetSocketAddress.equals(this.inetSocketAddress) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (((527 + this.address.hashCode()) * 31) + this.proxy.hashCode())) + this.inetSocketAddress.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Route{");
        stringBuilder.append(this.inetSocketAddress);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
