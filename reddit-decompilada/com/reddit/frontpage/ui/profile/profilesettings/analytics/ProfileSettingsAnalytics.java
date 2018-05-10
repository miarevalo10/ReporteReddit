package com.reddit.frontpage.ui.profile.profilesettings.analytics;

import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ProfileSettingsEventBuilder;
import com.reddit.frontpage.util.SessionUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0003\u0019\u001a\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001c"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalytics;", "Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalyticsContract;", "()V", "avatarRemoved", "", "avatarUploaded", "avatarUrl", "", "bannerRemoved", "bannerUploaded", "bannerUrl", "closeButtonClicked", "profileSettingsViewed", "saveButtonClicked", "displayName", "about", "contentVisible", "", "communitiesVisible", "configEvent", "Lcom/reddit/frontpage/commons/analytics/builders/ProfileSettingsEventBuilder;", "action", "Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalytics$Action;", "noun", "Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalytics$Noun;", "Action", "Companion", "Noun", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProfileSettingsAnalytics.kt */
public final class ProfileSettingsAnalytics implements ProfileSettingsAnalyticsContract {
    public static final Companion f29242a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalytics$Action;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VIEW", "CLICK", "UPLOAD", "REMOVE", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProfileSettingsAnalytics.kt */
    public enum Action {
        ;
        
        final String f21535e;

        private Action(String str) {
            Intrinsics.m26847b(str, "value");
            this.f21535e = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalytics$Companion;", "", "()V", "SOURCE", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProfileSettingsAnalytics.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/analytics/ProfileSettingsAnalytics$Noun;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SETTINGS_PAGE", "AVATAR", "COVER", "SAVE_SETTINGS", "CLOSE_SETTINGS", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProfileSettingsAnalytics.kt */
    public enum Noun {
        ;
        
        final String f21542f;

        private Noun(String str) {
            Intrinsics.m26847b(str, "value");
            this.f21542f = str;
        }
    }

    private static ProfileSettingsEventBuilder m30349a(ProfileSettingsEventBuilder profileSettingsEventBuilder, Action action, Noun noun) {
        profileSettingsEventBuilder.m21888a("profile_settings");
        profileSettingsEventBuilder.m21892b(action.f21535e);
        profileSettingsEventBuilder.m21895c(noun.f21542f);
        Object d = SessionUtil.m23898d();
        Intrinsics.m26843a(d, "SessionUtil.getTypedCurrentSessionAccountID()");
        Intrinsics.m26847b(d, "id");
        profileSettingsEventBuilder.f27459a.id(d);
        d = SessionUtil.m23899e();
        Intrinsics.m26843a(d, "SessionUtil.getCurrentUsername()");
        Intrinsics.m26847b(d, "name");
        profileSettingsEventBuilder.f27459a.name(d);
        return profileSettingsEventBuilder;
    }

    public final void mo5010a() {
        Object u = AppAnalytics.m21884u();
        Intrinsics.m26843a(u, "AppAnalytics.newProfileSettingsEvent()");
        m30349a(u, Action.f21530a, Noun.f21536a).m21891a();
    }

    public final void mo5011a(String str) {
        Intrinsics.m26847b(str, "avatarUrl");
        Object u = AppAnalytics.m21884u();
        Intrinsics.m26843a(u, "AppAnalytics.newProfileSettingsEvent()");
        ProfileSettingsEventBuilder a = m30349a(u, Action.f21532c, Noun.f21537b);
        Intrinsics.m26847b(str, "avatarUrl");
        a.f27459a.avatar_url(str);
        a.m21891a();
    }

    public final void mo5013b() {
        Object u = AppAnalytics.m21884u();
        Intrinsics.m26843a(u, "AppAnalytics.newProfileSettingsEvent()");
        m30349a(u, Action.f21533d, Noun.f21537b).m21891a();
    }

    public final void mo5014b(String str) {
        Intrinsics.m26847b(str, "bannerUrl");
        Object u = AppAnalytics.m21884u();
        Intrinsics.m26843a(u, "AppAnalytics.newProfileSettingsEvent()");
        ProfileSettingsEventBuilder a = m30349a(u, Action.f21532c, Noun.f21538c);
        Intrinsics.m26847b(str, "coverUrl");
        a.f27459a.cover_url(str);
        a.m21891a();
    }

    public final void mo5015c() {
        Object u = AppAnalytics.m21884u();
        Intrinsics.m26843a(u, "AppAnalytics.newProfileSettingsEvent()");
        m30349a(u, Action.f21533d, Noun.f21538c).m21891a();
    }

    public final void mo5012a(String str, String str2, boolean z, boolean z2) {
        Intrinsics.m26847b(str, "displayName");
        Intrinsics.m26847b(str2, "about");
        Object u = AppAnalytics.m21884u();
        Intrinsics.m26843a(u, "AppAnalytics.newProfileSettingsEvent()");
        ProfileSettingsEventBuilder a = m30349a(u, Action.f21531b, Noun.f21539d);
        Intrinsics.m26847b(str, "displayName");
        a.f27459a.display_name(str);
        Intrinsics.m26847b(str2, "about");
        a.f27459a.about(str2);
        a.f27459a.content_visible(Boolean.valueOf(z));
        a.f27459a.communities_visible(Boolean.valueOf(z2));
        a.m21891a();
    }

    public final void mo5016d() {
        Object u = AppAnalytics.m21884u();
        Intrinsics.m26843a(u, "AppAnalytics.newProfileSettingsEvent()");
        m30349a(u, Action.f21531b, Noun.f21540e).m21891a();
    }
}
