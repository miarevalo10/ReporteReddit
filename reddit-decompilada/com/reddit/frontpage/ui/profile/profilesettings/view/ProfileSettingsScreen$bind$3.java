package com.reddit.frontpage.ui.profile.profilesettings.view;

import android.view.View;
import com.reddit.frontpage.ui.profile.profilesettings.model.ImageActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: ProfileSettingsScreen.kt */
final class ProfileSettingsScreen$bind$3 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ProfileSettingsScreen f37354a;

    ProfileSettingsScreen$bind$3(ProfileSettingsScreen profileSettingsScreen) {
        this.f37354a = profileSettingsScreen;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ImageActions imageActions;
        obj = this.f37354a.m39454w();
        if (obj.f34414a) {
            imageActions = ImageActions.f21557a;
        } else {
            imageActions = ImageActions.f21558b;
        }
        obj.f34416c.mo7227a(imageActions);
        return Unit.f25273a;
    }
}
