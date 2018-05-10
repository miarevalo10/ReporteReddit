package com.instabug.library.visualusersteps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.Session;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.screenshot.C0753a;
import com.instabug.library.screenshot.C0753a.C0752a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.BitmapUtils.C0771a;
import com.instabug.library.util.DiskUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.C0781a.C0780a;
import java.io.File;
import java.util.List;
import rx.functions.Action1;

/* compiled from: VisualUserStepsProvider */
public class C0786d {
    private static int f9941b;
    private static C0786d f9942c;
    public C0784c f9943a = new C0784c();

    /* compiled from: VisualUserStepsProvider */
    class C14061 implements Action1<List<File>> {
        final /* synthetic */ C0786d f15556a;

        C14061(C0786d c0786d) {
            this.f15556a = c0786d;
        }

        public final /* synthetic */ void m15464a(Object obj) {
            List list = (List) obj;
            if (list != null && list.isEmpty() == null) {
                InstabugSDKLogger.m8361w(C0786d.class, "Can't clean visual user steps directory");
            }
        }
    }

    /* compiled from: VisualUserStepsProvider */
    class C14072 implements Action1<SDKCoreEvent> {
        final /* synthetic */ C0786d f15557a;

        C14072(C0786d c0786d) {
            this.f15557a = c0786d;
        }

        public final /* synthetic */ void m15465a(Object obj) {
            SDKCoreEvent sDKCoreEvent = (SDKCoreEvent) obj;
            if (sDKCoreEvent.getType().equals(Session.TYPE_SESSION) && sDKCoreEvent.getValue().equals(Session.VALUE_FINISHED) != null) {
                this.f15557a.m8393b();
            }
        }
    }

    private C0786d() {
        DiskUtils.getCleanDirectoryObservable(VisualUserStepsHelper.getVisualUserStepsDirectory(Instabug.getApplicationContext())).a(new C14061(this));
        SDKCoreEventSubscriber.subscribe(new C14072(this));
    }

    public static C0786d m8386a() {
        if (f9942c == null) {
            f9942c = new C0786d();
        }
        return f9942c;
    }

    public final void m8392a(String str, String str2, String str3) {
        if (!InstabugCore.isForegroundBusy()) {
            Object obj = -1;
            int hashCode = str.hashCode();
            if (hashCode != -1853253192) {
                if (hashCode != -1784260441) {
                    if (hashCode != -353343821) {
                        if (hashCode == 1761507048) {
                            if (str.equals("fragment_resumed")) {
                                obj = 3;
                            }
                        }
                    } else if (str.equals("fragment_attached")) {
                        obj = 1;
                    }
                } else if (str.equals("activity_resumed")) {
                    obj = 2;
                }
            } else if (str.equals("activity_created")) {
                obj = null;
            }
            switch (obj) {
                case null:
                case 1:
                    m8390a(str2);
                    break;
                case 2:
                case 3:
                    if (this.f9943a.m8383a().f9920e) {
                        m8390a(str2);
                    }
                    if (SettingsManager.getInstance().isReproStepsScreenshotEnabled()) {
                        final Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
                        new Handler().postDelayed(new Runnable(this) {
                            final /* synthetic */ C0786d f9940b;

                            /* compiled from: VisualUserStepsProvider */
                            class C14081 implements C0752a {
                                final /* synthetic */ C07853 f15558a;

                                C14081(C07853 c07853) {
                                    this.f15558a = c07853;
                                }

                                public final void mo2583a(Bitmap bitmap) {
                                    C0786d.m8388a(this.f15558a.f9940b, targetActivity, bitmap);
                                }

                                public final void mo2584a(Throwable th) {
                                    StringBuilder stringBuilder = new StringBuilder("capturing VisualUserStep failed error: ");
                                    stringBuilder.append(th.getMessage());
                                    stringBuilder.append(", time in MS: ");
                                    stringBuilder.append(System.currentTimeMillis());
                                    InstabugSDKLogger.m8358e(C0786d.class, stringBuilder.toString(), th);
                                }
                            }

                            public void run() {
                                C0753a.m8313a(targetActivity, new C14081(this));
                            }
                        }, 500);
                    }
                    m8391b(str, str2, str3);
                    return;
                default:
                    break;
            }
            m8391b(str, str2, str3);
        }
    }

    private void m8390a(String str) {
        C0784c c0784c = this.f9943a;
        int i = f9941b + 1;
        f9941b = i;
        c0784c.f9937a.add(new C0781a(String.valueOf(i), str));
    }

    private void m8391b(String str, String str2, String str3) {
        if (this.f9943a.m8383a() == null) {
            m8390a(str2);
        }
        C0784c c0784c = this.f9943a;
        str = C0783b.m8378a(str);
        str.f9922b = str2;
        str.f9921a = this.f9943a.m8383a().f9916a;
        str.f9926f = str3;
        str = str.m8377a();
        str2 = c0784c.m8383a();
        str2.f9919d.add(str);
        if (!(str.f9929a.equals("activity_resumed") == null && str.f9929a.equals("fragment_resumed") == null)) {
            str2.f9920e = true;
        }
        c0784c.f9938b += 1;
    }

    public final void m8393b() {
        if (SettingsManager.getInstance().isReproStepsScreenshotEnabled() && this.f9943a.f9937a.size() > 20) {
            int size = this.f9943a.f9937a.size() - 20;
            C0784c c0784c = this.f9943a;
            for (int i = 0; i < size; i++) {
                c0784c.m8385c();
            }
        }
        while (this.f9943a.f9938b > 100) {
            C0784c c0784c2 = this.f9943a;
            if (c0784c2.m8384b().f9919d.size() > 1) {
                c0784c2.f9938b--;
                c0784c2.m8384b().f9919d.removeFirst();
            } else {
                c0784c2.m8385c();
            }
        }
    }

    static /* synthetic */ void m8388a(C0786d c0786d, final Activity activity, Bitmap bitmap) {
        File visualUserStepsDirectory = VisualUserStepsHelper.getVisualUserStepsDirectory(activity);
        StringBuilder stringBuilder = new StringBuilder("step");
        stringBuilder.append(c0786d.f9943a.m8383a().f9916a);
        BitmapUtils.saveBitmapAsPNG(bitmap, 70, visualUserStepsDirectory, stringBuilder.toString(), new C0771a(c0786d) {
            final /* synthetic */ C0786d f15560b;

            public final void mo2581a(Uri uri) {
                C0780a c0780a = new C0780a(uri.getLastPathSegment());
                if (activity == null || activity.getResources().getConfiguration().orientation != 2) {
                    c0780a.f9915b = "portrait";
                } else {
                    c0780a.f9915b = "landscape";
                }
                this.f15560b.f9943a.m8383a().f9918c = c0780a;
            }

            public final void mo2582a(Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("capturing VisualUserStep failed error: ");
                stringBuilder.append(th.getMessage());
                stringBuilder.append(", time in MS: ");
                stringBuilder.append(System.currentTimeMillis());
                InstabugSDKLogger.m8358e(C0786d.class, stringBuilder.toString(), th);
            }
        });
    }
}
