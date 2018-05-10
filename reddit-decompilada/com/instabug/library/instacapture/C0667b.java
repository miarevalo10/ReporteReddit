package com.instabug.library.instacapture;

import android.app.Activity;
import android.graphics.Bitmap;
import com.instabug.library.instacapture.p021a.C0663a;
import com.instabug.library.instacapture.p022b.C0666a;
import com.instabug.library.instacapture.p023c.C0668a;
import com.instabug.library.instacapture.screenshot.C0671a;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/* compiled from: InstaCapture */
public final class C0667b {
    private static C0667b f9594a;
    private C0665a f9595b = new C0665a();
    private C0671a f9596c;

    private C0667b(Activity activity) {
        this.f9595b.m8173a(activity);
        if (this.f9595b.m8172a() == null) {
            C0668a.m8180b("Is your activity running?");
            activity = null;
        } else {
            activity = new C0671a();
        }
        this.f9596c = activity;
    }

    public static C0667b m8176a(Activity activity) {
        synchronized (C0667b.class) {
            if (f9594a == null) {
                f9594a = new C0667b(activity);
            } else {
                f9594a.f9595b.m8173a(activity);
            }
        }
        return f9594a;
    }

    public final void m8177a(final C0666a c0666a, int... iArr) {
        if (this.f9596c != null) {
            Activity a = this.f9595b.m8172a();
            if (a == null) {
                iArr = Observable.b(new C0663a("Is your activity running?"));
            } else {
                iArr = C0671a.m8182a(a, iArr).a(AndroidSchedulers.a());
            }
            Observable.a(new Subscriber<Bitmap>(this) {
                final /* synthetic */ C0667b f18561b;

                public final void m19491b() {
                }

                public final /* synthetic */ void a_(Object obj) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (c0666a != null) {
                        c0666a.mo2585a(bitmap);
                    }
                }

                public final void m19490a(Throwable th) {
                    C0668a.m8180b("Screenshot capture failed");
                    C0668a.m8179a(th);
                    if (c0666a != null) {
                        c0666a.mo2586a(th);
                    }
                }
            }, iArr);
        }
    }
}
