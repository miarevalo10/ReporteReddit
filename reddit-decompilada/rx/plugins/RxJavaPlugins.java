package rx.plugins;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {
    static final RxJavaErrorHandler f41408a = new C31381();
    private static final RxJavaPlugins f41409b = new RxJavaPlugins();
    private final AtomicReference<RxJavaErrorHandler> f41410c = new AtomicReference();
    private final AtomicReference<RxJavaObservableExecutionHook> f41411d = new AtomicReference();
    private final AtomicReference<RxJavaSingleExecutionHook> f41412e = new AtomicReference();
    private final AtomicReference<RxJavaCompletableExecutionHook> f41413f = new AtomicReference();
    private final AtomicReference<RxJavaSchedulersHook> f41414g = new AtomicReference();

    static class C31381 extends RxJavaErrorHandler {
        C31381() {
        }
    }

    class C31392 extends RxJavaCompletableExecutionHook {
        final /* synthetic */ RxJavaPlugins f41822a;

        C31392(RxJavaPlugins rxJavaPlugins) {
            this.f41822a = rxJavaPlugins;
        }
    }

    @Deprecated
    public static RxJavaPlugins m43511a() {
        return f41409b;
    }

    RxJavaPlugins() {
    }

    public final RxJavaErrorHandler m43512b() {
        if (this.f41410c.get() == null) {
            Object a = m43510a(RxJavaErrorHandler.class, System.getProperties());
            if (a == null) {
                this.f41410c.compareAndSet(null, f41408a);
            } else {
                this.f41410c.compareAndSet(null, (RxJavaErrorHandler) a);
            }
        }
        return (RxJavaErrorHandler) this.f41410c.get();
    }

    public final RxJavaObservableExecutionHook m43513c() {
        if (this.f41411d.get() == null) {
            Object a = m43510a(RxJavaObservableExecutionHook.class, System.getProperties());
            if (a == null) {
                this.f41411d.compareAndSet(null, RxJavaObservableExecutionHookDefault.m43929a());
            } else {
                this.f41411d.compareAndSet(null, (RxJavaObservableExecutionHook) a);
            }
        }
        return (RxJavaObservableExecutionHook) this.f41411d.get();
    }

    public final RxJavaSingleExecutionHook m43514d() {
        if (this.f41412e.get() == null) {
            Object a = m43510a(RxJavaSingleExecutionHook.class, System.getProperties());
            if (a == null) {
                this.f41412e.compareAndSet(null, RxJavaSingleExecutionHookDefault.m43930a());
            } else {
                this.f41412e.compareAndSet(null, (RxJavaSingleExecutionHook) a);
            }
        }
        return (RxJavaSingleExecutionHook) this.f41412e.get();
    }

    public final RxJavaCompletableExecutionHook m43515e() {
        if (this.f41413f.get() == null) {
            Object a = m43510a(RxJavaCompletableExecutionHook.class, System.getProperties());
            if (a == null) {
                this.f41413f.compareAndSet(null, new C31392(this));
            } else {
                this.f41413f.compareAndSet(null, (RxJavaCompletableExecutionHook) a);
            }
        }
        return (RxJavaCompletableExecutionHook) this.f41413f.get();
    }

    private static Object m43510a(Class<?> cls, Properties properties) {
        StringBuilder stringBuilder;
        properties = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String str = "rxjava.plugin.";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(simpleName);
        stringBuilder2.append(".implementation");
        String property = properties.getProperty(stringBuilder2.toString());
        if (property == null) {
            String str2 = ".class";
            String str3 = ".impl";
            for (Entry entry : properties.entrySet()) {
                String obj = entry.getKey().toString();
                if (obj.startsWith(str) && obj.endsWith(str2) && simpleName.equals(entry.getValue().toString())) {
                    property = obj.substring(0, obj.length() - str2.length()).substring(str.length());
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(property);
                    stringBuilder3.append(str3);
                    str = stringBuilder3.toString();
                    property = properties.getProperty(str);
                    if (property == null) {
                        properties = new StringBuilder("Implementing class declaration for ");
                        properties.append(simpleName);
                        properties.append(" missing: ");
                        properties.append(str);
                        throw new IllegalStateException(properties.toString());
                    }
                }
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (Class<?> cls2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation is not an instance of ");
            stringBuilder.append(simpleName);
            stringBuilder.append(": ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls2);
        } catch (Class<?> cls22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation class not found: ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls22);
        } catch (Class<?> cls222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation not able to be instantiated: ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls222);
        } catch (Class<?> cls2222) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(simpleName);
            stringBuilder.append(" implementation not able to be accessed: ");
            stringBuilder.append(property);
            throw new IllegalStateException(stringBuilder.toString(), cls2222);
        }
    }

    public final RxJavaSchedulersHook m43516f() {
        if (this.f41414g.get() == null) {
            Object a = m43510a(RxJavaSchedulersHook.class, System.getProperties());
            if (a == null) {
                this.f41414g.compareAndSet(null, RxJavaSchedulersHook.m43524g());
            } else {
                this.f41414g.compareAndSet(null, (RxJavaSchedulersHook) a);
            }
        }
        return (RxJavaSchedulersHook) this.f41414g.get();
    }
}
