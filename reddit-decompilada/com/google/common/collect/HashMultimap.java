package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    transient int f19829a;

    public final /* bridge */ /* synthetic */ boolean mo2387a(Object obj, Object obj2) {
        return super.mo2387a(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ Set mo4390b(Object obj) {
        return super.mo4390b(obj);
    }

    public final /* bridge */ /* synthetic */ void mo4391b() {
        super.mo4391b();
    }

    public final /* bridge */ /* synthetic */ Set mo4392e() {
        return super.mo4392e();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* bridge */ /* synthetic */ Map mo2388f() {
        return super.mo2388f();
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> HashMultimap<K, V> m21556h() {
        return new HashMultimap();
    }

    private HashMultimap() {
        this((byte) 0);
    }

    private HashMultimap(byte b) {
        super(Platform.m7247a());
        this.f19829a = 2;
        Preconditions.m6913a(true);
        this.f19829a = 2;
    }

    final Set<V> mo4393g() {
        return Platform.m7248a(this.f19829a);
    }

    final /* bridge */ /* synthetic */ Collection mo4053a() {
        return Platform.m7248a(this.f19829a);
    }
}
