package kotlin.reflect.jvm.internal.pcollections;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;

public final class MapEntry<K, V> implements Serializable {
    public final K f26453a;
    public final V f26454b;

    public MapEntry(K k, V v) {
        this.f26453a = k;
        this.f26454b = v;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
        r3 = this;
        r0 = r4 instanceof kotlin.reflect.jvm.internal.pcollections.MapEntry;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r4 = (kotlin.reflect.jvm.internal.pcollections.MapEntry) r4;
        r0 = r3.f26453a;
        if (r0 != 0) goto L_0x0011;
    L_0x000c:
        r0 = r4.f26453a;
        if (r0 != 0) goto L_0x0030;
    L_0x0010:
        goto L_0x001b;
    L_0x0011:
        r0 = r3.f26453a;
        r2 = r4.f26453a;
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x0030;
    L_0x001b:
        r0 = r3.f26454b;
        if (r0 != 0) goto L_0x0024;
    L_0x001f:
        r4 = r4.f26454b;
        if (r4 != 0) goto L_0x0030;
    L_0x0023:
        goto L_0x002e;
    L_0x0024:
        r0 = r3.f26454b;
        r4 = r4.f26454b;
        r4 = r0.equals(r4);
        if (r4 == 0) goto L_0x0030;
    L_0x002e:
        r4 = 1;
        return r4;
    L_0x0030:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.pcollections.MapEntry.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.f26453a == null ? 0 : this.f26453a.hashCode();
        if (this.f26454b != null) {
            i = this.f26454b.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f26453a);
        stringBuilder.append(Operation.EQUALS);
        stringBuilder.append(this.f26454b);
        return stringBuilder.toString();
    }
}
