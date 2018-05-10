package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzaiu {
    private final List<String> f6432a = new ArrayList();
    private final List<Double> f6433b = new ArrayList();
    private final List<Double> f6434c = new ArrayList();

    public final zzaiu m5292a(String str, double d, double d2) {
        int i = 0;
        while (i < this.f6432a.size()) {
            double doubleValue = ((Double) this.f6434c.get(i)).doubleValue();
            double doubleValue2 = ((Double) this.f6433b.get(i)).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.f6432a.add(i, str);
        this.f6434c.add(i, Double.valueOf(d));
        this.f6433b.add(i, Double.valueOf(d2));
        return this;
    }
}
