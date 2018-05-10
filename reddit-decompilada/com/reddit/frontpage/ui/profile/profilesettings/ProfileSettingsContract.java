package com.reddit.frontpage.ui.profile.profilesettings;

import com.reddit.frontpage.ui.profile.profilesettings.model.AccountPresentationModel;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract;", "", "Parameters", "Presenter", "View", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ProfileSettingsContract.kt */
public interface ProfileSettingsContract {

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$Parameters;", "", "userSubredditDisplayName", "", "(Ljava/lang/String;)V", "getUserSubredditDisplayName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProfileSettingsContract.kt */
    public static final class Parameters {
        public final String f21529a;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Parameters) {
                    if (Intrinsics.m26845a(this.f21529a, ((Parameters) obj).f21529a)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f21529a;
            return str != null ? str.hashCode() : 0;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Parameters(userSubredditDisplayName=");
            stringBuilder.append(this.f21529a);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public Parameters(String str) {
            Intrinsics.m26847b(str, "userSubredditDisplayName");
            this.f21529a = str;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/ui/profile/profilesettings/ProfileSettingsContract$View;", "", "bind", "", "account", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/AccountPresentationModel;", "closeScreen", "hideAvatarUploading", "hideBannerUploading", "notifyLoadAccountError", "notifyRemoveBannerError", "notifyRestoreAvatarError", "notifySaveError", "notifyUnableLoadImageError", "setAvatar", "url", "", "setBanner", "showAvatarUploading", "showBannerUploading", "showProfileImageActions", "imageActions", "Lcom/reddit/frontpage/ui/profile/profilesettings/model/ImageActions;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ProfileSettingsContract.kt */
    public interface View {
        void mo7225a();

        void mo7226a(AccountPresentationModel accountPresentationModel);

        void mo7227a(ImageActions imageActions);

        void mo7228a(String str);

        void aj_();

        void ak_();

        void al_();

        void mo7232b();

        void mo7233b(String str);

        void mo7234c();

        void mo7235d();

        void mo7236e();

        void mo7237f();

        void mo7238i();
    }
}
