package com.nytimes.android.external.store3.base.impl;

import com.nytimes.android.external.cache3.Preconditions;
import java.io.Serializable;

public final class BarCode implements Serializable {
    private static final BarCode f10229a = new BarCode("", "");
    private final String f10230b;
    private final String f10231c;

    private BarCode(String str, String str2) {
        this.f10230b = (String) Preconditions.m8670a((Object) str2);
        this.f10231c = (String) Preconditions.m8670a((Object) str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BarCode)) {
            return false;
        }
        BarCode barCode = (BarCode) obj;
        return this.f10230b.equals(barCode.f10230b) && this.f10231c.equals(barCode.f10231c) != null;
    }

    public final int hashCode() {
        return (31 * this.f10230b.hashCode()) + this.f10231c.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("BarCode{key='");
        stringBuilder.append(this.f10230b);
        stringBuilder.append('\'');
        stringBuilder.append(", type='");
        stringBuilder.append(this.f10231c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
