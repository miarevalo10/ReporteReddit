package com.reddit.frontpage.ui.profile.profilesettings.view;

import android.view.View;
import android.widget.ProgressBar;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ProgressBar;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsScreen.kt */
final class ProfileSettingsScreen$avatarPreloader$2 extends Lambda implements Function0<ProgressBar> {
    final /* synthetic */ ProfileSettingsScreen f37345a;

    ProfileSettingsScreen$avatarPreloader$2(ProfileSettingsScreen profileSettingsScreen) {
        this.f37345a = profileSettingsScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View c = this.f37345a.K;
        if (c == null) {
            Intrinsics.m26842a();
        }
        return (ProgressBar) c.findViewById(C1761R.id.avatar_preloader);
    }
}
