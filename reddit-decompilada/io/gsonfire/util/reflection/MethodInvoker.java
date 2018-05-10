package io.gsonfire.util.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MethodInvoker {
    public final Method f24976a;
    public final List<Class> f24977b;

    public interface ValueSupplier {
        Object mo5617a(Class cls);
    }

    public MethodInvoker(Method method, Set<Class> set) {
        this.f24976a = method;
        this.f24977b = new ArrayList(set.size());
        method = this.f24976a.getParameterTypes();
        int i = 0;
        int length = method.length;
        while (i < length) {
            Object obj = method[i];
            if (set.contains(obj)) {
                this.f24977b.add(obj);
                i++;
            } else {
                set = new StringBuilder("Cannot auto inject type: ");
                set.append(obj);
                throw new IllegalArgumentException(set.toString());
            }
        }
    }
}
