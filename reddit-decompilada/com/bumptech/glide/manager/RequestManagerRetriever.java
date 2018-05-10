package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Callback {
    private static final RequestManagerFactory f3586i = new C10811();
    final Map<FragmentManager, RequestManagerFragment> f3587a = new HashMap();
    final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> f3588b = new HashMap();
    public final ArrayMap<View, Fragment> f3589c = new ArrayMap();
    public final ArrayMap<View, android.app.Fragment> f3590d = new ArrayMap();
    private volatile RequestManager f3591e;
    private final Handler f3592f;
    private final RequestManagerFactory f3593g;
    private final Bundle f3594h = new Bundle();

    public interface RequestManagerFactory {
        RequestManager mo869a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    class C10811 implements RequestManagerFactory {
        C10811() {
        }

        public final RequestManager mo869a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        if (requestManagerFactory == null) {
            requestManagerFactory = f3586i;
        }
        this.f3593g = requestManagerFactory;
        this.f3592f = new Handler(Looper.getMainLooper(), this);
    }

    private RequestManager m3093b(Context context) {
        if (this.f3591e == null) {
            synchronized (this) {
                if (this.f3591e == null) {
                    this.f3591e = this.f3593g.mo869a(Glide.m2775a(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.f3591e;
    }

    public final RequestManager m3096a(Context context) {
        while (context != null) {
            if (Util.m3237c() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    context = (FragmentActivity) context;
                    if (Util.m3239d()) {
                        context = context.getApplicationContext();
                    } else {
                        m3094b((Activity) context);
                        return m3098a(context, context.getSupportFragmentManager(), null);
                    }
                } else if (context instanceof Activity) {
                    return m3095a((Activity) context);
                } else {
                    if (context instanceof ContextWrapper) {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
            }
            return m3093b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final RequestManager m3095a(Activity activity) {
        if (Util.m3239d()) {
            return m3096a(activity.getApplicationContext());
        }
        m3094b(activity);
        return m3097a((Context) activity, activity.getFragmentManager(), null);
    }

    public static void m3092a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment fragment : collection) {
                if (!(fragment == null || fragment.getView() == null)) {
                    map.put(fragment.getView(), fragment);
                    m3092a(fragment.getChildFragmentManager().mo229f(), (Map) map);
                }
            }
        }
    }

    @android.annotation.TargetApi(26)
    public final void m3101a(android.app.FragmentManager r5, android.support.v4.util.ArrayMap<android.view.View, android.app.Fragment> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 26;
        if (r0 < r1) goto L_0x0030;
    L_0x0006:
        r5 = r5.getFragments();
        r5 = r5.iterator();
    L_0x000e:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x002f;
    L_0x0014:
        r0 = r5.next();
        r0 = (android.app.Fragment) r0;
        r1 = r0.getView();
        if (r1 == 0) goto L_0x000e;
    L_0x0020:
        r1 = r0.getView();
        r6.put(r1, r0);
        r0 = r0.getChildFragmentManager();
        r4.m3101a(r0, r6);
        goto L_0x000e;
    L_0x002f:
        return;
    L_0x0030:
        r0 = 0;
    L_0x0031:
        r1 = r4.f3594h;
        r2 = "key";
        r3 = r0 + 1;
        r1.putInt(r2, r0);
        r0 = 0;
        r1 = r4.f3594h;	 Catch:{ Exception -> 0x0044 }
        r2 = "key";	 Catch:{ Exception -> 0x0044 }
        r1 = r5.getFragment(r1, r2);	 Catch:{ Exception -> 0x0044 }
        r0 = r1;
    L_0x0044:
        if (r0 == 0) goto L_0x0062;
    L_0x0046:
        r1 = r0.getView();
        if (r1 == 0) goto L_0x0060;
    L_0x004c:
        r1 = r0.getView();
        r6.put(r1, r0);
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 17;
        if (r1 < r2) goto L_0x0060;
    L_0x0059:
        r0 = r0.getChildFragmentManager();
        r4.m3101a(r0, r6);
    L_0x0060:
        r0 = r3;
        goto L_0x0031;
    L_0x0062:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.RequestManagerRetriever.a(android.app.FragmentManager, android.support.v4.util.ArrayMap):void");
    }

    @TargetApi(17)
    private static void m3094b(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed() != null) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    final RequestManagerFragment m3099a(FragmentManager fragmentManager, android.app.Fragment fragment) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null) {
            requestManagerFragment = (RequestManagerFragment) this.f3587a.get(fragmentManager);
            if (requestManagerFragment == null) {
                requestManagerFragment = new RequestManagerFragment();
                requestManagerFragment.f3583d = fragment;
                if (!(fragment == null || fragment.getActivity() == null)) {
                    requestManagerFragment.m3090a(fragment.getActivity());
                }
                this.f3587a.put(fragmentManager, requestManagerFragment);
                fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
                this.f3592f.obtainMessage(1, fragmentManager).sendToTarget();
            }
        }
        return requestManagerFragment;
    }

    public final RequestManager m3097a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment) {
        fragmentManager = m3099a(fragmentManager, fragment);
        fragment = fragmentManager.f3582c;
        if (fragment != null) {
            return fragment;
        }
        fragment = this.f3593g.mo869a(Glide.m2775a(context), fragmentManager.f3580a, fragmentManager.f3581b, context);
        fragmentManager.f3582c = fragment;
        return fragment;
    }

    final SupportRequestManagerFragment m3100a(android.support.v4.app.FragmentManager fragmentManager, Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.mo218a("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null) {
            supportRequestManagerFragment = (SupportRequestManagerFragment) this.f3588b.get(fragmentManager);
            if (supportRequestManagerFragment == null) {
                supportRequestManagerFragment = new SupportRequestManagerFragment();
                supportRequestManagerFragment.f16744d = fragment;
                if (!(fragment == null || fragment.getActivity() == null)) {
                    supportRequestManagerFragment.m17045a(fragment.getActivity());
                }
                this.f3588b.put(fragmentManager, supportRequestManagerFragment);
                fragmentManager.mo219a().mo197a((Fragment) supportRequestManagerFragment, "com.bumptech.glide.manager").mo205d();
                this.f3592f.obtainMessage(2, fragmentManager).sendToTarget();
            }
        }
        return supportRequestManagerFragment;
    }

    public final RequestManager m3098a(Context context, android.support.v4.app.FragmentManager fragmentManager, Fragment fragment) {
        fragmentManager = m3100a(fragmentManager, fragment);
        fragment = fragmentManager.f16743c;
        if (fragment != null) {
            return fragment;
        }
        fragment = this.f3593g.mo869a(Glide.m2775a(context), fragmentManager.f16741a, fragmentManager.f16742b, context);
        fragmentManager.f16743c = fragment;
        return fragment;
    }

    public boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        switch (message.what) {
            case 1:
                obj = (FragmentManager) message.obj;
                message = this.f3587a.remove(obj);
                break;
            case 2:
                obj = (android.support.v4.app.FragmentManager) message.obj;
                message = this.f3588b.remove(obj);
                break;
            default:
                z = false;
                message = null;
                break;
        }
        if (z && r5 == null && Log.isLoggable("RMRetriever", 5) != null) {
            StringBuilder stringBuilder = new StringBuilder("Failed to remove expected request manager fragment, manager: ");
            stringBuilder.append(obj);
            Log.w("RMRetriever", stringBuilder.toString());
        }
        return z;
    }
}
