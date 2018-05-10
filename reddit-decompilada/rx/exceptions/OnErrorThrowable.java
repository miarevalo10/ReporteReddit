package rx.exceptions;

import java.util.HashSet;
import java.util.Set;
import rx.plugins.RxJavaPlugins;

public final class OnErrorThrowable extends RuntimeException {

    public static class OnNextValue extends RuntimeException {
        final Object f41313a;

        static final class Primitives {
            static final Set<Class<?>> f41312a;

            static {
                Set hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                f41312a = hashSet;
            }
        }

        public OnNextValue(Object obj) {
            String str;
            StringBuilder stringBuilder = new StringBuilder("OnError while emitting onNext value: ");
            if (obj == null) {
                str = "null";
            } else if (Primitives.f41312a.contains(obj.getClass())) {
                str = obj.toString();
            } else if (obj instanceof String) {
                str = (String) obj;
            } else if (obj instanceof Enum) {
                str = ((Enum) obj).name();
            } else {
                RxJavaPlugins.m43511a().m43512b();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(obj.getClass().getName());
                stringBuilder2.append(".class");
                str = stringBuilder2.toString();
            }
            stringBuilder.append(str);
            super(stringBuilder.toString());
            this.f41313a = obj;
        }
    }

    public static Throwable m43437a(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable c = Exceptions.m43436c(th);
        if ((c instanceof OnNextValue) && ((OnNextValue) c).f41313a == obj) {
            return th;
        }
        Exceptions.m43431a(th, new OnNextValue(obj));
        return th;
    }
}
