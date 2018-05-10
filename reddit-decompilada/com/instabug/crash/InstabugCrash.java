package com.instabug.crash;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.instabug.crash.cache.CrashesCacheManager;
import com.instabug.crash.models.Crash.C0586a;
import com.instabug.crash.models.Crash.CrashState;
import com.instabug.crash.network.InstabugCrashesUploaderService;
import com.instabug.crash.p012a.C0580a;
import com.instabug.crash.p012a.C1332b;
import com.instabug.crash.p013b.C0582a;
import com.instabug.crash.p014c.C0585a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.video.AutoScreenRecordingService.Action;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Map.Entry;
import org.json.JSONObject;

public class InstabugCrash {
    public static void reportCaughtException(Context context, Throwable th, String str) {
        if (InstabugCore.getFeatureState(Feature.CRASH_REPORTING) != State.DISABLED) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error", C0585a.m8007a(th, str));
                C0582a.m7995a();
                if (C0582a.m7999b() != null) {
                    try {
                        C0582a.m7995a();
                        C0582a.m7999b().run();
                    } catch (Throwable th2) {
                        InstabugSDKLogger.m8358e(InstabugCrash.class, "Pre sending runnable failed to run.", th2);
                    }
                }
                th2 = new C0586a().m8008a(context);
                th2.f15424c = jSONObject.toString();
                th2.f15427f = CrashState.READY_TO_BE_SENT;
                th2.f15428g = true;
                if (InstabugCore.getExtraAttachmentFiles().size() > null) {
                    for (Entry entry : InstabugCore.getExtraAttachmentFiles().entrySet()) {
                        th2.m15330a(AttachmentsUtility.getNewFileAttachmentUri(context, (Uri) entry.getKey(), (String) entry.getValue()));
                    }
                }
                if (C1332b.m15327a().isEnabled() != null) {
                    AutoScreenRecordingEventBus.getInstance().post(Action.STOP_KEEP);
                    C0580a.m7994a(th2);
                }
                CrashesCacheManager.addCrash(th2);
                InstabugSDKLogger.m8359i(InstabugCrash.class, "ReportCaughtException: Your exception has been reported");
                context.startService(new Intent(context, InstabugCrashesUploaderService.class));
                C1332b.m15327a();
                C1332b.m15328b();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
    }

    public static void setPreSendingRunnable(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("runnable").setType(Runnable.class));
        C0582a.m7995a();
        C0582a.m7998a(runnable);
    }
}
