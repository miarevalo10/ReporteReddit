package com.bumptech.glide.util;

public class MultiClassKey {
    private Class<?> f3670a;
    private Class<?> f3671b;
    private Class<?> f3672c;

    public MultiClassKey(Class<?> cls, Class<?> cls2) {
        m3216a(cls, cls2, null);
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        m3216a(cls, cls2, cls3);
    }

    public final void m3216a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f3670a = cls;
        this.f3671b = cls2;
        this.f3672c = cls3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MultiClassKey{first=");
        stringBuilder.append(this.f3670a);
        stringBuilder.append(", second=");
        stringBuilder.append(this.f3671b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (getClass() == obj.getClass()) {
                MultiClassKey multiClassKey = (MultiClassKey) obj;
                return this.f3670a.equals(multiClassKey.f3670a) && this.f3671b.equals(multiClassKey.f3671b) && Util.m3232a(this.f3672c, multiClassKey.f3672c) != null;
            }
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((this.f3670a.hashCode() * 31) + this.f3671b.hashCode())) + (this.f3672c != null ? this.f3672c.hashCode() : 0);
    }
}
