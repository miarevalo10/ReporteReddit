package com.crashlytics.android.core;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.AppMeasurementEventLogger;
import com.crashlytics.android.answers.EventLogger;
import com.crashlytics.android.core.LogFileManager.DirectoryProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash.FatalException;
import io.fabric.sdk.android.services.common.Crash.LoggedException;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

class CrashlyticsController {
    private static final int ANALYZER_VERSION = 1;
    private static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
    private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    static final String FATAL_SESSION_DIR = "fatal-sessions";
    static final String FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS = "clx";
    static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    static final String FIREBASE_CRASH_TYPE = "fatal";
    private static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    static final String FIREBASE_REALTIME = "_r";
    static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    private static final String[] INITIAL_SESSION_PART_TAGS = new String[]{SESSION_USER_TAG, SESSION_APP_TAG, SESSION_OS_TAG, SESSION_DEVICE_TAG};
    static final String INVALID_CLS_CACHE_DIR = "invalidClsFiles";
    static final Comparator<File> LARGEST_FILE_NAME_FIRST = new C03134();
    static final int MAX_INVALID_SESSIONS = 4;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    static final int MAX_OPEN_SESSIONS = 8;
    static final int MAX_STACK_SIZE = 1024;
    static final String NONFATAL_SESSION_DIR = "nonfatal-sessions";
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final Map<String, String> SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    static final String SESSION_APP_TAG = "SessionApp";
    static final FilenameFilter SESSION_BEGIN_FILE_FILTER = new FileNameContainsFilter(SESSION_BEGIN_TAG) {
        public final boolean accept(File file, String str) {
            return (super.accept(file, str) == null || str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION) == null) ? null : true;
        }
    };
    static final String SESSION_BEGIN_TAG = "BeginSession";
    static final String SESSION_DEVICE_TAG = "SessionDevice";
    static final FileFilter SESSION_DIRECTORY_FILTER = new C03123();
    static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
    static final String SESSION_FATAL_TAG = "SessionCrash";
    static final FilenameFilter SESSION_FILE_FILTER = new C03112();
    private static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final int SESSION_ID_LENGTH = 35;
    static final String SESSION_JSON_SUFFIX = ".json";
    static final String SESSION_NON_FATAL_TAG = "SessionEvent";
    static final String SESSION_OS_TAG = "SessionOS";
    static final String SESSION_USER_TAG = "SessionUser";
    private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
    static final Comparator<File> SMALLEST_FILE_NAME_FIRST = new C03145();
    private final AppData appData;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    private final CrashlyticsCore crashlyticsCore;
    private final DevicePowerStateListener devicePowerStateListener;
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final FileStore fileStore;
    private final EventLogger firebaseAnalytics;
    private final boolean firebaseCrashlyticsEnabled;
    private final HandlingExceptionCheck handlingExceptionCheck;
    private final HttpRequestFactory httpRequestFactory;
    private final IdManager idManager;
    private final LogFileDirectoryProvider logFileDirectoryProvider;
    private final LogFileManager logFileManager;
    private final PreferenceManager preferenceManager;
    private final ReportFilesProvider reportFilesProvider;
    private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
    private final String unityVersion;

    static class C03112 implements FilenameFilter {
        C03112() {
        }

        public final boolean accept(File file, String str) {
            return (str.length() != 39 || str.endsWith(ClsFileOutputStream.SESSION_FILE_EXTENSION) == null) ? null : true;
        }
    }

    static class C03123 implements FileFilter {
        C03123() {
        }

        public final boolean accept(File file) {
            return (file.isDirectory() && file.getName().length() == 35) ? true : null;
        }
    }

    static class C03134 implements Comparator<File> {
        C03134() {
        }

        public final int compare(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    static class C03145 implements Comparator<File> {
        C03145() {
        }

        public final int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    private static class AnySessionPartFileFilter implements FilenameFilter {
        private AnySessionPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            return (CrashlyticsController.SESSION_FILE_FILTER.accept(file, str) != null || CrashlyticsController.SESSION_FILE_PATTERN.matcher(str).matches() == null) ? null : true;
        }
    }

    private interface CodedOutputStreamWriteAction {
        void writeTo(CodedOutputStream codedOutputStream) throws Exception;
    }

    static class FileNameContainsFilter implements FilenameFilter {
        private final String string;

        public FileNameContainsFilter(String str) {
            this.string = str;
        }

        public boolean accept(File file, String str) {
            return (str.contains(this.string) == null || str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION) != null) ? null : true;
        }
    }

    private interface FileOutputStreamWriteAction {
        void writeTo(FileOutputStream fileOutputStream) throws Exception;
    }

    static class InvalidPartFileFilter implements FilenameFilter {
        InvalidPartFileFilter() {
        }

        public boolean accept(File file, String str) {
            if (ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(file, str) == null) {
                if (str.contains(CrashlyticsController.SESSION_EVENT_MISSING_BINARY_IMGS_TAG) == null) {
                    return null;
                }
            }
            return true;
        }
    }

    private static final class SendReportRunnable implements Runnable {
        private final Context context;
        private final Report report;
        private final ReportUploader reportUploader;

        public SendReportRunnable(Context context, Report report, ReportUploader reportUploader) {
            this.context = context;
            this.report = report;
            this.reportUploader = reportUploader;
        }

        public final void run() {
            if (CommonUtils.l(this.context)) {
                Fabric.b().a(CrashlyticsCore.TAG, "Attempting to send crash report at time of crash...");
                this.reportUploader.forceUpload(this.report);
            }
        }
    }

    static class SessionPartFileFilter implements FilenameFilter {
        private final String sessionId;

        public SessionPartFileFilter(String str) {
            this.sessionId = str;
        }

        public boolean accept(File file, String str) {
            file = new StringBuilder();
            file.append(this.sessionId);
            file.append(ClsFileOutputStream.SESSION_FILE_EXTENSION);
            if (str.equals(file.toString()) == null && str.contains(this.sessionId) != null && str.endsWith(ClsFileOutputStream.IN_PROGRESS_SESSION_FILE_EXTENSION) == null) {
                return true;
            }
            return false;
        }
    }

    class C10906 implements CrashListener {
        C10906() {
        }

        public void onUncaughtException(Thread thread, Throwable th) {
            CrashlyticsController.this.handleUncaughtException(thread, th);
        }
    }

    private static final class LogFileDirectoryProvider implements DirectoryProvider {
        private static final String LOG_FILES_DIR = "log-files";
        private final FileStore rootFileStore;

        public LogFileDirectoryProvider(FileStore fileStore) {
            this.rootFileStore = fileStore;
        }

        public final File getLogFileDir() {
            File file = new File(this.rootFileStore.a(), LOG_FILES_DIR);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
    }

    private static final class PrivacyDialogCheck implements SendCheck {
        private final Kit kit;
        private final PreferenceManager preferenceManager;
        private final PromptSettingsData promptData;

        class C10911 implements AlwaysSendCallback {
            C10911() {
            }

            public void sendUserReportsWithoutPrompting(boolean z) {
                PrivacyDialogCheck.this.preferenceManager.setShouldAlwaysSendReports(z);
            }
        }

        public PrivacyDialogCheck(Kit kit, PreferenceManager preferenceManager, PromptSettingsData promptSettingsData) {
            this.kit = kit;
            this.preferenceManager = preferenceManager;
            this.promptData = promptSettingsData;
        }

        public final boolean canSendReports() {
            Fabric fabric = this.kit.getFabric();
            Activity activity = fabric.f != null ? (Activity) fabric.f.get() : null;
            if (activity != null) {
                if (!activity.isFinishing()) {
                    final CrashPromptDialog create = CrashPromptDialog.create(activity, this.promptData, new C10911());
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            create.show();
                        }
                    });
                    Fabric.b().a(CrashlyticsCore.TAG, "Waiting for user opt-in.");
                    create.await();
                    return create.getOptIn();
                }
            }
            return true;
        }
    }

    private final class ReportUploaderFilesProvider implements ReportFilesProvider {
        private ReportUploaderFilesProvider() {
        }

        public final File[] getCompleteSessionFiles() {
            return CrashlyticsController.this.listCompleteSessionFiles();
        }

        public final File[] getInvalidSessionFiles() {
            return CrashlyticsController.this.getInvalidFilesDir().listFiles();
        }
    }

    private final class ReportUploaderHandlingExceptionCheck implements HandlingExceptionCheck {
        private ReportUploaderHandlingExceptionCheck() {
        }

        public final boolean isHandlingException() {
            return CrashlyticsController.this.isHandlingException();
        }
    }

    CrashlyticsController(CrashlyticsCore crashlyticsCore, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, HttpRequestFactory httpRequestFactory, IdManager idManager, PreferenceManager preferenceManager, FileStore fileStore, AppData appData, UnityVersionProvider unityVersionProvider, boolean z) {
        this.crashlyticsCore = crashlyticsCore;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.httpRequestFactory = httpRequestFactory;
        this.idManager = idManager;
        this.preferenceManager = preferenceManager;
        this.fileStore = fileStore;
        this.appData = appData;
        this.unityVersion = unityVersionProvider.getUnityVersion();
        this.firebaseCrashlyticsEnabled = z;
        crashlyticsCore = crashlyticsCore.getContext();
        this.logFileDirectoryProvider = new LogFileDirectoryProvider(fileStore);
        this.logFileManager = new LogFileManager(crashlyticsCore, this.logFileDirectoryProvider);
        this.reportFilesProvider = new ReportUploaderFilesProvider();
        this.handlingExceptionCheck = new ReportUploaderHandlingExceptionCheck();
        this.devicePowerStateListener = new DevicePowerStateListener(crashlyticsCore);
        this.stackTraceTrimmingStrategy = new MiddleOutFallbackStrategy(1024, new StackTraceTrimmingStrategy[]{new RemoveRepeatsStrategy(10)});
        this.firebaseAnalytics = AppMeasurementEventLogger.getEventLogger(crashlyticsCore);
    }

    void enableExceptionHandling(UncaughtExceptionHandler uncaughtExceptionHandler) {
        openSession();
        this.crashHandler = new CrashlyticsUncaughtExceptionHandler(new C10906(), uncaughtExceptionHandler);
        Thread.setDefaultUncaughtExceptionHandler(this.crashHandler);
    }

    synchronized void handleUncaughtException(final Thread thread, final Throwable th) {
        Logger b = Fabric.b();
        String str = CrashlyticsCore.TAG;
        StringBuilder stringBuilder = new StringBuilder("Crashlytics is handling uncaught exception \"");
        stringBuilder.append(th);
        stringBuilder.append("\" from thread ");
        stringBuilder.append(thread.getName());
        b.a(str, stringBuilder.toString());
        this.devicePowerStateListener.dispose();
        final Date date = new Date();
        this.backgroundWorker.submitAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                CrashlyticsController.this.crashlyticsCore.createCrashMarker();
                CrashlyticsController.this.writeFatal(date, thread, th);
                SettingsData b = Settings.a().b();
                SessionSettingsData sessionSettingsData = b != null ? b.b : null;
                CrashlyticsController.this.doCloseSessions(sessionSettingsData);
                CrashlyticsController.this.doOpenSession();
                if (sessionSettingsData != null) {
                    CrashlyticsController.this.trimSessionFiles(sessionSettingsData.g);
                }
                if (!CrashlyticsController.this.shouldPromptUserBeforeSendingCrashReports(b)) {
                    CrashlyticsController.this.sendSessionReports(b);
                }
                return null;
            }
        });
    }

    void submitAllReports(float f, SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.b().d(CrashlyticsCore.TAG, "Could not send reports. Settings are not available.");
            return;
        }
        new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(settingsData.a.d), this.reportFilesProvider, this.handlingExceptionCheck).uploadReports(f, shouldPromptUserBeforeSendingCrashReports(settingsData) ? new PrivacyDialogCheck(this.crashlyticsCore, this.preferenceManager, settingsData.c) : new AlwaysSendCheck());
    }

    void writeToLog(final long j, final String str) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                if (!CrashlyticsController.this.isHandlingException()) {
                    CrashlyticsController.this.logFileManager.writeToLog(j, str);
                }
                return null;
            }
        });
    }

    void writeNonFatalException(final Thread thread, final Throwable th) {
        final Date date = new Date();
        this.backgroundWorker.submit(new Runnable() {
            public void run() {
                if (!CrashlyticsController.this.isHandlingException()) {
                    CrashlyticsController.this.doWriteNonFatal(date, thread, th);
                }
            }
        });
    }

    void cacheUserData(final String str, final String str2, final String str3) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(CrashlyticsController.this.getCurrentSessionId(), new UserMetaData(str, str2, str3));
                return null;
            }
        });
    }

    void cacheKeyData(final Map<String, String> map) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(CrashlyticsController.this.getCurrentSessionId(), map);
                return null;
            }
        });
    }

    void openSession() {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                CrashlyticsController.this.doOpenSession();
                return null;
            }
        });
    }

    private String getCurrentSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        return listSortedSessionBeginFiles.length > 0 ? getSessionIdFromSessionFile(listSortedSessionBeginFiles[0]) : null;
    }

    private String getPreviousSessionId() {
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        return listSortedSessionBeginFiles.length > 1 ? getSessionIdFromSessionFile(listSortedSessionBeginFiles[1]) : null;
    }

    static String getSessionIdFromSessionFile(File file) {
        return file.getName().substring(0, 35);
    }

    boolean hasOpenSession() {
        return listSessionBeginFiles().length > 0;
    }

    boolean finalizeSessions(final SessionSettingsData sessionSettingsData) {
        return ((Boolean) this.backgroundWorker.submitAndWait(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                if (CrashlyticsController.this.isHandlingException()) {
                    Fabric.b().a(CrashlyticsCore.TAG, "Skipping session finalization because a crash has already occurred.");
                    return Boolean.FALSE;
                }
                Fabric.b().a(CrashlyticsCore.TAG, "Finalizing previously open sessions.");
                CrashlyticsController.this.doCloseSessions(sessionSettingsData, true);
                Fabric.b().a(CrashlyticsCore.TAG, "Closed all previously open sessions");
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    private void doOpenSession() throws Exception {
        Date date = new Date();
        String clsuuid = new CLSUUID(this.idManager).toString();
        Logger b = Fabric.b();
        String str = CrashlyticsCore.TAG;
        StringBuilder stringBuilder = new StringBuilder("Opening a new session with ID ");
        stringBuilder.append(clsuuid);
        b.a(str, stringBuilder.toString());
        writeBeginSession(clsuuid, date);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
    }

    void doCloseSessions(SessionSettingsData sessionSettingsData) throws Exception {
        doCloseSessions(sessionSettingsData, false);
    }

    private void doCloseSessions(SessionSettingsData sessionSettingsData, boolean z) throws Exception {
        trimOpenSessions(8 + z);
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        if (listSortedSessionBeginFiles.length <= z) {
            Fabric.b().a(CrashlyticsCore.TAG, "No open sessions to be closed.");
            return;
        }
        writeSessionUser(getSessionIdFromSessionFile(listSortedSessionBeginFiles[z]));
        if (sessionSettingsData == null) {
            Fabric.b().a(CrashlyticsCore.TAG, "Unable to close session. Settings are not loaded.");
        } else {
            closeOpenSessions(listSortedSessionBeginFiles, z, sessionSettingsData.c);
        }
    }

    private void closeOpenSessions(File[] fileArr, int i, int i2) {
        Fabric.b().a(CrashlyticsCore.TAG, "Closing open sessions.");
        while (i < fileArr.length) {
            File file = fileArr[i];
            String sessionIdFromSessionFile = getSessionIdFromSessionFile(file);
            Logger b = Fabric.b();
            String str = CrashlyticsCore.TAG;
            StringBuilder stringBuilder = new StringBuilder("Closing session: ");
            stringBuilder.append(sessionIdFromSessionFile);
            b.a(str, stringBuilder.toString());
            writeSessionPartsToSessionFile(file, sessionIdFromSessionFile, i2);
            i++;
        }
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsFileOutputStream) {
        if (clsFileOutputStream != null) {
            try {
                clsFileOutputStream.closeInProgressStream();
            } catch (ClsFileOutputStream clsFileOutputStream2) {
                Fabric.b().c(CrashlyticsCore.TAG, "Error closing session file stream in the presence of an exception", clsFileOutputStream2);
            }
        }
    }

    private void recursiveDelete(Set<File> set) {
        for (File recursiveDelete : set) {
            recursiveDelete(recursiveDelete);
        }
    }

    private void recursiveDelete(File file) {
        if (file.isDirectory()) {
            for (File recursiveDelete : file.listFiles()) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }

    private void deleteSessionPartFilesFor(String str) {
        for (File delete : listSessionPartFilesFor(str)) {
            delete.delete();
        }
    }

    private File[] listSessionPartFilesFor(String str) {
        return listFilesMatching(new SessionPartFileFilter(str));
    }

    File[] listCompleteSessionFiles() {
        List linkedList = new LinkedList();
        Collections.addAll(linkedList, listFilesMatching(getFatalSessionFilesDir(), SESSION_FILE_FILTER));
        Collections.addAll(linkedList, listFilesMatching(getNonFatalSessionFilesDir(), SESSION_FILE_FILTER));
        Collections.addAll(linkedList, listFilesMatching(getFilesDir(), SESSION_FILE_FILTER));
        return (File[]) linkedList.toArray(new File[linkedList.size()]);
    }

    File[] listSessionBeginFiles() {
        return listFilesMatching(SESSION_BEGIN_FILE_FILTER);
    }

    private File[] listSortedSessionBeginFiles() {
        File[] listSessionBeginFiles = listSessionBeginFiles();
        Arrays.sort(listSessionBeginFiles, LARGEST_FILE_NAME_FIRST);
        return listSessionBeginFiles;
    }

    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private File[] listFiles(File file) {
        return ensureFileArrayNotNull(file.listFiles());
    }

    private File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[null] : fileArr;
    }

    private void trimSessionEventFiles(String str, int i) {
        File filesDir = getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(SESSION_NON_FATAL_TAG);
        Utils.capFileCount(filesDir, new FileNameContainsFilter(stringBuilder.toString()), i, SMALLEST_FILE_NAME_FIRST);
    }

    void trimSessionFiles(int i) {
        i -= Utils.capFileCount(getFatalSessionFilesDir(), i, SMALLEST_FILE_NAME_FIRST);
        Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, i - Utils.capFileCount(getNonFatalSessionFilesDir(), i, SMALLEST_FILE_NAME_FIRST), SMALLEST_FILE_NAME_FIRST);
    }

    private void trimOpenSessions(int i) {
        Set hashSet = new HashSet();
        File[] listSortedSessionBeginFiles = listSortedSessionBeginFiles();
        i = Math.min(i, listSortedSessionBeginFiles.length);
        for (int i2 = 0; i2 < i; i2++) {
            hashSet.add(getSessionIdFromSessionFile(listSortedSessionBeginFiles[i2]));
        }
        this.logFileManager.discardOldLogFiles(hashSet);
        retainSessions(listFilesMatching(new AnySessionPartFileFilter()), hashSet);
    }

    private void retainSessions(File[] fileArr, Set<String> set) {
        for (File file : fileArr) {
            String name = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(name);
            Logger b;
            String str;
            StringBuilder stringBuilder;
            if (!matcher.matches()) {
                b = Fabric.b();
                str = CrashlyticsCore.TAG;
                stringBuilder = new StringBuilder("Deleting unknown file: ");
                stringBuilder.append(name);
                b.a(str, stringBuilder.toString());
                file.delete();
            } else if (!set.contains(matcher.group(1))) {
                b = Fabric.b();
                str = CrashlyticsCore.TAG;
                stringBuilder = new StringBuilder("Trimming session file: ");
                stringBuilder.append(name);
                b.a(str, stringBuilder.toString());
                file.delete();
            }
        }
    }

    private File[] getTrimmedNonFatalFiles(String str, File[] fileArr, int i) {
        if (fileArr.length <= i) {
            return fileArr;
        }
        Fabric.b().a(CrashlyticsCore.TAG, String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
        trimSessionEventFiles(str, i);
        i = new StringBuilder();
        i.append(str);
        i.append(SESSION_NON_FATAL_TAG);
        return listFilesMatching(new FileNameContainsFilter(i.toString()));
    }

    void cleanInvalidTempFiles() {
        this.backgroundWorker.submit(new Runnable() {
            public void run() {
                CrashlyticsController.this.doCleanInvalidTempFiles(CrashlyticsController.this.listFilesMatching(new InvalidPartFileFilter()));
            }
        });
    }

    void doCleanInvalidTempFiles(File[] fileArr) {
        int length;
        final Set hashSet = new HashSet();
        int i = 0;
        for (File file : fileArr) {
            Logger b = Fabric.b();
            String str = CrashlyticsCore.TAG;
            StringBuilder stringBuilder = new StringBuilder("Found invalid session part file: ");
            stringBuilder.append(file);
            b.a(str, stringBuilder.toString());
            hashSet.add(getSessionIdFromSessionFile(file));
        }
        if (hashSet.isEmpty() == null) {
            fileArr = getInvalidFilesDir();
            if (!fileArr.exists()) {
                fileArr.mkdir();
            }
            File[] listFilesMatching = listFilesMatching(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    if (str.length() < 35) {
                        return false;
                    }
                    return hashSet.contains(str.substring(0, 35));
                }
            });
            length = listFilesMatching.length;
            while (i < length) {
                File file2 = listFilesMatching[i];
                Logger b2 = Fabric.b();
                String str2 = CrashlyticsCore.TAG;
                StringBuilder stringBuilder2 = new StringBuilder("Moving session file: ");
                stringBuilder2.append(file2);
                b2.a(str2, stringBuilder2.toString());
                if (!file2.renameTo(new File(fileArr, file2.getName()))) {
                    b2 = Fabric.b();
                    str2 = CrashlyticsCore.TAG;
                    stringBuilder2 = new StringBuilder("Could not move session file. Deleting ");
                    stringBuilder2.append(file2);
                    b2.a(str2, stringBuilder2.toString());
                    file2.delete();
                }
                i++;
            }
            trimInvalidSessionFiles();
        }
    }

    private void trimInvalidSessionFiles() {
        File invalidFilesDir = getInvalidFilesDir();
        if (invalidFilesDir.exists()) {
            File[] listFilesMatching = listFilesMatching(invalidFilesDir, new InvalidPartFileFilter());
            Arrays.sort(listFilesMatching, Collections.reverseOrder());
            Set hashSet = new HashSet();
            for (int i = 0; i < listFilesMatching.length && hashSet.size() < 4; i++) {
                hashSet.add(getSessionIdFromSessionFile(listFilesMatching[i]));
            }
            retainSessions(listFiles(invalidFilesDir), hashSet);
        }
    }

    private void writeFatal(Date date, Thread thread, Throwable th) {
        Closeable clsFileOutputStream;
        Flushable flushable = null;
        try {
            String currentSessionId = getCurrentSessionId();
            if (currentSessionId == null) {
                Fabric.b().c(CrashlyticsCore.TAG, "Tried to write a fatal exception while no session was open.", null);
                CommonUtils.a(null, "Failed to flush to session begin file.");
                CommonUtils.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            recordFatalExceptionAnswersEvent(currentSessionId, th.getClass().getName());
            recordFatalFirebaseEvent(date.getTime());
            File filesDir = getFilesDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(currentSessionId);
            stringBuilder.append(SESSION_FATAL_TAG);
            clsFileOutputStream = new ClsFileOutputStream(filesDir, stringBuilder.toString());
            try {
                Flushable newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                try {
                    writeSessionEvent(newInstance, date, thread, th, "crash", true);
                    CommonUtils.a(newInstance, "Failed to flush to session begin file.");
                } catch (Exception e) {
                    date = e;
                    flushable = newInstance;
                    try {
                        Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", date);
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        date = th2;
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                        throw date;
                    }
                } catch (Throwable th3) {
                    date = th3;
                    flushable = newInstance;
                    CommonUtils.a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    throw date;
                }
            } catch (Exception e2) {
                date = e2;
                Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", date);
                CommonUtils.a(flushable, "Failed to flush to session begin file.");
                CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            }
            CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Exception e3) {
            date = e3;
            clsFileOutputStream = null;
            Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the fatal exception logger", date);
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th4) {
            date = th4;
            clsFileOutputStream = null;
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw date;
        }
    }

    void writeExternalCrashEvent(final SessionEventData sessionEventData) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                if (!CrashlyticsController.this.isHandlingException()) {
                    CrashlyticsController.this.doWriteExternalCrashEvent(sessionEventData);
                }
                return null;
            }
        });
    }

    private void doWriteExternalCrashEvent(SessionEventData sessionEventData) throws IOException {
        Closeable clsFileOutputStream;
        Flushable flushable = null;
        try {
            String previousSessionId = getPreviousSessionId();
            if (previousSessionId == null) {
                Fabric.b().c(CrashlyticsCore.TAG, "Tried to write a native crash while no session was open.", null);
                CommonUtils.a(null, "Failed to flush to session begin file.");
                CommonUtils.a(null, "Failed to close fatal exception file output stream.");
                return;
            }
            r4 = new Object[2];
            int i = 0;
            r4[0] = sessionEventData.signal.code;
            r4[1] = sessionEventData.signal.name;
            recordFatalExceptionAnswersEvent(previousSessionId, String.format(Locale.US, "<native-crash [%s (%s)]>", r4));
            if (sessionEventData.binaryImages != null && sessionEventData.binaryImages.length > 0) {
                i = 1;
            }
            String str = i != 0 ? SESSION_FATAL_TAG : SESSION_EVENT_MISSING_BINARY_IMGS_TAG;
            File filesDir = getFilesDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(previousSessionId);
            stringBuilder.append(str);
            clsFileOutputStream = new ClsFileOutputStream(filesDir, stringBuilder.toString());
            try {
                Flushable newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                try {
                    NativeCrashWriter.writeNativeCrash(sessionEventData, new LogFileManager(this.crashlyticsCore.getContext(), this.logFileDirectoryProvider, previousSessionId), new MetaDataStore(getFilesDir()).readKeyData(previousSessionId), newInstance);
                    CommonUtils.a(newInstance, "Failed to flush to session begin file.");
                } catch (Exception e) {
                    sessionEventData = e;
                    flushable = newInstance;
                    try {
                        Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the native crash logger", sessionEventData);
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th) {
                        sessionEventData = th;
                        CommonUtils.a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                        throw sessionEventData;
                    }
                } catch (Throwable th2) {
                    sessionEventData = th2;
                    flushable = newInstance;
                    CommonUtils.a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
                    throw sessionEventData;
                }
            } catch (Exception e2) {
                sessionEventData = e2;
                Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the native crash logger", sessionEventData);
                CommonUtils.a(flushable, "Failed to flush to session begin file.");
                CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            }
            CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Exception e3) {
            sessionEventData = e3;
            clsFileOutputStream = null;
            Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the native crash logger", sessionEventData);
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
        } catch (Throwable th3) {
            sessionEventData = th3;
            clsFileOutputStream = null;
            CommonUtils.a(flushable, "Failed to flush to session begin file.");
            CommonUtils.a(clsFileOutputStream, "Failed to close fatal exception file output stream.");
            throw sessionEventData;
        }
    }

    private void doWriteNonFatal(Date date, Thread thread, Throwable th) {
        Closeable clsFileOutputStream;
        String currentSessionId = getCurrentSessionId();
        Flushable flushable = null;
        if (currentSessionId == null) {
            Fabric.b().c(CrashlyticsCore.TAG, "Tried to write a non-fatal exception while no session was open.", null);
            return;
        }
        recordLoggedExceptionAnswersEvent(currentSessionId, th.getClass().getName());
        try {
            Logger b = Fabric.b();
            String str = CrashlyticsCore.TAG;
            StringBuilder stringBuilder = new StringBuilder("Crashlytics is logging non-fatal exception \"");
            stringBuilder.append(th);
            stringBuilder.append("\" from thread ");
            stringBuilder.append(thread.getName());
            b.a(str, stringBuilder.toString());
            String a = CommonUtils.a(this.eventCounter.getAndIncrement());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(currentSessionId);
            stringBuilder2.append(SESSION_NON_FATAL_TAG);
            stringBuilder2.append(a);
            clsFileOutputStream = new ClsFileOutputStream(getFilesDir(), stringBuilder2.toString());
            try {
                Flushable newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                try {
                    writeSessionEvent(newInstance, date, thread, th, EVENT_TYPE_LOGGED, false);
                    CommonUtils.a(newInstance, "Failed to flush to non-fatal file.");
                } catch (Exception e) {
                    date = e;
                    flushable = newInstance;
                    try {
                        Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", date);
                        CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                        CommonUtils.a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                        trimSessionEventFiles(currentSessionId, 64);
                    } catch (Throwable th2) {
                        date = th2;
                        CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                        CommonUtils.a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                        throw date;
                    }
                } catch (Throwable th3) {
                    date = th3;
                    flushable = newInstance;
                    CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                    CommonUtils.a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                    throw date;
                }
            } catch (Exception e2) {
                date = e2;
                Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", date);
                CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
                CommonUtils.a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                trimSessionEventFiles(currentSessionId, 64);
            }
        } catch (Exception e3) {
            date = e3;
            clsFileOutputStream = null;
            Fabric.b().c(CrashlyticsCore.TAG, "An error occurred in the non-fatal exception logger", date);
            CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
            CommonUtils.a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Throwable th4) {
            date = th4;
            clsFileOutputStream = null;
            CommonUtils.a(flushable, "Failed to flush to non-fatal file.");
            CommonUtils.a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            throw date;
        }
        CommonUtils.a(clsFileOutputStream, "Failed to close non-fatal file output stream.");
        try {
            trimSessionEventFiles(currentSessionId, 64);
        } catch (Date date2) {
            Fabric.b().c(CrashlyticsCore.TAG, "An error occurred when trimming non-fatal files.", date2);
        }
    }

    private void writeSessionPartFile(String str, String str2, CodedOutputStreamWriteAction codedOutputStreamWriteAction) throws Exception {
        Flushable flushable = null;
        Closeable clsFileOutputStream;
        try {
            File filesDir = getFilesDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            clsFileOutputStream = new ClsFileOutputStream(filesDir, stringBuilder.toString());
            try {
                str = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
            } catch (Throwable th) {
                codedOutputStreamWriteAction = th;
                str = new StringBuilder("Failed to flush to session ");
                str.append(str2);
                str.append(" file.");
                CommonUtils.a(flushable, str.toString());
                str = new StringBuilder("Failed to close session ");
                str.append(str2);
                str.append(" file.");
                CommonUtils.a(clsFileOutputStream, str.toString());
                throw codedOutputStreamWriteAction;
            }
            try {
                codedOutputStreamWriteAction.writeTo(str);
                codedOutputStreamWriteAction = new StringBuilder("Failed to flush to session ");
                codedOutputStreamWriteAction.append(str2);
                codedOutputStreamWriteAction.append(" file.");
                CommonUtils.a(str, codedOutputStreamWriteAction.toString());
                str = new StringBuilder("Failed to close session ");
                str.append(str2);
                str.append(" file.");
                CommonUtils.a(clsFileOutputStream, str.toString());
            } catch (Throwable th2) {
                codedOutputStreamWriteAction = th2;
                flushable = str;
                str = new StringBuilder("Failed to flush to session ");
                str.append(str2);
                str.append(" file.");
                CommonUtils.a(flushable, str.toString());
                str = new StringBuilder("Failed to close session ");
                str.append(str2);
                str.append(" file.");
                CommonUtils.a(clsFileOutputStream, str.toString());
                throw codedOutputStreamWriteAction;
            }
        } catch (Throwable th3) {
            codedOutputStreamWriteAction = th3;
            clsFileOutputStream = null;
            str = new StringBuilder("Failed to flush to session ");
            str.append(str2);
            str.append(" file.");
            CommonUtils.a(flushable, str.toString());
            str = new StringBuilder("Failed to close session ");
            str.append(str2);
            str.append(" file.");
            CommonUtils.a(clsFileOutputStream, str.toString());
            throw codedOutputStreamWriteAction;
        }
    }

    private void writeFile(String str, String str2, FileOutputStreamWriteAction fileOutputStreamWriteAction) throws Exception {
        Closeable closeable = null;
        try {
            File filesDir = getFilesDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            Closeable fileOutputStream = new FileOutputStream(new File(filesDir, stringBuilder.toString()));
            try {
                fileOutputStreamWriteAction.writeTo(fileOutputStream);
                str = new StringBuilder("Failed to close ");
                str.append(str2);
                str.append(" file.");
                CommonUtils.a(fileOutputStream, str.toString());
            } catch (Throwable th) {
                str = th;
                closeable = fileOutputStream;
                fileOutputStreamWriteAction = new StringBuilder("Failed to close ");
                fileOutputStreamWriteAction.append(str2);
                fileOutputStreamWriteAction.append(" file.");
                CommonUtils.a(closeable, fileOutputStreamWriteAction.toString());
                throw str;
            }
        } catch (Throwable th2) {
            str = th2;
            fileOutputStreamWriteAction = new StringBuilder("Failed to close ");
            fileOutputStreamWriteAction.append(str2);
            fileOutputStreamWriteAction.append(" file.");
            CommonUtils.a(closeable, fileOutputStreamWriteAction.toString());
            throw str;
        }
    }

    private void writeBeginSession(String str, Date date) throws Exception {
        String format = String.format(Locale.US, GENERATOR_FORMAT, new Object[]{this.crashlyticsCore.getVersion()});
        final String str2 = str;
        final String str3 = format;
        final long time = date.getTime() / 1000;
        writeSessionPartFile(str, SESSION_BEGIN_TAG, new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeBeginSession(codedOutputStream, str2, str3, time);
            }
        });
        writeFile(str, "BeginSession.json", new FileOutputStreamWriteAction() {

            class C03071 extends HashMap<String, Object> {
                C03071() {
                    put("session_id", str2);
                    put("generator", str3);
                    put("started_at_seconds", Long.valueOf(time));
                }
            }

            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new C03071()).toString().getBytes());
            }
        });
    }

    private void writeSessionApp(String str) throws Exception {
        String str2 = this.idManager.b;
        String str3 = this.appData.versionCode;
        String str4 = this.appData.versionName;
        String a = this.idManager.a();
        final String str5 = str2;
        final String str6 = str3;
        final String str7 = str4;
        final String str8 = a;
        final int i = DeliveryMechanism.a(this.appData.installerPackageName).e;
        writeSessionPartFile(str, SESSION_APP_TAG, new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionApp(codedOutputStream, str5, CrashlyticsController.this.appData.apiKey, str6, str7, str8, i, CrashlyticsController.this.unityVersion);
            }
        });
        writeFile(str, "SessionApp.json", new FileOutputStreamWriteAction() {

            class C03081 extends HashMap<String, Object> {
                C03081() {
                    put("app_identifier", str5);
                    put("api_key", CrashlyticsController.this.appData.apiKey);
                    put("version_code", str6);
                    put("version_name", str7);
                    put("install_uuid", str8);
                    put("delivery_mechanism", Integer.valueOf(i));
                    put("unity_version", TextUtils.isEmpty(CrashlyticsController.this.unityVersion) ? "" : CrashlyticsController.this.unityVersion);
                }
            }

            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new C03081()).toString().getBytes());
            }
        });
    }

    private void writeSessionOS(String str) throws Exception {
        final boolean f = CommonUtils.f(this.crashlyticsCore.getContext());
        writeSessionPartFile(str, SESSION_OS_TAG, new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionOS(codedOutputStream, VERSION.RELEASE, VERSION.CODENAME, f);
            }
        });
        writeFile(str, "SessionOS.json", new FileOutputStreamWriteAction() {

            class C03091 extends HashMap<String, Object> {
                C03091() {
                    put("version", VERSION.RELEASE);
                    put("build_version", VERSION.CODENAME);
                    put("is_rooted", Boolean.valueOf(f));
                }
            }

            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new C03091()).toString().getBytes());
            }
        });
    }

    private void writeSessionDevice(String str) throws Exception {
        String str2 = str;
        Context context = this.crashlyticsCore.getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int a = CommonUtils.a();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long b = CommonUtils.b();
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean e = CommonUtils.e(context);
        Map c = this.idManager.c();
        int g = CommonUtils.g(context);
        final int i = a;
        final int i2 = availableProcessors;
        final long j = b;
        final long j2 = blockCount;
        final boolean z = e;
        long j3 = b;
        AnonymousClass23 anonymousClass23 = r0;
        final Map map = c;
        int i3 = availableProcessors;
        String str3 = SESSION_DEVICE_TAG;
        final int i4 = g;
        AnonymousClass23 anonymousClass232 = new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionDevice(codedOutputStream, i, Build.MODEL, i2, j, j2, z, map, i4, Build.MANUFACTURER, Build.PRODUCT);
            }
        };
        writeSessionPartFile(str2, str3, anonymousClass23);
        i2 = i3;
        j = j3;
        writeFile(str2, "SessionDevice.json", new FileOutputStreamWriteAction() {

            class C03101 extends HashMap<String, Object> {
                C03101() {
                    put("arch", Integer.valueOf(i));
                    put("build_model", Build.MODEL);
                    put("available_processors", Integer.valueOf(i2));
                    put("total_ram", Long.valueOf(j));
                    put("disk_space", Long.valueOf(j2));
                    put("is_emulator", Boolean.valueOf(z));
                    put("ids", map);
                    put("state", Integer.valueOf(i4));
                    put("build_manufacturer", Build.MANUFACTURER);
                    put("build_product", Build.PRODUCT);
                }
            }

            public void writeTo(FileOutputStream fileOutputStream) throws Exception {
                fileOutputStream.write(new JSONObject(new C03101()).toString().getBytes());
            }
        });
    }

    private void writeSessionUser(String str) throws Exception {
        final UserMetaData userMetaData = getUserMetaData(str);
        writeSessionPartFile(str, SESSION_USER_TAG, new CodedOutputStreamWriteAction() {
            public void writeTo(CodedOutputStream codedOutputStream) throws Exception {
                SessionProtobufHelper.writeSessionUser(codedOutputStream, userMetaData.id, userMetaData.name, userMetaData.email);
            }
        });
    }

    private void writeSessionEvent(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) throws Exception {
        boolean z2;
        Thread[] threadArr;
        TreeMap attributes;
        Map treeMap;
        TrimmedThrowableData trimmedThrowableData = new TrimmedThrowableData(th, this.stackTraceTrimmingStrategy);
        Context context = this.crashlyticsCore.getContext();
        long time = date.getTime() / 1000;
        Float c = CommonUtils.c(context);
        int a = CommonUtils.a(context, this.devicePowerStateListener.isPowerConnected());
        boolean d = CommonUtils.d(context);
        int i = context.getResources().getConfiguration().orientation;
        long b = CommonUtils.b() - CommonUtils.b(context);
        long c2 = CommonUtils.c(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = CommonUtils.a(context.getPackageName(), context);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.stacktrace;
        String str2 = this.appData.buildId;
        String str3 = this.idManager.b;
        int i2 = 0;
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            Thread[] threadArr2 = new Thread[allStackTraces.size()];
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr2[i2] = (Thread) entry.getKey();
                linkedList.add(r0.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[]) entry.getValue()));
                i2++;
            }
            z2 = true;
            threadArr = threadArr2;
        } else {
            z2 = true;
            threadArr = new Thread[0];
        }
        if (CommonUtils.a(context, COLLECT_CUSTOM_KEYS, z2)) {
            attributes = r0.crashlyticsCore.getAttributes();
            if (attributes != null && attributes.size() > z2) {
                treeMap = new TreeMap(attributes);
                SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, r0.logFileManager, a2, i, str3, str2, c, a, d, b, c2);
            }
        }
        attributes = new TreeMap();
        treeMap = attributes;
        SessionProtobufHelper.writeSessionEvent(codedOutputStream, time, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, linkedList, treeMap, r0.logFileManager, a2, i, str3, str2, c, a, d, b, c2);
    }

    private void writeSessionPartsToSessionFile(File file, String str, int i) {
        StringBuilder stringBuilder;
        Logger b = Fabric.b();
        String str2 = CrashlyticsCore.TAG;
        StringBuilder stringBuilder2 = new StringBuilder("Collecting session parts for ID ");
        stringBuilder2.append(str);
        b.a(str2, stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(SESSION_FATAL_TAG);
        File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(stringBuilder3.toString()));
        boolean z = listFilesMatching != null && listFilesMatching.length > 0;
        Fabric.b().a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z)}));
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str);
        stringBuilder4.append(SESSION_NON_FATAL_TAG);
        File[] listFilesMatching2 = listFilesMatching(new FileNameContainsFilter(stringBuilder4.toString()));
        boolean z2 = listFilesMatching2 != null && listFilesMatching2.length > 0;
        Fabric.b().a(CrashlyticsCore.TAG, String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z2)}));
        if (!z) {
            if (!z2) {
                file = Fabric.b();
                i = CrashlyticsCore.TAG;
                stringBuilder = new StringBuilder("No events present for session ID ");
                stringBuilder.append(str);
                file.a(i, stringBuilder.toString());
                file = Fabric.b();
                i = CrashlyticsCore.TAG;
                stringBuilder = new StringBuilder("Removing session part files for ID ");
                stringBuilder.append(str);
                file.a(i, stringBuilder.toString());
                deleteSessionPartFilesFor(str);
            }
        }
        synthesizeSessionFile(file, str, getTrimmedNonFatalFiles(str, listFilesMatching2, i), z ? listFilesMatching[0] : null);
        file = Fabric.b();
        i = CrashlyticsCore.TAG;
        stringBuilder = new StringBuilder("Removing session part files for ID ");
        stringBuilder.append(str);
        file.a(i, stringBuilder.toString());
        deleteSessionPartFilesFor(str);
    }

    private void synthesizeSessionFile(File file, String str, File[] fileArr, File file2) {
        Closeable clsFileOutputStream;
        StringBuilder stringBuilder;
        boolean z = file2 != null;
        File fatalSessionFilesDir = z ? getFatalSessionFilesDir() : getNonFatalSessionFilesDir();
        if (!fatalSessionFilesDir.exists()) {
            fatalSessionFilesDir.mkdirs();
        }
        Flushable flushable = null;
        Flushable newInstance;
        try {
            clsFileOutputStream = new ClsFileOutputStream(fatalSessionFilesDir, str);
            try {
                newInstance = CodedOutputStream.newInstance((OutputStream) clsFileOutputStream);
                try {
                    Logger b = Fabric.b();
                    String str2 = CrashlyticsCore.TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("Collecting SessionStart data for session ID ");
                    stringBuilder2.append(str);
                    b.a(str2, stringBuilder2.toString());
                    writeToCosFromFile(newInstance, file);
                    newInstance.writeUInt64(4, new Date().getTime() / 1000);
                    newInstance.writeBool(5, z);
                    newInstance.writeUInt32(11, 1);
                    newInstance.writeEnum(12, 3);
                    writeInitialPartsTo(newInstance, str);
                    writeNonFatalEventsTo(newInstance, fileArr, str);
                    if (z) {
                        writeToCosFromFile(newInstance, file2);
                    }
                    CommonUtils.a(newInstance, "Error flushing session file stream");
                    CommonUtils.a(clsFileOutputStream, "Failed to close CLS file");
                } catch (Exception e) {
                    file = e;
                    flushable = newInstance;
                    try {
                        fileArr = Fabric.b();
                        file2 = CrashlyticsCore.TAG;
                        stringBuilder = new StringBuilder("Failed to write session file for session ID: ");
                        stringBuilder.append(str);
                        fileArr.c(file2, stringBuilder.toString(), file);
                        CommonUtils.a(flushable, "Error flushing session file stream");
                        closeWithoutRenamingOrLog(clsFileOutputStream);
                    } catch (Throwable th) {
                        file = th;
                        newInstance = flushable;
                        CommonUtils.a(newInstance, "Error flushing session file stream");
                        CommonUtils.a(clsFileOutputStream, "Failed to close CLS file");
                        throw file;
                    }
                } catch (Throwable th2) {
                    file = th2;
                    CommonUtils.a(newInstance, "Error flushing session file stream");
                    CommonUtils.a(clsFileOutputStream, "Failed to close CLS file");
                    throw file;
                }
            } catch (Exception e2) {
                file = e2;
                fileArr = Fabric.b();
                file2 = CrashlyticsCore.TAG;
                stringBuilder = new StringBuilder("Failed to write session file for session ID: ");
                stringBuilder.append(str);
                fileArr.c(file2, stringBuilder.toString(), file);
                CommonUtils.a(flushable, "Error flushing session file stream");
                closeWithoutRenamingOrLog(clsFileOutputStream);
            }
        } catch (Exception e3) {
            file = e3;
            clsFileOutputStream = null;
            fileArr = Fabric.b();
            file2 = CrashlyticsCore.TAG;
            stringBuilder = new StringBuilder("Failed to write session file for session ID: ");
            stringBuilder.append(str);
            fileArr.c(file2, stringBuilder.toString(), file);
            CommonUtils.a(flushable, "Error flushing session file stream");
            closeWithoutRenamingOrLog(clsFileOutputStream);
        } catch (Throwable th3) {
            file = th3;
            newInstance = null;
            clsFileOutputStream = newInstance;
            CommonUtils.a(newInstance, "Error flushing session file stream");
            CommonUtils.a(clsFileOutputStream, "Failed to close CLS file");
            throw file;
        }
    }

    private static void writeNonFatalEventsTo(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.a);
        for (File name : fileArr) {
            try {
                Fabric.b().a(CrashlyticsCore.TAG, String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                writeToCosFromFile(codedOutputStream, name);
            } catch (Throwable e) {
                Fabric.b().c(CrashlyticsCore.TAG, "Error writting non-fatal to session.", e);
            }
        }
    }

    private void writeInitialPartsTo(CodedOutputStream codedOutputStream, String str) throws IOException {
        for (String str2 : INITIAL_SESSION_PART_TAGS) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(ClsFileOutputStream.SESSION_FILE_EXTENSION);
            File[] listFilesMatching = listFilesMatching(new FileNameContainsFilter(stringBuilder.toString()));
            if (listFilesMatching.length == 0) {
                Logger b = Fabric.b();
                String str3 = CrashlyticsCore.TAG;
                StringBuilder stringBuilder2 = new StringBuilder("Can't find ");
                stringBuilder2.append(str2);
                stringBuilder2.append(" data for session ID ");
                stringBuilder2.append(str);
                b.c(str3, stringBuilder2.toString(), null);
            } else {
                Logger b2 = Fabric.b();
                String str4 = CrashlyticsCore.TAG;
                StringBuilder stringBuilder3 = new StringBuilder("Collecting ");
                stringBuilder3.append(str2);
                stringBuilder3.append(" data for session ID ");
                stringBuilder3.append(str);
                b2.a(str4, stringBuilder3.toString());
                writeToCosFromFile(codedOutputStream, listFilesMatching[0]);
            }
        }
    }

    private static void writeToCosFromFile(CodedOutputStream codedOutputStream, File file) throws IOException {
        Closeable fileInputStream;
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    copyToCodedOutputStream(fileInputStream, codedOutputStream, (int) file.length());
                    CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                    return;
                } catch (Throwable th) {
                    codedOutputStream = th;
                    CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                    throw codedOutputStream;
                }
            } catch (Throwable th2) {
                codedOutputStream = th2;
                fileInputStream = null;
                CommonUtils.a(fileInputStream, "Failed to close file input stream.");
                throw codedOutputStream;
            }
        }
        codedOutputStream = Fabric.b();
        String str = CrashlyticsCore.TAG;
        StringBuilder stringBuilder = new StringBuilder("Tried to include a file that doesn't exist: ");
        stringBuilder.append(file.getName());
        codedOutputStream.c(str, stringBuilder.toString(), null);
    }

    private static void copyToCodedOutputStream(InputStream inputStream, CodedOutputStream codedOutputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                break;
            }
            i2 += read;
        }
        codedOutputStream.writeRawBytes(bArr);
    }

    private UserMetaData getUserMetaData(String str) {
        if (isHandlingException()) {
            return new UserMetaData(this.crashlyticsCore.getUserIdentifier(), this.crashlyticsCore.getUserName(), this.crashlyticsCore.getUserEmail());
        }
        return new MetaDataStore(getFilesDir()).readUserData(str);
    }

    boolean isHandlingException() {
        return this.crashHandler != null && this.crashHandler.isHandlingException();
    }

    File getFilesDir() {
        return this.fileStore.a();
    }

    File getFatalSessionFilesDir() {
        return new File(getFilesDir(), FATAL_SESSION_DIR);
    }

    File getNonFatalSessionFilesDir() {
        return new File(getFilesDir(), NONFATAL_SESSION_DIR);
    }

    File getInvalidFilesDir() {
        return new File(getFilesDir(), INVALID_CLS_CACHE_DIR);
    }

    private boolean shouldPromptUserBeforeSendingCrashReports(SettingsData settingsData) {
        if (settingsData == null || settingsData.d.a == null || this.preferenceManager.shouldAlwaysSendReports() != null) {
            return false;
        }
        return true;
    }

    private CreateReportSpiCall getCreateReportSpiCall(String str) {
        return new DefaultCreateReportSpiCall(this.crashlyticsCore, CommonUtils.d(this.crashlyticsCore.getContext(), CRASHLYTICS_API_ENDPOINT), str, this.httpRequestFactory);
    }

    private void sendSessionReports(SettingsData settingsData) {
        if (settingsData == null) {
            Fabric.b().d(CrashlyticsCore.TAG, "Cannot send reports. Settings are unavailable.");
            return;
        }
        Context context = this.crashlyticsCore.getContext();
        ReportUploader reportUploader = new ReportUploader(this.appData.apiKey, getCreateReportSpiCall(settingsData.a.d), this.reportFilesProvider, this.handlingExceptionCheck);
        for (File sessionReport : listCompleteSessionFiles()) {
            this.backgroundWorker.submit(new SendReportRunnable(context, new SessionReport(sessionReport, SEND_AT_CRASHTIME_HEADER), reportUploader));
        }
    }

    private static void recordLoggedExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) Fabric.a(Answers.class);
        if (answers == null) {
            Fabric.b().a(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new LoggedException(str, str2));
        }
    }

    private static void recordFatalExceptionAnswersEvent(String str, String str2) {
        Answers answers = (Answers) Fabric.a(Answers.class);
        if (answers == null) {
            Fabric.b().a(CrashlyticsCore.TAG, "Answers is not available");
        } else {
            answers.onException(new FatalException(str, str2));
        }
    }

    private void recordFatalFirebaseEvent(long j) {
        if (firebaseCrashExists()) {
            Fabric.b().a(CrashlyticsCore.TAG, "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return;
        }
        if (this.firebaseCrashlyticsEnabled) {
            if (this.firebaseAnalytics != null) {
                Fabric.b().a(CrashlyticsCore.TAG, "Logging Crashlytics event to Firebase");
                Bundle bundle = new Bundle();
                bundle.putInt(FIREBASE_REALTIME, 1);
                bundle.putInt(FIREBASE_CRASH_TYPE, 1);
                bundle.putLong(FIREBASE_TIMESTAMP, j);
                this.firebaseAnalytics.logEvent(FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS, FIREBASE_APPLICATION_EXCEPTION, bundle);
                return;
            }
            Fabric.b().a(CrashlyticsCore.TAG, "Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
        }
    }

    private boolean firebaseCrashExists() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        r0 = "com.google.firebase.crash.FirebaseCrash";	 Catch:{ ClassNotFoundException -> 0x0007 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0007 }
        r0 = 1;
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.CrashlyticsController.firebaseCrashExists():boolean");
    }
}
