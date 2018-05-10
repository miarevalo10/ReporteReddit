package com.instabug.crash.network;

import android.net.Uri;
import com.instabug.crash.cache.CrashesCacheManager;
import com.instabug.crash.models.Crash;
import com.instabug.crash.models.Crash.CrashState;
import com.instabug.crash.p013b.C0582a;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.internal.video.InstabugVideoUtils;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;

public class InstabugCrashesUploaderService extends InstabugNetworkBasedBackgroundService {
    private void m19457a() throws IOException, JSONException {
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(CrashesCacheManager.getCrashes().size());
        stringBuilder.append(" crashes in cache");
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        for (final Crash crash : CrashesCacheManager.getCrashes()) {
            StringBuilder stringBuilder2;
            if (crash.f15427f.equals(CrashState.READY_TO_BE_SENT)) {
                stringBuilder2 = new StringBuilder("Uploading crash: ");
                stringBuilder2.append(crash.toString());
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                C0587a.m8009a().m8010a(this, crash, new Callbacks<String, Throwable>(this) {
                    final /* synthetic */ InstabugCrashesUploaderService f15430b;

                    public /* synthetic */ void onSucceeded(Object obj) {
                        String str = (String) obj;
                        InstabugCrashesUploaderService instabugCrashesUploaderService = this.f15430b;
                        StringBuilder stringBuilder = new StringBuilder("crash uploaded successfully, setting crash TemporaryServerToken equal ");
                        stringBuilder.append(str);
                        InstabugSDKLogger.m8356d(instabugCrashesUploaderService, stringBuilder.toString());
                        crash.f15423b = str;
                        crash.f15427f = CrashState.LOGS_READY_TO_BE_UPLOADED;
                        CrashesCacheManager.saveCacheToDisk();
                        this.f15430b.m19458a(crash);
                        InstabugCrashesUploaderService.m19459a(this.f15430b);
                    }

                    public /* synthetic */ void onFailed(Object obj) {
                        InstabugSDKLogger.m8356d(this.f15430b, "Something went wrong while uploading crash");
                    }
                });
            } else if (crash.f15427f.equals(CrashState.LOGS_READY_TO_BE_UPLOADED)) {
                stringBuilder2 = new StringBuilder("crash: ");
                stringBuilder2.append(crash.toString());
                stringBuilder2.append(" already uploaded but has unsent logs, uploading now");
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                m19458a(crash);
            } else if (crash.f15427f.equals(CrashState.ATTACHMENTS_READY_TO_BE_UPLOADED)) {
                stringBuilder2 = new StringBuilder("crash: ");
                stringBuilder2.append(crash.toString());
                stringBuilder2.append(" already uploaded but has unsent attachments, uploading now");
                InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
                m19461b(crash);
            }
        }
    }

    private void m19458a(final Crash crash) {
        StringBuilder stringBuilder = new StringBuilder("START uploading all logs related to this crash id = ");
        stringBuilder.append(crash.f15422a);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        C0587a.m8009a().m8012c(this, crash, new Callbacks<Boolean, Crash>(this) {
            final /* synthetic */ InstabugCrashesUploaderService f15432b;

            public /* synthetic */ void onFailed(Object obj) {
                InstabugSDKLogger.m8356d(this.f15432b, "Something went wrong while uploading crash logs");
            }

            public /* synthetic */ void onSucceeded(Object obj) {
                InstabugSDKLogger.m8356d(this.f15432b, "crash logs uploaded successfully, change its state");
                crash.f15427f = CrashState.ATTACHMENTS_READY_TO_BE_UPLOADED;
                CrashesCacheManager.saveCacheToDisk();
                try {
                    this.f15432b.m19461b(crash);
                } catch (Object obj2) {
                    InstabugCrashesUploaderService instabugCrashesUploaderService = this.f15432b;
                    StringBuilder stringBuilder = new StringBuilder("Something went wrong while uploading crash attachments e: ");
                    stringBuilder.append(obj2.getMessage());
                    InstabugSDKLogger.m8357e(instabugCrashesUploaderService, stringBuilder.toString());
                }
            }
        });
    }

    private void m19461b(final Crash crash) throws JSONException, FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(crash.f15425d.size());
        stringBuilder.append(" attachments related to crash: ");
        stringBuilder.append(crash.f15424c);
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        C0587a.m8009a().m8011b(this, crash, new Callbacks<Boolean, Crash>(this) {
            final /* synthetic */ InstabugCrashesUploaderService f15434b;

            public /* synthetic */ void onFailed(Object obj) {
                InstabugSDKLogger.m8356d(this.f15434b, "Something went wrong while uploading crash attachments");
            }

            public /* synthetic */ void onSucceeded(Object obj) {
                InstabugSDKLogger.m8356d(this.f15434b, "Crash attachments uploaded successfully, deleting crash");
                CrashesCacheManager.deleteCrash(crash.f15422a);
                CrashesCacheManager.saveCacheToDisk();
                InstabugCrashesUploaderService.m19459a(this.f15434b);
            }
        });
    }

    protected void runBackgroundTask() throws Exception {
        if (SettingsManager.getInstance().autoScreenRecordingEnabled()) {
            int autoScreenRecordingMaxDuration = SettingsManager.getInstance().autoScreenRecordingMaxDuration();
            for (Crash crash : CrashesCacheManager.getCrashes()) {
                if (crash.f15427f == CrashState.WAITING_FOR_SCREEN_RECORDING_TO_BE_TRIMMED) {
                    Iterator it = crash.f15425d.iterator();
                    while (it.hasNext()) {
                        Attachment attachment = (Attachment) it.next();
                        if (attachment.getType().toString().equalsIgnoreCase(Type.AUTO_SCREEN_RECORDING.toString())) {
                            Uri fromFile = Uri.fromFile(InstabugVideoUtils.startTrim(new File(attachment.getLocalPath()), AttachmentManager.getAutoScreenRecordingFile(getApplicationContext()), autoScreenRecordingMaxDuration));
                            attachment.setName(fromFile.getLastPathSegment());
                            attachment.setLocalPath(fromFile.getPath());
                            InstabugSDKLogger.m8356d(this, "auto screen recording trimmed");
                            crash.f15427f = CrashState.READY_TO_BE_SENT;
                            break;
                        }
                    }
                }
            }
        }
        m19457a();
    }

    static /* synthetic */ void m19459a(InstabugCrashesUploaderService instabugCrashesUploaderService) {
        Calendar instance = Calendar.getInstance(Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder("Updating last_crash_time to ");
        stringBuilder.append(instance.getTime());
        InstabugSDKLogger.m8360v(instabugCrashesUploaderService, stringBuilder.toString());
        C0582a.m7995a();
        C0582a.m7996a(instance.getTime().getTime());
    }
}
