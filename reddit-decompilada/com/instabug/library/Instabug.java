package com.instabug.library;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import com.instabug.library.Feature.State;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.bugreporting.model.ReportCategory;
import com.instabug.library.core.plugin.C0657a;
import com.instabug.library.extendedbugreport.ExtendedBugReport;
import com.instabug.library.internal.layer.CapturableView;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.invocation.C0731c;
import com.instabug.library.invocation.C1381b;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InstabugInvocationMode;
import com.instabug.library.invocation.Invocation;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.invocation.util.InstabugVideoRecordingButtonCorner;
import com.instabug.library.logging.InstabugLog;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.BugCategory;
import com.instabug.library.p020c.C0650a;
import com.instabug.library.p020c.C0651b;
import com.instabug.library.p020c.C0652c;
import com.instabug.library.p020c.C0653d;
import com.instabug.library.settings.AttachmentsTypesParams;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.user.C0770a;
import com.instabug.library.user.UserEventParam;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.OrientationUtils;
import com.instabug.library.util.StringUtility;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.hockeyapp.android.UpdateFragment;

public class Instabug {
    private static InstabugState INSTABUG_STATE = InstabugState.NOT_BUILT;
    private static Instabug INSTANCE;
    private C1341a delegate;

    @SuppressFBWarnings({"URF_UNREAD_FIELD"})
    public static class Builder {
        private Application application;
        private Context applicationContext;
        private String applicationToken;
        private AttachmentsTypesParams attachmentsTypesParams;
        private boolean bugPromptOptionEnable;
        private boolean chatPromptOptionEnable;
        private boolean commentFieldRequired;
        private State consoleLogState;
        private State crashReportingState;
        private int defaultInvocationMode;
        private boolean emailFieldRequired;
        private boolean emailFieldVisibility;
        private boolean feedbackPromptOptionEnable;
        private int floatingButtonOffsetFromTop;
        private State inAppMessagingState;
        private InstabugFloatingButtonEdge instabugFloatingButtonEdge;
        private InstabugInvocationEvent instabugInvocationEvent;
        private Locale instabugLocale;
        private State instabugLogState;
        private int instabugPrimaryColor;
        private int instabugStatusBarColor;
        private InstabugColorTheme instabugTheme;
        private boolean introMessageEnabled;
        private boolean isSurveysAutoShowing;
        private int notificationIcon;
        private boolean playInAppNotificationSound;
        private boolean playSystemNotificationSound;
        private State pushNotificationState;
        private com.instabug.library.visualusersteps.State reproStepsState;
        private int shakingThreshold;
        private boolean shouldPlaySounds;
        private boolean successDialogEnabled;
        private State surveysState;
        private State trackingUserStepsState;
        private State userDataState;
        private State userEventsState;
        private State viewHierarchyState;
        private boolean willSkipInitialScreenshotAnnotating;

        public Builder(Application application, String str) {
            this(application, str, InstabugInvocationEvent.SHAKE);
        }

        public Builder(Application application, String str, InstabugInvocationEvent instabugInvocationEvent) {
            this(application.getApplicationContext(), str, instabugInvocationEvent);
            this.application = application;
        }

        Builder(Context context, String str, InstabugInvocationEvent instabugInvocationEvent) {
            this.instabugTheme = InstabugColorTheme.InstabugColorThemeLight;
            this.instabugPrimaryColor = -15893761;
            this.instabugStatusBarColor = -3815737;
            this.instabugInvocationEvent = InstabugInvocationEvent.SHAKE;
            this.defaultInvocationMode = 0;
            this.userDataState = C0645b.f9574a;
            this.consoleLogState = C0645b.f9574a;
            this.instabugLogState = C0645b.f9574a;
            this.inAppMessagingState = C0645b.f9574a;
            this.crashReportingState = C0645b.f9574a;
            this.pushNotificationState = C0645b.f9574a;
            this.trackingUserStepsState = C0645b.f9574a;
            this.reproStepsState = com.instabug.library.visualusersteps.State.ENABLED;
            this.viewHierarchyState = C0645b.f9574a;
            this.surveysState = C0645b.f9574a;
            this.userEventsState = C0645b.f9574a;
            this.emailFieldRequired = true;
            this.emailFieldVisibility = true;
            this.attachmentsTypesParams = new AttachmentsTypesParams();
            this.willSkipInitialScreenshotAnnotating = false;
            this.commentFieldRequired = false;
            this.introMessageEnabled = true;
            this.shouldPlaySounds = false;
            this.successDialogEnabled = true;
            this.instabugFloatingButtonEdge = InstabugFloatingButtonEdge.RIGHT;
            this.shakingThreshold = 350;
            this.floatingButtonOffsetFromTop = -1;
            this.instabugLocale = Locale.getDefault();
            this.isSurveysAutoShowing = true;
            this.chatPromptOptionEnable = true;
            this.bugPromptOptionEnable = true;
            this.feedbackPromptOptionEnable = true;
            this.applicationContext = context;
            this.instabugInvocationEvent = instabugInvocationEvent;
            this.applicationToken = str;
        }

        @Deprecated
        public Builder setInvocationEvent(IBGInvocationEvent iBGInvocationEvent) {
            AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("invocationEvent").setType(IBGInvocationEvent.class).setValue(iBGInvocationEvent));
            switch (iBGInvocationEvent) {
                case IBGInvocationEventNone:
                    setInvocationEvent(InstabugInvocationEvent.NONE);
                    break;
                case IBGInvocationEventShake:
                    setInvocationEvent(InstabugInvocationEvent.SHAKE);
                    break;
                case IBGInvocationEventFloatingButton:
                    setInvocationEvent(InstabugInvocationEvent.FLOATING_BUTTON);
                    break;
                case IBGInvocationEventTwoFingersSwipeLeft:
                    setInvocationEvent(InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT);
                    break;
                case IBGInvocationScreenshotGesture:
                    setInvocationEvent(InstabugInvocationEvent.SCREENSHOT_GESTURE);
                    break;
                default:
                    break;
            }
            return this;
        }

        public Builder setInvocationEvent(InstabugInvocationEvent instabugInvocationEvent) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugInvocationEvent").setType(InstabugInvocationEvent.class).setValue(instabugInvocationEvent));
            this.instabugInvocationEvent = instabugInvocationEvent;
            return this;
        }

        @Deprecated
        public Builder setShouldPlayConversationSounds(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySounds").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.shouldPlaySounds = z;
            return this;
        }

        @Deprecated
        public Builder setEnableSystemNotificationSound(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySound").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.playSystemNotificationSound = z;
            return this;
        }

        @Deprecated
        public Builder setEnableInAppNotificationSound(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySound").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.playInAppNotificationSound = z;
            return this;
        }

        @Deprecated
        public Builder setDefaultInvocationMode(IBGInvocationMode iBGInvocationMode) {
            AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("invocationMode").setType(IBGInvocationMode.class).setValue(iBGInvocationMode));
            switch (iBGInvocationMode) {
                case IBGInvocationModeNA:
                    this.defaultInvocationMode = 0;
                    break;
                case IBGInvocationModeBugReporter:
                    this.defaultInvocationMode = 1;
                    break;
                case IBGInvocationModeFeedbackSender:
                    this.defaultInvocationMode = 2;
                    break;
                default:
                    break;
            }
            return this;
        }

        @Deprecated
        public Builder setPromptOptionsEnabled(boolean z, boolean z2, boolean z3) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("chat").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)), new Parameter().setName("bug").setType(Boolean.TYPE).setValue(Boolean.valueOf(z2)), new Parameter().setName("feedback").setType(Boolean.TYPE).setValue(Boolean.toString(z3)));
            this.chatPromptOptionEnable = z;
            this.bugPromptOptionEnable = z2;
            this.feedbackPromptOptionEnable = z3;
            return this;
        }

        @Deprecated
        public Builder setShakingThreshold(int i) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("threshold").setType(Integer.TYPE).setValue(Integer.toString(i)));
            this.shakingThreshold = i;
            return this;
        }

        @Deprecated
        public Builder setShouldShowIntroDialog(boolean z) {
            AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("enabled").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.introMessageEnabled = z;
            return this;
        }

        @Deprecated
        public Builder setSuccessDialogEnabled(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("enabled").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.successDialogEnabled = z;
            return this;
        }

        @Deprecated
        public Builder setIntroMessageEnabled(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("enabled").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.introMessageEnabled = z;
            return this;
        }

        public Builder setTrackingUserStepsState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.trackingUserStepsState = state;
            return this;
        }

        public Builder setReproStepsState(com.instabug.library.visualusersteps.State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(com.instabug.library.visualusersteps.State.class).setValue(state));
            this.reproStepsState = state;
            return this;
        }

        public Builder setPushNotificationState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.pushNotificationState = state;
            return this;
        }

        public Builder setConsoleLogState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.consoleLogState = state;
            return this;
        }

        public Builder setCrashReportingState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.crashReportingState = state;
            return this;
        }

        public Builder setInstabugLogState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.instabugLogState = state;
            return this;
        }

        public Builder setUserDataState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.userDataState = state;
            return this;
        }

        public Builder setInAppMessagingState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.inAppMessagingState = state;
            return this;
        }

        public Builder setViewHierarchyState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.viewHierarchyState = state;
            return this;
        }

        public Builder setSurveysState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.surveysState = state;
            return this;
        }

        public Builder setUserEventsState(State state) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
            this.userEventsState = state;
            return this;
        }

        @Deprecated
        public Builder setCommentFieldRequired(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("commentFieldRequired").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.commentFieldRequired = z;
            return this;
        }

        @Deprecated
        public Builder setEmailFieldRequired(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("emailFieldRequired").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.emailFieldRequired = z;
            return this;
        }

        @Deprecated
        public Builder setEmailFieldVisibility(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("emailFieldVisibility").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.emailFieldVisibility = z;
            return this;
        }

        @Deprecated
        public Builder setWillTakeScreenshot(boolean z) throws IllegalStateException {
            AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("willTakeInitialScreenshot").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.attachmentsTypesParams.setShouldTakesInitialScreenshot(z);
            return this;
        }

        @Deprecated
        public Builder setAttachmentTypesEnabled(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("initialScreenshot").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)), new Parameter().setName("extraScreenshot").setType(Boolean.TYPE).setValue(Boolean.valueOf(z2)), new Parameter().setName("galleryImage").setType(Boolean.TYPE).setValue(Boolean.valueOf(z3)), new Parameter().setName("voiceNote").setType(Boolean.TYPE).setValue(Boolean.valueOf(z4)), new Parameter().setName("screenRecording").setType(Boolean.TYPE).setValue(Boolean.valueOf(z5)));
            this.attachmentsTypesParams.setShouldTakesInitialScreenshot(z).setAllowTakeExtraScreenshot(z2).setAllowAttachImageFromGallery(z3).setAllowScreenRecording(z5);
            return this;
        }

        @Deprecated
        public Builder setWillSkipScreenshotAnnotation(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("willSkipInitialScreenshotAnnotating").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.willSkipInitialScreenshotAnnotating = z;
            return this;
        }

        @Deprecated
        public Builder setColorTheme(IBGColorTheme iBGColorTheme) {
            AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("theme").setType(IBGColorTheme.class).setValue(iBGColorTheme));
            switch (iBGColorTheme) {
                case IBGColorThemeDark:
                    this.instabugTheme = InstabugColorTheme.InstabugColorThemeDark;
                    this.instabugPrimaryColor = -9580554;
                    break;
                case IBGColorThemeLight:
                    this.instabugTheme = InstabugColorTheme.InstabugColorThemeLight;
                    this.instabugPrimaryColor = -15893761;
                    break;
                case theme:
                    this.instabugTheme = InstabugColorTheme.InstabugColorThemeLight;
                    this.instabugPrimaryColor = -15893761;
                    break;
                default:
                    break;
            }
            return this;
        }

        @Deprecated
        public Builder setTheme(InstabugColorTheme instabugColorTheme) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugTheme").setType(InstabugColorTheme.class).setValue(instabugColorTheme));
            this.instabugTheme = instabugColorTheme;
            switch (instabugColorTheme) {
                case InstabugColorThemeDark:
                    this.instabugPrimaryColor = -9580554;
                    this.instabugStatusBarColor = -16119286;
                    break;
                case InstabugColorThemeLight:
                    this.instabugPrimaryColor = -15893761;
                    this.instabugStatusBarColor = -3815737;
                    break;
                default:
                    break;
            }
            return this;
        }

        @Deprecated
        public Builder setFloatingButtonEdge(IBGFloatingButtonEdge iBGFloatingButtonEdge) {
            AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("floatingButtonEdge").setType(IBGFloatingButtonEdge.class).setValue(iBGFloatingButtonEdge));
            switch (iBGFloatingButtonEdge) {
                case Right:
                    setFloatingButtonEdge(InstabugFloatingButtonEdge.RIGHT);
                    break;
                case Left:
                    setFloatingButtonEdge(InstabugFloatingButtonEdge.LEFT);
                    break;
                default:
                    break;
            }
            return this;
        }

        @Deprecated
        public Builder setFloatingButtonEdge(InstabugFloatingButtonEdge instabugFloatingButtonEdge) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugFloatingButtonEdge").setType(IBGFloatingButtonEdge.class).setValue(instabugFloatingButtonEdge));
            this.instabugFloatingButtonEdge = instabugFloatingButtonEdge;
            return this;
        }

        @Deprecated
        public Builder setFloatingButtonOffsetFromTop(int i) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("floatingButtonOffsetFromTop").setType(Integer.TYPE).setValue(Integer.toString(i)));
            this.floatingButtonOffsetFromTop = i;
            return this;
        }

        @Deprecated
        public Builder setLocale(Locale locale) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName(com.instabug.library.model.State.KEY_LOCALE).setType(Locale.class).setValue(locale));
            this.instabugLocale = locale;
            return this;
        }

        @Deprecated
        public Builder setNotificationIcon(int i) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("notificationIcon").setType(Integer.TYPE));
            this.notificationIcon = i;
            return this;
        }

        @Deprecated
        public Builder setSurveysAutoShowing(boolean z) {
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("isSurveysAutoShowing").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
            this.isSurveysAutoShowing = z;
            return this;
        }

        public Instabug build(State state) {
            boolean z = true;
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugInitialState").setType(State.class).setValue(state));
            SettingsManager.init(this.applicationContext);
            if (state != State.ENABLED) {
                z = false;
            }
            setFeaturesStates(Boolean.valueOf(z));
            state = new C1341a(this.applicationContext);
            Instabug.INSTANCE = new Instabug(state);
            Instabug.setState(InstabugState.BUILT);
            InstabugInternalTrackingDelegate.init(this.application);
            SettingsManager.getInstance().setAppToken(this.applicationToken);
            SettingsManager.getInstance().setIntroMessageEnabled(this.introMessageEnabled);
            state.m15339a();
            SettingsManager.getInstance().setInstabugLocale(this.instabugLocale);
            SettingsManager.getInstance().setTheme(this.instabugTheme);
            SettingsManager.getInstance().setPrimaryColor(this.instabugPrimaryColor);
            SettingsManager.getInstance().setStatusBarColor(this.instabugStatusBarColor);
            C0650a.m8122a(this.attachmentsTypesParams.isShouldTakesInitialScreenshot(), this.attachmentsTypesParams.isAllowTakeExtraScreenshot(), this.attachmentsTypesParams.isAllowAttachImageFromGallery(), this.attachmentsTypesParams.isAllowScreenRecording());
            C0650a.m8125b(this.emailFieldRequired);
            C0650a.m8127d(this.emailFieldVisibility);
            C0650a.m8121a(this.willSkipInitialScreenshotAnnotating);
            C0650a.m8128e(this.successDialogEnabled);
            C1381b.m15431c().m15438a(this.instabugInvocationEvent);
            Instabug.setPromptOptionsEnabled(this.chatPromptOptionEnable, this.bugPromptOptionEnable, this.feedbackPromptOptionEnable);
            C1381b.m15431c().f15516a.f9782b = this.defaultInvocationMode;
            C1381b.m15431c().f15516a.m8286b(this.shakingThreshold);
            C1381b.m15431c().f15516a.m8285a(this.instabugFloatingButtonEdge);
            if (this.floatingButtonOffsetFromTop != -1) {
                C1381b.m15431c().f15516a.m8284a(this.floatingButtonOffsetFromTop);
            }
            C0650a.m8126c(this.commentFieldRequired);
            C0651b.m8141b(this.shouldPlaySounds);
            C0651b.m8142c(this.playSystemNotificationSound);
            C0651b.m8143d(this.playInAppNotificationSound);
            C0651b.m8130a(this.notificationIcon);
            C0651b.m8135a(this.attachmentsTypesParams.isAllowTakeExtraScreenshot(), this.attachmentsTypesParams.isAllowAttachImageFromGallery(), this.attachmentsTypesParams.isAllowScreenRecording());
            C0651b.m8144e(this.willSkipInitialScreenshotAnnotating);
            C0653d.m8148a(this.isSurveysAutoShowing);
            return Instabug.INSTANCE;
        }

        public Instabug build() {
            if (Instabug.isBuilt()) {
                if (InternalScreenRecordHelper.getInstance().isRecording()) {
                    InternalScreenRecordHelper.getInstance().cancel();
                }
                Instabug.disable();
            }
            AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
            return build(State.ENABLED);
        }

        private void setFeaturesStates(Boolean bool) {
            StringBuilder stringBuilder = new StringBuilder("Setting user data feature state ");
            stringBuilder.append(this.userDataState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.USER_DATA, this.userDataState);
            stringBuilder = new StringBuilder("Setting console log feature state ");
            stringBuilder.append(this.consoleLogState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.CONSOLE_LOGS, this.consoleLogState);
            stringBuilder = new StringBuilder("Setting Instabug logs feature state ");
            stringBuilder.append(this.instabugLogState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.INSTABUG_LOGS, this.instabugLogState);
            stringBuilder = new StringBuilder("Setting crash reporting feature state ");
            stringBuilder.append(this.crashReportingState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.CRASH_REPORTING, this.crashReportingState);
            stringBuilder = new StringBuilder("Setting in-app messaging feature state ");
            stringBuilder.append(this.inAppMessagingState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.IN_APP_MESSAGING, this.inAppMessagingState);
            stringBuilder = new StringBuilder("Setting push notification feature state ");
            stringBuilder.append(this.pushNotificationState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.PUSH_NOTIFICATION, this.pushNotificationState);
            stringBuilder = new StringBuilder("Setting tracking user steps feature state ");
            stringBuilder.append(this.trackingUserStepsState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.TRACK_USER_STEPS, this.trackingUserStepsState);
            stringBuilder = new StringBuilder("Setting repro steps feature state ");
            stringBuilder.append(this.reproStepsState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            setReproStepsState();
            stringBuilder = new StringBuilder("Setting view hierarchy  feature state ");
            stringBuilder.append(this.viewHierarchyState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.VIEW_HIERARCHY, this.viewHierarchyState);
            stringBuilder = new StringBuilder("Setting surveys feature state ");
            stringBuilder.append(this.surveysState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.SURVEYS, this.surveysState);
            stringBuilder = new StringBuilder("Setting user events feature state ");
            stringBuilder.append(this.userEventsState);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8110a(Feature.USER_EVENTS, this.userEventsState);
            stringBuilder = new StringBuilder("Setting instabug overall state ");
            stringBuilder.append(bool);
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0645b.m8104a().m8111a(Feature.INSTABUG, bool.booleanValue());
        }

        private void setReproStepsState() {
            if (this.reproStepsState == com.instabug.library.visualusersteps.State.ENABLED) {
                C0645b.m8104a().m8110a(Feature.REPRO_STEPS, State.ENABLED);
                SettingsManager.getInstance().setReproStepsScreenshotEnabled(true);
            } else if (this.reproStepsState == com.instabug.library.visualusersteps.State.ENABLED_WITH_NO_SCREENSHOTS) {
                C0645b.m8104a().m8110a(Feature.REPRO_STEPS, State.ENABLED);
                SettingsManager.getInstance().setReproStepsScreenshotEnabled(false);
            } else {
                if (this.reproStepsState == com.instabug.library.visualusersteps.State.DISABLED) {
                    C0645b.m8104a().m8110a(Feature.REPRO_STEPS, State.DISABLED);
                }
            }
        }
    }

    @Deprecated
    public static void setShouldAudioRecordingOptionAppear(boolean z) throws IllegalStateException {
    }

    @Deprecated
    static boolean shouldAudioRecordingOptionAppear() throws IllegalStateException {
        return false;
    }

    private Instabug(C1341a c1341a) {
        this.delegate = c1341a;
    }

    static Instabug getInstance() throws IllegalStateException {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        throw new IllegalStateException("Instabug getInstance called before Instabug.Builder().build() was called");
    }

    public static Context getApplicationContext() {
        return getInstance().delegate.m15342c();
    }

    public static void setDebugEnabled(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("isDebugEnabled").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        SettingsManager.getInstance().setDebugEnabled(z);
    }

    @Deprecated
    public static void changeInvocationEvent(IBGInvocationEvent iBGInvocationEvent) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("invocationEvent").setType(IBGInvocationEvent.class).setValue(iBGInvocationEvent));
        switch (iBGInvocationEvent) {
            case IBGInvocationEventNone:
                changeInvocationEvent(InstabugInvocationEvent.NONE);
                return;
            case IBGInvocationEventShake:
                changeInvocationEvent(InstabugInvocationEvent.SHAKE);
                return;
            case IBGInvocationEventFloatingButton:
                changeInvocationEvent(InstabugInvocationEvent.FLOATING_BUTTON);
                return;
            case IBGInvocationEventTwoFingersSwipeLeft:
                changeInvocationEvent(InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT);
                return;
            case IBGInvocationScreenshotGesture:
                changeInvocationEvent(InstabugInvocationEvent.SCREENSHOT_GESTURE);
                break;
            default:
                break;
        }
    }

    public static void changeInvocationEvent(InstabugInvocationEvent instabugInvocationEvent) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugInvocationEvent").setType(InstabugInvocationEvent.class).setValue(instabugInvocationEvent));
        C1381b.m15431c().m15438a(instabugInvocationEvent);
    }

    @Deprecated
    public static void setDialog(Dialog dialog) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName(UpdateFragment.FRAGMENT_DIALOG).setType(Dialog.class));
    }

    @Deprecated
    public static void addMapView(View view, Object obj) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter[]{new Parameter().setName("mapView").setType(View.class), new Parameter().setName("googleMap").setType(Object.class)});
    }

    @Deprecated
    public static void addCapturableView(CapturableView capturableView) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("capturableView").setType(CapturableView.class));
    }

    @Deprecated
    public static void setGLSurfaceView(GLSurfaceView gLSurfaceView) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("surfaceView").setType(GLSurfaceView.class));
    }

    public static void invoke() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C1381b.m15431c().m15440e();
    }

    @Deprecated
    public static void invokeConversations() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter[0]);
        invoke(InstabugInvocationMode.CHATS_LIST);
    }

    @Deprecated
    public static void invoke(IBGInvocationMode iBGInvocationMode) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("invocationMode").setType(IBGInvocationMode.class).setValue(iBGInvocationMode));
        switch (iBGInvocationMode) {
            case IBGInvocationModeNA:
                invoke(InstabugInvocationMode.PROMPT_OPTION);
                return;
            case IBGInvocationModeBugReporter:
                invoke(InstabugInvocationMode.NEW_BUG);
                return;
            case IBGInvocationModeFeedbackSender:
                invoke(InstabugInvocationMode.NEW_FEEDBACK);
                break;
            default:
                break;
        }
    }

    public static void invoke(InstabugInvocationMode instabugInvocationMode) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugInvocationMode").setType(InstabugInvocationMode.class).setValue(instabugInvocationMode.toString()));
        switch (instabugInvocationMode) {
            case NEW_BUG:
                C1381b.m15431c().m15435a(1);
                return;
            case NEW_FEEDBACK:
                C1381b.m15431c().m15435a(2);
                return;
            case NEW_CHAT:
                C1381b.m15431c().m15435a(3);
                return;
            case CHATS_LIST:
                C1381b.m15431c().m15435a(4);
                return;
            default:
                C1381b.m15431c().m15435a(0);
                return;
        }
    }

    public static void setDefaultInvocationMode(int i) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("setDefaultInvocationMode").setType(Invocation.class).setValue(Integer.valueOf(i)));
        C1381b.m15431c().f15516a.f9782b = i;
    }

    public static void resetDefaultInvocationMode() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C1381b.m15431c().f15516a.f9782b = 0;
    }

    @Deprecated
    public static void log(String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedLoggingApiUsage(new Parameter().setName("message").setType(String.class));
        if (C0645b.m8104a().m8113b(Feature.INSTABUG_LOGS) == State.ENABLED) {
            InstabugLog.m8288d(str);
        }
    }

    @Deprecated
    public static void clearLog() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedLoggingApiUsage(new Parameter[0]);
        InstabugLog.clearLogs();
    }

    public static void showIntroMessage() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        getInstance().delegate.m15341b();
    }

    public static void reportException(Throwable th) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("throwable").setType(Throwable.class));
        reportException(th, null);
    }

    public static void reportException(Throwable th, String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("throwable").setType(Throwable.class), new Parameter().setName("exceptionIdentifier").setType(String.class));
        C0652c.m8145a(getApplicationContext(), th, str);
    }

    public static void setPrimaryColor(int i) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("primaryColorValue").setType(Integer.TYPE).setValue(String.valueOf(i)));
        SettingsManager.getInstance().setPrimaryColor(i);
    }

    public static int getPrimaryColor() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return SettingsManager.getInstance().getPrimaryColor();
    }

    @Deprecated
    public static IBGColorTheme getColorTheme() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter[0]);
        switch (SettingsManager.getInstance().getTheme()) {
            case InstabugColorThemeDark:
                return IBGColorTheme.IBGColorThemeDark;
            case InstabugColorThemeLight:
                return IBGColorTheme.IBGColorThemeLight;
            default:
                return IBGColorTheme.IBGColorThemeLight;
        }
    }

    public static InstabugColorTheme getTheme() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return SettingsManager.getInstance().getTheme();
    }

    public static void setUserData(String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("userData").setType(String.class));
        if (C0645b.m8104a().m8113b(Feature.USER_DATA) == State.ENABLED) {
            SettingsManager.getInstance().setUserData(StringUtility.trimString(str));
        }
    }

    @Deprecated
    public static void setFileAttachment(Uri uri, String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("fileUri").setType(Uri.class), new Parameter().setName("fileNameWithExtension").setType(String.class));
        addFileAttachment(uri, str);
    }

    public static void addFileAttachment(Uri uri, String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("fileUri").setType(Uri.class), new Parameter().setName("fileNameWithExtension").setType(String.class));
        SettingsManager.getInstance().addExtraAttachmentFile(uri, str);
    }

    public static void addFileAttachment(byte[] bArr, String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("data").setType(Uri.class), new Parameter().setName("fileNameWithExtension").setType(String.class));
        SettingsManager.getInstance().addExtraAttachmentFile(bArr, str);
    }

    public static void clearFileAttachment() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter[0]);
        SettingsManager.getInstance().clearExtraAttachmentFiles();
    }

    public static void setPreSendingRunnable(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchLoggingApiUsage(new Parameter().setName("preSendingRunnable").setType(Runnable.class));
        C0650a.m8119a(runnable);
        C0652c.m8146a(runnable);
    }

    @Deprecated
    public static void setOnSdkInvokedCallback(OnSdkInvokedCallback onSdkInvokedCallback) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("onSdkInvokedCallback").setType(OnSdkInvokedCallback.class));
        SettingsManager.getInstance().setOnSdkInvokedCallback(onSdkInvokedCallback);
    }

    public static void setPreInvocation(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("preSdkInvocationRunnable").setType(Runnable.class));
        SettingsManager.getInstance().setPreInvocationRunnable(runnable);
    }

    public static void setOnSdkDismissedCallback(OnSdkDismissedCallback onSdkDismissedCallback) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("onSdkDismissedCallback").setType(OnSdkDismissedCallback.class));
        C0650a.m8116a(onSdkDismissedCallback);
        C0651b.m8131a(onSdkDismissedCallback);
        SettingsManager.getInstance().setOnSdkDismissedCallback(onSdkDismissedCallback);
    }

    public static void setNewMessageHandler(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0651b.m8132a(runnable);
    }

    public static String getUserData() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return SettingsManager.getInstance().getUserData();
    }

    public static String getUserEmail() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C0770a.m8344b();
    }

    public static String getAppToken() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return SettingsManager.getInstance().getAppToken();
    }

    @Deprecated
    public static void setUserEmail(String str) {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName(com.instabug.library.model.State.KEY_EMAIL).setType(String.class));
        C0770a.m8345b(str);
    }

    @Deprecated
    public static void setUsername(String str) {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("username").setType(String.class));
        C0770a.m8343a(str);
    }

    public static void identifyUser(String str, String str2) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("username").setType(String.class), new Parameter().setName(com.instabug.library.model.State.KEY_EMAIL));
        C0770a.m8342a(getApplicationContext(), str, str2);
    }

    public static void logoutUser() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0770a.m8340a();
    }

    public static void setState(InstabugState instabugState) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        INSTABUG_STATE = instabugState;
    }

    public static InstabugState getState() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return INSTABUG_STATE;
    }

    public static boolean isBuilt() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        if (INSTANCE == null || getState() == InstabugState.NOT_BUILT) {
            return false;
        }
        return true;
    }

    public static boolean isEnabled() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        if (C0645b.m8104a().m8112a(Feature.INSTABUG) && C0645b.m8104a().m8113b(Feature.INSTABUG) == State.ENABLED) {
            return true;
        }
        return false;
    }

    public static void enable() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        if (!isEnabled()) {
            C0645b.m8104a().m8111a(Feature.INSTABUG, true);
            C0645b.m8104a().m8110a(Feature.INSTABUG, State.ENABLED);
            C0645b.m8104a().m8109a(getApplicationContext());
            getInstance().delegate.m15339a();
        }
    }

    public static void disable() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        if (isEnabled()) {
            C0645b.m8104a().m8110a(Feature.INSTABUG, State.DISABLED);
            C0645b.m8104a().m8111a(Feature.INSTABUG, false);
            C0645b.m8104a().m8109a(getApplicationContext());
            C1341a c1341a = getInstance().delegate;
            InstabugSDKLogger.m8356d(c1341a, "Stopping Instabug SDK functionality");
            setState(InstabugState.DISABLED);
            InstabugSDKLogger.m8360v(c1341a, "Un-registering broadcasts");
            LocalBroadcastManager.m744a(c1341a.m15342c()).m746a(c1341a.f15440c);
            if (!(c1341a.f15438a == null || c1341a.f15438a.d())) {
                c1341a.f15438a.c();
            }
            InstabugSDKLogger.m8356d(c1341a, "Stopping Instabug SDK invocation listeners");
            C1381b.m15431c().m15439d();
            C0657a.m8157a();
            try {
                if (c1341a.f15439b != null && c1341a.f15439b.isShowing()) {
                    InstabugSDKLogger.m8360v(c1341a, "Dismissing instabug dialog");
                    c1341a.f15439b.dismiss();
                }
            } catch (Exception e) {
                InstabugSDKLogger.m8356d(c1341a, Log.getStackTraceString(e.getCause()));
            }
        }
    }

    @Deprecated
    public static void changeLocale(Locale locale) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName(com.instabug.library.model.State.KEY_LOCALE).setType(Locale.class).setValue(locale));
        SettingsManager.getInstance().setInstabugLocale(locale);
    }

    public static void setLocale(Locale locale) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName(com.instabug.library.model.State.KEY_LOCALE).setType(Locale.class).setValue(locale));
        SettingsManager.getInstance().setInstabugLocale(locale);
    }

    public static Locale getLocale(Context context) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("context").setType(Context.class));
        return SettingsManager.getInstance().getInstabugLocale(context);
    }

    public static int getUnreadMessagesCount() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C0651b.m8129a();
    }

    public static void dismiss() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        getInstance();
    }

    @Deprecated
    public static void setBugCategories(List<BugCategory> list) {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("bugCategories").setType(List.class));
        C0650a.m8120a((List) list);
    }

    @Deprecated
    public static void setReportCategories(List<ReportCategory> list) {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("reportCategories").setType(List.class));
        C0650a.m8124b((List) list);
    }

    public static void addTags(String... strArr) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        SettingsManager.getInstance().addTags(StringUtility.trimStrings(strArr));
    }

    public static ArrayList<String> getTags() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return SettingsManager.getInstance().getTags();
    }

    public static void resetTags() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        SettingsManager.getInstance().resetTags();
    }

    public static boolean isInstabugNotification(Bundle bundle) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(Bundle.class));
        return C0651b.m8136a(bundle);
    }

    public static boolean isInstabugNotification(Map<String, String> map) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(Map.class));
        return C0651b.m8137a((Map) map);
    }

    public static void showNotification(Bundle bundle) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(Bundle.class));
        C0651b.m8139b(bundle);
    }

    public static void showNotification(Map<String, String> map) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("data").setType(Map.class));
        C0651b.m8140b((Map) map);
    }

    public static void setChatNotificationEnabled(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("isChatNotificationEnable").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0651b.m8134a(z);
    }

    public static void setPushNotificationRegistrationToken(String str) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("token").setType(String.class));
        C0651b.m8133a(str);
    }

    public static void setCustomTextPlaceHolders(InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugCustomTextPlaceHolder").setType(InstabugCustomTextPlaceHolder.class));
        SettingsManager.getInstance().setCustomPlaceHolders(instabugCustomTextPlaceHolder);
    }

    @Deprecated
    public static void setAttachmentTypesEnabled(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("initialScreenshot").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)), new Parameter().setName("extraScreenshot").setType(Boolean.TYPE).setValue(Boolean.valueOf(z2)), new Parameter().setName("galleryImage").setType(Boolean.TYPE).setValue(Boolean.valueOf(z3)), new Parameter().setName("voiceNote").setType(Boolean.TYPE).setValue(Boolean.valueOf(z4)), new Parameter().setName("screenRecording").setType(Boolean.TYPE).setValue(Boolean.valueOf(z5)));
        setAttachmentTypesEnabled(z, z2, z3, z5);
    }

    public static void setAttachmentTypesEnabled(boolean z, boolean z2, boolean z3, boolean z4) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("initialScreenshot").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)), new Parameter().setName("extraScreenshot").setType(Boolean.TYPE).setValue(Boolean.valueOf(z2)), new Parameter().setName("galleryImage").setType(Boolean.TYPE).setValue(Boolean.valueOf(z3)), new Parameter().setName("screenRecording").setType(Boolean.TYPE).setValue(Boolean.valueOf(z4)));
        C0650a.m8122a(z, z2, z3, z4);
        C0651b.m8135a(z2, z3, z4);
    }

    @Deprecated
    public static void setCustomTextPlaceHolders(IBGCustomTextPlaceHolder iBGCustomTextPlaceHolder) {
        AnalyticsObserver.getInstance().catchDeprecatedApiUsage(new Parameter().setName("ibgCustomTextPlaceHolder").setType(IBGCustomTextPlaceHolder.class));
        InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder = new InstabugCustomTextPlaceHolder();
        instabugCustomTextPlaceHolder.setPlaceHoldersMap(iBGCustomTextPlaceHolder.getConvertedHashMap());
        setCustomTextPlaceHolders(instabugCustomTextPlaceHolder);
    }

    public static HashMap<String, String> getAllUserAttributes() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return UserAttributesCacheManager.getAll();
    }

    public static void setUserAttribute(String str, String str2) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("key").setType(String.class), new Parameter().setName("value").setType(String.class));
        UserAttributesCacheManager.putAttribute(str, StringUtility.trimString(str2));
    }

    public static String getUserAttribute(String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("key").setType(String.class));
        return UserAttributesCacheManager.getAttribute(str);
    }

    public static void removeUserAttribute(String str) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("key").setType(String.class));
        UserAttributesCacheManager.deleteAttribute(str);
    }

    public static void clearAllUserAttributes() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        UserAttributesCacheManager.deleteAll();
    }

    public static void logUserEvent(String str, UserEventParam... userEventParamArr) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("eventIdentifier").setType(String.class), new Parameter().setName("userEventParams").setType(UserEventParam.class));
        InstabugUserEventLogger.getInstance().logUserEvent(str, userEventParamArr);
    }

    public static boolean showValidSurvey() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C0653d.m8149a();
    }

    public static boolean hasValidSurveys() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C0653d.m8152b();
    }

    public static void setPreShowingSurveyRunnable(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0653d.m8147a(runnable);
    }

    public static void setAfterShowingSurveyRunnable(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0653d.m8151b(runnable);
    }

    public static Date getFirstRunAt() {
        return SettingsManager.getInstance().getFirstRunAt();
    }

    public static boolean isAppOnForeground() {
        return SettingsManager.getInstance().isAppOnForeground();
    }

    @Deprecated
    public static void setRequestedOrientation(int i) {
        SettingsManager.getInstance().setRequestedOrientation(i);
    }

    @Deprecated
    public static int getRequestedOrientation() {
        return OrientationUtils.getOrientation(SettingsManager.getInstance().getRequestedOrientation());
    }

    @Deprecated
    public static void resetRequestedOrientation() {
        SettingsManager.getInstance().resetRequestedOrientation();
    }

    public static void setShouldPlayConversationSounds(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySounds").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0651b.m8141b(z);
    }

    public static void setEnableSystemNotificationSound(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySound").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0651b.m8142c(z);
    }

    public static void setEnableInAppNotificationSound(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("shouldPlaySound").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0651b.m8143d(z);
    }

    public static void setPromptOptionsEnabled(boolean z, boolean z2, boolean z3) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("chat").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)), new Parameter().setName("bug").setType(Boolean.TYPE).setValue(Boolean.valueOf(z2)), new Parameter().setName("feedback").setType(Boolean.TYPE).setValue(Boolean.toString(z3)));
        C0731c c0731c = C1381b.m15431c().f15516a;
        if (z) {
            c0731c.f9781a[4] = true;
        } else {
            c0731c.f9781a[4] = false;
        }
        if (z2) {
            c0731c.f9781a[1] = true;
        } else {
            c0731c.f9781a[1] = false;
        }
        if (z3) {
            c0731c.f9781a[2] = true;
        } else {
            c0731c.f9781a[2] = false;
        }
        if ((z && (z2 || z3)) || (z2 && z3)) {
            c0731c.f9782b = 0;
        } else if (z) {
            c0731c.f9782b = 4;
        } else if (z2) {
            c0731c.f9782b = 1;
        } else {
            if (z3) {
                c0731c.f9782b = 2;
            }
        }
    }

    public static void setShakingThreshold(int i) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("threshold").setType(Integer.TYPE).setValue(Integer.toString(i)));
        C1381b.m15431c().f15516a.m8286b(i);
    }

    public static void setSuccessDialogEnabled(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("enabled").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0650a.m8128e(z);
    }

    public static void setIntroMessageEnabled(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("enabled").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        SettingsManager.getInstance().setIntroMessageEnabled(z);
    }

    public static void setCommentFieldRequired(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("commentFieldRequired").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0650a.m8126c(z);
    }

    public static void setEmailFieldVisibility(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("emailFieldVisibility").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0650a.m8127d(z);
    }

    public static void setEmailFieldRequired(boolean z) {
        C0650a.m8125b(z);
    }

    public static void setWillSkipScreenshotAnnotation(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("willSkipInitialScreenshotAnnotating").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0650a.m8121a(z);
        C0651b.m8144e(z);
    }

    public static void setTheme(InstabugColorTheme instabugColorTheme) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugTheme").setType(InstabugColorTheme.class).setValue(instabugColorTheme));
        SettingsManager.getInstance().setTheme(instabugColorTheme);
        switch (instabugColorTheme) {
            case InstabugColorThemeDark:
                SettingsManager.getInstance().setPrimaryColor(-9580554);
                SettingsManager.getInstance().setStatusBarColor(-16119286);
                return;
            case InstabugColorThemeLight:
                SettingsManager.getInstance().setPrimaryColor(-15893761);
                SettingsManager.getInstance().setStatusBarColor(-3815737);
                break;
            default:
                break;
        }
    }

    public static boolean showSurvey(String str) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C0653d.m8150a(str);
    }

    public static boolean hasRespondToSurvey(String str) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C0653d.m8153b(str);
    }

    public static void setFloatingButtonEdge(InstabugFloatingButtonEdge instabugFloatingButtonEdge) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugFloatingButtonEdge").setType(InstabugFloatingButtonEdge.class).setValue(instabugFloatingButtonEdge));
        C1381b.m15431c().f15516a.m8285a(instabugFloatingButtonEdge);
    }

    public static void setFloatingButtonOffsetFromTop(int i) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("floatingButtonOffsetFromTop").setType(Integer.TYPE).setValue(Integer.toString(i)));
        C1381b.m15431c().f15516a.m8284a(i);
    }

    public static void setVideoRecordingFloatingButtonCorner(InstabugVideoRecordingButtonCorner instabugVideoRecordingButtonCorner) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("instabugViewRecordingButtonCorner").setType(InstabugVideoRecordingButtonCorner.class).setValue(instabugVideoRecordingButtonCorner));
        C1381b.m15431c().f15516a.f9783c = instabugVideoRecordingButtonCorner;
    }

    @Deprecated
    public static void addExtraReportField(CharSequence charSequence, boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("fieldHint").setType(CharSequence.class).setValue(charSequence), new Parameter().setName("required").setType(Boolean.TYPE).setValue(Boolean.valueOf(z)));
        C0650a.m8118a(charSequence, z);
    }

    public static void clearExtraReportFields() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        C0650a.m8123b();
    }

    public static void setNotificationIcon(int i) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("notificationIcon").setType(Integer.TYPE));
        C0651b.m8130a(i);
    }

    public static void setViewHierarchyState(State state) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
        C0645b.m8104a().m8110a(Feature.VIEW_HIERARCHY, state);
    }

    public static void setExtendedBugReportState(ExtendedBugReport.State state) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(ExtendedBugReport.State.class).setValue(state));
        C0650a.m8117a(state);
    }

    public static void setCrashReportingState(State state) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("state").setType(State.class).setValue(state));
        C0645b.m8104a().m8110a(Feature.CRASH_REPORTING, state);
    }

    public static void setAutoScreenRecordingEnabled(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("setAutoScreenRecordingEnabled").setType(Boolean.class).setValue(String.valueOf(z)));
        SettingsManager.getInstance().setAutoScreenRecordingEnabled(z);
        InternalAutoScreenRecorderHelper.getInstance().start();
    }

    public static void setAutoScreenRecordingMaxDuration(int i) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("setAutoScreenRecordingMaxDuration").setType(Boolean.class).setValue(String.valueOf(i)));
        SettingsManager.getInstance().setAutoScreenRecordingMaxDuration(i);
    }
}
