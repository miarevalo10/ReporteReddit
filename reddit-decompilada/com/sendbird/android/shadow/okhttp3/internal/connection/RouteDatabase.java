package com.sendbird.android.shadow.okhttp3.internal.connection;

import com.sendbird.android.shadow.okhttp3.Route;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RouteDatabase {
    private final Set<Route> f23392a = new LinkedHashSet();

    public final synchronized void m25394a(Route route) {
        this.f23392a.add(route);
    }

    public final synchronized void m25395b(Route route) {
        this.f23392a.remove(route);
    }

    public final synchronized boolean m25396c(Route route) {
        return this.f23392a.contains(route);
    }
}
