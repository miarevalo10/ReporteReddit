package com.birbit.android.jobqueue;

import java.util.Collections;
import java.util.HashSet;

public class Params {
    int f2939a = 0;
    public String f2940b = null;
    public String f2941c = null;
    public boolean f2942d = false;
    int f2943e;
    long f2944f;
    HashSet<String> f2945g;
    long f2946h = 0;
    Boolean f2947i;

    public Params(int i) {
        this.f2943e = i;
    }

    public final Params m2535a() {
        if (this.f2939a != 2) {
            this.f2939a = 1;
        }
        return this;
    }

    public final Params m2537b() {
        this.f2942d = true;
        return this;
    }

    public final Params m2536a(String... strArr) {
        if (this.f2945g == null) {
            this.f2945g = new HashSet();
        }
        Collections.addAll(this.f2945g, strArr);
        return this;
    }
}
