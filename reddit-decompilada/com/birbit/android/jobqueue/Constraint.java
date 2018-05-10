package com.birbit.android.jobqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Constraint {
    public int f2848a;
    public TagConstraint f2849b;
    public final Set<String> f2850c = new HashSet();
    public final List<String> f2851d = new ArrayList();
    public final List<String> f2852e = new ArrayList();
    public boolean f2853f;
    public Long f2854g;
    public long f2855h;

    final void m2485a(String[] strArr) {
        this.f2850c.clear();
        if (strArr != null) {
            Collections.addAll(this.f2850c, strArr);
        }
    }

    final void m2484a(Collection<String> collection) {
        this.f2851d.clear();
        if (collection != null) {
            this.f2851d.addAll(collection);
        }
    }

    final void m2483a() {
        this.f2848a = 2;
        this.f2849b = null;
        this.f2850c.clear();
        this.f2851d.clear();
        this.f2852e.clear();
        this.f2853f = false;
        this.f2854g = null;
        this.f2855h = Long.MIN_VALUE;
    }
}
