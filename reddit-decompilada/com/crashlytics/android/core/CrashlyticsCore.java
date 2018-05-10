package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.FirebaseInfo;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.network.PinningInfoProvider;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;

@DependsOn(a = {CrashEventDataProvider.class})
public class CrashlyticsCore extends Kit<Void> {
    static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.";
    private static final String PREFERENCE_STORE_NAME = "com.crashlytics.android.core.CrashlyticsCore";
    public static final String TAG = "CrashlyticsCore";
    private final ConcurrentHashMap<String, String> attributes;
    private CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsController controller;
    private CrashlyticsFileMarker crashMarker;
    private float delay;
    private boolean disabled;
    private CrashEventDataProvider externalCrashEventDataProvider;
    private HttpRequestFactory httpRequestFactory;
    private CrashlyticsFileMarker initializationMarker;
    private CrashlyticsListener listener;
    private final PinningInfoProvider pinningInfo;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;

    class C03192 implements Callable<Void> {
        C03192() {
        }

        public Void call() throws Exception {
            CrashlyticsCore.this.initializationMarker.create();
            Fabric.b().a(CrashlyticsCore.TAG, "Initialization marker file created.");
            return null;
        }
    }

    class C03203 implements Callable<Boolean> {
        C03203() {
        }

        public Boolean call() throws Exception {
            try {
                boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                Logger b = Fabric.b();
                String str = CrashlyticsCore.TAG;
                StringBuilder stringBuilder = new StringBuilder("Initialization marker file removed: ");
                stringBuilder.append(remove);
                b.a(str, stringBuilder.toString());
                return Boolean.valueOf(remove);
            } catch (Throwable e) {
                Fabric.b().c(CrashlyticsCore.TAG, "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    class C03214 implements Callable<Boolean> {
        C03214() {
        }

        public Boolean call() throws Exception {
            return Boolean.valueOf(CrashlyticsCore.this.initializationMarker.isPresent());
        }
    }

    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public Builder delay(float f) {
            if (f <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            } else if (this.delay > 0.0f) {
                throw new IllegalStateException("delay already set.");
            } else {
                this.delay = f;
                return this;
            }
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            } else if (this.listener != null) {
                throw new IllegalStateException("listener already set.");
            } else {
                this.listener = crashlyticsListener;
                return this;
            }
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider) {
            if (pinningInfoProvider == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            } else if (this.pinningInfoProvider != null) {
                throw new IllegalStateException("pinningInfoProvider already set.");
            } else {
                this.pinningInfoProvider = pinningInfoProvider;
                return this;
            }
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = CrashlyticsCore.CLS_DEFAULT_PROCESS_DELAY;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }
    }

    private static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        public final Boolean call() throws Exception {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            Fabric.b().a(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    private static final class NoOpListener implements CrashlyticsListener {
        public final void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }

        private NoOpListener() {
        }
    }

    class C17061 extends PriorityCallable<Void> {
        C17061() {
        }

        public Void call() throws Exception {
            return CrashlyticsCore.this.doInBackground();
        }

        public Priority getPriority() {
            return Priority.d;
        }
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String getVersion() {
        return "2.4.1.19";
    }

    public CrashlyticsCore() {
        this(CLS_DEFAULT_PROCESS_DELAY, null, null, false);
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f, crashlyticsListener, pinningInfoProvider, z, ExecutorUtils.a("Crashlytics Exception Handler"));
    }

    CrashlyticsCore(float f, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f;
        if (crashlyticsListener == null) {
            crashlyticsListener = new NoOpListener();
        }
        this.listener = crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.attributes = new ConcurrentHashMap();
        this.startTime = System.currentTimeMillis();
    }

    protected boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    boolean onPreExecute(Context context) {
        Context context2 = context;
        if (this.disabled) {
            return false;
        }
        ApiKey apiKey = new ApiKey();
        String a = ApiKey.a(context);
        if (a == null) {
            return false;
        }
        String k = CommonUtils.k(context);
        if (isBuildIdValid(k, CommonUtils.a(context2, CRASHLYTICS_REQUIRE_BUILD_ID, true))) {
            try {
                Logger b = Fabric.b();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("Initializing Crashlytics ");
                stringBuilder.append(getVersion());
                b.c(str, stringBuilder.toString());
                FileStore fileStoreImpl = new FileStoreImpl(r11);
                r11.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, fileStoreImpl);
                r11.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, fileStoreImpl);
                PreferenceManager create = PreferenceManager.create(new PreferenceStoreImpl(getContext(), PREFERENCE_STORE_NAME), r11);
                PinningInfoProvider crashlyticsPinningInfoProvider = r11.pinningInfo != null ? new CrashlyticsPinningInfoProvider(r11.pinningInfo) : null;
                r11.httpRequestFactory = new DefaultHttpRequestFactory(Fabric.b());
                r11.httpRequestFactory.a(crashlyticsPinningInfoProvider);
                IdManager idManager = getIdManager();
                AppData create2 = AppData.create(context2, idManager, a, k);
                UnityVersionProvider manifestUnityVersionProvider = new ManifestUnityVersionProvider(context2, create2.packageName);
                Logger b2 = Fabric.b();
                k = TAG;
                StringBuilder stringBuilder2 = new StringBuilder("Installer package name is: ");
                stringBuilder2.append(create2.installerPackageName);
                b2.a(k, stringBuilder2.toString());
                FirebaseInfo firebaseInfo = new FirebaseInfo();
                CrashlyticsController crashlyticsController = r1;
                CrashlyticsController crashlyticsController2 = new CrashlyticsController(r11, r11.backgroundWorker, r11.httpRequestFactory, idManager, create, fileStoreImpl, create2, manifestUnityVersionProvider, FirebaseInfo.b(context));
                r11.controller = crashlyticsController;
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                r11.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler());
                if (didPreviousInitializationFail && CommonUtils.l(context)) {
                    Fabric.b().a(TAG, "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    finishInitSynchronously();
                    return false;
                }
                Fabric.b().a(TAG, "Exception handling initialization successful");
                return true;
            } catch (Throwable e) {
                Fabric.b().c(TAG, "Crashlytics was not started due to an exception during initialization", e);
                r11.controller = null;
                return false;
            }
        }
        throw new UnmetDependencyException(MISSING_BUILD_ID_MSG);
    }

    protected Void doInBackground() {
        markInitializationStarted();
        SessionEventData externalCrashEventData = getExternalCrashEventData();
        if (externalCrashEventData != null) {
            this.controller.writeExternalCrashEvent(externalCrashEventData);
        }
        this.controller.cleanInvalidTempFiles();
        try {
            SettingsData b = Settings.a().b();
            if (b == null) {
                Fabric.b().d(TAG, "Received null settings, skipping report submission!");
                markInitializationComplete();
                return null;
            } else if (b.d.c) {
                if (!this.controller.finalizeSessions(b.b)) {
                    Fabric.b().a(TAG, "Could not finalize previous sessions.");
                }
                this.controller.submitAllReports(this.delay, b);
                markInitializationComplete();
                return null;
            } else {
                Fabric.b().a(TAG, "Collection of crash reports disabled in Crashlytics settings.");
                markInitializationComplete();
                return null;
            }
        } catch (Throwable e) {
            Fabric.b().c(TAG, "Crashlytics encountered a problem during asynchronous initialization.", e);
        } catch (Throwable th) {
            markInitializationComplete();
        }
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) Fabric.a(CrashlyticsCore.class);
    }

    public PinningInfoProvider getPinningInfoProvider() {
        return !this.disabled ? this.pinningInfo : null;
    }

    public void logException(Throwable th) {
        if (this.disabled || !ensureFabricWithCalled("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            Fabric.b().a(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.controller.writeNonFatalException(Thread.currentThread(), th);
        }
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    private void doLog(int i, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.controller.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i, str, str2));
        }
    }

    public void log(int i, String str, String str2) {
        doLog(i, str, str2);
        Fabric.b().a(i, str, str2, true);
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userId = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userName = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userEmail = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setString(String str, String str2) {
        if (this.disabled || !ensureFabricWithCalled("prior to setting keys.")) {
            return;
        }
        if (str == null) {
            str = getContext();
            if (str == null || CommonUtils.h(str) == null) {
                Fabric.b().c(TAG, "Attempting to set custom attribute with null key, ignoring.", null);
                return;
            }
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        str = sanitizeAttribute(str);
        if (this.attributes.size() < 64 || this.attributes.containsKey(str)) {
            if (str2 == null) {
                str2 = "";
            } else {
                str2 = sanitizeAttribute(str2);
            }
            this.attributes.put(str, str2);
            this.controller.cacheKeyData(this.attributes);
            return;
        }
        Fabric.b().a(TAG, "Exceeded maximum number of custom attributes (64)");
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    public void setDouble(String str, double d) {
        setString(str, Double.toString(d));
    }

    public void setFloat(String str, float f) {
        setString(str, Float.toString(f));
    }

    public void setInt(String str, int i) {
        setString(str, Integer.toString(i));
    }

    public void setLong(String str, long j) {
        setString(str, Long.toString(j));
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (URL url2) {
            Fabric.b().c(TAG, "Could not verify SSL pinning", url2);
            return null;
        }
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        Fabric.b().d(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener == null) {
            throw new IllegalArgumentException("listener must not be null.");
        }
        this.listener = crashlyticsListener;
    }

    Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    CrashlyticsController getController() {
        return this.controller;
    }

    String getUserIdentifier() {
        return getIdManager().a ? this.userId : null;
    }

    String getUserEmail() {
        return getIdManager().a ? this.userEmail : null;
    }

    String getUserName() {
        return getIdManager().a ? this.userName : null;
    }

    private void finishInitSynchronously() {
        Callable c17061 = new C17061();
        for (Task addDependency : getDependencies()) {
            c17061.addDependency(addDependency);
        }
        Future submit = getFabric().c.submit(c17061);
        Fabric.b().a(TAG, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Fabric.b().c(TAG, "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            Fabric.b().c(TAG, "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            Fabric.b().c(TAG, "Crashlytics timed out during initialization.", e22);
        }
    }

    void markInitializationStarted() {
        this.backgroundWorker.submitAndWait(new C03192());
    }

    void markInitializationComplete() {
        this.backgroundWorker.submit(new C03203());
    }

    boolean didPreviousInitializationFail() {
        return ((Boolean) this.backgroundWorker.submitAndWait(new C03214())).booleanValue();
    }

    void setExternalCrashEventDataProvider(CrashEventDataProvider crashEventDataProvider) {
        this.externalCrashEventDataProvider = crashEventDataProvider;
    }

    SessionEventData getExternalCrashEventData() {
        return this.externalCrashEventDataProvider != null ? this.externalCrashEventDataProvider.getCrashEventData() : null;
    }

    boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        url = this.httpRequestFactory.a(HttpMethod.a, url.toString());
        ((HttpsURLConnection) url.getConnection()).setInstanceFollowRedirects(false);
        url.code();
        return true;
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.backgroundWorker.submitAndWait(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Throwable e) {
                Fabric.b().c(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
            }
        }
    }

    void createCrashMarker() {
        this.crashMarker.create();
    }

    private static String formatLogMessage(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CommonUtils.b(i));
        stringBuilder.append(Operation.DIVISION);
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore instance = getInstance();
        if (instance != null) {
            if (instance.controller != null) {
                return true;
            }
        }
        Logger b = Fabric.b();
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("Crashlytics must be initialized by calling Fabric.with(Context) ");
        stringBuilder.append(str);
        b.c(str2, stringBuilder.toString(), null);
        return null;
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        return str.length() > 1024 ? str.substring(0, 1024) : str;
    }

    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            Fabric.b().a(TAG, "Configured not to require a build ID.");
            return true;
        } else if (CommonUtils.d(str) == null) {
            return true;
        } else {
            Log.e(TAG, ".");
            Log.e(TAG, ".     |  | ");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".   \\ |  | /");
            Log.e(TAG, ".    \\    /");
            Log.e(TAG, ".     \\  /");
            Log.e(TAG, ".      \\/");
            Log.e(TAG, ".");
            Log.e(TAG, MISSING_BUILD_ID_MSG);
            Log.e(TAG, ".");
            Log.e(TAG, ".      /\\");
            Log.e(TAG, ".     /  \\");
            Log.e(TAG, ".    /    \\");
            Log.e(TAG, ".   / |  | \\");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".     |  |");
            Log.e(TAG, ".");
            return null;
        }
    }
}
