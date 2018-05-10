package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ActiveResources {
    final Handler f3359a = new Handler(Looper.getMainLooper(), new C02711(this));
    public final Map<Key, ResourceWeakReference> f3360b = new HashMap();
    ResourceListener f3361c;
    ReferenceQueue<EngineResource<?>> f3362d;
    volatile boolean f3363e;
    volatile DequeuedResourceCallback f3364f;
    private final boolean f3365g;
    private Thread f3366h;

    class C02711 implements Callback {
        final /* synthetic */ ActiveResources f3354a;

        C02711(ActiveResources activeResources) {
            this.f3354a = activeResources;
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return null;
            }
            this.f3354a.m2883a((ResourceWeakReference) message.obj);
            return true;
        }
    }

    class C02722 implements Runnable {
        final /* synthetic */ ActiveResources f3355a;

        C02722(ActiveResources activeResources) {
            this.f3355a = activeResources;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = 10;
            android.os.Process.setThreadPriority(r0);
            r0 = r4.f3355a;
        L_0x0007:
            r1 = r0.f3363e;
            if (r1 != 0) goto L_0x0028;
        L_0x000b:
            r1 = r0.f3362d;	 Catch:{ InterruptedException -> 0x0020 }
            r1 = r1.remove();	 Catch:{ InterruptedException -> 0x0020 }
            r1 = (com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference) r1;	 Catch:{ InterruptedException -> 0x0020 }
            r2 = r0.f3359a;	 Catch:{ InterruptedException -> 0x0020 }
            r3 = 1;	 Catch:{ InterruptedException -> 0x0020 }
            r1 = r2.obtainMessage(r3, r1);	 Catch:{ InterruptedException -> 0x0020 }
            r1.sendToTarget();	 Catch:{ InterruptedException -> 0x0020 }
            r1 = r0.f3364f;	 Catch:{ InterruptedException -> 0x0020 }
            goto L_0x0007;
        L_0x0020:
            r1 = java.lang.Thread.currentThread();
            r1.interrupt();
            goto L_0x0007;
        L_0x0028:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.ActiveResources.2.run():void");
        }
    }

    interface DequeuedResourceCallback {
    }

    static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final Key f3356a;
        final boolean f3357b;
        Resource<?> f3358c;

        ResourceWeakReference(Key key, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.f3356a = (Key) Preconditions.m3217a((Object) key);
            key = (engineResource.f12427a == null || !z) ? null : (Resource) Preconditions.m3217a(engineResource.f12428b);
            this.f3358c = key;
            this.f3357b = engineResource.f12427a;
        }

        final void m2881a() {
            this.f3358c = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this.f3365g = z;
    }

    public final void m2882a(Key key, EngineResource<?> engineResource) {
        if (this.f3362d == null) {
            this.f3362d = new ReferenceQueue();
            this.f3366h = new Thread(new C02722(this), "glide-active-resources");
            this.f3366h.start();
        }
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.f3360b.put(key, new ResourceWeakReference(key, engineResource, this.f3362d, this.f3365g));
        if (resourceWeakReference != null) {
            resourceWeakReference.m2881a();
        }
    }

    public final void m2883a(ResourceWeakReference resourceWeakReference) {
        Util.m3230a();
        this.f3360b.remove(resourceWeakReference.f3356a);
        if (resourceWeakReference.f3357b) {
            if (resourceWeakReference.f3358c != null) {
                EngineResource engineResource = new EngineResource(resourceWeakReference.f3358c, true, false);
                engineResource.m11338a(resourceWeakReference.f3356a, this.f3361c);
                this.f3361c.mo918a(resourceWeakReference.f3356a, engineResource);
            }
        }
    }
}
