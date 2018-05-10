package com.instabug.library.invocation;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.instabug.library.C0645b;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugState;
import com.instabug.library.core.InitialScreenshotHelper;
import com.instabug.library.core.InitialScreenshotHelper.InitialScreenshotCapturingListener;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.plugin.C0657a;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.invocation.p025a.C0711a;
import com.instabug.library.invocation.p025a.C1372b;
import com.instabug.library.invocation.p025a.C1375d;
import com.instabug.library.invocation.p025a.C1376e;
import com.instabug.library.invocation.p025a.C1377f;
import com.instabug.library.p020c.C0651b;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.ui.promptoptions.PromptOptionsActivity;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Iterator;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: InvocationManager */
public class C1381b implements C0729a {
    private static C1381b f15515e;
    public C0731c f15516a = new C0731c();
    public InstabugInvocationEvent f15517b = InstabugInvocationEvent.SHAKE;
    C0711a f15518c;
    public boolean f15519d = true;
    private Subscription f15520f = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new C13803(this));

    /* compiled from: InvocationManager */
    class C13781 implements InitialScreenshotCapturingListener {
        final /* synthetic */ C1381b f15511a;

        C13781(C1381b c1381b) {
            this.f15511a = c1381b;
        }

        public void onScreenshotCapturedSuccessfully(Uri uri) {
            C1381b.m15432c(uri);
        }

        public void onScreenshotCapturingFailed(Throwable th) {
            C1381b.m15432c(null);
        }
    }

    /* compiled from: InvocationManager */
    class C13803 implements Action1<ActivityLifeCycleEvent> {
        final /* synthetic */ C1381b f15514a;

        C13803(C1381b c1381b) {
            this.f15514a = c1381b;
        }

        public final /* synthetic */ void m15424a(Object obj) {
            switch ((ActivityLifeCycleEvent) obj) {
                case RESUMED:
                    InstabugSDKLogger.m8360v(this, "current activity resumed");
                    this.f15514a.m15433g();
                    return;
                case PAUSED:
                    InstabugSDKLogger.m8360v(this, "current activity paused");
                    this.f15514a.m15439d();
                    break;
                default:
                    break;
            }
        }
    }

    private C1381b() {
    }

    public static void m15428b() {
        InstabugSDKLogger.m8360v(C1381b.class, "initializing invocationManager");
        if (f15515e == null) {
            f15515e = new C1381b();
        } else {
            f15515e.m15433g();
        }
    }

    public static C1381b m15431c() {
        if (f15515e != null) {
            return f15515e;
        }
        throw new IllegalStateException("calling InvocationManager.getInstance() before calling InvocationManager.init()");
    }

    public final void m15438a(InstabugInvocationEvent instabugInvocationEvent) {
        this.f15517b = instabugInvocationEvent;
        if (this.f15518c != null) {
            this.f15518c.mo2597b();
        }
        switch (instabugInvocationEvent) {
            case NONE:
                this.f15518c = null;
                break;
            case SHAKE:
                this.f15518c = new C1376e(Instabug.getApplicationContext(), this);
                ((C1376e) this.f15518c).m15415a(this.f15516a.f9785e);
                break;
            case FLOATING_BUTTON:
                this.f15518c = new C1372b(this);
                break;
            case TWO_FINGER_SWIPE_LEFT:
                this.f15518c = new C1377f(Instabug.getApplicationContext(), this);
                break;
            case SCREENSHOT_GESTURE:
                this.f15518c = new C1375d(this);
                break;
            default:
                break;
        }
        if (this.f15518c != null) {
            this.f15518c.mo2596a();
        }
    }

    private void m15433g() {
        if (Instabug.getState().equals(InstabugState.ENABLED) && this.f15519d) {
            if ((m15441f().size() > 0 ? 1 : null) != null && this.f15518c != null) {
                this.f15518c.mo2596a();
            }
        }
    }

    public final void m15437a(MotionEvent motionEvent) {
        if (Instabug.getState().equals(InstabugState.ENABLED) && !InstabugCore.isForegroundBusy() && (this.f15518c instanceof C1377f)) {
            C1377f c1377f = (C1377f) this.f15518c;
            if (c1377f.f15506a != null) {
                if ((motionEvent.getAction() & 255) == 2) {
                    if (motionEvent.getPointerCount() >= 2) {
                        c1377f.f15507b = true;
                    } else {
                        return;
                    }
                }
                c1377f.f15506a.f1437a.mo367a(motionEvent);
            }
        }
    }

    public final void m15439d() {
        if (this.f15518c != null) {
            this.f15518c.mo2597b();
        }
    }

    public final void m15440e() {
        if (!InstabugCore.isForegroundBusy()) {
            m15435a(this.f15516a.f9782b);
        }
    }

    private void m15425a(int i, Uri uri) {
        while (true) {
            switch (i) {
                case 0:
                    i = m15441f();
                    if (i.size() >= 2) {
                        if (uri == null) {
                            InitialScreenshotHelper.captureScreenshot(new C13781(this));
                            return;
                        } else {
                            C1381b.m15432c(uri);
                            return;
                        }
                    } else if (i.size() == 1) {
                        PluginPromptOption pluginPromptOption = (PluginPromptOption) i.get(0);
                        int invocationMode = pluginPromptOption.getInvocationMode();
                        if (invocationMode != 4) {
                            switch (invocationMode) {
                                case 1:
                                case 2:
                                    if (uri == null) {
                                        m15429b(invocationMode);
                                        return;
                                    }
                                    i = invocationMode;
                                default:
                                    break;
                            }
                        }
                        pluginPromptOption.invoke();
                        return;
                    } else {
                        InstabugSDKLogger.m8361w(C1381b.class, "No plugins prompt options available");
                        return;
                    }
                case 1:
                case 2:
                case 4:
                    PluginPromptOption promptOptionByInvocationMode = PluginPromptOption.getPromptOptionByInvocationMode(i);
                    if (promptOptionByInvocationMode != null) {
                        promptOptionByInvocationMode.invoke(uri);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder("'");
                    stringBuilder.append(i);
                    stringBuilder.append("' invocationMode isn't available");
                    InstabugSDKLogger.m8361w(C1381b.class, stringBuilder.toString());
                    return;
                case 3:
                    C0651b.m8138b();
                    break;
                default:
                    break;
            }
            return;
        }
    }

    public final ArrayList<PluginPromptOption> m15441f() {
        ArrayList<PluginPromptOption> arrayList = new ArrayList();
        Iterator it = C0657a.m8160c().iterator();
        while (it.hasNext()) {
            PluginPromptOption pluginPromptOption = (PluginPromptOption) it.next();
            if (this.f15516a.f9781a[pluginPromptOption.getInvocationMode()]) {
                arrayList.add(pluginPromptOption);
            }
        }
        return arrayList;
    }

    private void m15429b(final int i) {
        InitialScreenshotHelper.captureScreenshot(new InitialScreenshotCapturingListener(this) {
            final /* synthetic */ C1381b f15513b;

            public void onScreenshotCapturedSuccessfully(Uri uri) {
                this.f15513b.m15425a(i, uri);
            }

            public void onScreenshotCapturingFailed(Throwable th) {
                this.f15513b.m15425a(i, null);
            }
        });
    }

    public final void mo2600a(Uri uri) {
        m15425a(this.f15516a.f9782b, uri);
    }

    public final void mo2599a() {
        m15440e();
    }

    private static void m15432c(Uri uri) {
        Context currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(PromptOptionsActivity.m21619a(currentActivity, uri));
        }
    }

    public final void m15435a(int i) {
        Object obj = (C0645b.m8104a().m8113b(Feature.INSTABUG) == State.ENABLED && C0645b.m8104a().m8112a(Feature.INSTABUG)) ? 1 : null;
        if (obj != null) {
            switch (i) {
                case 0:
                case 3:
                case 4:
                    m15425a(i, null);
                    return;
                case 1:
                case 2:
                    m15429b(i);
                    break;
                default:
                    break;
            }
        }
    }
}
