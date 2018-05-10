package com.instabug.bug;

import com.instabug.bug.OnSdkDismissedCallback.DismissType;
import com.instabug.bug.cache.BugsCacheManager;
import com.instabug.bug.extendedbugreport.ExtendedBugReport;
import com.instabug.bug.model.Bug;
import com.instabug.bug.model.Bug.BugState;
import com.instabug.bug.model.C0478b;
import com.instabug.bug.model.ReportCategory;
import com.instabug.bug.settings.AttachmentsTypesParams;
import com.instabug.bug.settings.C0485a;
import com.instabug.bug.settings.C0486b;
import com.instabug.library.OnSdkDismissedCallback;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.bugreporting.model.Bug.Type;
import com.instabug.library.extendedbugreport.ExtendedBugReport.State;
import com.instabug.library.model.BugCategory;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.List;

public class InstabugBugReporting {
    public static void setReportCategories(List<ReportCategory> list) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("reportCategories").setType(ReportCategory.class));
        C0485a.m7793a();
        C0485a.m7802a((List) list);
    }

    private static void setLegacyReportCategories(List<com.instabug.library.bugreporting.model.ReportCategory> list) {
        List arrayList = new ArrayList();
        for (com.instabug.library.bugreporting.model.ReportCategory reportCategory : list) {
            arrayList.add(ReportCategory.getInstance().withIcon(reportCategory.getIcon()).withLabel(reportCategory.getLabel()));
        }
        setReportCategories(arrayList);
    }

    private static void setLegacyBugCategories(List<BugCategory> list) {
        List arrayList = new ArrayList();
        for (BugCategory bugCategory : list) {
            arrayList.add(ReportCategory.getInstance().withIcon(bugCategory.getIcon()).withLabel(bugCategory.getLabel()));
        }
        setReportCategories(arrayList);
    }

    private void updateBugCacheManager() {
        for (Bug bug : BugsCacheManager.getBugs()) {
            if (bug.f15315f == BugState.WAITING_VIDEO) {
                InstabugSDKLogger.m8360v(this, "found the video bug");
                bug.f15315f = BugState.READY_TO_BE_SENT;
                BugsCacheManager.addBug(bug);
                return;
            }
        }
    }

    private static void setLegacyOnSdkDismissedCallback(final OnSdkDismissedCallback onSdkDismissedCallback) throws IllegalStateException {
        setOnSdkDismissedCallback(new OnSdkDismissedCallback() {
            public final void onSdkDismissed(DismissType dismissType, C0478b c0478b) {
                switch (c0478b) {
                    case BUG:
                        c0478b = Type.BUG;
                        break;
                    case FEEDBACK:
                        c0478b = Type.FEEDBACK;
                        break;
                    case NOT_AVAILABLE:
                        c0478b = Type.NOT_AVAILABLE;
                        break;
                    default:
                        c0478b = Type.NOT_AVAILABLE;
                        break;
                }
                switch (dismissType) {
                    case SUBMIT:
                        dismissType = OnSdkDismissedCallback.DismissType.SUBMIT;
                        break;
                    case CANCEL:
                        dismissType = OnSdkDismissedCallback.DismissType.CANCEL;
                        break;
                    case ADD_ATTACHMENT:
                        dismissType = OnSdkDismissedCallback.DismissType.ADD_ATTACHMENT;
                        break;
                    default:
                        dismissType = OnSdkDismissedCallback.DismissType.CANCEL;
                        break;
                }
                onSdkDismissedCallback.onSdkDismissed(dismissType, c0478b);
            }
        });
    }

    public static void setOnSdkDismissedCallback(OnSdkDismissedCallback onSdkDismissedCallback) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("onSdkDismissedCallback").setType(OnSdkDismissedCallback.class));
        C0485a.m7793a();
        C0485a.m7796a(onSdkDismissedCallback);
    }

    public static void setAttachmentTypesEnabled(boolean z, boolean z2, boolean z3, boolean z4) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("initialScreenshot").setType(Boolean.class).setValue(Boolean.toString(z)), new Parameter().setName("extraScreenshot").setType(Boolean.class).setValue(Boolean.toString(z2)), new Parameter().setName("galleryImage").setType(Boolean.class).setValue(Boolean.toString(z3)), new Parameter().setName("screenRecording").setType(Boolean.class).setValue(Boolean.toString(z4)));
        AttachmentsTypesParams attachmentsTypesParams = new AttachmentsTypesParams(z, z2, z3, z4);
        C0485a.m7793a();
        C0485a.m7798a(attachmentsTypesParams);
    }

    public static void setPreSendingRunnable(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("runnable").setType(Runnable.class));
        C0485a.m7793a();
        C0485a.m7800a(runnable);
    }

    public static Runnable getPreSendingRunnable() {
        return C0486b.m7829b().f9144f;
    }

    public static void setShouldSkipInitialScreenshotAnnotation(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("willSkipInitialScreenshotAnnotating").setType(Boolean.class).setValue(Boolean.toString(z)));
        C0485a.m7793a();
        C0485a.m7807b(z);
    }

    public static void setEmailFieldRequired(boolean z) {
        C0485a.m7793a();
        C0485a.m7803a(z);
    }

    public static void setEmailFieldVisibility(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("emailFieldVisibility").setType(Boolean.class).setValue(Boolean.toString(z)));
        C0485a.m7793a();
        C0485a.m7810c(z);
    }

    public static void setCommentFieldRequired(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("commentFieldRequired").setType(Boolean.class).setValue(Boolean.toString(z)));
        C0485a.m7793a();
        C0485a.m7812d(z);
    }

    public static void setSuccessDialogEnabled(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("enabled").setType(Boolean.class).setValue(Boolean.toString(z)));
        C0485a.m7793a();
        C0485a.m7813e(z);
    }

    public static void openNewFeedback() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0467a.m7734b();
    }

    public static void openNewBugReport() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0467a.m7738c();
    }

    public static void addExtraReportField(CharSequence charSequence, boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("fieldHint").setType(CharSequence.class).setValue(charSequence), new Parameter().setName("required").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0485a.m7793a();
        C0485a.m7799a(charSequence, z);
    }

    public static void clearExtraReportFields() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0485a.m7793a();
        C0485a.m7824o();
    }

    public static void setExtendedBugReportState(State state) {
        ExtendedBugReport.State state2;
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        switch (state) {
            case ENABLED_WITH_REQUIRED_FIELDS:
                state2 = ExtendedBugReport.State.ENABLED_WITH_REQUIRED_FIELDS;
                break;
            case ENABLED_WITH_OPTIONAL_FIELDS:
                state2 = ExtendedBugReport.State.ENABLED_WITH_OPTIONAL_FIELDS;
                break;
            default:
                state2 = ExtendedBugReport.State.DISABLED;
                break;
        }
        C0485a.m7793a();
        C0485a.m7797a(state2);
    }
}
