package org.parceler;

import java.util.ArrayList;
import java.util.List;

public final class IdentityCollection {
    public static final Object f27202a = new Object();
    private final List<Object> f27203b = new ArrayList();

    public IdentityCollection() {
        m28660a(null);
    }

    public final boolean m28662a(int i) {
        return i < this.f27203b.size();
    }

    public final boolean m28664b(int i) {
        return this.f27203b.get(i) == f27202a;
    }

    public final void m28661a(int i, Object obj) {
        if (this.f27203b.size() > i) {
            this.f27203b.remove(i);
        }
        this.f27203b.add(i, obj);
    }

    public final int m28660a(Object obj) {
        this.f27203b.add(obj);
        return this.f27203b.size() - 1;
    }

    public final <T> T m28665c(int i) {
        return this.f27203b.get(i);
    }

    public final int m28663b(Object obj) {
        for (int i = 0; i < this.f27203b.size(); i++) {
            if (this.f27203b.get(i) == obj) {
                return i;
            }
        }
        return -1;
    }
}
