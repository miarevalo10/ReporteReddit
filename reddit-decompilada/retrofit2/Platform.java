package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter.Factory;

class Platform {
    private static final Platform f41213a = m43307c();

    static class Android extends Platform {

        static class MainThreadExecutor implements Executor {
            private final Handler f41212a = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            public void execute(Runnable runnable) {
                this.f41212a.post(runnable);
            }
        }

        Android() {
        }

        public final Executor mo7890b() {
            return new MainThreadExecutor();
        }

        final Factory mo7889a(Executor executor) {
            if (executor != null) {
                return new ExecutorCallAdapterFactory(executor);
            }
            throw new AssertionError();
        }
    }

    static class Java8 extends Platform {
        Java8() {
        }

        final boolean mo7892a(Method method) {
            return method.isDefault();
        }

        final Object mo7891a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = Lookup.class.getDeclaredConstructor(new Class[]{Class.class, Integer.TYPE});
            declaredConstructor.setAccessible(true);
            return ((Lookup) declaredConstructor.newInstance(new Object[]{cls, Integer.valueOf(-1)})).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    boolean mo7892a(Method method) {
        return false;
    }

    Executor mo7890b() {
        return null;
    }

    Platform() {
    }

    static Platform m43306a() {
        return f41213a;
    }

    private static retrofit2.Platform m43307c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "android.os.Build";	 Catch:{ ClassNotFoundException -> 0x000f }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x000f }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ ClassNotFoundException -> 0x000f }
        if (r0 == 0) goto L_0x000f;	 Catch:{ ClassNotFoundException -> 0x000f }
    L_0x0009:
        r0 = new retrofit2.Platform$Android;	 Catch:{ ClassNotFoundException -> 0x000f }
        r0.<init>();	 Catch:{ ClassNotFoundException -> 0x000f }
        return r0;
    L_0x000f:
        r0 = "java.util.Optional";	 Catch:{ ClassNotFoundException -> 0x001a }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x001a }
        r0 = new retrofit2.Platform$Java8;	 Catch:{ ClassNotFoundException -> 0x001a }
        r0.<init>();	 Catch:{ ClassNotFoundException -> 0x001a }
        return r0;
    L_0x001a:
        r0 = new retrofit2.Platform;
        r0.<init>();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.Platform.c():retrofit2.Platform");
    }

    Factory mo7889a(Executor executor) {
        if (executor != null) {
            return new ExecutorCallAdapterFactory(executor);
        }
        return DefaultCallAdapterFactory.f41578a;
    }

    Object mo7891a(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
