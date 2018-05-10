package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzfhz extends zzfhy<FieldDescriptorType, Object> {
    zzfhz(int i) {
        super(i);
    }

    public final void mo1917a() {
        if (!this.f7448a) {
            Entry b;
            for (int i = 0; i < m6071b(); i++) {
                b = m6072b(i);
                if (((zzffs) b.getKey()).m6001d()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Entry b2 : m6073c()) {
                if (((zzffs) b2.getKey()).m6001d()) {
                    b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                }
            }
        }
        super.mo1917a();
    }
}
