package com.sendbird.android.shadow.okhttp3.internal.connection;

import com.sendbird.android.shadow.okhttp3.ConnectionSpec;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector {
    final List<ConnectionSpec> f23388a;
    int f23389b = 0;
    boolean f23390c;
    boolean f23391d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f23388a = list;
    }

    final boolean m25393a(SSLSocket sSLSocket) {
        for (int i = this.f23389b; i < this.f23388a.size(); i++) {
            if (((ConnectionSpec) this.f23388a.get(i)).m25220a(sSLSocket)) {
                return true;
            }
        }
        return null;
    }
}
