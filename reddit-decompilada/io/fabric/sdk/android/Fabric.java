package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Fabric {
    static volatile Fabric f24693a;
    static final Logger f24694b = new DefaultLogger((byte) 0);
    public final ExecutorService f24695c;
    public final Handler f24696d;
    public ActivityLifecycleManager f24697e;
    public WeakReference<Activity> f24698f;
    final Logger f24699g;
    final boolean f24700h;
    private final Context f24701i;
    private final Map<Class<? extends Kit>, Kit> f24702j;
    private final InitializationCallback<Fabric> f24703k;
    private final InitializationCallback<?> f24704l;
    private final IdManager f24705m;
    private AtomicBoolean f24706n = new AtomicBoolean(null);

    public static class Builder {
        private final Context f24684a;
        private Kit[] f24685b;
        private PriorityThreadPoolExecutor f24686c;
        private Handler f24687d;
        private Logger f24688e;
        private boolean f24689f;
        private String f24690g;
        private String f24691h;
        private InitializationCallback<Fabric> f24692i;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f24684a = context;
        }

        public final Builder m26233a(Kit... kitArr) {
            if (this.f24685b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f24685b = kitArr;
            return this;
        }

        public final Fabric m26234a() {
            HashMap hashMap;
            if (this.f24686c == null) {
                this.f24686c = PriorityThreadPoolExecutor.m26386a();
            }
            if (this.f24687d == null) {
                this.f24687d = new Handler(Looper.getMainLooper());
            }
            if (this.f24688e == null) {
                if (this.f24689f) {
                    this.f24688e = new DefaultLogger();
                } else {
                    this.f24688e = new DefaultLogger((byte) 0);
                }
            }
            if (this.f24691h == null) {
                this.f24691h = this.f24684a.getPackageName();
            }
            if (this.f24692i == null) {
                this.f24692i = InitializationCallback.f24710d;
            }
            if (this.f24685b == null) {
                hashMap = new HashMap();
            } else {
                hashMap = Fabric.m26239a(Arrays.asList(this.f24685b));
            }
            HashMap hashMap2 = hashMap;
            Context applicationContext = this.f24684a.getApplicationContext();
            return new Fabric(applicationContext, hashMap2, this.f24686c, this.f24687d, this.f24688e, this.f24689f, this.f24692i, new IdManager(applicationContext, this.f24691h, this.f24690g, hashMap2.values()), Fabric.m26235a(this.f24684a));
        }
    }

    class C25371 extends Callbacks {
        final /* synthetic */ Fabric f30975a;

        C25371(Fabric fabric) {
            this.f30975a = fabric;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            this.f30975a.m26247a(activity);
        }

        public void onActivityStarted(Activity activity) {
            this.f30975a.m26247a(activity);
        }

        public void onActivityResumed(Activity activity) {
            this.f30975a.m26247a(activity);
        }
    }

    public static String m26238a() {
        return "1.4.1.19";
    }

    Fabric(Context context, Map<Class<? extends Kit>, Kit> map, PriorityThreadPoolExecutor priorityThreadPoolExecutor, Handler handler, Logger logger, boolean z, InitializationCallback initializationCallback, IdManager idManager, Activity activity) {
        this.f24701i = context;
        this.f24702j = map;
        this.f24695c = priorityThreadPoolExecutor;
        this.f24696d = handler;
        this.f24699g = logger;
        this.f24700h = z;
        this.f24703k = initializationCallback;
        context = map.size();
        this.f24704l = new InitializationCallback(this) {
            final CountDownLatch f30976a = new CountDownLatch(context);
            final /* synthetic */ Fabric f30978c;

            public final void mo5573a() {
                this.f30976a.countDown();
                if (this.f30976a.getCount() == 0) {
                    this.f30978c.f24706n.set(true);
                    this.f30978c.f24703k.mo5573a();
                }
            }

            public final void mo5574a(Exception exception) {
                this.f30978c.f24703k.mo5574a(exception);
            }
        };
        this.f24705m = idManager;
        m26247a(activity);
    }

    public static Fabric m26236a(Context context, Kit... kitArr) {
        if (f24693a == null) {
            synchronized (Fabric.class) {
                if (f24693a == null) {
                    m26240a(new Builder(context).m26233a(kitArr).m26234a());
                }
            }
        }
        return f24693a;
    }

    public static void m26240a(Fabric fabric) {
        f24693a = fabric;
        fabric.f24697e = new ActivityLifecycleManager(fabric.f24701i);
        fabric.f24697e.m26232a(new C25371(fabric));
        Context context = fabric.f24701i;
        Future submit = fabric.f24695c.submit(new FabricKitsFinder(context.getPackageCodePath()));
        Collection values = fabric.f24702j.values();
        Onboarding onboarding = new Onboarding(submit, values);
        List<Kit> arrayList = new ArrayList(values);
        Collections.sort(arrayList);
        onboarding.injectParameters(context, fabric, InitializationCallback.f24710d, fabric.f24705m);
        for (Kit injectParameters : arrayList) {
            injectParameters.injectParameters(context, fabric, fabric.f24704l, fabric.f24705m);
        }
        onboarding.initialize();
        StringBuilder stringBuilder = m26243b().mo5564a(3) ? new StringBuilder("Initializing io.fabric.sdk.android:fabric [Version: 1.4.1.19], with the following kits:\n") : null;
        for (Kit kit : arrayList) {
            kit.initializationTask.m31963a(onboarding.initializationTask);
            m26241a(fabric.f24702j, kit);
            kit.initialize();
            if (stringBuilder != null) {
                stringBuilder.append(kit.getIdentifier());
                stringBuilder.append(" [Version: ");
                stringBuilder.append(kit.getVersion());
                stringBuilder.append("]\n");
            }
        }
        if (stringBuilder != null) {
            m26243b().mo5562a("Fabric", stringBuilder.toString());
        }
    }

    public final Fabric m26247a(Activity activity) {
        this.f24698f = new WeakReference(activity);
        return this;
    }

    private static void m26241a(Map<Class<? extends Kit>, Kit> map, Kit kit) {
        DependsOn dependsOn = kit.dependsOnAnnotation;
        if (dependsOn != null) {
            for (Class cls : dependsOn.m26383a()) {
                if (cls.isInterface()) {
                    for (Kit kit2 : map.values()) {
                        if (cls.isAssignableFrom(kit2.getClass())) {
                            kit.initializationTask.m31963a(kit2.initializationTask);
                        }
                    }
                } else if (((Kit) map.get(cls)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    kit.initializationTask.m31963a(((Kit) map.get(cls)).initializationTask);
                }
            }
        }
    }

    public static Logger m26243b() {
        if (f24693a == null) {
            return f24694b;
        }
        return f24693a.f24699g;
    }

    public static boolean m26246c() {
        if (f24693a == null) {
            return false;
        }
        return f24693a.f24700h;
    }

    private static void m26242a(Map<Class<? extends Kit>, Kit> map, Collection<? extends Kit> collection) {
        for (Kit kit : collection) {
            map.put(kit.getClass(), kit);
            if (kit instanceof KitGroup) {
                m26242a((Map) map, ((KitGroup) kit).getKits());
            }
        }
    }

    public static <T extends Kit> T m26237a(Class<T> cls) {
        if (f24693a != null) {
            return (Kit) f24693a.f24702j.get(cls);
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    static /* synthetic */ Map m26239a(Collection collection) {
        Map hashMap = new HashMap(collection.size());
        m26242a(hashMap, collection);
        return hashMap;
    }

    static /* synthetic */ Activity m26235a(Context context) {
        return context instanceof Activity ? (Activity) context : null;
    }
}
