package kotlin.jvm.internal;

import java.util.ArrayList;

public class SpreadBuilder {
    public final ArrayList<Object> f25294a = new ArrayList(2);

    public final void m26865a(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    this.f25294a.ensureCapacity(this.f25294a.size() + objArr.length);
                    for (Object add : objArr) {
                        this.f25294a.add(add);
                    }
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Don't know how to spread ");
            stringBuilder.append(obj.getClass());
            throw new UnsupportedOperationException(stringBuilder.toString());
        }
    }

    public final void m26867b(Object obj) {
        this.f25294a.add(obj);
    }

    public final Object[] m26866a(Object[] objArr) {
        return this.f25294a.toArray(objArr);
    }
}
