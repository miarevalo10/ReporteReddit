package com.instabug.bug.settings;

import android.content.Context;
import com.instabug.bug.OnSdkDismissedCallback;
import com.instabug.bug.extendedbugreport.ExtendedBugReport.State;
import com.instabug.bug.model.C0477a;
import com.instabug.bug.model.ReportCategory;
import com.instabug.library.core.InstabugCore;
import java.util.List;

/* compiled from: BugSettings */
public class C0485a {
    private static C0485a f9137a;

    private C0485a() {
    }

    public static void m7795a(Context context) {
        f9137a = new C0485a();
        C0487c.m7831a(context);
        C0486b.m7828a();
    }

    public static C0485a m7793a() {
        if (f9137a == null) {
            f9137a = new C0485a();
        }
        return f9137a;
    }

    public static List<ReportCategory> m7804b() {
        return C0486b.m7829b().f9141c;
    }

    public static void m7802a(List<ReportCategory> list) {
        C0486b.m7829b().f9141c = list;
    }

    public static String m7808c() {
        return C0487c.m7830a().f9150a.getString("ib_remote_report_categories", null);
    }

    public static void m7801a(String str) {
        C0487c.m7830a().f9150a.edit().putString("ib_remote_report_categories", str).apply();
    }

    public static AttachmentsTypesParams m7811d() {
        return C0486b.m7829b().f9140b;
    }

    public static void m7798a(AttachmentsTypesParams attachmentsTypesParams) {
        C0486b.m7829b().f9140b = attachmentsTypesParams;
    }

    public static boolean m7814e() {
        if (!(C0486b.m7829b().f9140b.isAllowTakeExtraScreenshot() || C0486b.m7829b().f9140b.isAllowAttachImageFromGallery())) {
            if (!C0486b.m7829b().f9140b.isAllowScreenRecording()) {
                return false;
            }
        }
        return true;
    }

    public static boolean m7815f() {
        return C0487c.m7830a().f9150a.getBoolean("ib_bugreporting_is_email_required", true);
    }

    public static void m7803a(boolean z) {
        C0487c a = C0487c.m7830a();
        a.f9151b.putBoolean("ib_bugreporting_is_email_required", z);
        a.f9151b.apply();
    }

    public static Runnable m7816g() {
        return C0486b.m7829b().f9144f;
    }

    public static void m7800a(Runnable runnable) {
        C0486b.m7829b().f9144f = runnable;
    }

    public static void m7806b(String str) {
        InstabugCore.setUserEmail(str);
    }

    public static OnSdkDismissedCallback m7817h() {
        return C0486b.m7829b().f9142d;
    }

    public static boolean m7818i() {
        return C0487c.m7830a().f9150a.getBoolean("ib_bugreporting_is_email_enabled", true);
    }

    public static void m7796a(OnSdkDismissedCallback onSdkDismissedCallback) {
        C0486b.m7829b().f9142d = onSdkDismissedCallback;
    }

    public static boolean m7819j() {
        return C0486b.m7829b().f9139a;
    }

    public static void m7807b(boolean z) {
        C0486b.m7829b().f9139a = z;
    }

    public static void m7810c(boolean z) {
        C0487c a = C0487c.m7830a();
        a.f9151b.putBoolean("ib_bugreporting_is_email_enabled", z);
        a.f9151b.apply();
    }

    public static void m7812d(boolean z) {
        C0486b.m7829b().f9143e = z;
    }

    public static boolean m7820k() {
        return C0486b.m7829b().f9143e;
    }

    public static long m7821l() {
        return C0487c.m7830a().f9150a.getLong("last_bug_time", 0);
    }

    public static void m7794a(long j) {
        C0487c.m7830a().f9150a.edit().putLong("last_bug_time", j).apply();
    }

    public static boolean m7822m() {
        return C0487c.m7830a().f9150a.getBoolean("ib_bugreporting_success_dialog_enabled", true);
    }

    public static void m7813e(boolean z) {
        C0487c.m7830a().f9150a.edit().putBoolean("ib_bugreporting_success_dialog_enabled", z).apply();
    }

    public static void m7809c(String str) {
        C0486b.m7829b().f9145g = str;
    }

    public static String m7823n() {
        return C0486b.m7829b().f9145g;
    }

    public static void m7799a(CharSequence charSequence, boolean z) {
        C0486b.m7829b().f9146h.add(new C0477a(charSequence, z));
    }

    public static void m7824o() {
        C0486b.m7829b().f9146h.clear();
    }

    public static List<C0477a> m7825p() {
        return C0486b.m7829b().f9146h;
    }

    public static void m7797a(State state) {
        C0486b.m7829b().f9147i = state;
    }

    public static State m7826q() {
        C0486b b = C0486b.m7829b();
        return b.f9147i == null ? State.DISABLED : b.f9147i;
    }

    public static long m7827r() {
        return C0487c.m7830a().f9150a.getLong("report_categories_fetched_time", 0);
    }

    public static void m7805b(long j) {
        C0487c.m7830a().f9150a.edit().putLong("report_categories_fetched_time", j).apply();
    }
}
