package com.instabug.crash;

import android.content.Context;
import android.net.Uri;
import com.instabug.crash.cache.CrashesCacheManager;
import com.instabug.crash.models.Crash;
import com.instabug.crash.models.Crash.C0586a;
import com.instabug.crash.models.Crash.CrashState;
import com.instabug.crash.p012a.C0580a;
import com.instabug.crash.p012a.C1332b;
import com.instabug.crash.p013b.C0582a;
import com.instabug.crash.p014c.C0585a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.video.AutoScreenRecordingService.Action;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InstabugUncaughtExceptionHandler */
public class C0581a implements UncaughtExceptionHandler {
    UncaughtExceptionHandler f9370a = Thread.getDefaultUncaughtExceptionHandler();

    public void uncaughtException(Thread thread, Throwable th) {
        if (InstabugCore.getFeatureState(Feature.CRASH_REPORTING) == State.DISABLED) {
            this.f9370a.uncaughtException(thread, th);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Instabug Caught an Unhandled Exception: ");
        stringBuilder.append(th.getClass().getCanonicalName());
        InstabugSDKLogger.m8358e(Instabug.class, stringBuilder.toString(), th);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("threadName", thread.getName());
            jSONObject2.put("threadId", thread.getId());
            jSONObject2.put("threadPriority", thread.getPriority());
            jSONObject2.put("threadState", thread.getState().toString());
            ThreadGroup threadGroup = thread.getThreadGroup();
            if (threadGroup != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("name", threadGroup.getName());
                jSONObject3.put("maxPriority", threadGroup.getMaxPriority());
                jSONObject3.put("activeCount", threadGroup.activeCount());
                jSONObject2.put("threadGroup", jSONObject3);
            }
            jSONObject.put("thread", jSONObject2);
            jSONObject.put("error", C0585a.m8007a(th, null));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C0582a.m7995a();
        if (C0582a.m7999b() != null) {
            try {
                C0582a.m7995a();
                C0582a.m7999b().run();
            } catch (Throwable e2) {
                InstabugSDKLogger.m8358e(Instabug.class, "Pre sending runnable failed to run.", e2);
            }
        }
        Crash a = new C0586a().m8008a(Instabug.getApplicationContext());
        a.f15424c = jSONObject.toString();
        a.f15427f = CrashState.READY_TO_BE_SENT;
        a.f15428g = false;
        Context applicationContext = Instabug.getApplicationContext();
        if (InstabugCore.getExtraAttachmentFiles().size() > 0) {
            for (Entry entry : InstabugCore.getExtraAttachmentFiles().entrySet()) {
                a.m15330a(AttachmentsUtility.getNewFileAttachmentUri(applicationContext, (Uri) entry.getKey(), (String) entry.getValue()));
            }
        }
        if (C1332b.m15327a().isEnabled()) {
            AutoScreenRecordingEventBus.getInstance().post(Action.STOP_KEEP);
            C0580a.m7994a(a);
        }
        CrashesCacheManager.addCrash(a);
        CrashesCacheManager.saveCacheToDisk();
        InstabugSDKLogger.m8359i(Instabug.class, "Crash persisted for upload at next startup");
        this.f9370a.uncaughtException(thread, th);
    }
}
