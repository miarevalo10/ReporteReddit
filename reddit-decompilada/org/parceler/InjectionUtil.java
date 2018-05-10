package org.parceler;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

public final class InjectionUtil {

    private static abstract class AccessibleElementPrivilegedAction<T, E extends AccessibleObject> implements PrivilegedExceptionAction<T> {
        private final E f27204a;

        public abstract T mo6358a(E e) throws Exception;

        protected AccessibleElementPrivilegedAction(E e) {
            this.f27204a = e;
        }

        public T run() throws Exception {
            boolean isAccessible = this.f27204a.isAccessible();
            this.f27204a.setAccessible(true);
            T a = mo6358a(this.f27204a);
            this.f27204a.setAccessible(isAccessible);
            return a;
        }
    }

    private static final class GetFieldPrivilegedAction<T> extends AccessibleElementPrivilegedAction<T, Field> {
        private final Object f33422a;

        public final /* synthetic */ Object mo6358a(AccessibleObject accessibleObject) throws Exception {
            return ((Field) accessibleObject).get(this.f33422a);
        }

        private GetFieldPrivilegedAction(Field field, Object obj) {
            super(field);
            this.f33422a = obj;
        }
    }

    private static final class SetFieldPrivilegedAction extends AccessibleElementPrivilegedAction<Void, Field> {
        private final Object f33423a;
        private final Object f33424b;

        public final /* synthetic */ Object mo6358a(AccessibleObject accessibleObject) throws Exception {
            ((Field) accessibleObject).set(this.f33423a, this.f33424b);
            return null;
        }

        private SetFieldPrivilegedAction(Field field, Object obj, Object obj2) {
            super(field);
            this.f33423a = obj;
            this.f33424b = obj2;
        }
    }

    public static <T> T m28667a(Class<?> cls, Object obj, String str) {
        try {
            return AccessController.doPrivileged(new GetFieldPrivilegedAction(cls.getDeclaredField(str), obj));
        } catch (Class<?> cls2) {
            StringBuilder stringBuilder = new StringBuilder("NoSuchFieldException Exception during field injection: ");
            stringBuilder.append(str);
            stringBuilder.append(" in ");
            stringBuilder.append(obj.getClass());
            throw new ParcelerRuntimeException(stringBuilder.toString(), cls2);
        } catch (Class<?> cls22) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", cls22);
        } catch (Class<?> cls222) {
            throw new ParcelerRuntimeException("Exception during field injection", cls222);
        }
    }

    public static void m28668a(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            AccessController.doPrivileged(new SetFieldPrivilegedAction(cls.getDeclaredField(str), obj, obj2));
        } catch (Class<?> cls2) {
            StringBuilder stringBuilder = new StringBuilder("NoSuchFieldException Exception during field injection: ");
            stringBuilder.append(str);
            stringBuilder.append(" in ");
            stringBuilder.append(obj.getClass());
            throw new ParcelerRuntimeException(stringBuilder.toString(), cls2);
        } catch (Class<?> cls22) {
            throw new ParcelerRuntimeException("PrivilegedActionException Exception during field injection", cls22);
        } catch (Class<?> cls222) {
            throw new ParcelerRuntimeException("Exception during field injection", cls222);
        }
    }
}
