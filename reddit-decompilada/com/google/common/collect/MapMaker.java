package com.google.common.collect;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

public final class MapMaker {
    public boolean f8441a;
    int f8442b = -1;
    int f8443c = -1;
    public Strength f8444d;
    Strength f8445e;
    Equivalence<Object> f8446f;

    public final int m7167a() {
        return this.f8442b == -1 ? 16 : this.f8442b;
    }

    public final int m7168b() {
        return this.f8443c == -1 ? 4 : this.f8443c;
    }

    final Strength m7169c() {
        return (Strength) MoreObjects.m6895a(this.f8444d, Strength.f8462a);
    }

    final Strength m7170d() {
        return (Strength) MoreObjects.m6895a(this.f8445e, Strength.f8462a);
    }

    public final String toString() {
        ToStringHelper a = MoreObjects.m6894a(this);
        if (this.f8442b != -1) {
            a.m6891a("initialCapacity", this.f8442b);
        }
        if (this.f8443c != -1) {
            a.m6891a("concurrencyLevel", this.f8443c);
        }
        if (this.f8444d != null) {
            a.m6893a("keyStrength", Ascii.m6871a(this.f8444d.toString()));
        }
        if (this.f8445e != null) {
            a.m6893a("valueStrength", Ascii.m6871a(this.f8445e.toString()));
        }
        if (this.f8446f != null) {
            a.m6890a("keyEquivalence");
        }
        return a.toString();
    }
}
