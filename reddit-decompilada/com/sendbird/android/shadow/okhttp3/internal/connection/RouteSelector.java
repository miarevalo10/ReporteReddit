package com.sendbird.android.shadow.okhttp3.internal.connection;

import com.sendbird.android.shadow.okhttp3.Address;
import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.EventListener;
import com.sendbird.android.shadow.okhttp3.Route;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector {
    final Address f23397a;
    final RouteDatabase f23398b;
    private final Call f23399c;
    private final EventListener f23400d;
    private List<Proxy> f23401e = Collections.emptyList();
    private int f23402f;
    private List<InetSocketAddress> f23403g = Collections.emptyList();
    private final List<Route> f23404h = new ArrayList();

    public static final class Selection {
        final List<Route> f23395a;
        int f23396b = 0;

        Selection(List<Route> list) {
            this.f23395a = list;
        }

        public final boolean m25398a() {
            return this.f23396b < this.f23395a.size();
        }
    }

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f23397a = address;
        this.f23398b = routeDatabase;
        this.f23399c = call;
        this.f23400d = eventListener;
        routeDatabase = address.f23037a;
        address = address.f23044h;
        if (address != null) {
            address = Collections.singletonList(address);
        } else {
            List select = this.f23397a.f23043g.select(routeDatabase.m25292a());
            if (select == null || select.isEmpty() != null) {
                address = Util.m25363a(Proxy.NO_PROXY);
            } else {
                address = Util.m25362a(select);
            }
        }
        this.f23401e = address;
        this.f23402f = 0;
    }

    public final boolean m25401a() {
        if (!m25400c()) {
            if (this.f23404h.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final Selection m25402b() throws IOException {
        if (m25401a()) {
            List arrayList = new ArrayList();
            while (m25400c()) {
                if (m25400c()) {
                    List list = this.f23401e;
                    int i = this.f23402f;
                    this.f23402f = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    m25399a(proxy);
                    int size = this.f23403g.size();
                    for (i = 0; i < size; i++) {
                        Route route = new Route(this.f23397a, proxy, (InetSocketAddress) this.f23403g.get(i));
                        if (this.f23398b.m25396c(route)) {
                            this.f23404h.add(route);
                        } else {
                            arrayList.add(route);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("No route to ");
                stringBuilder.append(this.f23397a.f23037a.f23215b);
                stringBuilder.append("; exhausted proxy configurations: ");
                stringBuilder.append(this.f23401e);
                throw new SocketException(stringBuilder.toString());
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f23404h);
                this.f23404h.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }

    private boolean m25400c() {
        return this.f23402f < this.f23401e.size();
    }

    private void m25399a(Proxy proxy) throws IOException {
        String hostName;
        int port;
        int size;
        int i;
        StringBuilder stringBuilder;
        this.f23403g = new ArrayList();
        if (proxy.type() != Type.DIRECT) {
            if (proxy.type() != Type.SOCKS) {
                SocketAddress address = proxy.address();
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    InetAddress address2 = inetSocketAddress.getAddress();
                    if (address2 == null) {
                        hostName = inetSocketAddress.getHostName();
                    } else {
                        hostName = address2.getHostAddress();
                    }
                    port = inetSocketAddress.getPort();
                    if (port > 0) {
                        if (port > 65535) {
                            if (proxy.type() != Type.SOCKS) {
                                this.f23403g.add(InetSocketAddress.createUnresolved(hostName, port));
                                return;
                            }
                            EventListener.m25238b();
                            proxy = this.f23397a.f23038b.mo5301a(hostName);
                            if (proxy.isEmpty()) {
                                EventListener.m25239c();
                                size = proxy.size();
                                for (i = 0; i < size; i++) {
                                    this.f23403g.add(new InetSocketAddress((InetAddress) proxy.get(i), port));
                                }
                                return;
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(this.f23397a.f23038b);
                            stringBuilder2.append(" returned no addresses for ");
                            stringBuilder2.append(hostName);
                            throw new UnknownHostException(stringBuilder2.toString());
                        }
                    }
                    stringBuilder = new StringBuilder("No route to ");
                    stringBuilder.append(hostName);
                    stringBuilder.append(":");
                    stringBuilder.append(port);
                    stringBuilder.append("; port is out of range");
                    throw new SocketException(stringBuilder.toString());
                }
                StringBuilder stringBuilder3 = new StringBuilder("Proxy.address() is not an InetSocketAddress: ");
                stringBuilder3.append(address.getClass());
                throw new IllegalArgumentException(stringBuilder3.toString());
            }
        }
        hostName = this.f23397a.f23037a.f23215b;
        port = this.f23397a.f23037a.f23216c;
        if (port > 0) {
            if (port > 65535) {
                if (proxy.type() != Type.SOCKS) {
                    EventListener.m25238b();
                    proxy = this.f23397a.f23038b.mo5301a(hostName);
                    if (proxy.isEmpty()) {
                        EventListener.m25239c();
                        size = proxy.size();
                        for (i = 0; i < size; i++) {
                            this.f23403g.add(new InetSocketAddress((InetAddress) proxy.get(i), port));
                        }
                        return;
                    }
                    StringBuilder stringBuilder22 = new StringBuilder();
                    stringBuilder22.append(this.f23397a.f23038b);
                    stringBuilder22.append(" returned no addresses for ");
                    stringBuilder22.append(hostName);
                    throw new UnknownHostException(stringBuilder22.toString());
                }
                this.f23403g.add(InetSocketAddress.createUnresolved(hostName, port));
                return;
            }
        }
        stringBuilder = new StringBuilder("No route to ");
        stringBuilder.append(hostName);
        stringBuilder.append(":");
        stringBuilder.append(port);
        stringBuilder.append("; port is out of range");
        throw new SocketException(stringBuilder.toString());
    }
}
