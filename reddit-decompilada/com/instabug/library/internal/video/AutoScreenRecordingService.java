package com.instabug.library.internal.video;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.internal.video.C0696b.C06921;
import com.instabug.library.internal.video.C0696b.C06932;
import com.instabug.library.internal.video.C0696b.C0694a;
import com.instabug.library.model.Session.SessionState;
import com.instabug.library.settings.SettingsManager;
import java.io.File;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class AutoScreenRecordingService extends Service {
    private final C0694a f9623a = new C13641(this);
    private C0696b f9624b;
    private CompositeSubscription f9625c;

    public enum Action {
        STOP_DELETE,
        STOP_KEEP,
        STOP_TRIM_KEEP
    }

    class C13641 implements C0694a {
        final /* synthetic */ AutoScreenRecordingService f15467a;

        C13641(AutoScreenRecordingService autoScreenRecordingService) {
            this.f15467a = autoScreenRecordingService;
        }
    }

    class C13652 implements Action1<Action> {
        final /* synthetic */ AutoScreenRecordingService f15468a;

        C13652(AutoScreenRecordingService autoScreenRecordingService) {
            this.f15468a = autoScreenRecordingService;
        }

        public final /* synthetic */ void m15384a(Object obj) {
            switch ((Action) obj) {
                case STOP_DELETE:
                    if (SettingsManager.getInstance().isScreenCurrentlyRecorded() != null) {
                        SettingsManager.getInstance().setScreenCurrentlyRecorded(false);
                        this.f15468a.f9624b.m8210a();
                        new Thread(new C06921(this.f15468a.f9624b)).start();
                        return;
                    }
                    break;
                case STOP_KEEP:
                    if (SettingsManager.getInstance().isScreenCurrentlyRecorded() != null) {
                        SettingsManager.getInstance().setScreenCurrentlyRecorded(false);
                        this.f15468a.f9624b.m8210a();
                        InternalAutoScreenRecorderHelper.getInstance().setAutoScreenRecordingFile(new File(this.f15468a.f9624b.f9648a));
                        return;
                    }
                    break;
                case STOP_TRIM_KEEP:
                    if (SettingsManager.getInstance().isScreenCurrentlyRecorded() != null) {
                        SettingsManager.getInstance().setScreenCurrentlyRecorded(false);
                        this.f15468a.f9624b.m8210a();
                        new Thread(new C06932(this.f15468a.f9624b, SettingsManager.getInstance().autoScreenRecordingMaxDuration())).start();
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    class C13663 implements Action1<SessionState> {
        final /* synthetic */ AutoScreenRecordingService f15469a;

        C13663(AutoScreenRecordingService autoScreenRecordingService) {
            this.f15469a = autoScreenRecordingService;
        }

        public final /* synthetic */ void m15385a(Object obj) {
            if (((SessionState) obj) == SessionState.FINISH) {
                this.f15469a.f9624b.m8210a();
            }
        }
    }

    static Intent m8200a(Context context, int i, Intent intent) {
        Intent intent2 = new Intent(context, AutoScreenRecordingService.class);
        intent2.putExtra("result-code", i);
        intent2.putExtra("data", intent);
        return intent2;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf();
        } else {
            this.f9625c = new CompositeSubscription();
            this.f9625c.a(AutoScreenRecordingEventBus.getInstance().subscribe(new C13652(this)));
            this.f9625c.a(SessionStateEventBus.getInstance().subscribe(new C13663(this)));
            int intExtra = intent.getIntExtra("result-code", 0);
            Intent intent2 = (Intent) intent.getParcelableExtra("data");
            if (intExtra != 0) {
                if (intent2 != null) {
                    if (!SettingsManager.getInstance().isScreenCurrentlyRecorded()) {
                        this.f9624b = new C0696b(this, this.f9623a, intExtra, intent2);
                        SettingsManager.getInstance().setScreenCurrentlyRecorded(true);
                    }
                }
            }
            throw new IllegalStateException("Result code or data missing.");
        }
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
        r3 = this;
        super.onDestroy();
        r0 = r3.f9625c;
        if (r0 == 0) goto L_0x0026;
    L_0x0007:
        r0 = r3.f9625c;
        r1 = r0.b;
        if (r1 != 0) goto L_0x0026;
    L_0x000d:
        monitor-enter(r0);
        r1 = r0.b;	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x0021;
    L_0x0012:
        r1 = r0.a;	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0021;
    L_0x0017:
        r1 = r0.a;	 Catch:{ all -> 0x0023 }
        r2 = 0;
        r0.a = r2;	 Catch:{ all -> 0x0023 }
        monitor-exit(r0);	 Catch:{ all -> 0x0023 }
        rx.subscriptions.CompositeSubscription.a(r1);
        goto L_0x0026;
    L_0x0021:
        monitor-exit(r0);	 Catch:{ all -> 0x0023 }
        return;
    L_0x0023:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0023 }
        throw r1;
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.AutoScreenRecordingService.onDestroy():void");
    }
}
