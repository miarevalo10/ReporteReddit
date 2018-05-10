package com.instabug.bug;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import com.instabug.bug.OnSdkDismissedCallback.DismissType;
import com.instabug.bug.cache.BugsCacheManager;
import com.instabug.bug.model.Bug;
import com.instabug.bug.model.Bug.BugState;
import com.instabug.bug.settings.C0485a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.user.UserEvent;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Map.Entry;

/* compiled from: LiveBugManager */
public class C0474d {
    private static C0474d f9099d = new C0474d();
    public Bug f9100a;
    public boolean f9101b;
    public DismissType f9102c = null;

    private C0474d() {
    }

    public static C0474d m7762a() {
        return f9099d;
    }

    public final void m7768a(Context context, Uri uri, String str, Type type) {
        this.f9100a.m15214a(AttachmentsUtility.getNewFileAttachmentUri(context, uri, str), type);
        C0474d.m7763a(context);
    }

    public static void m7763a(Context context) {
        LocalBroadcastManager.m744a(context).m748a(new Intent("refresh.attachments"));
    }

    public final void m7770b(final Context context) {
        C0485a.m7793a();
        if (C0485a.m7816g() != null) {
            try {
                C0485a.m7816g().run();
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e("LiveBugManager", "Pre sending runnable failed to run.", e);
            }
        }
        new Thread(new Runnable(this) {
            final /* synthetic */ C0474d f9098b;

            /* compiled from: LiveBugManager */
            class C04721 implements Runnable {
                final /* synthetic */ C04731 f9096a;

                C04721(C04731 c04731) {
                    this.f9096a = c04731;
                }

                public void run() {
                    this.f9096a.f9098b.m7767c();
                    this.f9096a.f9098b.f9100a = null;
                }
            }

            public void run() {
                Bug bug;
                C0474d.m7765a(this.f9098b, context);
                C0474d.m7766b(this.f9098b, context);
                C0474d c0474d = this.f9098b;
                if (c0474d.f9100a.getState() != null) {
                    c0474d.f9100a.getState().setTags(InstabugCore.getTagsAsString());
                    c0474d.f9100a.getState().setUserAttributes(UserAttributesCacheManager.getUserAttributes());
                    c0474d.f9100a.getState().updateConsoleLog();
                    if (InstabugCore.getFeatureState(Feature.USER_DATA) == State.ENABLED) {
                        c0474d.f9100a.getState().setUserData(InstabugCore.getUserData());
                    }
                    if (InstabugCore.getFeatureState(Feature.INSTABUG_LOGS) == State.ENABLED) {
                        c0474d.f9100a.getState().setInstabugLog(InstabugLog.getLogs());
                    }
                    if (InstabugCore.getFeatureState(Feature.USER_EVENTS) == State.ENABLED) {
                        try {
                            c0474d.f9100a.getState().setUserEvents(UserEvent.toJson(InstabugUserEventLogger.getInstance().getUserEvents()).toString());
                        } catch (Throwable e) {
                            InstabugSDKLogger.m8358e(c0474d, "Got error while parsing user events logs", e);
                        }
                    }
                }
                this.f9098b.f9102c = DismissType.SUBMIT;
                if (this.f9098b.f9100a.hasVideo()) {
                    if (!this.f9098b.f9100a.hasVideo() || !this.f9098b.f9100a.isVideoEncoded()) {
                        bug = this.f9098b.f9100a;
                        bug.f15315f = BugState.WAITING_VIDEO;
                        BugsCacheManager.addBug(bug);
                        Looper.prepare();
                        new Handler(Looper.getMainLooper()).post(new C04721(this));
                    }
                }
                InstabugSDKLogger.m8356d("LiveBugManager", "Sending bug..");
                bug = this.f9098b.f9100a;
                bug.f15315f = BugState.READY_TO_BE_SENT;
                BugsCacheManager.addBug(bug);
                Looper.prepare();
                new Handler(Looper.getMainLooper()).post(new C04721(this));
            }
        }).start();
    }

    private void m7767c() {
        C0485a.m7793a();
        if (C0485a.m7817h() != null) {
            C0485a.m7817h().onSdkDismissed(this.f9102c, this.f9100a.f15312c);
        }
    }

    public final void m7769b() {
        this.f9101b = true;
        this.f9102c = DismissType.ADD_ATTACHMENT;
        m7767c();
    }

    static /* synthetic */ void m7765a(C0474d c0474d, Context context) {
        for (Entry entry : InstabugCore.getExtraAttachmentFiles().entrySet()) {
            c0474d.m7768a(context, (Uri) entry.getKey(), (String) entry.getValue(), Type.ATTACHMENT_FILE);
        }
    }

    static /* synthetic */ void m7766b(C0474d c0474d, Context context) {
        c0474d = c0474d.f9100a.f15314e.iterator();
        while (c0474d.hasNext()) {
            Attachment attachment = (Attachment) c0474d.next();
            if (attachment.getType().equals(Type.IMAGE) || attachment.getType().equals(Type.MAIN_SCREENSHOT)) {
                try {
                    BitmapUtils.compressBitmapAndSave(AttachmentsUtility.getAttachmentFile(context, attachment.getName()));
                } catch (Exception e) {
                    e.printStackTrace();
                    InstabugSDKLogger.m8357e(C0474d.class, "Failed to compress MAIN_SCREENSHOT or IMAGE & save original as it is");
                }
            }
        }
    }
}
