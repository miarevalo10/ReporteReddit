package com.google.android.gms.common.internal;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.List;

public final class zzbi {
    private final List<String> f5904a;
    private final Object f5905b;

    private zzbi(Object obj) {
        this.f5905b = zzbq.m4808a(obj);
        this.f5904a = new ArrayList();
    }

    public final zzbi m4807a(String str, Object obj) {
        List list = this.f5904a;
        str = (String) zzbq.m4808a((Object) str);
        String valueOf = String.valueOf(obj);
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(str).length()) + String.valueOf(valueOf).length());
        stringBuilder.append(str);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(valueOf);
        list.add(stringBuilder.toString());
        return this;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(this.f5905b.getClass().getSimpleName());
        stringBuilder.append('{');
        int size = this.f5904a.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) this.f5904a.get(i));
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
