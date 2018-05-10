package com.instabug.survey;

import android.content.Context;
import android.content.Intent;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugState;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.cache.SurveysCacheManager;
import com.instabug.survey.network.C0800a;
import com.instabug.survey.network.C0800a.C0798a;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p029c.C0796e;
import com.instabug.survey.p029c.C0797f;
import com.instabug.survey.ui.SurveyActivity;
import java.lang.ref.WeakReference;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SurveysManager */
public class C1414a implements C0798a {
    private static C1414a f15583d;
    WeakReference<Context> f15584a;
    C0800a f15585b;
    public boolean f15586c = false;
    private C0797f f15587e;

    private C1414a(Context context) {
        this.f15584a = new WeakReference(context);
        this.f15585b = new C0800a(this);
        this.f15587e = new C0797f(InstabugDeviceProperties.getAppVersion(context), InstabugDeviceProperties.getAppVersionName(context));
    }

    public static C1414a m15478a(Context context) {
        if (f15583d == null) {
            f15583d = new C1414a(context);
        }
        return f15583d;
    }

    public final boolean m15484a() {
        if (Instabug.isEnabled()) {
            try {
                if (!Instabug.getState().equals(InstabugState.ENABLED) || !C0796e.m8412a() || !Instabug.isAppOnForeground()) {
                    return false;
                }
                C1413c c = m15479c();
                if (c == null) {
                    return false;
                }
                m15481a(c);
                return true;
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(C0800a.class.getAnnotations(), e.getMessage(), e);
                return false;
            }
        }
        InstabugSDKLogger.m8356d(C1414a.class, "Instabug SDK is disabled.");
        return false;
    }

    final C1413c m15480a(String str) {
        StringBuilder stringBuilder;
        for (C1413c c1413c : SurveysCacheManager.getSurveys()) {
            if (c1413c.f15572b != null && c1413c.f15572b.equals(str)) {
                stringBuilder = new StringBuilder("Showing survey With token ");
                stringBuilder.append(str);
                InstabugSDKLogger.m8359i(this, stringBuilder.toString());
                return c1413c;
            }
        }
        stringBuilder = new StringBuilder("No Survey With token ");
        stringBuilder.append(str);
        InstabugSDKLogger.m8359i(this, stringBuilder.toString());
        return null;
    }

    public final boolean m15485b() {
        try {
            if (!Instabug.getState().equals(InstabugState.ENABLED) || !C0796e.m8412a()) {
                return false;
            }
            C0797f c0797f = this.f15587e;
            List<C1413c> notAnsweredSurveys = SurveysCacheManager.getNotAnsweredSurveys();
            List arrayList = new ArrayList();
            for (C1413c c1413c : notAnsweredSurveys) {
                if (c0797f.m8422a(c1413c)) {
                    arrayList.add(c1413c);
                }
            }
            if (arrayList.size() > 0) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            InstabugSDKLogger.m8358e(C0800a.class.getAnnotations(), e.getMessage(), e);
            return false;
        }
    }

    public final void mo2623a(Throwable th) {
        InstabugSDKLogger.m8358e(C0800a.class.getAnnotations(), th.getMessage(), th);
    }

    private C1413c m15479c() throws ParseException {
        C0797f c0797f = this.f15587e;
        for (C1413c c1413c : SurveysCacheManager.getNotAnsweredSurveys()) {
            if (c0797f.m8422a(c1413c)) {
                return c1413c;
            }
        }
        return null;
    }

    final void m15481a(C1413c c1413c) {
        if (!(this.f15586c || InstabugCore.isForegroundBusy())) {
            if (Instabug.isEnabled()) {
                C0796e.m8413b();
                Context targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
                if (targetActivity != null) {
                    Intent intent = new Intent(targetActivity, SurveyActivity.class);
                    intent.putExtra("survey", c1413c);
                    targetActivity.startActivity(intent);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2624a(java.util.List<com.instabug.survey.p027a.C1413c> r8) {
        /*
        r7 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r8 = r8.iterator();
    L_0x0009:
        r1 = r8.hasNext();
        if (r1 == 0) goto L_0x007a;
    L_0x000f:
        r1 = r8.next();
        r1 = (com.instabug.survey.p027a.C1413c) r1;
        r2 = com.instabug.survey.cache.SurveysCacheManager.getCache();
        r3 = 0;
        r4 = 1;
        if (r2 == 0) goto L_0x002b;
    L_0x001d:
        r5 = r1.f15571a;
        r5 = java.lang.Long.valueOf(r5);
        r2 = r2.get(r5);
        if (r2 == 0) goto L_0x002b;
    L_0x0029:
        r2 = r4;
        goto L_0x002c;
    L_0x002b:
        r2 = r3;
    L_0x002c:
        if (r2 == 0) goto L_0x0076;
    L_0x002e:
        r2 = com.instabug.survey.cache.SurveysCacheManager.getCache();
        if (r2 == 0) goto L_0x0046;
    L_0x0034:
        r5 = r1.f15571a;
        r5 = java.lang.Long.valueOf(r5);
        r2 = r2.get(r5);
        r2 = (com.instabug.survey.p027a.C1413c) r2;
        r2 = r2.f15578h;
        if (r2 == 0) goto L_0x0046;
    L_0x0044:
        r2 = r4;
        goto L_0x0047;
    L_0x0046:
        r2 = r3;
    L_0x0047:
        if (r2 != 0) goto L_0x0062;
    L_0x0049:
        r2 = com.instabug.survey.cache.SurveysCacheManager.getCache();
        if (r2 == 0) goto L_0x0060;
    L_0x004f:
        r5 = r1.f15571a;
        r5 = java.lang.Long.valueOf(r5);
        r2 = r2.get(r5);
        r2 = (com.instabug.survey.p027a.C1413c) r2;
        r2 = r2.f15581k;
        if (r2 == 0) goto L_0x0060;
    L_0x005f:
        r3 = r4;
    L_0x0060:
        if (r3 == 0) goto L_0x0076;
    L_0x0062:
        r2 = com.instabug.survey.cache.SurveysCacheManager.getCache();
        if (r2 == 0) goto L_0x0009;
    L_0x0068:
        r3 = r1.f15571a;
        r1 = java.lang.Long.valueOf(r3);
        r1 = r2.get(r1);
        r0.add(r1);
        goto L_0x0009;
    L_0x0076:
        r0.add(r1);
        goto L_0x0009;
    L_0x007a:
        r8 = com.instabug.survey.cache.SurveysCacheManager.getCache();
        if (r8 == 0) goto L_0x0083;
    L_0x0080:
        r8.invalidate();
    L_0x0083:
        com.instabug.survey.cache.SurveysCacheManager.addSurveys(r0);
        r8 = com.instabug.library.Instabug.isEnabled();
        if (r8 != 0) goto L_0x0094;
    L_0x008c:
        r8 = com.instabug.survey.C1414a.class;
        r0 = "Instabug SDK is disabled.";
        com.instabug.library.util.InstabugSDKLogger.m8356d(r8, r0);
        return;
    L_0x0094:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        java.lang.Thread.sleep(r0);	 Catch:{ ParseException -> 0x00af, ParseException -> 0x00af }
        r8 = com.instabug.survey.p028b.C0791c.m8402a();	 Catch:{ ParseException -> 0x00af, ParseException -> 0x00af }
        if (r8 == 0) goto L_0x00ae;
    L_0x009f:
        r8 = com.instabug.library.Instabug.isAppOnForeground();	 Catch:{ ParseException -> 0x00af, ParseException -> 0x00af }
        if (r8 == 0) goto L_0x00ae;
    L_0x00a5:
        r8 = r7.m15479c();	 Catch:{ ParseException -> 0x00af, ParseException -> 0x00af }
        if (r8 == 0) goto L_0x00ae;
    L_0x00ab:
        r7.m15481a(r8);	 Catch:{ ParseException -> 0x00af, ParseException -> 0x00af }
    L_0x00ae:
        return;
    L_0x00af:
        r8 = move-exception;
        r0 = com.instabug.survey.network.C0800a.class;
        r0 = r0.getAnnotations();
        r1 = r8.getMessage();
        com.instabug.library.util.InstabugSDKLogger.m8358e(r0, r1, r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.a.a(java.util.List):void");
    }
}
