package com.instabug.bug.p001b;

import android.app.Activity;
import com.instabug.bug.C0469b;
import com.instabug.bug.C0474d;
import com.instabug.bug.cache.BugsCacheManager;
import com.instabug.bug.model.Bug;
import com.instabug.bug.model.Bug.BugState;
import com.instabug.library.core.eventbus.VideoProcessingServiceEventBus;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.video.ScreenRecordEvent;
import com.instabug.library.internal.video.VideoProcessingService.Action;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.Attachment.Type;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.ArrayList;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: ExternalScreenRecordHelper */
public class C0468b {
    private static C0468b f9094b;
    public Subscription f9095a;

    /* compiled from: ExternalScreenRecordHelper */
    class C12601 implements Action1<ScreenRecordEvent> {
        final /* synthetic */ String f15305a;
        final /* synthetic */ C0468b f15306b;

        public C12601(C0468b c0468b, String str) {
            this.f15306b = c0468b;
            this.f15305a = str;
        }

        public final /* synthetic */ void m15210a(Object obj) {
            ScreenRecordEvent screenRecordEvent = (ScreenRecordEvent) obj;
            if (screenRecordEvent.getStatus() == 1) {
                if (this.f15305a != null) {
                    Bug bug = BugsCacheManager.getBug(this.f15305a);
                    if (bug != null) {
                        C0468b.m7749a(C0468b.m7746a(bug.f15314e), screenRecordEvent.getVideoUri().getPath());
                        bug.f15315f = BugState.READY_TO_BE_SENT;
                        BugsCacheManager.addBug(bug);
                    }
                }
                C0468b.m7747a(this.f15306b);
            } else if (screenRecordEvent.getStatus() == 0) {
                C0468b.m7748a(screenRecordEvent);
                C0468b.m7752c();
            } else {
                if (screenRecordEvent.getStatus() == 2) {
                    if (this.f15305a != null) {
                        obj = BugsCacheManager.getBug(this.f15305a);
                        if (obj != null) {
                            C0468b c0468b = this.f15306b;
                            Attachment a = C0468b.m7746a(obj.f15314e);
                            obj.f15314e.remove(a);
                            File file = new File(a.getLocalPath());
                            if (Type.VIDEO.equals(a.getType())) {
                                InstabugSDKLogger.m8356d(c0468b, "removing video attachment");
                                obj.setHasVideo(false);
                                VideoProcessingServiceEventBus.getInstance().post(Action.STOP);
                            }
                            if (file.delete()) {
                                InstabugSDKLogger.m8359i(c0468b, "attachment removed successfully");
                            }
                            obj.f15315f = BugState.READY_TO_BE_SENT;
                            BugsCacheManager.addBug(obj);
                        }
                    }
                    C0468b.m7747a(this.f15306b);
                }
            }
        }
    }

    /* compiled from: ExternalScreenRecordHelper */
    class C12612 implements Action1<Action> {
        final /* synthetic */ C0468b f15307a;

        public C12612(C0468b c0468b) {
            this.f15307a = c0468b;
        }

        public final /* synthetic */ void m15211a(Object obj) {
            if (this.f15307a.f9095a != null) {
                C0468b.m7747a(this.f15307a);
            }
        }
    }

    public static C0468b m7745a() {
        if (f9094b == null) {
            f9094b = new C0468b();
        }
        return f9094b;
    }

    public static void m7749a(Attachment attachment, String str) {
        attachment.setLocalPath(str);
        attachment.setVideoEncoded(true);
    }

    public static boolean m7751b() {
        return InternalScreenRecordHelper.getInstance().isRecording();
    }

    static /* synthetic */ Attachment m7746a(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Attachment attachment = (Attachment) arrayList.get(size);
            if (attachment.getType() == Type.VIDEO) {
                return attachment;
            }
        }
        return null;
    }

    static /* synthetic */ void m7747a(C0468b c0468b) {
        if (!c0468b.f9095a.d()) {
            c0468b.f9095a.c();
        }
    }

    static /* synthetic */ void m7748a(ScreenRecordEvent screenRecordEvent) {
        C0474d.m7762a().f9100a.m15214a(screenRecordEvent.getVideoUri(), Type.VIDEO);
        C0474d.m7762a().f9100a.f15315f = BugState.WAITING_VIDEO;
    }

    static /* synthetic */ void m7752c() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(C0469b.m7755c(currentActivity.getApplicationContext()));
        }
    }
}
