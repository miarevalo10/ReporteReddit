package com.instabug.bug;

import android.content.Context;
import android.net.Uri;
import com.instabug.bug.OnSdkDismissedCallback.DismissType;
import com.instabug.bug.cache.C0471a;
import com.instabug.bug.model.Bug;
import com.instabug.bug.model.Bug.BugState;
import com.instabug.bug.model.Bug.C0476a;
import com.instabug.bug.model.Bug.C0476a.C12641;
import com.instabug.bug.model.C0478b;
import com.instabug.bug.model.ReportCategory;
import com.instabug.bug.p001b.C1259a;
import com.instabug.bug.screenshot.viewhierarchy.C0481a;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.view.ReportCategoriesActivity;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.core.InitialScreenshotHelper;
import com.instabug.library.core.InitialScreenshotHelper.InitialScreenshotCapturingListener;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.core.plugin.PluginPromptOption.OnInvocationListener;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.model.State.Builder;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugMemoryUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.visualusersteps.VisualUserStepsHelper;
import java.util.ArrayList;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* compiled from: BugPluginWrapper */
public class C0467a {
    public static void m7729a(Context context) {
        C0485a.m7795a(context);
        C0471a.m7761a(context);
    }

    static Subscription m7725a(Action1<SDKCoreEvent> action1) {
        return SDKCoreEventSubscriber.subscribe(action1);
    }

    static Action1<SDKCoreEvent> m7733b(final Context context) {
        return new Action1<SDKCoreEvent>() {
            public final /* synthetic */ void m15208a(Object obj) {
                C0470c.m7759a(context, (SDKCoreEvent) obj);
            }
        };
    }

    static ArrayList<PluginPromptOption> m7737c(final Context context) {
        ArrayList<PluginPromptOption> arrayList = new ArrayList();
        PluginPromptOption pluginPromptOption = new PluginPromptOption();
        pluginPromptOption.setOrder(2);
        pluginPromptOption.setInvocationMode(1);
        pluginPromptOption.setIcon(C0465R.drawable.instabug_ic_report_bug);
        pluginPromptOption.setTitle(PlaceHolderUtils.getPlaceHolder(Key.REPORT_BUG, LocaleUtils.getLocaleStringResource(Instabug.getLocale(context), C0465R.string.instabug_str_bug_header, context)));
        pluginPromptOption.setOnInvocationListener(new OnInvocationListener() {
            public final void onInvoke(Uri uri) {
                C0467a.m7741d(context, uri);
            }
        });
        arrayList.add(pluginPromptOption);
        pluginPromptOption = new PluginPromptOption();
        pluginPromptOption.setOrder(3);
        pluginPromptOption.setInvocationMode(2);
        pluginPromptOption.setIcon(C0465R.drawable.instabug_ic_send_feedback);
        pluginPromptOption.setTitle(PlaceHolderUtils.getPlaceHolder(Key.REPORT_FEEDBACK, LocaleUtils.getLocaleStringResource(Instabug.getLocale(context), C0465R.string.instabug_str_feedback_header, context)));
        pluginPromptOption.setOnInvocationListener(new OnInvocationListener() {
            public final void onInvoke(Uri uri) {
                C0467a.m7739c(context, uri);
            }
        });
        arrayList.add(pluginPromptOption);
        return arrayList;
    }

    private static void m7727a(final int i) {
        C0485a.m7793a();
        if (C0485a.m7811d().isShouldTakesInitialScreenshot()) {
            InitialScreenshotHelper.captureScreenshot(new InitialScreenshotCapturingListener() {
                public final void onScreenshotCapturedSuccessfully(Uri uri) {
                    C0467a.m7735b(i, uri);
                }

                public final void onScreenshotCapturingFailed(Throwable th) {
                    StringBuilder stringBuilder = new StringBuilder("initial screenshot capturing got error: ");
                    stringBuilder.append(th.getMessage());
                    stringBuilder.append(", time in MS: ");
                    stringBuilder.append(System.currentTimeMillis());
                    InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
                }
            });
        } else {
            C0467a.m7735b(i, null);
        }
    }

    private static void m7735b(int i, Uri uri) {
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null) {
            switch (i) {
                case 2:
                    C0467a.m7741d(bugPlugin.getAppContext(), uri);
                    return;
                case 3:
                    C0467a.m7739c(bugPlugin.getAppContext(), uri);
                    break;
                default:
                    break;
            }
        }
    }

    private static void m7740d() {
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null) {
            bugPlugin.setState(1);
        }
        InstabugSDKLogger.m8356d(C0467a.class, "setPluginStateForeground->change plugin state to FOREGROUND");
    }

    private static void m7739c(Context context, Uri uri) {
        C0467a.m7740d();
        C0467a.m7742e();
        InstabugSDKLogger.m8356d(C0467a.class, "Handle invocation request new feedback");
        C0467a.m7731a(uri);
        C0474d.m7762a().f9100a.m15215a(context.getString(C0465R.string.instabug_str_feedback_header));
        C0467a.m7743f();
        if (ReportCategory.hasSubCategories(C0478b.FEEDBACK) != null) {
            context.startActivity(ReportCategoriesActivity.m21609a(context, C0478b.FEEDBACK));
        } else {
            context.startActivity(C0469b.m7754b(context));
        }
    }

    private static void m7741d(Context context, Uri uri) {
        C0467a.m7740d();
        C0467a.m7742e();
        InstabugSDKLogger.m8356d(C0467a.class, "Handle invocation request new bug");
        C0467a.m7731a(uri);
        C0474d.m7762a().f9100a.m15215a(context.getString(C0465R.string.instabug_str_bug_header));
        C0467a.m7743f();
        if (ReportCategory.hasSubCategories(C0478b.BUG) != null) {
            context.startActivity(ReportCategoriesActivity.m21609a(context, C0478b.BUG));
        } else {
            context.startActivity(C0469b.m7753a(context));
        }
    }

    private static void m7742e() {
        if (InstabugCore.getOnSdkInvokedCallback() != null) {
            InstabugCore.getOnSdkInvokedCallback().onSdkInvoked();
        }
    }

    private static void m7731a(Uri uri) {
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null) {
            C0474d a = C0474d.m7762a();
            Context appContext = bugPlugin.getAppContext();
            if (a.f9100a == null) {
                C0476a c0476a = new C0476a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(System.currentTimeMillis());
                Bug bug = new Bug(stringBuilder.toString(), new Builder(appContext).build(false), BugState.IN_PROGRESS);
                bug.f15317h = InstabugCore.getFeatureState(Feature.VIEW_HIERARCHY) == State.ENABLED;
                if (InstabugCore.getFeatureState(Feature.REPRO_STEPS) == State.ENABLED && InstabugCore.isReproStepsScreenshotEnabled()) {
                    VisualUserStepsHelper.getVisualUserStepsFileObservable(appContext, bug.getId()).b(Schedulers.d()).a(new C12641(c0476a, bug));
                }
                a.f9100a = bug;
                a.f9101b = false;
                a.f9102c = DismissType.CANCEL;
            }
        }
        if (uri != null) {
            C0485a.m7793a();
            if (C0485a.m7811d().isShouldTakesInitialScreenshot()) {
                C0474d.m7762a().f9100a.f15310a = uri.getPath();
            }
        }
        if (C1259a.m15209a().isEnabled() != null) {
            uri = C1259a.m15209a().getAutoScreenRecordingFileUri();
            C1259a.m15209a().clear();
            if (uri != null) {
                Attachment attachment = new Attachment();
                attachment.setName(uri.getLastPathSegment());
                attachment.setLocalPath(uri.getPath());
                attachment.setType(Type.AUTO_SCREEN_RECORDING);
                C0474d.m7762a().f9100a.f15314e.add(attachment);
            }
        }
    }

    private static void m7743f() {
        if (C0474d.m7762a().f9100a != null && C0474d.m7762a().f9100a.f15317h && !InstabugMemoryUtils.isLowMemory()) {
            C0481a.m7781a(InstabugInternalTrackingDelegate.getInstance().getTargetActivity());
        }
    }

    static void m7732a(Subscription subscription) {
        if (subscription != null && !subscription.d()) {
            subscription.c();
        }
    }

    public static void m7726a() {
        C0471a.m7760a();
    }

    private static boolean m7744g() {
        BugPlugin bugPlugin = (BugPlugin) InstabugCore.getXPlugin(BugPlugin.class);
        if (bugPlugin != null && bugPlugin.isAppContextAvailable()) {
            if (InstabugCore.getFeatureState(Feature.INSTABUG) == State.ENABLED) {
                return true;
            }
        }
        return false;
    }

    static void m7734b() {
        if (C0467a.m7744g()) {
            C0467a.m7727a(3);
        }
    }

    static void m7738c() {
        if (C0467a.m7744g()) {
            C0467a.m7727a(2);
        }
    }
}
