package com.reddit.frontpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService;
import com.reddit.frontpage.sync.routine.AppConfigSyncRoutine.AppConfigurationUpdatedEvent;
import com.reddit.frontpage.util.IntentUtil;
import de.greenrobot.event.EventBus;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class StartActivity extends Activity {
    private static final String f19893a = "StartActivity";
    private final Handler f19894b = new Handler();
    private boolean f19895c;
    private final AtomicBoolean f19896d = new AtomicBoolean();

    class C17621 implements Runnable {
        final /* synthetic */ StartActivity f19891a;

        C17621(StartActivity startActivity) {
            this.f19891a = startActivity;
        }

        public void run() {
            this.f19891a.m21783a(true);
        }
    }

    static class TokenCallable implements Callable<Void> {
        private final AtomicBoolean f19892a;

        public /* synthetic */ Object call() throws Exception {
            return m21781a();
        }

        TokenCallable(AtomicBoolean atomicBoolean) {
            this.f19892a = atomicBoolean;
        }

        private Void m21781a() throws Exception {
            SessionManager.b().e();
            this.f19892a.set(true);
            return null;
        }
    }

    @android.annotation.SuppressLint({"ResourceType"})
    protected void onCreate(android.os.Bundle r7) {
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
        r6 = this;
        super.onCreate(r7);
        r0 = 2131558435; // 0x7f0d0023 float:1.8742186E38 double:1.053129795E-314;
        r1 = 0;
        r6.setContentView(r0);	 Catch:{ NotFoundException -> 0x000c }
        goto L_0x00b8;
    L_0x000c:
        r0 = r6.getWindow();
        r0 = r0.getWindowStyle();
        r2 = 35;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002e }
        r4 = "Color at 35: ";	 Catch:{ Exception -> 0x002e }
        r3.<init>(r4);	 Catch:{ Exception -> 0x002e }
        r4 = 12345; // 0x3039 float:1.7299E-41 double:6.099E-320;	 Catch:{ Exception -> 0x002e }
        r4 = r0.getColor(r2, r4);	 Catch:{ Exception -> 0x002e }
        r3.append(r4);	 Catch:{ Exception -> 0x002e }
        r3 = r3.toString();	 Catch:{ Exception -> 0x002e }
        com.crashlytics.android.Crashlytics.log(r3);	 Catch:{ Exception -> 0x002e }
        goto L_0x0055;
    L_0x002e:
        r3 = move-exception;
        r4 = new java.lang.StringBuilder;
        r5 = "Threw ";
        r4.<init>(r5);
        r4.append(r3);
        r3 = r4.toString();
        com.crashlytics.android.Crashlytics.log(r3);
        r3 = new java.lang.StringBuilder;
        r4 = "Error getting color at 35, was type: ";
        r3.<init>(r4);
        r4 = r0.getType(r2);
        r3.append(r4);
        r3 = r3.toString();
        com.crashlytics.android.Crashlytics.log(r3);
    L_0x0055:
        r3 = r0.getResourceId(r2, r1);	 Catch:{ Exception -> 0x0084 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0084 }
        r5 = "Reference at 35: ";	 Catch:{ Exception -> 0x0084 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0084 }
        r4.append(r3);	 Catch:{ Exception -> 0x0084 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0084 }
        com.crashlytics.android.Crashlytics.log(r4);	 Catch:{ Exception -> 0x0084 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0084 }
        r5 = "Resource name at 35: ";	 Catch:{ Exception -> 0x0084 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0084 }
        r5 = r6.getResources();	 Catch:{ Exception -> 0x0084 }
        r3 = r5.getResourceName(r3);	 Catch:{ Exception -> 0x0084 }
        r4.append(r3);	 Catch:{ Exception -> 0x0084 }
        r3 = r4.toString();	 Catch:{ Exception -> 0x0084 }
        com.crashlytics.android.Crashlytics.log(r3);	 Catch:{ Exception -> 0x0084 }
        goto L_0x00ab;
    L_0x0084:
        r3 = move-exception;
        r4 = new java.lang.StringBuilder;
        r5 = "Threw ";
        r4.<init>(r5);
        r4.append(r3);
        r3 = r4.toString();
        com.crashlytics.android.Crashlytics.log(r3);
        r3 = new java.lang.StringBuilder;
        r4 = "Error getting reference at 35, was type: ";
        r3.<init>(r4);
        r2 = r0.getType(r2);
        r3.append(r2);
        r2 = r3.toString();
        com.crashlytics.android.Crashlytics.log(r2);
    L_0x00ab:
        r2 = new java.lang.RuntimeException;
        r3 = "1685 Wrong resource exception, tell Steven S";
        r2.<init>(r3);
        com.crashlytics.android.Crashlytics.logException(r2);
        r0.recycle();
    L_0x00b8:
        if (r7 != 0) goto L_0x00bd;
    L_0x00ba:
        com.reddit.frontpage.util.Util.m23998b(r6);
    L_0x00bd:
        r7 = de.greenrobot.event.EventBus.getDefault();
        r7.register(r6);
        r7 = com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil.d(r6);
        if (r7 != 0) goto L_0x00dd;
    L_0x00ca:
        r7 = com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil.c(r6);
        if (r7 != 0) goto L_0x00dd;
    L_0x00d0:
        r7 = f19893a;
        r0 = 1;
        r0 = new java.lang.Object[r0];
        r2 = "Encountered null default account and failed to create one";
        r0[r1] = r2;
        timber.log.Timber.e(r7, r0);
        return;
    L_0x00dd:
        r7 = com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil.d(r6);
        r0 = 2131887088; // 0x7f1203f0 float:1.9408773E38 double:1.053292171E-314;
        r0 = r6.getString(r0);
        com.reddit.frontpage.sync.SyncSchedule.m23256a(r7, r0);
        r7 = com.reddit.datalibrary.frontpage.redditauth.account.AccountUtilKt.a();
        r0 = com.reddit.frontpage.FrontpageApplication.m28875k();
        r0 = r0.mo4632t();
        r0 = r0.a();
        r7 = r7.subscribeOn(r0);
        r7.subscribe();
        r7 = new com.reddit.frontpage.StartActivity$TokenCallable;
        r0 = r6.f19896d;
        r7.<init>(r0);
        bolts.Task.a(r7);
        com.reddit.frontpage.util.AppRater.m23641a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.StartActivity.onCreate(android.os.Bundle):void");
    }

    protected void onResume() {
        super.onResume();
        m21783a(false);
        if (!isFinishing()) {
            this.f19894b.postDelayed(new C17621(this), 3500);
        }
        this.f19895c = true;
    }

    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private void m21783a(boolean z) {
        if (!isFinishing()) {
            if (z || (this.f19896d.get() && System.currentTimeMillis() - FrontpageSettings.a().b.getLong("com.reddit.frontpage.app_config_timestamp", -1) < 86400000)) {
                z = InternalSettings.a();
                Session session = SessionManager.b().c;
                if (!z.g()) {
                    if (session.isAnonymous()) {
                        z = new Intent(this, IntroductionActivity.class);
                        if (!this.f19895c || VERSION.SDK_INT < 21) {
                            startActivity(z);
                        } else {
                            ActivityOptionsCompat a = ActivityOptionsCompat.a(this, findViewById(C1761R.id.launch_logo), "logo");
                            getWindow().setExitTransition(null);
                            startActivity(z, a.a());
                        }
                        ActivityCompat.b(this);
                    }
                }
                startActivity(IntentUtil.m23751a((Context) this, true));
                startService(VideoUploadService.getResumeUploadsIntent(this));
                ActivityCompat.b(this);
            }
        }
    }

    public void onEventMainThread(AppConfigurationUpdatedEvent appConfigurationUpdatedEvent) {
        m21783a((boolean) null);
    }
}
