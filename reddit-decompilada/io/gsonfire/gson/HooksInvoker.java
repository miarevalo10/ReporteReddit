package io.gsonfire.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.gsonfire.util.reflection.AbstractMethodInspector;
import io.gsonfire.util.reflection.MethodInvoker;
import io.gsonfire.util.reflection.MethodInvoker.ValueSupplier;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class HooksInvoker {
    private static final Set<Class> f24961a = new HashSet(Arrays.asList(new Class[]{JsonElement.class, Gson.class}));
    private AbstractMethodInspector<MethodInvoker> f24962b = new C27351(this);

    private static class HooksInvokerValueSupplier implements ValueSupplier {
        private final JsonElement f31061a;
        private final Gson f31062b;

        private HooksInvokerValueSupplier(JsonElement jsonElement, Gson gson) {
            this.f31061a = jsonElement;
            this.f31062b = gson;
        }

        public final Object mo5617a(Class cls) {
            if (cls == JsonElement.class) {
                return this.f31061a;
            }
            return cls == Gson.class ? this.f31062b : null;
        }
    }

    class C27351 extends AbstractMethodInspector<MethodInvoker> {
        final /* synthetic */ HooksInvoker f34699a;

        C27351(HooksInvoker hooksInvoker) {
            this.f34699a = hooksInvoker;
        }

        protected final /* synthetic */ Object mo5618a(AccessibleObject accessibleObject) {
            return new MethodInvoker((Method) accessibleObject, HooksInvoker.f24961a);
        }
    }

    final void m26460a(Object obj, Class<? extends Annotation> cls, JsonElement jsonElement, Gson gson) {
        if (obj != null) {
            cls = this.f24962b.m26465a(obj.getClass(), cls).iterator();
            while (cls.hasNext()) {
                MethodInvoker methodInvoker = (MethodInvoker) cls.next();
                try {
                    int i = 0;
                    ValueSupplier hooksInvokerValueSupplier = new HooksInvokerValueSupplier(jsonElement, gson);
                    Object[] objArr = new Object[methodInvoker.f24976a.getParameterTypes().length];
                    while (i < objArr.length) {
                        objArr[i] = hooksInvokerValueSupplier.mo5617a((Class) methodInvoker.f24977b.get(i));
                        i++;
                    }
                    methodInvoker.f24976a.invoke(obj, objArr);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
