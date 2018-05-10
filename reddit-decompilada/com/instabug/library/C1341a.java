package com.instabug.library;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.instabug.library.C0645b.C06392;
import com.instabug.library.InstabugCustomTextPlaceHolder.Key;
import com.instabug.library.broadcast.C0648a;
import com.instabug.library.broadcast.C0648a.C0647a;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.core.plugin.C0657a;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.OnDiskCache;
import com.instabug.library.internal.storage.cache.SessionsCacheManager;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.internal.storage.cache.p024a.C0683a;
import com.instabug.library.internal.storage.cache.p024a.C0684b;
import com.instabug.library.internal.video.AutoScreenRecordingService.Action;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.migration.C0736c;
import com.instabug.library.model.C1388b;
import com.instabug.library.model.Session;
import com.instabug.library.model.Session.SessionState;
import com.instabug.library.network.worker.fetcher.InstabugFeaturesFetcherService;
import com.instabug.library.network.worker.uploader.InstabugSessionUploaderService;
import com.instabug.library.p015a.C0598a;
import com.instabug.library.p019b.C0641a;
import com.instabug.library.p019b.C0644b;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.user.C0770a;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;
import com.instabug.library.util.PlaceHolderUtils;
import java.lang.ref.WeakReference;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: InstabugDelegate */
class C1341a implements C0647a {
    Subscription f15438a;
    Dialog f15439b;
    final C0648a f15440c = new C0648a(this);
    private WeakReference<Context> f15441d;

    /* compiled from: InstabugDelegate */
    class C05942 implements Runnable {
        final /* synthetic */ C1341a f9392a;

        C05942(C1341a c1341a) {
            this.f9392a = c1341a;
        }

        public void run() {
            C1341a.m15336c(this.f9392a);
            C1341a.m15337d(this.f9392a);
        }
    }

    /* compiled from: InstabugDelegate */
    class C05953 implements Runnable {
        final /* synthetic */ C1341a f9393a;

        C05953(C1341a c1341a) {
            this.f9393a = c1341a;
        }

        public void run() {
            InstabugSDKLogger.m8356d(this, "Dumping caches");
            UserAttributesCacheManager.saveCacheToDisk();
            if (this.f9393a.f15441d != null) {
                Context context = (Context) this.f9393a.f15441d.get();
                if (context != null) {
                    AssetsCacheManager.cleanUpCache(context);
                }
            }
        }
    }

    /* compiled from: InstabugDelegate */
    class C05964 implements Runnable {
        final /* synthetic */ C1341a f9394a;

        C05964(C1341a c1341a) {
            this.f9394a = c1341a;
        }

        public void run() {
            C0736c.m8303a(this.f9394a.m15342c());
        }
    }

    /* compiled from: InstabugDelegate */
    class C05975 implements Runnable {
        final /* synthetic */ C1341a f9395a;

        C05975(C1341a c1341a) {
            this.f9395a = c1341a;
        }

        public void run() {
            if (SettingsManager.getInstance().isIntroMessageEnabled()) {
                this.f9395a.m15341b();
            }
        }
    }

    /* compiled from: InstabugDelegate */
    class C13401 implements Action1<SessionState> {
        final /* synthetic */ C1341a f15437a;

        C13401(C1341a c1341a) {
            this.f15437a = c1341a;
        }

        public final /* synthetic */ void m15333a(Object obj) {
            if (((SessionState) obj).equals(SessionState.FINISH) != null) {
                new Thread(new C05953(this.f15437a)).start();
            }
            C1341a.m15335b(this.f15437a);
        }
    }

    public C1341a(Context context) {
        this.f15441d = new WeakReference(context);
        C0657a.m8158a(context);
        new Thread(new C06392(C0645b.m8104a(), context)).start();
        new Thread(new C05942(this)).start();
    }

    public final void mo2567a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("SDK Invoked: ");
        stringBuilder.append(z);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        if (!(Instabug.getState() == InstabugState.TAKING_SCREENSHOT || Instabug.getState() == InstabugState.RECORDING_VIDEO || Instabug.getState() == InstabugState.TAKING_SCREENSHOT_FOR_CHAT || Instabug.getState() == InstabugState.RECORDING_VIDEO_FOR_CHAT || Instabug.getState() == InstabugState.IMPORTING_IMAGE_FROM_GALLERY_FOR_CHAT)) {
            if (z) {
                Instabug.setState(InstabugState.INVOKED);
                z = Action.STOP_TRIM_KEEP;
                if (SettingsManager.getInstance().autoScreenRecordingEnabled()) {
                    stringBuilder = new StringBuilder("Sending auto event: ");
                    stringBuilder.append(z.toString());
                    InstabugSDKLogger.m8359i(this, stringBuilder.toString());
                    AutoScreenRecordingEventBus.getInstance().post(z);
                }
                return;
            }
            z = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
            if (z) {
                OrientationUtils.unlockOrientation(z);
            }
            if (C0645b.m8104a().m8112a(Feature.INSTABUG)) {
                Instabug.setState(InstabugState.ENABLED);
                return;
            }
            Instabug.setState(InstabugState.DISABLED);
        }
    }

    final void m15339a() {
        if (C0645b.m8104a().m8112a(Feature.INSTABUG)) {
            this.f15438a = SessionStateEventBus.getInstance().subscribe(new C13401(this));
            InstabugSDKLogger.m8356d(this, "Initializing the exception handler");
            Thread.setDefaultUncaughtExceptionHandler(new C0598a());
            InstabugSDKLogger.m8356d(this, "Starting Instabug SDK functionality");
            Instabug.setState(InstabugState.ENABLED);
            InstabugSDKLogger.m8360v(this, "show intro dialog if valid");
            StringBuilder stringBuilder = new StringBuilder("Checking if should show intro dialog, firstRun ");
            stringBuilder.append(SettingsManager.getInstance().isFirstRun());
            stringBuilder.append(", SettingsManager.getInstance().isIntroMessageEnabled() ");
            stringBuilder.append(SettingsManager.getInstance().isIntroMessageEnabled());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            if (SettingsManager.getInstance().isFirstRun()) {
                InstabugSDKLogger.m8360v(this, "Showing Intro Message");
                new Handler().postDelayed(new C05975(this), 10000);
            }
            InstabugSDKLogger.m8360v(this, "Initializing Session manager");
            C0662e.m8167a(SettingsManager.getInstance());
            InstabugSDKLogger.m8360v(this, "Initializing Internal tracking delegate");
            InstabugInternalTrackingDelegate.getInstance();
            InstabugSDKLogger.m8360v(this, "Initializing surveys manager");
            InstabugSDKLogger.m8360v(this, "Initializing database manager");
            C0683a.m8191a(new C0684b(m15342c()));
            InstabugSDKLogger.m8360v(this, "run valid migration");
            new Thread(new C05964(this)).start();
            InstabugSDKLogger.m8360v(this, "Registering broadcasts");
            LocalBroadcastManager.m744a(m15342c()).m747a(this.f15440c, new IntentFilter("SDK invoked"));
            InstabugSDKLogger.m8360v(this, "Preparing user state");
            C0770a.m8350e();
            InstabugSDKLogger.m8360v(this, "Initializing auto screen recording");
            InternalAutoScreenRecorderHelper.getInstance().start();
            this.f15439b = null;
        } else {
            Instabug.setState(InstabugState.DISABLED);
        }
        InstabugSDKLogger.m8360v(this, "Initializing invocation manager");
        InstabugSDKLogger.m8360v(this, "initialize Instabug InvocationMode Manager");
        C1381b.m15428b();
    }

    public final void m15341b() {
        if (Instabug.isEnabled()) {
            Context targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
            if (!(targetActivity == null || targetActivity.isFinishing())) {
                InstabugInvocationEvent instabugInvocationEvent = C1381b.m15431c().f15517b;
                Resources resources = targetActivity.getResources();
                AssetManager assets = resources.getAssets();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.locale = Instabug.getLocale(targetActivity);
                resources = new Resources(assets, displayMetrics, configuration);
                if (instabugInvocationEvent == InstabugInvocationEvent.SHAKE) {
                    this.f15439b = new C0641a(targetActivity, PlaceHolderUtils.getPlaceHolder(Key.SHAKE_HINT, resources.getString(C0593R.string.instabug_str_shake_hint)));
                } else if (instabugInvocationEvent == InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT) {
                    this.f15439b = new C0644b(targetActivity, PlaceHolderUtils.getPlaceHolder(Key.SWIPE_HINT, resources.getString(C0593R.string.instabug_str_swipe_hint)));
                }
                if (this.f15439b != null) {
                    this.f15439b.setCanceledOnTouchOutside(true);
                    this.f15439b.show();
                }
            }
            return;
        }
        Log.e("Instabug", "Cannot show intro message while SDK is Disabled");
    }

    public final Context m15342c() {
        if (this.f15441d.get() == null) {
            InstabugSDKLogger.m8357e(this, "Application context instance equal null");
        }
        return (Context) this.f15441d.get();
    }

    static /* synthetic */ void m15335b(C1341a c1341a) {
        if (c1341a.f15441d != null) {
            Context context = (Context) c1341a.f15441d.get();
            if (context != null) {
                context.startService(new Intent(context, InstabugFeaturesFetcherService.class));
                context.startService(new Intent(context, InstabugSessionUploaderService.class));
            }
        }
    }

    static /* synthetic */ void m15336c(C1341a c1341a) {
        InstabugSDKLogger.m8360v(c1341a, "Creating sessions disk cache");
        CacheManager.getInstance().addCache(new OnDiskCache(c1341a.m15342c(), SessionsCacheManager.SESSIONS_DISK_CACHE_KEY, SessionsCacheManager.SESSIONS_DISK_CACHE_FILE_NAME, Session.class));
    }

    static /* synthetic */ void m15337d(C1341a c1341a) {
        InstabugSDKLogger.m8360v(c1341a, "Creating UserAttributes disk cache");
        CacheManager.getInstance().addCache(new OnDiskCache(c1341a.m15342c(), UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_KEY, UserAttributesCacheManager.USER_ATTRIBUTES_DISK_CACHE_FILE_NAME, C1388b.class));
    }
}
